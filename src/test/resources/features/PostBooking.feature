Feature: Create booking

  @PostBooking
  Scenario Outline: Create successful booking
    When I consume the endpoint "<endpoint>" and I send the booking information firstname "<firstname>", lastname "<lastname>", totalprice <totalprice>, depositpaid "<depositpaid>", additionalneeds "<additionalneeds>"
    Then I can validate the response service code <code>

    Examples:
      | endpoint | firstname | lastname | totalprice | depositpaid | additionalneeds | code |
      | /booking | camilo     | perez    | 123        | true        | test            | 200  |