package Ejercicio5;
import java.io.*;
import java.util.Scanner;

public class Adder {
    public static void main(String[] args) {
        /*Se guarda el fichero que recieb como parámetro para luego acceder a el y leerlo*/
        String fichero = args[0];
        Scanner sc=null;
        int sumaTotal = 0;
        /*Se lee el contenido del fichero haciendo uso de un Scanner y un BufferedReader*/
        try {
            sc = new Scanner(new BufferedReader(new FileReader(fichero)));
            /*Mientras que hayas numeros dentro del fichero, se van sumando todos los numeros en la variable sumaTotal*/
            while (sc.hasNext()){
                if (sc.hasNextInt())
                    sumaTotal += sc.nextInt();
                else
                    sc.next();
            }
            /*El proceso hijo devuelve la variable sumaTotal al padre para que este la almacene en el ArrayList*/
            System.out.println(sumaTotal);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            /*Se cierra el fichero para escribir los datos y serializarlos*/
            sc.close();
        }
    }
}
