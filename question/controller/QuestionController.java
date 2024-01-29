package com.u2team.huansync.activity.trivia.question.controller;

import com.u2team.huansync.activity.trivia.question.model.Question;
import com.u2team.huansync.activity.trivia.question.model.QuestionDAO;

import java.util.List;

/**
 * Controller class for managing trivia questions.
 */
public class QuestionController {
    private static QuestionDAO questionDAO = new QuestionDAO();

    /**
     * Retrieves a list of all questions.
     *
     * @return List of all questions.
     */
    public static List<Question> getAllQuestions() {
        return questionDAO.getAllQuestions();
    }

    /**
     * Retrieves a single question by its ID.
     *
     * @param questionId The ID of the question to retrieve.
     * @return The question with the specified ID.
     */
    public static Question getQuestionById(Long questionId) {
        return questionDAO.getQuestionById(questionId);
    }

    /**
     * Inserts a new question into the system.
     *
     * @param question The question to be inserted.
     */
    public static void insertQuestion(Question question) {
        questionDAO.insertQuestion(question);
    }

    /**
     * Updates an existing question by its ID.
     *
     * @param question The updated question object.
     */
    public static void updateQuestion(Question question) {
        questionDAO.updateQuestion(question);
    }

    /**
     * Deletes a question by its ID.
     *
     * @param questionId The ID of the question to be deleted.
     */
    public static void deleteQuestion(Long questionId) {
        questionDAO.deleteQuestion(questionId);
    }
}
