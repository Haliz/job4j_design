package ru.job4j.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "author")
public class Author {

    @XmlAttribute
    private String name;

    public Author() {

    }

    public Author(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Author{"
                + "name='" + name + '\''
                + '}';
    }
}
