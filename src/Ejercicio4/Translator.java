package Ejercicio4;
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Translator {
    /*Se crean los HashMaps que almacenaran las palabras y sus traducciones*/
    private static HashMap<String, String> interno = new HashMap<>();
    private static HashMap<String, String> dict = new HashMap<>();

    private static List<String> argumentos;

    /*En el método main se detectará que caso de ejcución debe ocurrir y se llamara a uno de los dos métodos disponibles
    para leer las palabras o bien de la entrada del padre o bien del fichero que pasa el padre*/
    public static void main(String args[]){
        crearDiccionarioInterno(interno); //Invoca el metodo para crear el diccionario interno por si es necesario usarlo
        argumentos = Arrays.asList(args);
        if (argumentos.contains("op1")){
            usarInterno();
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
    /*El metodo usarInterno se usará en los casos 1 y 3, en los cuales el hijo debe usar el diccionario interno creado anteiormente para
    traducir las palabras que le lleguen del padre. Si la palabra está en el diccionario interno, devolverá la traducción, si no devolvera desconocido*/
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

    /*El metodo usarNuevo se usará en los casos 2 y 4, en los cuales el hijo debe usar el fichero que le pasan para traducir las palabras que le envia el
    proceso padre. Si la palabra está en el fichero de diccionario, devolverá la traducción, si no devolvera desconocido*/
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
    /*Método que se encarga de leer el fichero que le pasa el padre y lo adapta para transformarlo en HashMap y trabajar con las palabras
    de su interior*/
    private static void leerDiccionarioHijo() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(argumentos.get(1)))){
            String linea = br.readLine();
            while (linea != null){
                /*Usando split se separan las palabras originales de su traducción usando como referencia el símbolo ";"*/
                String cadenas[] = linea.split(";");
                dict.put(cadenas[0],cadenas[1]);
                linea = br.readLine();
            }
        }
    }

    /*Crea las palabras y sus traducciones del diccionario interno. Este se usará en los casos 1 y 3 para intentar traducir las palabras que vengan del proceso padre*/
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
