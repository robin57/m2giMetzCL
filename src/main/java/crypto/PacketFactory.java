/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;

/**
 * @author PME
 */
public class PacketFactory {

    private Type type;


    public PacketFactory() {

        this.setTypeAES();
    }


    public void setTypeAES() {

        this.type = Type.AES;
    }

    public Packet creatPacket(String id) {
        switch (type) {
            case AES:
                return new PacketAES(id);
            default:
                return null;
        }
    }

    public Packet creatPacket(byte[] enc) {
        switch (type) {
            case AES:
                return new PacketAES(enc);
            default:
                return null;
        }
    }

}
