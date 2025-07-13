package com.example.cbcf.service;

import com.example.cbcf.model.NonUeMessageTransferRequest;
import org.springframework.stereotype.Component;

/**
 * A mock client to simulate communication with an AMF (Access and Mobility Management Function).
 * In a real 5G environment, this would involve making actual HTTP/2 requests
 * to the AMF's Namf service, adhering to 3GPP specifications for the AMF's API.
 *
 * For this example, it just prints messages to the console.
 */
@Component
public class AmfCommunicationClient {

    /**
     * Simulates sending a Non-UE specific message to the AMF.
     * @param request The message transfer request.
     */
    public void sendNonUeMessageToAmf(NonUeMessageTransferRequest request) {
        System.out.println("--- Mock AMF Communication ---");
        System.out.println("Simulating sending Non-UE message to AMF for UE: " + request.getTargetUeId());
        System.out.println("Message Content: " + request.getMessageContent());
        System.out.println("--- End Mock AMF Communication ---");
        // In a real scenario, this would be an HTTP client call (e.g., WebClient or RestTemplate)
        // to the AMF's Namf_Communication service endpoint for message transfer.
    }

    /**
     * Simulates sending a subscription request to the AMF.
     * @param callbackUrl The callback URL for notifications.
     * @param n2InfoType The type of N2 information.
     * @return A simulated subscription ID from the AMF.
     */
    public String sendSubscriptionToAmf(String callbackUrl, String n2InfoType) {
        System.out.println("--- Mock AMF Communication ---");
        System.out.println("Simulating sending N2 Info Subscription to AMF.");
        System.out.println("Callback URL: " + callbackUrl + ", N2 Info Type: " + n2InfoType);
        String amfSubscriptionId = "amf-sub-" + System.currentTimeMillis();
        System.out.println("AMF returns simulated subscription ID: " + amfSubscriptionId);
        System.out.println("--- End Mock AMF Communication ---");
        return amfSubscriptionId;
    }

    /**
     * Simulates sending an unsubscription request to the AMF.
     * @param amfSubscriptionId The subscription ID to unsubscribe.
     */
    public void sendUnsubscriptionToAmf(String amfSubscriptionId) {
        System.out.println("--- Mock AMF Communication ---");
        System.out.println("Simulating sending N2 Info Unsubscription to AMF for ID: " + amfSubscriptionId);
        System.out.println("--- End Mock AMF Communication ---");
    }
}