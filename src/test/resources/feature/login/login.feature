Feature: User login

  Scenario Outline: valid business and login source
    Given a user with login name <login_name>, logging in business <business> and login source as <login_source>
    When logging in
    Then should return a user id

    Examples:
      | login_name | business  | login_source |
      | joe1       | initech   | local        |
      | joe2       | initech   | facebook     |
      | joe3       | initech   | google       |
      | joe4       | initrode  | local        |
      | joe5       | initrode  | facebook     |
      | joe6       | initrode  | google       |

  Scenario Outline: Invalid business or login source
    Given a user with login name <login_name>, logging in business <business> and login source as <login_source>
    When logging in
    Then should return error

    Examples:
      | login_name | business   | login_source |
      | joe1       | invalid    | local        |
      | joe2       | invalid2   | facebook     |
      | joe3       | invalid3   | google       |
      | joe4       | initech    | invalid      |
      | joe5       | initrode   | invalid      |
      | joe6       | initrode   | invalid      |
      | joe6       | invalid    | invalid      |