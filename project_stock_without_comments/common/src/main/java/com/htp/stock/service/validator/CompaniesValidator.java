package com.htp.stock.service.validator;

import com.htp.stock.domain.to.Companies;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CompaniesValidator implements ValidatorInterface<Companies> {

    private static final ValidatorInterface<Companies> instance = new CompaniesValidator();

    private CompaniesValidator() {
    }

    public static ValidatorInterface<Companies> getInstance() {
        return instance;
    }


    private static final String REGULAR_EXP_COMPANY_NAME = "[([AZ][A-Za-z]+?)+, (\\w\\.)+]{1,25}";
    private static final String REGULAR_EXP_CITY = "[а-яА-Яa-zA-Z]{2,20}";
    private static final String REGULAR_EXP_ADDRESS = "([\\w \\s]+){2,40}";

    private static final Pattern patternCompanyName = Pattern.compile(REGULAR_EXP_COMPANY_NAME);
    private static final Pattern patternCity = Pattern.compile(REGULAR_EXP_CITY);
    private static final Pattern patternAddress = Pattern.compile(REGULAR_EXP_ADDRESS);


    @Override
    public boolean isValid(Companies companies) {
        String companyNameValid = String.valueOf(companies.getCompanyName());
        String cityValid = String.valueOf(companies.getCity());
        String addressValid = String.valueOf(companies.getAddress());

        Matcher matcherCompanyName = patternCompanyName.matcher(companyNameValid);
        Matcher matcherCity = patternCity.matcher(cityValid);
        Matcher matcherAddress = patternAddress.matcher(addressValid);

        return matcherCompanyName.find() &
                matcherCity.find() &
                matcherAddress.find();
    }

}
