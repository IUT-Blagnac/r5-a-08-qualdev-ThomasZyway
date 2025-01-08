Feature: Préparation d'une évaluation
  En tant qu'étudiant,
  Je veux suivre mes révisions pour une évaluation
  Afin de m'assurer que je suis bien préparé.

  Scenario: Ajouter une notion à réviser
    Given une liste de révisions vide
    When j'ajoute la notion "Qualité"
    Then la notion "Qualité" est dans la liste des révisions

  Scenario: Marquer une notion comme révisée
    Given une liste de révisions contenant "Qualité"
    When je marque la notion "Qualité" comme révisée
    Then la notion "Qualité" est marquée comme révisée

  Scenario: Vérifier les notions révisées
    Given une liste de révisions contenant "Qualité" et "Bases de données"
    And la notion "Qualité" est marquée comme révisée
    When je vérifie les notions révisées
    Then je dois voir "Qualité" dans la liste des notions révisées
    And je ne dois pas voir "Bases de données" dans la liste des notions révisées
