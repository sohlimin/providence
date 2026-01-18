import java.util.stream.Stream;
import java.util.Optional;
import java.util.List;

class View implements Viewable, Printable {
    private final Stream<Page> pages;
    private final int currentPageNumber;
    //private final Stream<Chapter> chapters;
    private final Optional<Book> optBook;

    View(Stream<Page> pages) {
        this.pages = pages;
        currentPageNumber = 0;
        //this.chapters = Stream.of();
        optBook = Optional.empty();
        
    }
    private View(Stream<Page> pages, int currentPageNumber) {
        this.pages = pages;
        this.currentPageNumber = currentPageNumber;
        //this.chapters = Stream.of();
        optBook = Optional.empty();
    }
/*
    View(Stream<Chapter> chapters) {
        this.pages = Stream.of();
        this.currentPageNumber = 0;
        this.chapters = chapters;
    }
*/

    View(int currentPageNumber, Book book) {
        optBook = Optional.of(book);
        pages = Stream.of();
        this.currentPageNumber = currentPageNumber;
    }

    //all pages
    public View view() {
        return new View(pages);  
    }

    public View viewOfBook() {
        return new View(currentPageNumber, optBook);
    }

    public Stream<Page> pages() {
        return pages;
    }
    
    //specific page
    public void show() {
        List<Page> lol = pages.toList();
        if (lol.isEmpty()) {
            System.out.print("");
        } else if (currentPageNumber >= lol.size()) {
            lol.getLast().show();
            //reduce
        } else {
            lol.get(currentPageNumber).show();
        }
    }

    //increments currentPageNumber
    public View next() {
        return new View(pages, currentPageNumber + 1);  
    }
    
    //decrements currentPageNumber
    public View prev() {
        if (currentPageNumber == 0) {
            return view();
        }
        return new View(pages, currentPageNumber - 1);    
    }

    public String toString() {
        return "view";
    }
}
