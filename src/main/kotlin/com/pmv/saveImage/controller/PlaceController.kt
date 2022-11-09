package com.pmv.saveImage.controller

import com.pmv.saveImage.model.Place
import com.pmv.saveImage.repository.PlaceRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/place")
@Api(value = "Контроллер управления местами")
class PlaceController {

    @Autowired
    lateinit var placeRepository: PlaceRepository

    @PostMapping("/")
    @ApiOperation(value = "Создание места отдыха", httpMethod = "POST")
    fun addPlace(@RequestBody newPlace: Place): ResponseEntity<*> {
        val placeExist = placeRepository.findById(newPlace.id)

        if (!placeExist.isPresent) {
            return ResponseEntity(placeRepository.save(newPlace), HttpStatus.CREATED)
        }

        return ResponseEntity("Ошибка создания места", HttpStatus.BAD_REQUEST)
    }
}