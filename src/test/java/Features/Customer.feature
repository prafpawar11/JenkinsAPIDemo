Feature: Test End to End all Customer EndPoints

  Scenario: create a new Customer using post Request
    Given user get the RequestSpecification object
    And user request Header as "Content-Type" and "application/json"
    And user add request customer payload from json file by passing "createCustomer" node name
    When user Select HTTP "POST" for Customer Endpoints
    Then user validate status code as 201
    And user validate status line as "201 Created"
    And user validate latency should below 3000 ms
    And user validate "product_Name" and "product_Discount"
    And user validate json Schema from "customerJsonSchema"
    And user generate response log
    And user extract id from customer response payload

  Scenario: retrieve a new Employee using GET Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for customer Endpoints
    When user Select HTTP "GET" for Customer Endpoints
    Then user validate status code as 200
    And user validate status line as "200 OK"
    And user validate latency should below 3000 ms
    And user validate "product_Name" and "product_Discount"
    And user validate json Schema from "customerJsonSchema"
    And user generate response log

  Scenario: update a new Customer using PUT Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for customer Endpoints
    And user request Header as "Content-Type" and "application/json"
    And user add request customer payload from json file by passing "updateCustomer" node name
    When user Select HTTP "PUT" for Customer Endpoints
    Then user validate status code as 200
    And user validate status line as "200 OK"
    And user validate latency should below 3000 ms
    And user validate "product_Name" and "product_Discount"
    And user validate json Schema from "customerJsonSchema"
    And user generate response log

  Scenario: retrieve a new customer using GET Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for customer Endpoints
    When user Select HTTP "GET" for Customer Endpoints
    Then user validate status code as 200
    And user validate status line as "200 OK"
    And user validate latency should below 3000 ms
    And user validate "product_Name" and "product_Discount"
    And user validate json Schema from "customerJsonSchema"
    And user generate response log

  Scenario: delete a new customer using DELETE Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for customer Endpoints
    When user Select HTTP "DELETE" for Customer Endpoints
    Then user validate status code as 200
    And user validate status line as "200 OK"
    And user validate latency should below 3000 ms
    And user generate response log

  Scenario: retrieve a new customer using GET Request
    Given user get the RequestSpecification object
    And user add Request Path Path Parameter for customer Endpoints
    When user Select HTTP "GET" for Customer Endpoints
    Then user validate status code as 404
    And user validate status line as "404 Not Found"
    And user validate latency should below 3000 ms
    And user generate response log
