package com.korea.basic1.User.PersonalSchedule;

import com.korea.basic1.User.User.SiteUser;
import com.korea.basic1.User.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonalScheduleService {
    private final PersonalScheduleRepository personalScheduleRepository;
    private final UserRepository userRepository;

    public PersonalSchedule addSubject(Long userId, String subject){
        SiteUser user = userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 아이디입니다."));

        PersonalSchedule schedule = new PersonalSchedule();
        schedule.setSubject(subject);
        schedule.setTotalTime(0);
        schedule.setLastReset(LocalDateTime.now());
        schedule.setSiteUser(user);
        return personalScheduleRepository.save(schedule);
    }

    public void recordStudyTime(Long scheduleId,int duration){
        PersonalSchedule schedule = personalScheduleRepository.findById(scheduleId)
                .orElseThrow(()->new IllegalArgumentException("스케줄 아이디를 확인해주세요"));
        schedule.setTotalTime(schedule.getTotalTime()+duration);
        personalScheduleRepository. save(schedule);
    }

    public List<PersonalSchedule> getSchedulesByUser(Long userId){
        SiteUser user = userRepository.findById(userId)
                .orElseThrow(()->new IllegalArgumentException("유저 아이디를 찾을 수 없습니다."));
        return user.getPersonalSchedules();
    }

    public void resetDailyStudyTimes(){
        List<PersonalSchedule> schedules = personalScheduleRepository.findAll();
        LocalDateTime now = LocalDateTime.now();
        for(PersonalSchedule schedule:schedules){
            if(schedule.getLastReset().toLocalDate().isBefore(now.toLocalDate())){
                schedule.setTotalTime(0);
                schedule.setLastReset(now);
                personalScheduleRepository.save(schedule);
            }
        }
    }

}
