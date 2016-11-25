import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.regex.Pattern;

public class Utils {


    public static ArrayList<String> getTokens(String input) {
        String[] divided = input.split("[ .,]");
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < divided.length; i++) {
            if (!Objects.equals(divided[i], ""))
                words.add(divided[i]);
        }

        return words;

    }


    public static void createFileFromArrayList(String path, ArrayList<String> data) throws IOException {
        try {
            File newFile = new File(path);
            newFile.getParentFile().mkdirs();
            newFile.createNewFile();
            FileWriter out = new FileWriter(newFile);
            for (int i = 0; i < data.size(); i++) {
                out.write(data.get(i));
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

