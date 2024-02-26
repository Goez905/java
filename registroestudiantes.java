import java.util.Scanner;
import java.util.ArrayList;

public class registroestudiantes {
    // Definición de la clase Estudiante
    static class Estudiante {
        private int id;
        private String nombre;
        private String email;
        // Constructor de la clase Estudiante
        public Estudiante(int id, String nombre, String email) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
        }
        // Métodos para obtener los atributos del estudiante
        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        public String getEmail() {
            return email;
        }
        // Métodos para modificar los atributos del estudiante
        public void setId(int id) {
            this.id = id;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
        // Método para imprimir los datos del estudiante
        public void imprimirEstudiante() {
            System.out.println("Identificación: " + id);
            System.out.println("Nombre: " + nombre);
            System.out.println("Email: " + email);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Estudiante> listaEstudiantes = new ArrayList<>();
        // Solicitar al usuario el número de estudiantes a cargar
        System.out.print("Ingrese el número de estudiantes a cargar: ");
        int n = scanner.nextInt();
        // Ciclo para cargar los datos de los estudiantes
        for (int i = 0; i < n; i++) {
            System.out.println("Ingrese los datos del estudiante " + (i + 1) + ":");
            System.out.print("Identificación: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            // Crear un objeto Estudiante y agregarlo a la lista de estudiantes
            Estudiante estudiante = new Estudiante(id, nombre, email);
            listaEstudiantes.add(estudiante);
        }
        // Imprimir la lista original de estudiantes
        System.out.println("\nLista original de estudiantes:");
         for (Estudiante estudiante : listaEstudiantes) {
         estudiante.imprimirEstudiante();
         System.out.println();
        }

        // Consulta de un estudiante por número de identificación
        System.out.print("Ingrese el número de identificación del estudiante a consultar: ");
        int idConsulta = scanner.nextInt();
        boolean encontrado = false;
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getId() == idConsulta) {
                System.out.println("\nDatos del estudiante encontrado:");
                estudiante.imprimirEstudiante();
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontró ningún estudiante con esa identificación.");
        }

        // Actualización de la identificación y del nombre
        System.out.print("\nIngrese el número de identificación del estudiante a actualizar: ");
        int idActualizar = scanner.nextInt();
        for (Estudiante estudiante : listaEstudiantes) {
            if (estudiante.getId() == idActualizar) {
                scanner.nextLine(); // Limpiar el buffer
                System.out.print("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                estudiante.setNombre(nuevoNombre);

                System.out.print("Ingrese la nueva identificación: ");
                int nuevaId = scanner.nextInt();
                estudiante.setId(nuevaId);

                System.out.println("Datos actualizados del estudiante:");
                estudiante.imprimirEstudiante();
                break;
            }
        }

        // Imprime el listado de los estudiantes actualizada 
        System.out.println("\nListado de estudiantes actualizada:");
        for (Estudiante estudiante : listaEstudiantes) {
            estudiante.imprimirEstudiante();
            System.out.println();
        }
    }
}


