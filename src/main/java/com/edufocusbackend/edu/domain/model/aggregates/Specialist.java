package com.edufocusbackend.edu.domain.model.aggregates;
import com.edufocusbackend.edu.domain.model.entities.Activity;
import com.edufocusbackend.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Specialist  extends AuditableModel {
    @Getter
    @Id
    private Long id;

    private String firstName;
    private String lastname;

    private Integer age;
    private String specialization;

    //private List<String> tags = new ArrayList<>();

    private String language;
    private String nationality;
}
