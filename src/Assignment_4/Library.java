package Assignment_4;

public class Library {
    // Add the missing implementation to this class
	String address;
	Book[] books = new Book[10];
	int bookCount = 0;
	
	Library(String newAddress) {
		address = newAddress;
	}
	
	void addBook(Book newBook) {
		books[bookCount++] = newBook;
//		System.out.println(bookCount);
	}
	
	static void printOpeningHours() {
		System.out.println("Libraries are open daily from 9am to 5pm.");
	}
	
	void printAddress() {
		System.out.println(address);
	}
	
	void borrowBook(String title) {
		for(int i = 0; i < bookCount; i++) {
			if(title.equals(books[i].getTitle())) {
				if(books[i].isBorrowed()) {
					System.out.println("Sorry, this book is already borrowed.");
				}else {
					books[i].borrowed();
					System.out.println("You successfully borrowed " + title);
				}
				return;
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
	}
	
	void printAvailableBooks() {
		if(bookCount == 0) {
			System.out.println("No book in catalog");
			return;
		}
		for(int i = 0; i < bookCount; i++) {
			if(!books[i].isBorrowed()) {
				System.out.println(books[i].getTitle());
			}
		}
	}
	
	void returnBook(String title) {
		for(int i = 0; i < bookCount; i++) {
			if(title.equals(books[i].getTitle())) {
				if(books[i].isBorrowed()) {
					System.out.println("You successfully returned The Lord of the Rings");
					books[i].returned();
				}else {
					System.out.println("The following book is not currently borrowed: " + title);
				}
				return;
			}
		}
		System.out.println("Sorry, this book is not in our catalog.");
	}

    public static void main(String[] args) {
        // Create two libraries
    	Library firstLibrary = new Library("10 Main St.");
        Library secondLibrary = new Library("228 Liberty St.");

        // Add four books to the first library
        firstLibrary.addBook(new Book("The Da Vinci Code"));
        firstLibrary.addBook(new Book("Le Petit Prince"));
        firstLibrary.addBook(new Book("A Tale of Two Cities"));
        firstLibrary.addBook(new Book("The Lord of the Rings"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstLibrary.printAddress();
        secondLibrary.printAddress();
        System.out.println();

        // Try to borrow The Lords of the Rings from both libraries
        System.out.println("Borrowing The Lord of the Rings:");
        firstLibrary.borrowBook("The Lord of the Rings");
        firstLibrary.borrowBook("The Lord of the Rings");
        secondLibrary.borrowBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of all available books from both libraries
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second library:");
        secondLibrary.printAvailableBooks();
        System.out.println();

        // Return The Lords of the Rings to the first library
        System.out.println("Returning The Lord of the Rings:");
        firstLibrary.returnBook("The Lord of the Rings");
        // Extra tests
        firstLibrary.returnBook("The Lord of the Rings");
        secondLibrary.returnBook("The Lord of the Rings");
        System.out.println();

        // Print the titles of available from the first library
        System.out.println("Books available in the first library:");
        firstLibrary.printAvailableBooks();
    }
} 