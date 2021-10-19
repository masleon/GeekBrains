import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Integer> wordsMap = new HashMap<>();
        String[] words = new String[]{
                "go",
                "hello",
                "apple",
                "pass",
                "walk",
                "go",
                "apple",
                "dream",
                "beyond",
                "green",
                "pass",
                "red",
                "pass"
        };
        for (int i = 0; i < words.length; i++) {
            if (wordsMap.containsKey(words[i])){
                wordsMap.put(words[i],wordsMap.get(words[i])+1);
            }
            else {
                wordsMap.put(words[i],1);
            }
        }
        System.out.println(wordsMap);

    }
}
