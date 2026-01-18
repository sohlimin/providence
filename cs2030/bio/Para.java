class Para implements Printable {
    private final int paragraphNumber;    
    private final String text;
    
    Para(int paragraphNumber, String text) {
        this.paragraphNumber = paragraphNumber;
        this.text = text;
    }

    public void show() {
        System.out.println(String.format("%d: %s", paragraphNumber, text));
    }
    
    public String toString() {
        return "paragraph";
    }
}
