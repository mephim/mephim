package com.example.mephim.request;

import lombok.Data;

@Data
public class PaymentCreateDto {
    private int amount;
    private String vnp_OrderInfo;
    private String vnp_BankCode;
    private String vnp_TxnRef;
    private String txt_billing_mobile;
    private String txt_billing_email;
    private String txt_billing_fullname;
}
