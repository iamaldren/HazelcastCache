# HazelcastCache

Sample program for Spring Boot caching, using Hazelcast as its cache manager.

## What is it for?

Spring Boot starter provides a simple cache provider which stores value in an instance of ConcurrentHashMap.

But I want to run 2 different instances of the application, and share the cache between them. Hence, I used hazelcast for this purpose.

Hazelcast has the clustering capabilities, and on top of that hazelcast is just embedded in your own application.

I am using Netflix's Eureka to detect hazelcast instances.

## How to run

### Pre-requisites
- Eureka (This is easy to do with Spring Boot, and you can check my sample code [here](https://github.com/iamaldren/Eureka-Server))
- Java 11
- Maven
- MariaDB

### Running the program

<WIP>


## TODO
- Unit Testing

## Useful Links
- [Hazelcast Code Samples](https://github.com/hazelcast/hazelcast-code-samples/tree/master/hazelcast-integration)
- [Hazelcast Persistence with MySQL](https://www.tvajjala.in/2014/05/hazelcast-persistence-with-mysql.html)