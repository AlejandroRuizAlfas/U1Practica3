package Ejercicio4;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        searchArgs(args);
    }

    /*El metodo searchArgs() se encargará de leer los argumentos que se le pasan, y dependiendo
    de los argumentos que haya, escogerá un camino u otro y ejecutara uno de los 4 casos posibles*/
    public static void searchArgs(String[] args) {
        List<String> argumentos = Arrays.asList(args);
        if (argumentos.size() == 0) {
            System.out.println("Caso1");
            caso1();
        } else if (argumentos.contains("-d") && argumentos.contains("-f")) {
            System.out.println("Caso4");
            caso4(argumentos.get(1));
        } else if (argumentos.contains("-f")) {
            System.out.println("Caso3");
            caso3();
        } else if (argumentos.contains("-d")) {
            System.out.println("Caso2");
            caso2(argumentos.get(1));
        }
    }

    /*Si el metodo searchArgs detecta que se va a ejecutar el caso1, este método creará un proceso hijo el cual recibirá las palabras del padre*/
    private static void caso1() {
        String command = "java -jar out/artifacts/Translator_jar/U1Practica3.jar op1";
        crearProcesos1(command);
    }

    /*Si el metodo searchArgs detecta que se va a ejecutar el caso2, este método creará un proceso hijo el cual recibirá las palabras del padre
     y le enviará al hijo su fichero de diccionario*/
    private static void caso2(String fichero) {
        String command = "java -jar out/artifacts/Translator_jar/U1Practica3.jar op2 " + fichero;
        crearProcesos1(command);
    }

    /*Si el metodo searchArgs detecta que se va a ejecutar el caso3, este método creará un proceso hijo*/
    private static void caso3() {
        String command = "java -jar out/artifacts/Translator_jar/U1Practica3.jar op3";
        crearProcesos2(command);
    }

    /*Si el metodo searchArgs detecta que se va a ejecutar el caso2, este método creará un proceso hijo
     y le enviará al hijo su fichero de diccionario*/
    private static void caso4(String fichero) {
        String command = "java -jar out/artifacts/Translator_jar/U1Practica3.jar op4 " + fichero;
        crearProcesos2(command);
    }

    /*La primera variante de creación de hijo permite crear un proceso hijo, en el cual el padre empezará a pedirle palabras al usuario
    hasta que este escriba la palabra "close". Las palabras se enviarán al hijo y este se encargará de traducirlas.*/
    private static void crearProcesos1(String command) {
        ProcessBuilder pb = new ProcessBuilder(command.split(" "));
        try {
            /*Inicia el proceso y pepara el I/O entre el padre y el hijo*/
            Process process = pb.start();
            OutputStream os = process.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);

            /*Le pide al usuario palabras y se las envia al proceso hijo para que las tradusca. Imprime lo que devuelve el hijo*/
            Scanner scHijo = new Scanner(process.getInputStream());
            Scanner sc = new Scanner(System.in);
            String linea = sc.nextLine();
            while (!linea.equals("close")) {
                bw.write(linea);
                bw.newLine();
                bw.flush();
                System.out.println(scHijo.nextLine());
                linea = sc.nextLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /*La primera variante de creación de hijo es parecida a la anterior, pero en este caso el padre no va a pedir palabras al usuario, si no que las palabras vendrán escritas
    * en un fichero de texto que recibe de los argumentos, por lo que esta forma de creación es diferente a la anterior*/
    private static void crearProcesos2(String command) {
        ProcessBuilder pb = new ProcessBuilder(command.split(" "));
        try {
            /*Inicia el proceso y pepara el I/O entre el padre y el hijo*/
            Process process = pb.start();
            OutputStream os = process.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            Scanner scHijo = new Scanner(process.getInputStream());

            /*El padre coge las palabras que hay en el archivo y se las pasa al hijo para que este las traduzca e imprime lo que le ha devuelto el hijo*/
            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String linea = br.readLine();
            while (linea != null) {
                bw.write(linea);
                bw.newLine();
                bw.flush();
                System.out.println(scHijo.nextLine());
                linea = br.readLine();
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
