package libraryManagement;

// Client Side
public class LibraryManagement {
    public static void main(String[] args) {
        ConcreteImplementation implementation = new ConcreteImplementation();

        LibraryItem book = new Book("Title 1", "Author 1", 2023, "123-4-567-89123-4");
        LibraryItem dvd = new DVD("Title 2", "Director 2", 2023);

        Observer observer1 = new PopularityObserver("Observer1");
        Observer observer2 = new PopularityObserver("Observer2");

        implementation.addObserver(observer1);
        implementation.addObserver(observer2);

        implementation.addItem(new LibraryItemDecorator(book, "Genre 1"));
        implementation.addItem(new LibraryItemDecorator(dvd, "Genre 2"));

        testItem(book, implementation);
        testItem(dvd, implementation);
    }

    public static void testItem(LibraryItem item, ConcreteImplementation implementation) {
        System.out.println("Tests with library item.");

        // Test checkout
        item.update("Checkout event");

        // Test return
        item.update("Return event");

        // Display library items
        implementation.displayItems();
    }
}
