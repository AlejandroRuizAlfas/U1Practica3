package Ejercicio4;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        HashMap<String, String> interno = new HashMap<String, String>();
        searchArgs(args);
    }

    public static void searchArgs(String [] args){
        List<String> argumentos = Arrays.asList(args);
        if (argumentos.size() == 0){
            System.out.println("Caso1");
            caso1();
        }else if (argumentos.contains("-d") && argumentos.contains("-f")){
            System.out.println("Caso4");
            caso4(argumentos.get(1));
        }else if (argumentos.contains("-f")){
            System.out.println("Caso3");
            caso3();
        }else if (argumentos.contains("-d")){
            System.out.println("Caso2");
            caso2(argumentos.get(1));
        }
    }

    private static void caso1() {
        String command = "java -jar out/artifacts/Translator_jar/Act3.jar op1";
        crearProcesos1(command);
    }

    private static void caso2(String fichero) {
        String command = "java -jar out/artifacts/Translator_jar/Act3.jar op2 "+fichero;
        crearProcesos1(command);
    }

    private static void caso3() {
        String command = "java -jar out/artifacts/Translator_jar/Act3.jar op3";
        crearProcesos2(command);
    }

    private static void caso4(String fichero) {
        String command = "java -jar out/artifacts/Translator_jar/Act3.jar op4 "+fichero;
        crearProcesos2(command);
    }

    private static void crearProcesos1(String command){
        ProcessBuilder pb = new ProcessBuilder(command.split(" "));
        try {
            Process process = pb.start();
            OutputStream os = process.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            Scanner scHijo = new Scanner(process.getInputStream());

            Scanner sc = new Scanner(System.in);
            String linea = sc.nextLine();

            while( ! linea.equals("close")){
                bw.write(linea);
                bw.newLine();
                bw.flush();
                System.out.println(scHijo.nextLine());
                linea = sc.nextLine();
            }
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

    private static void crearProcesos2(String command){
        ProcessBuilder pb = new ProcessBuilder(command.split(" "));
        try {
            Process process = pb.start();
            OutputStream os = process.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(os);
            BufferedWriter bw = new BufferedWriter(osw);
            Scanner scHijo = new Scanner(process.getInputStream());

            BufferedReader br = new BufferedReader(new FileReader("file.txt"));
            String linea = br.readLine();
            while( linea != null){
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
