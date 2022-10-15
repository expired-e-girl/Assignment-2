//Marilyn Ruptash
//ID: 261126626
//This program will validate if an email address input by a user is valid or not. It contains different methods to validate
//the format, allowed and required characters and any syntax errors.

import java.util.*;

import static java.lang.Character.isLetter;

public class EmailValidation {

    public static boolean isAlphanumeric(Character x) { //Method to validate if characters are alphanumerical or not
        boolean alphanumerical = Character.isLetterOrDigit(x);
        return alphanumerical;
    }


    public static String getPrefix(String email) { // Method that returns the prefix part of the input email address
        int i = email.indexOf('@');
        String prefix = (email.substring(0, i));
        return prefix;
    }


    public static String getDomain(String email) { // Method that returns the domain part of the input email address
        int i = email.indexOf('@');
        String domain = (email.substring(i + 1));
        return domain;
    }

    public static boolean isValidPrefixChar(Character prefixChars) { // Method that verifies if the prefix characters are valid or not
        if (isAlphanumeric(prefixChars) || (prefixChars == '.') || (prefixChars == '-') || (prefixChars == '_')) {
            return true;
        } else return false;
    }


    public static boolean isValidDomainChar(Character domainChars) { // Method that verifies if the domain characters are valid or not
        if (isAlphanumeric(domainChars) || (domainChars == '.') || (domainChars == '-')) {
            return true;
        } else return false;
    }


    public static boolean exactlyOneAt(String email) { // Method to determine if the email string contains exactly one @ character
        if (email.indexOf("@") != email.lastIndexOf("@")) { // Loop to check the index of @ and make sure it is the last possible occurrence
            return false;
        } else return true;
    }

    public static Boolean isValidPrefix(String prefix) { // Method that checks if the prefix of the email is valid
        if (prefix.length() < 1)        // Loop checks that length is at least one character
            return false;
        else if (!isAlphanumeric(prefix.charAt(0)) && !isAlphanumeric(prefix.charAt(prefix.length() - 1)))
            return false;               // Checks if first and last character of prefix is alphanumeric
        for (int i = 1; prefix.length() > i; i++){
            if (!isValidPrefixChar(prefix.charAt(i))) // Checks is a valid prefix character
                return false;
            if ((prefix.charAt(i - 1)) == '.' || (prefix.charAt(i - 1)) == '-' || (prefix.charAt(i - 1)) == '_') {
                if (!isAlphanumeric(prefix.charAt(i))) // Checking that punctuation is followed by alphanumerical character
                    return false;
            }
        }
        return true;
    }

    public static boolean isValidDomain(String domain) { // Method that checks if the domain of the email is valid
        if (domain.indexOf('.') == 0) // Making sure domain has at least one period
            return false;
        String firstPortion = domain.substring(0, domain.lastIndexOf('.')); // Portion one before last occurrence of period
        String secondPortion = domain.substring(domain.lastIndexOf('.') + 1);   // Portion two after last occurrence of period

        boolean portionsLength = firstPortion.length() >= 1 && secondPortion.length() >= 2; // Length of each portion

        if (!portionsLength)    // Checking if portions have appropriate length
            return false;
        if (!isAlphanumeric(domain.charAt(0)) && !isAlphanumeric(domain.charAt(domain.length() - 1)))
            return false;       // Checking if first and last character of domain are alphanumerical

        for (int i = 1; firstPortion.length() > i; i++){
            if (!isValidDomainChar(firstPortion.charAt(i))) // Checking if domain characters are valid in first portion
                return false;
            if ((firstPortion.charAt(i - 1)) == '-' || (firstPortion.charAt(i - 1)) == '.') {
                if (!isAlphanumeric(firstPortion.charAt(i)))  // Checking that punctuation in first portion is followed by alphanumerical character
                    return false;
            }
            for (int j = 0; secondPortion.length() > j; j++){ // Checking that second portion is only letters
                if(!isLetter(secondPortion.charAt(j)))
                    return false;
            }
        }
        return true;
    }

        public static boolean isValidEmail(String email){
            String prefix = getPrefix(email); // Obtaining prefix with method
            String domain = getDomain(email); // Obtaining domain with method

            if (exactlyOneAt(email) && isValidDomain(domain) && isValidPrefix(prefix)) {
                return true;
            } else {
                return false;
            }
        }

        public static void main (String[]args){
            Scanner input = new Scanner(System.in); // Initialize scanner
            System.out.println("Please enter your full email address: "); // Ask user to input their email
            String email = input.nextLine();

            if (isValidEmail(email)) { // Calling the email validation method
                System.out.println("The email is valid.");  // If all conditions are respected, email is valid
            } else System.out.println("The email is invalid."); // If one condition is not respected, email is invalid
        }
}
