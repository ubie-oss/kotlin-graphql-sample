package app.ubie.kotlingraphqlsample.infrastructure.jdbc

import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.domain.DiseaseRepository
import brave.Tracing
import brave.scopedSpan
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Component

@Component
class JdbcDiseaseRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) : DiseaseRepository {
    private val rowMapper: RowMapper<Disease> = RowMapper { rs, _ ->
        Disease(
                icd = rs.getString("icd"),
                name = rs.getString("name")
        )
    }

    override fun getDiseases(icd: String): List<Disease> {
        return Tracing.currentTracer().scopedSpan("getDiseases(icd)") {
            if (icd.isBlank()) return emptyList()
            //language=SQL
            jdbcTemplate.query(
                """
                SELECT
                  icd,
                  name
                FROM
                  disease
                WHERE
                  icd = :icd
                """.trimIndent(), mapOf("icd" to icd), rowMapper
            )
        }
    }

    override fun getDiseases(icds: List<String>): List<Disease> {
        return Tracing.currentTracer().scopedSpan("getDiseases(icds)") {
            val targets = icds.filterNot { it.isBlank() }
            if (targets.isEmpty()) return emptyList()
            //language=SQL
            jdbcTemplate.query(
                """
                SELECT
                  icd,
                  name
                FROM
                  disease
                WHERE
                  icd IN (:icd)
                """.trimIndent(), mapOf("icd" to targets), rowMapper
            )
        }
    }
}
