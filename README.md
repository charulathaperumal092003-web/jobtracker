# Job Tracker API

A REST API to track job applications, built with Spring Boot. Users register, log in to get a JWT token, and use it to manage their job applications.

## Tech Stack
- Java 17
- Spring Boot, Spring Data JPA, Spring Security
- MySQL
- JWT (jjwt) and BCrypt password encryption
- Maven

## Features
- CRUD for job applications
- DTO validation
- Global exception handling (400 and 404 responses)
- User registration with BCrypt-encrypted passwords
- Login with JWT authentication
- JWT filter protecting all `/api/jobs/**` endpoints

## How to Run
1. Install Java 17 and MySQL.
2. Create the database:
```sql
   CREATE DATABASE jobtracker;
```
3. Open `src/main/resources/application.properties` and set your MySQL username and password.
4. Run `JobtrackerApplication` from your IDE, or run `mvn spring-boot:run`.
5. The API starts at `http://localhost:8080`.

## API Endpoints

### Auth (no token needed)
| Method | URL | Description |
|--------|-----|-------------|
| POST | `/api/auth/register` | Register a new user |
| POST | `/api/auth/login` | Log in and get a JWT token |

### Jobs (token required)
Add the header `Authorization: Bearer <your-token>`.

| Method | URL | Description |
|--------|-----|-------------|
| POST | `/api/jobs` | Create a job application |
| GET | `/api/jobs` | Get all job applications |
| GET | `/api/jobs/{id}` | Get one job application |
| PUT | `/api/jobs/{id}` | Update a job application |
| DELETE | `/api/jobs/{id}` | Delete a job application |

## Example Requests

Register:
```json
{ "name": "Test User", "email": "test@example.com", "password": "secret123" }
```

Login:
```json
{ "email": "test@example.com", "password": "secret123" }
```

## Error Responses
- `400` validation error
- `404` job not found
- `403` missing or invalid token