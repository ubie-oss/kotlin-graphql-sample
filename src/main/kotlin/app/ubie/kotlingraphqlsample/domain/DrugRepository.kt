package app.ubie.kotlingraphqlsample.domain

interface DrugRepository {
    fun getDrugs(yjCode: String): List<Drug>
    fun getDrugs(yjCodes: List<String>): List<Drug>

    fun getDrugsByName(name: String): List<Drug>
}