FROM container-registry.oracle.com/graalvm/native-image:21.0.0-ol9-20230919 AS builder
COPY . .

RUN ./mvnw -B org.apache.maven.plugins:maven-dependency-plugin:3.1.2:go-offline

RUN ./mvnw -Pnative native:compile


FROM container-registry.oracle.com/os/oraclelinux:9-slim
COPY --from=builder /app/target/fiscal /fiscal
EXPOSE 30001 30002
ENTRYPOINT ["/fiscal", "-Xms64m", "-Xmx120m"]