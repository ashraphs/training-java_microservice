# Read Me First
The following was discovered as part of building this project:

* This documentation is part of training for maybank project.

# Getting Started

### Requirement
* step 1. (OPTIONAL) docker run --name mbb-local-postgres -d -p 5432:5432 -e POSTGRES_PASSWORD=postgres postgres:alpine
* step 2. Java 8 and above
* step 3. Postman

### Step to run the services
#### step 1. Run registry-server
* mvn clean compile spring-boot:run

#### step 2. Run config-server
* mvn clean compile spring-boot:run -Dspring.profiles.active=dev

#### step 3. Run master-data-service
* mvn clean compile spring-boot:run

#### step 4. Test in postman
* POSTMAN - Use this link to run the API (https://www.postman.com/lively-moon-579376/workspace/public/collection/19577438-286c3385-e4f1-476e-a73b-86202fdfdda0?action=share&creator=19577438)

### Server info
* MBB-API-GATEWAY-SERVICE | Port: 8881
* MBB-REGISTRY-SERVER | Port: 8761
* MBB-CONFIG-SERVER | Port: 8888
* MBB-MASTER-DATA-SERVICE | Port: 8082 (NO NEED TO POINT TO THIS PORT AS WE USED THE API GATEWAY)



### Step to change database configuration
#### step 1. Run config-server
#### step 2. Change below configuration in path <mbb-config-server/src/main/resources/config-repo/application-dev.properties>
`spring.datasource.url=jdbc:postgresql://localhost:5432/postgres` <br>
`spring.database.scheme=mbb_core` <br>
`spring.datasource.username=postgres` <br>
`spring.datasource.password=postgres`


### Guideline Traning Documentation
* Spring Cloud (https://spring.io/projects/spring-cloud)
  * Spring Cloud Netflix
  * Spring Cloud Config
  * Spring Cloud OpenFeign
  * Spring Cloud Connector (MQ)
  * Spring Cloud Security
  * Spring Cloud Gateway
  * Zuul Gateway
* Spring Data (https://spring.io/projects/spring-data)
  * Spring Data JDBC
  * Spring Data JPA
  * Spring Data Redis
* Monitor
  * Elastic Logstash
  * Prometheus
  * Datadog
* Others
  * Swagger (https://swagger.io/docs/)
  * Kubernetes / Docker
    * https://kubernetes.io/docs/home/
    * https://www.docker.com/get-started/
* Microservice Architecture
  * https://dzone.com/articles/top-5-microservices-architecture-and-design-best-p
  * https://towardsdatascience.com/microservice-architecture-and-its-10-most-important-design-patterns-824952d7fa41
 

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/2.7.2/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#web)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#data.sql.jpa-and-spring-data)
* [Spring Data JDBC](https://docs.spring.io/spring-boot/docs/2.7.2/reference/htmlsingle/#data.sql.jdbc)
* [Config Client Quick Start](https://docs.spring.io/spring-cloud-config/docs/current/reference/html/#_client_side_usage)
* [Eureka Discovery Client](https://docs.spring.io/spring-cloud-netflix/docs/current/reference/html/#service-discovery-eureka-clients)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)
* [Using Spring Data JDBC](https://github.com/spring-projects/spring-data-examples/tree/master/jdbc/basics)
* [Service Registration and Discovery with Eureka and Spring Cloud](https://spring.io/guides/gs/service-registration-and-discovery/)

