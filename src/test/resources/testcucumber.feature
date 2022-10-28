Feature: Add two numbers
  This is to add two numbers

  Scenario Outline: add two numbers
    Given I have 2 numbers <First> and <Second>
    When I add these 2 numbers<First> and <Second>
    Then I get result as <Result>
    Examples:
    / First / Second / Result /
    / 100 / 200 / 300 /


