package com.example.cbcf.model;

/**
 * Data model for the response of a successful NonUeN2InfoSubscribe operation.
 * Contains the unique ID assigned to the new subscription.
 */
public class SubscriptionResponse {
    private String subscriptionId;
    private String resourceLocation; // Typically the URI of the created subscription resource

    // Default constructor for JSON deserialization
    public SubscriptionResponse() {
    }

    public SubscriptionResponse(String subscriptionId, String resourceLocation) {
        this.subscriptionId = subscriptionId;
        this.resourceLocation = resourceLocation;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getResourceLocation() {
        return resourceLocation;
    }

    public void setResourceLocation(String resourceLocation) {
        this.resourceLocation = resourceLocation;
    }

    @Override
    public String toString() {
        return "SubscriptionResponse{" +
               "subscriptionId='" + subscriptionId + '\'' +
               ", resourceLocation='" + resourceLocation + '\'' +
               '}';
    }
}