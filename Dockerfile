# ====== STAGE 1: BUILD ======
FROM maven:3.9.9-eclipse-temurin-17 AS build

WORKDIR /app

# Copia apenas arquivos necessários primeiro (melhora cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copia o restante do projeto
COPY src ./src

# Build da aplicação
RUN mvn clean package -DskipTests


# ====== STAGE 2: RUNTIME ======
FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

# Copia o jar gerado
COPY --from=build /app/target/*.jar app.jar

# Porta padrão (Render usa variável PORT)
EXPOSE 8080

# Start da aplicação
ENTRYPOINT ["java","-jar","app.jar"]