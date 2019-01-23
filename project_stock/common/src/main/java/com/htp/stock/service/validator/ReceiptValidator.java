package com.htp.stock.service.validator;

import com.htp.stock.domain.to.Receipt;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReceiptValidator implements ValidatorInterface<Receipt> {

    private static final ValidatorInterface<Receipt> instance = new ReceiptValidator();

    private ReceiptValidator() {
    }

    public static ValidatorInterface<Receipt> getInstance() {
        return instance;
    }

    private static final String REGULAR_EXP_QUANTITY = "/^[0-9]+(\\\\.[0-9]+)?$";
    private static final String REGULAR_EXP_PRICE = "/^[0-9]+(\\\\.[0-9]+)?$";
    private static final String REGULAR_EXP_DATE = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
    private static final String REGULAR_INVOICE_NUMBER = "[0-9]{1,11}";

    private static final Pattern patternQuantity = Pattern.compile(REGULAR_EXP_QUANTITY);
    private static final Pattern patternPrice = Pattern.compile(REGULAR_EXP_PRICE);
    private static final Pattern patternDate = Pattern.compile(REGULAR_EXP_DATE);
    private static final Pattern patternInvoiceNumber = Pattern.compile(REGULAR_INVOICE_NUMBER);


    @Override
    public boolean isValid(Receipt receipt) {
        String quantityValid = String.valueOf(receipt.getReceiptQuantity());
        String priceValid = String.valueOf(receipt.getReceiptPrice());
        String dateValid = String.valueOf(receipt.getReceiptDate());
        String invoiceNumberValid = String.valueOf(receipt.getInvoiceNumber());

        Matcher matcherQuantity = patternQuantity.matcher(quantityValid);
        Matcher matcherPrice = patternPrice.matcher(priceValid);
        Matcher matcherDate = patternDate.matcher(dateValid);
        Matcher matcherInvoiceNumber = patternInvoiceNumber.matcher(invoiceNumberValid);

        return matcherQuantity.find() &
                matcherPrice.find() &
                matcherDate.find() &
                matcherInvoiceNumber.find();
    }
}

