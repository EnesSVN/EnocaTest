# Enoca Test

### Teknolojiler
    1. [Java](www.java.com)
    2. [Spring Boot](https://spring.io/projects/spring-boot)
    3. [Maven](https://maven.apache.org/)
    4. [H2 Database](https://www.h2database.com/html/main.html)
    5. [Hibernate] (https://hibernate.org/)

## Yapılan araçlar
    1. [Git](www.git-scm.com)
    2. [GitHub](www.github.com)
    3. [IntelliJ IDEA](www.jetbrains.com)

## Neler yapılmıştır?
    1. [x] Spring Boot projesi oluşturuldu.
    2. [x] H2 Database oluşturuldu.
    3. [x] Entity oluşturuldu.
    4. [x] Repository oluşturuldu.
    5. [x] Service oluşturuldu.
    6. [x] Controller oluşturuldu.
    7. [x] Test oluşturuldu.
    8. [x] ReadMe oluşturuldu.


## Api Dokümantasyonu
### Open Api Dokümantasyonu
    [swagger] (http://localhost:8081/swagger-ui.html)
### Tutorial

    1. [List](http://localhost:8081/api/v1/tutorials)
    2. [Find](http://localhost:8081/api/v1/tutorial/1)
    3. [Create](http://localhost:8081/api/v1/create/tutorial)
    4. [Update](http://localhost:8081/api/v1/update/tutorial/1)
    5. [Delete](http://localhost:8081/api/v1/delete/tutorial/1)

### Comment

    1. [List](ttp://localhost:8081/tutorials/1/comment)
    2. [Find](http://localhost:8081/comment/1)
    3. [Create](http://localhost:8081/tutorial/1/comment)
    4. [Update](http://localhost:8081/update/comment/1)
    5. [Delete](http://localhost:8081/delete/comment/1)

## Test Verileri
### Tutorial
    {
    "title":"title1",
    "description":"description1",
    "published":true
    }
    {
    "title":"title2",
    "description":"description2",
    "published":true
    }
### Comment
    {
    "content": "content1"
    }
    {
    "content": "content2"
    }


