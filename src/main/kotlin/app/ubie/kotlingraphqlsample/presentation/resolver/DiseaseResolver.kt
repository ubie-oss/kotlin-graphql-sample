package app.ubie.kotlingraphqlsample.presentation.resolver

import app.ubie.kotlingraphqlsample.service.DiseaseKinkiDrugService
import app.ubie.kotlingraphqlsample.service.DrugService
import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.domain.Drug
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class DiseaseResolver(private val service: DiseaseKinkiDrugService, private val drugService: DrugService) : GraphQLResolver<Disease> {

    fun getKinkiDrugs(disease: Disease): List<Drug> {
        val kinkiDrugs = service.findKinkiDrugsByIcd(disease.icd)
        return drugService.getDrugs(kinkiDrugs.map { it.yjCode })
    }
}