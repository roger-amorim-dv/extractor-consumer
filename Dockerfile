FROM openjdk:20-ea-17-jdk
EXPOSE 8080
WORKDIR /workspace/app
COPY build/libs/demo-0.0.1.jar /workspace/app/extractor-consumer.jar
COPY entrypoint.sh /workspace/app/entrypoint.sh
RUN chmod +x /workspace/app/entrypoint.sh
ENTRYPOINT ["/workspace/app/entrypoint.sh"]