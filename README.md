\# Travel Agency System



A Spring Boot Microservices-based Travel Agency Management System built using Java, Spring Boot, Spring Cloud, Eureka Service Discovery, API Gateway, JWT Authentication, and MySQL.



\## Architecture



The application follows a microservices architecture where each business capability is implemented as an independent service.



\### Microservices



\- Eureka Server

\- API Gateway

\- Auth Service

\- Customer Service

\- Travel Package Service

\- Booking Service

\- Payment Service

\- Agency Service



\## Tech Stack



\- Java 17

\- Spring Boot

\- Spring Data JPA

\- Spring Security

\- JWT Authentication

\- Spring Cloud Gateway

\- Netflix Eureka

\- MySQL

\- Maven

\- Git \& GitHub



\## Services and Ports



| Service | Port |

|----------|----------|

| Eureka Server | 8761 |

| API Gateway | 9090 |

| Auth Service | 8081 |

| Customer Service | 8082 |

| Travel Package Service | 8083 |

| Booking Service | 8084 |

| Payment Service | 8085 |

| Agency Service | 8086 |



\## Features



\### Authentication Service

\- User Registration

\- User Login

\- JWT Token Generation

\- Role-based Security



\### Customer Service

\- Add Customer

\- Update Customer

\- Delete Customer

\- View Customer Details



\### Travel Package Service

\- Create Travel Package

\- Update Travel Package

\- Delete Travel Package

\- View Available Packages



\### Booking Service

\- Book Travel Packages

\- View Booking Details

\- Customer Validation using Feign Client

\- Package Validation using Feign Client



\### Payment Service

\- Process Payments

\- View Payment Details

\- Booking Validation



\### Agency Service

\- Manage Travel Agencies

\- Agency Information Management



\### API Gateway

\- Centralized Routing

\- Request Filtering

\- JWT Validation

\- Security Layer



\### Eureka Server

\- Service Registration

\- Service Discovery



\## Project Structure



text

travel-agency-system

│

├── eureka-server

├── api-gateway

├── auth-service

├── customer-service

├── travel-package-service

├── booking-service

├── payment-service

└── agency-service





\## Service Communication



\- Eureka for Service Discovery

\- OpenFeign for Inter-Service Communication

\- API Gateway for Routing

\- JWT for Authentication and Authorization



\## How To Run



\### 1. Start Eureka Server



bash

cd eureka-server

mvn spring-boot:run





\### 2. Start Auth Service



bash

cd auth-service

mvn spring-boot:run





\### 3. Start Remaining Services



\- Customer Service

\- Travel Package Service

\- Booking Service

\- Payment Service

\- Agency Service



\### 4. Start API Gateway



bash

cd api-gateway

mvn spring-boot:run





\### 5. Verify Eureka Dashboard





http://localhost:8761





\## Future Enhancements



\- Docker Support

\- Kubernetes Deployment

\- CI/CD Pipeline

\- Resilience4J Circuit Breaker

\- Distributed Tracing

\- Centralized Logging

\- Monitoring using Prometheus and Grafana



\## Author



Rahul Kumar



Microservices \& Spring Boot Developer

