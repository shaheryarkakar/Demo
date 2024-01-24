package com.memorynotfound.integration;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.math.BigDecimal;

public class Order implements Serializable {

    @NotEmpty(message= "value can't be empty")
    //@Email(message= "Please enter a valid email address only")
    private String from;
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String to;
    @NotNull
    private BigDecimal amount;

    public Order() {
    }

    public Order(String from, String to, BigDecimal amount) {
        this.from = from;
        this.to = to;
        this.amount = amount;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", amount=" + amount +
                '}';
    }
}
