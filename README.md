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

## Flow of APIs
### User APIs
1) call /movie-hall/{townId} to get all the movie halls in a town  
2) call /available-screen/{movieHallId} to get the available screens for book tickets in a movie hall. 
3) call /seat/{scheduleId} to get the available seats for the selected show(scheduleId)
4) call /book-ticket to book the ticket for the selected seats and show 
5) call /cancel-ticket/{ticketId} to cancel the booked ticket 

### Admin APIs
1) call /admin/ticket-report/{hallId}/{date} to generate the report 
2) call /admin/user/{emailId}/{roleId} to update the role

#### Upload movie schedules flow
1) call /admin/movie to get the latest movies
2) call /admin/screen/{movieHallId} to get all the screen for the selected movie hall
3) call /movie-upload to upload new movie schedules(shows) with selected movies and screens

## Instruction to generate swagger
1) Add SpringFox dependency
2) Add SwaggerConfiguration class in which we add controller package for which we want to add swagger documentation, API URLs to be included in the swagger and general information(title, description) regarding the swagger document.
3) Use below annotations to customise the swagger documentation
   1) @Api - to give information regarding the controller
   2) @ApiOperation - to give  information regarding the API
   3) @ApiResponses - to mention the status codes of the API
