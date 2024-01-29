package com.u2team.huansync.activity.trivia;

import com.u2team.huansync.activity.trivia.controller.TriviaController;
import com.u2team.huansync.activity.trivia.model.Trivia;
import com.u2team.huansync.activity.trivia.model.TriviaBuilderImpl;
import com.u2team.huansync.activity.trivia.question.controller.QuestionController;
import com.u2team.huansync.activity.trivia.question.model.Question;

import java.util.*;

public class TriviaGame {
    public static void initTriviaGame(Long activityId) {
        Scanner scanner = new Scanner(System.in);

        long inchargedId = 1;

        List<TestParticipant> playersRound1 = new ArrayList<>(Arrays.asList(
                new TestParticipant(1, "Juan"),
                new TestParticipant(2, "Cristina"),
                new TestParticipant(3, "Gonzalo"),
                new TestParticipant(4, "Santiago"),
                new TestParticipant(5, "Pedro"),
                new TestParticipant(6, "Camilo"),
                new TestParticipant(7, "Violeta"),
                new TestParticipant(8, "Pedro")
        ));

        List<TestParticipant> playersRound2 = new ArrayList<>();
        List<TestParticipant> playersRound3 = new ArrayList<>();

        List<Question> questions = QuestionController.getAllQuestions();

        List<Question> questionsEasy = new ArrayList<>(questions.stream().filter(question -> "easy".equalsIgnoreCase(question.getDifficulty().getName())).toList());
        List<Question> questionsMedium = new ArrayList<>(questions.stream().filter(question -> "medium".equalsIgnoreCase(question.getDifficulty().getName())).toList());
        List<Question> questionsHard = new ArrayList<>(questions.stream().filter(question -> "hard".equalsIgnoreCase(question.getDifficulty().getName())).toList());

        System.out.println("\n------------ ROUND 1 ------------");
        do {
            int pointsPlayer1 = 0;
            int pointsPlayer2 = 0;

            while (!playersRound1.isEmpty()) {
                int indexQuestion = new Random().nextInt(questionsEasy.size());
                String answer = questionsEasy.get(indexQuestion).getAnswer();

                System.out.println("\n" + questionsEasy.get(indexQuestion).getQuestion());
                System.out.println("Answer: " + answer);
                System.out.print("\n" + playersRound1.get(0).getName() + "'s answer: ");
                String r1 = scanner.nextLine();
                System.out.print(playersRound1.get(1).getName() + "'s answer: ");
                String r2 = scanner.nextLine();

                if (r1.equalsIgnoreCase(answer) || r2.equalsIgnoreCase(answer))
                    questionsEasy.remove(indexQuestion);

                if (r1.equalsIgnoreCase(answer)) {
                    pointsPlayer1++;
                    if (pointsPlayer1 == 3) {
                        System.out.println("\nWINNER: " + playersRound1.get(0).getName());
                        Trivia trivia = new TriviaBuilderImpl().activityId(activityId)
                                .participantOneId(playersRound1.get(0).getParticipantId())
                                .participantTwoId(playersRound1.get(1).getParticipantId())
                                .winnerId(playersRound1.get(0).getParticipantId())
                                .inchargedId(inchargedId)
                                .build();
                        TriviaController.insertTrivia(trivia);
                        playersRound2.add(playersRound1.remove(0));
                        playersRound1.remove(0);
                        break;
                    }
                } else if (r2.equalsIgnoreCase(answer)) {
                    pointsPlayer2++;
                    if (pointsPlayer2 == 3) {
                        System.out.println("\nWINNER: " + playersRound1.get(1).getName());
                        Trivia trivia = new TriviaBuilderImpl().activityId(activityId)
                                .participantOneId(playersRound1.get(0).getParticipantId())
                                .participantTwoId(playersRound1.get(1).getParticipantId())
                                .winnerId(playersRound1.get(1).getParticipantId())
                                .inchargedId(inchargedId)
                                .build();
                        TriviaController.insertTrivia(trivia);
                        playersRound2.add(playersRound1.remove(1));
                        playersRound1.remove(0);
                        break;
                    }
                }

                System.out.println("\nPOINTS");
                System.out.println("Player 1: " + pointsPlayer1);
                System.out.println("Player 2: " + pointsPlayer2);
            }
        } while (!playersRound1.isEmpty());

        System.out.println("\n------------ ROUND 2 ------------");
        do {
            int pointsPlayer1 = 0;
            int pointsPlayer2 = 0;

            while (!playersRound2.isEmpty()) {
                int indexQuestion = new Random().nextInt(questionsMedium.size());
                String answer = questionsMedium.get(indexQuestion).getAnswer();

                System.out.println("\n" + questionsMedium.get(indexQuestion).getQuestion());
                System.out.println("Answer: " + answer);
                System.out.print("\n" + playersRound2.get(0).getName() + "'s answer: ");
                String r1 = scanner.nextLine();
                System.out.print(playersRound2.get(1).getName() + "'s answer: ");
                String r2 = scanner.nextLine();

                if (r1.equalsIgnoreCase(answer) || r2.equalsIgnoreCase(answer))
                    questionsMedium.remove(indexQuestion);

                if (r1.equalsIgnoreCase(answer)) {
                    pointsPlayer1++;
                    if (pointsPlayer1 == 3) {
                        System.out.println("\nWINNER: " + playersRound2.get(0).getName());
                        Trivia trivia = new TriviaBuilderImpl().activityId(activityId)
                                .participantOneId(playersRound2.get(0).getParticipantId())
                                .participantTwoId(playersRound2.get(1).getParticipantId())
                                .winnerId(playersRound2.get(0).getParticipantId())
                                .inchargedId(inchargedId)
                                .build();
                        TriviaController.insertTrivia(trivia);
                        playersRound3.add(playersRound2.remove(0));
                        playersRound2.remove(0);
                        break;
                    }
                } else if (r2.equalsIgnoreCase(answer)) {
                    pointsPlayer2++;
                    if (pointsPlayer2 == 3) {
                        System.out.println("\nWINNER: " + playersRound2.get(1).getName());
                        Trivia trivia = new TriviaBuilderImpl().activityId(activityId)
                                .participantOneId(playersRound2.get(0).getParticipantId())
                                .participantTwoId(playersRound2.get(1).getParticipantId())
                                .winnerId(playersRound2.get(1).getParticipantId())
                                .inchargedId(inchargedId)
                                .build();
                        TriviaController.insertTrivia(trivia);
                        playersRound3.add(playersRound2.remove(1));
                        playersRound2.remove(0);
                        break;
                    }
                }

                System.out.println("\nPOINTS");
                System.out.println("Player 1: " + pointsPlayer1);
                System.out.println("Player 2: " + pointsPlayer2);
            }
        } while (!playersRound2.isEmpty());

        System.out.println("\n------------ ROUND 3 ------------");
        do {
            int pointsPlayer1 = 0;
            int pointsPlayer2 = 0;

            while (!(playersRound3.size() == 1)) {
                int indexQuestion = new Random().nextInt(questionsHard.size());
                String answer = questionsHard.get(indexQuestion).getAnswer();

                System.out.println("\n" + questionsHard.get(indexQuestion).getQuestion());
                System.out.println("Answer: " + answer);
                System.out.print("\n" + playersRound3.get(0).getName() + "'s answer: ");
                String r1 = scanner.nextLine();
                System.out.print(playersRound3.get(1).getName() + "'s answer: ");
                String r2 = scanner.nextLine();

                if (r1.equalsIgnoreCase(answer) || r2.equalsIgnoreCase(answer))
                    questionsHard.remove(indexQuestion);

                if (r1.equalsIgnoreCase(answer)) {
                    pointsPlayer1++;
                    if (pointsPlayer1 == 3) {
                        System.out.println("\nWINNER: " + playersRound3.get(0).getName());
                        Trivia trivia = new TriviaBuilderImpl().activityId(activityId)
                                .participantOneId(playersRound3.get(0).getParticipantId())
                                .participantTwoId(playersRound3.get(1).getParticipantId())
                                .winnerId(playersRound3.get(0).getParticipantId())
                                .inchargedId(inchargedId)
                                .build();
                        TriviaController.insertTrivia(trivia);
                        playersRound3.remove(1);
                        break;
                    }
                } else if (r2.equalsIgnoreCase(answer)) {
                    pointsPlayer2++;
                    if (pointsPlayer2 == 3) {
                        System.out.println("\nWINNER: " + playersRound3.get(1).getName());
                        Trivia trivia = new TriviaBuilderImpl().activityId(activityId)
                                .participantOneId(playersRound3.get(0).getParticipantId())
                                .participantTwoId(playersRound3.get(1).getParticipantId())
                                .winnerId(playersRound3.get(1).getParticipantId())
                                .inchargedId(inchargedId)
                                .build();
                        TriviaController.insertTrivia(trivia);
                        playersRound3.remove(0);
                        break;
                    }
                }

                System.out.println("\nPOINTS");
                System.out.println("Player 1: " + pointsPlayer1);
                System.out.println("Player 2: " + pointsPlayer2);
            }
        } while ((playersRound3.size() != 1));
    }
}