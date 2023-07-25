package LTCA.Container;

import LTCA.Entity.*;

import java.util.ArrayList;

public class ComponentContainer {
    private final ArrayList<Title> titles;
    private final ArrayList<Comment> comments;
    private final ArrayList<Sentence> sentences;
    private final ArrayList<Word> words;
    private final ArrayList<HardSentence> hardSentences;
    private final ArrayList<TranslateSentence> translateSentences;

    public ComponentContainer() {
        this.titles = new ArrayList<>();
        this.comments = new ArrayList<>();
        this.sentences = new ArrayList<>();
        this.words = new ArrayList<>();
        this.hardSentences = new ArrayList<>();
        this.translateSentences = new ArrayList<>();
    }

    public ArrayList<Title> getTitles() {
        return titles;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public ArrayList<Sentence> getSentences() {
        return sentences;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public ArrayList<HardSentence> getHardSentences() {
        return hardSentences;
    }
    public ArrayList<TranslateSentence> getTranslateSentences() {
        return translateSentences;
    }
}
