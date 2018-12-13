package app.ubie.kotlingraphqlsample.presentation.queryresolver

import app.ubie.kotlingraphqlsample.service.DiseaseService
import app.ubie.kotlingraphqlsample.domain.Disease
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class DiseaseQueryResolver(private val service: DiseaseService) : GraphQLQueryResolver {
    fun diseases(icd: String): List<Disease> = service.getDiseases(icd)
}