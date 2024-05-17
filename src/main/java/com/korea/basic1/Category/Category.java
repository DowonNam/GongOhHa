package com.korea.basic1.Category;

import com.korea.basic1.Question.Question;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Category {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @OneToMany(mappedBy = "category", cascade = CascadeType.REMOVE)
    private List<Question> questionList;

    @Column(columnDefinition = "TEXT")
    private String name;

}