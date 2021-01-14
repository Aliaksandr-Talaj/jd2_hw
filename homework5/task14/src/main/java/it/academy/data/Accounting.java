package it.academy.data;

import java.sql.Date;

public class Accounting {


    private String entityName;
    private int paymentNumber;
    private Date paymentDate;
    private int recipientId;
    private double amount;



    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {

        this.entityName = entityName;
    }

    public int getPaymentNumber() {
        return paymentNumber;
    }

    public void setPaymentNumber(int paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(int recipientId) {
        this.recipientId = recipientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}

