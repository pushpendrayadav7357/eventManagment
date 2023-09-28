# University Event Management

University Event Management is a Spring Boot application that allows you to manage students and events within a university. This project uses H2 as the database and enforces various constraints on data validation.



## Technologies Used

- **Spring Boot**: The core framework for building the application.
- **H2 Database**: An in-memory database for storing student and event data.

## Data Models

### Student Model

- `studentId` (Long): Unique identifier for the student.
- `firstName` (String): First name of the student.
- `lastName` (String): Last name of the student.
- `age` (int): Age of the student (must be between 18 and 25).
- `department` (Enum): Department of the student (values: ME, ECE, Civil, CSE).

### Event Model

- `eventId` (Long): Unique identifier for the event.
- `eventName` (String): Name of the event.
- `locationOfEvent` (String): Location of the event.
- `date` (Date): Date of the event.
- `startTime` (Time): Start time of the event.
- `endTime` (Time): End time of the event.

## API Documentation

The application provides the following endpoints for managing students and events:

### Student Endpoints

- `POST /api/students`: Add a new student.
- `PUT /api/students/{studentId}/department`: Update the department of a student.
- `DELETE /api/students/{studentId}`: Delete a student by ID.
- `GET /api/students`: Get a list of all students.
- `GET /api/students/{studentId}`: Get a student by ID.

### Event Endpoints

- `POST /api/events`: Add a new event.
- `PUT /api/events/{eventId}`: Update an event by ID.
- `DELETE /api/events/{eventId}`: Delete an event by ID.
- `GET /api/events/byDate/{date}`: Get a list of all events on a specific date.

## Validation

The following validation rules are enforced:

- Age must be between 18 and 25.
- The first letter of the first name should be capitalized.
- The department must be one of the following values: ME, ECE, Civil, CSE.

