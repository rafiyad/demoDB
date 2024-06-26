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
