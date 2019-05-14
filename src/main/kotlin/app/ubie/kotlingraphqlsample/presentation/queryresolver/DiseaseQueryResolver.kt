package app.ubie.kotlingraphqlsample.presentation.queryresolver

import app.ubie.kotlingraphqlsample.service.DiseaseService
import app.ubie.kotlingraphqlsample.domain.Disease
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class DiseaseQueryResolver(private val service: DiseaseService) : GraphQLQueryResolver {
    @Suppress("unused")
    fun diseases(icd: String): List<Disease> {
        if (icd.isEmpty()) throw IllegalArgumentException("icd must not be empty")
        return service.getDiseases(icd)
    }

    fun diseasesByName(name: String): List<Disease> {
        if (name.isEmpty()) throw IllegalArgumentException("name must not be empty")
        return service.getDiseasesByName(name)
    }
}