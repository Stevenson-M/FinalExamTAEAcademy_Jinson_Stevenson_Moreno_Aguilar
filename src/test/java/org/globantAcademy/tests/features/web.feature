Feature: ESPN webpage navigation review procedure

        We are going to verify several components of the ESPN page
        As users of the website
        We will create a user and navigate within different parts of the website

        Background:
                Given I'm on the main page of the espn website

        Scenario: Validate modal login
                Given I am in the login modal
                Then I should see the login modal with its elements displayed

        Scenario: Validate sing up modal
                Given I am in the login modal
                When I click on the sign up button
                Then I should see the sing up modal with its elements displayed

        Scenario: Validate User creation
                Given I am in the login modal
                When I click on the sign up button
                And I fill the form with valid data
                Then I create a new user

        Scenario: Validate WatchPage
                Given I create a new user successfully
                When I click on the Watch button
                Then I should navigate to the Watch page and validate its elements
                And I should be able to return to the main page
                Then I should see the user icon


        Scenario: Verify Welcome texts when logged
                Given I create a new user successfully
                When I move the mouse over the User menu icon
                Then The welcome text in the menu is displayed along with my name

        Scenario: Verify Welcome texts when logged out
                Given I create a new user successfully
                When I click on the logout button
                And I move the mouse over the User menu icon after logout
                Then The welcome text in the menu is displayed without the user name









