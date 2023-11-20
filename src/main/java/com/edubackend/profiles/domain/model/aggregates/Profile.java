package com.edubackend.profiles.domain.model.aggregates;
import com.edubackend.profiles.domain.model.valueobjects.Email;
import com.edubackend.profiles.domain.model.valueobjects.Password;
import com.edubackend.profiles.domain.model.valueobjects.PersonName;
import com.edubackend.profiles.domain.model.valueobjects.UserName;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Profile {
    @Getter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private PersonName fullname;

    @Embedded
    private Email email;

    @Embedded
    private UserName userName;

    @Embedded
    private Password password;

    @CreatedDate
    private Date createAt;

    @LastModifiedDate
    private Date updatedAt;

    public Profile(){

    }

    public Profile(String fullname, String username, String email, String password){
        this.fullname = new PersonName(fullname);
        this.userName = new UserName(username);
        this.email = new Email(email);
        this.password = new Password(password);
    }

    public String getFullName(){
        return this.fullname.getFullName();
    }

    public String getEmailAddress(){
        return this.email.address();
    }

    public String getUserName(){return this.userName.getUserName();}
}
