package me.uwu.xchanger;

import me.uwu.xchanger.utils.Crypto;

public class Main {
    public static void main(String[] args) {
        Crypto crypto = new Crypto("ﮄﮫﭽꜺḖᴙ۞ՖҢӪїῦ̤ȾǱ×ݭࢭἳὬἄ﷽ﭿﻦԫ֏Ҏз");
        Crypto crypto2 = new Crypto("ﮄﮫﭽꜺḖᴙ۞ՖҢӪїῦ̤ȾǱ×ݭࢭἳὬἄ﷽ﭿﻦԫ֏Ҏз");
        String message = "Java est un langage de programmation orienté objet créé par James Gosling et Patrick Naughton, employés de Sun Microsystems, avec le soutien de Bill Joy (cofondateur de Sun Microsystems en 1982), présenté officiellement le 23 mai 1995 au SunWorld. La société Sun a été ensuite rachetée en 2009 par la société Oracle qui détient et maintient désormais Java. Une particularité de Java est que les logiciels écrits dans ce langage sont compilés vers une représentation binaire intermédiaire qui peut être exécutée dans une machine virtuelle Java (JVM) en faisant abstraction du système d'exploitation.";

        crypto.printDebug(false); // false by default just for the example
        crypto2.printDebug(false);

        byte[] encoded = crypto.crypt(message); // client number encrypting with the key

        System.out.println("Encrypted result: " + Crypto.decodeUTF8(encoded)); // malicious person that convert to utf8 intercepted packet to see content
        System.out.println("Decrypted result: " + Crypto.decodeUTF8(crypto2.decrypt(encoded))); // client number 2 convert to utf8 after decrypting with the key
    }
}
