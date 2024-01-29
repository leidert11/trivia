/**
 * This class, {@code Informs}, provides methods to retrieve various information related to trivia activities.
 * It utilizes an instance of {@link InformsDAO} to interact with the data source.
 */
package com.u2team.huansync.activity.trivia.informs;

public class Informs {
    private static InformsDAO informsDAO = new InformsDAO();

    /**
     * Retrieves participant details for trivia activities.
     */
    public static void getParticipantDetails() {
        informsDAO.getParticipantDetails();
    }

    /**
     * Retrieves winners and staff information for trivia activities.
     */
    public static void getWinnersAndStaff() {
        informsDAO.getWinnersAndStaff();
    }

    /**
     * Retrieves the number of trivia activities per participant.
     */
    public static void getTriviasPerParticipant() {
        informsDAO.getTriviasPerParticipant();
    }

    /**
     * Retrieves trivia activities that do not have a winner yet.
     */
    public static void getTriviasWithoutWinner() {
        informsDAO.getTriviasWithoutWinner();
    }

    /**
     * Retrieves participant details for a specific activity identified by its ID.
     */
    public static void getParticipantDetailsByActivityId() {
        informsDAO.getParticipantDetailsByActivityId();
    }
}
