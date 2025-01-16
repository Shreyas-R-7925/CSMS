package com.cars24.data.Entities;

public class InvoiceEntity {
    private int invoice_id;
    private int appointment_id;
    private int decimal;
    private String payment_status;

    public int getInvoice_id() {
        return invoice_id;
    }

    public void setInvoice_id(int invoice_id) {
        this.invoice_id = invoice_id;
    }

    public int getAppointment_id() {
        return appointment_id;
    }

    public void setAppointment_id(int appointment_id) {
        this.appointment_id = appointment_id;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public java.lang.String getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(java.lang.String payment_status) {
        this.payment_status = payment_status;
    }
}
