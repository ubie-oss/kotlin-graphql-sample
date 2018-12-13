package app.ubie.kotlingraphqlsample.queryresolver

import app.ubie.kotlingraphqlsample.dao.DrugDao
import app.ubie.kotlingraphqlsample.domain.Drug
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.stereotype.Component

@Component
class DrugQueryResolver(val drugDao: DrugDao) : GraphQLQueryResolver {
    fun drugs(yjCode: String): List<Drug> = drugDao.getDrugs(yjCode)
}