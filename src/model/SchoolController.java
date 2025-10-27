package model;

import java.util.ArrayList;
import java.time.LocalDate;

public class SchoolController {

    private Computer[][] building;
    private ArrayList<Computer> computers;

    public SchoolController() {
        building = new Computer[5][10];
        computers = new ArrayList<Computer>();
    }

    public void agregarComputador(String serialNumber, int floor, int column) {
        
        if (floor < 0 || floor >= building.length) {
            System.out.println("Piso inválido.");
            return;
        }

        for (int j = 0; j < building[floor].length; j++) {
            if (building[floor][j] == null) {
                Computer compu = new Computer(serialNumber, floor, j);
                building[floor][j] = compu;
                computers.add(compu);
                System.out.println("Computador agregado en piso " + floor + ", columna " + j);
                return;
            }
        }

        System.out.println("No hay espacio disponible en ese piso.");
    }

    public void agregarIncidenteEnComputador(String serialNumber, String description) {
        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[i].length; j++) {
                Computer c = building[i][j];
                if (c != null && c.getSerialNumber().equals(serialNumber)) {
                    Incident nuevo = new Incident(LocalDate.now(), description);
                    c.addIncident(nuevo);
                    System.out.println("Incidente registrado en " + serialNumber);
                    return;
                }
            }
        }
        System.out.println("Computador no encontrado.");
    }

    public void getComputerList() {
        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[i].length; j++) {
                Computer c = building[i][j];
                if (c != null) {
                    System.out.println("Piso: " + i + " | Columna: " + j + 
                                       " | Serial: " + c.getSerialNumber() +
                                       " | Incidentes: " + c.getTotalIncidents());
                }
            }
        }
    }

    public Computer getComputerWithMoreIncidents() {
        Computer mayor = null;
        int max = -1;

        for (int i = 0; i < building.length; i++) {
            for (int j = 0; j < building[i].length; j++) {
                Computer c = building[i][j];
                if (c != null && c.getTotalIncidents() > max) {
                    max = c.getTotalIncidents();
                    mayor = c;
                }
            }
        }

        return mayor;
    }
}
