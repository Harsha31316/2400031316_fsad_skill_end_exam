# FSAD End Semester Exam - Hibernate HQL Project

This is a Maven-based Hibernate project that demonstrates Hibernate Query Language (HQL) operations on a Payment entity.

## Prerequisites

- Java 8 or higher
- Maven 3.6 or higher
- MySQL Server running on localhost:3306
- A MySQL database named `fsadendexam`

## Setup

1. Ensure MySQL is running and create the database:
   ```sql
   CREATE DATABASE fsadendexam;
   ```

2. Update the database credentials in `src/main/resources/hibernate.cfg.xml` if necessary:
   - Change `hibernate.connection.username` and `hibernate.connection.password` to your MySQL credentials.

## Running the Project

1. Compile the project:
   ```
   mvn clean compile
   ```

2. Run the ClientDemo class:
   ```
   mvn exec:java -Dexec.mainClass="com.klef.fsad.exam.ClientDemo"
   ```

## What the Program Does

- **Insert Records**: Creates and saves two Payment objects to the database.
- **Delete Record**: Deletes a Payment record with ID 1 using HQL with named parameters.

## Entity Details

The Payment entity includes:
- `id`: Auto-generated integer ID
- `name`: String representing the payment name
- `date`: Date of the payment
- `status`: String representing the payment status (e.g., "Pending", "Completed")

## Troubleshooting

- If you encounter connection issues, verify MySQL is running and credentials are correct.
- Ensure the `fsadendexam` database exists.
- Check for any Hibernate-related errors in the console output.