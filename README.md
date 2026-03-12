# SecureAuth - JWT Authentication API

SecureAuth is a backend REST API built with Spring Boot that provides secure user authentication using JWT (JSON Web Token).

## Tech Stack

- Java
- Spring Boot
- Spring Security
- JWT Authentication
- PostgreSQL
- Hibernate / JPA
- Maven

## Features

- User Registration
- User Login with JWT Token
- Password Encryption using BCrypt
- Protected APIs using JWT Authentication
- PostgreSQL Database Integration
- RESTful API Architecture

## API Endpoints

### Register User
POST /api/users/register

Example body:
{
  "name": "Ankit",
  "email": "ankit@example.com",
  "password": "123456"
}

### Login User
POST /api/users/login

Example body:
{
  "email": "ankit@example.com",
  "password": "123456"
}

Returns JWT token.

### Protected Endpoint
GET /api/users/profile

Requires Bearer Token.

## Run Locally

Clone repository

git clone https://github.com/YOUR_USERNAME/secureauth-jwt-api.git

Run the project

mvn spring-boot:run

Server will run on:

http://localhost:8080
