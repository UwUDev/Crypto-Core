package me.uwu.xchanger;

import me.uwu.xchanger.utils.Password;

public class PassTest {
    public static void main(String[] args) {
        Password password = new Password();
        System.out.println(password.generatePassword(17));
        System.out.println(password.generateWeakPassword());
        System.out.println(password.generateNormalPassword());
        System.out.println(password.generateStrongPassword());
        System.out.println(password.generateSuperStrongPassword());
        System.out.println(password.generateInsanePassword());
    }
}
