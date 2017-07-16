package entities;

import java.sql.Date;

/**
 *
 * @author Jhon
 */
public class Cena {
    //id, comedor_id, expediente_id, created_at, updated_at
    private String idx,codx,dnix,apex,nomx,facx,epx,becax;
    private String id,comid,expid;
    private Date created,updated;
    private String fs,fu;
    
    public Cena() {
    }

    public String getIdx() {
        return idx;
    }

    public void setIdx(String idx) {
        this.idx = idx;
    }

    public String getCodx() {
        return codx;
    }

    public void setCodx(String codx) {
        this.codx = codx;
    }

    public String getDnix() {
        return dnix;
    }

    public void setDnix(String dnix) {
        this.dnix = dnix;
    }

    public String getApex() {
        return apex;
    }

    public void setApex(String apex) {
        this.apex = apex;
    }

    public String getNomx() {
        return nomx;
    }

    public void setNomx(String nomx) {
        this.nomx = nomx;
    }

    public String getFacx() {
        return facx;
    }

    public void setFacx(String facx) {
        this.facx = facx;
    }

    public String getEpx() {
        return epx;
    }

    public void setEpx(String epx) {
        this.epx = epx;
    }

    public String getBecax() {
        return becax;
    }

    public void setBecax(String becax) {
        this.becax = becax;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComid() {
        return comid;
    }

    public void setComid(String comid) {
        this.comid = comid;
    }

    public String getExpid() {
        return expid;
    }

    public void setExpid(String expid) {
        this.expid = expid;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getFu() {
        return fu;
    }

    public void setFu(String fu) {
        this.fu = fu;
    }    
    
    public Cena(String comid, String expid, String fs) {       
        this.comid = comid;
        this.expid = expid;
        this.fs = fs;
    }
    
}
