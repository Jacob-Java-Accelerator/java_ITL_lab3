## Features

- User authentication using JWT tokens.
- Secure API endpoints requiring valid JWT tokens.
- Role-based authentication with NORMALUSER and ADMINUSER roles.
- Token validation and extraction of user details.
- Custom JWT authentication filter for processing authentication requests.


## Authentication Flow
- User Login: Users authenticate using their email and password.
- JWT Token Issuance: Upon successful authentication, a JWT token is generated and returned.
- Token Validation: Every API request (except login) must include a valid JWT token in the Authorization header.
- User Authorization: The application extracts the token, validates it, and authorizes the user based on their role.

## Endpoints
| Method | Endpoint                        | Description                          | Access              |
| ------ | ------------------------------- | ------------------------------------ | ------------------- |
| POST   | `/api/v1/auth/register`         | Register a new user                  | Public              |
| POST   | `/api/v1/auth/authenticate`     | Authenticate user & return JWT token | Public              |
| GET    | `/api/v1/social-media/homepage` | View homepage                        | Authenticated Users |
| GET    | `/api/v1/social-media/profile`  | View user profile                    | Authenticated Users |
