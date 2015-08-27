package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateISO7064;
import pozivi.algs.PozivValidateMOD11;
import pozivi.algs.PozivValidateMOD11MBG;

/**
 * Created by msarcevic on 26.8.2015..
 */
public class PozivNaModel_65 implements IPozivNaBroj {
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
        //check ako je poziv predug
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
                if (nOfParts == 1 ){
                    if (next.length() != 4 || !algMOD11.checkKBR(next)) {
                        valid = false;
                        msgErrorCode = "poziv.modul11.fail";
                        return valid;
                    }
                }
                if (nOfParts == 2 ){
                    if (next.length() > 3 || !algMOD11.checkKBR(next)) {
                        valid = false;
                        msgErrorCode = "poziv.podatak.drugi.neispravan";
                        return valid;
                    }
                }
                if ( nOfParts == 3){
                    if (next.substring(0,1).equals("0")){
                        valid=false;
                        msgErrorCode="poziv.podatak.prvi.nula";
                        return valid;
                    }
                    if (next.length() > 5 || !algISO7064.checkKBR(next)) {
                        valid = false;
                        msgErrorCode = "poziv.podatak.treci.neispravan";
                        return valid;
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            //if za ako je crtica zadnja
            if (kod.equals("")|| !num.isNumeric(kod)) {valid=false; msgErrorCode="poziv.fail.default";return valid;}
            if ( nOfParts == 3){
                if (kod.substring(0,1).equals("0")){
                    valid=false;
                    msgErrorCode="poziv.podatak.prvi.nula";
                    return valid;
                }
                if (kod.length() > 5 || !algISO7064.checkKBR(kod)) {
                    valid = false;
                    msgErrorCode = "poziv.podatak.treci.neispravan";
                    return valid;
                }
            }
            if (nOfParts == 4 ){
                if (kod.length() > 12 ) {
                    valid = false;
                    msgErrorCode = "poziv.podatak.predug";
                    return valid;
                }
            }
            if (nOfParts > 4){
                valid=false;
                msgErrorCode="poziv.previse.dijelova";
                return valid;
            }
            if(nOfParts < 3){
                valid=false;
                msgErrorCode="poziv.premalo.podataka";
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
                msgErrorCode = "poziv.required.parts";
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
        PozivNaModel_65 poz = new PozivNaModel_65();
        String test = "3117-120-1238-1";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
