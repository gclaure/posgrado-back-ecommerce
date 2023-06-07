FROM openjdk:11
RUN mvn clean package
VOLUME /tmp
EXPOSE 8080
ADD posgrado-ecommerce-0.0.1.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]