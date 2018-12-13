package app.ubie.kotlingraphqlsample.presentation.resolver

import app.ubie.kotlingraphqlsample.service.DiseaseKinkiDrugService
import app.ubie.kotlingraphqlsample.service.DrugService
import app.ubie.kotlingraphqlsample.service.DiseaseService
import app.ubie.kotlingraphqlsample.service.KinkiDrugService
import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.domain.Drug
import com.coxautodev.graphql.tools.GraphQLResolver
import org.springframework.stereotype.Component

@Component
class DrugResolver(
    private val kinkiDrugService: KinkiDrugService,
    private val diseseKinkiDrugService: DiseaseKinkiDrugService,
    private val drugService: DrugService,
    private val diseaseService: DiseaseService
) : GraphQLResolver<Drug> {

    fun getKinkiDrugs(drug: Drug): List<Drug> {
        val kinkiDrugs = kinkiDrugService.findKinkiDrugsByYjCode(drug.yjCode)
        return drugService.getDrugs(kinkiDrugs.map { it.kinkiYjCode })
    }

    fun getKinkiDiseases(drug: Drug): List<Disease> {
        val kinkiDrugs = diseseKinkiDrugService.findKinkiDrugsByYjCode(drug.yjCode)
        return diseaseService.getDiseases(kinkiDrugs.map { it.icd })
    }
}