package com.example.cbcf.model;

/**
 * Data model for the NonUeMessageTransfer request.
 * This represents the payload sent by the CBCF to the AMF (or in this case, the CBCF's Namf_Communication service).
 *
 * Simplified for demonstration purposes. Real 3GPP specs would have more fields.
 */
public class NonUeMessageTransferRequest {
    private String messageContent; // The actual broadcast message content
    private String targetUeId;     // An identifier for the target UE (e.g., SUPI, PEI)

    // Default constructor for JSON deserialization
    public NonUeMessageTransferRequest() {
    }

    public NonUeMessageTransferRequest(String messageContent, String targetUeId) {
        this.messageContent = messageContent;
        this.targetUeId = targetUeId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getTargetUeId() {
        return targetUeId;
    }

    public void setTargetUeId(String targetUeId) {
        this.targetUeId = targetUeId;
    }

    @Override
    public String toString() {
        return "NonUeMessageTransferRequest{" +
               "messageContent='" + messageContent + '\'' +
               ", targetUeId='" + targetUeId + '\'' +
               '}';
    }
}