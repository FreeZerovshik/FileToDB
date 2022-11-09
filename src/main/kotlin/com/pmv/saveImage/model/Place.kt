package com.pmv.saveImage.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.hibernate.annotations.ColumnDefault
import org.hibernate.annotations.Type
import java.io.Serializable
import java.sql.Blob
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "places")
data class Place(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: Long = 0,

    @Column(name = "name", nullable = false, length = 1000)
    var name: String? = "",

    @Column(name = "description", nullable = true)
    @ColumnDefault("''")
    @Lob
    @Type(type = "org.hibernate.type.TextType")
    var description: String? = "",

    @Column(name = "dateCreated")
    var dateCreated: Date = Date(),

    @Column(name = "dateChanged")
    var dateChanged: Date = Date(),

    @ManyToOne(cascade = [CascadeType.ALL])
    @JoinColumn(name = "images_id")
    @JsonIgnore
    var images: FileData? = null
): Serializable
