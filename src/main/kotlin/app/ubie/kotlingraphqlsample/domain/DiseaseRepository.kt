package app.ubie.kotlingraphqlsample.domain

interface DiseaseRepository {
    fun getDiseases(icd: String): List<Disease>
    fun getDiseases(icds: List<String>): List<Disease>
}