package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "book")
@XmlAccessorType(XmlAccessType.FIELD)
public class Book {
    @XmlAttribute
    private String title;
    private Author author;
    private boolean forSale;
    private int numberOfPages;
    @XmlElementWrapper(name = "genres")
    @XmlElement
    private String[] genre;

    public Book() {
    }

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

    public static void main(String[] args) throws JAXBException {
        Book book1 = new Book("Java. Полное руководство", new Author("Г. Шилдт"),
                true, 1488, "computers", "java");
        JAXBContext context = JAXBContext.newInstance(Book.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(book1, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
