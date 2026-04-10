package dev.aqthurn.hardening_api.service;

import dev.aqthurn.hardening_api.dto.*;
import dev.aqthurn.hardening_api.model.ScanReport;
import dev.aqthurn.hardening_api.repository.ScanReportRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service

public class ScanReportService {

    private final ScanReportRepository repository;

    public ScanReportService(ScanReportRepository repository) {
        this.repository = repository;
    }

    public ScanReport save(ScanReportRequest request){
        ScanReport report = toEntity(request);
        ScanReport saved = repository.save(report);
        return toResponse(saved);

    }

    public List<ScanReportResponse> findAll(){
        return repository.findAll().stream()
                .map(this::toResponse)
                .toList();
    }

    public ScanReportResponse findById(Long id) {
        ScanReport report = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found: " + id));
        return toResponse(report);
    }



}
