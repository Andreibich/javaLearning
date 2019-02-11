package com.htp.stock.service.validator;

import com.htp.stock.domain.to.Shipment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShipmentValidator implements ValidatorInterface<Shipment> {

    private static final ValidatorInterface<Shipment> instance = new ShipmentValidator();

    private ShipmentValidator() {
    }

    public static ValidatorInterface<Shipment> getInstance() {
        return instance;
    }

    private static final String REGULAR_EXP_QUANTITY = "/^[0-9]+(\\\\.[0-9]+)?$";
    private static final String REGULAR_EXP_PRICE = "/^[0-9]+(\\\\.[0-9]+)?$";
    private static final String REGULAR_EXP_DATE = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";
    private static final String REGULAR_EXP_INVOICE_NUMBER = "[0-9]{1,11}";
    private static final String REGULAR_EXP_PROXY_NUMBER = "[0-9]{1,11}";
    private static final String REGULAR_EXP_RECEPIENT_EMPLOYEE_NAME = "^[\\p{L} \\.'\\-]+$";

    private static final Pattern patternQuantity = Pattern.compile(REGULAR_EXP_QUANTITY);
    private static final Pattern patternPrice = Pattern.compile(REGULAR_EXP_PRICE);
    private static final Pattern patternDate = Pattern.compile(REGULAR_EXP_DATE);
    private static final Pattern patternInvoiceNumber = Pattern.compile(REGULAR_EXP_INVOICE_NUMBER);
    private static final Pattern patternProxyNumber = Pattern.compile(REGULAR_EXP_PROXY_NUMBER);
    private static final Pattern patternRecepientEmployeeName = Pattern.compile(REGULAR_EXP_RECEPIENT_EMPLOYEE_NAME);


    @Override
    public boolean isValid(Shipment shipment) {
        String quantityValid = String.valueOf(shipment.getShipmentQuantity());
        String priceValid = String.valueOf(shipment.getShipmentPrice());
        String dateValid = String.valueOf(shipment.getShipmentDate());
        String invoiceNumberValid = String.valueOf(shipment.getInvoiceNumber());
        String proxyNumberValid = String.valueOf(shipment.getProxyNumber());
        String recepientEmployeeNameValid = String.valueOf(shipment.getRecepientEmployeeName());

        Matcher matcherQuantity = patternQuantity.matcher(quantityValid);
        Matcher matcherPrice = patternPrice.matcher(priceValid);
        Matcher matcherDate = patternDate.matcher(dateValid);
        Matcher matcherInvoiceNumber = patternInvoiceNumber.matcher(invoiceNumberValid);
        Matcher matcherProxyNumber = patternProxyNumber.matcher(proxyNumberValid);
        Matcher matcherRecepientEmployeeNameValid = patternRecepientEmployeeName.matcher(recepientEmployeeNameValid);

        return matcherQuantity.find() &
                matcherPrice.find() &
                matcherDate.find() &
                matcherInvoiceNumber.find() &
                matcherProxyNumber.find() &
                matcherRecepientEmployeeNameValid.find();
    }
}
