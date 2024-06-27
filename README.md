# Setting Up and Running a Java Project with PostgreSQL
## Download only the zip file and extract in your computer if total project missing any file
This guide will walk you through setting up a Java project using Java 17 or later, integrating it with PostgreSQL, importing it into IntelliJ IDEA (or Eclipse), and testing the necessary APIs.

## Prerequisites

- **Java Development Kit (JDK) 17 or later** installed.
  - You can download it from [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html) or [AdoptOpenJDK](https://adoptopenjdk.net/).

- **IDE (IntelliJ IDEA or Eclipse)** installed.
  - Download IntelliJ IDEA from [JetBrains](https://www.jetbrains.com/idea/download/) or Eclipse from [Eclipse IDE](https://www.eclipse.org/downloads/).

- **PostgreSQL** or MySQL installed locally or accessible remotely.
  - PostgreSQL can be downloaded from [PostgreSQL Downloads](https://www.postgresql.org/download/) and MySQL from [MySQL Downloads](https://dev.mysql.com/downloads/).

- **Postman** or similar tool for testing APIs.
  - Download Postman from [Postman Downloads](https://www.postman.com/downloads/).

## Step-by-Step Guide

### 1. Install Java Development Kit (JDK) 17

- Download and install JDK 17 or later according to your operating system.

### 2. Import Project into IDE

#### IntelliJ IDEA:

1. Open IntelliJ IDEA.
2. Choose "Open" from the welcome screen or select "File" -> "Open" from the menu.
3. Navigate to the project directory and select it.
4. IntelliJ IDEA will automatically import the project.

#### Eclipse:

1. Open Eclipse IDE.
2. Select "File" -> "Import" from the menu.
3. Choose "Existing Gradle Project" or "Existing Maven Project" depending on your project setup.
4. Navigate to the project directory and select it.
5. Eclipse will import the project.

### 3. Configure Database Connection

- Open `application.properties` or `application.yml` located in `src/main/resources` of your project.

#### For PostgreSQL:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/teamcollab
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
```
### 4. Start the Project
Run the main class of your Spring Boot application (usually Application.java or similarly named class with @SpringBootApplication annotation).

### 5.Test APIs
Open Postman or a similar tool.
Test the APIs available at `http://localhost:8091`.
Send requests to endpoints to verify functionality and data retrieval.
- Users
Register User (POST /api/users/register/): Create a new user.
Login User (POST /api/users/login/): Authenticate a user and return a token.
Get User Details (GET /api/users/{id}/): Retrieve details of a specific user.
Update User (PUT/PATCH /api/users/{id}/): Update user details.
Delete User (DELETE /api/users/{id}/): Delete a user account.
- Projects
List Projects (GET /api/projects/): Retrieve a list of all projects.
Create Project (POST /api/projects/): Create a new project.
Retrieve Project (GET /api/projects/{id}/): Retrieve details of a specific project.
Update Project (PUT/PATCH /api/projects/{id}/): Update project details.
Delete Project (DELETE /api/projects/{id}/): Delete a project.
- Task
List Tasks (GET /api/projects/{project_id}/tasks/): Retrieve a list of all tasks in
a project.
Create Task (POST /api/projects/{project_id}/tasks/): Create a new task in a
project.

Retrieve Task (GET /api/tasks/{id}/): Retrieve details of a specific
task. Update Task (PUT/PATCH /api/tasks/{id}/): Update task details.
Delete Task (DELETE /api/tasks/{id}/): Delete a task.
