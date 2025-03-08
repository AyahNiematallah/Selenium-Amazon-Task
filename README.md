# Amazon Shopping Automation Framework

This project is an automated testing framework for Amazon.eg shopping functionality using Selenium WebDriver with Java and TestNG.

## Prerequisites

- Java JDK 11 or higher
- Maven 3.6 or higher
- Chrome browser

## Project Structure

```
project-root/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/amazon/
│   │   │       ├── pages/      # Page Object classes
│   │   │       └── utils/      # Utility classes
│   │   └── resources/          # Configuration files
│   └── test/
│       └── java/
│           └── com/amazon/
│               └── tests/       # Test classes
├── pom.xml
└── README.md
```

## Setup

1. Clone the repository:
```bash
git clone <repository-url>
```

2. Update configuration:
   Edit `src/main/resources/config.properties` with your Amazon credentials and preferences:
   ```properties
   username=your_email@example.com
   password=your_password
   maxPrice=15000
   ```

## Running Tests

1. Using Maven:
```bash
mvn clean test
```

2. Using TestNG XML:
   - Right-click on `testng.xml`
   - Select "Run As" > "TestNG Suite"

## Framework Features

- Page Object Model design pattern
- Data-driven approach using properties file
- Reusable components
- TestNG for test execution
- Maven for dependency management
- WebDriverManager for browser driver management

## Dependencies

- Selenium WebDriver
- TestNG
- WebDriverManager

## Notes

- The framework is configured to run tests on Chrome browser by default
- All dependencies are managed through Maven
- Test results can be found in the `test-output` directory after execution 