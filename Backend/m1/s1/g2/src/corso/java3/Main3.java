package corso.java3;

import java.util.Scanner;

public class Main3 {

public static void main(String[] args) {

String input = "";

Scanner sc = new Scanner(System.in);
do {
    System.out.println("Inserisci una stringa");
    input = sc.nextLine();
    String[] words = input.split("");
    System.out.println(String.join(",", words));
}while (!input.equals(":q"));
sc.close();



}


}
