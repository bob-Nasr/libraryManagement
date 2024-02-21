package libraryManagement;

// Behavioral Pattern: Observer

interface Observer {
    void update(String message);
}

interface Subject {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObservers(String message);
}

class PopularityObserver implements Observer {
 private final String name;

 public PopularityObserver(String name) {
     this.name = name;
 }

 @Override
 public void update(String message) {
     System.out.println(name + " received popularity update: " + message);
 }
}
