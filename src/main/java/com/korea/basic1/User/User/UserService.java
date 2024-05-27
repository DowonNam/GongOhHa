package com.korea.basic1.User.User;



import com.korea.basic1.DataNotFoundException;
import com.korea.basic1.DuplicateEmailException;
import com.korea.basic1.Schedule.UserCalendar.CalendarService;
import com.korea.basic1.Schedule.UserCalendar.UserCalendar;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final CalendarService calendarService;

    @Transactional
    public SiteUser create(String username, String email, String password, String userNickname) {

        // 이메일 중복 검사
        Optional<SiteUser> existingUser = userRepository.findByEmail(email);
        if (existingUser.isPresent()) {
            throw new DuplicateEmailException("이 이메일은 이미 사용중입니다: " + email);
        }

        SiteUser user = new SiteUser();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setUserNickname(userNickname);
        user.setCreateDate(LocalDateTime.now());

        // SiteUser 엔티티를 먼저 저장합니다.
        SiteUser savedUser = userRepository.save(user);

        // 새 사용자 등록 시 달력 생성 및 기본 이벤트 추가
        UserCalendar userCalendar = calendarService.createCalendar(savedUser);
        savedUser.setUserCalendar(userCalendar);

        return userRepository.save(savedUser);
    }

    public SiteUser getUser(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }


    public SiteUser getUserByUsername(String username) {
        Optional<SiteUser> siteUser = this.userRepository.findByUsername(username);
        if (siteUser.isPresent()) {
            return siteUser.get();
        } else {
            throw new DataNotFoundException("siteuser not found");
        }
    }

}
