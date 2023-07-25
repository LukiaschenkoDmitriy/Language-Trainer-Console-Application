package LTCA;

import LTCA.Exception.FileFormatException;
import LTCA.Container.ComponentContainer;
import LTCA.Converter.*;
import LTCA.Entity.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Compilator {
    public static final String FORMAT_MESSAGE = ".lta";
    private BufferedReader bufferedReader;
    private final ComponentContainer componentContainer = new ComponentContainer();
    public Compilator(String absoluteFilePath) {
        this.checkFileExist(absoluteFilePath);
        this.checkRightFormat(absoluteFilePath);
    }

    public void checkFileExist(String path) {
        try {
            this.bufferedReader = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void checkRightFormat(String path) {
        try {
            String actualFormat = path.substring(path.lastIndexOf("."));
            if (!path.endsWith(FORMAT_MESSAGE))
                throw new FileFormatException(actualFormat, FORMAT_MESSAGE);
        } catch (FileFormatException e) {
            throw new RuntimeException(e);
        }
    }

    public void compile() {
        try {
            String actualLine = bufferedReader.readLine();
            int lineNumber = 0;
            while(actualLine != null) {
                if (actualLine.isEmpty()) {
                    actualLine = bufferedReader.readLine();
                    continue;
                }

                if (CommentConverter.getSingleton().validate(actualLine)) {
                    this.componentContainer.getComments().add(new Comment(lineNumber, actualLine));
                }
                else if (HardSentenceConverter.getSingleton().validate(actualLine)) {
                    this.componentContainer.getHardSentences().add(new HardSentence(lineNumber, actualLine));
                }
                else if (TitleConverter.getSingleton().validate(actualLine)) {
                    this.componentContainer.getTitles().add(new Title(lineNumber, actualLine));
                }
                else if (TranslateSentenceConverter.getSingleton().validate(actualLine)) {
                    this.componentContainer.getTranslateSentences().add(new TranslateSentence(lineNumber, actualLine));
                }
                else if (WordConverter.getSingleton().validate(actualLine)) {
                    this.componentContainer.getWords().add(new Word(lineNumber, actualLine));
                } else this.componentContainer.getSentences().add(new Sentence(lineNumber, actualLine));

                lineNumber++;
                actualLine = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ComponentContainer getComponentContainer() {
        return componentContainer;
    }
}
