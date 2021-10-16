package Ejercicio4;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Translator {

    private static HashMap<String, String> interno = new HashMap<>();
    private static HashMap<String, String> dict = new HashMap<>();
    private static List<String> argumentos;

    public static void main(String args[]){
        crearDiccionarioInterno(interno);
        argumentos = Arrays.asList(args);
        if (argumentos.contains("op1")){
            try {
                leerDiccionarioHijo();
                usarInterno();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(argumentos.contains("op2")){
            try {
                leerDiccionarioHijo();
                usarNuevo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(argumentos.contains("op3")){
            usarInterno();
        }else if(argumentos.contains("op4")){
            try {
                leerDiccionarioHijo();
                usarNuevo();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void usarInterno(){
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        while (!cadena.equals("close")){
            cadena = sc.nextLine();
            if (interno.containsKey(cadena)){
                System.out.println(interno.get(cadena));
            }else{
                System.out.println("desconocido");
            }
        }
    }

    private static void usarNuevo(){
        Scanner sc = new Scanner(System.in);
        String cadena = "";
        while (!cadena.equals("close")){
            cadena = sc.nextLine();
            if (dict.containsKey(cadena)){
                System.out.println(dict.get(cadena));
            }else{
                System.out.println("desconocido");
            }
        }
    }

    private static void leerDiccionarioHijo() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(argumentos.get(1)))){
            String linea = br.readLine();
            while (linea != null){
                String cadenas[] = linea.split(";");
                dict.put(cadenas[0],cadenas[1]);
                linea = br.readLine();
            }
        }
    }

    private static void crearDiccionarioInterno(HashMap interno){
        interno.put("casa","house");
        interno.put("coche","car");
        interno.put("techo","roof");
        interno.put("galleta","cookie");
        interno.put("perro","dog");
        interno.put("gato","gato");
        interno.put("lampara","lamp");
        interno.put("teclado","keyboard");
        interno.put("botella","bottle");
        interno.put("reloj","clock");
    }
}
