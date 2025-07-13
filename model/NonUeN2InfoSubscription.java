package com.example.cbcf.model;

/**
 * Internal data model representing an active N2 information subscription.
 * This is used by the service layer to store and manage subscriptions.
 */
public class NonUeN2InfoSubscription {
    private String subscriptionId;
    private String callbackUrl;
    private String n2InfoType;
    private long creationTimestamp;

    public NonUeN2InfoSubscription(String subscriptionId, String callbackUrl, String n2InfoType) {
        this.subscriptionId = subscriptionId;
        this.callbackUrl = callbackUrl;
        this.n2InfoType = n2InfoType;
        this.creationTimestamp = System.currentTimeMillis();
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getCallbackUrl() {
        return callbackUrl;
    }

    public void setCallbackUrl(String callbackUrl) {
        this.callbackUrl = callbackUrl;
    }

    public String getN2InfoType() {
        return n2InfoType;
    }

    public void setN2InfoType(String n2InfoType) {
        this.n2InfoType = n2InfoType;
    }

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    @Override
    public String toString() {
        return "NonUeN2InfoSubscription{" +
               "subscriptionId='" + subscriptionId + '\'' +
               ", callbackUrl='" + callbackUrl + '\'' +
               ", n2InfoType='" + n2InfoType + '\'' +
               ", creationTimestamp=" + creationTimestamp +
               '}';
    }
}