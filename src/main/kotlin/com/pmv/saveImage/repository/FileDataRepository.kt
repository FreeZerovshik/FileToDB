package com.pmv.saveImage.repository;

import com.pmv.saveImage.model.FileData
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface FileDataRepository : JpaRepository<FileData, Long> {
}