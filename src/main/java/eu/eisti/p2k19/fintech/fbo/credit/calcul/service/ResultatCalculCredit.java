package eu.eisti.p2k19.fintech.fbo.credit.calcul.service;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "ResultatCalculCredit")
public class ResultatCalculCredit {
    
    private double taeg;
    private int duree;
    
    public double getTaeg() {
        return this.taeg;
    }
    
    public void setTaeg(double taeg) {
        this.taeg = taeg;
    }

    public int getDuree() {
        return this.duree;
    }
    
    public void setDuree(int duree) {
        this.duree = duree;
    }

    public ResultatCalculCredit() {
    }
    
    public ResultatCalculCredit(double taeg, int duree) {
        this.taeg = taeg;
        this.duree = duree;
    }
    
}
