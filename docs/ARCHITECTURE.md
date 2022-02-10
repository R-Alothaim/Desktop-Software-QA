# Architecture

## Overview

The Quiz Desktop App follows a layered package structure under `com.qaisr`.
Each layer has a single responsibility, keeping the codebase navigable as it
grows.

## Layers

```
com.qaisr
├── QuizApplication.java   -- application entry point
├── config/                 -- externalised configuration (DB credentials)
├── model/                  -- domain data classes (Question)
├── ui/                     -- Swing frames and panels (LoginFrame, QuizPanel, ScorePanel, TimerDisplay)
├── service/                -- quiz orchestration logic (QuizService, QuizShortService)
└── util/                   -- shared helpers (AnswerShuffler)
```

### config

`DatabaseConfig` reads connection parameters from environment variables,
falling back to local-development defaults. No credentials are committed to
source control.

### model

`Question` is a simple data carrier holding the question text, four options,
the correct answer, and a hint string.

### ui

All Swing/AWT code lives here. `LoginFrame` collects credentials,
`QuizPanel` renders a single question with lifelines, `ScorePanel` shows the
result, and `TimerDisplay` tracks elapsed time.

### service

`QuizService` drives the full question bank in order; `QuizShortService`
randomly selects 35 questions from the bank. Both delegate UI rendering to the
`ui` layer.

### util

`AnswerShuffler` encapsulates the answer-randomisation algorithm previously
duplicated across service classes.

## Data Flow

1. `QuizApplication` creates a `LoginFrame`.
2. On successful authentication, `LoginFrame` starts either `QuizService` or
   `QuizShortService` on a background thread.
3. The service builds `Question[]`, iterates through them, and delegates each
   to a `QuizPanel` for display.
4. When the quiz ends, `ScorePanel` shows the result and offers restart or
   exit.
