import java.util.*;

/*
    Zaimplementuj metodę Java - tokenGenerator().
    1. Liczba parametrów - dowolne
    2. Nazwa - tokenGenerator()
    3. Return - zwraca token
    4. token - to ciąg randomowych znaków [a-z][A-Z][0-9][!@#$%^&*()] - o dowolnej długości
    3  Metoda generuje 3 różne wersje tokenów w zależności od potrzeby usera:  5-znakowy, 10-znakowy oraz 15-znakowy

    Przykład tokena 5 znakowego - g4#2%
    Przykład tokena 10 znakowego - g4#2%hQQ5^
    Przykład tokena 15 znakowego - g4#2%hQQ5^YY5!2
     */

public class Main {
    public static List asciiChars = new ArrayList(); // declare List for all ASCII chars

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        /*
        ASCII codes:
        [a-z] 97-122
        [A-Z] 65-90
        [0-9] 48-57
        [!@#$%^&*()] 33,64,35,36,37,94,38,42,40,41
         */

        Collections.addAll(asciiChars, 33,64,35,36,37,94,38,42,40,41); // add [!@#$%^&*()]
        putRangeOfValuesToList(97, 122); // add [a-z]
        putRangeOfValuesToList(65, 90); // add [A-Z]
        putRangeOfValuesToList(48, 57); // add [0-9]

        System.out.println("Enter the length of the token? Choose length: 5, 10 or 15");

        int tokenLength = scanner.nextInt();
        getLengthToken(tokenLength);
    }

    public static void putRangeOfValuesToList(int start, int end) {
        for (int i = start; i <= end; i++) {
            asciiChars.add(i);
        }
    }

    public static void getLengthToken(int tokenLength) {
        switch (tokenLength) {
            case 5 :
            case 10 :
            case 15 :
                tokenGenerator(tokenLength);
                break;
            default :
                System.out.println("You should pass only 5, 10 or 15 as length of token");
        }
    }

    public static void tokenGenerator(int tokenLength) {
        List<Integer> token = new ArrayList<>();

        for (int i = 0; i < tokenLength; i++){
            token.add(getRandomNumber(asciiChars));
        }
        printToken(token);
    }

    public static Integer getRandomNumber(List<Integer> list) {
        Random rnd = new Random();
        return list.get(rnd.nextInt(list.size()));
    }

    public static void printToken(List<Integer> list) {
        List<String> printToken = new ArrayList<>();

        for (int el : list) {
            String elem = Character.toString((char) el);
            printToken.add(elem);
        }

        System.out.print("Token generated: " + printToken.toString()
                .replace(",", "")
                .replace(" ", "")
                .replace("[", "")
                .replace("]", ""));
    }
}
