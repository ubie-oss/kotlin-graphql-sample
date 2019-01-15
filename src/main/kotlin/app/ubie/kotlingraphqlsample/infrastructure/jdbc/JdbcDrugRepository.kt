package app.ubie.kotlingraphqlsample.infrastructure.jdbc

import app.ubie.kotlingraphqlsample.domain.Drug
import app.ubie.kotlingraphqlsample.domain.DrugRepository
import brave.Tracing
import brave.scopedSpan
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class JdbcDrugRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) : DrugRepository {

    private val rowMapper: RowMapper<Drug> = RowMapper { rs, _ ->
        Drug(
                name = rs.getString("name"),
                yjCode = rs.getString("yj_code")
        )
    }

    override fun getDrugs(yjCode: String): List<Drug> {
        return Tracing.currentTracer().scopedSpan("getDrugs(yjCode)") {
            if (yjCode.isBlank()) return emptyList()
            //language=SQL
            jdbcTemplate.query(
                """
                SELECT
                  name,
                  yj_code
                FROM
                  drug
                WHERE
                  yj_code = :yj_code
                """.trimIndent(), mapOf("yj_code" to yjCode), rowMapper
            )
        }
    }

    override fun getDrugs(yjCodes: List<String>): List<Drug> {
        return Tracing.currentTracer().scopedSpan("getDrugs(yjCodes)") {
            val target = yjCodes.filterNot { it.isEmpty() }
            if (target.isEmpty()) return emptyList()
            //language=SQL
            jdbcTemplate.query(
                """
                SELECT
                  name,
                  yj_code
                FROM
                  drug
                WHERE
                  yj_code IN (:yj_codes)
                """.trimIndent(), mapOf("yj_codes" to yjCodes), rowMapper
            )
        }
    }
}