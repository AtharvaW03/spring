package com.sprint.sqch11ex3.proxy;

import com.sprint.sqch11ex3.model.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
// Mono is a reactive type from Project Reactor (used by Spring WebFlux).
// It represents a stream that will emit 0 or 1 item asynchronously in the future.
// Think of it as a promise/future for a single value — the result isn't available
// immediately, it will arrive later without blocking the current thread.
// Mono<Payment> means: "I will eventually give you one Payment object (or nothing)."
import reactor.core.publisher.Mono;

@Component
public class PaymentsProxy {
    private final WebClient webClient;
    //take base URI from properties file
    @Value("${name.service.url}")
    private String url;

    public PaymentsProxy(WebClient webClient){
        this.webClient = webClient;
    }

    // Returns Mono<Payment> — the response won't block the thread while waiting
    // for the HTTP call to complete. The Payment value arrives asynchronously.
    public Mono<Payment> createPayment(
            String requestId,
            Payment payment){
        //specify http method used when making the call
        return webClient.post()
                //specify URI for call
                .uri(url + "/payment")
                //add http header value, can be called multiple times to add more headers if needed
                .header("requestId", requestId)
                // Mono.just(payment) wraps the payment object into a Mono so it can
                // be sent as a reactive stream in the request body
                //provide http request body
                .body(Mono.just(payment), Payment.class)
                //send http request and obtain response
                .retrieve()
                // bodyToMono converts the response body into a Mono<Payment>
                // — it will emit the Payment object once the response arrives
                //we get http response body
                .bodyToMono(Payment.class);
    }
}
