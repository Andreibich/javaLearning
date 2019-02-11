package com.htp.stock.service.validator;

import com.htp.stock.domain.to.ProductCatalog;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductCatalogValidator implements ValidatorInterface<ProductCatalog> {

    private static final ValidatorInterface<ProductCatalog> instance = new ProductCatalogValidator();

    private ProductCatalogValidator() {
    }

    public static ValidatorInterface<ProductCatalog> getInstance() {
        return instance;
    }


    private static final String REGULAR_EXP_PRODUCT_NAME = "([\\w \\s]+){2,40}";
    private static final String REGULAR_EXP_PRODUCT_UNIT = "[а-яa-z]{1,10}";

    private static final Pattern patternProductName = Pattern.compile(REGULAR_EXP_PRODUCT_NAME);
    private static final Pattern patternProductUnit = Pattern.compile(REGULAR_EXP_PRODUCT_UNIT);


    @Override
    public boolean isValid(ProductCatalog productCatalog) {
        String productNameValid = String.valueOf(productCatalog.getProductName());
        String productUnitValid = String.valueOf(productCatalog.getProductUnit());


        Matcher matcherProductName = patternProductName.matcher(productNameValid);
        Matcher matcherProductUnit = patternProductUnit.matcher(productUnitValid);


        return  matcherProductName.find() &
                matcherProductUnit.find();
    }
}

