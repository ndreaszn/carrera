import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        startRace();
    }

    public static void startRace() {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int actionCount = 0;
        int position = 15; // empieza en puesto 15
        int stress = 0;    // empieza con 0 estrés
        boolean crashed = false;

        while (actionCount < 20) {
            actionCount++;
            System.out.println("\n--- Acción #" + actionCount + " ---");
            System.out.println("Posición actual: " + position);
            System.out.println("Estrés actual: " + stress);

            String userAction = getUserChoice(scanner);
            System.out.println("Acción elegida: " + userAction);

            // actualizar estrés basado en la acción
            if (userAction.equalsIgnoreCase("PACIENTE")) {
                stress -= 20;
                if (stress < 0) {
                    stress = 0;
                }
            } else if (userAction.equalsIgnoreCase("AGRESIVO")) {
                stress += 15;
                if (stress > 100) {
                    stress = 100;
                }
            } else if (userAction.equalsIgnoreCase("TEMERARIO")) {
                stress += 30;
                if (stress > 100) {
                    stress = 100;
                }
            }

            // verificar si choca (solo si estrés > 80)
            if (stress > 80) {
                int crashChance = random.nextInt(2);
                if (crashChance == 0) {
                    crashed = true;
                    System.out.println("¡El corredor ha CHOCADO!");
                    break;
                }
            }

            // actualizar posición basado en la acción
            if (userAction.equalsIgnoreCase("PACIENTE")) {
                int chance = random.nextInt(2);
                if (chance == 0 && position < 20) {
                    position += 1; // pierde un puesto
                    System.out.println("Perdió un puesto");
                } else {
                    System.out.println("Mantuvo la posición");
                }
            } else if (userAction.equalsIgnoreCase("AGRESIVO")) {
                int chance = random.nextInt(2);
                if (chance == 0 && position > 1) {
                    position -= 1; // gana un puesto
                    System.out.println("¡Ganó un puesto!");
                } else {
                    System.out.println("Mantuvo la posición");
                }
            } else if (userAction.equalsIgnoreCase("TEMERARIO")) {
                if (position > 1) {
                    position -= 2; // gana dos puestos
                    if (position < 1) {
                        position = 1;
                    }
                    System.out.println("¡Ganó dos puestos!");
                }
            }

            // verificar si ganó la carrera
            if (position == 1) {
                System.out.println("\n¡GANASTE LA CARRERA!");
                break;
            }
        }

        System.out.println("\n=== Resultados Finales ===");
        System.out.println("Acciones realizadas: " + actionCount);
        System.out.println("Posición final: " + position);
        System.out.println("Estrés final: " + stress);
        if (crashed) {
            System.out.println("Estado: CHOCADO");
        } else if (position == 1) {
            System.out.println("Estado: ¡GANADOR!");
        } else {
            System.out.println("Estado: Carrera completada");
        }
    }

    public static String getUserChoice(Scanner scanner) {
        System.out.println("\nAcción del corredor: ");
        System.out.println("1. PACIENTE");
        System.out.println("2. AGRESIVO");
        System.out.println("3. TEMERARIO");
        System.out.print("Elige de 1-3: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            return "PACIENTE";
        } else if (choice == 2) {
            return "AGRESIVO";
        } else if (choice == 3) {
            return "TEMERARIO";
        } else {
            System.out.println("Entrada inválida! Se usará PACIENTE por defecto.");
            return "PACIENTE";
        }
    }
}