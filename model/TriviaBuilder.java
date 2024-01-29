package com.u2team.huansync.activity.trivia.model;

/**
 * The {@code TriviaBuilder} interface provides a fluent builder pattern for creating instances of the {@code Trivia} class.
 * It allows for constructing a {@code Trivia} object with various attributes using a step-by-step approach.
 */
public interface TriviaBuilder {

    /**
     * Sets the trivia ID for the builder.
     *
     * @param triviaId The trivia ID to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    TriviaBuilder triviaId(Long triviaId);

    /**
     * Sets the activity ID for the builder.
     *
     * @param activityId The activity ID to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    TriviaBuilder activityId(Long activityId);

    /**
     * Sets the ID of the first participant for the builder.
     *
     * @param participantOneId The ID of the first participant to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    TriviaBuilder participantOneId(Long participantOneId);

    /**
     * Sets the ID of the second participant for the builder.
     *
     * @param participantTwoId The ID of the second participant to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    TriviaBuilder participantTwoId(Long participantTwoId);

    /**
     * Sets the ID of the winner participant for the builder.
     *
     * @param winnerId The ID of the winner participant to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    TriviaBuilder winnerId(Long winnerId);

    /**
     * Sets the ID of the person in charge for the builder.
     *
     * @param inchargedId The ID of the person in charge to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    TriviaBuilder inchargedId(Long inchargedId);

    /**
     * Builds and returns a new {@code Trivia} object based on the configured attributes.
     *
     * @return A new {@code Trivia} object.
     */
    Trivia build();
}
