package me.uwu.xchanger;

import me.uwu.xchanger.utils.Crypto;

public class Main {
    public static void main(String[] args) {
        Crypto crypto = new Crypto("ﮄﮫﭽꜺḖᴙ۞ՖҢӪїῦ̤ȾǱ×ݭࢭἳὬἄ﷽ﭿﻦԫ֏Ҏз");
        Crypto crypto2 = new Crypto("ﮄﮫﭽꜺḖᴙ۞ՖҢӪїῦ̤ȾǱ×ݭࢭἳὬἄ﷽ﭿﻦԫ֏Ҏз");

        //System.out.println(Crypto.decodeUTF8(crypto.crypt("Salut :)")));
        System.out.println(Crypto.decodeUTF8(crypto2.decrypt(crypto.crypt("Salut :)"))));
    }
}
