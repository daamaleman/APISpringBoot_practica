# Etapa 1: Construcción (Build)
FROM maven:3-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Ejecución (Run)
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Copiamos explícitamente el archivo .war y lo renombramos a app.war
COPY --from=build /app/target/*.war app.war
EXPOSE 8080
# Ejecutamos el archivo .war
ENTRYPOINT ["java", "-jar", "app.war"]