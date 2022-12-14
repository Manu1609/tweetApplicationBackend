FROM public.ecr.aws/docker/library/openjdk:latest
EXPOSE 9090
ADD target/tweetApp.jar tweetApp.jar
ENTRYPOINT ["java","-jar","/tweetApp.jar"]
