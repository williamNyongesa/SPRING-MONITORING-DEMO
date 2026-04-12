package com.william.monitoring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Health & Monitoring Controller
 * Custom endpoints for application monitoring
 */
@RestController
@RequestMapping("/api/monitor")
public class HealthController {

    @Autowired
    private DataSource dataSource;

    // GET application info
    // http://localhost:8080/api/monitor/info
    @GetMapping("/info")
    public ResponseEntity<Map<String, Object>> getInfo() {
        Map<String, Object> info = new HashMap<>();
        info.put("application", "Spring Monitoring Demo");
        info.put("author", "William Nyongesa");
        info.put("github", "github.com/williamNyongesa");
        info.put("version", "1.0.0");
        info.put("timestamp", LocalDateTime.now().toString());
        info.put("status", "Running");
        return ResponseEntity.ok(info);
    }

    // GET database health
    // http://localhost:8080/api/monitor/db-health
    @GetMapping("/db-health")
    public ResponseEntity<Map<String, Object>> getDatabaseHealth() {
        Map<String, Object> health = new HashMap<>();
        try (Connection connection = dataSource.getConnection()) {
            health.put("database", "Connected");
            health.put("product", connection.getMetaData().getDatabaseProductName());
            health.put("version", connection.getMetaData().getDatabaseProductVersion());
            health.put("status", "UP");
        } catch (Exception e) {
            health.put("database", "Disconnected");
            health.put("error", e.getMessage());
            health.put("status", "DOWN");
        }
        return ResponseEntity.ok(health);
    }

    // GET system metrics
    // http://localhost:8080/api/monitor/metrics
    @GetMapping("/metrics")
    public ResponseEntity<Map<String, Object>> getMetrics() {
        Runtime runtime = Runtime.getRuntime();
        Map<String, Object> metrics = new HashMap<>();
        metrics.put("totalMemoryMB", runtime.totalMemory() / (1024 * 1024));
        metrics.put("freeMemoryMB", runtime.freeMemory() / (1024 * 1024));
        metrics.put("usedMemoryMB", (runtime.totalMemory() - runtime.freeMemory()) / (1024 * 1024));
        metrics.put("availableProcessors", runtime.availableProcessors());
        metrics.put("timestamp", LocalDateTime.now().toString());
        return ResponseEntity.ok(metrics);
    }
}
