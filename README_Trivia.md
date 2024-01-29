# Trivia Section for Java Project

## Overview
Welcome to the Trivia Section of our Java project, where we've crafted a captivating and interactive trivia game. This section features anime-themed questions, comprehensive trivia reports, and a competitive trivia game mechanism. It's designed for groups of eight players, battling in pairs until one emerges as the champion. Additionally, we maintain a meticulous record of all trivia activities in our database.

## OOP Implementation
We've embraced Object-Oriented Programming (OOP) principles for the development of this section. The classes are designed to be independent and easily readable, with clear method implementations. A notable use of inheritance is evident where the `Trivia` class is a subclass of `Activity`, showcasing polymorphism.

### Highlights

- **Anime-Themed Questions:** Immerse yourself in a diverse range of trivia questions themed around the captivating world of Anime. This feature promises to challenge and entertain anime aficionados.

- **Trivia Reports:** Generate in-depth reports of trivia contests, covering aspects like player scores, performance analytics, and question breakdowns.

- **Trivia Gameplay:** Experience the thrill of our trivia game, where eight participants engage in head-to-head matches, striving to be the last one standing.

- **Database Management:** Our robust database system efficiently logs every aspect of trivia activities, ensuring comprehensive record-keeping for analysis and reference.

## Core Classes

1. **Trivia.java:** This class forms the backbone of the trivia game, encapsulating its primary functionalities.

2. **TriviaBuilderImpl.java:** Implements the Builder pattern to streamline the creation of Trivia objects, enhancing flexibility and ease of use.

3. **Questions.java:** A dedicated class for managing trivia questions, including their organization and retrieval.

4. **Informs.java:** Focuses on generating and administering reports and data related to trivia sessions.

5. **TriviaDAO.java:** Acts as the Data Access Object (DAO), managing all database interactions related to trivia.

## Enums

1. **CategoryQuestion.java:** Categorizes trivia questions into distinct types for an organized question pool.

2. **DifficultyQuestion.java:** Defines the difficulty levels of trivia questions, adding a layer of complexity to the game.

## Design Pattern

- **Builder:** Implemented in the Trivia class to manage complex object creation and enhance code readability.

## SOLID Principles

- **Interface Segregation Principle:** Applied to improve code readability and enforce a template that mandates the use of all created methods.

## Package Structure

Navigate through the Trivia section in our project repository:

      Trivia

      ├─ Controller
      ├─ img
      ├─ model
      ├─ questions
      ├─ TestParticipants.java
      ├─ TriviaGame.java
      ├─ TriviaManagement.java

# Class Diagram

![](.\img\ClassDiagram.jpg)