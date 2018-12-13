package app.ubie.kotlingraphqlsample.infrastructure.jdbc

import app.ubie.kotlingraphqlsample.domain.KinkiDrug
import app.ubie.kotlingraphqlsample.domain.KinkiDrugRepository
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class JdbcKinkiDrugRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) : KinkiDrugRepository {

    private val rowMapper: RowMapper<KinkiDrug> = RowMapper { rs, _ ->
        KinkiDrug(
                yjCode = rs.getString("yj_code"),
                kinkiYjCode = rs.getString("kinki_yj_code")
        )
    }

    override fun findKinkiDrugsByYjCode(yjCode: String): List<KinkiDrug> {
        if (yjCode.isEmpty()) return emptyList()
        //language=SQL
        return jdbcTemplate.query(
                """
                SELECT
                  yj_code,
                  kinki_yj_code
                FROM
                  kinki_drug
                WHERE
                  yj_code = :yj_code
                """.trimIndent(), mapOf("yj_code" to yjCode), rowMapper
        )
    }
}