package dev.aqthurn.hardening_api.repository;
import dev.aqthurn.hardening_api.model.ScanReport;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ScanReportRepository extends JpaRepository<ScanReport, Long> {
}
