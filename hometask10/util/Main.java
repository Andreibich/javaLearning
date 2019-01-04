package com.htp.hometask10.util;

import com.htp.hometask10.domain.AuthorMiddleNameComparator;
import com.htp.hometask10.domain.AuthorNameComparator;
import com.htp.hometask10.domain.AuthorSurnameComparator;
import com.htp.hometask10.domain.Book;
import com.htp.hometask10.domain.CatalogComparator;
import com.htp.hometask10.domain.Category;
import com.htp.hometask10.domain.Student;
import com.htp.hometask10.domain.StudentSurnameComparator;
import com.htp.hometask10.util.LetterCheck;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {

        Book book1 = new Book("Мастер и Маргарита", "Михаил", "Афанасьевич", "Булгаков");
        Book book2 = new Book("Ася", "Иван", "Сергеевич", "Тургенев");
        Book book3 = new Book("Мертвые души", "Николай", "Васильевич", "Гоголь");
        Book book4 = new Book("Хождение по мукам", "Алексей", "Николаевич", "Толстой");
        Book book5 = new Book("Мертвые души", "Николай", "Васильевич", "Гоголь");
        Book book6 = new Book("Записки охотника", "Иван", "Сергеевич", "Тургенев");
        Book book7 = new Book("Война и мир", "Лев", "Николаевич", "Толстой");
        Book book8 = new Book("Левша", "Николай", "Семенович", "Лесков");
        Book book9 = new Book("Мертвые души", "Николай", "Васильевич", "Гоголь");
        Book book10 = new Book("Обыкновенная история", "Иван", "Александрович", "Гончаров");
        Book book11 = new Book("Герой нашего времени", "Михаил", "Юрьевич", "Лермонтов");
        Book book12 = new Book("Записки из Мертвого дома", "Федор", "Михайлович", "Достоевский");
        Book book13 = new Book("Мертвые души", "Николай", "Васильевич", "Гоголь");
        Book book14 = new Book("Палата №6", "Антон", "Павлович", "Чехов");
        Book book15 = new Book("Мцыри", "Михаил", "Юрьевич", "Лермонтов");
        Book book16 = new Book("Преступление и наказание", "Федор", "Михайлович", "Достоевский");
        Book book17 = new Book("Мертвые души", "Николай", "Васильевич", "Гоголь");
        Book book18 = new Book("Голова профессора Доуэля", "Александр", "Романович", "Беляев");
        Book book19 = new Book("Доктор Живаго", "Борис", "Леонидович", "Пастернак");
        Book book20 = new Book("Собачье сердце", "Михаил", "Афанасьевич", "Булгаков");
        Book book21 = new Book("Мертвые души", "Николай", "Васильевич", "Гоголь");
        Book book22 = new Book("Униженные и оскорбленные", "Федор", "Михайлович", "Достоевский");
        Book book23 = new Book("Руслан и Людмила", "Александр", "Сергеевич", "Пушкин");
        Book book24 = new Book("Братья Карамазовы", "Федор", "Михайлович", "Достоевский");
        Book book25 = new Book("Белая гвардия", "Михаил", "Афанасьевич", "Булгаков");

//        Task 1

        List<Book> bookList1 = new LinkedList<>();
        bookList1.add(book1);
        bookList1.add(book2);
        bookList1.add(book3);

        System.out.println("Task1");
        for (Book element : bookList1) {
            System.out.println(element);
        }

        bookList1.remove(1);
        System.out.println();

        for (Book element : bookList1) {
            System.out.println(element);
        }
        System.out.println();


//        Task 2

        Set<Book> bookHashSet2 = new HashSet<>();
        bookHashSet2.add(book1);
        bookHashSet2.add(book2);
        bookHashSet2.add(book3);
        bookHashSet2.add(book4);
        bookHashSet2.add(book5);
        bookHashSet2.add(book6);
        bookHashSet2.add(book7);
        bookHashSet2.add(book8);
        bookHashSet2.add(book9);
        bookHashSet2.add(book10);
        bookHashSet2.add(book11);
        bookHashSet2.add(book12);
        bookHashSet2.add(book13);
        bookHashSet2.add(book14);
        bookHashSet2.add(book15);
        bookHashSet2.add(book16);
        bookHashSet2.add(book17);
        bookHashSet2.add(book18);
        bookHashSet2.add(book19);
        bookHashSet2.add(book20);
        bookHashSet2.add(book21);
        bookHashSet2.add(book22);
        bookHashSet2.add(book23);
        bookHashSet2.add(book24);
        bookHashSet2.add(book25);

        System.out.println("Task2");
        for (Book element : bookHashSet2) {
            System.out.println(element);
        }

        System.out.println();

        //TODO method with contains in list letters to constants
        LetterCheck letterCheck = new LetterCheck();
        letterCheck.checkMethod(bookHashSet2);

        System.out.println();


//        Task 3

        System.out.println("Task3");
        List<Book> sortedList3 = new ArrayList<>(bookHashSet2);
        Collections.sort(sortedList3, new AuthorNameComparator());
        for (Book element : sortedList3) {
            System.out.println(element);
        }

        System.out.println();

        sortedList3.sort(new AuthorMiddleNameComparator());
        for (Book element : sortedList3) {
            System.out.println(element);
        }

        System.out.println();

        Set<Book> bookTreeSet3 = new TreeSet<>(new AuthorSurnameComparator());
        bookTreeSet3.addAll(sortedList3);
        for (Book element : bookTreeSet3) {
            System.out.println(element);
        }
        System.out.println();


//        Task 4

        Student student1 = new Student("Ivanov", "Ivan", 19);
        Student student2 = new Student("Petrov", "Vasiliy", 20);
        Student student3 = new Student("Zakharov", "Viktor", 21);
        Student student4 = new Student("Vasilenko", "Sergey", 19);
        Student student5 = new Student("Tchaikovsky", "Anton", 18);
        Student student6 = new Student("Bogdanovich", "Viacheslav", 19);
        Student student7 = new Student("Chernick", "Denis", 20);
        Student student8 = new Student("Bragin", "Boris", 20);
        Student student9 = new Student("Mandrick", "Anton", 21);

        Set<Student> studentTreeSet = new TreeSet<>(new StudentSurnameComparator());

        studentTreeSet.add(student1);
        studentTreeSet.add(student2);
        studentTreeSet.add(student3);
        studentTreeSet.add(student4);
        studentTreeSet.add(student5);
        studentTreeSet.add(student6);
        studentTreeSet.add(student7);
        studentTreeSet.add(student8);
        studentTreeSet.add(student9);

        System.out.println("Task4");
        for (Student element : studentTreeSet) {
            System.out.println(element);
        }

        System.out.println();
        Iterator<Student> iterator = studentTreeSet.iterator();

        //TODO
        while (iterator.hasNext()) {
            if (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                if (iterator.hasNext()) {
                    iterator.next();
                }
            }
        }


        System.out.println();
        for (Student element : studentTreeSet) {
            System.out.println(element);
        }

//        Task 5

        HashMap<String, Integer> catalog = new HashMap<>();

        Category category1 = new Category("Laptop", 8635);
        Category category2 = new Category("Computer", 5691);
        Category category3 = new Category("Tablet PC", 1968);
        Category category4 = new Category("Monitor", 1928);
        Category category5 = new Category("All-in-one PC", 2232);
        Category category6 = new Category("Phone", 0);

        catalog.put(category1.getName(), category1.getQuantity());
        catalog.put(category2.getName(), category2.getQuantity());
        catalog.put(category3.getName(), category3.getQuantity());
        catalog.put(category4.getName(), category4.getQuantity());
        catalog.put(category5.getName(), category5.getQuantity());
        catalog.put(category6.getName(), category6.getQuantity());

        System.out.println("\nTask 5");
        for (Iterator it = catalog.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(me.getKey() + ": " + me.getValue());

        }

        //TODO: type for particular list
        List list = new LinkedList<>(catalog.entrySet());
        Collections.sort(list, new CatalogComparator());
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }

        Iterator it1 = sortedHashMap.entrySet().iterator();
        while (it1.hasNext()) {
            Map.Entry me = (Map.Entry) it1.next();
            if (me.getValue().equals(0)) {
                it1.remove();
            }
        }

        //TODO foreach instead iterator
        for (Object o : sortedHashMap.entrySet()) {
            Map.Entry me = (Map.Entry) o;
            sortedHashMap.remove(me.getKey(), 0);
        }


        System.out.println("\nMax Value - " + Collections.max(list, new CatalogComparator()) + "\n");
        System.out.println("After Sorting and Removing 0-Values:");
        for (Iterator it = sortedHashMap.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry me = (Map.Entry) it.next();
            System.out.println(me.getKey() + ": " + me.getValue());

        }
    }
}