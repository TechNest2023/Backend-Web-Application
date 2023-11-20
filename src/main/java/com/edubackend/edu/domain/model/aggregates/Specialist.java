package com.edubackend.edu.domain.model.aggregates;
import com.edubackend.edu.domain.model.valueobjects.*;
import com.edubackend.profiles.domain.model.valueobjects.PersonName;
import com.edubackend.shared.domain.model.entities.AuditableModel;
//import io.jsonwebtoken.lang.Strings;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Specialist extends AuditableModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;

    //@Embedded
    private String fullname;

    //@Embedded
    private Integer age;

    //@Embedded
    private String career;

    private String specialization;

    //@Embedded
    //private String topics;

    @ElementCollection
    @CollectionTable(name = "specialist_topics", joinColumns = @JoinColumn(name = "specialist_id"))
    @Column(name = "topic")
    private List<String> topics;


    private String  language;

    private String nationality;

    //@Embedded
    private String image;

    public Specialist(){
        //this.specialization = Strings.EMPTY;
        //this.language = Strings.EMPTY;
        //this.nationality = Strings.EMPTY;
    }

    public Specialist(String fullname, Integer age, String career, String specialization,
                      List<String> topics, String language, String nationality, String image){

        this();
        /*
        this.fullname = new PersonName(fullname);
        this.age = new Age(age);
        this.career = new Career(career);
        this.specialization = specialization;
        this.topics = new Topics(topics);
        this.language = language;
        this.nationality = nationality;
        this.image = new Image(image);*/

        this.fullname = fullname;
        this.age = age;
        this.career = career;
        this.specialization = specialization;
        this.topics = topics;
        this.language = language;
        this.nationality = nationality;
        this.image = image;
    }
}
