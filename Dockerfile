FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY target/teste-0.0.1-SNAPSHOT.jar app.jar
ENV POSTGRES_URL=jdbc:postgresql://postgres-db:5432/teste_sicredi \
    POSTGRES_USER=hudson \
    POSTGRES_PASSWORD=hudson123
EXPOSE 7000
ENTRYPOINT ["java", "-jar", "app.jar"]