import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Перетворення оцінки в текст
        System.out.println("Оцінки (Function)");
        int[] scores = {95, 80, 70, 50};
        for (int score : scores) {
            System.out.println(score + ": " + GradeUtils.describe(score));
        }

        // 2. Перевірка курсу
        System.out.println("\n Рік: ");
        int[] courses = {1, 2, 5};
        for (int course : courses) {
            String level = StudyUtils.isMagistr(course) ? "Магістр" : "Бакалавр";
            System.out.println("Курс " + course + ": " + level);
        }

        // 3. Обробка списку оцінок
        List<Integer> allGrades = Arrays.asList(95, 85, 75, 65, 55, 45);

        System.out.println("\nБез stream:");
        for (int mark : allGrades) {
            if (mark >= 60) {
                System.out.println(mark + ": " + GradeUtils.describe(mark));
            }
        }

        System.out.println("\nЗ stream:");
        allGrades.stream()
                .filter(m -> m >= 60)
                .map(m -> m + ": " + GradeUtils.describe(m))
                .forEach(System.out::println);
    }
}
