package com.pmv.saveImage.model

import org.hibernate.annotations.Type
import javax.persistence.*

@Entity
@Table(name = "files")
data class FileData(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String,

    val type: String,

    @Lob
    @Column(name="file_data")
    @Type(type="org.hibernate.type.BinaryType")
    val data: ByteArray

)
