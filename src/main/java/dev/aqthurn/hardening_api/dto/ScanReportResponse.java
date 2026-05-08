package dev.aqthurn.hardening_api.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ScanReportResponse {

    private Long id;
    private String hostname;
    private String ipAddress;
    private LocalDateTime scannedAt;
    private int totalChecks;
    private int passedChecks;
    private int failedChecks;
    private List<CheckResultResponse> results;

    public ScanReportResponse(Long id, String hostname, String ipAddress, LocalDateTime scannedAt, int totalChecks, int passedChecks, int failedChecks, List<CheckResultResponse> results){

        this.id = id;
        this.hostname = hostname;
        this.ipAddress = ipAddress;
        this.scannedAt = scannedAt;
        this.totalChecks = totalChecks;
        this.passedChecks = passedChecks;
        this.failedChecks = failedChecks;
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public String getHostname() {
        return hostname;
    }

    public LocalDateTime getScannedAt() {
        return scannedAt;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getTotalChecks() {
        return totalChecks;
    }

    public int getPassedChecks() {
        return passedChecks;
    }

    public int getFailedChecks() {
        return failedChecks;
    }

    public List<CheckResultResponse> getResults() {
        return results;
    }
}
