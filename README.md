### Movie Hall
# Description
Make a movie hall application.

There are X movie halls in a town.

Each movie halls have Y screens.

Each Screen has M seats.

Each Screen has K movies per day with a time slot.

Each seat has a unique ID.

# Use Cases

Customers must be able to log in. using google sign on.

Movie staff also log in using google sign on they will have a ROLE say staff.(manage it internally)

Movie staff can associate/disassociate STAFF role to a user email. [ROLE STAFF]

Master data upload using JSON. (Movie hall time slots for future dates) [ROLE STAFF]

Customers can book seats in a movie screen. [ROLE USER or STAFF]

GET for movie halls. [ROLE USER or STAFF]

GET for the screen in the movie hall. [ROLE USER or STAFF]

GET for available seats in a screen.[ROLE USER or STAFF]

Ability to cancel the booking.[ROLE USER or STAFF]

Ability to get a report on tickets sold in a date.[ROLE STAFF]

Configure payment GW using dummy https://github.com/ShalithaCell/fake-payment-gateway

All endpoints must be authenticated and authorised via JWT.

# Expectations:
0) Make ET diagram.
1) make domain objects
2) make SQL db scripts for read user write user roles and table using liquibase.
3) make swagger.
4) Oauth-2 setup.
5) make controllers and services including junit test case.
6) postman test suite.
7) remove fake payment gateway replace with sandbox paypal/stripe.

Docker compose services
1) PG
2) liquibase
3) Spring boot application.


Use java 8+
Use SpringBoot.

## Instruction.
1) Please fork this project in your git lab.
2) For each task reviewer will create an issue in the project assign it.
3) After completion of each task update the PR in the issue with comments.
4) Use SpringFox for generating swagger documentation
