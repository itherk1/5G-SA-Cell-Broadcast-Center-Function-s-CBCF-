package com.example.cbcf.model;

public class NonUeN2InfoUnsubscribeRequest {
    private String subscriptionId;

    public String getSubscriptionId() { return subscriptionId; }
    public void setSubscriptionId(String subscriptionId) { this.subscriptionId = subscriptionId; }

    @Override
    public String toString() {
        return "NonUeN2InfoUnsubscribeRequest{" +
                "subscriptionId='" + subscriptionId + '\'' +
                '}';
    }
}