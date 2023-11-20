package com.edubackend.edu.domain.model.aggregates;
import com.edubackend.edu.domain.model.valueobjects.*;
import com.edubackend.shared.domain.model.entities.AuditableModel;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import java.util.Date;

/**
 * Represents a student.
 * The student is an aggregate root.
 */

@Entity
public class Student extends AuditableModel {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    @Getter
    @Embedded
    @Column(name = "edu_student_id")
    private final EduStudentRecordId eduStudentRecordId;

    @Embedded
    private ProfileId profileId;

    @Embedded
    private TypeOfUser typeOfUser;

    @Embedded
    private UniversityOrInstitute universityOrInstitute;

    @Embedded
    private Gender gender;

    @Embedded
    private Birthdate birthdate;

    public Student(){
        this.eduStudentRecordId = new EduStudentRecordId();
    }

    public Student(Long profileId){
        this();
        this.profileId = new ProfileId(profileId);
    }

    public Student(ProfileId profileId){
        this();
        this.profileId = profileId;
    }

    public Student(Long profileId, String typeOfUser, String universityOrInstitute, String gender,
                   Birthdate birthdate){
        this();
        this.profileId = new ProfileId(profileId);
        this.typeOfUser = new TypeOfUser(typeOfUser);
        this.universityOrInstitute = new UniversityOrInstitute(universityOrInstitute);
        this.gender = new Gender(gender);
        this.birthdate =birthdate;
    }

    public Student(ProfileId profileId, String typeOfUser, String universityOrInstitute, String gender,
                   Birthdate birthdate){
        this();
        this.profileId = profileId;
        this.typeOfUser = new TypeOfUser(typeOfUser);
        this.universityOrInstitute = new UniversityOrInstitute(universityOrInstitute);
        this.gender = new Gender(gender);
        this.birthdate = birthdate;
    }

    public String getStudentRecordId(){
        return this.eduStudentRecordId.studentRecordId();
    }

    public Long getProfileId(){
        return this.profileId.profileId();
    }

}
