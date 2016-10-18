package t2.redes;

public class MibOption {
    private String value;
    private String text;

    public MibOption(String value, String text) {
        this.value = value;
        this.text = text;
    }

    public String getValue(){
        return value;
    }
    
    @Override
    public String toString() {
        return text;
    }
}
