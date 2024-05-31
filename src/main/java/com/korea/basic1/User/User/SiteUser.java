package com.korea.basic1.User.User;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.korea.basic1.Schedule.Event.Event;
import com.korea.basic1.Schedule.UserCalendar.UserCalendar;
import com.korea.basic1.User.Group.Group;
import com.korea.basic1.User.PersonalSchedule.PersonalSchedule;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.*;

@Getter
@Setter
@Entity
public class SiteUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String userNickname;

    @Lob
    private byte[] profileImage;

    @ManyToMany
    @JoinTable(
            name = "user_event",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "event_id")
    )
    private Set<Event> events = new HashSet<>();

    private LocalDateTime createDate;

    public String getBase64EncodedProfileImage() {
        if (profileImage != null) {
            return Base64.getEncoder().encodeToString(profileImage);
        } else {
            // 프로필 이미지가 없는 경우 기본 이미지를 반환하거나 빈 문자열을 반환할 수 있습니다.
            return ""; // 빈 문자열 반환
        }
    }

    // 변경
    @OneToMany(mappedBy = "siteUser", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<PersonalSchedule> personalSchedules;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calendar_id")
    private UserCalendar userCalendar;

    @ManyToMany(mappedBy = "members")
    private Set<Group> groups = new HashSet<>();

    @Transient
    private int todayStudyTime;
}
