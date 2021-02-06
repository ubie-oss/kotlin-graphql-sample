package app.ubie.kotlingraphqlsample.domain

interface DrugRepository {
    fun getDrugs(yjCode: String): List<Drug>
    fun getDrugs(yjCodes: List<String>): List<Drug>
    fun getDrug(id: String): Drug?
}