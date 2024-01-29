package com.u2team.huansync.activity.trivia.model;

/**
 * The {@code TriviaBuilderImpl} class is an implementation of the {@code TriviaBuilder} interface,
 * providing a fluent builder pattern for creating instances of the {@code Trivia} class.
 */
public class TriviaBuilderImpl implements TriviaBuilder {

    private Trivia trivia = new Trivia();

    /**
     * Sets the trivia ID for the builder.
     *
     * @param triviaId The trivia ID to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    @Override
    public TriviaBuilder triviaId(Long triviaId) {
        trivia.setTriviaId(triviaId);
        return this;
    }

    /**
     * Sets the activity ID for the builder.
     *
     * @param activityId The activity ID to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    @Override
    public TriviaBuilder activityId(Long activityId) {
        trivia.setActivityId(activityId);
        return this;
    }

    /**
     * Sets the ID of the first participant for the builder.
     *
     * @param participantOneId The ID of the first participant to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    @Override
    public TriviaBuilder participantOneId(Long participantOneId) {
        trivia.setParticipantOneId(participantOneId);
        return this;
    }

    /**
     * Sets the ID of the second participant for the builder.
     *
     * @param participantTwoId The ID of the second participant to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    @Override
    public TriviaBuilder participantTwoId(Long participantTwoId) {
        trivia.setParticipantTwoId(participantTwoId);
        return this;
    }

    /**
     * Sets the ID of the winner participant for the builder.
     *
     * @param winnerId The ID of the winner participant to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    @Override
    public TriviaBuilder winnerId(Long winnerId) {
        trivia.setWinnerId(winnerId);
        return this;
    }

    /**
     * Sets the ID of the person in charge for the builder.
     *
     * @param inchargedId The ID of the person in charge to set.
     * @return The {@code TriviaBuilder} instance for method chaining.
     */
    @Override
    public TriviaBuilder inchargedId(Long inchargedId) {
        trivia.setInchargedId(inchargedId);
        return this;
    }

    /**
     * Builds and returns a new {@code Trivia} object based on the configured attributes.
     *
     * @return A new {@code Trivia} object.
     */
    @Override
    public Trivia build() {
        return trivia;
    }
}
