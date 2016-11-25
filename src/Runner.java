import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Runner {
    public static void main(String[] args) throws IOException {
        File file = new File("src//input.txt");
        Scanner in = new Scanner(file);

        ArrayList<String> numericWords = new ArrayList<>();
        ArrayList<String> simpleWords = new ArrayList<>();

        while (in.hasNextLine()) {
            ArrayList<String> tokens = Utils.getTokens(in.nextLine());
            System.out.println(tokens);
            for (int i = 0; i < tokens.size(); i++) {
                if (Utils.isNumericWord(tokens.get(i)))
                    numericWords.add(tokens.get(i));
                else if (Utils.isSimpleWord(tokens.get(i)))
                    simpleWords.add(tokens.get(i));
            }

        }

        System.out.println("Количество цифровых лексем:" + numericWords.size());
        System.out.println("Количество буквенных лексем:" + simpleWords.size());

        numericWords.sort(Utils.compByLetters);
        simpleWords.sort(Utils.compByLetters);

        Utils.createFileFromArrayList("src//output1.txt", numericWords);
        Utils.createFileFromArrayList("src//output2.txt", simpleWords);
    }
}
