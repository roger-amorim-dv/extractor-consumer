FROM openjdk:17-alpine
EXPOSE 8080
WORKDIR /workspace/app
COPY build/libs/demo-0.0.1.jar /workspace/app/extractor-consumer.jar
COPY entrypoint.sh /workspace/app/entrypoint.sh
RUN chmod +x /workspace/app/entrypoint.sh
ENTRYPOINT ["/workspace/app/entrypoint.sh"]