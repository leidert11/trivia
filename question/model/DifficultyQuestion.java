package com.u2team.huansync.activity.trivia.question.model;

/**
 * Enumeration representing the difficulty levels of trivia questions.
 */
public enum DifficultyQuestion {
    EASY("easy"), MEDIUM("medium"), HARD("hard");

    private String name;

    /**
     * Constructs a DifficultyQuestion enum with the specified name.
     *
     * @param name The name of the difficulty level.
     */
    private DifficultyQuestion(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the difficulty level.
     *
     * @return The name of the difficulty level.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the difficulty level.
     *
     * @param name The name of the difficulty level to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
