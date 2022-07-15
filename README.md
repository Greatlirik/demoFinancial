# Crypto financial simpl rest application
Web application development (project demo) :
- backend on Java (Spring Boot, Maven + Lombok)
- database container Docker
- RDBMS PostgreSQL
- Flyway for database-migration

## Functionality
Automatic update of the cryptocurrency rate from a third-party resource. The user can create a record on the coin and receive a notification about its change

## Components


#### Web security
Implemented through Spring Security with the addition of special functionality for the administrator, the addition of a password encoder, and data entry into the database.


#### Controllers
Added controllers and repositories for entities "user", "coin", "recordr" and logic between them.


#### Database
Created a table in the database for each entity, migrations are carried out through flyway

