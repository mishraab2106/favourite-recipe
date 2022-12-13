FROM openjdk:8
ARG JAR_FILE=target/favourite-recipe.jar
COPY ${JAR_FILE} favourite-recipe.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/favourite-recipe.jar"]