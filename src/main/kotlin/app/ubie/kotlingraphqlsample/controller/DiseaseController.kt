package app.ubie.kotlingraphqlsample.controller

import app.ubie.kotlingraphqlsample.domain.Disease
import app.ubie.kotlingraphqlsample.service.DiseaseService
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMethod

@RestController
@RequestMapping("api/diseases")
class DiseaseController(private val diseaseService: DiseaseService) {

    @GetMapping("/{name}")
    fun getDiseases(@PathVariable("name") name : String) : List<Disease>
        = diseaseService.getDiseasesByName(name)
}