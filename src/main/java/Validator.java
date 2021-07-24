import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Validator {

    private static int size;

    public static ArrayList<Integer> validation(String name) {
        String str;
        char[] strArray;
        size = 0;
        int i = 0;
        ArrayList<Integer> map = new ArrayList<Integer>();
        File file = new File("test.txt");

        Scanner scanner = null;
        try {
            scanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            strArray = str.toCharArray();
            if (strArray[0] == '#') {

            } else if (strArray.length == 1) {
                if (size != 0) {
                    System.exit(-1);
                }
                if ((size = Integer.getInteger(str)) < 2) {
                    System.exit(-1);
                }
                break;
            }
        }
        int[] tmp = new int[size];
        String[] stringNumers;
        while (scanner.hasNextLine()) {
            i = 0;
            str = scanner.nextLine();
            strArray = str.toCharArray();
            checkNumbers(strArray);
            stringNumers = str.split(" ");
            for (String number : stringNumers) {
                tmp[i++] = Integer.getInteger(number);
                map.add(tmp[i]);
            }
        }
        solutionsExist(map);
        return map;
    }
    //todo дописать проверки с пробелом
    private static void checkNumbers(char[] charStr) {
        for (int i = 0; i < charStr.length; i++) {
            if ('0' < charStr[i] && charStr[i] < '9') {
                continue;
            } else if (charStr[i] == ' ') {
                continue;
            } else if (charStr[i] == '#') {
                if (i < size * 2 - 1) {
                    System.exit(-1);
                } else {
                    continue;
                }
            }
        }
    }

    private static void solutionsExist(ArrayList<Integer> map) {
        int i = 0;
        Integer num;
        for (int j = 0; j < map.size(); j++) {
            num = map.get(j);
            for (int k = j + 1; k < map.size(); k++) {
                if (num > map.get(k)) {
                    i++;
                }
            }
        }
        if (i % 2 == 1) {
            System.exit(-1);
        }
    }
}