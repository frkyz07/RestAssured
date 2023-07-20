  Feature: Application Login

    Scenario: Home page default plugin

      Given User is on the landing page
      When User login into app with username "elma" and password "armut"
      Then Home page is populated
      And Cards are displayed "true"

    Scenario: Home page default plugin

      Given User is on the landing page
      When User login into app with username "kedi" and password "kopek"
      Then Home page is populated
      And Cards are displayed "false"