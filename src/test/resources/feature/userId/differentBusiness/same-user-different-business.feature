Feature: Same user different business

  Scenario: Same user logging in using different business
    Given a user with login name "jeo1" and login source "facebook"
    When logging in using business "initech"
    Then should return a User ID
    When logging in using business "initrode"
    Then should return a User ID
    And should not be same User ID returned for business "initech"

