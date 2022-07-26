@appiumApp @android @appium

  Feature: Testing android app

    Scenario: Verify Add button works in LogTextBox
      Given User navigates to Text page
      And User clicks LogTextBox option
      When User presses the ADD button
      Then This is a test should be displayed