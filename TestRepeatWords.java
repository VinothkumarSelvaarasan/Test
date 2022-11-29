import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class TestRepeatWords {
    public static void main(String[] args) {
        Map<String, Integer> map = new LinkedHashMap<String, Integer>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            String currentLine = reader.readLine();
            while (currentLine!= null) {
                String[] input = currentLine.replaceAll("[^a-zA-Z]", " ").toLowerCase().split(" ");
                for (int i = 0; i < input.length; i++) {
                    if (map.containsKey(input[i])) {
                        int count = map.get(input[i]);
                        map.put(input[i], count + 1);
                    } else {
                        map.put(input[i], 1);
                    }
                }
                currentLine = reader.readLine();
            }
            String mostRepeatedWord = null;
            int count = 0;
            for (Map.Entry<String, Integer> m:map.entrySet())
            {
                if(m.getValue() > count)
                {
                    mostRepeatedWord = m.getKey();

                    count = m.getValue();
                }
            }
            System.out.println("The most repeated word in input file is : "+mostRepeatedWord);
            System.out.println("Number Of Occurrences : "+count);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}