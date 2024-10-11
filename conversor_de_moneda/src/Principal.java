
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        int opcion = 0;
        boolean okBandera = false;
        Scanner lectura = new Scanner(System.in);
        Calculo conversion = new Calculo();

        String menu = """
                        ***************************************************************
                        Sea bienvenido/a al Conversor de Moneda
                        1) Dólar =>> Peso argentino
                        2) Peso argentino =>> Dólar
                        3) Dólar =>> Real brasileño
                        4) Real brasileño =>> Dólar
                        5) Dólar =>> Peso colombiano
                        6) Peso colombiano =>> Dólar
                        7) Salir
                        Elija una opción válida:
                        ***************************************************************
                        """;
        do{
            do{
                try {
                    okBandera = false;
                    System.out.println(menu);
                    opcion = lectura.nextInt();
                }catch (InputMismatchException ime){
                    System.out.println("Opción no válida.\n");
                    okBandera = true;
                    lectura.nextLine();
                }
            }while (okBandera == true);

            switch (opcion){
                case 1:
                    conversion.hacerCalculo("USD", "ARS");
                    break;
                case 2:
                    conversion.hacerCalculo("ARS", "USD");
                    break;
                case 3:
                    conversion.hacerCalculo("USD", "BRL");
                    break;
                case 4:
                    conversion.hacerCalculo("BRL", "USD");
                    break;
                case 5:
                    conversion.hacerCalculo("USD", "COP");
                    break;
                case 6:
                    conversion.hacerCalculo("COP", "USD");
                    break;
                case 7:
                    System.out.println("Fin de la aplicación...");
                    break;
                default:
                    System.out.println("Elija una opción del menú...\n");
            }
        }while (opcion != 7);







//        Scanner lectura = new Scanner(System.in);
//        ConsultaMoneda consulta = new ConsultaMoneda();
//        String codigoBase;
//        String codigoDestino;
//
//        //Prueba de conexión
//        try{
//            System.out.println("Moneda base: ");
//            codigoBase = lectura.nextLine();
//            System.out.println("Moneda destino: ");
//            codigoDestino = lectura.nextLine();
//
//            Moneda moneda = consulta.hacerConsulta(codigoBase, codigoDestino);
//            System.out.println(moneda);
//
//        }catch (RuntimeException e){
//            System.out.println(e.getMessage());
//            System.out.println("Finalizando aplicación");
//        }






    }


}
