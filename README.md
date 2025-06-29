# User Authentication App (Spring Boot + Thymeleaf + MySQL)

This is a simple user authentication web application built using:
- Java 17
- Spring Boot 3.5
- Thymeleaf (HTML template engine)
- Spring Security
- MySQL (for persistent storage)

It supports:
- ✅ User registration (with first name, last name, email, password)
- ✅ Secure password hashing
- ✅ Login and logout
- ✅ Personalized welcome page showing full name
- ✅ Basic form validation
- ✅ Styled with custom CSS

---

## 🔧 Setup Instructions

### 1. Clone the Repository

```bash
git https://github.com/apondi-art/loginchecker.git
cd loginchecker
cd userauth
./mvnw spring-boot:run
```
. Create MySQL Database

Open MySQL shell:

sudo mysql

Then:
## create table
CREATE DATABASE IF NOT EXISTS userauth_db;
EXIT;
## using the table

USE userauth_db;


## Check if the users table exists:
##  Optional: View Table Columns

Use the built-in wrapper:

./mvnw spring-boot:run

Or with installed Maven:

mvn spring-boot:run

🌐 Test the App

Open your browser:

    📄 Registration: http://localhost:8080/register

    🔐 Login: http://localhost:8080/login

    👋 Welcome: http://localhost:8080/welcome (after login)

📁 Project Structure

src
├── main
│   ├── java
│   │   └── com.example.userauth
│   │       ├── model            # User entity
│   │       ├── repository       # UserRepository (interface)
│   │       ├── service          # UserService, CustomUserDetailsService
│   │       ├── controller       # WebController
│   │       └── config           # SecurityConfig
│   └── resources
│       ├── templates            # Thymeleaf HTML templates
│       ├── static/css           # Custom CSS files
│       └── application.properties

✅ Features Implemented

Registration with form and validation

Login page with messages
# loginchecker
loginchecker is a beginner-friendly Java + Spring Boot web application that allows users to register, log in, and view a personalized greeting. It uses Spring Security for authentication, Thymeleaf for the front-end, and H2 for a lightweight database

Password hashing with BCrypt

Session-based authentication

Thymeleaf integration

Logout handling (POST form)

    Personalized greeting with full name

🛡️ Security Note

    Passwords are hashed using BCryptPasswordEncoder

    Login uses Spring Security's form login and session management

    Logout is handled securely via POST



