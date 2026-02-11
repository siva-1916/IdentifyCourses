Feature: Identify Courses and Language Details

  Scenario: Extract Web Development Courses
    Given I am on the Coursera homepage
    When I search for "Web Development"
    And I filter for Level "Beginner" and Language "English"
    Then I capture the first 2 course details
    And I quit from browser

  Scenario: Extract Language Learning Statistics
    Given I am on the Coursera homepage
    When I navigate to Language Learning section
    Then I list all languages and levels with their counts
    And I quit from browser

  Scenario: Validate Enterprise Form Error
    Given I am on the Coursera homepage
    When I navigate to "For Enterprise"
    And I fill the Ready to transform form with invalid email "InValid_Email"
    Then I capture and display the validation error message
    And I quit from browser