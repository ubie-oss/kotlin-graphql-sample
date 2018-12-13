package app.ubie.kotlingraphqlsample.dao

import app.ubie.kotlingraphqlsample.domain.Drug
import app.ubie.kotlingraphqlsample.domain.DrugRepository
import org.springframework.stereotype.Component

@Component
class DrugDao(private val repository: DrugRepository) {
    fun getDrugs(yjCode: String): List<Drug> = repository.getDrugs(yjCode)
    fun getDrugs(yjCodes: List<String>): List<Drug> = repository.getDrugs(yjCodes)
}