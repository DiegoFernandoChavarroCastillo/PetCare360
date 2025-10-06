package com.PetCare360.demo.enums;

public enum Status {
    PENDIENTE("Pendiente"),
    CONFIRMADA("Confirmada"),
    PROGRAMADA("Programada"),
    ENCURSO("EnCurso"),
    FINALIZADA("Finalizada");
    
    private final String description;
    Status(String description){this.description=description;}
    public String getDescription(){return this.description;}

    @Override
    public String toString(){return description;}
}
