import java.util.Arrays;

public class Task {
    private String text;

    public Task() {
    }

    public Task(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        return text != null ? text.equals(task.text) : task.text == null;
    }

    @Override
    public int hashCode() {
        return text != null ? text.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Task{" +
                "text='" + text + '\'' +
                '}';
    }

    public void methodTask1() {
        System.out.println("Task1:");
        String text1 = text;
        char[] text1CharArray = text1.toCharArray();
        for (int i = 0; i < text1.length(); i++) {
            if (text1.charAt(i) == ' ' || text1.charAt(i) == '(' || text1.charAt(i) == '-') {
                text1CharArray[i + 1] = Character.toUpperCase(text1CharArray[i + 1]);
            }
        }
        text1 = new String(text1CharArray);
        System.out.println(text1 + "\n");
    }

    public void methodTask2() {
        System.out.println("Task2:");
        int quantityOfPunctuationMarks = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '.' || text.charAt(i) == ',' || text.charAt(i) == '!' || text.charAt(i) == '?' ||
                    text.charAt(i) == ',' || text.charAt(i) == ':' || text.charAt(i) == ';' || text.charAt(i) == '-' ||
                    text.charAt(i) == '(' || text.charAt(i) == ')' || text.charAt(i) == '\"') {
                quantityOfPunctuationMarks = quantityOfPunctuationMarks + 1;
            }
        }
        System.out.println("Quantity Of Punctuation Marks - " + quantityOfPunctuationMarks + "\n");
    }

    public void methodTask3() {
        System.out.println("Task3:");
        System.out.print("Founded numbers: ");
        int sum = 0;
        StringBuilder number = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                while (Character.isDigit(text.charAt(i))) {
                    number.append(text.charAt(i));
                    i++;
                }
                System.out.print(number + ", ");
                sum += Integer.parseInt(number.toString());
                number.delete(0, number.length());
            }
        }
        System.out.println("\nThe sum of numbers - " + sum + "\n");
    }

    public void methodTask4(int kIndex, char removeLetter) {
        System.out.println("Task4:");
        int a = 0;
        String text4 = text;
        char[] text4CharArray = text4.toCharArray();
        for (int i = 0; i < text4.length(); i++) {
            if (Character.isLetter(text4CharArray[i])) {

                while (Character.isLetter(text4CharArray[i])) {
                    a += 1;
                    i++;
                }
                if (a >= kIndex) {
                    text4CharArray[i - a + kIndex - 1] = removeLetter;

                }
                a = 0;
            }
        }
        text4 = new String(text4CharArray);
        System.out.println(text4 + "\n");
    }

    public void methodTask5(char firstSymbol, char secondSymbol) {
        System.out.println("Task5:");
        int a;
        int b;
        StringBuilder text5 = new StringBuilder(text);
        for (int i = 0; i < text5.length() - 1; i++) {
            a = 0;
            b = 0;
            if (text5.charAt(i) == firstSymbol) {
                a = i;
                for (int j = a + 1; j < text5.length(); j++) {
                    if (text5.charAt(j) == secondSymbol) {
                        b = j;
                        break;
                    }
                }
                if (a != 0 & b != 0) {
                    text5.delete(a + 1, b);
                }
            }
        }
        System.out.println(text5 + "\n");
    }

    public void methodTask6() {
        System.out.println("Task6:");
        int a;
        StringBuilder word = new StringBuilder();
        StringBuilder text6 = new StringBuilder(text);
        char[] text6CharArray = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {

            if (Character.isLetter(text6CharArray[i])) {
                a = 0;
                while (Character.isLetter(text6CharArray[i])) {
                    word.append(text.charAt(i));
                    i++;
                }
                for (int j = 0; j < text.length(); j++) {
                    if (text.regionMatches(true, j, word.toString(), 0, word.length())) {
                        a += 1;
                    }
                }
                System.out.print(word + "(" + a + ") ");
                word.delete(0, word.length());
            }
        }
        System.out.println("\n");
    }


    public void methodTask7() {
        System.out.println("Task7:");
        char[] text7CharArray = text.toCharArray();
        int quantityOfSentences = 0;
        for (int i = 0; i < text7CharArray.length; i++) {
            if (text7CharArray[i] == '.' || text7CharArray[i] == '!' || text7CharArray[i] == '?') {
                quantityOfSentences += 1;
            }
        }
        int[] sentences = new int[quantityOfSentences];

        System.out.println("Quantity of the sentences in the text - " + quantityOfSentences + "\n");


        int a;
        int b = 0;
        for (int j = 0; j < sentences.length; j++) {
            if (j == 0) {
                a = 0;
            } else {
                a = b;
            }
            int numberOfVowel = 0;
            int numberOfConsonant = 0;
            for (int i = a; i < text7CharArray.length; i++) {

                if (Character.isLetter(text7CharArray[i])) {
                    char l = text7CharArray[i];
                    if (l == 'a' || l == 'e' || l == 'i' || l == 'o' || l == 'u' || l == 'y' ||
                            l == 'A' || l == 'E' || l == 'I' || l == 'O' || l == 'U' || l == 'Y') {
                        numberOfVowel++;
                    } else {
                        numberOfConsonant++;
                    }
                }
                if (text7CharArray[i] == '.' || text7CharArray[i] == '!' || text7CharArray[i] == '?') {
                    sentences[j] = i;
                    b = i + 1;
                    System.out.println("Sentence #" + (j + 1) + ": vowel - " + numberOfVowel +
                            ", consonant - " + numberOfConsonant);
                    break;
                }
            }
        }
        System.out.println();
    }

    public void methodTask8(int wordLenght) {
        System.out.println("Task8:");
        char[] text8CharArray = text.toCharArray();
        int quantityOfSentences = 0;
        int quantityOfQuestSentences = 0;
        for (int i = 0; i < text8CharArray.length; i++) {
            if (text8CharArray[i] == '.' || text8CharArray[i] == '!' || text8CharArray[i] == '?') {
                quantityOfSentences += 1;
                if (text8CharArray[i] == '?') {
                    quantityOfQuestSentences += 1;
                }
            }
        }
        int[] sentences = new int[quantityOfSentences];
        System.out.println("Quantity of the sentences in the text - " + quantityOfSentences);
        System.out.println("Quantity of the '?'-sentences in the text - " + quantityOfQuestSentences + "\n");

        StringBuilder word = new StringBuilder();
        StringBuilder questSentence = new StringBuilder();

        int a;
        int b = 0;
        int e = 0;
        for (int j = 0; j < sentences.length; j++) {
            if (j == 0) {
                a = 0;
            } else {
                a = b;
            }

            for (int i = a; i < text8CharArray.length; i++) {
                if (text8CharArray[i] == '.' || text8CharArray[i] == '!' || text8CharArray[i] == '?') {
                    if (text8CharArray[i] == '?') {
                        for (int y = a; y <= i; y++) {
                            int c;
                            int d;
                            if (Character.isLetter(text8CharArray[y])) {
                                c = y;
                                while (Character.isLetter(text8CharArray[y])) {
                                    word.append(text.charAt(y));
                                    y++;
                                }
                                d = y;
                                if ((d - c) == wordLenght) {
                                    if (questSentence.toString().contains(word.toString())) {
                                    } else {
                                        questSentence.append(word + " ");
                                    }
//                                    System.out.print(word + " ");
                                }

                                word.delete(0, word.length());
                            }
                        }
                        System.out.print((e + 1) + ". " + questSentence.toString() + "? ");
                        questSentence.delete(0, questSentence.length());
                        System.out.println();
                        e++;
                    }
                    sentences[j] = i;
                    b = i + 1;
                    break;
                }
            }
        }
    }

}
