package model;
import java.time.LocalDate;

public class Incident { 

    private LocalDate dateReport; 
    private String description; 
    private boolean solution; 
    private int solutionHours;

    public incident (LocalDate dateReport, String description) {
        this.dateReport = dateReport; 
        this.description = description; 
    }

    public LocalDate getDateReport() {
        return dateReport;
    }

    public String getDescription () {
        return description;
    }

    public boolean getSolution () {
        return solution;
    }

    public int getSolutionHours () {
        return solutionHours;
    }

    public void setDateReport(LocalDate dateReport) {
        this.DateReport = dateReport; 
    }

    public void setDescription(String description) {
        this.Description = description; 
    }

    public void setSolution(boolean solution){
        this.Solution = solution;
    }

    public void setSolutionHours(int solutionHours) {
        this.SolutionHours = solutionHours;
    }
}