package com.memorynotfound.integration;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class OrderValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Order.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Order order = (Order) target;

        if (order == null){
            errors.reject(null, "order cannot be null");
        } else {
            if (order.getFrom() == null){
                errors.rejectValue("from", null, "from cannot be null");
            }
            if (order.getTo() == null){
                errors.rejectValue("to", null, "to cannot be null");
            }
            if (order.getAmount() == null){
                errors.rejectValue("amount", null, "to cannot be null");
            }
        }

    }
}
