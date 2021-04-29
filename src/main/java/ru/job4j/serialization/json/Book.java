package ru.job4j.serialization.json;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public boolean isForSale() {
        return forSale;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public String[] getGenre() {
        return genre;
    }

    public static void main(String[] args) {
        Book book1 = new Book("Java. Полное руководство", new Author("Г. Шилдт"),
                true, 1488, "computers", "java");
        Book book2 = new Book("Java. Полное руководство", new Author("Хортсман"),
                false, 500, "Computers", "Java");

        System.out.println(new JSONObject(book1));

        /* JSONObject из json-строки */
        JSONObject jsonAuthor = new JSONObject("{\"name\" : \"Хортсман\"}");

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("Computers");
        list.add("Java");
        JSONArray jsonGenres = new JSONArray(list);

        /* JSONObject напрямую методом put */
        JSONObject jsonBook2 = new JSONObject();
        jsonBook2.put("title", book2.getTitle());
        jsonBook2.put("author", jsonAuthor);
        jsonBook2.put("forSale", book2.isForSale());
        jsonBook2.put("numberOfPages", book2.getNumberOfPages());
        jsonBook2.put("genres", jsonGenres);

        System.out.println(jsonBook2);
    }
}
