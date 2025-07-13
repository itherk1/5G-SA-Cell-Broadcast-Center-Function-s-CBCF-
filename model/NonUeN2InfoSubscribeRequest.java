package com.example.cbcf.model;

/**
 * Data model for the NonUeN2InfoSubscribe request.
 * This represents the payload sent by a consumer (e.g., CBCF) to subscribe to N2 information.
 *
 * Simplified for demonstration purposes. Real 3GPP specs would have more fields.
 */
public class NonUeN2InfoSubscribeRequest {
    private String callbackUrl; // URL where notifications should be sent
    private String n2InfoType;  // Type of N2 information to subscribe to (e.g., "CELL_BROADCAST_INFO")

    // Default constructor for JSON deserialization
    public NonUeN2InfoSubscribeRequest() {
    }

    public NonUeN2InfoSubscribeRequest(String callbackUrl, String n2InfoType) {
        this.callbackUrl = callbackUrl;
        this.n2InfoType = n2InfoType;
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

    @Override
    public String toString() {
        return "NonUeN2InfoSubscribeRequest{" +
               "callbackUrl='" + callbackUrl + '\'' +
               ", n2InfoType='" + n2InfoType + '\'' +
               '}';
    }
}