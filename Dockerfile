# Usa una imagen base con JDK
FROM openjdk:17-jdk

# Copia el JAR construido en el contenedor
COPY target/plants-0.0.1-SNAPSHOT.jar /app.jar

# Expon el puerto en el que la aplicación escuchará
EXPOSE 8080

# Define el comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app.jar"]
