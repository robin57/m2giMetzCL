/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

/**
 *
 * @author PME
 */
public class TestCrypto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        PacketFactory pf = new PacketFactory();
        Packet p = pf.creatPacket("msg");
        p.add("Bonjour, le chiffrement AES marche!");
        byte[] enc = p.onSend();
        System.out.println("Chiffré : " + new String(enc)); 
        
        Packet p2 = pf.creatPacket(enc);
        System.out.println("Déchiffré : " + p2.onReceive());

    }

}
