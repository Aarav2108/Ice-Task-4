

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
       String inputFile = "accounts.txt";
        String outputFile = "valid_accounts.txt";
        
         try (Scanner in = new Scanner(new File(inputFile));
             PrintWriter out = new PrintWriter(new FileWriter(outputFile))) {
 
            while (in.hasNextLine()) {
                String account = in.nextLine().trim();
                if (account.isEmpty()) 
 
                if (isValid(account)) {
                    System.out.println(account + " is valid");
                    out.println(account);
                } else {
                    System.out.println(account + " is invalid");
                }
            }
            System.out.println("Valid account numbers written to " + outputFile);
 
        } catch (FileNotFoundException e) {
            System.out.println("Input file not found: " + inputFile);
        } catch (IOException e) {
            System.out.println("Error writing output file: " + e.getMessage());
        }
    }
}
