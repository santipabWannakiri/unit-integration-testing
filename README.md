# unit-integration-testing
## Introduction
When delving into Spring Boot testing, I initially found it confusing due to the abundance of terms and frameworks associated with it, such as JUnit, Mockito, Spring Boot Test, MockMvc, TestNG, RestTemplate, and more. Each of these frameworks serves a specific purpose in simplifying the process of writing tests in Spring Boot.

However, before deciding which framework to utilize for writing tests, it's essential to take a step back and start with the fundamental concept of "Types of Testing." Understanding the different types of software testing will help us determine which specific framework is best suited for each type of testing scenario in the Spring Boot environment.

In regard to this, I'll share some methods for testing as well as a few frameworks that perform well with Spring Boot Test.

## Types of Testing
We can divide the type of testing into two majority groups as follows:
1. Functional testing typically involves testing individual functions, modules, or components of the software to check if they behave as expected.
2. Non-functional testing is focused on evaluating aspects of the software application that are not directly related to its specific functions or features. Instead, it aims to assess the software's quality attributes and characteristics that contribute to its overall performance, usability, and reliability.

I'd like to advise looking at the illustration below for more details.
![enter image description here](images/TypeOfTesting.png)


## Unit Testing and Integration Testing
