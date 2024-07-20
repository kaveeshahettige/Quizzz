package com.example.Quizzz.model;

import lombok.Data;

@Data
public class QuestionWrapper {
    private int id;
    private String question;
    private String option1;
    private String option2;
    private String option3;

    public QuestionWrapper(int id, String question, String option1, String option2, String option3) {
        this.option3 = option3;
        this.id = id;
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
    }
}

