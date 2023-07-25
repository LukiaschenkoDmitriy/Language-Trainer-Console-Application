import LTCA.Compilator;
import LTCA.Container.ComponentContainer;
import LTCA.Entity.TranslateSentence;

public class Main {
    public static void main(String[] args) {
        String path = "D:\\Languages\\English\\A2.lta";
        Compilator compilator = new Compilator(path);
        compilator.compile();
        ComponentContainer componentContainer = compilator.getComponentContainer();

        for (TranslateSentence translateSentence : componentContainer.getTranslateSentences()) {
            System.out.println(translateSentence.getTranslate());
        }
    }
}