package com.u2team.huansync.activity.trivia.question.model;

/**
 * Implementation of the {@link QuestionBuilder} interface for building instances of {@link Question}.
 */
public class QuestionBuilderImpl implements QuestionBuilder {
    private Question question = new Question();

    /**
     * Sets the ID of the question.
     *
     * @param questionId The ID to set for the question.
     * @return The updated QuestionBuilderImpl instance.
     */
    @Override
    public QuestionBuilder questionId(Long questionId) {
        question.setQuestionId(questionId);
        return this;
    }

    /**
     * Sets the text of the question.
     *
     * @param questionText The text to set for the question.
     * @return The updated QuestionBuilderImpl instance.
     */
    @Override
    public QuestionBuilder question(String questionText) {
        question.setQuestion(questionText);
        return this;
    }

    /**
     * Sets the answer to the question.
     *
     * @param answer The answer to set for the question.
     * @return The updated QuestionBuilderImpl instance.
     */
    @Override
    public QuestionBuilder answer(String answer) {
        question.setAnswer(answer);
        return this;
    }

    /**
     * Sets the category of the question.
     *
     * @param categoryQuestion The category to set for the question.
     * @return The updated QuestionBuilderImpl instance.
     */
    @Override
    public QuestionBuilder categoryQuestion(CategoryQuestion categoryQuestion) {
        question.setCategoryQuestion(categoryQuestion);
        return this;
    }

    /**
     * Sets the difficulty level of the question.
     *
     * @param difficultyQuestion The difficulty level to set for the question.
     * @return The updated QuestionBuilderImpl instance.
     */
    @Override
    public QuestionBuilder difficultyQuestion(DifficultyQuestion difficultyQuestion) {
        question.setDifficultyQuestion(difficultyQuestion);
        return this;
    }

    /**
     * Builds and returns an instance of {@link Question}.
     *
     * @return An instance of {@link Question}.
     */
    @Override
    public Question build() {
        return question;
    }
}
