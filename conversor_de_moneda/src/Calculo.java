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

    public void hacerCalculo(String base, String destino){ // Realiza cálculo de la conversión
        moneda = consulta.hacerConsulta(base, destino);

        if(moneda.base_code() != null && moneda.target_code() != null){
            valorAConvertir = validarValorAConvertir();
            valorFinal = valorAConvertir * moneda.conversion_rate();
            System.out.println("El valor de " + valorAConvertir +" [" + moneda.base_code() + "] corresponde al valor final de =>> " +
                    valorFinal + " [" + moneda.target_code() + "]\n");
        }
        else{
            System.out.println("No existen datos sobre las monedas solicitadas.");
        }

    }

    public void hacerCalculoEntrada(){ //Solicita datos al usuario para realizar conversión personalizada
        String codigoBase = "";
        String codigoDestino = "";
        do{
            System.out.println("Ingrese el código de la moneda base: ");
            codigoBase = lectura.nextLine();
            System.out.println("Ingrese el código de la moneda destino: ");
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

    public double validarValorAConvertir() { // Verifica el tipo de entrada
        double valor = 0;
        do {
            do {
                try {
                    okValidacion = false;
                    System.out.println("Ingresa el valor que deseas convertir: ");
                    valor = lectura.nextDouble();
                    lectura.nextLine();
                } catch (InputMismatchException ime) {
                    System.out.println("Debe ingresar solo números.");
                    okValidacion = true;
                    lectura.nextLine();
                }
            } while (okValidacion == true);
            if(valor < 0){
                System.out.println("Debe ingresar valores positivos.");
            }
        }while (valor < 0);
        return valor;
    }

    public boolean validarCodigoEntrada(String codigoBase, String codigoDestino){ //Verifica el código ingresado por el usuario
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
