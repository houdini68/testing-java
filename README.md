# Testing the Java ecosystem

Testing the APIs needed by a modern Java developer.

How many times are you stuck at customer site because you don't remember the usage of a class or a method from a well known api?

Javadoc is sometimes complicated. Not easy to read. You want an example.

I have decided to document the classes/APIs that a modern developer has a great chance to meet at customer site.

Each time I visit a site (Stackoverflow) to get some help on programming or I made some investigations on a specific topic I will try to create a test that will be documented here.

It is an Apache Maven project and it was developed using Intellij Idea.

Rudy Vissers(Belgium).

# Tested on JDK 8 - 81 tests

##### [Test Results](TestResults-All_in_testing-java.html)

# Java lang

##### [ShutdownHookDemo](src/main/java/api/java/lang/ShutdownHookDemo.java)

# Design Patterns

##### [ClassSingleton](src/main/java/dp/singleton/ClassSingleton.java)
##### [EnumSingleton](src/main/java/dp/singleton/EnumSingleton.java)

# Non compliant code

##### [NonNullValuesShouldNotBeSeToNull](src/main/java/non_compliant_code/NonNullValuesShouldNotBeSeToNull.java)
###### Nonnull
###### ParametersAreNonnullByDefault
###### ParametersAreNullableByDefault

# Java 8

##### [FilterApple](src/main/java/se/behaviorparameterization/FilterApple.java)

# Java Util 

##### [Util](src/main/java/util/Util.java)
###### mapToBoolean

# Jackson

#### Constructor injection

##### [ConstructorInjectionTest](src/test/java/api/com/fasterxml/jackson/ConstructorInjectionTest.java)

# Guava

##### [FunctionsTest](src/test/java/api/com/google/common/base/FunctionsTest.java)
##### [FunctionTest](src/test/java/api/com/google/common/base/FunctionTest.java) 
##### [JoinerTest](src/test/java/api/com/google/common/base/JoinerTest.java)
##### [MoreObjectsTest](src/test/java/api/com/google/common/base/MoreObjectsTest.java)
##### [SplitterTest](src/test/java/api/com/google/common/base/SplitterTest.java)

##### [FluentIterableTest](src/test/java/api/com/google/common/collect/FluentIterableTest.java)
##### [ImmutableMapTest](src/test/java/api/com/google/common/collect/ImmutableMapTest.java)

# Java lang

##### [BoxingUnboxingTest](src/test/java/api/java/lang/BoxingUnboxingTest.java)
##### [IntegerTest](src/test/java/api/java/lang/IntegerTest.java)

# Java nio

##### [FilesTest](src/test/java/api/java/nio/file/FilesTest.java) 

# Java 8

##### [BiConsumerTest](src/test/java/api/java/util/function/BiConsumerTest.java)
##### [BiFunctionTest](src/test/java/api/java/util/function/BiFunctionTest.java)

##### [FlatMapTest](src/test/java/api/java/util/stream/FlatMapTest.java) 

##### [MapTest](src/test/java/api/java/util/MapTest.java)

# Apache lang3

##### [StringUtilsTest](src/test/java/api/org/apache/commons/lang3/StringUtilsTest.java)

# AssertJ

##### [AssertionsTest](src/test/java/api/org/assertj/core/api/AssertionsTest.java)

# Joda

##### [PeriodFormatterBuilderTest](src/test/java/api/org/joda/time/format/PeriodFormatterBuilderTest.java)

# Mockito

##### [ArgumentMatchersTest](src/test/java/api/org/mockito/ArgumentMatchersTest.java)
##### [CaptorTest](src/test/java/api/org/mockito/CaptorTest.java)
##### [InjectMocksTest](src/test/java/api/org/mockito/InjectMocksTest.java)
##### [MockTest](src/test/java/api/org/mockito/MockTest.java)
##### [SpyTest](src/test/java/api/org/mockito/SpyTest.java)
##### [VerifyTest](src/test/java/api/org/mockito/VerifyTest.java)

# Java core

##### [Comparisons](src/test/java/core/Comparisons.java)

##### [EnumTest](src/test/java/api/java/core/EnumTest.java)

##### [SwitchTest](src/test/java/api/java/core/SwitchTest.java)

# Design patterns

##### [ClassSingletonTest](src/test/java/dp/singleton/ClassSingletonTest.java)
##### [EnumSingletonTest](src/test/java/dp/singleton/EnumSingletonTest.java)

# Java 8

##### [BehaviorParameterizationTest](src/test/java/se/behaviorparameterization/BehaviorParameterizationTest.java)
##### [FilterApple](src/main/java/se/behaviorparameterization/FilterApple.java)

# Spring (to move somewhere else)

#### Wiring of a bean. Java configuration.
##### [HelloSpringTest](src/test/java/springframework/HelloSpringTest.java)

# Java util
 
##### [UtilTest](src/test/java/util/UtilTest.java)
######mapToBoolean

