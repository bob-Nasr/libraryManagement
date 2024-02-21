package libraryManagement;

import java.util.ArrayList;
import java.util.List;

//Structural Pattern

//Bridge Pattern for LibraryItems with Books and DVDs as subItems
// Implementor
interface Implementation {
    void addItem(LibraryItem item);

    void removeItem(LibraryItem item);

    void displayItems();
}

// ConcreteImplementor
class ConcreteImplementation implements Implementation, Subject {
    private final List<LibraryItem> items = new ArrayList<>();
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void addItem(LibraryItem item) {
        items.add(item);
        if (item instanceof Observer) {
            addObserver((Observer) item);
        }
    }

    @Override
    public void removeItem(LibraryItem item) {
        items.remove(item);
        if (item instanceof Observer) {
            removeObserver((Observer) item);
        }
    }

    @Override
    public void displayItems() {
        System.out.println("Library Catalog:");
        for (LibraryItem item : items) {
            item.display();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

interface LibraryItem extends Observer {
    void display();

    String getTitle();
}


// RefinedAbstraction
class Book implements LibraryItem {
    private final String title;
    private final String author;
    private final int releaseYear;
    private final String isbn;

    public Book(String title, String author, int releaseYear, String isbn) {
        this.title = title;
        this.author = author;
        this.releaseYear = releaseYear;
        this.isbn = isbn;
    }

    @Override
    public void display() {
        System.out.println("Book: " + title + " by " + author + ", " + releaseYear + ", ISBN: " + isbn);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void update(String message) {
        System.out.println("Book received update: " + message);
    }
}

// RefinedAbstraction
class DVD implements LibraryItem {
    private final String title;
    private final String director;
    private final int releaseYear;

    public DVD(String title, String director, int releaseYear) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
    }

    @Override
    public void display() {
        System.out.println("DVD: " + title + " directed by " + director + ", " + releaseYear);
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void update(String message) {
        System.out.println("DVD received update: " + message);
    }
}

// Composite Pattern for Series
class Series implements LibraryItem {
    private final String title;
    private final List<LibraryItem> items = new ArrayList<>();

    public Series(String title) {
        this.title = title;
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    @Override
    public void display() {
        System.out.println("Series: " + title);
        for (LibraryItem item : items) {
            item.display();
        }
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void update(String message) {
        System.out.println("Series received update: " + message);
    }
}
