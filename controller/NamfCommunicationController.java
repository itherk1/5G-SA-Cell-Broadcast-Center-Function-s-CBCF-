package com.example.cbcf.controller;

import com.example.cbcf.model.NonUeMessageTransferRequest;
import com.example.cbcf.model.NonUeN2InfoSubscribeRequest;
import com.example.cbcf.model.SubscriptionResponse;
import com.example.cbcf.service.NamfCommunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST Controller for the Namf_Communication service of the CBCF.
 * This controller exposes the endpoints for NonUeMessageTransfer,
 * NonUeN2InfoSubscribe, and NonUeN2InfoUnsubscribe operations.
 *
 * Base path for these operations is typically /namf-comm/v1 based on 3GPP specs.
 */
@RestController
@RequestMapping("/namf-comm/v1")
public class NamfCommunicationController {

    private final NamfCommunicationService namfCommunicationService;

    /**
     * Constructor for dependency injection of NamfCommunicationService.
     * @param namfCommunicationService The service handling Namf_Communication logic.
     */
    @Autowired
    public NamfCommunicationController(NamfCommunicationService namfCommunicationService) {
        this.namfCommunicationService = namfCommunicationService;
    }

    /**
     * Implements the NonUeMessageTransfer operation.
     * This endpoint receives a non-UE specific message from the CBCF and processes it.
     * In a real scenario, this might involve forwarding it to the AMF or another NF.
     *
     * @param request The request body containing the message content and target UE ID.
     * @return ResponseEntity indicating success (200 OK) or an error.
     */
    @PostMapping("/non-ue-messages")
    public ResponseEntity<Void> nonUeMessageTransfer(@RequestBody NonUeMessageTransferRequest request) {
        System.out.println("Received NonUeMessageTransfer request: " + request);
        namfCommunicationService.transferNonUeMessage(request);
        return ResponseEntity.ok().build(); // 200 OK
    }

    /**
     * Implements the NonUeN2InfoSubscribe operation.
     * This endpoint allows a consumer (e.g., CBCF) to subscribe to N2 information from the AMF.
     *
     * @param request The request body containing subscription details like callback URL and N2 info type.
     * @return ResponseEntity with the SubscriptionResponse (containing subscription ID) and 201 Created status.
     */
    @PostMapping("/subscriptions")
    public ResponseEntity<SubscriptionResponse> nonUeN2InfoSubscribe(@RequestBody NonUeN2InfoSubscribeRequest request) {
        System.out.println("Received NonUeN2InfoSubscribe request: " + request);
        SubscriptionResponse response = namfCommunicationService.subscribeN2Info(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response); // 201 Created
    }

    /**
     * Implements the NonUeN2InfoUnsubscribe operation.
     * This endpoint allows a consumer to unsubscribe from previously created N2 information subscriptions.
     *
     * @param subscriptionId The ID of the subscription to be unsubscribed.
     * @return ResponseEntity indicating success (204 No Content) or an error.
     */
    @DeleteMapping("/subscriptions/{subscriptionId}")
    public ResponseEntity<Void> nonUeN2InfoUnsubscribe(@PathVariable String subscriptionId) {
        System.out.println("Received NonUeN2InfoUnsubscribe request for ID: " + subscriptionId);
        namfCommunicationService.unsubscribeN2Info(subscriptionId);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    /**
     * Global exception handler for any unhandled exceptions.
     * In a real application, this would map to specific 3GPP error responses.
     * @param ex The exception that occurred.
     * @return A ResponseEntity with a 500 Internal Server Error status.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        System.err.println("An error occurred: " + ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
    }
}