package app.ubie.kotlingraphqlsample.resolver

import app.ubie.kotlingraphqlsample.dao.DiseaseKinkiDrugDao
import app.ubie.kotlingraphqlsample.dao.DrugDao
import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.domain.Drug
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class DiseaseResolver(private val dao: DiseaseKinkiDrugDao, private val drugDao: DrugDao) : GraphQLResolver<Disease> {

    fun getKinkiDrugs(disease: Disease): List<Drug> {
        val kinkiDrugs = dao.findKinkiDrugsByIcd(disease.icd)
        return drugDao.getDrugs(kinkiDrugs.map { it.yjCode })
    }
}