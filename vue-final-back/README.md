
# Reminders Backend - Java Spring Application

## Overview

This is the **backend** service for the **Reminders App**, developed using **Java Spring Boot**. It provides a REST API for managing reminders, including CRUD operations and user authentication using **OAuth 2.0**. The backend communicates with the frontend built in Vue 3, enabling users to store, retrieve, and manage their reminders securely.

The project supports role-based access control and uses **MySQL**, with **Spring Security** handling authentication and authorization.

## Table of Contents

- [Features](#features)
- [Tech Stack](#tech-stack)
- [Setup](#setup)
- [API Documentation](#api-documentation)
- [Security](#security)
- [Development Workflow](#development-workflow)
- [Improvements](#improvements)

## Features

1. **REST API**: Provides endpoints to create, read, update, and delete reminders.
2. **User Authentication**: Secure login and token-based authentication using **OAuth 2.0**.
3. **Role-based Access Control**: Differentiates access between regular users and admins. *(Still in Development)
4. **Database Management**: Utilizes **Hibernate** for ORM and MySQL Driver.
5. **DataLoader**: Populates the database with initial test data for development.

## Tech Stack

- **Java 17**
- **Spring Boot 3**
- **Spring Security** (OAuth 2.0)
- **Hibernate** (ORM)
- **MySQL**
- **Maven** (for dependency management)

## Setup

### Prerequisites

- Java JDK 17+
- Maven installed

### Running the Backend Locally

1. Clone the repository:
   ```bash
   git clone https://github.com/FranRevi8/Reminders-backend.git
   cd Reminders-backend
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Access the **MySQL database** (credentials can be found in `application.properties`).

## API Documentation

### Reminder Endpoints

- **GET /reminders**: Get all reminders for the authenticated user.
- **POST /reminders**: Create a new reminder.
- **GET /reminders/{id}**: Get a specific reminder by ID.
- **PUT /reminders/{id}**: Update an existing reminder.
- **DELETE /reminders/{id}**: Delete a reminder.

### User Endpoints

- **POST /new-account**: Create a new user account.
- **POST /api/login**: Authenticate and receive a JWT token.

## Security

- **Authentication**: OAuth 2.0 is implemented using **JWT (JSON Web Token)**. When a user logs in, the backend issues a JWT, which the frontend uses for subsequent requests.
  
- **Authorization**: Each API endpoint is secured, requiring a valid JWT for access. Additionally, role-based access control ensures that sensitive operations can only be performed by authorized users (e.g., admin roles).

### Example JWT Token Flow:

1. User logs in via `/api/auth/login`.
2. Backend issues a JWT token.
3. Frontend stores the token and includes it in the `Authorization` header for subsequent API requests.
4. Backend validates the token for each incoming request.

## Development Workflow

1. **Project Initialization**: The backend was set up using **Spring Initializr**, with the necessary dependencies for **Spring Web**, **Spring Security**, and **JPA** added.

2. **Reminder Model**: 
   - Defined as a JPA entity with fields like `list`, `name`, `dueDate`, `completedState`, and associations with users.
   - Mapped to the database using Hibernate.

3. **Reminder CRUD Operations**: 
   - A `ReminderController` was created to handle HTTP requests and map them to the corresponding service methods.
   - The `ReminderService` contains the business logic for managing reminders.
   - `ReminderRepository` interfaces with the database.

4. **Security Implementation**: 
   - **OAuth 2.0** and JWT were integrated for authentication.
   - The security configuration (`SecurityConfig`) defines access rules and configures authentication filters.

5. **Database Configuration**: 
   - Used MySQL Driver to access the database.
   - A `DataLoader` was added to populate the database with initial data for testing.

6. **Testing and Debugging**: 
   - Testing endpoints using **Postman** and debugging through logs.
   - Fixed issues with token expiration, refresh tokens, and added better error handling.

## Next Improvements

- **Token Refresh Mechanism**: Implement a refresh token strategy to allow long-lived sessions without requiring frequent logins.
- **Rate Limiting**: Add rate limiting to protect the API from abuse.
- **API Documentation**: Use **Swagger** for better API documentation and testing.
