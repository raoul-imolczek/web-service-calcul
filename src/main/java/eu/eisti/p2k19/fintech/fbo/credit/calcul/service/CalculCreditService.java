package eu.eisti.p2k19.fintech.fbo.credit.calcul.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import eu.eisti.p2k19.fintech.fbo.credit.model.CreditPasRemboursableException;
import eu.eisti.p2k19.fintech.fbo.credit.model.TauxUsureException;

@WebService
public interface CalculCreditService {
    
    @WebMethod
    public ResultatCalculCredit calculCredit(
        @WebParam(name = "montant") double montant,
        @WebParam(name = "apport") double apport,
        @WebParam(name = "taux") double taux,
        @WebParam(name = "mensualite") double mensualite)
        throws TauxUsureException, CreditPasRemboursableException;
    
}
