import org.w3c.dom.ls.LSOutput;

import java.util.*;

public class Catalogue {
    private HashMap<String, Book> booksByISBN;
    private HashMap<String, Set<Book>> booksByTitle;
    private HashMap<String, Set<Book>> booksByAuthor;
    private HashMap<String, Set<Book>> booksByPublisher;

    public Catalogue() {
        booksByISBN = new HashMap<>();
        booksByAuthor = new HashMap<>();
        booksByTitle = new HashMap<>();
        booksByPublisher = new HashMap<>();
    }

    public boolean putBook(Book book) {
        boolean added = booksByISBN.put(book.getIsbn(), book) == null;
        if(added) {
            booksByAuthor.computeIfAbsent(book.getAuthor(), k -> new HashSet<>()).add(book);
            booksByTitle.computeIfAbsent(book.getTitle(), k -> new HashSet<>()).add(book);
            booksByPublisher.computeIfAbsent(book.getPublisher(), k -> new HashSet<>()).add(book);
        }
        return added;
    }

    public Book searchByISBN(String ISBN) {
        return booksByISBN.get(ISBN);
    }

    public Set<Book> searchByTitle(String title) {
        return booksByTitle.getOrDefault(title, Collections.emptySet());
    }

    public Set<Book> searchByAuthor(String author) {
        return booksByAuthor.getOrDefault(author, Collections.emptySet());
    }

    public Set<Book> searchByPublisher(String publisher) {
        return booksByPublisher.getOrDefault(publisher, Collections.emptySet());
    }

    public boolean removeBook(Book book) {
        Book bookToRemove = booksByISBN.remove(book.getIsbn());

        if (bookToRemove != null) {
            removeFromIndex(booksByAuthor, bookToRemove.getAuthor(), bookToRemove);
            removeFromIndex(booksByTitle, bookToRemove.getTitle(), bookToRemove);
            removeFromIndex(booksByPublisher, bookToRemove.getPublisher(), bookToRemove);
            return true;
        }
        return false;
    }

    private void removeFromIndex(Map<String, Set<Book>> indexMap, String key, Book bookToRemove) {
        Set<Book> bookSet = indexMap.get(key);

        if (bookSet != null) {
            bookSet.remove(bookToRemove);

            if (bookSet.isEmpty()) {
                indexMap.remove(key);
            }
        }
    }

    public boolean updateBook(Book newBookData) {
        Book oldBookData = booksByISBN.get(newBookData.getIsbn());

        if (oldBookData == null) {
            return false;
        }
        manageIndexUpdate(booksByAuthor, oldBookData.getAuthor(), newBookData.getAuthor(), oldBookData, newBookData);
        manageIndexUpdate(booksByTitle, oldBookData.getTitle(), newBookData.getTitle(), oldBookData, newBookData);
        manageIndexUpdate(booksByPublisher, oldBookData.getPublisher(), newBookData.getPublisher(), oldBookData, newBookData);

        booksByISBN.replace(newBookData.getIsbn(), newBookData);
        return true;
    }

    private void manageIndexUpdate(
            Map<String, Set<Book>> indexMap,
            String oldKey,
            String newKey,
            Book oldBook,
            Book newBook)
    {
        if (oldKey.equals(newKey)) {
            return;
        }

        Set<Book> oldBookSet = indexMap.get(oldKey);
        if (oldBookSet != null) {
            oldBookSet.remove(oldBook);
            if (oldBookSet.isEmpty()) {
                indexMap.remove(oldKey); // Limpieza de memoria
            }
        }

        indexMap.computeIfAbsent(newKey, k -> new HashSet<>()).add(newBook);
    }

    public String toString() {
        if(!booksByISBN.isEmpty()) {
            String str = "";
            for (Map.Entry<String, Book> entry : booksByISBN.entrySet()) {
                str = str.concat(entry.getKey()).concat("\n");
            }
            return str;
        } else return "";
    }
}


