package com.u2team.huansync.activity.trivia.model;

import com.u2team.huansync.activity.model.Activity;
import com.u2team.huansync.activity.model.TypeActivity;

import java.time.LocalTime;

/**
 * The {@code Trivia} class represents a trivia entity, extending the base class {@code Activity}.
 * It includes additional attributes specific to trivia activities.
 */
public class Trivia extends Activity {

    private Long triviaId;
    private Long activityId;
    private Long participantOneId;
    private Long participantTwoId;
    private Long winnerId;
    private Long inchargedId;

    public Trivia() {

    }

    public Trivia(String nameActivity, TypeActivity typeActivity, Long categoryCosplayId, int numParticipants, Long eventId, LocalTime startTime, double price, boolean completed) {
        super(nameActivity,typeActivity,categoryCosplayId,numParticipants,eventId,startTime,price,completed);
    }

    /**
     * Gets the unique identifier of the trivia.
     *
     * @return The trivia ID.
     */
    public Long getTriviaId() {
        return triviaId;
    }

    /**
     * Sets the unique identifier of the trivia.
     *
     * @param triviaId The trivia ID to set.
     */
    public void setTriviaId(Long triviaId) {
        this.triviaId = triviaId;
    }

    /**
     * Gets the ID of the associated activity.
     *
     * @return The activity ID.
     */
    @Override
    public Long getActivityId() {
        return activityId;
    }

    /**
     * Sets the ID of the associated activity.
     *
     * @param activityId The activity ID to set.
     */
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    /**
     * Gets the ID of the first participant.
     *
     * @return The ID of the first participant.
     */
    public Long getParticipantOneId() {
        return participantOneId;
    }

    /**
     * Sets the ID of the first participant.
     *
     * @param participantOneId The ID of the first participant to set.
     */
    public void setParticipantOneId(Long participantOneId) {
        this.participantOneId = participantOneId;
    }

    /**
     * Gets the ID of the second participant.
     *
     * @return The ID of the second participant.
     */
    public Long getParticipantTwoId() {
        return participantTwoId;
    }

    /**
     * Sets the ID of the second participant.
     *
     * @param participantTwoId The ID of the second participant to set.
     */
    public void setParticipantTwoId(Long participantTwoId) {
        this.participantTwoId = participantTwoId;
    }

    /**
     * Gets the ID of the winner participant.
     *
     * @return The ID of the winner participant.
     */
    public Long getWinnerId() {
        return winnerId;
    }

    /**
     * Sets the ID of the winner participant.
     *
     * @param winnerId The ID of the winner participant to set.
     */
    public void setWinnerId(Long winnerId) {
        this.winnerId = winnerId;
    }

    /**
     * Gets the ID of the person in charge.
     *
     * @return The ID of the person in charge.
     */
    public Long getInchargedId() {
        return inchargedId;
    }

    /**
     * Sets the ID of the person in charge.
     *
     * @param inchargedId The ID of the person in charge to set.
     */
    public void setInchargedId(Long inchargedId) {
        this.inchargedId = inchargedId;
    }

    /**
     * Returns a string representation of the trivia object.
     *
     * @return A string representation of the trivia object.
     */
    @Override
    public String toString() {
        return "Trivia{" +
                "triviaId=" + triviaId +
                ", activityId=" + activityId +
                ", participantOneId=" + participantOneId +
                ", participantTwoId=" + participantTwoId +
                ", winnerId=" + winnerId +
                ", inchargedId=" + inchargedId +
                '}';
    }
}
