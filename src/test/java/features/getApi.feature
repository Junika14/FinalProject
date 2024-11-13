Feature: API List

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
    "email": "{email}",
    "gender": "male",
    "status": "active",
    }
    """
    When send a post request
    Then  validation status code is equals 201

  @api
  Scenario: update user information with valid data
    Given give the valid url "UPDATE_USER" with id user "7518233"
    And input the body request update :
      """
    {
    "name": "Abadam",
    "email": "{email}",
    "gender": "male",
    "status": "inactive",
    }
    """
    When send put request
    Then  validation status code is equals 200

  @api
  Scenario: Delete data user
    Given give the valid url "CREATE_USER"
    And input the body request :
    """
    {
    "name": "abadam",
    "email": "{email}",
    "gender": "male",
    "status": "active",
    }
    """
    When send a post request
    Then  validation status code is equals 201
    And save the "ID_CREATED" of the newly created user
    Given give the valid url "DELETE_USER" with valid "ID_CREATED"
    When send delete request
    Then  validation status code is equals 204
    And validate that user is deleted


