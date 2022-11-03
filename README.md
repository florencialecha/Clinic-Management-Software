# Sessions Booking System
Appointment booking system for a dental clinic. 
[Project done for the Backend I subject, part of the Certified Tech Developer course taken at Digital House.](https://github.com/florencialecha/sessionsBookingSystem/files/9933116/Trabajo.Integrador.Back.End.I.docx.pdf)

We want to implement a system to manage the appointment booking for a dental clinic. It must meet the following requirements:
Dentist data management: list, add, modify and delete dentists. Register dentists' last name, first name and registration number.
Patient data management: list, add, modify and delete patients. For each patient: name, surname, address, ID number and date of discharge are stored.
Register appointment: it must be possible to assign a patient an appointment with a dentist at a certain date and time. 
Login: validate entry to the system by means of a login with username and password. Any logged-in user (ROLE_USER) must be allowed to register an appointment, but only those who have an administration role (ROLE_ADMIN) must be able to manage dentists and patients. A user can have only one role and they will be entered directly into the database.

# Technical Requirements

The application must be developed in layers:

- Business entity layer: these are the Java classes of our business modeled through the object-oriented paradigm.
- Data access layer (Repository): these are the classes that will be in charge of accessing the database.
- Data layer (database): it is the database of our system modeled through an entity-relationship model. We will use the H2 base for its practicality. 
- Business layer: these are the service classes that are responsible for decoupling data access from the view.
- Presentation layer: these are the web screens that we will have to develop using the Spring Boot MVC framework with the controllers and one of these two options: HTML+JavaScript or React for the view.

It is important to perform exception handling by logging any exception that may be generated and performing unit tests to ensure the quality of the developments.
