5G SA Cell Broadcast Center Function's (CBCF)

Run the CbcfApplication.java file & it will trigger others to work on.
It execute & preapre basic functions:- Namf_Communication service's NonUeMessageTransfer,
NonUeN2InfoSubscribe,
NonUeN2InfoUnsubsribe

This code outlines a Spring Boot application, CbcfApplication, designed to manage communication flows, particularly for non-UE (User Equipment) devices within a network. The NamfCommunicationController serves as the central hub, defining specific API endpoints to handle various interactions. Clients can send messages to non-UE targets via the /non-ue-message-transfer endpoint and manage information subscriptions by subscribing to (/subscribe) and unsubscribing from (/unsubscribe) updates, with subscription details stored internally. The model package further defines the data structures for these requests, ensuring clear communication protocols for message transfers and subscription management.

Basic requirement:- 
Java & springboot in the system
