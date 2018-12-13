package app.ubie.kotlingraphqlsample.domain

interface DiseaseKinkiDrugRepository {
    fun findKinkiDrugsByIcd(icd: String): List<DiseaseKinkiDrug>
    fun findKinkiDrugsByYjCode(yjCode: String): List<DiseaseKinkiDrug>
}