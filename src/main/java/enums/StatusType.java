package enums;

public enum StatusType {
    DRAFT("draft"),
    REVIEW("review"),
    PUBLISH("publish");

    private String statusType;

    StatusType(String statusType){
        this.statusType = statusType;
    }

    public String getStatusType(){
        return statusType;
    }
}
