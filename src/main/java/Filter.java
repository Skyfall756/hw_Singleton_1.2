import java.util.ArrayList;
import java.util.List;

public class Filter {

    protected int threshold;

    public Filter(int threshold) {
        this.threshold = threshold;
    }

    public List<Integer> filterOut (List<Integer> source) {
        Logger logger = Logger.getLogger();
        logger.log("Запускаем фильтрацию");
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < source.size(); i++) {
            int s = source.get(i);
            if (s <= threshold) {
                result.add(s);
                logger.log("Элемент " + "\"" + s + "\"" + " проходит");
            } else {
                logger.log("Элемент " + "\"" + s + "\"" + " не проходит");
            }
        }
        logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());
        logger.log("Выводим результат на экран");
        System.out.println("Отфильтрованный список: " + result);
        return result;
    }
}
