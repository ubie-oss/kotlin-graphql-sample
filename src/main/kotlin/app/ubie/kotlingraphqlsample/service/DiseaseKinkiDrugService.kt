package app.ubie.kotlingraphqlsample.service

import app.ubie.kotlingraphqlsample.domain.DiseaseKinkiDrug
import app.ubie.kotlingraphqlsample.domain.DiseaseKinkiDrugRepository
import org.springframework.stereotype.Service

@Service
class DiseaseKinkiDrugService(private val repository: DiseaseKinkiDrugRepository) {
    fun findKinkiDrugsByYjCode(yjCode: String): List<DiseaseKinkiDrug> = repository.findKinkiDrugsByYjCode(yjCode)

    fun findKinkiDrugsByIcd(icd: String): List<DiseaseKinkiDrug> = repository.findKinkiDrugsByIcd(icd)
}