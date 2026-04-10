package dev.aqthurn.hardening_api.dto;

import jakarta.validation.constraints.NotBlank;

public class CheckResultRequest {

    @NotBlank(message = "checkName é obrigatório")
    private String checkName;

    @NotBlank(message = "status é obrigatório")
    private String status;

    private String message;

    // getters e setters

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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}