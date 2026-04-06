package dev.aqthurn.hardening_api.service;


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

    public ScanReport save(ScanReport report){
        return repository.save(report);

    }

    public List<ScanReport> findAll(){
        return repository.findAll();
    }

    public ScanReport findById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found: " +id ));
    }

}
