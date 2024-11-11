import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {


        Scanner morseFile = new Scanner(new File("morse.txt"));

        ArrayList<Character> alphabet = new ArrayList<>();
        ArrayList<String> codes = new ArrayList<>();

        while(morseFile.hasNext()) {
            String line = morseFile.nextLine();
            String [] tokens = line.split("\t");
            alphabet.add(tokens[0].charAt(0));
            codes.add(tokens[1]);
        }
        morseFile.close();

        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter a string to convert to Morse code:");
        String input = scan.nextLine();
        String morse = convert(input, alphabet, codes);
        System.out.println(morse);
    }

    private static String convert(String input, ArrayList<Character> alphabet, ArrayList<String> codes) {
        StringBuilder res = new StringBuilder();

        for(int i = 0;  i < input.length(); i++){
            char c = input.charAt(i);
            int position = find(alphabet, c);
            if(position != -1){
                res.append(codes.get(position));
            } else {
                res.append('?');
            }
            res.append(' ');
        }
        return res.toString();
    }

    private static int find(ArrayList<Character> alphabet, char c) {
        boolean found = false;
        int position = -1;
        for(int i = 0; !found && i < alphabet.size(); i++){
            if(Character.toUpperCase(c) == Character.toUpperCase(alphabet.get(i))){
                position = i;
                found = true;
            }
        }
        return position;
    }

}