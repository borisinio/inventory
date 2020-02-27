FROM openjdk:8
EXPOSE 8080
ADD target/inventory.jar docker.jar
ENTRYPOINT ["java","-jar","docker.jar"]