package app.ubie.kotlingraphqlsample.dao

import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.domain.DiseaseRepository
import org.springframework.stereotype.Component

@Component
class DiseaseDao(private val repository: DiseaseRepository) {
    fun getDiseases(icd: String): List<Disease> = repository.getDiseases(icd)
    fun getDiseases(icds: List<String>): List<Disease> = repository.getDiseases(icds)
}