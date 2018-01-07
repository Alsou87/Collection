import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;
import java.io.FileReader;
import static javax.swing.UIManager.get;
import static javax.swing.UIManager.installLookAndFeel;

public class Coll {
    private  Scanner scanner;
    private Map<String,Integer> statistics;
    public Coll(String path) throws FileNotFoundException {
        {
            scanner = new Scanner(new File(path));
            statistics = new HashMap<String, Integer>();
            while (scanner.hasNext()) {
                String word = scanner.useDelimiter("\\s+").next();
                Integer count = statistics.get(word);
                if (count == null) {
                    count = 0;
                }
                statistics.put(word, ++count);}
                //выбор максимального повторения слова
            }
            System.out.println("Вывод всех слов на консоль и их количество: ");
        }

    public Map<String,Integer> getStatistics() {
            return statistics;
    }
    public static void main (String[]args) throws FileNotFoundException {
            Coll collections = new Coll("C:\\Fail\\Fail1.txt");
            System.out.println(collections.getStatistics());
            collections.Ordering(collections.getStatistics());
            collections.Max(collections.getStatistics());
    }
    //метод сортировки слов по альфавиту
    void Ordering(Map<String, Integer> statis) {
        Set<String> words = new TreeSet<String>();
        Iterator<Map.Entry<String, Integer>> entryIterator1 = statis.entrySet().iterator();
        while (entryIterator1.hasNext()) {
            words.add(entryIterator1.next().getKey());
        }
        System.out.println("Сортировка слов по алфавиту: ");
        System.out.println(words);
    }
    //метод выбора максимально повторяющегося слова
    void Max (Map<String, Integer> statis) {
        int max = 0;
        String maxWord = null;
        for (String a: statis.keySet()){
            if (statis.get(a) > max) {
                max = statis.get(a);
                maxWord = a;
            }
        }
        System.out.println("Слово, повторяющееся максимальное кол-во раз: " + maxWord);
        System.out.println("Количество повторений: " + max);
    }
}








