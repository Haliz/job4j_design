package ru.job4j.serialization.json;

import com.google.gson.Gson;

import java.util.Arrays;

public class Book {
    private final String title;
    private final Author author;
    private final boolean forSale;
    private final int numberOfPages;
    private final String[] genre;

    public Book(String title, Author author, boolean forSale, int numberOfPages, String... genre) {
        this.title = title;
        this.author = author;
        this.forSale = forSale;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book{"
                + "title=" + title + '\''
                + ", autor=" + author
                + ", forSale=" + forSale
                + ", numberOfPages=" + numberOfPages
                + ", genre=" + Arrays.toString(genre)
                + '}';
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java. Полное руководство", new Author("Г. Шилдт"),
                true, 1488, "computers", "java");
        final Gson gson = new Gson();
        String strGson = gson.toJson(book1);
        Book book2 = gson.fromJson(strGson, Book.class);
        System.out.println(book1);
        System.out.println(book2);
        String myJson = "{" + "\"title\" : \"Java. Полное руководство\","
                + "\"author\" : { \"name\" : \"Хортсман\"},"
                + "\"forSale\" : false, \"numberOfPages\" : 500,"
                + "\"genre\" : [\"Computers\", \"Java\"]"
                + "}";
        Book book3 = gson.fromJson(myJson, Book.class);
        System.out.println(book3);
    }
}
