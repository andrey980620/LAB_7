import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Utils {

    public static void fill(Scanner in, ArrayList<String>  num,ArrayList<String>  alph){
        while (in.hasNextLine()) {
            ArrayList<String> tokens = Utils.getTokens(in.nextLine());
            System.out.println(tokens);
            for (String token : tokens) {
                if (Utils.isNumericWord(token))
                    num.add(token);
                else if (Utils.isSimpleWord(token))
                    alph.add(token);
            }
        }
    }



    public static ArrayList<String> getTokens(String input) {
        String[] divided = input.split("[ .,]");
        ArrayList<String> words = new ArrayList<>();
        for (String unit : divided) {
            if (!Objects.equals(unit, ""))
                words.add(unit);
        }

        return words;

    }

    public static void createFileFromArrayList(String path, ArrayList<String> data) throws IOException {
        try {
            File newFile = new File(path);
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();
            FileWriter out = new FileWriter(newFile);
            for (String unit : data) {
                out.write(unit);
                out.write("\r\n");
            }
            out.close();
        } catch (IOException e) {
            System.out.println("\n!!! Unable to  create a file with path:  " + path);
        }
    }

    public static boolean isNumericWord(String path) {
        Pattern pattern = Pattern.compile("[0-9]+");
        return path.matches(pattern.pattern());
    }
    public static boolean isSimpleWord(String path) {
        Pattern pattern = Pattern.compile("[^0-9]+");
        return path.matches(pattern.pattern());
    }

    public static Comparator<String> compByLetters = (o1, o2) -> o1.compareTo(o2);

}

