
import java.util.ArrayList;
import java.util.Scanner;

class Empleado {
    private static int contadorEmpleados = 0;

    private int Cc;
    private String nombre;
    private double sueldo;

    // Constructor
    public Empleado(String nombre, double sueldo) {
        this.Cc = ++contadorEmpleados; // Se incrementa el contador al crear un nuevo empleado
        this.nombre = nombre;
        this.sueldo = sueldo;
    }

    // Metodo para obtener información del empleado
    public String obtenerInfo() {
        return "C.c: " + Cc + ", Nombre: " + nombre + ", Sueldo: $" + sueldo;
    }

    // Metodo estático para obtener el total de empleados creados
    public static int obtenerTotalEmpleados() {
        return contadorEmpleados;
    }
}

// Clase Empresa para manejar empleados
class Empresa {
    private ArrayList<Empleado> listaEmpleados;

    public Empresa() {
        this.listaEmpleados = new ArrayList<>();
    }

    // Metodo para agregar empleados
    public void agregarEmpleado(String nombre, double sueldo) {
        Empleado nuevoEmpleado = new Empleado(nombre, sueldo);
        listaEmpleados.add(nuevoEmpleado);
        System.out.println(" Empleado agregado con exito.");
    }

    // Metodo para mostrar los empleados registrados
    public void mostrarEmpleados() {
        if (listaEmpleados.isEmpty()) {
            System.out.println(" No hay empleados registrados.");
        } else {
            System.out.println("\nLista de empleados:");
            for (Empleado e : listaEmpleados) {
                System.out.println(e.obtenerInfo());
            }
        }
    }

    // Metodo para mostrar el total de empleados creados
    public void mostrarTotalEmpleados() {
        System.out.println(" Total de empleados creados: " + Empleado.obtenerTotalEmpleados());
    }
}

// Clase principal con menú interactivo
public class Gestion {
    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        Scanner scanner = new Scanner(System.in);

        int opcion;

        do {
            System.out.println("\n MENÚ DE GESTIÓN DE EMPLEADOS ");
            System.out.println("1 Agregar empleado");
            System.out.println("2️ Mostrar empleados");
            System.out.println("3️ Mostrar total de empleados");
            System.out.println("4️ Salir");
            System.out.print(" Elige una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    System.out.print(" Ingresa el nombre del empleado: ");
                    String nombre = scanner.nextLine();
                    System.out.print(" Ingresa el sueldo del empleado: ");
                    double sueldo = scanner.nextDouble();
                    empresa.agregarEmpleado(nombre, sueldo);
                    break;

                case 2:
                    empresa.mostrarEmpleados();
                    break;

                case 3:
                    empresa.mostrarTotalEmpleados();
                    break;

                case 4:
                    System.out.println(" Saliendo del programa...");
                    break;

                default:
                    System.out.println(" Opcion invalida, intenta de nuevo.");
            }
        } while (opcion != 4);

        scanner.close();
    }
}
