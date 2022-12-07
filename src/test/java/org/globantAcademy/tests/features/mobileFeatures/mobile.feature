@mobile
Feature: Disney app navigation review

        We are going to verify several elements of the Disney app
        As users of the app
        We will navigate within different parts of the app

        Background:
                Given I'm in the Dashboard screen

        Scenario: Verify Map view
                Given I'm in the Map screen
                Then The Map screen and its elements should be displayed

        Scenario: Verify Map menu category list
                Given I'm in the Map screen
                When I click the category button
                Then Attraction category should be selected by default
                And Hotels category should available in the list

        Scenario: Verify menu dashboard screen
                Given I'm in the dashboard menu screen
                Then the menu screen should be displayed
                And when scroll through the menu
                Then the menu list should be displayed

        Scenario: Verify privacy and legal screen
                Given I'm in the dashboard menu screen
                When I scroll and click the privacy and legal button
                Then the privacy and legal screen should be displayed with its elements

        Scenario: Verify Plans Options screen
                Given I'm in the Plans Options screen
                Then the Plans Options list should be displayed
                And the Reserve Dining Option is in the list


















