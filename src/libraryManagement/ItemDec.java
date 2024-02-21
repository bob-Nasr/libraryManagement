package libraryManagement;

//Structural Pattern

// Decorator Pattern
// Decorator to add additional details to items
class LibraryItemDecorator implements LibraryItem {
    private final LibraryItem item;
    private final String additionalDetails;

    public LibraryItemDecorator(LibraryItem item, String additionalDetails) {
        this.item = item;
        this.additionalDetails = additionalDetails;
    }

    @Override
    public void display() {
        item.display();
        System.out.println("Additional Details: " + additionalDetails);
    }

    @Override
    public String getTitle() {
        return item.getTitle();
    }

    @Override
    public void update(String message) {
        System.out.println("Decorator received update: " + message);
    }
}
