package com.htp.hometask10.domain;

import java.util.Comparator;

public class AuthorNameComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getAutorName().compareTo(o2.getAutorName());
    }
}
