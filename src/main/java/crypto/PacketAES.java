/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author PME
 */
public class PacketAES extends Packet {

    final String key = "1DA14369D874E366CF853248811C2342";
    
    public PacketAES() {

    }

    public PacketAES(String id) {

        super(id);

    }

    public PacketAES(byte[] enc) {

        super(enc);

    }

    @Override
    public byte[] onSend() {

        try {

            SecretKey cle = new SecretKeySpec(key.getBytes(), Type.AES.toString());
            byte[] enc = encrypter(this.getMsg(), cle);
            this.setMsgEnc(enc);
            return this.getMsgEnc();

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {
        }
        return null;
    }

    @Override
    public String onReceive() {

        try {

            SecretKey cle = new SecretKeySpec(key.getBytes(), Type.AES.toString());
            String dec = decrypter(this.getMsgEnc(), cle);
            return dec;

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException e) {

        }
        return null;
    }

    @Override
    public byte[] encrypter(final String message, SecretKey cle)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance(Type.AES.toString());
        cipher.init(Cipher.ENCRYPT_MODE, cle);
        byte[] donnees = message.getBytes();
        return cipher.doFinal(donnees);
    }

    @Override
    public String decrypter(final byte[] donnees, SecretKey cle)
            throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException {

        Cipher cipher = Cipher.getInstance(Type.AES.toString());
        cipher.init(Cipher.DECRYPT_MODE, cle);

        return new String(cipher.doFinal(donnees));
    }

}
