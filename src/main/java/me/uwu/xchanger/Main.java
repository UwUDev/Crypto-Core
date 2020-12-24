package me.uwu.xchanger;

import me.uwu.xchanger.utils.Crypto;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Crypto crypto = new Crypto("T");

        System.out.println(crypto.decodeUTF8(crypto.crypt("Salut :)")));
        System.out.println(crypto.decodeUTF8(crypto.decrypt(crypto.crypt("Salut :)"))));
    }
}
