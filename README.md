# Testing the Java ecosystem

This file is cached into your browser. Reload to get the latest changes.

Testing the APIs needed by a modern Java developer.

How many times are you in search of the usage of a class or a method of a well-known api?
Javadoc is sometimes complicated and not easy to read. You want an example.

I have decided to document the classes/APIs that a modern developer has a great chance to meet at customer site.

Each time I visit a site (Stackoverflow) to get some help on programming, or I made some investigations on a specific topic I will try to create a test that will be documented here.

It is an Apache Maven project, and it was developed using Intellij Idea.

Rudy Vissers [Belgium]
-

## Tested on JDK 8 - 101 tests
#### To be documented:guava-cache

# Java lang

##### [IntegerTest](src/test/java/api/java/lang/IntegerTest.java)
##### [BoxingUnboxingTest](src/test/java/api/java/lang/BoxingUnboxingTest.java)
##### [ShutdownHookDemo](src/main/java/api/java/lang/ShutdownHookDemo.java) 

# Java core

##### [Comparisons](src/test/java/core/Comparisons.java)
##### [EnumTest](src/test/java/core/EnumTest.java)
##### [SwitchTest](src/test/java/core/SwitchTest.java)

# Collections
##### [ListTest](src/test/java/core/collection/ListTest.java)
* merge lists
##### [MapTest](src/test/java/api/java/util/MapTest.java)

# Java Util 

##### [Util](src/main/java/util/Util.java)
##### [UtilTest](src/test/java/util/UtilTest.java)
###### mapToBoolean

# Lamda

##### [BiConsumerTest](src/test/java/api/java/util/function/BiConsumerTest.java)
##### [BiFunctionTest](src/test/java/api/java/util/function/BiFunctionTest.java)

# Streams

##### [FlatMapTest](src/test/java/api/java/util/stream/FlatMapTest.java) 

# Optional
#### Without Optional (don't do that!)
##### [AbsenceOfValueByNull](src/test/java/api/java/util/optional/absenceofvaluebynull/AbsenceOfValueByNullTest.java)
#### With Optional
##### [OptionalTest](src/test/java/api/java/util/optional/OptionalTest.java) 

# Behavior Parameterization

##### [FilterApple](src/main/java/se/behaviorparameterization/filter/FilterApple.java)
##### [FilterAppleTest](src/test/java/se/behaviorparameterization/filter/FilterAppleTest.java)
###### functional interface:
##### [ApplePredicate](src/main/java/se/behaviorparameterization/predicate/ApplePredicate.java)
##### [AppleGreenColorPredicate](src/main/java/se/behaviorparameterization/predicate/AppleGreenColorPredicate.java)
##### [AppleHeavyWeightPredicate](src/main/java/se/behaviorparameterization/predicate/AppleHeavyWeightPredicate.java)
##### [AppleRedAndHeavyPredicate](src/main/java/se/behaviorparameterization/predicate/AppleRedAndHeavyPredicate.java)
##### [AppleTest](src/test/java/se/behaviorparameterization/AppleTest.java)
###### functional interface:
##### [AppleFormatter](src/main/java/se/behaviorparameterization/formatter/AppleFormatter.java)
##### [AppleSimpleFormatter](src/main/java/se/behaviorparameterization/formatter/AppleSimpleFormatter.java)
##### [AppleFancyFormatter](src/main/java/se/behaviorparameterization/formatter/AppleFancyFormatter.java)

# Java nio

##### [FilesTest](src/test/java/api/java/nio/file/FilesTest.java) 

# Design patterns

##### [ClassSingleton](src/main/java/dp/singleton/ClassSingleton.java)
##### [EnumSingleton](src/main/java/dp/singleton/EnumSingleton.java)
##### [ClassSingletonTest](src/test/java/dp/singleton/ClassSingletonTest.java)
##### [EnumSingletonTest](src/test/java/dp/singleton/EnumSingletonTest.java)

# Non compliant code - IDE

##### [NonNullValuesShouldNotBeSeToNull](src/main/java/non_compliant_code/NonNullValuesShouldNotBeSeToNull.java)
###### Nonnull
###### ParametersAreNonnullByDefault
###### ParametersAreNullableByDefault

# Guava

#### Passing behaviour

##### [FunctionsTest](src/test/java/api/com/google/common/base/FunctionsTest.java)
##### [FunctionTest](src/test/java/api/com/google/common/base/FunctionTest.java)

#### Joiner, Splitter

##### [JoinerTest](src/test/java/api/com/google/common/base/JoinerTest.java)
##### [SplitterTest](src/test/java/api/com/google/common/base/SplitterTest.java)

#### Collections 
##### [FluentIterableTest](src/test/java/api/com/google/common/collect/FluentIterableTest.java)
##### [ImmutableMapTest](src/test/java/api/com/google/common/collect/ImmutableMapTest.java)

#### Misc
##### [MoreObjectsTest](src/test/java/api/com/google/common/base/MoreObjectsTest.java)


# Apache lang3

##### [StringUtilsTest](src/test/java/api/org/apache/commons/lang3/StringUtilsTest.java)

# AssertJ

##### [AssertionsTest](src/test/java/api/org/assertj/core/api/AssertionsTest.java)

# Mockito

##### [ArgumentMatchersTest](src/test/java/api/org/mockito/ArgumentMatchersTest.java)
##### [CaptorTest](src/test/java/api/org/mockito/CaptorTest.java)
##### [InjectMocksTest](src/test/java/api/org/mockito/InjectMocksTest.java)
##### [MockTest](src/test/java/api/org/mockito/MockTest.java)
##### [SpyTest](src/test/java/api/org/mockito/SpyTest.java)
##### [VerifyTest](src/test/java/api/org/mockito/VerifyTest.java)

# Joda

##### [PeriodFormatterBuilderTest](src/test/java/api/org/joda/time/format/PeriodFormatterBuilderTest.java)
##### [SimpleDateFormatToJodaDateTimeFormatTest](src/test/java/api/org/joda/time/format/SimpleDateFormatToJodaDateTimeFormatTest.java)
###### Migration from java.text.SimpleDateFormat (not thread-safe to org.joda.time.format.DateTimeFormatter thread-safe).

# Jackson

#### Constructor injection

##### [ConstructorInjectionTest](src/test/java/api/com/fasterxml/jackson/ConstructorInjectionTest.java)

# JSONObject

##### [JSONObjectTest](src/test/java/api/org/json/JSONObjectTest.java)

# Spring (to move somewhere else)

#### Wiring of a bean. Java configuration.
##### [HelloSpringTest](src/test/java/springframework/hello/HelloSpringTest.java)
##### [Hello.java](src/test/java/springframework/hello/Hello.java)
##### [Config.java](src/test/java/springframework/hello/Config.java)

## Cheat sheet
##### Functional Interfaces
Class | Method | Input | Output
-------------- | ------------- | -------------  | -------------
BiFunction<T, U, R> | apply | T, U | R

