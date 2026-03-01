package com.sprint.sqch11payments.controller;

import com.sprint.sqch11payments.model.Payment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class PaymentsController {
    //use a logger to prove the right controller method
    // gets the correct data when endpoint is called.
    private static Logger logger = Logger.getLogger(PaymentsController.class.getName());

    //the endpoint needs to get a request header and request body from caller.
    //the controller method gets these two details as params
    @PostMapping("/payment")
    public ResponseEntity<Payment> createPayment(
            @RequestHeader String requestId,
            @RequestBody Payment payment
    ){
        logger.info("Received request with ID " + requestId +
                " ;Payment Amount: " + payment.getAmount());

        //sets a random value for the payment's ID
        payment.setId(UUID.randomUUID().toString());

        return ResponseEntity
                .status(HttpStatus.OK)
                .header("requestId", requestId)
                .body(payment);
    }
}
