package com.u2team.huansync.activity.trivia.question.model;

/**
 * Model class representing a trivia question.
 */
public class Question {
    private Long questionId;
    private String question;
    private String answer;
    private CategoryQuestion categoryQuestion;
    private DifficultyQuestion difficultyQuestion;

    /**
     * Gets the ID of the question.
     *
     * @return The ID of the question.
     */
    public Long getQuestionId() {
        return questionId;
    }

    /**
     * Sets the ID of the question.
     *
     * @param questionId The ID to set for the question.
     */
    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    /**
     * Gets the text of the question.
     *
     * @return The text of the question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Sets the text of the question.
     *
     * @param question The text to set for the question.
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * Gets the answer to the question.
     *
     * @return The answer to the question.
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * Sets the answer to the question.
     *
     * @param answer The answer to set for the question.
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * Gets the category of the question.
     *
     * @return The category of the question.
     */
    public CategoryQuestion getCategory() {
        return categoryQuestion;
    }

    /**
     * Sets the category of the question.
     *
     * @param categoryQuestion The category to set for the question.
     */
    public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
        this.categoryQuestion = categoryQuestion;
    }

    /**
     * Gets the difficulty level of the question.
     *
     * @return The difficulty level of the question.
     */
    public DifficultyQuestion getDifficulty() {
        return difficultyQuestion;
    }

    /**
     * Sets the difficulty level of the question.
     *
     * @param difficultyQuestion The difficulty level to set for the question.
     */
    public void setDifficultyQuestion(DifficultyQuestion difficultyQuestion) {
        this.difficultyQuestion = difficultyQuestion;
    }

    /**
     * Returns a string representation of the question.
     *
     * @return String representation of the question.
     */
    @Override
    public String toString() {
        return "Question{" +
                "questionId=" + questionId +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", category=" + categoryQuestion +
                ", difficulty=" + difficultyQuestion +
                '}';
    }
}
