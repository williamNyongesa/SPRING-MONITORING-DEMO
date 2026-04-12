# Spring Boot Monitoring Demo

**Author:** William Nyongesa  
**GitHub:** [github.com/williamNyongesa](https://github.com/williamNyongesa)  
**Stack:** Java 17 · Spring Boot 3 · PostgreSQL · Spring Actuator · Prometheus

---

## About This Project

A production-ready Spring Boot application demonstrating:
- ✅ RESTful API development with Spring MVC
- ✅ Database integration with Spring Data JPA + PostgreSQL
- ✅ Application monitoring with Spring Boot Actuator
- ✅ Metrics collection with Micrometer + Prometheus
- ✅ Custom health check endpoints
- ✅ Full CRUD operations for Employee management

---

## Tech Stack

| Technology | Purpose |
|---|---|
| Java 17 | Core language |
| Spring Boot 3 | Application framework |
| Spring Data JPA | Database ORM |
| PostgreSQL | Relational database |
| Spring Actuator | Application monitoring |
| Micrometer + Prometheus | Metrics collection |
| Maven | Build tool |

---

## Getting Started

### Prerequisites
- Java 17+
- Maven 3.6+
- PostgreSQL 14+

### 1. Clone the repository
```bash
git clone https://github.com/williamNyongesa/spring-monitoring-demo.git
cd spring-monitoring-demo
```

### 2. Create PostgreSQL database
```sql
CREATE DATABASE monitoring_demo;
```

### 3. Update database credentials
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/monitoring_demo
spring.datasource.username=your_username
spring.datasource.password=your_password
```

### 4. Run the application
```bash
mvn spring-boot:run
```

App runs at: **http://localhost:8080**

---

## API Endpoints

### Employee Management
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/employees` | Get all employees |
| GET | `/api/employees/{id}` | Get employee by ID |
| GET | `/api/employees/department/{dept}` | Get by department |
| POST | `/api/employees` | Create employee |
| PUT | `/api/employees/{id}` | Update employee |
| DELETE | `/api/employees/{id}` | Delete employee |
| GET | `/api/employees/count` | Total count |

### Monitoring Endpoints
| Method | Endpoint | Description |
|---|---|---|
| GET | `/api/monitor/info` | Application info |
| GET | `/api/monitor/db-health` | Database health |
| GET | `/api/monitor/metrics` | JVM metrics |

### Spring Actuator Endpoints
| Endpoint | Description |
|---|---|
| `/actuator/health` | Application health |
| `/actuator/metrics` | All metrics |
| `/actuator/info` | App info |
| `/actuator/prometheus` | Prometheus metrics |

---

## Sample API Usage

### Create an employee
```bash
curl -X POST http://localhost:8080/api/employees \
  -H "Content-Type: application/json" \
  -d '{
    "name": "William Nyongesa",
    "email": "william@example.com",
    "department": "Engineering",
    "salary": 80000
  }'
```

### Get all employees
```bash
curl http://localhost:8080/api/employees
```

### Check application health
```bash
curl http://localhost:8080/actuator/health
```

---

## Project Structure

```
spring-monitoring-demo/
├── src/main/java/com/william/monitoring/
│   ├── MonitoringDemoApplication.java    # Main class
│   ├── controller/
│   │   ├── EmployeeController.java       # REST API endpoints
│   │   └── HealthController.java         # Monitoring endpoints
│   ├── model/
│   │   └── Employee.java                 # Database entity
│   ├── repository/
│   │   └── EmployeeRepository.java       # Database operations
│   └── service/
│       └── EmployeeService.java          # Business logic
├── src/main/resources/
│   └── application.properties            # Configuration
└── pom.xml                               # Dependencies
```

---

## Connect With Me

- 🌐 Portfolio: [williamnyongesa.github.io](https://williamnyongesa.github.io)
- 💼 LinkedIn: [linkedin.com/in/william-nyongesa-a2a064241](https://linkedin.com/in/william-nyongesa-a2a064241)
- 🐙 GitHub: [github.com/williamNyongesa](https://github.com/williamNyongesa)
