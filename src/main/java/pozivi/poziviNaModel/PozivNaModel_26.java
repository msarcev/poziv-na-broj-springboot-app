package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateISO7064;
import pozivi.algs.PozivValidateMOD11;
import pozivi.algs.PozivValidateMOD11MBG;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_26 implements IPozivNaBroj {
    private String msgErrorCode ="poziv.fail.default";
    private Integer nOfParts=1;
    private IsNumeric num = new IsNumeric();
    private String pozivNB;
    private boolean valid = true;
    public String getPozivNB() {
        return pozivNB;
    }
    public void setPozivNB(String pozivNB) {
        this.pozivNB = pozivNB;
    }

    @Override
    public boolean validatePoziv(String kod) {
        PozivValidateMOD11 algMOD11 = new PozivValidateMOD11();
        PozivValidateMOD11MBG algMOD11MBG = new PozivValidateMOD11MBG();
        PozivValidateISO7064 algISO7064 = new PozivValidateISO7064();
        if (kod.length() > 22) {
            valid = false;
            msgErrorCode = "poziv.duzina.veca.max";
            return valid;
        }

        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                if (next.equals("") || !num.isNumeric(next)){
                    valid= false;
                    msgErrorCode="poziv.fail.default";
                    return valid;
                }
                //check za prvi podatak
                if (nOfParts == 1) {
                    if (!algMOD11.checkKBR(next) || next.length() != 4) {
                        valid = false;
                        msgErrorCode = "poziv.podatak.prvi.neispravan";
                        return valid;
                    }
                }
                //check za drugi podatak
                if (nOfParts == 2) {
                    if (next.length() <= 10){
                        if (!algMOD11.checkKBR(next)){
                            valid = false;
                            msgErrorCode="poziv.podatak.drugi.neispravan";
                            return valid;
                        }
                    } else if (next.length() == 11 ){
                        if (!algISO7064.checkKBR(next)){
                            valid = false;
                            msgErrorCode="poziv.podatak.drugi.neispravan";
                            return valid;
                        }
                    } else {
                        valid = false;
                        msgErrorCode = "poziv.podatak.predug";
                        return valid;
                    }
                }
                if ( nOfParts == 3) {
                 if ( next.length() <=10){
                     if (!algMOD11.checkKBR(next)){
                         valid = false;
                         msgErrorCode="poziv.podatak.treci.neispravan";
                         return valid;
                     }
                 } else if (next.length() == 11 ){
                     if (!algISO7064.checkKBR(next)){
                         valid = false;
                         msgErrorCode="poziv.podatak.treci.neispravan";
                         return valid;
                     }
                 } else if (next.length() == 13){
                     if (!algMOD11MBG.checkKBR(next)){
                         valid = false;
                         msgErrorCode="poziv.podatak.treci.neispravan";
                         return valid;
                     }
                 } else {
                     valid = false;
                     msgErrorCode = "poziv.podatak.predug";
                     return valid;
                 }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            //if za ako je crtica zadnja
            if (kod.equals("")|| !num.isNumeric(kod)) {valid=false; msgErrorCode="poziv.fail.default";return valid;}
            //check ponovo za treci podatak, ako ima samo 3
            if ( nOfParts == 3) {
                if ( kod.length() <=10){
                    if (!algMOD11.checkKBR(kod)){
                        valid = false;
                        msgErrorCode="poziv.podatak.treci.neispravan";
                        return valid;
                    }
                } else if (kod.length() == 11 ){
                    if (!algISO7064.checkKBR(kod)){
                        valid = false;
                        msgErrorCode="poziv.podatak.treci.neispravan";
                        return valid;
                    }
                } else if (kod.length() == 13){
                    if (!algMOD11MBG.checkKBR(kod)){
                        valid = false;
                        msgErrorCode="poziv.podatak.treci.neispravan";
                        return valid;
                    }
                } else {
                    valid = false;
                    msgErrorCode = "poziv.podatak.predug";
                    return valid;
                }
            }
            if (nOfParts == 4){
             if (kod.length() > 13) {
                 valid= false;
                 msgErrorCode= "poziv.podatak.predug";
                 return valid;
             }
            }
            if ( nOfParts < 3){
                valid=false;
                msgErrorCode="poziv.premalo.podataka";
                return valid;
            }
            if (nOfParts>4 ){
                valid=false;
                msgErrorCode="poziv.previse.dijelova";
                return valid;
            }
        }
        else {
            if (kod.equals("") || !num.isNumeric(kod)){
                valid= false;
                msgErrorCode="poziv.fail.default";
                return valid;
            } else {
                valid = false;
                msgErrorCode = "poziv.premalo.podatak";
                return valid;
            }
        }
        return valid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_26 poz = new PozivNaModel_26();
        String test = "3127-1214-123412311123-12";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
