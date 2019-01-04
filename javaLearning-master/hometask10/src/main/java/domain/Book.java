package domain;

public class Book {
    private String title;
    private String autorName;
    private String autorMiddleName;
    private String autorSurname;


    public Book() {
    }

    public Book(String title, String autorName, String autorMiddleName, String autorSurname) {
        this.title = title;
        this.autorName = autorName;
        this.autorMiddleName = autorMiddleName;
        this.autorSurname = autorSurname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutorName() {
        return autorName;
    }

    public void setAutorName(String autorName) {
        this.autorName = autorName;
    }

    public String getAutorMiddleName() {
        return autorMiddleName;
    }

    public void setMiddleName(String middleName) {
        this.autorMiddleName = middleName;
    }

    public String getAutorSurname() {
        return autorSurname;
    }

    public void setAutorSurname(String autorSurname) {
        this.autorSurname = autorSurname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        if (autorName != null ? !autorName.equals(book.autorName) : book.autorName != null) return false;
        if (autorMiddleName != null ? !autorMiddleName.equals(book.autorMiddleName) : book.autorMiddleName != null) return false;
        return autorSurname != null ? autorSurname.equals(book.autorSurname) : book.autorSurname == null;
    }

    @Override
    public int hashCode() {
        int result = title != null ? title.hashCode() : 0;
        result = 31 * result + (autorName != null ? autorName.hashCode() : 0);
        result = 31 * result + (autorMiddleName != null ? autorMiddleName.hashCode() : 0);
        result = 31 * result + (autorSurname != null ? autorSurname.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", autorName='" + autorName + '\'' +
                ", autorMiddleName='" + autorMiddleName + '\'' +
                ", autorSurname='" + autorSurname + '\'' +
                '}';
    }
}
