# IMAGEN MODELO
FROM eclipse-temurin:17.0.13_11-jdk

# INFORMAR PUERTO DE LA APLICACION
EXPOSE 8080

# DIRECTORIO RAIZ
WORKDIR /root

# COPIAR ARCHIVOS DENTRO DEL CONTENEDOR
COPY ./pom.xml /root
COPY ./.mvn /root/.mvn
COPY ./mvnw /root

# DESCARGAR DEPENDENCIAS
RUN ./mvnw dependency:go-offline

# COPIAR EL CODIGO FUENTE DENTRO DEL CONTENEDOR
COPY ./src /root/src

# CONSTRUIR EL PROYECTO
RUN ./mvnw clean install -DskipTests

# LEVANTANDO NUESTRA APLICACION
ENTRYPOINT [ "java", "-jar", "/root/target/franquicias-1.2.0.jar" ]