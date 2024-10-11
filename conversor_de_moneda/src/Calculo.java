import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculo {
    double valorAConvertir = 0;
    double valorFinal = 0;
    boolean okValidacion = false;
    Scanner lectura = new Scanner(System.in);
    ConsultaMoneda consulta = new ConsultaMoneda();
    Moneda moneda;

    public void hacerCalculo(String base, String destino){
        moneda = consulta.hacerConsulta(base, destino);
        valorAConvertir = validarValorAConvertir();
        valorFinal = valorAConvertir * moneda.conversion_rate();
        System.out.println("El valor de " + valorAConvertir +" [" + moneda.base_code() + "] corresponde al valor final de =>> " +
                valorFinal + " [" + moneda.target_code() + "]\n");
    }

    public double validarValorAConvertir() {
        double valor = 0;
        do {
            do {
                try {
                    okValidacion = false;
                    System.out.println("Ingresa el valor que deseas convertir: ");
                    valor = lectura.nextDouble();
                } catch (InputMismatchException ime) {
                    System.out.println("Debe ingresar solo números.");
                    okValidacion = true;
                    lectura.nextLine();
                }
            } while (okValidacion == true);
            if(valor < 0){
                System.out.println("Debe ingresar valores positivos..");
            }
        }while (valor < 0);
        return valor;
    }
}
