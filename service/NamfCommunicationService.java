package com.example.cbcf.service;

import com.example.cbcf.model.NonUeMessageTransferRequest;
import com.example.cbcf.model.NonUeN2InfoSubscribeRequest;
import com.example.cbcf.model.NonUeN2InfoSubscription;
import com.example.cbcf.model.SubscriptionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.UUID;

/**
 * Service layer for handling the business logic of the Namf_Communication service operations.
 * This service manages subscriptions in-memory and interacts with a mock AMF client.
 */
@Service
public class NamfCommunicationService {

    // In-memory storage for subscriptions. In a real application, this would be a database.
    private final Map<String, NonUeN2InfoSubscription> subscriptions = new ConcurrentHashMap<>();

    private final AmfCommunicationClient amfCommunicationClient;

    /**
     * Constructor for dependency injection of AmfCommunicationClient.
     * @param amfCommunicationClient The client for communicating with the AMF.
     */
    @Autowired
    public NamfCommunicationService(AmfCommunicationClient amfCommunicationClient) {
        this.amfCommunicationClient = amfCommunicationClient;
    }

    /**
     * Processes the NonUeMessageTransfer request.
     * This method would typically involve validating the message and then forwarding it
     * to the appropriate network function (e.g., AMF) for delivery to UEs.
     *
     * @param request The NonUeMessageTransferRequest containing the message details.
     */
    public void transferNonUeMessage(NonUeMessageTransferRequest request) {
        // Business logic for message transfer
        System.out.println("Processing Non-UE Message Transfer for UE: " + request.getTargetUeId());
        System.out.println("Message: " + request.getMessageContent());

        // Simulate forwarding the message to the AMF
        amfCommunicationClient.sendNonUeMessageToAmf(request);

        System.out.println("Non-UE Message Transfer completed.");
    }

    /**
     * Handles the NonUeN2InfoSubscribe operation.
     * Creates a new subscription, stores it in memory, and simulates sending
     * a corresponding subscription request to the AMF.
     *
     * @param request The NonUeN2InfoSubscribeRequest containing subscription details.
     * @return A SubscriptionResponse with the newly generated subscription ID.
     */
    public SubscriptionResponse subscribeN2Info(NonUeN2InfoSubscribeRequest request) {
        // Generate a unique subscription ID
        String subscriptionId = UUID.randomUUID().toString();

        // Create a new subscription object
        NonUeN2InfoSubscription newSubscription = new NonUeN2InfoSubscription(
            subscriptionId,
            request.getCallbackUrl(),
            request.getN2InfoType()
        );

        // Store the subscription in memory
        subscriptions.put(subscriptionId, newSubscription);
        System.out.println("Subscription created: " + newSubscription);

        // Simulate sending subscription to AMF (AMF would return its own subscription ID)
        // For simplicity, we'll just use our internal ID for now, or you could store AMF's ID.
        amfCommunicationClient.sendSubscriptionToAmf(request.getCallbackUrl(), request.getN2InfoType());

        // Construct the response
        // In a real scenario, the resourceLocation would point to the URI of this specific subscription resource.
        String resourceLocation = "/namf-comm/v1/subscriptions/" + subscriptionId;
        return new SubscriptionResponse(subscriptionId, resourceLocation);
    }

    /**
     * Handles the NonUeN2InfoUnsubscribe operation.
     * Removes an existing subscription from memory and simulates sending
     * an unsubscription request to the AMF.
     *
     * @param subscriptionId The ID of the subscription to be removed.
     */
    public void unsubscribeN2Info(String subscriptionId) {
        // Check if the subscription exists
        if (subscriptions.containsKey(subscriptionId)) {
            // Remove the subscription from memory
            NonUeN2InfoSubscription removedSubscription = subscriptions.remove(subscriptionId);
            System.out.println("Subscription removed: " + removedSubscription);

            // Simulate sending unsubscription to AMF
            amfCommunicationClient.sendUnsubscriptionToAmf(subscriptionId);

            System.out.println("Non-UE N2 Info Unsubscribe completed for ID: " + subscriptionId);
        } else {
            System.out.println("Subscription with ID " + subscriptionId + " not found. No action taken.");
            // In a real application, you might throw an exception or return a specific error code.
        }
    }

    /**
     * Retrieves a subscription by its ID (for internal use or debugging).
     * @param subscriptionId The ID of the subscription to retrieve.
     * @return An Optional containing the NonUeN2InfoSubscription if found, otherwise empty.
     */
    public Optional<NonUeN2InfoSubscription> getSubscription(String subscriptionId) {
        return Optional.ofNullable(subscriptions.get(subscriptionId));
    }
}