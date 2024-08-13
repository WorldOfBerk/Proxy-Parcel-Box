# Proxy-Parcel-Box

## Overview

ProxyParcelBox is a web application designed to facilitate communication between neighbors for package deliveries. Users can share delivery information and send real-time messages using tracking numbers. The application automatically sends an email when a chat room is created, and if the user subscribes to the chat, they receive email notifications for every new message in that chat room. Additionally, the application generates a QR code for each chat room, allowing easy access via scanning.

[Jump to Installation!](#installation)

## Features

- **Real-time Messaging**: Users can send and receive messages instantly using WebSocket.
- **Automated Email Notifications**: Emails are automatically sent when a chat room is created, and subscribers receive notifications for each new message.
- **QR Code Generation**: Each chat room has a unique QR code for quick access.
- **User-friendly Interface**: Simple and intuitive UI designed with FreeMarker and CSS.
- **Backend and Frontend Separation**: Clear distinction between backend services and frontend rendering.

## Technologies Used

### Backend

- **Spring Boot**: Provides the main framework for developing the application.
- **Kotlin**: The programming language used to write the application.
- **Gradle**: Build automation tool used to manage dependencies and build the project.
- **PostgreSQL**: Relational database system used for storing data.
- **Docker & Docker Compose**: Used to containerize the application and manage multi-container Docker applications.
- **Nginx**: Web server used to handle requests and serve static content.

### Frontend

- **FreeMarker**: Template engine used for rendering dynamic HTML content.
- **JavaScript & WebSocket**: Used to implement real-time messaging functionality.
- **CSS**: Styling and layout of the application.
- **QR Code API**: External API used to generate QR codes for chat rooms.

## Deployment

The application was successfully deployed using Docker Compose on an Ubuntu server provided during the course. The deployment process includes setting up containers for the Spring Boot application, PostgreSQL database, and Nginx server.

## Getting Started

### Prerequisites

- **Docker** and **Docker Compose** installed on your machine.
- **Java 11** or higher.

### Installation

1. Clone the repository:
   ```bash
   git clone https://github.com/yourusername/proxyparcelbox.git
   cd proxyparcelbox

## Configuration

Before running the application, you'll need to configure the database settings, email credentials, and other environment-specific variables.

### 1. Docker Compose Configuration

The `docker-compose.yml` file is used to set up the containers for the application. Here are the key environment variables that need to be configured:

- **POSTGRES_DB**: The name of the database.
- **POSTGRES_USER**: The username for accessing the database.
- **POSTGRES_PASSWORD**: The password for the database user.
- **PGADMIN_DEFAULT_EMAIL**: The email address for accessing pgAdmin.
- **PGADMIN_DEFAULT_PASSWORD**: The password for the pgAdmin user.

### 2. Application Properties

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/your_database_name
spring.datasource.username=your_database_user
spring.datasource.password=your_secure_password

spring.mail.host=smtp.your-email-provider.com
spring.mail.port=587
spring.mail.username=your_email@example.com
spring.mail.password=your_email_password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```
### 3. Running the Application
Once you've configured the docker-compose.yml and application.properties files with your own credentials and information, you can build and run the application with Docker Compose:
```bash
docker-compose up --build
```
## Access

Once the application is up and running, you can access the different services through the following ports:

- **Application Frontend** (port 8080): Accessible at `http://localhost:8080`.

- **pgAdmin** (port 9001): Accessible at `http://localhost:9001`.