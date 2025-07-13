package com.example.cbcf.model;

public class NonUeN2InfoSubscribeRequest {
    private String subscriptionId;
    private String notificationUri;
    private String n2InfoType;
    private String tai;

    public String getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(String subscriptionId) { this.subscriptionId = subscriptionId; }

    public String getNotificationUri() { return notificationUri; }
    public void setNotificationUri(String notificationUri) { this.notificationUri = notificationUri; }

    public String getN2InfoType() { return n2InfoType; }
    public void setN2InfoType(String n2InfoType) { this.n2InfoType = n2InfoType; }

    public String getTai() { return tai; }
    public void setTai(String tai) { this.tai = tai; }

    @Override
    public String toString() {
        return "NonUeN2InfoSubscribeRequest{" +
                "subscriptionId='" + subscriptionId + '\'' +
                ", notificationUri='" + notificationUri + '\'' +
                ", n2InfoType='" + n2InfoType + '\'' +
                ", tai='" + tai + '\'' +
                '}';
    }
}