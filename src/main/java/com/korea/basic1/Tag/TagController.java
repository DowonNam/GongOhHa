package com.korea.basic1.Tag;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    @GetMapping("/list")
    public String getTags(Model model) {
        List<Tag> tags = tagService.getTagList();
        model.addAttribute("tags", tags);
        return "groupList_form";  // 뷰 템플릿 경로에 맞게 수정하세요.
    }

    @GetMapping("/{id}")
    public String getTag(@PathVariable Long id, Model model) {
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag", tag);
        return "tags/detail";  // 뷰 템플릿 경로에 맞게 수정하세요.
    }

    @GetMapping("/create")
    public String createTagForm(Model model) {
        model.addAttribute("tag", new Tag());
        return "tags/new";  // 뷰 템플릿 경로에 맞게 수정하세요.
    }

    @PostMapping("/create")
    public String createTag(@ModelAttribute Tag tag) {
        tagService.create(tag.getName());
        return "redirect:/tags";
    }

    @GetMapping("/{id}/edit")
    public String editTagForm(@PathVariable Long id, Model model) {
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag", tag);
        return "tags/edit";  // 뷰 템플릿 경로에 맞게 수정하세요.
    }

    @PostMapping("/{id}")
    public String updateTag(@PathVariable Long id, @ModelAttribute Tag tag) {
        Tag existingTag = tagService.getTag(id);
        existingTag.setName(tag.getName());
        tagService.create(existingTag.getName());
        return "redirect:/tags";
    }

    @PostMapping("/{id}/delete")
    public String deleteTag(@PathVariable Long id) {
        tagService.delete(id);
        return "redirect:/tags";
    }



}
