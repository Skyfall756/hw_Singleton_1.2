import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static Logger logger = Logger.getLogger();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        logger.log("Запускаем программу");
        filter(createList());
        logger.log("Завершаем программу");

    }

    public static List<Integer> createList() {
        logger.log("Просим пользователя внести входные данные для списка");
        int size = 0;
        int max = 0;
        boolean correct;
        do {
            try {
                System.out.println("Введите размер списка:");
                size = scanner.nextInt();
                correct = true;
                if (size < 0) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                logger.log("Некорректный ввод размера списка");
                scanner.nextLine();
                correct = false;
            }
        } while (!correct);

        do {
            try {
                System.out.println("Введите верхнюю границу для значений:");
                max = scanner.nextInt();
                correct = true;
                if (max < 0) throw new InputMismatchException();
            } catch (InputMismatchException e) {
                logger.log("Некорректное значение верхней границы");
                scanner.nextLine();
                correct = false;
            }
        } while (!correct);

        logger.log("Создаем и наполняем список");

        List<Integer> list = new Random()
                .ints(size, 0, max + 1)
                .boxed()
                .collect(Collectors.toList());
        System.out.println("Вот случайный список: " + list);
        return list;
    }

    public static List<Integer> filter(List<Integer> resource) {
        int limit = 2147483647;
        List<Integer> result = new ArrayList<>();
        try {
            logger.log("Просим пользователя ввести входные данные для фильтрации");
            System.out.println("Введите порог для фильтра");
            limit = scanner.nextInt();
            Filter f = new Filter(limit);
            result = f.filterOut(resource);
        } catch (InputMismatchException e) {
            logger.log("Указан некорректный порог для фильтра");
            scanner.nextLine();
            filter(resource);
        }
        return result;
    }

}
