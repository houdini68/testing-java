# Testing the Java ecosystem

Testing the apis needed by a modern Java developer.

How many times are you stuck at customer site because you don't remember the usage of a class or a method from a well known api?

Javadoc is sometimes complicated. Not easy to read. You want an example.

I have decided to document the classes that a modern developer has a great chance to meet at customer site.

Each time I visit a site (Stackoverflow) to get some help on programming or I made some investigations on a specific topic I will try to make a test that will be documented here.

It is an Apache Maven project and it was written using Intellij Idea.

Rudy Vissers(Belgium).

# Software Engineering

## Behavior Parameterization

#### [FilterApple](src/main/java/se/behaviorparameterization/FilterApple.java)
#### [Apple](src/main/java/se/behaviorparameterization/Apple.java)
#### [Color](src/main/java/se/behaviorparameterization/Color.java)
#### [BehaviorParameterizationTest](src/test/java/se/behaviorparameterization/BehaviorParameterizationTest.java)

# Springframework
## core
##### [HelloSpringTest](src/test/java/springframework/HelloSpringTest.java)
###### Wiring of a bean. Java configuration.

# Util
#### [Util](src/main/java/util/Util.java)
###### String mapToBoolean(String value, String defaultValue)
#### [UtilTest](src/test/java/util/UtilTest.java)

# Java

## Core language

##### [SwitchTest](src/test/java/corelanguage/SwitchTest.java)

## java.lang

##### [demo shutdown hook](src/main/java/api/java/lang/ShutdownHookDemo.java) 
##### [WrapperTest](src/test/java/api/java/lang/WrapperTest.java) 

## java.nio.file

##### [FilesTest](src/test/java/api/java/nio/file/FilesTest.java) 

## java.util.function

##### [BiConsumerTest](src/test/java/api/java/util/function/BiConsumerTest.java)
##### [BiFunctionTest](src/test/java/api/java/util/function/BiFunctionTest.java)

## java.util.stream

##### [FlatMapTest](src/test/java/api/java/util/stream/FlatMapTest.java) 

## java.util

##### [MapTest](src/test/java/api/java/util/MapTest.java)

# Joda

## org.joda.time.format

#### [PeriodFormatterBuilderTest](src/test/java/api/org/joda/time/format/PeriodFormatterBuilderTest.java)

# Guava

## com.google.common.base

##### [FunctionsTest](src/test/java/api/com/google/common/base/FunctionsTest.java)
##### [FunctionTest](src/test/java/api/com/google/common/base/FunctionTest.java) 
##### [JoinerTest](src/test/java/api/com/google/common/base/JoinerTest.java)
##### [MoreObjectsTest](src/test/java/api/com/google/common/base/MoreObjectsTest.java) [not yet tested]
##### [SplitterTest](src/test/java/api/com/google/common/base/SplitterTest.java)

## com.google.common.collect

##### [FluentIterableTest](src/test/java/api/com/google/common/collect/FluentIterableTest.java)
##### [ImmutableMapTest](src/test/java/api/com/google/common/collect/ImmutableMapTest.java)

# Testing

# Mockito

## org.mockito

##### [MockTest](src/test/java/api/org/mockito/MockTest.java)
##### [SpyTest](src/test/java/api/org/mockito/SpyTest.java)
##### [CaptorTest](src/test/java/api/org/mockito/CaptorTest.java)
##### [InjectMocksTest](src/test/java/api/org/mockito/InjectMocksTest.java)
##### [VerifyTest](src/test/java/api/org/mockito/VerifyTest.java)
##### [Service](src/main/java/api/org/mockito/injectsmocks/Service.java)
##### [Service1](src/main/java/api/org/mockito/injectsmocks/Service1.java)
##### [Service2](src/main/java/api/org/mockito/injectsmocks/Service2.java)

# AssertJ

## org.assertj.core.api

##### [AssertionsTest](src/test/java/api/org/assertj/core/api/AssertionsTest.java)
###### assertThat
###### assertThatThrownByTest
###### catchTrowableTest
##### [Race](src/test/java/api/org/assertj/core/api/AssertionsTest.java)
##### [TolkienCharacter](src/test/java/api/org/assertj/core/api/AssertionsTest.java)

# Code analysis

# Non compliant code analyzed by the IDE

## Nonnull annotation

##### [NonNullValuesShouldNotBeSeToNull](src/main/java/non_compliant_code/NonNullValuesShouldNotBeSeToNull.java)

# Model

## model

##### [PersonV1](src/main/java/model/PersonV1.java)

