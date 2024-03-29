package com.example.usersservice.queries;


import com.gui.estore.core.model.PaymentDetails;
import com.gui.estore.core.model.User;
import com.gui.estore.core.queries.FetchUserPaymentDetailsQuery;
import org.axonframework.queryhandling.QueryHandler;
import org.springframework.stereotype.Component;

@Component
public class UserEventsHandler {

    @QueryHandler
    public User getPaymentDetails(FetchUserPaymentDetailsQuery query) {

        PaymentDetails paymentDetails = PaymentDetails.builder()
                .cardNumber("123Card")
                .cvv("123")
                .name("GUILLE")
                .validUntilMonth(12)
                .validUntilYear(2030)
                .build();

        return User.builder()
                .firstName("GUILLE")
                .lastName("Kargopolov")
                .userId(query.getUserId())
                .email("duche27@hotmail.com")
                .paymentDetails(paymentDetails)
                .build();
    }
}
