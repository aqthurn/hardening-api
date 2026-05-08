package dev.aqthurn.hardening_api.service;

import dev.aqthurn.hardening_api.dto.*;
import dev.aqthurn.hardening_api.model.CheckResult;
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

    public ScanReportResponse save(ScanReportRequest request){
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

    private ScanReport toEntity(ScanReportRequest request){
        ScanReport report = new ScanReport();
        report.setHostname(request.getHostname());
        report.setIpAddress(request.getIpAddress());
        report.setScannedAt(request.getScannedAt());
        report.setTotalChecks(request.getTotalChecks());
        report.setPassedChecks(request.getPassedChecks());
        report.setFailedChecks(request.getFailedChecks());

        if (request.getResults() != null) {
            List<CheckResult> results = request.getResults().stream()
                    .map(cr -> {
                        CheckResult entity = new CheckResult();
                        report.setHostname(request.getHostname());
                        report.setIpAddress(request.getIpAddress());
                        report.setScannedAt(request.getScannedAt());
                        report.setTotalChecks(request.getTotalChecks());
                        report.setPassedChecks(request.getPassedChecks());
                        report.setFailedChecks(request.getFailedChecks());
                    })
                    .toList();
            report.setResults(results);
        }



        return report;
    }



    private ScanReportResponse toResponse(ScanReport report){


    }


    private ScanReport toEntity(ScanReportRequest request) {
        ScanReport report = new ScanReport();
        report.setHostname(request.getHostname());
        report.setIpAddress(request.getIpAddress());
        report.setScannedAt(request.getScannedAt());
        report.setTotalChecks(request.getTotalChecks());
        report.setPassedChecks(request.getPassedChecks());
        report.setFailedChecks(request.getFailedChecks());

        if (request.getResults() != null) {
            List<CheckResult> results = request.getResults().stream()
                    .map(r -> {
                        CheckResult cr = new CheckResult();
                        cr.setCheckName(r.getCheckName());
                        cr.setStatus(r.getStatus());
                        cr.setMessage(r.getMessage());
                        cr.setScanReport(report);
                        return cr;
                    })
                    .toList();
            report.setResults(results);
        }

        return report;
    }
    private ScanReportResponse toResponse(ScanReport report) {
        List<CheckResultResponse> results = List.of();

        if (report.getResults() != null) {
            results = report.getResults().stream()
                    .map(r -> new CheckResultResponse(
                            r.getId(),
                            r.getCheckName(),
                            r.getStatus(),
                            r.getMessage()
                    ))
                    .toList();
        }

        return new ScanReportResponse(
                report.getId(),
                report.getHostname(),
                report.getIpAddress(),
                report.getScannedAt(),
                report.getTotalChecks(),
                report.getPassedChecks(),
                report.getFailedChecks(),
                results
        );
    }
}
