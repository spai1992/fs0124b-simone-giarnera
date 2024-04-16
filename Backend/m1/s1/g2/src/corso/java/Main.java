package corso.java;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String testString = "Prova";
        int anno = 2024;

        System.out.println("Lunghezza pari?" + stringsPariDispari(testString));
        System.out.println("L'anno" + anno + "è bisestile?" + annoBisestile(anno) );
    }

    public static boolean stringsPariDispari (String str ){
        return str.length() % 2 == 0;
    }

    public static boolean annoBisestile (int year) {

        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {


            return true;

        }

        else {

        return false;
        }
}

    }
