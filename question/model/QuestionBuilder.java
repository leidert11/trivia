package com.u2team.huansync.activity.trivia.question.model;

/**
 * Builder interface for creating instances of {@link Question}.
 */
public interface QuestionBuilder {
    /**
     * Sets the ID of the question.
     *
     * @param questionId The ID to set for the question.
     * @return The updated QuestionBuilder instance.
     */
    QuestionBuilder questionId(Long questionId);

    /**
     * Sets the text of the question.
     *
     * @param question The text to set for the question.
     * @return The updated QuestionBuilder instance.
     */
    QuestionBuilder question(String question);

    /**
     * Sets the answer to the question.
     *
     * @param answer The answer to set for the question.
     * @return The updated QuestionBuilder instance.
     */
    QuestionBuilder answer(String answer);

    /**
     * Sets the category of the question.
     *
     * @param categoryQuestion The category to set for the question.
     * @return The updated QuestionBuilder instance.
     */
    QuestionBuilder categoryQuestion(CategoryQuestion categoryQuestion);

    /**
     * Sets the difficulty level of the question.
     *
     * @param difficultyQuestion The difficulty level to set for the question.
     * @return The updated QuestionBuilder instance.
     */
    QuestionBuilder difficultyQuestion(DifficultyQuestion difficultyQuestion);

    /**
     * Builds and returns an instance of {@link Question}.
     *
     * @return An instance of {@link Question}.
     */
    Question build();
}
