package oleh.congratulationservice.common;

public enum ResponseStatus {
    OK("ok"), FAILED("failed");

    private String status;

    public String getStatus(){
        return status;
    }

    ResponseStatus(String status){
        this.status = status;
    }
}
