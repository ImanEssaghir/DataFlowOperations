public class BookStoreDB {

    private String isbn;
    private String title;
    private String author;
    private  String publisher;
    private String store;
    private String location;

    public BookStoreDB(String isbn, String title, String author, String publisher, String store, String location) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.store = store;
        this.location = location;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getStore() {
        return store;
    }

    public String getLocation() {
        return location;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}
