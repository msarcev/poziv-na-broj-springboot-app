package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateMOD11;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_28 implements IPozivNaBroj {
    private String msgErrorCode ="poziv.fail.default";
    private Integer nOfPart =1;
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
                if (nOfPart == 1) {
                    if ( next.length() != 4 || !algMOD11.checkKBR(next) ) {
                        valid = false;
                        msgErrorCode = "poziv.podatak.prvi.neispravan";
                        return valid;
                    }
                }
                if (nOfPart == 2) {
                    if ( next.length() != 3 || !algMOD11.checkKBR(next) ) {
                        valid = false;
                        msgErrorCode = "poziv.podatak.drugi.neispravan";
                        return valid;
                    }
                }
                if (nOfPart == 3) {
                    if ( next.length() != 6 || !algMOD11.checkKBR(next) ) {
                        valid = false;
                        msgErrorCode = "poziv.podatak.treci.neispravan";
                        return valid;
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfPart++;
            } while (kod.contains("-"));
            //if za ako je crtica zadnja
            if (kod.equals("")|| !num.isNumeric(kod)) {valid=false; msgErrorCode="poziv.fail.default";return valid;}
            if (nOfPart == 3) {
                if ( kod.length() != 6 || !algMOD11.checkKBR(kod) ) {
                    valid = false;
                    msgErrorCode = "poziv.podatak.treci.neispravan";
                    return valid;
                }
            }
            if ( nOfPart ==4 && kod.length()>6){
                valid = false;
                msgErrorCode = "poziv.podatak.predug";
                return valid;
            }
            if (nOfPart < 3){
                valid=false;
                msgErrorCode="poziv.premalo.podataka";
                return valid;
            }
            if ( nOfPart > 4){
                valid=false;
                msgErrorCode="poziv.previse.dijelova";
                return valid;
            }
        }
        else {
            if (kod.equals("") || !num.isNumeric(kod)) {
                valid = false;
                msgErrorCode = "poziv.fail.default";
                return valid;
            } else {
                valid = false;
                msgErrorCode = "poziv.premalo.podataka";
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
        PozivNaModel_28 poz = new PozivNaModel_28();
        String test = "3117";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
