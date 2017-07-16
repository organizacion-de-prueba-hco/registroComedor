package entities;

import java.io.InputStream;

/**
 *
 * @author Jhon
 */
public class Expediente {
    //expediente, jefe_usu, solicitud_decano, croquis_vivienda, reporte_notas, dni_estudiante, dni_apoderado, recibo, certificado_medico, ficha_soc_econ, 
    //declaracion_jurada, tipo_beca, estado, obs, huella_a, huella_b, created_at, updated_at
    private String id,cod,dni,ape,nom,fac,ep,beca;
    private  InputStream h1,h2;
    private int tam,tam2; 

    public Expediente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getFac() {
        return fac;
    }

    public void setFac(String fac) {
        this.fac = fac;
    }

    public String getEp() {
        return ep;
    }

    public void setEp(String ep) {
        this.ep = ep;
    }

    public String getBeca() {
        return beca;
    }

    public void setBeca(String beca) {
        this.beca = beca;
    }
    
    public InputStream getH1() {
        return h1;
    }

    public void setH1(InputStream h1,int tam) {
        this.h1 = h1;
        this.tam = tam;
    }

    public InputStream getH2() {
        return h2;
    }

    public void setH2(InputStream h2,int tam2) {
        this.h2 = h2;
        this.tam2 = tam2;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getTam2() {
        return tam2;
    }

    public void setTam2(int tam2) {
        this.tam2 = tam2;
    }
    
}
