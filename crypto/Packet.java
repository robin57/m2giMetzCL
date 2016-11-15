/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

/**
 *
 * @author PME
 */
public abstract class Packet {

    final String sep = " ";
    private StringBuilder msg;
    private byte[] msgEnc;

    public Packet() {

    }

    public Packet(String id) {

        this.msg = new StringBuilder(id);

    }

    public Packet(byte[] enc) {

        this.msgEnc = enc;

    }

    public void add(String opt) {

        this.msg.append(sep);
        this.msg.append(opt);

    }

    public void add(float opt) {

        this.msg.append(sep);
        this.msg.append(opt);

    }

    public void add(int opt) {

        this.msg.append(sep);
        this.msg.append(opt);

    }

    public void setId(String id) {

        this.msg.append("#");
        this.msg.append(id);

    }

    public String getMsg() {

        return msg.toString();

    }

    public void setMsg(String msg) {

        this.msg = new StringBuilder();
        this.msg.append(msg);

    }

    public void setMsgEnc(byte[] enc) {

        this.msgEnc = enc;

    }

    public byte[] getMsgEnc() {

        return this.msgEnc;

    }

    public abstract byte[] onSend();

    public abstract String onReceive();

    public abstract byte[] encrypter(final String message, SecretKey cle)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

    public abstract String decrypter(final byte[] donnees, SecretKey cle)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException;

}
