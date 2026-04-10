package dev.aqthurn.hardening_api.dto;


public class CheckResultResponse {


    private Long id;
    private String checkName;
    private String status;
    private String message;

    public CheckResultResponse(Long id, String checkName, String status, String message){
        this.id = id;
        this.checkName = checkName;
        this.status = status;
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public String getCheckName() {
        return checkName;
    }

    public String getMessage() {
        return message;
    }

    public String getStatus() {
        return status;
    }
}
