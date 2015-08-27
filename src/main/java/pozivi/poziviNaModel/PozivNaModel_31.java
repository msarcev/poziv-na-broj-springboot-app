package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateISO7064;

/**
 * Created by msarcevic on 25.8.2015..
 */
public class PozivNaModel_31 implements IPozivNaBroj {
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
                if (nOfParts == 1 && (next.length() > 6 || !algISO7064.checkKBR(next))) {
                    valid=false;
                    msgErrorCode="Prvi podatak je neispravan";
                    return valid;
                }
                if (nOfParts>1 && (next.length() > 12)){
                    valid=false;
                    msgErrorCode="poziv.podatak.predug";
                    return valid;
                }

                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            //if za ako je crtica zadnja
            if (kod.equals("")|| !num.isNumeric(kod)) {valid=false; msgErrorCode="poziv.fail.default";return valid;}
            if (nOfParts == 4 && kod.length()>12){
                valid=false;
                msgErrorCode="poziv.podatak.predug";
                return valid;
            }
            if (nOfParts>4){
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
            } else if (kod.length() > 6 || !algISO7064.checkKBR(kod)) {
                valid=false;
                msgErrorCode="poziv.podatak.prvi.neispravan";
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
        PozivNaModel_31 poz = new PozivNaModel_31();
        String test = "3115--112111111";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
