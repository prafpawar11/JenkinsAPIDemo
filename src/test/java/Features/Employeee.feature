Feature: Test End to End all Employee EndPoints

  Scenario: create a new Employee using post Request
    Given user get the RequestSpecification object
    And user request Header as "Content-Type" and "application/json"
    And user add request payload from json file by passing "createEmployee" node name
    When user Select HTTP "POST" for Employee Endpoints
    Then user validate status code as 201
    And user validate status line as "201 Created"
    And user validate latency should below 3000 ms
    And user validate "firstName" and "lastName" and "address"
    And user validate json Schema from "employeeJsonSchema"
    And user generate response log
    And user extract id from response payload

  Scenario: retrieve a new Employee using GET Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for employee Endpoints
    When user Select HTTP "GET" for Employee Endpoints
    Then user validate status code as 200
    And user validate status line as "200 OK"
    And user validate latency should below 3000 ms
    And user validate "firstName" and "lastName" and "address"
    And user validate json Schema from "employeeJsonSchema"
    And user generate response log

  Scenario: update Employee using put Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for employee Endpoints
    And user request Header as "Content-Type" and "application/json"
    And user add request payload from json file by passing "updateEmployee" node name
    When user Select HTTP "PUT" for Employee Endpoints
    Then user validate status code as 200
    And user validate status line as "200 OK"
    And user validate latency should below 3000 ms
    And user validate "firstName" and "lastName" and "address"
    And user validate json Schema from "employeeJsonSchema"
    And user generate response log

  Scenario: retrieve a new Employee using GET Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for employee Endpoints
    When user Select HTTP "GET" for Employee Endpoints
    Then user validate status code as 200
    And user validate status line as "200 OK"
    And user validate latency should below 3000 ms
    And user validate "firstName" and "lastName" and "address"
    And user validate json Schema from "employeeJsonSchema"
    And user generate response log

  Scenario: delete a new Employee using DELETE Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for employee Endpoints
    When user Select HTTP "DELETE" for Employee Endpoints
    Then user validate status code as 200
    And user validate status line as "200 OK"
    And user validate latency should below 3000 ms
    And user generate response log
    
    
      Scenario: retrieve a new Employee using GET Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for employee Endpoints
    When user Select HTTP "GET" for Employee Endpoints
    Then user validate status code as 404
    And user validate status line as "404 Not Found"
    And user validate latency should below 3000 ms
    And user generate response log
