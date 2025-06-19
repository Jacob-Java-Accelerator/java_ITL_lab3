#### Lab 1: Secure a REST API with JWT Authentication

#### <bold> Scenario: </bold>You're building a REST API for a social media platform. Users need to be authenticated securely before accessing their profiles or posting content.

## Tasks:

- Implement JWT authentication in your Spring Boot application.
- Users log in with username and password, receiving a JWT token upon successful authentication.
- Secure API endpoints by requiring a valid JWT token in the authorization header.
- Implement logic to validate and decode JWT tokens within controllers.

#### Using an in memory user to achieve this

```
- payload (json)

{
    "email": "dickson",
    "password": "password"
}
```

#### Response

```
{
    "token": "",
    "email": {
        "password": null,
        "username": "dickson",
        "authorities": [
            {
                "authority": "read"
            }
        ],
        "accountNonExpired": true,
        "accountNonLocked": true,
        "credentialsNonExpired": true,
        "enabled": true
    }
}j
```

#### Lab 3: Monitor Application Health with Actuator Endpoints

#### Scenario: You're deploying your Spring Boot application to a production environment. It's crucial to monitor its health and performance.

### Tasks:

- Enable Spring Boot Actuator in your application.
- Explore Actuator endpoints like /health, /metrics, and /env.
- Visualize application health metrics using a monitoring tool (e.g., Grafana, Prometheus).
- Secure access to Actuator endpoints using basic authentication or other security measures.

- [grafana dashboard json](./extra/12900_rev3.json)
