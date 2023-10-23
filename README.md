# 5TWIN5-Microservice

portApp: http://localhost:8086/



docker-compose.yml : 
version: "3.8"
services:

  Client:
    container_name: COURSE
    build: .\msCourse
    ports:
      - "8089:8088"
    hostname: serviceregistry
    environment:
      - SPRING_DATASOURCE_URL=jdbc:mysql://docker-mysql_2:3306/mscourse?useLegacyDatetimeCode=false&serverTimezone=UTC
      - EUREKA_CLIENT_SERVICEURL_DEFAULTZONE=http://serviceregistry:8761/eureka/
    image: "course"
    depends_on:
      - Eureka
      - docker-mysql_2



  docker-mysql_2:
    image: "mysql:5.7"
    environment:
      - spring.datasource.username=root
      - MYSQL_ROOT_PASSWORD=faresmekni
      - MYSQL_DATABASE=mscourse
    ports:
      - 3308:3306
