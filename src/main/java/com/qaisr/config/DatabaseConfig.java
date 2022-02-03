package com.qaisr.config;

/**
 * Centralised database configuration.
 * <p>
 * Connection parameters are resolved from environment variables at startup,
 * falling back to sensible local-development defaults when the variables are
 * not set.
 * </p>
 */
public class DatabaseConfig {

    private DatabaseConfig() {
        // utility class -- not instantiable
    }

    public static final String DB_URL = System.getenv("QUIZ_DB_URL") != null
            ? System.getenv("QUIZ_DB_URL")
            : "jdbc:mysql://localhost:3306/nlogin?zeroDateTimeBehavior=CONVERT_TO_NULL";

    public static final String DB_USER = System.getenv("QUIZ_DB_USER") != null
            ? System.getenv("QUIZ_DB_USER")
            : "root";

    public static final String DB_PASSWORD = System.getenv("QUIZ_DB_PASSWORD") != null
            ? System.getenv("QUIZ_DB_PASSWORD")
            : "";
}
