/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package caesers.cipher;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class CaesersCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Text : ");
        String str = sc.nextLine();
        //Encryption 
        int key = 3;
        StringBuffer encryptedStr = new StringBuffer();
        System.out.println(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch;
            if (Character.isLowerCase(str.charAt(i))) {
                ch = (char) (((int) ((str.charAt(i) + key - 97) % 26) + 97));
            } else {
                if (Character.isUpperCase(str.charAt(i))) {
                    ch = (char) (((int) ((str.charAt(i) + key - 65) % 26) + 65));
                } else {
                    ch = str.charAt(i);
                }
            }
            encryptedStr.append(ch);
        }
        System.out.println("Encrypted Text : " + encryptedStr);
        StringBuffer decryptedStr = new StringBuffer();
        for (int i = 0; i < str.length(); i++) {
            char ch;
            if (Character.isLowerCase(encryptedStr.charAt(i))) {
                if ((int) ((encryptedStr.charAt(i) - key)) < 97) {
                    ch = (char) (((int) ((encryptedStr.charAt(i) - key - 97 + 26) % 26) + 97));
                } else {
                    ch = (char) (((int) ((encryptedStr.charAt(i) - key - 97) % 26) + 97));
                }
            } else {
                if (Character.isUpperCase(encryptedStr.charAt(i))) {
                    if ((int) ((encryptedStr.charAt(i) - key)) < 65) {
                        ch = (char) (((int) ((encryptedStr.charAt(i) - key - 65 + 26) % 26) + 65));
                    } else {
                        ch = (char) (((int) ((encryptedStr.charAt(i) - key - 65) % 26) + 65));
                    }
                } else {
                    ch = str.charAt(i);
                }
            }
            decryptedStr.append(ch);
        }
        System.out.println("Decrypted Text : " + decryptedStr);

    }
}
