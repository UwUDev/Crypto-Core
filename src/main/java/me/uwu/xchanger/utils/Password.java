package me.uwu.xchanger.utils;

import java.nio.charset.StandardCharsets;
import java.util.Random;

public class Password {
    public static final String lowerCaseChars = "abcdefghijklmnopqrstuvwxyz";
    public static final String upperCaseChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String numbersChars = "0123456789";
    public static final String symbolsChars = "\"#$%&'()*-+/;,?.§<>{}=";
    public static final String strongerSymbolsChars = "£µùéè\\@çç^¨º¹²³[]|`~¡°¿¶¢¥©®±";

    private boolean lowerCase, upperCase, numbers, symbols, strongerSymbols;

    public Password (){
        this.lowerCase = true;
        this.upperCase = true;
        this.numbers = true;
    }

    public String generatePassword(int length){
        StringBuilder chars = new StringBuilder();
        if (this.lowerCase)
            chars.append(lowerCaseChars);
        if (this.upperCase)
            chars.append(upperCaseChars);
        if (this.numbers)
            chars.append(numbersChars);
        if (this.symbols)
            chars.append(symbolsChars);
        if (this.strongerSymbols)
            chars.append(strongerSymbolsChars);

        Random random = new Random();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i<=length; i++)
            sb.append(chars.charAt(random.nextInt(chars.length())));
        return sb.toString();
    }

    public String generateWeakPassword(){
        Random random = new Random();

        if (random.nextBoolean()) {
            this.strongerSymbols = false;
            this.symbols = false;
            this.numbers = false;
            this.upperCase = false;
            this.lowerCase = true;
        } else {
            this.strongerSymbols = false;
            this.symbols = false;
            this.numbers = true;
            this.upperCase = false;
            this.lowerCase = false;
        }

        return generatePassword(random.nextInt(2) + 4);
    }

    public String generateNormalPassword(){
        Random random = new Random();
        this.strongerSymbols = false;
        this.symbols = false;
        this.numbers = true;
        this.upperCase = true;
        this.lowerCase = true;
        return generatePassword(random.nextInt(3) + 8);
    }

    public String generateStrongPassword(){
        Random random = new Random();
        this.strongerSymbols = false;
        this.symbols = true;
        this.numbers = true;
        this.upperCase = true;
        this.lowerCase = true;
        return generatePassword(random.nextInt(4) + 14);
    }

    public String generateSuperStrongPassword(){
        Random random = new Random();
        this.strongerSymbols = true;
        this.symbols = true;
        this.numbers = true;
        this.upperCase = true;
        this.lowerCase = true;
        return generatePassword(random.nextInt(6) + 14);
    }

    public String generateInsanePassword(){
        Random random = new Random();
        this.strongerSymbols = true;
        this.symbols = true;
        this.numbers = true;
        this.upperCase = true;
        this.lowerCase = true;
        return generatePassword(random.nextInt(15) + 25);
    }

    public void setLowerCase(boolean lowerCase) {
        this.lowerCase = lowerCase;
    }

    public void setUpperCase(boolean upperCase) {
        this.upperCase = upperCase;
    }

    public void setNumbers(boolean numbers) {
        this.numbers = numbers;
    }

    public void setSymbols(boolean symbols) {
        this.symbols = symbols;
    }

    public void setStrongerSymbols(boolean strongerSymbols) {
        this.strongerSymbols = strongerSymbols;
    }

    public static String genKey(){
        return genKeyWithLength(32);
    }

    public static String genKeyWithLength(int length){
        byte[] array = new byte[length];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }
}
