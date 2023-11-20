package com.edubackend.edu.domain.model.aggregates;
import com.edubackend.edu.domain.model.valueobjects.EduStudentRecordId;
import com.edubackend.edu.domain.model.valueobjects.ReserveStatus;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.domain.AbstractAggregateRoot;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import java.util.Date;

@EntityListeners(AuditingEntityListener.class)
@Entity
public class Reserve extends AbstractAggregateRoot<Reserve> {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Embedded
    private EduStudentRecordId eduStudentRecordId;

    @Getter
    @ManyToOne
    @JoinColumn(name = "specialist_id")
    private Specialist specialist;

    private ReserveStatus status;

    @CreatedDate
    private Date createdAt;

    @LastModifiedDate
    private Date updatedAt;

    public Reserve(){

    }

    public Reserve(EduStudentRecordId eduStudentRecordId, Specialist specialist){
        this.specialist = specialist;
        this.status = ReserveStatus.CONFIRMED;
        this.eduStudentRecordId = eduStudentRecordId;
    }

    /**
     * Confirms the Reserve.
     */
    public void confirm(){
        this.status = ReserveStatus.CONFIRMED;
    }

    /**
     * Cancels the Reserve.
     */
    public void cancel(){
        this.status = ReserveStatus.CANCELLED;
    }

    /**
     * Returns the status of the enrollment.
     * @return The status of the enrollment.
     */
    public String getStatus() {
        return this.status.name().toLowerCase();
    }
}
