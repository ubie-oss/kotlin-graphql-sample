package app.ubie.kotlingraphqlsample.resolver

import app.ubie.kotlingraphqlsample.dao.DiseaseKinkiDrugDao
import app.ubie.kotlingraphqlsample.dao.DrugDao
import app.ubie.kotlingraphqlsample.dao.DiseaseDao
import app.ubie.kotlingraphqlsample.dao.KinkiDrugDao
import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.domain.Drug
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class DrugResolver(
    private val kinkiDrugDao: KinkiDrugDao,
    private val diseseKinkiDrugDao: DiseaseKinkiDrugDao,
    private val drugDao: DrugDao,
    private val diseaseDao: DiseaseDao
) : GraphQLResolver<Drug> {

    fun getKinkiDrugs(drug: Drug): List<Drug> {
        val kinkiDrugs = kinkiDrugDao.findKinkiDrugsByYjCode(drug.yjCode)
        return drugDao.getDrugs(kinkiDrugs.map { it.kinkiYjCode })
    }

    fun getKinkiDiseases(drug: Drug): List<Disease> {
        val kinkiDrugs = diseseKinkiDrugDao.findKinkiDrugsByYjCode(drug.yjCode)
        return diseaseDao.getDiseases(kinkiDrugs.map { it.icd })
    }
}