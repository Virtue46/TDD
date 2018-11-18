import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by jxzhong on 2018/5/22.
 */
public class WordFrequencyGame {
    public String getResult(String inputStr) {

        String[] split = inputStr.split("\\s+");


        try {

            List<Input> inputList = initInputWord(split);

            inputList = countWordsFrequency(inputList);

            inputList.sort((w1, w2) -> w2.getWordCount() - w1.getWordCount());

            StringJoiner joiner = formatWords(inputList);


            return joiner.toString();
        } catch (Exception e) {
            return "Calculate Error";
        }
    }

    private StringJoiner formatWords(List<Input> inputList) {
    StringJoiner joiner = new StringJoiner("\n");
        for (Input w : inputList) {
            String s = w.getValue() + " " + w.getWordCount();
            joiner.add(s);
        }
//        inputList.stream().map(word -> String.format("%s %d"),word.getValue(),word.getWordCount()).collect(joiniong);
        return joiner;
    }

    private List<Input> countWordsFrequency(List<Input> inputList) {
        Map<String, List<Input>> map1 = new HashMap<>();
        for (Input input1 : inputList) {
            map1.computeIfAbsent(input1.getValue(), k -> new ArrayList<>()).add(input1);
        }


        inputList = map1.entrySet().stream().map(entry -> new Input(entry.getKey(), entry.getValue().size())).collect(Collectors.toList());
        return inputList;
    }

    private List<Input> initInputWord(String[] arr) {
        List<Input> inputList = new ArrayList<>();
        for (String s : arr) {
            Input input = new Input(s, 1);
            inputList.add(input);
        }
        return inputList;
    }

}
