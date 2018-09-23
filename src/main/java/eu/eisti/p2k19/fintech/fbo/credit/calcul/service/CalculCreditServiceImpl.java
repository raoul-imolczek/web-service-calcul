package eu.eisti.p2k19.fintech.fbo.credit.calcul.service;

import java.time.LocalDate;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

import eu.eisti.p2k19.fintech.fbo.credit.model.CreditImmobilier;
import eu.eisti.p2k19.fintech.fbo.credit.model.CreditPasRemboursableException;
import eu.eisti.p2k19.fintech.fbo.credit.model.TauxUsureException;

@WebService(
    serviceName = "CalculCreditService",
    endpointInterface = "eu.eisti.p2k19.fintech.fbo.credit.calcul.service.CalculCreditService"
    )
@SOAPBinding(style=Style.DOCUMENT, use=Use.LITERAL)
public class CalculCreditServiceImpl implements CalculCreditService {

    @Override
    public ResultatCalculCredit calculCredit(double montant, double apport, double taux, double mensualite)
        throws TauxUsureException, CreditPasRemboursableException {

        CreditImmobilier credit;
        try {
            credit = new CreditImmobilier(apport, montant, mensualite, taux, 0, 0, LocalDate.now());

            int duree = credit.getDuree();
            double taeg = credit.getTaeg();    
            
            ResultatCalculCredit resultat = new ResultatCalculCredit(taeg, duree);

            return resultat;

        } catch (TauxUsureException e) {
            throw e;
        } catch (CreditPasRemboursableException e) {
            throw e;
        }

    }
}
