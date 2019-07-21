package app.ubie.kotlingraphqlsample.domain

data class Drug(
    val id: String,
    val name: String,
    val description: String?,
    val yjCode: String
)