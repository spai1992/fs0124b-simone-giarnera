package corso.java2;

import java.util.Scanner;


public class Main {


    public static void main(String[] args) {

        String[] str = {"zero","uno","due","tre"};
        System.out.println("Inserisci un numero compreso tra 0 e 3:  ");
        int numero = new Scanner(System.in).nextInt();
        switch (numero){
            case 0:
                System.out.println(str[0]);
                break;
                case 1:
                    System.out.println(str[1]);
                    break;
                    case 2:
                        System.out.println(str[2]);
                        break;
                        case 3:
                            System.out.println(str[3]);
            default:
                throw new IllegalStateException("invalid number" + numero);
        }
    }

}
