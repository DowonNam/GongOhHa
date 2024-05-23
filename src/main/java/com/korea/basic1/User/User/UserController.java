package com.korea.basic1.User.User;


import com.korea.basic1.Board.Answer.Answer;
import com.korea.basic1.Board.Answer.AnswerService;
import com.korea.basic1.Board.Comment.Comment;
import com.korea.basic1.Board.Comment.CommentService;
import com.korea.basic1.Board.Question.Question;
import com.korea.basic1.Board.Question.QuestionService;
import com.korea.basic1.Security.MyUser;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;
    private final QuestionService questionService;
    private final CommentService commentService;
    private final AnswerService answerService;

    @GetMapping("/studyBoard/{username}")
    public String userBoard(Model model, Principal principal) {
        // 현재 로그인된 사용자의 유저네임을 Principal 객체에서 추출
        String username = principal.getName();

        // 유저네임을 사용하여 사용자 정보 조회
        SiteUser user = this.userService.getUserByUsername(username);

        // 사용자 정보가 null인지 확인
        if (user == null) {
            return "userNotFound"; // 사용자가 존재하지 않을 경우 적절한 처리 필요
        }

        // 모델에 사용자 정보 추가
        model.addAttribute("user", user);
        List<Question> questions = questionService.findByAuthorId(user.getId());
        List<Comment> comments = commentService.findByUserId(user.getId());
        List<Answer> answers = answerService.findByAuthorId(user.getId());

        model.addAttribute("questions", questions);
        model.addAttribute("comments", comments);
        model.addAttribute("answers", answers);
        model.addAttribute("userNickname",user.getUserNickname());
        model.addAttribute("userId", user.getId());
        model.addAttribute("username", user.getUsername());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("userCalendarId",user.getUserCalendar());

        // 프로필 페이지 뷰 이름 반환
        return "studyBoard";
    }

    @GetMapping("/profile/{userNickname}")
    public String userProfile(Model model, Authentication authentication) {
        // 현재 로그인된 사용자의 유저네임을 Principal 객체에서 추출
        MyUser user = (MyUser) authentication.getPrincipal();

        // 유저네임을 사용하여 사용자 정보 조회
        SiteUser foundedUser = this.userService.getUserByUsername(user.getUsername());

        // 사용자 정보가 null인지 확인
        if (foundedUser == null) {
            return "userNotFound"; // 사용자가 존재하지 않을 경우 적절한 처리 필요
        }

        // 모델에 사용자 정보 추가
        model.addAttribute("user", user);
        List<Question> questions = questionService.findByAuthorId(foundedUser.getId());
        List<Comment> comments = commentService.findByUserId(foundedUser.getId());
        List<Answer> answers = answerService.findByAuthorId(foundedUser.getId());

        model.addAttribute("questions", questions);
        model.addAttribute("comments", comments);
        model.addAttribute("answers", answers);
        model.addAttribute("userNickname",foundedUser.getUserNickname());
        model.addAttribute("userId", foundedUser.getId());
        model.addAttribute("username", foundedUser.getUsername());
        model.addAttribute("email", foundedUser.getEmail());

        // 프로필 페이지 뷰 이름 반환
        return "userProfile_form";
    }

    @GetMapping("/signup")
    public String signup(UserCreateForm userCreateForm) {
        return "signup_form";
    }

    @PostMapping("/signup")
    public String signup(@Valid UserCreateForm userCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "signup_form";
        }
        if (!userCreateForm.getPassword1().equals(userCreateForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect",
                    "2개의 패스워드가 일치하지 않습니다.");
            return "signup_form";
        }
        try {
            userService.create(userCreateForm.getUsername(), userCreateForm.getEmail(), userCreateForm.getPassword1(), userCreateForm.getUsernickname());
        } catch (DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "이미 등록된 사용자입니다.");
            return "signup_form";
        } catch (Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "signup_form";
        }

        // 불필요한 userService.create 호출을 제거함
        return "redirect:/";
    }

    @GetMapping("/login")
    public String login() {
        return "login_form";
    }

}


