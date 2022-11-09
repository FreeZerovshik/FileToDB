package com.pmv.saveImage.controller

import com.pmv.saveImage.model.FileData
import com.pmv.saveImage.repository.PlaceRepository
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile

@RestController
@RequestMapping("/")
@Api(value = "Управление файлами")
class FileController {

    @Autowired
    lateinit var placeRepository: PlaceRepository

    @PostMapping("/place/{placeId}/upload")
    @ApiOperation(value = "Добавить файл", httpMethod = "POST")
    fun uploadFile(@PathVariable(name = "placeId", required = true) placeId: Long,
                     @RequestParam image: MultipartFile)
    {
        val placeExist = placeRepository.findById(placeId)

        if (placeExist.isPresent) {
            val place = placeExist.get()

            val newFile = FileData(
                name = image.originalFilename.toString(),
                type = image.contentType.toString(),
                data = image.bytes
            )

            place.images = newFile

            placeRepository.save(place)
        }
    }
}