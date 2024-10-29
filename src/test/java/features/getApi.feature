Feature: Get List

  @api
  Scenario: get list all users
    Given give the valid url "GET_USERS"
    And hit api get all users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_all_user.json"

  @api
  Scenario: create user with input valid data
    Given give the valid url "CREATE_USER"
    And input the body request :
    """
    {
    "name": "abadam",
    "email": "abadam@example.com",
    "gender": "male",
    "status": "active",
    }
    """
  When send a post request
  Then validation status code is equals 201