FROM openjdk:15-alpine
VOLUME /tmp
ADD /target/canned-lab-backend.jar canned-lab-backend.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/canned-lab-backend.jar"]