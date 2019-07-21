package app.ubie.kotlingraphqlsample.infrastructure.jdbc

import app.ubie.kotlingraphqlsample.domain.Drug
import app.ubie.kotlingraphqlsample.domain.DrugRepository
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
class JdbcDrugRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) : DrugRepository {

    private val rowMapper: RowMapper<Drug> = RowMapper { rs, _ ->
        Drug(
                id = rs.getString("id"),
                name = rs.getString("name"),
                description = rs.getString("description"),
                yjCode = rs.getString("yj_code")
        )
    }

    override fun getDrugs(yjCode: String): List<Drug> {
        if (yjCode.isBlank()) return emptyList()
        //language=SQL
        return jdbcTemplate.query(
                """
                SELECT
                  id,
                  name,
                  description,
                  yj_code
                FROM
                  drug
                WHERE
                  yj_code = :yj_code
                """.trimIndent(), mapOf("yj_code" to yjCode), rowMapper
        )
    }

    override fun getDrugs(yjCodes: List<String>): List<Drug> {
        val target = yjCodes.filterNot { it.isEmpty() }
        if (target.isEmpty()) return emptyList()
        //language=SQL
        return jdbcTemplate.query(
                """
                SELECT
                  id,
                  name,
                  description,
                  yj_code
                FROM
                  drug
                WHERE
                  yj_code IN (:yj_codes)
                """.trimIndent(), mapOf("yj_codes" to yjCodes), rowMapper
        )
    }

    override fun getDrug(id: String): Drug? {
        if (id.isEmpty()) return null
        //language=SQL
        return jdbcTemplate.query(
            """
                SELECT
                  id,
                  name,
                  description,
                  yj_code
                FROM
                  drug
                WHERE
                  id = :id
                """.trimIndent(), mapOf("id" to UUID.fromString(id)), rowMapper
        ).firstOrNull()
    }
}