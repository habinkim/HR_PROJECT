# HR Project

[TOC]

------



## 1. Story And Issue

### Issue 1. 사용자는 특정 사원의 현재 정보를 조회할 수 있다.



### Issue 2. 사용자는 특정 사원의 업무 이력 정보를 조회할 수 있다.



### Issue 3. 사용자는 부서 정보를 조회할 수 있다.



### Issue 4. 사용자는 특정 부서의 급여를 특정 비율로 인상할 수 있다.



### Issue 5. 사용자는 사원 정보를 업데이트할 수 있다.



### Issue 6. 사용자는 서울특별시 동작구 횡단보도 정보조회를 할 수 있다.



## 2. 기술 스택

### 2.1. Backend

- Language : Java 17
- Framework : Spring
  - Spring Boot
  - Spring Data JPA
  - Srpring Web
  - Spring MVC
  - Spring REST Docs
- DataBase Connection
  - HikariPool
  - MariaDB
- Persistence Framework
  - JPA
  - QueryDSL
- Boiler Plate Code
  - lombok
  - mapstruct
- TDD
  - JUnit
  - testcontainers
  - Spring REST Docs
    - MockMvc
    - AsciiDoctor
- Logging
  - Logback
  - p6spy Query Logger



### 2.2. Infra

- AWS (SaaS)
  - VPC
  - EC2
  - Application Load Balancer
  - Certification Manager
  - Route 53
- Gabia
  - Domain



## 3. 실행 방법

1. Project Root 경로에서 `./gradlew build`
2. `cd build/libs`
3. `java -jar -Dspring.profiles.active=local hr-1.3.0.jar`
