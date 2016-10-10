package com.example.jhon.loginapp.util;

/**
 * Created by jhon on 5/10/16.
 */

public class ValidateStrings {

    public static boolean validateUserName(String...params){
        for (String param : params) {
            if (param.equals(" ")){
                return false;
            }
            if (param.startsWith(" ")){
                return false;
            }

            if (param.length() < 4){
                return false;
            }
        }
        return true;
    }

    public static boolean validateUserPass(String...params){
        for (String param : params) {
            if (param.startsWith(" ")){
                return false;
            }
            if (param.length() < 7){
                return false;
            }
        }
        return true;
    }
}
