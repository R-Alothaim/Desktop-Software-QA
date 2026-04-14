# Quiz App for Desktop

![Java](https://img.shields.io/badge/Java-11+-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.6+-C71A36?style=for-the-badge&logo=apache-maven&logoColor=white)
![Swing](https://img.shields.io/badge/Swing-GUI-007396?style=for-the-badge&logo=java&logoColor=white)
![JavaFX](https://img.shields.io/badge/JavaFX-13-3776AB?style=for-the-badge&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=mysql&logoColor=white)

A desktop quiz application built with Java Swing that tests users on computer science topics. It features a database-backed login system, two quiz modes (35-question and full bank), randomized answer order, lifelines (50:50 and hint), timed questions, and a score summary screen.

---

## Table of Contents

- [Architecture](#architecture)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Environment Setup](#environment-setup)
- [Build and Run](#build-and-run)
- [Configuration](#configuration)
- [Screenshots](#screenshots)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

## Architecture

The codebase follows a layered package layout under `com.qaisr`:

| Layer | Responsibility |
|-------|----------------|
| `config` | Externalised database configuration via environment variables |
| `model` | Domain data classes (`Question`) |
| `ui` | Swing frames and panels (`LoginFrame`, `QuizPanel`, `ScorePanel`, `TimerDisplay`) |
| `service` | Quiz orchestration (`QuizService` for full bank, `QuizShortService` for 35-question mode) |
| `util` | Shared helpers (`AnswerShuffler`) |

See [`docs/ARCHITECTURE.md`](docs/ARCHITECTURE.md) for a deeper walkthrough.

## Project Structure

```
Desktop-app/
├── pom.xml
├── .editorconfig
├── .gitattributes
├── LICENSE
├── docs/
│   └── ARCHITECTURE.md
├── src/
│   └── main/
│       ├── java/
│       │   ├── module-info.java
│       │   └── com/qaisr/
│       │       ├── QuizApplication.java        # Entry point
│       │       ├── config/
│       │       │   └── DatabaseConfig.java      # DB connection constants
│       │       ├── model/
│       │       │   └── Question.java            # Question data model
│       │       ├── ui/
│       │       │   ├── LoginFrame.java          # Login screen (Swing JFrame)
│       │       │   ├── LoginFrame.form          # NetBeans form descriptor
│       │       │   ├── QuizPanel.java           # Question display panel
│       │       │   ├── ScorePanel.java          # Score summary panel
│       │       │   └── TimerDisplay.java        # Timer utility
│       │       ├── service/
│       │       │   ├── QuizService.java         # Full quiz runner
│       │       │   └── QuizShortService.java    # 35-question quiz runner
│       │       └── util/
│       │           └── AnswerShuffler.java      # Answer randomisation
│       └── resources/
│           ├── application.properties
│           └── com/qaisr/
│               ├── ui/
│               │   ├── fifty-fifty.png          # 50:50 lifeline icon
│               │   ├── hint.png                 # Hint lifeline icon
│               │   └── R.png                    # Logo / branding image
│               ├── primary.fxml
│               └── secondary.fxml
└── README.md
```

## Prerequisites

- **Java JDK 11** or later
- **Apache Maven 3.6+**
- **MySQL 5.7+** (or MariaDB equivalent)

## Environment Setup

Database credentials are read from environment variables so that nothing sensitive is committed to source control:

```bash
export QUIZ_DB_URL="jdbc:mysql://localhost:3306/nlogin?zeroDateTimeBehavior=CONVERT_TO_NULL"
export QUIZ_DB_USER="root"
export QUIZ_DB_PASSWORD=""
```

If the variables are not set, the application falls back to the defaults shown above.

## Build and Run

1. **Clone the repository**

   ```bash
   git clone https://github.com/R-Alothaim/Desktop-app.git
   cd Desktop-app
   ```

2. **Build the project**

   ```bash
   mvn clean compile
   ```

3. **Run the application**

   ```bash
   mvn javafx:run
   ```

## Configuration

Runtime configuration lives in `src/main/resources/application.properties`. Database connection parameters should be overridden via the environment variables described above rather than editing the file directly.



## Contributing

1. Fork the repository.
2. Create a feature branch (`git checkout -b feature/my-feature`).
3. Commit your changes and open a pull request.

Please follow the existing code style enforced by `.editorconfig`.

## License

This project is available under the [MIT License](LICENSE).

## Author

**R-Alothaim** -- [GitHub](https://github.com/R-Alothaim)
