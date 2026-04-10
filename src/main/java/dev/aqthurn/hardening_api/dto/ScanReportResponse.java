package dev.aqthurn.hardening_api.dto;

import java.time.LocalDateTime;
import java.util.List;

public class ScanReportResponse {

    private Long id;
    private String hostName;
    private String ipAddress;
    private LocalDateTime scannedAt;
    private int totalChecks;
    private int passedChecks;
    private int faildedChecks;
    private List<CheckResultResponse> results;

    public ScanReportResponse(Long id, String hostName, String ipAddress, LocalDateTime scannedAt, int totalChecks, int passedChecks, int faildedChecks, List<CheckResultResponse> results){

        this.id = id;
        this.hostName = hostName;
        this.ipAddress = ipAddress;
        this.scannedAt = scannedAt;
        this.totalChecks = totalChecks;
        this.passedChecks = passedChecks;
        this.faildedChecks = faildedChecks;
        this.results = results;
    }

    public Long getId() {
        return id;
    }

    public String getHostName() {
        return hostName;
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

    public int getFaildedChecks() {
        return faildedChecks;
    }

    public List<CheckResultResponse> getResults() {
        return results;
    }
}
