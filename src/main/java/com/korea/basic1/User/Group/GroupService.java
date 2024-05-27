package com.korea.basic1.User.Group;

import com.korea.basic1.User.User.SiteUser;
import com.korea.basic1.User.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GroupService {
    private final GroupRepository groupRepository;
    private final UserRepository userRepository;

    public Group createGroup(String name, Principal principal) {
        String username = principal.getName();
        SiteUser leader = userRepository.findByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 유저입니다."));

        Group group = new Group();
        group.setName(name);
        group.setLeader(leader);
        group.setCreateDate(LocalDateTime.now());

        // 그룹에 리더를 멤버로 추가
        group.getMembers().add(leader);

        return groupRepository.save(group);
    }


    public void addGroup(Long groupId, Long userId){
        Optional<Group> groupOpt = groupRepository.findById(groupId);
        Optional<SiteUser> userOpt = userRepository.findById(userId);

        if(groupOpt.isPresent()&&userOpt.isPresent()){
            Group group = groupOpt.get();
            SiteUser user = userOpt.get();
            group.getMembers().add(user);
            groupRepository.save(group);
        } else{
            throw new IllegalArgumentException("그룹이나 유저를 찾을 수 없습니다.");
        }
    }
    // 그룹 업데이트 메소드 추가
    public Group updateGroup(Long groupId, String name, String goal) {
        Group group = groupRepository.findById(groupId)
                .orElseThrow(() -> new IllegalArgumentException("그룹을 찾을 수 없습니다."));
        group.setName(name);
        group.setGoal(goal);
        return groupRepository.save(group);
    }

    public Group getGroup(Long id) {
        return groupRepository.findById(id).orElseThrow();
    }

    public List<Group> getAllGroups() {
        return groupRepository.findAll();
    }

    public List<Group> getAllGroupsSortedByMembers() {
        return groupRepository.findAllOrderByMembersCountDesc();
    }
}
