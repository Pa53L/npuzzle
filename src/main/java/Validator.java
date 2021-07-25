import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Validator {

    private static int size;

    public static int[][] validation(String name) {
        String str;
        char[] strArray;
        int j = 0;
        int[][] map = null;
        File file = new File(name);
        int cur;

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                strArray = str.toCharArray();
                cur = normalSize(strArray);
                if (cur == 1) {
                    size = Integer.parseInt(str);
                    if (size < 2) {
                        System.exit(-1);
                    }
                    break;
                } else if (cur == 2) {
                    System.exit(-1);
                }
            }
            map = new int[size][size];
            int[] tmp = new int[size];
            String[] stringNumbers;
            while (scanner.hasNextLine()) {
                str = scanner.nextLine();
                strArray = str.toCharArray();
                cur = parsingTable(strArray);
                if (cur == 1) {
                    stringNumbers = str.split(" ", size + 1);
                    for (int i = 0; i < size; i++) {
                        tmp[i] = Integer.parseInt(stringNumbers[i]);
                        map[j][i] = tmp[i];
                    }
                } else if (cur == 2) {
                    System.exit(-1);
                }
                j++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        solutionsExist(map);
        return map;
    }

    //todo этот метод какая-то хуета, писал под пивасом, в понедельник разобраться
    private static int parsingTable(char[] str) {
//        System.out.println(str);
        int len = str.length;
        int countNum = 0;

        if (str[0] == '#') {
            return 0;
        }
//        System.out.println(len);
        for (int i = 0; i < len; i++) {
            System.out.println("1 " + str[i]);
            while(isNumber(str[i]) && i < len - 1) {
                System.out.println("2 " + str[i]);
                i++;
            }
            countNum++;
            if (str[i] == ' ') {
                i++;
            } else if (str[i] == '#' && countNum == size) {
                return 1;
            } else {
                return 2;
            }
        }
        return 1;
    }

    private static int normalSize(char[] str) {
        int len = str.length;

        if (str[0] == '#') {
            return 0;
        } else if (isNumber(str[0])) {
            for (int i = 1; i < len; i++) {
                if (str[i] == ' ') {
                    continue;
                } else if (str[i] == '#') {
                    return 1;
                } else {
                    return 2;
                }
            }
        }
        return 1;
    }

    private static boolean isNumber(char c) {
        return c >= '0' && c <= '9';
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
                    if (num == map[j][k] || map[j][k] >= size * size || map[j][k] < 0) {
                        System.exit(2);
                    }
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
            System.exit(-1);
        }
    }
}