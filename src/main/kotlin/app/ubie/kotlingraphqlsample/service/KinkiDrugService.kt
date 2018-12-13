package app.ubie.kotlingraphqlsample.service

import app.ubie.kotlingraphqlsample.domain.KinkiDrug
import app.ubie.kotlingraphqlsample.domain.KinkiDrugRepository
import org.springframework.stereotype.Service

@Service
class KinkiDrugService(private val repository: KinkiDrugRepository) {
    fun findKinkiDrugsByYjCode(yjCode: String): List<KinkiDrug> = repository.findKinkiDrugsByYjCode(yjCode)
}