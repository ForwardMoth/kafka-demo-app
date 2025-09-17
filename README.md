# Kafka Demo Application

This repository contains two Spring Boot applications that demonstrate Kafka messaging between microservices:

- kafka-producer: Service that sends messages to Kafka

- kafka-consumer: Service that consumes messages from Kafka

## Architecture

```text
HTTP Client → kafka-producer (POST /kafka/send) → Kafka Topic → kafka-consumer
```

## Prerequisites

- Java 17+
- Spring Boot 3+
- Maven
- Docker and Docker Compose
- Kafka (local installation or via Docker)

## Quick Start

### Option 1: Using Local Kafka Installation

1. Install and start Kafka locally: https://kafka.apache.org/downloads

2. Configure **.environment**. Use variables **.environment_example** from resources of app (producer/consumer)

3. Start the applications locally

## Option 2: Using Docker Compose (Recommended)

1. Start Kafka with Docker Compose:

```bash
cd docker-compose-kafka
docker-compose up -d
```

2. Configure **.environment**. Use variables from file **.environment_example** from resources of app (
   producer/consumer)

3. Start the applications locally

## Option 3: Fully Containerized with Docker Compose

1. Create environment file. Use variables from file **.env_example**.

2. Form jar files

```bash
mvn clean install
```

3. Start all services

```bash
docker-compose up -d
```

## Configuration

Copy the example environment files and configure as needed

#### For kafka-producer:

```bash
cp kafka-producer/src/main/resources/.environment_example kafka-producer/src/main/resources/.env
```

#### For kafka-consumer:

```bash
cp kafka-consumer/src/main/resources/.environment_example kafka-consumer/src/main/resources/.env
```

## Kafka Configuration

The Kafka topic is automatically created by the producer application with the following configuration:

- Topic name: test-topic

- Partitions: 3

- Replication factor: 1 (for development)

## API Usage

Send Message
Endpoint: ```POST /kafka/send```

Request:

```bash
curl -X POST http://localhost:8080/kafka/send \
-H "Content-Type: application/json" \
-d '{
"message": "My message"
}'
```

Response:

```json
{
    "status": "Message sent successfully",
    "timestamp": "2025-09-17T12:36:30.6062484"
}
```

## Verify Message Consumption

Check the kafka-consumer application logs to see consumed messages:

```text
2025-09-17T12:36:30.634+03:00  INFO 10440 --- [kafka-consumer] [ntainer#0-0-C-1] c.e.k.consumer.KafkaConsumer             : Received message: {
    "message": "My message"
}
```

## Project Structure

```text
kafka-app/
├── kafka-producer/          # Producer application
│   ├── src/main/java/
│   ├── src/main/resources/
│   └── pom.xml
├── kafka-consumer/          # Consumer application
│   ├── src/main/java/
│   ├── src/main/resources/
│   └── pom.xml
├── docker-compose-kafka/    # Kafka infrastructure
│   └── docker-compose.yml
├── docker-compose.yml       # Main application compose
├── .env_example            # Environment variables template
└── README.md
```
