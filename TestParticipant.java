/**
 * The `TestParticipant` class represents a participant in a trivia game, identified by a unique participant ID and a name.
 */
package com.u2team.huansync.activity.trivia;

public class TestParticipant {
    private long participantId; // Unique identifier for the participant
    private String name; // Name of the participant

    /**
     * Constructs a new `TestParticipant` with the specified participant ID and name.
     *
     * @param participantId The unique identifier for the participant.
     * @param name           The name of the participant.
     */
    public TestParticipant(long participantId, String name) {
        this.participantId = participantId;
        this.name = name;
    }

    /**
     * Retrieves the participant's unique identifier.
     *
     * @return The participant's unique identifier.
     */
    public long getParticipantId() {
        return participantId;
    }

    /**
     * Sets the participant's unique identifier.
     *
     * @param id The new unique identifier for the participant.
     */
    public void setParticipantId(long id) {
        this.participantId = id;
    }

    /**
     * Retrieves the name of the participant.
     *
     * @return The name of the participant.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the participant.
     *
     * @param name The new name for the participant.
     */
    public void setName(String name) {
        this.name = name;
    }
}
