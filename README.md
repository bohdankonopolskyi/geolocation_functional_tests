# IP Geolocation 

Automated tests verify that the server is really located in a specific country


## Required:
Java 11, Gradle, TestNG, Allure

## Run
Clone repo with test framework

Navigate to directory with project:


```bash
cd <directory_with_cloned_project>/geolocation_functional_tests
```

### Run with Gradle command or manually via IDE

```bash
gradle test
```

## Get Allure report

From ```geolocation_functional_tests/```

```bash
cd build
```

Run

```bash
allure generate --clean
```

Open report page ```index.html``` located in ```allure-report/```

