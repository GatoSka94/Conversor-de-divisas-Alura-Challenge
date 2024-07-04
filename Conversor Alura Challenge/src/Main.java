import javax.swing.*;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        int opcion=1;
        Scanner entrada = new Scanner(System.in);

        while (opcion!=0) {
            String moneda_base="";
            String moneda_target="";
            ConsultarConversion conversion = new ConsultarConversion();
            int ciclo=0;

            try {
                while (ciclo<=0) {

                    System.out.println("Digite el tipo de moneda que tenga para hacer la conversion\n" +
                            "(MXN) Peso Mexicano\n" +
                            "(ARS) Peso Argentino\n" +
                            "(COP) Peso Colombiano\n" +
                            "(BRL) Real Brasileño\n" +
                            "(USD) Dolares");
                    moneda_base = entrada.nextLine();
                    if (moneda_base.matches("[a-zA-Z]{3}")) {
                        ciclo =1;

                    } else {
                        System.out.println("Moneda inválida: "+moneda_base+" La moneda debe contener exactamente 3 letras y no puede ser " +
                                "ningun numero.");

                    }
                }
                ciclo=0;
                while (ciclo <=0){
                    System.out.println("Digite el tipo de moneda a la que hara la conversión\n" +
                            "(MXN) Peso Mexicano\n" +
                            "(ARS) Peso Argentino\n" +
                            "(COP) Peso Colombiano\n" +
                            "(BRL) Real Brasileño\n" +
                            "(USD) Dolares");
                    moneda_target = entrada.nextLine();
                    if (moneda_target.matches("[a-zA-Z]{3}")) {
                        ciclo=1;

                    } else {
                        System.out.println("Moneda inválida: "+moneda_target+" La moneda debe contener exactamente 3 letras y no puede ser " +
                                "ningun numero.");

                    }
                }
                    double dinero=0;

                    while (dinero<=0) {
                        System.out.println("Digite la cantidad de dinero a convertir");
                        dinero = entrada.nextDouble();
                        if (dinero < 0) {
                            System.out.println("No se puede hacer una conversión de numeros negativos");


                        }
                    }
                Dinero dinero1 = conversion.hacercoonversion(moneda_base,moneda_target,dinero);

                System.out.println("$"+dinero+""+moneda_base+" a "+moneda_target+" es:$"+dinero1+moneda_target);
                GenerarArchivoJson generar = new GenerarArchivoJson();

                generar.generarJson(dinero1);
                System.out.println("Digite 0 para salir o 1 para continuar:");
                if (entrada.hasNextInt()) {
                    opcion = entrada.nextInt();
                } else {
                    System.out.println("Entrada inválida. Saliendo del programa.");
                    opcion = 0;
                }
                entrada.nextLine(); // Limpiar el buffer después de leer un entero
            }catch (Exception e){

                System.out.println("Error: "+e.getMessage());
                break;


            }
            if(opcion ==0){

                System.out.println("Programa Finalizado");
                break;
            }
        }
        entrada.close();
    }
}