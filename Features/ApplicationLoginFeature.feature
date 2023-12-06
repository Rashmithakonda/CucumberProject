#Author: BharathTechAcademy@gmail.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
Feature: Parabank Login Feature
  I want to use this feature file to validate login feature of parabank application

  Background: Initialize all pages and launch the Application
    Given Initialize all pages
    And Launch the application using "https://parabank.parasoft.com/parabank/index.htm"
    When Application launched with the title "ParaBank | Welcome | Online Banking"

  @Sanity1
  Scenario: Verify Application Logo and Caption
    Then application logo should be displayed in login page
    And application caption should be displayed as "Experience the difference"

  @Samoke
  Scenario: Verify Application Login Page Header
    Then application login page header should be displayed as "Customer Login"

  @Sanity @Regression
  Scenario: Verify Application Registration Feature
    When user navigates to registration page
    Then registration page should be launched
    When user updates the registration details with "Administrator" and "admin123"
    And click on register button
    Then registration should be successful

  @Regression
  Scenario Outline: Verify Login Feature
    When User enters <Username> and <Password>
    And click on login button
    Then login should be successful

    Examples: 
      | Username      | Password |
      | Administrator | admin123 |
      | abcd          | abcd123  |
