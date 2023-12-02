package org.example;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Book {
    @JsonProperty("titulo")
    private String title;
    private String author;
    private int isbn;
    private int year;
    private int pages;

    @Override
    public String toString() {
        return "Book: " +
                "Title= " + title +
                ", Author= " + author  +
                ", ISBN= " + isbn  +
                ", Year= " + year +
                ", Pages= " + pages;
    }
}
