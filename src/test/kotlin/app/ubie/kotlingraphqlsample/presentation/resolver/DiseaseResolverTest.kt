package app.ubie.kotlingraphqlsample.presentation.resolver

import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.domain.DiseaseKinkiDrug
import app.ubie.kotlingraphqlsample.domain.Drug
import app.ubie.kotlingraphqlsample.service.DiseaseKinkiDrugService
import app.ubie.kotlingraphqlsample.service.DrugService
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DiseaseResolverTest {
    private val service: DiseaseKinkiDrugService = mockk()
    private val drugService: DrugService = mockk()

    private val resolver: DiseaseResolver = DiseaseResolver(service, drugService)

    @Nested
    inner class getKinkiDrugs {
        @Test
        fun `should get kinki drugs`() {
            val disease: Disease = mockk()
            every { disease.icd } returns "icd"
            val kinkiDrugs: DiseaseKinkiDrug = mockk()
            every { kinkiDrugs.yjCode } returns "yjCode"
            val icdSlot = slot<String>()
            every { service.findKinkiDrugsByIcd(capture(icdSlot)) } returns listOf(kinkiDrugs)
            val result = mockk<List<Drug>>()
            val yjCodesSlot = slot<List<String>>()
            every { drugService.getDrugs(capture(yjCodesSlot)) } returns result

            val got = resolver.getKinkiDrugs(disease)

            Assertions.assertThat(got).isEqualTo(result)
            Assertions.assertThat(icdSlot.captured).isEqualTo("icd")
            Assertions.assertThat(yjCodesSlot.captured)
                .hasSize(1)
                .containsOnly("yjCode")
        }

        @Test
        fun `should not throw Exception if no kinkiDrugs found`() {
            val disease: Disease = mockk()
            every { disease.icd } returns "icd"
            val icdSlot = slot<String>()
            every { service.findKinkiDrugsByIcd(capture(icdSlot)) } returns emptyList()
            val yjCodesSlot = slot<List<String>>()
            every { drugService.getDrugs(capture(yjCodesSlot)) } returns mockk()

            resolver.getKinkiDrugs(disease)

            Assertions.assertThat(icdSlot.captured).isEqualTo("icd")
            Assertions.assertThat(yjCodesSlot.captured).isEmpty()
        }
    }
}