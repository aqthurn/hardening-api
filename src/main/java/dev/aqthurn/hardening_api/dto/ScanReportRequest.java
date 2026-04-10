package dev.aqthurn.hardening_api.dto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDateTime;
import java.util.List;

public class ScanReportRequest {


    @NotBlank(message = "Hostname é obrigatório")
    private String hostname;

    private String ipAddress;


    @NotNull(message = "ScannedAt é obrigatório")
    private LocalDateTime scannedAt;

    private int totalChecks;
    private int passedChecks;
    private int failedChecks;

    @Valid
    @NotNull(message = "Results é obrigatório")
    private List<CheckResultRequest> results;

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public LocalDateTime getScannedAt() {
        return scannedAt;
    }

    public void setScannedAt(LocalDateTime scannedAt) {
        this.scannedAt = scannedAt;
    }

    public int getTotalChecks() {
        return totalChecks;
    }

    public void setTotalChecks(int totalChecks) {
        this.totalChecks = totalChecks;
    }

    public int getPassedChecks() {
        return passedChecks;
    }

    public void setPassedChecks(int passedChecks) {
        this.passedChecks = passedChecks;
    }

    public int getFailedChecks() {
        return failedChecks;
    }

    public void setFailedChecks(int failedChecks) {
        this.failedChecks = failedChecks;
    }

    public List<CheckResultRequest> getResults() {
        return results;
    }

    public void setResults(List<CheckResultRequest> results) {
        this.results = results;
    }
}
