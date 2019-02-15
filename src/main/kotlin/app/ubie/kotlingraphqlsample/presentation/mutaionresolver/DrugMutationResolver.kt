package app.ubie.kotlingraphqlsample.presentation.mutaionresolver

import app.ubie.kotlingraphqlsample.service.DrugService
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import graphql.servlet.GraphQLContext
import graphql.servlet.GraphQLServletListener
import org.springframework.stereotype.Component

@Component
class DrugMutationResolver(private val service: DrugService) : GraphQLMutationResolver {
    fun updateDrugPrice(yjCode: String, newPrice: Int) {
        service.updatePrice(yjCode, newPrice)
    }
}