 Feature: Ordance Survey website

  Background: 
    Given User is on the webpage

  @HomepageVerify
  Scenario: Verify items on page
    And user can verify title page and see the welcome text

  @API_dashboard
  Scenario: Navigates through header menu
    When user clicks on API Dashboard
    Then user should see a welcome to OS data hub message

  @Download
  Scenario: Navigates through header menu
    When user clicks on download
    Then user should see OS OpenData Download

  @Docs
  Scenario: Verify items on the side menu of 'Docs' page
    When user clicks on Docs page
    And User verifies items on the side menu
    Then user should be able to expand listed sections under OS features API
