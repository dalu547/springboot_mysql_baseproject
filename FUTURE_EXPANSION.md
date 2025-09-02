# Future Expansion Roadmap

This document outlines possible extensions to the foundation scaffold for upcoming projects.  
Not all projects will need these — add them **when requirements demand**.

---

## 1. Caching
- **Why**: Improve performance and reduce DB load.  
- **Options**:
  - Spring Cache abstraction with Redis
- **When to add**: For read-heavy APIs or frequently accessed data (e.g., product catalog).

---

## 2. Asynchronous Processing / Messaging
- **Why**: Decouple services, handle background tasks, improve scalability.  
- **Options**:
  - Spring Events (lightweight async inside app)
  - RabbitMQ / Kafka (for distributed messaging)
- **When to add**: For long-running tasks, event-driven systems, or inter-service communication.

---

## 3. Testing Enhancements
- **Why**: Ensure reliability and prevent regressions.  
- **Options**:
  - JUnit 5 + Mockito for unit tests
  - Testcontainers for integration tests with MySQL
  - MockMvc for controller tests
- **When to add**: From the start of real feature development.

---

## 4.  CI/CD Automation
- **Why**: Automate build, test, and deployment pipelines.  
- **Options**:
  - GitHub Actions, GitLab CI, or Jenkins
- **When to add**: As soon as team grows or deployment needs automation.

---

## 5. Monitoring & Observability
- **Why**: Track application health, performance, and errors in production.  
- **Options**:
  - Micrometer + Prometheus + Grafana (metrics)
  - ELK stack / OpenSearch (logs)
- **When to add**: For production-grade deployments.

---

## 8. API Versioning & Governance
- **Why**: Avoid breaking changes in APIs.  
- **Options**:
  - URI versioning (`/api/v1/products`)
  - Header-based versioning
- **When to add**: When APIs are exposed externally or multiple clients depend on them.

---

## 9. Modularization / Microservices Transition
- **Why**: Scale system as features grow.  
- **Options**:
  - Gradually split domains into separate deployable services
  - Introduce API Gateway (e.g., Spring Cloud Gateway)
- **When to add**: When monolith becomes too large and scaling independently is needed.

---

## Recommendation
Start with the **foundation scaffold** and only extend when business or technical needs arise.  
This ensures the system stays **simple, maintainable, and future-proof**.

---


---

## 10. CI/CD with Bitbucket + AWS

Since this project is hosted on **Bitbucket** and deployed to **AWS**, the recommended CI/CD setup is:

- **Bitbucket Pipelines**  
  - Define steps in `bitbucket-pipelines.yml`  
  - Run Maven build + tests automatically on commits  
  - Deploy build artifact (JAR or Docker image) to AWS  

- **AWS Deployment Options**  
  - Elastic Beanstalk → simplest way (deploy JAR/Docker)  
  - ECS (Fargate) → containerized deployment  
  - EKS → if moving to Kubernetes/microservices in future  
  - EC2 + Systemd → lightweight option for running Spring Boot JAR  

> Recommendation: Start with **Bitbucket Pipelines + AWS Elastic Beanstalk** for simplicity.  
> Later scale to ECS/EKS as the system grows.
