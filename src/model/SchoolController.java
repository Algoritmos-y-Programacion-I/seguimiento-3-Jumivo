package model;

import java.util.ArrayList;
import java.time.LocalDate;

public class SchoolController {

    private ArrayList<Computer> computers;

    public SchoolController() {
        computers = new ArrayList<Computer>();
    }

    public void agregarComputador(String serialNumber, int floor, int column) {
        Computer compu = new Computer(serialNumber, floor, column);
        computers.add(compu);
    }

    public void agregarIncidenteEnComputador(String serialNumber, String description) {
        for (int i = 0; i < computers.size(); i++) {
            Computer c = computers.get(i);

            if (c.getSerialNumber().equals(serialNumber)) {
                Incident nuevo = new Incident(LocalDate.now(), description);
                c.addIncident(nuevo);
            }
        }
    }

    public void getComputerList() {
        for (int i = 0; i < computers.size(); i++) {
            Computer c = computers.get(i);

            System.out.println("Serial: " + c.getSerialNumber());
            System.out.println("Piso: " + c.getFloor());
            System.out.println("Columna: " + c.getColumn());
            System.out.println("Incidentes: " + c.getTotalIncidents());
            System.out.println("--------------------");
        }
    }

    public Computer getComputerWithMoreIncidents() {
        if (computers.size() == 0) {
            return null; 
        }

        Computer mayor = computers.get(0);
        for (int i = 1; i < computers.size(); i++) {
            Computer c = computers.get(i);
            if (c.getTotalIncidents() > mayor.getTotalIncidents()) {
                mayor = c;
            }
        }
        return mayor;
    }
}
