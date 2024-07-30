# StringCalculator - TDD Development

## Overview

This project implements a `StringCalculator` class using Test-Driven Development (TDD) principles. The calculator can handle various custom delimiters, including multi-character delimiters, and can validate and sum integers from a string input. The tests for this project are written using the JUnit Jupiter API.

## Features

- **Basic Arithmetic**: Sum integers from a string, handling default delimiters (comma and newline).
- **Custom Delimiters**: Support for single-character and multi-character custom delimiters.
- **Error Handling**: Detect and report negative numbers.
- **Ignore Large Numbers**: Numbers greater than 1000 are ignored in the sum.

## Setup

### Prerequisites

- Java 18 or higher
- Maven (for dependency management and build automation)


### Installation steps
1. **Clone the repository**
  ```bash
  git clone https://github.com/Vishwadeep17/String_Calculator_TDD.git
  ```
2. **Navigate to the project directory**
  ```bash
  cd String_Calculator_TDD
  ```
3. **Build the project**
  ```bash
  mvn install
  ```
4. **Run the test cases**
  ```bash
  mvn test
  ```

### Dependencies

The project uses JUnit Jupiter for testing. Ensure the following dependency is included in your `pom.xml`:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter-api</artifactId>
    <version>5.8.2</version>
    <scope>test</scope>
</dependency>
```

