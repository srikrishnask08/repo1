FROM openjdk:17
COPY target/RestfulProject-Unidirectional-3.0.5.war RestfulProject-Unidirectional-3.0.5.war 
EXPOSE 8888
ENTRYPOINT ["java","-war","/RestfulProject-Unidirectional-3.0.5.war"]