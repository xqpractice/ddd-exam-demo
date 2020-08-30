package com.exam.context.paper.application.command;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

import java.util.List;

@Getter
@AllArgsConstructor
public class AssemblePaperCommand {
    private String teacherId;
    private List<BlankQuiz> quizzes;

    @Getter
    @AllArgsConstructor
    public static class BlankQuiz {
        private String quizId;
        private int score;
    }
}
