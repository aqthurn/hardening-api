package dev.aqthurn.hardening_api.controller;

import dev.aqthurn.hardening_api.model.CheckResult;
import dev.aqthurn.hardening_api.model.ScanReport;
import dev.aqthurn.hardening_api.service.ScanReportService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/reports")

public class ScanReportController {

    private final ScanReportService service;

    public ScanReportController (ScanReportService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ScanReport> create(@RequestBody ScanReport report) {
        if (report.getResults() != null) {
            for (CheckResult result : report.getResults()) {
                result.setScanReport(report);
            }
        }
        ScanReport saved = service.save(report);
        return ResponseEntity.ok(saved);
    }
    @GetMapping
    public ResponseEntity<List<ScanReport>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScanReport> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }
}