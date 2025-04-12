package org.ses.models;

import java.time.LocalDate;

public class Patient extends User{
    private String bloodType;
    private String allergies;
    private String diseases;
    private double weight;
    private double height;
    private String patientId;
    private LocalDate lastVisit;
    private String prescription;
    private String testReport;

    public Patient() {
        super();
    }

    public Patient(String bloodType, String allergies, String diseases, double weight, double height, String patientId, LocalDate lastVisit, String prescription, String testReport) {
        this.bloodType = bloodType;
        this.allergies = allergies;
        this.diseases = diseases;
        this.weight = weight;
        this.height = height;
        this.patientId = patientId;
        this.lastVisit = lastVisit;
        this.prescription = prescription;
        this.testReport = testReport;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    public String getDiseases() {
        return diseases;
    }

    public void setDiseases(String diseases) {
        this.diseases = diseases;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public LocalDate getLastVisit() {
        return lastVisit;
    }

    public void setLastVisit(LocalDate lastVisit) {
        this.lastVisit = lastVisit;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getTestReport() {
        return testReport;
    }

    public void setTestReport(String testReport) {
        this.testReport = testReport;
    }
}
