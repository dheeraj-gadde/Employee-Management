# 🧑‍💼 Employee Management System

A modern web-based Employee Management System built with **Spring Boot**, **Thymeleaf**, and **MySQL**. This application allows users to manage employee records, including adding, editing, viewing, and deleting employees in a clean and intuitive UI.

## ✨ Features

- 📋 View a list of all employees
- ➕ Add a new employee
- ✏️ Edit existing employee details
- ❌ Delete employee records
- 📱 Responsive & modern UI using custom CSS
- 💾 Data stored in a MySQL database
- ⚙️ Auto-incremented employee IDs

## 🛠️ Technologies Used

| Layer            | Technology           |
|------------------|----------------------|
| Backend          | Java, Spring Boot    |
| Frontend         | HTML, Thymeleaf, CSS |
| Database         | MySQL                |
| ORM & JPA        | Hibernate (JPA)      |
| Build Tool       | Maven                |
| IDE Recommended  | IntelliJ / Eclipse   |

## ⚙️ System Requirements

- Java 17+
- Maven 3.6+
- MySQL 8.0+
- A modern browser (Chrome, Firefox, etc.)


## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/dheeraj-gadde/employee-management.git
cd employee-management
```

### 2. Set Up MySQL

- Create a database:

```sql
CREATE DATABASE employee;
```

- Update your `application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_db
spring.datasource.username=your_mysql_user
spring.datasource.password=your_mysql_password
spring.jpa.hibernate.ddl-auto=update
```

### 3. Run the Application

```bash
./mvnw spring-boot:run
```

Then visit: [http://localhost:8080](http://localhost:8080)


## 📄 License

This project is open-source and available under the [MIT License](LICENSE).

---

### 💡 Author

**Dheeraj**  
Made for learning and improving Java Spring Boot skills.