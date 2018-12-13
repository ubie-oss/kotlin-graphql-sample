package app.ubie.kotlingraphqlsample.dao

import app.ubie.kotlingraphqlsample.domain.KinkiDrug
import app.ubie.kotlingraphqlsample.domain.KinkiDrugRepository
import org.springframework.stereotype.Component

@Component
class KinkiDrugDao(private val repository: KinkiDrugRepository) {
    fun findKinkiDrugsByYjCode(yjCode: String): List<KinkiDrug> = repository.findKinkiDrugsByYjCode(yjCode)
}