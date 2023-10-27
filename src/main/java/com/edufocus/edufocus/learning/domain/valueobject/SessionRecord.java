package com.edufocus.edufocus.learning.domain.valueobject;

import com.edufocus.edufocus.learning.domain.entities.SessionRecordItem;
import jakarta.persistence.Embeddable;
import jakarta.persistence.OneToMany;

import java.util.List;

@Embeddable
public class SessionRecord {

    @OneToMany(mappedBy =  "enrollment")
    private List<SessionRecordItem> sessionRecordItems;
}
