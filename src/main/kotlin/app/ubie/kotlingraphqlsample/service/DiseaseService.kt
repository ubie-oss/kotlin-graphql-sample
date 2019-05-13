package app.ubie.kotlingraphqlsample.service

import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.domain.DiseaseRepository
import org.springframework.stereotype.Service

@Service
class DiseaseService(private val repository: DiseaseRepository) {
    fun getDiseases(icd: String): List<Disease> = repository.getDiseases(icd)
    fun getDiseases(icds: List<String>): List<Disease> = repository.getDiseases(icds)

    fun getDiseasesByName(name: String): List<Disease> = repository.getDiseasesByName(name)

}