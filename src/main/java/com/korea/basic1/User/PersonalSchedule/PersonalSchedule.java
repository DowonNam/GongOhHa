package com.korea.basic1.User.PersonalSchedule;

import com.korea.basic1.User.User.SiteUser;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class PersonalSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String subject;

    private int totalTime; // Total study time in seconds

    private LocalDateTime lastReset;

    @ManyToOne
    private SiteUser siteUser;

}
