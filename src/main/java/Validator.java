import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Validator {

    private static int size;

    public static int[][] validation(String name) {
        String str;
        char[] strArray;
        int i = 0;
        int j = 0;
        int[][] map = null;
        File file = new File(name);

        try (Scanner scanner = new Scanner(file)) {
//            scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                strArray = str.toCharArray();
                if (strArray[0] == '#') {
                    continue;
                } else if (strArray.length == 1) {
//                System.out.println(Integer.parseInt(str));
                    size = Integer.parseInt(str);
//                System.out.println(size);
                    if (size < 2) {
                        System.exit(-1);
                    }
                    break;
                }
            }

            map = new int[size][size];
            int[] tmp = new int[size];
            String[] stringNumers;
            while (scanner.hasNextLine()) {
                i = 0;
                str = scanner.nextLine();
                strArray = str.toCharArray();
                checkNumbers(strArray);
                stringNumers = str.split(" ");
                for (String number : stringNumers) {
                    tmp[i] = Integer.parseInt(number);
                    map[j][i] = tmp[i];
                    i++;
                }
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
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
                   // System.exit(-1);
                } else {
                    continue;
                }
            }
        }
    }

    private static void solutionsExist(int[][] map) {
        int i = 0;
        int j;
        int k;
        int s = 0;
        int f = 0;
        int num;
        while (s * f != (size - 1) * (size - 1)) {
            if (s == size) {
                f++;
                s = 0;
            }
            num = map[f][s];
            j = f;
            while (j < map.length) {
                k = s + 1;
                while (k < map[j].length) {
                    if (num > map[j][k] && map[j][k] != 0) {
                        i++;
                    }
                    k++;
                }
                j++;
            }
            s++;
        }
        if (i % 2 == 1) {
            System.out.println(i);
            System.exit(-1);
        }
    }
}