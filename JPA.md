## JPA
Src: https://www.youtube.com/watch?v=MaI0_XdpdP8&t=1844s
Github: https://www.youtube.com/redirect?event=video_description&redir_token=QUFFLUhqbFAzMVliR0c0V3R5NkhGVEIyc0dmN3ZzeEs4QXxBQ3Jtc0ttUWJCbzZrOHBaUzdKbGVlTDRIRGJSd1FGNHZHNjdERk1pYVVhRmVzSFVNR3RvQTNpRm1qWVd0S2dFdEN0VWt0cEI3WFl5b3N4aGtOOVFzWVkxTEt5Mi1EMDd4OWZxaFpBSmZTX0s5Z0lLZDRWbVU1OA&q=https%3A%2F%2Fgithub.com%2Fin28minutes%2Fgetting-started-in-5-steps%2Ftree%2Fmaster%2Fjpa-in-10-steps&v=MaI0_XdpdP8

![image](https://user-images.githubusercontent.com/69948118/180342274-8e363e44-c790-4312-a35f-c93c475e3c81.png)
![image](https://user-images.githubusercontent.com/69948118/180342721-0d7b9710-ca66-4630-8376-a87f5ed3e9d6.png)
![image](https://user-images.githubusercontent.com/69948118/180342787-b79f10cb-7e8a-4edd-8145-15177a599be7.png)
![image](https://user-images.githubusercontent.com/69948118/180342936-52d071bd-c9a9-4a24-ba52-55d71035a5ba.png)
![image](https://user-images.githubusercontent.com/69948118/180343029-8007cab1-7b80-44b9-8220-f9075b97c21c.png)
![image](https://user-images.githubusercontent.com/69948118/180343078-3e071429-c821-4312-98ec-6bd8016c9a13.png)
![image](https://user-images.githubusercontent.com/69948118/180343127-39ea6de2-a1fd-444e-b82d-5c6a1b1287bc.png)
![image](https://user-images.githubusercontent.com/69948118/180343228-3747cfe5-1507-4c50-9c0d-0785f58b9b3e.png)
![image](https://user-images.githubusercontent.com/69948118/180343409-1ba03198-72ff-4957-8fc1-bc2e5ca36015.png)
![image](https://user-images.githubusercontent.com/69948118/180343652-75303bc1-c7ff-4b3b-92be-dcd4ba502c0d.png)
![image](https://user-images.githubusercontent.com/69948118/180343669-2648c0f0-6d59-4b25-9a41-bb68d63137fa.png)
![image](https://user-images.githubusercontent.com/69948118/180343800-67419659-a266-4960-8486-2f9ee47a452e.png)
![image](https://user-images.githubusercontent.com/69948118/180343822-be9de674-7bd6-4994-a8a2-156b863c3fde.png)
![image](https://user-images.githubusercontent.com/69948118/180345103-307db45e-0fa6-4a91-b42b-06792d477532.png)




##  First 10 Steps in JPA with H2 in-memory database

- Step 1 : Object Relational Impedence Mismatch - Understanding the problem that JPA solves
- Step 2 : World before JPA - JDBC, Spring JDBC and myBatis
- Step 3 : Introduction to JPA
- Step 4 : Creating a JPA Project using Spring Initializr
- Step 5 : Defining a JPA Entity - User
- Step 6 : Defining a Service to manage the Entity - UserService and EntityManager
- Step 7 : Using a Command Line Runner to save the User to database.
- Step 8 : Magic of Spring Boot and In Memory Database H2
- Step 9 : Introduction to Spring Data JPA
- Step 10 : More JPA Repository : findById and findAll
- Next Steps

Notes
- http://localhost:8080/h2-console
- Use db url jdbc:h2:mem:testdb
## Complete Code Example


### /notes.txt

```
Questions
- Where is the database created?
- What schema is used to create the tables?
- Where are the tables created?
- Can I see the data in the database?
- Where is Hibernate coming in from?
- How is a datasource created?

Magic of Spring Boot and in Memory Database
- Zero project setup or infrastructure
- Zero Configuration
- Zero Maintainance
- Easy to use for Learning and Unit Tests
- Simple Configuration to switch to a real database

# Restrictions of using in-memory database
- Data is not persisted between restarts

Spring Boot chooses a default value for you based on whether it thinks your database is embedded (default create-drop) or not (default none). 

HibernateJpaAutoConfiguration matched:
 - @ConditionalOnClass found required classes 'org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean', 'javax.persistence.EntityManager'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)
 - HibernateEntityManager found class 'org.hibernate.ejb.HibernateEntityManager' (HibernateJpaAutoConfiguration.HibernateEntityManagerCondition)

DataSourceAutoConfiguration matched:
 - @ConditionalOnClass found required classes 'javax.sql.DataSource', 'org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType'; @ConditionalOnMissingClass did not find unwanted class (OnClassCondition)

JpaBaseConfiguration#entityManagerFactory matched:
 - @ConditionalOnMissingBean (types: org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean,javax.persistence.EntityManagerFactory; SearchStrategy: all) did not find any beans (OnBeanCondition)

JpaBaseConfiguration#transactionManager matched:
 - @ConditionalOnMissingBean (types: org.springframework.transaction.PlatformTransactionManager; SearchStrategy: all) did not find any beans (OnBeanCondition)
```
---

### /pom.xml

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>

	<groupId>com.in28minutes.learning.jpa</groupId>
	<artifactId>jpa-in-10-steps</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<packaging>jar</packaging>

	<name>jpa-in-10-steps</name>
	<description>Demo project for Spring Boot</description>

	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.0.0.BUILD-SNAPSHOT</version>
		<relativePath /> <!-- lookup parent from repository -->
	</parent>

	<properties>
		<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
		<project.reporting.outputEncoding>UTF-8</project.reporting.outputEncoding>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
		
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

	<repositories>
		<repository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</repository>
		<repository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</repository>
	</repositories>

	<pluginRepositories>
		<pluginRepository>
			<id>spring-snapshots</id>
			<name>Spring Snapshots</name>
			<url>https://repo.spring.io/snapshot</url>
			<snapshots>
				<enabled>true</enabled>
			</snapshots>
		</pluginRepository>
		<pluginRepository>
			<id>spring-milestones</id>
			<name>Spring Milestones</name>
			<url>https://repo.spring.io/milestone</url>
			<snapshots>
				<enabled>false</enabled>
			</snapshots>
		</pluginRepository>
	</pluginRepositories>


</project>
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/entity/User.java

```java
package com.in28minutes.learning.jpa.jpain10steps.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//Table - User
@Entity
public class User {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	private String role;

	protected User() {

	}

	public User(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Override
	public String toString() {
		return String.format("User [id=%s, name=%s, role=%s]", id, name, role);
	}
}
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/JpaIn10StepsApplication.java

```java
package com.in28minutes.learning.jpa.jpain10steps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JpaIn10StepsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaIn10StepsApplication.class, args);
	}
}
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/service/UserDAOService.java

```java
package com.in28minutes.learning.jpa.jpain10steps.service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

@Repository
@Transactional
public class UserDAOService {
		
	@PersistenceContext
	private EntityManager entityManager;
	
	public long insert(User user){
		entityManager.persist(user);
		return user.getId();
	}
}

/*
 * Spring Data JPA
 * 
 * 
 * 
 */
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/service/UserRepository.java

```java
package com.in28minutes.learning.jpa.jpain10steps.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/UserDaoServiceCommandLineRunner.java

```java
package com.in28minutes.learning.jpa.jpain10steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserDAOService;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);
	
	@Autowired
	private UserDAOService userDaoService;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jack", "Admin");
		//New User is created : User [id=1, name=Jack, role=Admin]
		long insert = userDaoService.insert(user);
		log.info("New User is created : " + user);
	}
}
```
---

### /src/main/java/com/in28minutes/learning/jpa/jpain10steps/UserRepositoryCommandLineRunner.java

```java
package com.in28minutes.learning.jpa.jpain10steps;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.in28minutes.learning.jpa.jpain10steps.entity.User;
import com.in28minutes.learning.jpa.jpain10steps.service.UserRepository;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner{

	private static final Logger log = 
			LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... arg0) throws Exception {
		User user = new User("Jill", "Admin");
		userRepository.save(user);
		log.info("New User is created : " + user);
		
		Optional<User> userWithIdOne = userRepository.findById(1L);
		log.info("User is retrived : " + userWithIdOne);

		List<User> users = userRepository.findAll();
		log.info("All Users : " + users);			
	}
	
}
```
---

### /src/main/resources/application.properties

```properties
spring.jpa.show-sql=true
spring.h2.console.enabled=true
logging.level.org.springframework=debug
```
---

### /src/test/java/com/in28minutes/learning/jpa/jpain10steps/JpaIn10StepsApplicationTests.java

```java
package com.in28minutes.learning.jpa.jpain10steps;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaIn10StepsApplicationTests {

	@Test
	public void contextLoads() {
	}

}
```
---

### /step-completed.sh

```
java -cp /ProgrammingExcellence/Workspaces/Rithus.com/ListDirectoryContentInGitFormat/bin test.ListDirectoryContentInGitFormat $PWD >> $1.md
zip -r $1.zip . -x "target/*" -x ".*/*" -x ".*" -x "*.md" -x "mvn*" -x "*.zip"
git add *; git commit -m "$1"; git push;
```
---

### /take-step-backup.sh

```
java -cp /ProgrammingExcellence/Workspaces/Rithus.com/ListDirectoryContentInGitFormat/bin test.ListDirectoryContentInGitFormat $PWD >> $1.md
zip -r $1.zip . -x "target/*" -x ".*/*" -x ".*" -x "*.md" -x "mvn*" -x "*.zip"
```
---

---
### JPA in Details

SRC : https://www.youtube.com/watch?v=ndHywjc3-kY&list=PL6oD2syjfW7COL__RNrWl4S97vNcqh3mO

![image](https://user-images.githubusercontent.com/69948118/180624602-39c327d8-cf88-4743-928f-190c514b0ccb.png)
![image](https://user-images.githubusercontent.com/69948118/180624632-bc0380dd-78ab-49e9-9070-8e2e5741f54f.png)
![image](https://user-images.githubusercontent.com/69948118/180624721-3efc471c-0b91-4e3e-b109-b4d784348769.png)
![image](https://user-images.githubusercontent.com/69948118/180624980-99ab669d-670f-4b05-8999-3d1a89251c64.png)




