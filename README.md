# Disney+ UI Test

Selenium + TestNG + Page Object Model implementation of the interview exercise.

## Requirements

- Java 25+
- Maven 3.8+
- Google Chrome

Selenium Manager resolves the matching ChromeDriver automatically.

## Run

Run with a visible Chrome window:

```bash
mvn clean test
```

The test navigates to Disney+, scrolls to the footer, opens `Privacy Policy`, verifies the privacy domain, and confirms that the Privacy Policy page loads.
