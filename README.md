# Testing Java,Guava,...

By Rudy Vissers from Belgium. English is not my mother tongue.

Testing the apis needed by a modern Java developer.

How many times are you stuck at customer site because you don't remember the usage of a class or a method from a well known api?

Javadoc is sometimes complicated. Not easy to read. You want an example.

I have decided to document the classes that a modern developer has a great chance to meet at customer site.

Each time I visit a site (Stackoverflow) to get some help on programming or I made some investigations on a specific topic I will try to make a test that will be documented here.

Not yet documented:
Spring framework, Mockito, AssertJ,...

Yea, it is an Apache Maven project and it was written using Intellij Idea.

# What is tested:

# Java

## java.util

##### MapTest

## java.util.function

##### BiConsumerTest

##### BiFunctionTest

# Guava

## com.google.common.base

##### [FunctionsTest](src/test/java/api/com/google/common/base/FunctionsTest.java)
##### FunctionTest
##### JoinerTest
##### SplitterTest

## com.google.common.collect

##### FluentIterableTest
##### ImmutableMapTest

# Non compliant code

## non_compliant_code

##### NonNullValuesShouldNotBeSeToNull

# Model

## model

##### Person
