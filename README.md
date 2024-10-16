# Reminders App - Fullstack Web Application

By [Francisco Revidiego](https://www.linkedin.com/in/fran-revidiego/) (FranRevi8) 10/2024

## Overview

**IronReminders App** is a web application that helps users organize their tasks by creating, modifying, and categorizing reminders. The app is inspired by Apple's Reminders app and allows users to manage their tasks with custom lists, filters, and urgent notifications.

The frontend is developed using **Vue 3**, while the backend is powered by **Java Spring**, with communication between the two established via REST API. The application supports user authentication using **OAuth 2.0** and role-based authorization, ensuring secure access to user data.

This repository contains all the **frontend** and **backend** portions of the project, but they born separately in first place. You can find the backend repository [here](https://github.com/FranRevi8/Reminders-backend), and the frontend repository [here](https://github.com/FranRevi8/midterm-to-do-list). (If you want to see the complete development process)

## Table of Contents

- [Usage](#usage)
- [Features](#features)
- [Tech Stack](#tech-stack)
- [Setup](#setup)
- [Development Workflow](#development-workflow)
- [Backend Development](#backend-development)
- [Improvements](#improvements)

## Usage

Upon accessing the app, users are directed to the **Login** page. New users can create an account via the **Sign Up** form.

After logging in, users can:

- **Create a new reminder** by clicking the "New Reminder" button.
- **Complete or uncomplete reminders** using the green button on each reminder.
- **Edit** a reminder using the blue button or **delete** it with the trash icon.
- **Organize reminders by lists**, with each list acting as a folder.
- **Filter reminders** to view by specific lists, all reminders, or only urgent ones (past due).
- **Toggle between completed and incomplete reminders** using the "Show Completed" button.
- **Log out** by clicking the "Logout" button to return to the login page.

## Features

1. **User Authentication**: Secure login and sign-up functionality.
2. **Reminder Management**: Create, edit, complete, delete, and categorize reminders.
3. **List-Based Organization**: Reminders can be organized into custom lists for better task management.
4. **Urgent Reminders**: Reminders with passed due dates are highlighted in an "Urgent" section.
5. **Responsive Design**: Mobile-friendly interface with smooth transitions and interactions. (Still in development)
6. **OAuth 2.0 Security**: Secure backend integration for user authentication and authorization.

## Tech Stack

### Frontend

- **Vue 3**: Working in a SPA.
- **Vue Router**: For routing between pages (login, home, etc.).
- **CSS**: Custom styles and animations.

### Backend

- **Java Spring Boot**
- **Spring Security**: OAuth 2.0 for authentication and role-based access control.
- **Hibernate**: For ORM and database management.
- **MySQL Driver**: In-memory database for development.

## Setup

### Prerequisites

- Node.js and npm installed
- Java (JDK 17 or above)
- Maven for backend

### Frontend Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/FranRevi8/Reminders-frontend.git
   cd Reminders-frontend
   ```

2. Install dependencies:

   ```bash
   npm install
   ```

3. Run the development server:
   ```bash
   npm run serve
   ```

### Backend Setup

The backend must be running for the frontend to function properly. Follow the instructions in the backend repository to set up and run the backend server: [Reminders-backend](https://github.com/FranRevi8/Reminders-backend).

## Development Workflow

1. **Project Architecture**: The project began with defining its architecture. Core functionalities were documented, and the design was loosely inspired by Apple’s Reminders app.

2. **Frontend Development**:

   - Initial development started with building the **views** and **components** in Vue 3.
   - Mock data was used to simulate the reminder list, stored in the `HomeView` as a local array.
   - Components such as `ReminderComponent` and `TypesList` were created to handle the display and management of reminders.
   - A **store** was introduced to centralize state management and handle data flow across components.

3. **Backend Integration**:

   - Once the frontend was functional with mock data, the backend was developed using Java Spring.
   - A **CRUD API** was implemented to manage reminders, and **fetch** requests were integrated into the frontend for seamless interaction with the backend.
   - Debugging focused on solving asynchronous issues, followed by connecting the store to the API.

4. **Security**:

   - OAuth 2.0 security was implemented to secure user data and handle authentication using **Spring Security**.
   - The frontend login and sign-up flows were adjusted to accommodate the OAuth integration, with **token handling** added to the store.

5. **Debugging & Optimization**:
   - Both the frontend and backend underwent rounds of debugging to fix bugs and optimize performance.
   - Final adjustments focused on enhancing the **CSS**, including transitions and ensuring a responsive design.

## Backend Development

The backend consists of:

- **Reminder Entity**: Represents the reminder model.
- **Reminder Controller**: Handles HTTP requests and routes for reminders.
- **Reminder Service**: Business logic for managing reminders.
- **Reminder Repository**: Interacts with the database to perform CRUD operations.
- **Security Configuration**: Manages OAuth 2.0 security settings.
- **DataLoader**: Loads initial data into the database for testing and development purposes.

## Next Improvements

- **Real-time Sync**: Implement WebSockets or Server-Sent Events (SSE) for real-time updates when reminders are created, edited, or completed.
- **Notifications**: Add push notifications to remind users of upcoming or urgent tasks.
- **Multi-User Collaboration**: Allow sharing lists or reminders between multiple users for collaborative task management.
