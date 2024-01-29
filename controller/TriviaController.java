package com.u2team.huansync.activity.trivia.controller;

import com.u2team.huansync.activity.trivia.model.Trivia;
import com.u2team.huansync.activity.trivia.model.TriviaDAO;

import java.util.List;

/**
 * The {@code TriviaController} class serves as a controller for managing trivia-related operations.
 * It interacts with the underlying data access object (DAO) to perform CRUD operations on trivia entities.
 */
public class TriviaController {

    private static TriviaDAO triviaDAO = new TriviaDAO();

    /**
     * Retrieves a list of all trivia entities.
     *
     * @return A {@code List} of {@code Trivia} objects representing all trivia entities.
     */
    public static List<Trivia> getAllTrivia() {
        return triviaDAO.getAllTrivia();
    }

    /**
     * Retrieves a trivia entity based on the specified trivia ID.
     *
     * @param triviaId The unique identifier of the trivia entity.
     * @return A {@code Trivia} object representing the trivia entity with the given ID, or {@code null} if not found.
     */
    public static Trivia getTriviaById(Long triviaId) {
        return triviaDAO.getTriviaById(triviaId);
    }

    /**
     * Inserts a new trivia entity into the system.
     *
     * @param trivia The {@code Trivia} object to be inserted.
     */
    public static void insertTrivia(Trivia trivia) {
        triviaDAO.insertTrivia(trivia);
    }

    /**
     * Updates an existing trivia entity in the system.
     *
     * @param trivia The {@code Trivia} object to be updated.
     */
    public static void updateTrivia(Trivia trivia) {
        triviaDAO.updateTrivia(trivia);
    }

    /**
     * Deletes a trivia entity based on the specified trivia ID.
     *
     * @param triviaId The unique identifier of the trivia entity to be deleted.
     */
    public static void deleteTrivia(Long triviaId) {
        triviaDAO.deleteTrivia(triviaId);
    }
}
