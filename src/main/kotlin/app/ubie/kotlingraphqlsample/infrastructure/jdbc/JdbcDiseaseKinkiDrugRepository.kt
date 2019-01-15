package app.ubie.kotlingraphqlsample.infrastructure.jdbc

import app.ubie.kotlingraphqlsample.domain.DiseaseKinkiDrug
import app.ubie.kotlingraphqlsample.domain.DiseaseKinkiDrugRepository
import brave.Tracing
import brave.scopedSpan
import org.springframework.jdbc.core.RowMapper
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate
import org.springframework.stereotype.Repository

@Repository
class JdbcDiseaseKinkiDrugRepository(private val jdbcTemplate: NamedParameterJdbcTemplate) : DiseaseKinkiDrugRepository {

    private val rowMapper: RowMapper<DiseaseKinkiDrug> = RowMapper { rs, _ ->
        DiseaseKinkiDrug(
                yjCode = rs.getString("yj_code"),
                icd = rs.getString("icd")
        )
    }

    override fun findKinkiDrugsByIcd(icd: String): List<DiseaseKinkiDrug> {
        return Tracing.currentTracer().scopedSpan("findKinkiDrugsByIcd") {
            if (icd.isBlank()) return emptyList()
            jdbcTemplate.query(
                //language=SQL
                """
                SELECT
                  yj_code,
                  icd
                FROM
                  disease_kinki_drug
                WHERE
                  icd = :icd
                """.trimIndent(), mapOf("icd" to icd), rowMapper
            )
        }
    }

    override fun findKinkiDrugsByYjCode(yjCode: String): List<DiseaseKinkiDrug> {
        return Tracing.currentTracer().scopedSpan("findKinkiDrugsByYjCode") {
            if (yjCode.isBlank()) return emptyList()
            jdbcTemplate.query(
                //language=SQL
                """
                SELECT
                  yj_code,
                  icd
                FROM
                  disease_kinki_drug
                WHERE
                  yj_code = :yj_code
                """.trimIndent(), mapOf("yj_code" to yjCode), rowMapper
            )
        }
    }
}