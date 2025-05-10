# Project Test Execution Instructions

This guide provides instructions for running tests in the project using Maven. The tests can be executed for specific projects and test classes using the following commands.

## 1. Run Tests for the `orangehr` Project

To run tests for the `orangehr` project, such as `LoginTests`, `TableElementTest`, and `UserRoleDropDownTests`, use the following command:

```bash
mvn -Dproject=orangehr -Dtest="LoginTests,TableElementTest,UserRoleDropDownTests" test
```

## 2. Run Tests for the `userinyerface` Project

To run tests for the `userinyerface` project, for example, `IntroductionTests`, use the following command:

```bash
mvn -Dproject=userinyerface -Dtest=IntroductionTests test
```
## 3. Run a Specific Test Method

To run a specific test method, for example, `userFormNavigationSuccessful` from the `IntroductionTests` class, use the following command:

```bash
mvn -Dproject=userinyerface -Dtest=IntroductionTests#userFormNavigationSuccessful test
```
