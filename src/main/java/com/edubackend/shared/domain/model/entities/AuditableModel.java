package com.edubackend.shared.domain.model.entities;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableModel {
    @CreatedDate
    @Column(name = "created_at")
    private Date createdAt;

    @LastModifiedBy
    @Column(name = "updated_at")
    private Date updatedAt;
}
