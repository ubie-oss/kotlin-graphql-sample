package app.ubie.kotlingraphqlsample.domain

interface KinkiDrugRepository {
    fun findKinkiDrugsByYjCode(yjCode: String): List<KinkiDrug>
}