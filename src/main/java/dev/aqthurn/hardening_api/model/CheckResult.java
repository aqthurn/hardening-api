package dev.aqthurn.hardening_api.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


@Entity
@Table(name = "check_results")



public class CheckResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String checkName;

    private String status;

    private String message;


    @ManyToOne
    @JoinColumn(name = "scan_report_id")
    @JsonBackReference

    private ScanReport scanReport;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCheckName() {
        return checkName;
    }

    public void setCheckName(String checkName) {
        this.checkName = checkName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ScanReport getScanReport() {
        return scanReport;
    }

    public void setScanReport(ScanReport scanReport) {
        this.scanReport = scanReport;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
