package com.example.cbcf.model;

public class NonUeMessageTransferRequest {
    private String messageId;
    private String targetId;
    private String messageContent;

    public String getMessageId() { return messageId; }
    public void setMessageId(String messageId) { this.messageId = messageId; }

    public String getTargetId() { return targetId; }
    public void setTargetId(String targetId) { this.targetId = targetId; }

    public String getMessageContent() { return messageContent; }
    public void setMessageContent(String messageContent) { this.messageContent = messageContent; }

    @Override
    public String toString() {
        return "NonUeMessageTransferRequest{" +
                "messageId='" + messageId + '\'' +
                ", targetId='" + targetId + '\'' +
                ", messageContent='" + messageContent + '\'' +
                '}';
    }
}