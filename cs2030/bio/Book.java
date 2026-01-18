import java.util.stream.Stream;

class Book {
    private final View view; //delegation, even when we dont have more than 1 parent, because fuck extends
    private final Stream<Chapter> chapters;    
    
    Book(Chapter chapter) {
        chapters = Stream.of(chapter); 
        view = new View(0, this);
        //super(chapter.pages());
        //super(Stream.of(chapter));
    }
    
    Book(Stream<Chapter> chapters) {
        this.chapters = chapters;
        view = new View(0, this);
        //super(chapters.flatMap(x -> x.pages())); //problem: not LAZILY implemented -> infinite cannot
        //but then if Book extends View, we have to super() and use View's constructor
        //so, overload View()? NO! name clash View(Stream<Page>) and View(Stream<Chapter>) are identical
        //generics? ahhhh fak this
        //super(chapters);
    }

    public View view() {
        return view.viewOfBook();    
    }

    public String toString() {
        return "book";
    }

}
