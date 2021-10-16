package Ejercicio5;
import java.io.*;
import java.util.Scanner;

public class Adder {
    public static void main(String[] args) {
        String fichero = args[0];
        Scanner sc=null;
        int sumaTotal = 0;
        try {
            sc = new Scanner(new BufferedReader(new FileReader(fichero)));

            while (sc.hasNext()){
                if (sc.hasNextInt())
                    sumaTotal += sc.nextInt();
                else
                    sc.next();
            }
            System.out.println(sumaTotal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            sc.close();
        }
    }
}
