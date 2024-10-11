import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculo {
    double valorAConvertir = 0;
    double valorFinal = 0;
    boolean okValidacion = false;
    boolean okEntrada = false;
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

    public void hacerCalculoEntrada(){
        String codigoBase = "";
        String codigoDestino = "";
        do{
            System.out.println("Ingrese la moneda base: ");
            codigoBase = lectura.nextLine();
            System.out.println("Ingrese la moneda destino: ");
            codigoDestino = lectura.nextLine();

            if(validarCodigoEntrada(codigoBase, codigoDestino)){
                hacerCalculo(codigoBase, codigoDestino);
                okEntrada = false;
            }else{
                System.out.println("Debe ingresar codigos válidos.\n");
                okEntrada = true;
            }

        }while(okEntrada == true);
    }

    public double validarValorAConvertir() {
        double valor = 0;
        do {
            do {
                try {
                    okValidacion = false;
                    System.out.println("Ingresa el valor que deseas convertir: ");
                    valor = lectura.nextDouble();
//                    lectura.nextLine();
                } catch (InputMismatchException ime) {
                    System.out.println("Debe ingresar solo números.");
                    okValidacion = true;
                }
            } while (okValidacion == true);
            if(valor < 0){
                System.out.println("Debe ingresar valores positivos.");
            }
        }while (valor < 0);
        lectura.nextLine();
        return valor;
    }

    public boolean validarCodigoEntrada(String codigoBase, String codigoDestino){
        codigoBase = codigoBase.trim();
        codigoDestino = codigoDestino.trim();

        if((codigoBase == null || codigoBase.equals("") || codigoBase.length() != 3) || (codigoDestino == null || codigoDestino.equals("") || codigoDestino.length() != 3)) {
            return false;
        }

        if(!codigoBase.toUpperCase().matches("[A-Z]*") || !codigoDestino.toUpperCase().matches("[A-Z]*")){
            return false;
        }

        return true;
    }
}
