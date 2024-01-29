package com.u2team.huansync.activity.trivia.question.model;

import com.u2team.huansync.persistence.BDConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Data Access Object (DAO) class for managing operations related to the Question entity in the database.
 */
public class QuestionDAO {

    /**
     * Retrieves all questions from the database.
     *
     * @return A list of Question objects representing all questions in the database.
     */
    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_questions";
            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Question question = new Question();
                    question.setQuestionId(resultSet.getLong("questionId"));
                    question.setQuestion(resultSet.getString("question"));
                    question.setAnswer(resultSet.getString("answer"));
                    if (resultSet.getString("category").equalsIgnoreCase("jujutsu kaisen")) {
                        question.setCategoryQuestion(CategoryQuestion.valueOf("JUJUTSU_KAISEN"));
                    } else if (resultSet.getString("category").equalsIgnoreCase("harry potter")) {
                        question.setCategoryQuestion(CategoryQuestion.valueOf("HARRY_POTTER"));
                    } else {
                        question.setCategoryQuestion(CategoryQuestion.valueOf(resultSet.getString("category").toUpperCase()));
                    }
                    question.setDifficultyQuestion(DifficultyQuestion.valueOf(resultSet.getString("difficulty").toUpperCase()));
                    questions.add(question);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    /**
     * Retrieves a specific question by its ID from the database.
     *
     * @param questionId The ID of the question to retrieve.
     * @return A Question object representing the question with the specified ID.
     */
    public Question getQuestionById(Long questionId) {
        Question question = new Question();
        try (Connection connection = BDConnection.MySQLConnection()){
            String sql = "SELECT * FROM tbl_questions WHERE questionId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, questionId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        question.setQuestionId(resultSet.getLong("questionId"));
                        question.setQuestion(resultSet.getString("question"));
                        question.setAnswer(resultSet.getString("answer"));
                        if (resultSet.getString("category").equalsIgnoreCase("jujutsu kaisen")) {
                            question.setCategoryQuestion(CategoryQuestion.valueOf("JUJUTSU_KAISEN"));
                        } else if (resultSet.getString("category").equalsIgnoreCase("harry potter")) {
                            question.setCategoryQuestion(CategoryQuestion.valueOf("HARRY_POTTER"));
                        } else {
                            question.setCategoryQuestion(CategoryQuestion.valueOf(resultSet.getString("category").toUpperCase()));
                        }
                        question.setDifficultyQuestion(DifficultyQuestion.valueOf(resultSet.getString("difficulty").toUpperCase()));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

    /**
     * Inserts a new question into the database.
     *
     * @param question The Question object to insert.
     */
    public void insertQuestion(Question question){
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "INSERT INTO tbl_questions (question, answer, category, difficulty) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1,question.getQuestion());
                statement.setString(2,question.getAnswer());
                statement.setString(3,question.getCategory().getName());
                statement.setString(4,question.getDifficulty().getName());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Updates an existing question in the database.
     *
     * @param question The updated Question object.
     */
    public void updateQuestion(Question question){
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "UPDATE tbl_questions SET question = ?, answer = ?, category = ?, difficulty = ? WHERE questionId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, question.getQuestion());
                statement.setString(2, question.getAnswer());
                statement.setString(3, question.getCategory().getName());
                statement.setString(4, question.getDifficulty().getName());
                statement.setLong(5, question.getQuestionId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes a question from the database based on its ID.
     *
     * @param questionId The ID of the question to delete.
     */
    public void deleteQuestion(Long questionId){
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "DELETE FROM tbl_questions WHERE questionId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, questionId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
