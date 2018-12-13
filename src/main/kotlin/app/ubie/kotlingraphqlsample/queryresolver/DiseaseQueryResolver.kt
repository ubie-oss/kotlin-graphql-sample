package app.ubie.kotlingraphqlsample.queryresolver

import app.ubie.kotlingraphqlsample.dao.DiseaseDao
import app.ubie.kotlingraphqlsample.domain.Disease
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class DiseaseQueryResolver(private val dao: DiseaseDao) : GraphQLQueryResolver {
    fun diseases(icd: String): List<Disease> = dao.getDiseases(icd)
}