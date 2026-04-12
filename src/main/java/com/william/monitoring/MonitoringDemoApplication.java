package com.william.monitoring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot Monitoring Demo Application
 * Author: William Nyongesa
 * GitHub: github.com/williamNyongesa
 *
 * Features:
 * - REST API endpoints
 * - Spring Boot Actuator (health, metrics, info)
 * - Prometheus metrics endpoint
 * - PostgreSQL database integration
 * - Employee management CRUD operations
 */
@SpringBootApplication
public class MonitoringDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(MonitoringDemoApplication.class, args);
    }
}
