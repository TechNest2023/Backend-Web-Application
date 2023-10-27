package com.edufocus.edufocus.shared.domain.model.entities;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import java.util.Date;

@Data
@MappedSuperclass
public class AuditableModel {
    @CreatedDate
    private Date createdAt;
    @LastModifiedBy
    private Date updatedAt;
}
