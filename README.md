# Student Assessment System

A system for managing college courses and their assessment. Built with Java, Servlets, JSP, JDBC and MySQL.

Admins can manage courses and instructors.

Instructors can manage courses, assessment criteria and student grades.

Students can manage their enrolled courses and view their grades.

### Requires a local MySQL database

Run the `seedDB.sql` script to create the `student_assessment` database and populate its tables.

If you encounter a SQLException while running locally, in the DAO classes set `dbPassword` to your local MySQL password.

[Screenshot of instructor dashboard](./dashboard-screenshot.png)