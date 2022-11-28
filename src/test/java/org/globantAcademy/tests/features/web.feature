Feature: ESPN webpage procedure review


        Scenario: Validate modal login
        Given I'm on the main page of the espn website
        When I click on the login button
        Then I should see the login modal with the following elements:
        | Username | Password | Login Button | Sing Up |






