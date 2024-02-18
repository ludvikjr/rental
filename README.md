# Car rental Spring boot REST API
This project is meant to demonstrate my skills in SW development in Unicorn.

## Swagger UI
You can access Swagger UI documentation on /rental/swagger-ui/index.html endpoint.
It contains detailed information about this API.

## Tests
There are tests for controller and service layers in src/test directory.
I have tested only these two layers because DAO (or repository) layer has been provided
by CrudRepository interface provided by Spring.

## Database
Database connection right now is configured to MariaDB dialect. Connection properties can be changed in [application.properties](src/main/resources/application.properties).
Connection is also configured to create tables on build and doesn't need any setup
(except creating database itself and database user).

### Test database
Test database doesn't need any configuration whatsoever. This is achieved by using
H2 in-memory database which also configures itself on build.
If you wish to change the test database properties, they are located in [application-test.properties](./src/main/resources/application-test.properties).

### Insert scripts
Both main and test database execute insert scripts right after tables have been initialized.
They provide easy way to demonstrate the functionality of the application and make tests easier to define.
