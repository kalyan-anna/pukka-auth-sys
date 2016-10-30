Feature: Consistent User ID

  Scenario: Consistent User ID for same user and specific business
    Given a user with login name "jeo1" and login source "facebook"
    When logging in using business "initech"
    Then should return a User ID
    When logging in again using same business "initech"
    Then should return same User ID as before
