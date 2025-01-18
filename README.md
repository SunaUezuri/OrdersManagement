# Orders Management System

## Introduction
This project is an **Orders Management System** built entirely in English as a personal challenge and practice for both the English language and working with Java using Spring Boot. It integrates a database connection to manage orders and provides a structured backend service.

Any opinions, suggestions, or criticisms are welcome!

---

## Technologies Used
- **Java**: Core programming language.
- **Spring Boot**: Framework for building the application.
- **PostgreSQL**: Relational database for robust data management.
- **Maven**: Dependency and build management.
- **JPA**: Java Persistence API for database interactions.

---

## Dependencies
The project relies on the following main dependencies:

- `spring-boot-starter-data-jpa`
- `spring-boot-starter-web`
- `postgresql` (for database)
- `spring-boot-starter-test`

All dependencies are managed through the `pom.xml` file and can be updated or modified as needed.

---

## Database Information
The project uses **PostgreSQL** as its database. The configuration can be found in the `application.properties` file:

```
spring.datasource.url=jdbc:postgresql://localhost:5432/ordersdb
spring.datasource.username=<your-username>
spring.datasource.password=<your-password>
spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
```

Make sure to replace `<your-username>` and `<your-password>` with your actual database credentials. You must have PostgreSQL installed and the `ordersdb` database created beforehand.

---

## How to Run the Project

### Running in Terminal
1. Open your terminal and navigate to the root directory of the project.
2. Ensure you have Maven and Java installed and properly configured.
3. Use the following commands to run the application:

```bash
# To clean and package the project
mvn clean package

# To run the project
java -jar target/<project-jar-file>.jar
```

Replace `<project-jar-file>` with the actual name of the generated JAR file (e.g., `orders-0.0.1-SNAPSHOT.jar`).

### Running in IntelliJ IDEA
1. Open IntelliJ IDEA and import the project as a Maven project.
2. Wait for IntelliJ to resolve dependencies and index the project.
3. Locate the main application file (e.g., `OrdersApplication.java`) in the `src/main/java` directory.
4. Right-click on the file and select **Run**.

---

## Personal Note
This project was created entirely in English as a way of challenging myself and practicing both the English language and Java with Spring Boot and database integration. Any feedback is greatly appreciated!

