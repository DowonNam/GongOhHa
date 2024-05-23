package com.korea.basic1.User.PersonalSchedule;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PersonalScheduleController {

    private final PersonalScheduleService personalScheduleService;

    @GetMapping("/schedules")
    public String getSchedules(Model model, @RequestParam Long userId) {
        model.addAttribute("schedules", personalScheduleService.getSchedulesByUser(userId));
        return "schedules";
    }

    @PostMapping("/schedules")
    public String addSubject(@RequestParam Long userId, @RequestParam String subject) {
        personalScheduleService.addSubject(userId, subject);
        return "studyBoard";
    }

    @PostMapping("/study-time")
    @ResponseBody
    public void recordStudyTime(@RequestParam Long scheduleId, @RequestParam int duration) {
        personalScheduleService.recordStudyTime(scheduleId, duration);
    }
}
