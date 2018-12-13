package app.ubie.kotlingraphqlsample.presentation.queryresolver

import app.ubie.kotlingraphqlsample.service.DrugService
import app.ubie.kotlingraphqlsample.domain.Drug
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class DrugQueryResolver(val drugService: DrugService) : GraphQLQueryResolver {
    fun drugs(yjCode: String): List<Drug> = drugService.getDrugs(yjCode)
}