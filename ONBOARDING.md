# Developer Onboarding Guide

This document helps new developers set up and run the application locally.

---

## 1. Prerequisites  
Ensure the following tools are installed:  
- **Java 17+** (check with `java -version`)  
- **Maven 3.9+** (`mvn -v`)  
- **MySQL 8+** (running locally or via Docker)  
- **IntelliJ IDEA** (Ultimate recommended for Spring)  
- **Git client**  

---

## 2. Clone the Repository  
```bash
git clone https://yourcompany.com/your-repo.git
cd your-repo
```

---

## 3. Setup Database  
- Create a new MySQL database:  
  ```sql
  CREATE DATABASE productapp;
  ```  
- Update credentials in `src/main/resources/application-dev.yml`:  
  ```yaml
  spring:
    datasource:
      url: jdbc:mysql://localhost:3306/productapp
      username: root
      password: root
  ```

---

## 4. Run the Application  
- Start with Maven:  
  ```bash
  mvn spring-boot:run -Dspring-boot.run.profiles=dev
  ```  
- Or run from IntelliJ: `ProductApplication.main()`  

---

## 5. Verify Migrations  
- Flyway will auto-apply migrations from `src/main/resources/db/migration/`.  
- Check logs → should say `Successfully applied X migrations`.  

---

## 6. Access APIs  
- Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)  
- API Docs (JSON): [http://localhost:8080/v1/api-docs](http://localhost:8080/v1/api-docs)  

Sample request:  
```bash
curl -X POST http://localhost:8080/api/products \
  -H "Content-Type: application/json" \
  -d '{"name":"Laptop","price":1200.00}'
  
  ```

---

## 7. Logs & Monitoring  
- Logs are written to:  
  - Console (dev mode)  
  - `logs/productapp.log` (staging/prod with rolling policy)  

---

## 8. Profiles  
- `dev` → Local development  
- `staging` → QA/UAT environment  
- `prod` → Production  

Switch profiles with:  
```bash
mvn spring-boot:run -Dspring-boot.run.profiles=staging
```

---

## 9. Common Issues & Fixes  
- ❌ `DB connection failed` → Ensure MySQL is running & creds are correct  
- ❌ `Port 8080 already in use` → Kill process or run with `-Dserver.port=9090`  
- ❌ IntelliJ errors on Lombok → Install **Lombok plugin** in IntelliJ & enable annotation processing  

---

## 10. Next Steps for New Developers  
- Review code structure (`src/main/java/...`)  
- Check `README.md` diagrams for architecture overview  
- Start by adding a **new endpoint** under `ProductController` for practice  

---
