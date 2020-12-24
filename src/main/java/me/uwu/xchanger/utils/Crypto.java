/*
*
* © UwUDev 2020-2021
*
* i made it with love for you guys.
* its free tu use <3
*
*/

package me.uwu.xchanger.utils;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Random;

public class Crypto {

    private String key;
    private boolean print = false;

    public Crypto(String key) {
        this.key = key;
    }
    
    public void printDebug(boolean b){
        this.print = b;
    }

    public byte[] decrypt(byte[] message){

        byte[] keyBytes = this.key.getBytes(StandardCharsets.US_ASCII);

        ArrayList<Byte> byteArray = new ArrayList<>();

        int state = 0;
        for (byte b : message) {
            if(state >= keyBytes.length)
                state = 0;
            if(this.print)
                System.out.println(b);
            byte oof = (byte) (b - keyBytes[state]);
            byteArray.add(oof);
            state++;
        }

        return getBytes(byteArray);
    }

    private byte[] getBytes(ArrayList<Byte> byteArray) {
        if(this.print) {
            System.out.println("\n\n");

            for (byte b : byteArray) {
                System.out.println(b);
            }
        }

        byte[] result = new byte[byteArray.size()];
        for(int i = 0; i < byteArray.size(); i++) {
            result[i] = byteArray.get(i);
        }

        return result;
    }

    public byte[] crypt(String message){
        byte[] keyBytes = this.key.getBytes(StandardCharsets.US_ASCII);
        byte[] bytes = message.getBytes(StandardCharsets.UTF_8);

        ArrayList<Byte> byteArray = new ArrayList<>();

        int state = 0;
        for (byte b : bytes) {
            if(state >= keyBytes.length)
                state = 0;
            if(this.print)
                System.out.println(b);
            byte oof = (byte) (b + keyBytes[state]);
            byteArray.add(oof);
            state++;
        }

        return getBytes(byteArray);
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    private static final Charset UTF8_CHARSET = StandardCharsets.UTF_8;

    public static String decodeUTF8(byte[] bytes) {
        return new String(bytes, UTF8_CHARSET);
    }

    byte[] encodeUTF8(String string) {
        return string.getBytes(UTF8_CHARSET);
    }

    public static String genkey(){
        return genkeyWithLength(32);
    }

    public static String genkeyWithLength(int length){
        byte[] array = new byte[length];
        new Random().nextBytes(array);

        return new String(array, StandardCharsets.UTF_8);
    }
}
