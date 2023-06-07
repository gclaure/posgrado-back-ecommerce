FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
COPY --from=build /app/build/libs/*.jar ./app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]