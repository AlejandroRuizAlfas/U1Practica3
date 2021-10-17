package Ejercicio5;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex5_Accounter {

    private static ArrayList<Integer> resultados = new ArrayList<>();

    public static void main(String[] args){
        /*Comprueba si hay argumentos. Si los hay, procede con la ejecución,en caso contrario, para el programa y avisa al usuario*/
        if (args.length <= 0){
            System.err.println("No hay argumentos. Pasa los ficheros con numeros a través de los argumentos en el comando");
            System.exit(-1);
        }else{
            /*Por cada fichero que se pasa por parámetro, se crea un nuevo proceso hijo que calcule la suma de los numeros*/
            for (int i=0;i< args.length;i++){
                procesoFichero(args[i]);
            }
            /*Crea el fichero totals.txt dodne se almacenan los resultados  y se recorre el array de reusltados para serializar cada resultado
            dentro del fichero*/
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("totals.txt"))){
                for (int i=0;i<resultados.size();i++){
                    bw.write("El resultado del fichero "+args[i]+" ha sido: "+resultados.get(i));
                    bw.newLine();
                }
                /*Se crea una variable sumaFinal que guardará el valor de todas las sumas de ficheros juntas y lo serializará en la última linea de totals.txt*/
                int sumaFinal=0;
                for (int num: resultados){
                    sumaFinal+=num;
                }
                bw.write("La suma total de todos los ficheros es "+sumaFinal);
                System.out.println("Todos los resultados han sido guardados correctamente en el fichero totals.txt");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /*Es el metodo escargado de crear el proceso hijo, pasarle a través de argumentos el fichero con los numeros y obtiene el resultado de la suma
    y lo guarda en una ArrayList de enteros llamada reusltados, para luego sumar todas las sumas de cada fichero individual */
    private static void procesoFichero(String fichero){
        String command = "java -jar out/artifacts/Adder_jar/U1Practica3.jar "+fichero;
        ProcessBuilder pb = new ProcessBuilder(command.split(" "));
        try {
            Process process = pb.start();
            pb.inheritIO();
            Scanner procesoSC = new Scanner(process.getInputStream());
            resultados.add(Integer.parseInt(procesoSC.nextLine()));
        } catch (IOException ex) {
            ex.getMessage();
        }
    }
}
