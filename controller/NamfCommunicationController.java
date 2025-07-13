package com.example.cbcf.controller;

import com.example.cbcf.model.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/namf-communication")
public class NamfCommunicationController {

    private final Map<String, NonUeN2InfoSubscribeRequest> subscriptions = new ConcurrentHashMap<>();

    @PostMapping("/non-ue-message-transfer")
    public ResponseEntity<String> nonUeMessageTransfer(@RequestBody NonUeMessageTransferRequest request) {
        System.out.println("Received Non-UE Message Transfer: " + request);
        return ResponseEntity.ok("Non-UE Message delivered");
    }

    @PostMapping("/subscribe")
    public ResponseEntity<String> nonUeN2InfoSubscribe(@RequestBody NonUeN2InfoSubscribeRequest request) {
        subscriptions.put(request.getSubscriptionId(), request);
        System.out.println("Subscribed: " + request);
        return ResponseEntity.ok("Subscription successful");
    }

    @DeleteMapping("/unsubscribe")
    public ResponseEntity<String> nonUeN2InfoUnsubscribe(@RequestBody NonUeN2InfoUnsubscribeRequest request) {
        subscriptions.remove(request.getSubscriptionId());
        System.out.println("Unsubscribed: " + request.getSubscriptionId());
        return ResponseEntity.ok("Unsubscription successful");
    }
}