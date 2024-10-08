
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner lectura = new Scanner(System.in);
        ConsultaMoneda consulta = new ConsultaMoneda();
        String codigoBase;
        String codigoDestino;

        //Prueba de conexión
        try{
            System.out.println("Moneda base: ");
            codigoBase = lectura.nextLine();
            System.out.println("Moneda destino: ");
            codigoDestino = lectura.nextLine();

            Moneda moneda = consulta.hacerConsulta(codigoBase, codigoDestino);
            System.out.println(moneda);

        }catch (RuntimeException e){
            System.out.println(e.getMessage());
            System.out.println("Finalizando aplicación");
        }



    }
}
