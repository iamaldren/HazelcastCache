# HazelcastCache

This project uses Spring Boot caching mechanism, with Hazelcast as its Cache Manager.

## How it works

You can run 2 instances, and it should be able to share the cache for that 2 instance. 

I am leveraging of the clustering capabilities of Hazelcast, and using Eureka for service discovery.

## To be solved

com.hazelcast.nio.serialization.HazelcastSerializationException: There is no suitable serializer
