package com.u2team.huansync.activity.trivia.model;

import com.u2team.huansync.persistence.BDConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TriviaDAO {

    public List<Trivia> getAllTrivia() {
        List<Trivia> trivias = new ArrayList<>();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_trivias";
            try (Statement statement = connection.createStatement();
                 ResultSet resultSet = statement.executeQuery(sql)) {
                while (resultSet.next()) {
                    Trivia trivia = new Trivia();
                    trivia.setTriviaId(resultSet.getLong("triviaId"));
                    trivia.setActivityId(resultSet.getLong("activityId"));
                    trivia.setParticipantOneId(resultSet.getLong("participantOneId"));
                    trivia.setParticipantTwoId(resultSet.getLong("participantTwoId"));
                    trivia.setWinnerId(resultSet.getLong("winnerId"));
                    trivia.setInchargedId(resultSet.getLong("inchargedId"));
                    trivias.add(trivia);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trivias;
    }

    public Trivia getTriviaById(Long triviaId) {
        Trivia trivia = new Trivia();
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "SELECT * FROM tbl_trivias WHERE triviaId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, triviaId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        trivia.setTriviaId(resultSet.getLong("triviaId"));
                        trivia.setActivityId(resultSet.getLong("activityId"));
                        trivia.setParticipantOneId(resultSet.getLong("participantOneId"));
                        trivia.setParticipantTwoId(resultSet.getLong("participantTwoId"));
                        trivia.setWinnerId(resultSet.getLong("winnerId"));
                        trivia.setInchargedId(resultSet.getLong("inchargedId"));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return trivia;
    }

    public void insertTrivia(Trivia trivia) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "INSERT INTO tbl_trivias (activityId, participantOneId, participantTwoId, winnerId, inchargedId) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, trivia.getActivityId());
                statement.setLong(2, trivia.getParticipantOneId());
                statement.setLong(3, trivia.getParticipantTwoId());
                statement.setLong(4, trivia.getWinnerId());
                statement.setLong(5, trivia.getInchargedId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTrivia(Trivia trivia) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "UPDATE tbl_trivias SET participantOneId = ? , participantTwoId = ? , winnerId = ? , inchargedId = ? WHERE triviaId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, trivia.getParticipantOneId());
                statement.setLong(2, trivia.getParticipantTwoId());
                statement.setLong(3, trivia.getWinnerId());
                statement.setLong(4, trivia.getInchargedId());
                statement.setLong(5, trivia.getTriviaId());
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTrivia(Long triviaId) {
        try (Connection connection = BDConnection.MySQLConnection()) {
            String sql = "DELETE FROM tbl_trivias WHERE triviaId = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setLong(1, triviaId);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
