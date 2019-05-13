package app.ubie.kotlingraphqlsample.controller

import app.ubie.kotlingraphqlsample.domain.Drug
import app.ubie.kotlingraphqlsample.service.DrugService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMethod

@RestController
@RequestMapping("/api/drugs")
class DrugController(private val drugService: DrugService) {

    @GetMapping("/{name}")
    fun getDrugs(@PathVariable("name") name : String) : List<Drug>
        = drugService.getDrugsByName(name)
}