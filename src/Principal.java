import java.io.*;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException {
        Scanner lectura = new Scanner(System.in);
        int option = 0, choice1 = 0, choice2 = 0;
        String monedaBase = "";
        String monedaFinal = "";
        String respuesta, resultado;
        double monto = 0.0;
        DefinirMoneda definirMoneda = new DefinirMoneda();
        ConsumoDeAPI consumodeAPI = new ConsumoDeAPI();
        Resultados resultados = new Resultados();

        String monedas = """
                ************************ MONEDAS DISPONIBLES ************************
                
                    1) USD ---> Dólar estadounidense.
                    2) COP ---> Peso Colombiano.
                    3) ARS ---> Peso argentino.
                    4) BRL ---> Real brasilero
                    5) MXN ---> Peso mexicano.
                    6) CLP ---> Peso chileno.
                """;

        String menu = """
                ************************ CONVERSOR DE MONEDAS ************************
                
                    1) Convertir monedas
                    2) Mostrar historial de converción
                    3) Salir
                """;

        while(option!=3){
            System.out.println(menu);
            System.out.println("Por favor ingrese una opción: ");
            option = lectura.nextInt();
            switch (option){
                case 1:
                    System.out.println(monedas);
                    System.out.println("Ingrese la moneda base: ");
                    choice1 = lectura.nextInt();
                    System.out.println("Ingrese la moneda a convertir: ");
                    choice2 = lectura.nextInt();
                    System.out.println("Ingrese el monto a convertir");
                    monto = lectura.nextDouble();

                    monedaBase = definirMoneda.getMoneda(choice1);
                    monedaFinal = definirMoneda.getMoneda(choice2);

                    respuesta = consumodeAPI.obtenerURL(monedaBase, monedaFinal, monto);
                    //System.out.println(respuesta);
                    resultado = resultados.respuesta(respuesta);

                    System.out.println("El valor de "+ Double.toString(monto) +
                            " ("+monedaBase+") es de "+ resultado + " ("+monedaFinal+")");

                    BufferedWriter escritura = new BufferedWriter(new FileWriter("historial.txt", true));
                    escritura.write("El valor de "+ Double.toString(monto)+
                            " ("+monedaBase+") es de "+ resultado + " ("+monedaFinal+")\n");
                    escritura.close();
                    break;

                case 2:
                    System.out.println("*********** HISTORIAL DE CONVERSIONES ***********");
                    String path = "historial.txt";
                    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 3:
                    try (FileWriter fw = new FileWriter("historial.txt", false)) {
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Gracias por usar nuestro programa!!");
                    break;

                default:
                    System.out.println("Opción invalida, intente nuevamente");
                    break;
            }
        };

    }

}


