package Ejercicio5;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Ex5_Accounter {

    private static ArrayList<Integer> resultados = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        if (args.length <= 0){
            System.err.println("No hay argumentos. Pasa los ficheros con numeros a través de los argumentos en el comando");
            System.exit(-1);
        }else{
            for (int i=0;i< args.length;i++){
                procesoFichero(args[i]);
            }
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("totals.txt"))){
                for (int i=0;i<resultados.size();i++){
                    bw.write("El resultado del fichero "+args[i]+" ha sido: "+resultados.get(i));
                    bw.newLine();
                }
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

    private static void procesoFichero(String fichero){
        String command = "java -jar out/artifacts/Adder_jar/Act3.jar "+fichero;
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
