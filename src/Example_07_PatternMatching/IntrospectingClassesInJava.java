package Example_07_PatternMatching;

import java.util.Arrays;
import java.util.List;

public class IntrospectingClassesInJava {

    public static class Language {
        public final String name;
        public final boolean hasClosures;
        public final double version;
        public Language(String name, boolean hasClosures, double version) {
            this.name = name;
            this.hasClosures = hasClosures;
            this.version = version;
        }
    }

    private static String shouldILearn(Language language) {
        if (language.name.equals("Scala"))
            return "Scala!? For sure!";

        if (language.hasClosures)
            return "Has closures. Could be alright.";

        if (language.name.equals("Java")) {
            if (language.version >= 1.5)
                return "If you've got no better options...";

            if (language.version == 1.4)
                return "Depends. How much are they going to pay you?";

            return "Urrr... maybe change careers?";
        }

        return "Sorry. Don't know anything about that.";
    }

    public static void main(String[] args) {
        List<Language> languages = Arrays.asList(
            new Language("Scala", true, 2.9),
            new Language("Scala", true, 2.8),
            new Language("Ruby", true, 1.9),
            new Language("Javascript", true, 1.8),
            new Language("Java", false, 1.6),
            new Language("Java", false, 1.4),
            new Language("Java", false, 1.2),
            new Language("Visual Basic.NET", false, 2010)
        );

        for (Language language : languages) {
            System.out.println("Should I learn " + language.name + " " + language.version + " ?");
            System.out.println("    " + shouldILearn(language) + "\n");
        }

    }
}
