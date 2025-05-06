import java.util.function.Function;

public class GradeUtils {

    // Через лямбду
    public static final Function<Integer, String> toText = g -> {
        if (g >= 90) return "Відмінно";
        if (g >= 75) return "Добре";
        if (g >= 60) return "Задовільно";
        return "Незадовільно";
    };

    // Через метод
    public static String describe(int grade) {
        return toText.apply(grade);
    }
}