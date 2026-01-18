import java.util.stream.Stream;
import java.util.List;

class Page implements Printable {
    private final String paragraphs;
    
    Page(String paragraphs) {
        this.paragraphs = paragraphs;
    }

    public void show() {
        indexify().forEach(x -> x.show());        
    }

    private Stream<Para> indexify() {
        List<String> blah = paragraphs.lines().toList();
        return Stream.iterate(1, x -> x + 1).limit(blah.size()).map(x -> new Para(x, blah.get(x)));
    }

    public String toString() {
        return "page";
    }
}
