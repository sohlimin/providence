import java.util.stream.Stream;

class Chapter extends View {
    
    Chapter(Page page) {
        super(Stream.of(page));
    }

    Chapter(Stream<Page> pages) {
        super(pages);
    }
    
/*
    public Stream<Page> pages() {
        return pages;
    }
*/
    public String toString() {
        return "chapter";
    }



}
