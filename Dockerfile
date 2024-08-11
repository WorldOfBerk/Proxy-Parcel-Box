FROM gradle:latest
WORKDIR /app
COPY . /app
EXPOSE 8080
ENTRYPOINT ["gradle","bootRun"]
