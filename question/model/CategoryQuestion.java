package com.u2team.huansync.activity.trivia.question.model;

/**
 * Enumeration representing categories of trivia questions.
 */
public enum CategoryQuestion {
    NARUTO("Naruto"),
    SPYXFAMILY("SPYxFamily"),
    JUJUTSU_KAISEN("Jujutsu Kaisen"),
    HARRY_POTTER("Harry Potter"),
    COMICS("Comics");

    private String name;

    /**
     * Constructs a CategoryQuestion enum with the specified name.
     *
     * @param name The name of the category.
     */
    private CategoryQuestion(String name) {
        this.name = name;
    }

    /**
     * Gets the name of the category.
     *
     * @return The name of the category.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the category.
     *
     * @param name The name of the category to set.
     */
    public void setName(String name) {
        this.name = name;
    }
}
