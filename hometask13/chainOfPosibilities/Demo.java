package com.htp.hometask13.chainOfPosibilities;

public class Demo {
    public static void main(String[] args) {
        Text reportWord = new Word(Choise.CHOISE_WORD);
        Text reportSentence = new Sentence(Choise.CHOISE_SENTENCE);
        Text reportParagpaph = new Paragraph(Choise.CHOISE_PARAGRAPH);

        reportWord.setNext(reportSentence);
        reportSentence.setNext(reportParagpaph);

        reportWord.manager("(Level 1) ", Choise.CHOISE_WORD);
        reportWord.manager("(Level 2) ", Choise.CHOISE_SENTENCE);
        reportWord.manager("(Level 3) ", Choise.CHOISE_PARAGRAPH);

    }
}
