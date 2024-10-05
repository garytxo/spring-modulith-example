package com.example.shared.infrastructure.persistence

import jakarta.persistence.Column
import jakarta.persistence.EntityListeners
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.annotation.Version
import org.springframework.data.domain.Persistable
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.time.Instant

@EntityListeners(AuditingEntityListener::class)
abstract class AuditableEntity<T>:Persistable<T> {

    @Version
    @Column(name = "row_version")
    var version: Long? = null


    @CreatedDate
    @Column(name = "row_created_on")
    var createdOn: Instant = Instant.now()

    @LastModifiedDate
    @Column(name = "row_updated_on")
    var lastModifiedOn: Instant? = null


    override fun isNew() = version==null


}