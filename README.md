# Java Spring Microservices

A production-style microservices system built with **Java 21** and **Spring Boot**, organized around a set of independently deployable services that communicate through HTTP, gRPC, Kafka, and Spring Cloud Gateway. The repository also includes local infrastructure tooling and API request examples to make development and testing easier.

## Overview

This project is structured as a multi-module Java application with a focus on:

- **Microservice separation** for bounded business domains
- **API gateway routing** for centralized external access
- **Authentication and authorization**
- **Event-driven communication** with Kafka
- **gRPC-based internal communication**
- **Persistence with Spring Data JPA**
- **Containerized service deployment**
- **Local cloud infrastructure support**
- **Integration testing**


---

### Supporting folders

- `api-requests/` — sample HTTP requests for testing service endpoints
- `grpc-request/` — gRPC-related request artifacts
- `infrastructure/cdk.out/` — generated infrastructure deployment output

---

## Architecture

The system is designed around a modern microservices architecture:

- **Clients** call the **API Gateway**
- The gateway routes traffic to dedicated backend services
- **Auth service** validates identities and issues or verifies tokens
- **Domain services** manage business data and workflows
- **Kafka** is used for asynchronous event processing
- **gRPC** supports low-latency internal communication where needed
- **JPA + PostgreSQL/H2** support persistence and testing scenarios
- **Docker** is used to containerize services
- **LocalStack / CDK** assist with local cloud-like infrastructure

---

## Key Technologies

### Core
- Java 21
- Spring Boot
- Spring Web / WebFlux
- Spring Security
- Spring Data JPA
- Spring Cloud Gateway
- Spring Kafka
- gRPC
- Docker

### Persistence and Databases
- PostgreSQL
- H2 for local/testing use
- Hibernate / JPA

### API and Documentation
- Springdoc OpenAPI / Swagger

### Testing
- JUnit 5
- Mockito
- Spring Boot Test
- Awaitility
- Rest Assured
- Spring Kafka Test
- Spring Security Test

### Infrastructure
- AWS CDK
- LocalStack


---

## Getting Started

### 1. Clone the repository

### 2. Build the modules

From the project root, build the whole workspace:

If you want to build a specific service:

### 3. Run the services

Start each service from its module, or run them from your IDE using the corresponding Spring Boot application class.

Common startup order:

1. Infrastructure / dependencies
2. Auth service
3. Core domain services
4. Analytics service
5. API Gateway
6. Integration tests

---

## Running with Docker

Each service includes a `Dockerfile`, so the services can be containerized individually.

Example:

Then run the containers with the correct environment configuration for your local setup.

---

## API Testing

The `api-requests/` folder contains ready-to-use HTTP request files for testing endpoints directly from IntelliJ IDEA.

Examples include requests for:

- authenticating a user
- validating JWT tokens
- creating patients
- fetching patients
- deleting patients

These files are useful for quick manual testing without needing a separate API client.

---

## Security

The project includes authentication and token validation support.  
Expected security features may include:

- login flow
- JWT-based validation
- protected endpoints
- gateway-level request forwarding
- Spring Security configuration

When running locally, make sure all required secrets, token values, and environment variables are configured safely.

---

## Messaging and Async Processing

The repository includes Kafka dependencies and an analytics consumer.  
This suggests an event-driven architecture where services can:

- publish domain events
- consume asynchronous messages
- process analytics or integration workflows independently

This approach helps reduce coupling between services and improves scalability.

---

## gRPC Support

The project also includes gRPC-related dependencies and request artifacts.  
gRPC is typically used for:

- fast service-to-service communication
- strongly typed contracts
- efficient binary transport
- internal platform communication

---

## Infrastructure

The `infrastructure` module contains cloud provisioning support, including AWS CDK-related output and a local stack implementation.

This can be used for:

- local testing of cloud resources
- reproducing infrastructure in development
- provisioning supporting services for the microservices platform

---

## Testing Strategy

The project supports multiple layers of testing:

- **Unit tests** for isolated logic
- **Integration tests** for cross-module behavior
- **Kafka tests** for asynchronous flows
- **Security tests** for protected endpoints
- **REST endpoint tests** for HTTP APIs

Recommended execution:

Or run the integration-test module separately if needed.

---

## Example Use Cases

This kind of architecture is a good fit for systems that need:

- independent service deployment
- scalable backend domains
- secure access control
- event-driven workflows
- internal RPC communication
- clear separation of concerns
- infrastructure-as-code support

---

## Development Notes

- Keep service boundaries clean and domain-focused
- Use the API Gateway for client-facing traffic
- Prefer asynchronous messaging for non-blocking workflows
- Keep shared contracts versioned and explicit
- Use integration tests for end-to-end confidence
- Store environment-specific configuration outside source control


---


## Roadmap Ideas

Possible future improvements include:

- a centralized configuration server
- observability with tracing and metrics
- contract testing between services
- CI/CD pipeline configuration
- service health dashboards
- more detailed API documentation
- automated environment bootstrap scripts

---
