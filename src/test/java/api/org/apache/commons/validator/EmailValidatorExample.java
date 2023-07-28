package api.org.apache.commons.validator;

import org.apache.commons.validator.routines.EmailValidator;

public class EmailValidatorExample {

    public static void main(String[] args) {
        String email = "example@example.com";
        String emailWrong = "exampleexample.com";

        if (isValidEmail(email)) {
            System.out.printf("Valid email address:%s!%n",email);
        } else {
            System.out.printf("Invalid email address;%s!%n", email);
        }

        if (isValidEmail(emailWrong)) {
            System.out.printf("Valid email address:%s!%n",emailWrong);
        } else {
            System.out.printf("Invalid email address;%s!%n", emailWrong);
        }
    }

    private static boolean isValidEmail(String email) {
        // Create an instance of EmailValidator
        EmailValidator validator = EmailValidator.getInstance();

        // Check if the email is valid
        return validator.isValid(email);
    }
}