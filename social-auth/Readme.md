#### Lab 2: Integrate OAuth2 with a Social Login Provider

#### <bold> Scenario: </bold> You're developing an e-commerce application. Allow users to register and log in using their existing social media accounts (e.g., Google, Facebook).

### Tasks:

- Choose a social login provider (e.g., Google).
- Configure your Spring Security application to integrate with the chosen provider's OAuth2 flow.
- Users log in using their social media credentials, granting access to your application.
- Retrieve user information (e.g., name, email) from the social provider after successful login.

## Implementation Details

### 1. Configuration

I chose to integrate Google as the social login provider. To do this, I utilized Spring Security's OAuth2 client support.

### 2. Setting Up OAuth2 Client

I used the `OAuth2Client` interface along with the default customizer provided by Spring Security. This allowed me to easily configure the OAuth2 client for Google.

### 3. Adding Client Credentials

In the configuration, I provided the client ID and client secret obtained from Google Developers Console. Spring automatically picked up these credentials and created client beans.

### 4. authentication

with the oauth2 client configured, users were able to log in using their google credentials. spring security handled the oauth2 flow, including redirecting users to google's authentication page.

### 4. Retrieving User Details

After successful authentication, I retrieved user information such as name and email from the authentication object provided by Spring Security. This information could then be used within the application as needed.

- [http://localhost:8080/login](http://localhost:8080/login)
  [login img](./docs/login.PNG)
