package com.korea.basic1.User.PersonalSchedule;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PersonalScheduleController {

    private final PersonalScheduleService personalScheduleService;

    @PostMapping("/schedules")
    public String addSubject(@RequestParam Long userId, @RequestParam String subject) {
        personalScheduleService.addSubject(userId, subject);
        return "redirect:/user/studyBoard/"+ userId;
    }

    @PostMapping("/schedules/delete")
    public String deleteSubject(@RequestParam Long userId, @RequestParam Long scheduleId) {
        personalScheduleService.deleteSchedule(scheduleId);
        return "redirect:/user/studyBoard/" + userId;
    }

    @PostMapping("/study-time")
    @ResponseBody
    public void recordStudyTime(@RequestParam Long scheduleId, @RequestParam int duration) {
        personalScheduleService.recordStudyTime(scheduleId, duration);
    }
}
