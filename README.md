# springboot-apachekafka

<p> apache kafka is a message broker used for real time data streaming</p>

## Kafka Ecosystem
<p>Apacke Kafka is a distributed system so it act as a kafka cluster. Kafka cluster has one or more broker</p>

![IMG_6440](https://user-images.githubusercontent.com/48306820/235588972-23cb41bf-c24f-4334-9fa7-9d42f6720bee.jpeg)

<p>
 <li>
    Producer can produce any kind of message it can be plainset, string, json
 </li>
 <li>
    Producer produce the message and it will send the message to kafka cluster
 </li>
 <li>
    Consumer consume message from kafka cluster
 </li>
 <li>
    Zookeper manage state of call kafka brokers
 </li>
 <li>
    Apache kafka cluster is capable for fault tolerance meaning if any one broker goes down then it will manage other node as well
 </li>
</p>

## Kafka Cluster
<p>
<li>
    Apache Kafka is a distributed, it act as a cluster
</li>
<li>
    A Kafka cluster consist of a set of broker, a clusters has a minimum of 3 brokers
</li>
</p>

![IMG_6439](https://user-images.githubusercontent.com/48306820/235589017-bf8a143a-bc22-4e50-8d03-70de39589901.jpeg)


## Kafka Broker
<p>
The Broker is a kafka server,it just a meaningfull name given to the kafka server, and this name makes sense as well because all the kafka does is act as a message broker b.w producer and consumer.

The producer and consumer don't interact directly , then use kafka server as an agent or a broker to exchange message
</p>

## Producer
<p>
Producer is an application that send message it does not send message directly to the recipient , it send message only to the kafka server
</p>

## Producer
<p>
Consumer is a application that read message from kafka server. If produceres are sending data , they must be sending it to someone right . the consumer are recipient but remeber producer dont send it to consumer address.

They send message to kafka server and anyone who is intrested in to take that message will come forward and take that message from server
</p>

## Kafka Topic
<p>
We learned that producer send message to kafka broker, then a consumer can ask for data from the kafka broker, but the question is which data ? we need to have some indentification mechanism to request data from the kafka broker there come the notation of the topic

<li>
Topic is like a table in DB os folder in file system
</li>
<li>
Topic is identified by name
</li>
<li>
You can have any number of topics
</li>
</p>

## How to start Kafka
<p>Run the following commands in order to start all services in the correct order:</p>


`bin/zookeeper-server-start.sh config/zookeeper.properties`

<br>

<p>Start the Kafka broker service</p>

`bin/kafka-server-start.sh config/server.properties`
<br>

<p>Read the events</p>

`bin/kafka-console-consumer.sh --topic <your topic name> --from-beginning --bootstrap-server localhost:9092`

<br><br>

## application.properties file

```
spring.kafka.consumer.bootstrap-servers: localhost:9092

# consumer group id
spring.kafka.consumer.group-id:myGroup
spring.kafka.consumer.auto-offset-reset:earliest
spring.kafka.consumer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer: org.apache.kafka.common.serialization.StringDeserializer

# producer config
spring.kafka.producer.boostrap-servers:localhost:9092
spring.kafka.producer.key-serializer: org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer: org.apache.kafka.common.serialization.StringSerializer

```

## Sending message from producer to kafka topic 

![Screenshot 2023-05-02 at 11 43 57 AM](https://user-images.githubusercontent.com/48306820/235592490-b8d93436-fb7b-489d-bad3-88194978ddf9.jpeg)


## Configure kafka producer and consumer for JSON serializer and deserializer 

<p>
How to send and recieve a Java object as a JSON byte[] to and from Apache Kafka.

Apache kafka stores and transport byte[]. There are a number of built-in serializers and deserializers but it doesn't include any for JSON. Spring Kafka created a JsonSerializer and JsonDeserializer which we can use to convert Java objects to and from JSON

We'll send a Java object as JSON byte[] to a kafka Topic using a JsonSerializer. Afterward we'll configure how to recieve a JSON byte[] and automatically convert it to a Java Object using a JsonDeserializer
</p>


## application.properties file

<p>Using Deserializer & Serializer in place of String</p>

```
spring.kafka.consumer.bootstrap-servers: localhost:9092

# consumer group id
spring.kafka.consumer.group-id:myGroup
spring.kafka.consumer.auto-offset-reset:earliest
spring.kafka.consumer.key-deserializer: org.apache.kafka.common.serialization.StringDeserializer
#spring.kafka.consumer.value-deserializer: org.apache.kafka.common.serialization.StringDeserializer
spring.kafka.consumer.value-deserializer: org.springframework.kafka.support.serializer.JsonDeserializer
spring.kafka.consumer.properties.spring.json.trusted.packages=*

# producer config
spring.kafka.producer.boostrap-servers:localhost:9092
spring.kafka.producer.key-serializer: org.apache.kafka.common.serialization.StringSerializer
#spring.kafka.producer.value-serializer: org.apache.kafka.common.serialization.StringSerializer
spring.kafka.producer.value-serializer: org.springframework.kafka.support.serializer.JsonSerializer
```

<img width="1440" alt="Screenshot 2023-05-02 at 12 35 31 PM" src="https://user-images.githubusercontent.com/48306820/235601550-bc672af1-f104-4731-9376-cb4e4fb4f0d2.png">
