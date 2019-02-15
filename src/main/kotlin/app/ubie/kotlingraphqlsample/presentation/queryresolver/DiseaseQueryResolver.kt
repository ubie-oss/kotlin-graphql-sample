package app.ubie.kotlingraphqlsample.presentation.queryresolver

import app.ubie.kotlingraphqlsample.service.DiseaseService
import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.presentation.GraphQLUtil
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import graphql.servlet.GraphQLContext
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class DiseaseQueryResolver(private val service: DiseaseService) : GraphQLQueryResolver {

    private val log = LoggerFactory.getLogger(DiseaseQueryResolver::class.java)

    fun diseases(icd: String, dataFetchingEnvironment: DataFetchingEnvironment): List<Disease> {
        val context = dataFetchingEnvironment.getContext<GraphQLContext>()
        val authContext = context as? GraphQLUtil.UbieAuthContext

        log.error(authContext?.token)

        return service.getDiseases(icd)
    }
}