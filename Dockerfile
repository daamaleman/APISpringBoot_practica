# Etapa 1: Construcción (Build)
FROM maven:3-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Compilamos y borramos cualquier archivo secundario (-plain.jar) que cause conflictos
RUN mvn clean package -DskipTests && rm -f target/*-plain.jar

# Etapa 2: Ejecución (Run)
FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
# Copiamos el archivo principal (sea .jar o .war) y lo nombramos app.jar
COPY --from=build /app/target/*.*AR app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]