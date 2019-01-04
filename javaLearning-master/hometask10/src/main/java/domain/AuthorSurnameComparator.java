package domain;

import java.util.Comparator;

public class AuthorSurnameComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getAutorSurname().compareTo(o2.getAutorSurname());
    }
}
