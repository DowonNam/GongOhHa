package com.korea.basic1.User.Group;

import com.korea.basic1.User.User.SiteUser;
import com.korea.basic1.User.User.UserRepository;
import com.korea.basic1.User.User.UserService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/group")
public class GroupController {

    private final GroupService groupService;
    private final GroupRepository groupRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @GetMapping("/edit/{groupId}")
    public String editGroup(@PathVariable Long groupId, Model model) {
        Optional<Group> groupOpt = groupRepository.findById(groupId);
        if (groupOpt.isPresent()) {
            Group group = groupOpt.get();
            model.addAttribute("group", group);
            return "groupEdit";
        } else {
            return "error/404";
        }
    }

    @PostMapping("/edit/{groupId}")
    public String updateGroup(@PathVariable Long groupId, @RequestParam String name, @RequestParam String goal) {
        groupService.updateGroup(groupId, name, goal);
        return "redirect:/group/detail/" + groupId;
    }


    @PostMapping("/create")
    public ResponseEntity<Group> createGroup(@RequestParam String name, Principal principal) {
        Group group = groupService.createGroup(name, principal);
        return ResponseEntity.ok(group);
    }

    @PostMapping("/{groupId}/join")
    public ResponseEntity<Void> joinGroup(@PathVariable Long groupId, @RequestParam Long userId) {
        groupService.addGroup(groupId, userId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/list")
    public String getAllGroups(Model model, Principal principal) {
        List<Group> groups = groupService.getAllGroups();
        model.addAttribute("groups", groups);

        // 로그인된 사용자 정보 추가
        String username = principal.getName();
        SiteUser user = userService.getUserByUsername(username);
        model.addAttribute("user", user);

        return "groupList_form";
    }

    @GetMapping("/sorted")
    public ResponseEntity<List<Group>> getAllGroupsSortedByMembers() {
        List<Group> groups = groupService.getAllGroupsSortedByMembers();
        return ResponseEntity.ok(groups);
    }

    @GetMapping("/detail/{groupId}")
    public String getGroupDetail(@PathVariable Long groupId, Model model) {
        Optional<Group> groupOpt = groupRepository.findById(groupId);
        if (groupOpt.isPresent()) {
            Group group = groupOpt.get();
            model.addAttribute("group", group);
            return "groupDetail";
        } else {
            return "error/404";
        }
    }

}
