# Microservices Architecture with Spring Boot and Kafka 🚀

## Introduction 📝
This documentation provides a comprehensive overview of a Microservices Architecture project leveraging Spring Boot and Kafka. It offers detailed insights, guidelines, and examples pertaining to various aspects of microservices architecture, including design patterns, deployment strategies, and integration with Kafka for event-driven communication.

## Objective 🎯
The primary aim of this project documentation is to offer a thorough understanding of the architectural decisions, implementation specifics, and best practices associated with developing microservices using Spring Boot and Kafka. By delving into fundamental concepts such as Clean and Hexagonal architectures, Domain-Driven Design (DDD), SAGA, Outbox, and CQRS, this documentation seeks to equip developers with the necessary knowledge to design, build, and deploy scalable and resilient microservices-based systems. 📘

## Topics
This repository covers the following topics:

🛠️ **Spring Boot Microservices**
🏛️ **Clean Architecture**
🔷 **Hexagonal Architecture**
🔄 **Domain-Driven Design (DDD)**
🔄 **SAGA Architecture Pattern**
📤 **Outbox Architecture Pattern**
↔️ **CQRS Architecture Pattern**
🐘 **Kafka**
📦 **Kubernetes Basics**
☁️ **Google Cloud & Google Kubernetes Engine (GKE)**
🔄 **Change Data Capture (CDC) with Debezium and Kafka**

## Contents
1. 🛠️ Spring Boot Microservices
2. 🏛️ Clean Architecture
3. 🔷 Hexagonal Architecture
4. 🔄 Domain-Driven Design (DDD)
5. 🔄 SAGA Architecture Pattern
6. 📤 Outbox Architecture Pattern
7. ↔️ CQRS Architecture Pattern
8. 🐘 Kafka Architecture and Programming
9. 🐘 Using Kafka as the Event Store for Event-Driven Services
10. 📦 Kubernetes Basics & Running a Local Cluster using Docker Desktop
11. 📦 Deploying Microservices to Local Kubernetes Cluster
12. 📦 Running Confluent Kafka on Kubernetes using cp-helm-charts
13. 📦 Running Postgres on Kubernetes
14. ☁️ Deploying Microservices to Google Kubernetes Engine (GKE)
15. 🔄 Change Data Capture (CDC) with Debezium and Kafka

## Implementation 💻
Each topic includes implementation details and code examples, which can be found in the respective directories within this repository.

### To create modules images dependencies
````
 mvn com.github.ferstl:depgraph-maven-plugin:aggregate -DcreateImage=true -DreduceEdges=false -Dscope=compile "-Dincludes=code.vanilson.food-order*:*"

````

## Contributors 🤝
- [vanilson muhongo](https://github.com/edsonwade)


## License 📄
This project is licensed under the [MIT License](LICENSE).
