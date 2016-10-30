Feature: Same login name but different source

  Scenario: Same login name but different login source should get different User ID
    Given a user with login name "jeo1" and business "initech"
    When logging in using login source "facebook"
    Then should return a User ID
    When logging in again using login source "google"
    Then should return a User ID
    And should not be same User ID returned for "facebook"