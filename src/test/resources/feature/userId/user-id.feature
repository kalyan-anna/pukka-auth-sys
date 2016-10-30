Feature: User ID generation

  Scenario: Same user (login name + login source) logging in using different business
    Given a user with login name "jeo1" and login source "facebook"
    When logging in using business "initech"
    Then should return a User ID
    When logging in using business "initrode"
    Then should return a User ID
    But should not be same User ID returned for business "initech"

  Scenario: Consistent User ID for same user (login name + login source) and specific business
    Given a user with login name "jeo1" and login source "facebook"
    When logging in using business "initech"
    Then should return a User ID
    When logging in again using business "initech"
    Then should return same User ID as before

  Scenario: Same login name but different login source should get different User ID
    Given a user with login name "jeo1" and business "initech"
    When logging in using login source "facebook"
    Then should return a User ID
    When logging in using login source "google"
    Then should return a User ID
    But should not be same User Id returned for login source "facebook"

  Scenario: User ID format
    Given a user with login name "jeo1", business "initech" and login source "facebook"
    When logging in
    Then should return a User ID
    And User ID should only be ASCII case-sensitive alphanumeric strings or numbers
