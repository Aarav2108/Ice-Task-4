

package com.mycompany.icetask4;

import java.io.*;
import java.util.Scanner;

public class IceTask4 {
    
    public static boolean isValid(String account) {
        if (account.length() != 6) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            char c = account.charAt(i);
            if (!Character.isDigit(c)) {
                return false;
            }
            sum += c - '0';
        }
        char last = account.charAt(5);
        if (!Character.isDigit(last)) {
            return false;
        }
        return (sum % 10) == (last - '0');
    }
    
    

    public static void main(String[] args) {
       
    }
}
