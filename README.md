# HazelcastCache

Sample program for Spring Boot caching, using Hazelcast as its cache manager.

## What is it for?

Spring Boot starter provides a simple cache provider which stores value in an instance of ConcurrentHashMap.

But I want to run 2 different instance of your application, and share the cache between these 2 instances. Hence, I used hazelcast for this purpose.

Hazelcast has the clustering capabilities, and on top of that hazelcast is just embedded in your own application.

I am using Netflix's Eureka to detect hazelcast instances.

## How to run

### Pre-requisites
- Eureka (This is easy to do with Spring Boot, and you can check my sample code [here](https://github.com/iamaldren/Eureka-Server))
- Java 11
- Maven

### Running the program

1. Run an instance of Eureka server. It should be started at http://localhost:8761 or to whatever port you used.
2. Make sure bootstrap.properties for this program is pointed to your Eureka server instance.
3. Run the program by using java -jar command.
4. Run another instance by starting on a different port.
5. You should see 2 services registered in your Eureka server.
6. Hit the url http://localhost:<your_port>/student/1
7. On the console, you should see an output call with "Searching by ID : 1" and "Simulating back-end call."
8. If you hit the same URL, you should only see "Searching by ID : 1", and the back-end wasn't hit anymore as the record was taken from the cache.
9. Hit the same ID on your 2nd instance. E.g. http://localhost:<your_port_2>/student/1
10. You should only see "Searching by ID : 1"


## TODO
- Actual database implementation (MariaDB)
- Add @CachePut for updating records, in the database and in the cache
