package com.learning.quiz_service.dto;

import lombok.Data;

@Data
public class QuizDTO {
    String categoryName;
    Integer numQuestions;
    String title;
}
