package com.edufocusbackend.edu.domain.model.valueobjects;
import com.edufocusbackend.edu.domain.model.aggregates.Reserve;
import com.edufocusbackend.edu.domain.model.entities.Activity;
import com.edufocusbackend.edu.domain.model.entities.ActivityRecordItem;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;


/*Por cada asesoria o reserva se puede tener varias actividades a realizar.*/
@Embeddable
public class ActivityRecord {
    @OneToMany(mappedBy =  "reserve") // Una asesoria puede tener de una a muchas actividades.
    private List<ActivityRecordItem> activityRecordItems;

    public ActivityRecord(){
        activityRecordItems = new ArrayList<>();
    }

    public void initializeAdiviceRecord(Reserve reserve, Activity activity){
        ActivityRecordItem activityRecordItem = new ActivityRecordItem(reserve, activity);
    }

    //obtener elemento de registro de proceso con ID de tutorial
    private ActivityRecordItem getAdviceRecordItemWithActivityId(Long activityId){
        return activityRecordItems.stream().filter(activityRecordItem -> activityRecordItem.getActivity()
                .getId().equals(activityId)).findFirst().orElse(null);
    }

    private boolean hasAnItemNotStarted(){
        return activityRecordItems.stream().anyMatch(ActivityRecordItem::isNotStarted);
    }

    public void completeActivity(Long activityId){
        ActivityRecordItem activityRecordItem =getAdviceRecordItemWithActivityId(activityId);
        if (activityRecordItem != null){
            activityRecordItem.complete();
        }
        else throw new IllegalArgumentException("Activity with given Id not found in Advice record");
    }

}
