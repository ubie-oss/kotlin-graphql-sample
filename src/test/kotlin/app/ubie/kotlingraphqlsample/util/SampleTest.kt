package app.ubie.kotlingraphqlsample.util

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class SampleTest {
    @Nested
    inner class getOne {
        private val sample: Sample = Sample()

        @Test
        fun `should get one`() {
            Assertions.assertThat(sample.getOne()).isEqualTo(1)
        }
    }
}
