  Feature: Application Login

    Scenario: Home page default plugin

      Given User is on the landing page
      When User login into app with username and password
      Then Home page is populated
      And Cards are displayed