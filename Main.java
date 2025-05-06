import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {


        // Спосіб 1
        System.out.println("1 Завдання : ");
        System.out.println("1 спосіб:");
        Function<Integer,String> gradeToText1 = new Function<Integer, String>() {
            @Override
            public String apply(Integer grade) {
                if (grade>=90)return "Відмінно";
                else if (grade>=75)return "Добре";
                else if (grade>=60)return "Задовільно";
                else return "Незадовільно";
            }
        };
        System.out.println(gradeToText1.apply(92));

        // Спосіб 2
        System.out.println("2 спосіб:");
        Function<Integer,String> gradeToText = grade -> {
            if (grade>=90)return "Відмінно";
            else if (grade>=75)return "Добре";
            else if (grade>=60)return "Задовільно";
            else return "Незадовільно";
        };
        System.out.println(gradeToText.apply(85));
        System.out.println(gradeToText1.apply(70));
        System.out.println(gradeToText1.apply(50));

        // Спосіб 1
        System.out.println("2 Завдання : ");
        System.out.println("1 спосіб:");
        Predicate<Integer> isMaster = new Predicate<Integer>() {
            @Override
            public boolean test(Integer course) {
                return course>=5;
            }
        };
        System.out.println(isMaster.test(1));
        System.out.println(isMaster.test(2));
        System.out.println(isMaster.test(5));

        // Спосіб 2 для Predicate
        System.out.println("2 спосіб:");
        Predicate<Integer> isMaster1 = course -> course >= 5;
        System.out.println(isMaster1.test(1));
        System.out.println(isMaster1.test(2));
        System.out.println(isMaster1.test(5));

        // Спосіб 1 для перевірки оцінок
        System.out.println("3 Завдання : ");
        System.out.println("1 спосіб:");
        Predicate<Integer> hasPassed = grade -> grade >= 60;
        Function<Integer, String> gradeToText2 = grade -> {
            if (grade>=90)return "Відмінно";
            else if (grade>=75)return "Добре";
            else if (grade>=60)return "Задовільно";
            else return "Незадовільно";
        };

        List<Integer> grades = Arrays.asList(95, 85, 75, 65, 55, 45);
        System.out.println("Без Stream:");
        for (Integer grade : grades) {
            if (hasPassed.test(grade)) {
                System.out.println("Оцінка " +grade+ ": " +gradeToText2.apply(grade));
            }
        }

        // З Stream
        System.out.println("З Stream:");
        grades.stream()
                .filter(hasPassed)
                .map(grade -> "Оцінка "+grade+": " + gradeToText.apply(grade))
                .forEach(System.out::println);
    }
}