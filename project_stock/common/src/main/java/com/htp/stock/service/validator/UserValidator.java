package com.htp.stock.service.validator;

import com.htp.stock.domain.enums.Type;
import com.htp.stock.domain.to.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements ValidatorInterface<User> {

    private static final ValidatorInterface<User> instance = new UserValidator();

    private UserValidator() {
    }

    public static ValidatorInterface<User> getInstance() {
        return instance;
    }


    private static final String REGULAR_EXP_NAME = "[а-яА-Яa-zA-Z]{2,25}";
    private static final String REGULAR_EXP_SURNAME = "[а-яА-Яa-zA-Z]{2,25}";
    private static final String REGULAR_EXP_LOGIN = "[а-яА-Яa-zA-Z]{2,25}";
    private static final String REGULAR_EXP_PASSWORD = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    private static final String REGULAR_EXP_PHONE_NUMBER = "/^\\+?[0-9]{11,11}$/";
    private static final String REGULAR_EXP_EMAIL = "^^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    private static final String REGULAR_EXP_CREATION_DATE = "^[0-9]{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$";

    private static final Pattern patternName = Pattern.compile(REGULAR_EXP_NAME);
    private static final Pattern patternSurname = Pattern.compile(REGULAR_EXP_SURNAME);
    private static final Pattern patternLogin = Pattern.compile(REGULAR_EXP_LOGIN);
    private static final Pattern patternPassword = Pattern.compile(REGULAR_EXP_PASSWORD);
    private static final Pattern patternPhoneNumber = Pattern.compile(REGULAR_EXP_PHONE_NUMBER);
    private static final Pattern patternEmail = Pattern.compile(REGULAR_EXP_EMAIL);
    private static final Pattern patternCreationDate = Pattern.compile(REGULAR_EXP_CREATION_DATE);
//    private static final Pattern patternType = Pattern.compile(Type.ADMIN);

    @Override
    public boolean isValid(User user) {
        String nameValid = String.valueOf(user.getUserName());
        String surnameValid = String.valueOf(user.getSurname());
        String loginValid = String.valueOf(user.getLogin());
        String passwordValid = String.valueOf(user.getPassword());
        String phoneNumberValid = String.valueOf(user.getPhoneNumber());
        String emailValid = String.valueOf(user.getEmail());
        String creationDateValid = String.valueOf(user.getCreationDate());

        Matcher matcherName = patternName.matcher(nameValid);
        Matcher matcherSurname = patternSurname.matcher(surnameValid);
        Matcher matcherLogin = patternLogin.matcher(loginValid);
        Matcher matcherPassword = patternPassword.matcher(passwordValid);
        Matcher matcherPhoneNumber = patternPhoneNumber.matcher(phoneNumberValid);
        Matcher matcherEmail = patternEmail.matcher(emailValid);
        Matcher matcherCreationDate = patternCreationDate.matcher(creationDateValid);

        return matcherName.find() &
                matcherSurname.find() &
                matcherLogin.find() &
                matcherPassword.find() &
                matcherPhoneNumber.find() &
                matcherEmail.find() &
                matcherCreationDate.find();
    }
}
