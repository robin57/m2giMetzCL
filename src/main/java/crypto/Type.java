package crypto;

/**
 * Created by florian on 24/12/16.
 *
 */
public enum Type {
    AES("AES");

    private final String value;


    /**
     * Constructor
     *
     * @param val value
     */
    private Type(String val){
        value = val;
    }

    public boolean equalsValue(String otherValue) {
        return otherValue != null && value.equals(otherValue);
    }


    @Override
    public String toString() {
        return this.value;
    }
}
