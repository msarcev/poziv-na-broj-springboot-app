package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateISO7064;
import pozivi.algs.PozivValidateMOD11;
import pozivi.algs.PozivValidateMOD11MBG;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_template implements IPozivNaBroj {
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
                if (nOfParts == 1) {

                }

                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            //if za ako je crtica zadnja
            if (kod.equals("")|| !num.isNumeric(kod)) {valid=false; msgErrorCode="poziv.fail.default";return valid;}
        }
        else {

        }
        return valid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_27 poz = new PozivNaModel_27();
        String test = "3117-12121218";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
