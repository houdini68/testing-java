# Testing the Java ecosystem

Testing the apis needed by a modern Java developer.

How many times are you stuck at customer site because you don't remember the usage of a class or a method from a well known api?

Javadoc is sometimes complicated. Not easy to read. You want an example.

I have decided to document the classes that a modern developer has a great chance to meet at customer site.

Each time I visit a site (Stackoverflow) to get some help on programming or I made some investigations on a specific topic I will try to make a test that will be documented here.

Not yet documented:
Java 13, Spring framework (Spring Boot), JPA (Hibernate), Mockito, AssertJ,...

It is an Apache Maven project and it was written using Intellij Idea.

Rudy Vissers(Belgium). English is not my mother tongue.

# What is tested?

# Java

## java.util

##### [MapTest](src/test/java/api/java/util/MapTest.java)

## java.util.function

##### [BiConsumerTest](src/test/java/api/java/util/function/BiConsumerTest.java)

##### [BiFunctionTest](src/test/java/api/java/util/function/BiFunctionTest.java)

# Guava

## com.google.common.base

##### [FunctionsTest](src/test/java/api/com/google/common/base/FunctionsTest.java)
##### [FunctionTest](src/test/java/api/com/google/common/base/FunctionTest.java) 
##### [JoinerTest](src/test/java/api/com/google/common/base/JoinerTest.java)
##### [SplitterTest](src/test/java/api/com/google/common/base/SplitterTest.java)

## com.google.common.collect

##### [FluentIterableTest](src/test/java/api/com/google/common/collect/FluentIterableTest.java)
##### [ImmutableMapTest](src/test/java/api/com/google/common/collect/ImmutableMapTest.java)

# Non compliant code

## non_compliant_code

##### [NonNullValuesShouldNotBeSeToNull](src/main/java/non_compliant_code/NonNullValuesShouldNotBeSeToNull.java)

# Model

## model

##### [PersonV1](src/main/java/model/PersonV1.java)
