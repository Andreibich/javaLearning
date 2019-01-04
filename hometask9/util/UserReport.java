package com.htp.lesson9.hometask9.util;

public class UserReport {
    private boolean nameValid = true;
    private boolean surnameValid = true;
    private boolean ageValid = true;
    private boolean sexValid = true;
    private boolean educationValid = true;

    public UserReport() {
    }

    public boolean isNameValid() {
        return nameValid;
    }

    public void setNameValid(boolean nameValid) {
        this.nameValid = nameValid;
    }

    public boolean isSurnameValid() {
        return surnameValid;
    }

    public void setSurnameValid(boolean surnameValid) {
        this.surnameValid = surnameValid;
    }

    public boolean isAgeValid() {
        return ageValid;
    }

    public void setAgeValid(boolean ageValid) {
        this.ageValid = ageValid;
    }

    public boolean isSexValid() {
        return sexValid;
    }

    public void setSexValid(boolean sexValid) {
        this.sexValid = sexValid;
    }

    public boolean isEducationValid() {
        return educationValid;
    }

    public void setEducationValid(boolean educationValid) {
        this.educationValid = educationValid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserReport that = (UserReport) o;

        if (nameValid != that.nameValid) return false;
        if (surnameValid != that.surnameValid) return false;
        if (ageValid != that.ageValid) return false;
        if (sexValid != that.sexValid) return false;
        return educationValid == that.educationValid;
    }

    @Override
    public int hashCode() {
        int result = (nameValid ? 1 : 0);
        result = 31 * result + (surnameValid ? 1 : 0);
        result = 31 * result + (ageValid ? 1 : 0);
        result = 31 * result + (sexValid ? 1 : 0);
        result = 31 * result + (educationValid ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "UserReport{" +
                "nameValid=" + nameValid +
                ", surnameValid=" + surnameValid +
                ", ageValid=" + ageValid +
                ", sexValid=" + sexValid +
                ", educationValid=" + educationValid +
                '}';
    }

    public void printReport(){
        System.out.println("\nUser report:");
        System.out.println("nameValid = " + nameValid);
        System.out.println("surnameValid = " + surnameValid);
        System.out.println("ageValid = " + ageValid);
        System.out.println("sexValid = " + sexValid);
        System.out.println("educationValid = " + educationValid);
    }
}
