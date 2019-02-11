package com.htp.stock.service.validator;

import com.htp.stock.domain.to.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginValidator implements ValidatorInterface<User> {

    private static final ValidatorInterface<User> instance = new LoginValidator();

    private LoginValidator() {
    }

    public static ValidatorInterface<User> getInstance() {
        return instance;
    }

    private static final String REGULAR_EXP_LOGIN = "[а-яА-Яa-zA-Z]{2,25}";
    private static final String REGULAR_EXP_PASSWORD = /*"(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$"*/"[а-яА-Яa-zA-Z]{2,25}";

    private static final Pattern patternLogin = Pattern.compile(REGULAR_EXP_LOGIN);
    private static final Pattern patternPassword = Pattern.compile(REGULAR_EXP_PASSWORD);

    @Override
    public boolean isValid(User user) {
        String loginValid = String.valueOf(user.getLogin());
        String passwordValid = String.valueOf(user.getPassword());

        Matcher matcherLogin = patternLogin.matcher(loginValid);
        Matcher matcherPassword = patternPassword.matcher(passwordValid);

        return matcherLogin.find() &
                matcherPassword.find();
    }
}
