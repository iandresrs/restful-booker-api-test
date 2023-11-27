Feature: Get a book

  @GetBook
  Scenario: Get a book successfully
    When the user insert id book into url service
    Then service response successfully