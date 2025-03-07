### Spring Boot OAuth2 Integration
## Prerequisites
- Java 17 or higher
- Maven or Gradle
- Google / GitHub OAuth2 credentials (Client ID and Client Secret)

### Access the Application

| Endpoint            | Access Level      | Description                                               |
|---------------------|-------------------|-----------------------------------------------------------|
| `/public/about`     | Public            | This is a public endpoint accessible without authentication. |
| `/homepage`         | Authenticated     | A protected homepage endpoint, available after logging in. |
| `/user-info`        | Authenticated     | Retrieves and displays the authenticated user's email address from Google. |
| `/the-user`         | Authenticated     | Displays basic OAuth2 user details.                       |
