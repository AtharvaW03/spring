package com.sprint.sqch11ex1.proxy;

import com.sprint.sqch11ex1.model.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

// use @FeignClient to config REST client.
// This minimal config defines name of proxy and endpoint base URI
@FeignClient(name = "payments",
        url = "${name.service.url}")
public interface PaymentsProxy {
    /*
    Each method declared in the interface represents a REST endpoint call.
     */
    //specify endpoint path and http method
    @PostMapping("/payment")
    // define request headers and body
    Payment createPayment(@RequestHeader String requestId,
                          @RequestBody Payment payment);

}
