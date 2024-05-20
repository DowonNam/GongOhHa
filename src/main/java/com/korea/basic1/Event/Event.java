package com.korea.basic1.Event;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.korea.basic1.Calendar.Calendar;
import com.korea.basic1.User.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime endDate;

    private String registrationLink;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    private Calendar calendar;

    @ManyToMany(mappedBy = "events")
    private Set<SiteUser> users = new HashSet<>();
}
