/**
 * The `TriviaManagement` class provides a console-based user interface for managing trivia activities.
 * Users can add, list, update, and delete trivia activities through a menu-driven interface.
 */
package com.u2team.huansync.activity.trivia;

import com.u2team.huansync.activity.controller.ActivityController;
import com.u2team.huansync.activity.model.Activity;
import com.u2team.huansync.activity.model.TypeActivity;
import com.u2team.huansync.activity.trivia.model.Trivia;

import java.time.LocalTime;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class TriviaManagement {
    private static final Scanner SCANNER = new Scanner(System.in);

    /**
     * Initializes the trivia management application and provides a menu for users to perform various actions related to trivia activities.
     */
    public static void initAppTrivia() {
        while (true) {
            System.out.println("""
                                        
                    ------------ TRIVIA MANAGEMENT ------------
                                        
                    Choose the action to do:
                    1. Add new trivia
                    2. List all trivias to play
                    3. Update trivia
                    4. Delete trivia
                    5. << Back
                    """);
            System.out.print("Option: ");
            try {
                int option = SCANNER.nextInt();
                SCANNER.nextLine();

                if (option == 5) {
                    System.out.println("\nGoing back...");
                    break;
                } else if (option == 1) {
                    addTrivia();
                } else if (option == 2) {
                    listTriviasToPlay();
                } else if (option == 3) {
                    updateTrivia();
                } else if (option == 4) {
                    deleteTrivia();
                } else {
                    throw new Exception("\nError: The option entered is not valid.");
                }
            } catch (InputMismatchException e) {
                SCANNER.nextLine();
                System.out.println("\nError: The character entered is not valid.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * Adds a new trivia activity by collecting necessary information from the user.
     *
     * @throws Exception If there is an error in the input or during the activity creation.
     */
    private static void addTrivia() throws Exception {
        System.out.println("\n------------ ADD TRIVIA ------------\n");
        System.out.print("Enter the trivia name: ");
        String nameActivity = SCANNER.nextLine();

        if (nameActivity.isBlank())
            throw new Exception("\nError: Trivia name mustn't be empty.");

        System.out.print("Enter the start time (HH:MM): ");
        String startTime = SCANNER.nextLine();
        LocalTime startTimeParsed = null;
        try {
            startTimeParsed = LocalTime.parse(startTime);
        } catch (Exception e) {
            throw new Exception("\nError: Start time not valid.");
        }

        System.out.print("Enter the trivia price: ");
        double price = SCANNER.nextDouble();
        SCANNER.nextLine();

        if (price < 0)
            throw new Exception("\nError: Trivia price cannot be less than 0.");

        Activity trivia = new Trivia(nameActivity, TypeActivity.TRIVIA, null, 8, null, startTimeParsed, price, true);
        ActivityController.insertActivity(trivia);
    }

    /**
     * Lists all available trivias to play and prompts the user to select a trivia for playing.
     *
     * @throws Exception If there are no available trivias or if the selected trivia does not exist.
     */
    private static void listTriviasToPlay() throws Exception {
        System.out.println("\n------------ TRIVIAS TO PLAY ------------\n");

        List<Activity> triviasToPlay = listTrivias();
        if (triviasToPlay.isEmpty())
            throw new Exception("\nMensaje: There's no trivias to play.");

        System.out.print("\nEnter the trivia ID to play: ");
        long triviaId = SCANNER.nextLong();
        SCANNER.nextLine();

        boolean exists = triviasToPlay.stream().anyMatch(trivia -> trivia.getActivityId() == triviaId);

        if (!exists)
            throw new Exception("\nError: Entered trivia doesn't exist.");

        TriviaGame.initTriviaGame(triviaId);
    }

    /**
     * Updates an existing trivia activity by collecting updated information from the user.
     *
     * @throws Exception If there is an error in the input, if there are no trivias to update, or if the selected trivia does not exist.
     */
    private static void updateTrivia() throws Exception {
        System.out.println("\n------------ UPDATE TRIVIA ------------\n");

        List<Activity> triviasToUpdate = listTrivias();
        if (triviasToUpdate.isEmpty())
            throw new Exception("\nMensaje: There's no trivias to update.");

        System.out.print("\nEnter the trivia ID to update: ");
        long triviaId = SCANNER.nextLong();
        SCANNER.nextLine();

        boolean exists = triviasToUpdate.stream().anyMatch(trivia -> trivia.getActivityId() == triviaId);

        if (!exists)
            throw new Exception("\nError: Entered trivia doesn't exist.");

        Activity triviaToUpdate = ActivityController.getActivityById(triviaId);

        System.out.println("\nOld name: " + triviaToUpdate.getNameActivity());
        System.out.print("Enter new name: ");
        String newNameActivity = SCANNER.nextLine();

        if (newNameActivity.isBlank())
            throw new Exception("\nError: Trivia name mustn't be empty.");

        System.out.println("\nOld start time: " + triviaToUpdate.getStartTime());
        System.out.print("Enter new start time (HH:MM): ");
        String newStartTime = SCANNER.nextLine();
        LocalTime newStartTimeParsed = null;
        try {
            newStartTimeParsed = LocalTime.parse(newStartTime);
        } catch (Exception e) {
            throw new Exception("\nError: Start time not valid.");
        }

        System.out.println("\nOld price: " + triviaToUpdate.getPrice());
        System.out.print("Enter new trivia price: ");
        double newPrice = SCANNER.nextDouble();
        SCANNER.nextLine();

        if (newPrice < 0)
            throw new Exception("\nError: Trivia price cannot be less than 0.");

        triviaToUpdate.setNameActivity(newNameActivity);
        triviaToUpdate.setStartTime(newStartTimeParsed);
        triviaToUpdate.setPrice(newPrice);

        ActivityController.updateActivity(triviaToUpdate);
    }

    /**
     * Deletes an existing trivia activity by prompting the user to select a trivia for deletion.
     *
     * @throws Exception If there are no trivias to delete or if the selected trivia does not exist.
     */
    private static void deleteTrivia() throws Exception {
        System.out.println("\n------------ DELETE TRIVIA ------------\n");

        List<Activity> triviasToDelete = listTrivias();
        if (triviasToDelete.isEmpty())
            throw new Exception("\nMensaje: There's no trivias to delete.");

        System.out.print("\nEnter the trivia ID to delete: ");
        long triviaId = SCANNER.nextLong();

        boolean exists = triviasToDelete.stream().anyMatch(trivia -> trivia.getActivityId() == triviaId);

        if (!exists)
            throw new Exception("\nError: Entered trivia doesn't exist.");

        ActivityController.deleteActivity(triviaId);
    }

    /**
     * Lists all available trivias to play and returns the list of activities.
     *
     * @return The list of trivias available to play.
     */
    private static List<Activity> listTrivias() {
        List<Activity> triviasToPlay = ActivityController.getAllActivities().stream()
                .filter(activity -> !activity.isCompleted() && activity.getTypeActivity().getName().equalsIgnoreCase("trivia")).toList();

        for (Activity trivia : triviasToPlay) {
            System.out.println(trivia.getActivityId() + ". Name: " + trivia.getNameActivity() + ", Start: " + trivia.getStartTime());
        }

        return triviasToPlay;
    }
}
