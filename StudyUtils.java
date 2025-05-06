import java.util.function.Predicate;

public class StudyUtils {

    // Через лямбду
    public static final Predicate<Integer> magistrCheck = c -> c == 5 || c == 6;

    // Через метод
    public static boolean isMagistr(int course) {
        return magistrCheck.test(course);
    }
}
