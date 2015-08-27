package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateMOD11;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_29 implements IPozivNaBroj {
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
                if (nOfParts == 1 && (next.length() != 4 || !algMOD11.checkKBR(next))) {
                    valid=false;
                    msgErrorCode="Prvi podatak je neispravan";
                    return valid;
                }
                if (nOfParts== 2 && (next.length() > 12 || !algMOD11.checkKBR(next))){
                    valid=false;
                    msgErrorCode="Drugi podatak je neispravan";
                    return valid;
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            //if za ako je crtica zadnja
            if (kod.equals("")|| !num.isNumeric(kod)) {valid=false; msgErrorCode="poziv.fail.default";}
            if ( nOfParts == 3 && (kod.length() > 12 || !algMOD11.checkKBR(kod))){
                valid=false;
                msgErrorCode="poziv.podatak.treci.neispravan";
                return valid;
            }
            if (nOfParts < 3 || nOfParts > 3){
                valid=false;
                msgErrorCode= "poziv.broj.podataka.fail";
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
        PozivNaModel_29 poz = new PozivNaModel_29();
        String test = "3117-1212131210-1214";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
