package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateMOD11;

/**
 * Created by msarcevic on 23.8.2015..
 */
public class PozivNaModel_23 implements IPozivNaBroj {
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
                    String check6 = next.substring(0, 1);
                    if (!check6.equals("6")) {
                        valid = false;
                        msgErrorCode = "poziv.podatak.prvi.neispravan";
                        return valid;
                    }
                    if (!algMOD11.checkKBR(next) || next.length() != 4) {
                        valid = false;
                        msgErrorCode = "poziv.modul11.fail";
                        return valid;
                    }
                }
                if (nOfParts > 1) {
                    if (next.length() > 12) {
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
            if (nOfParts > 1) {
                if (kod.length() > 12) {
                    valid = false;
                    msgErrorCode = "poziv.podatak.predug";
                    return valid;
                }}
                //check za previse djelova
                if (nOfParts > 4) {
                    valid = false;
                    msgErrorCode = "poziv.previse.dijelova";
                    return valid;
                }

            } else {
            if (kod.equals("") || !num.isNumeric(kod)){
                valid= false;
                msgErrorCode="poziv.fail.default";
                return valid;
            } else {
                String check6 = kod.substring(0, 1);
            if (!check6.equals("6") || !algMOD11.checkKBR(kod) || kod.length() != 4) {
                valid = false;
                msgErrorCode = "poziv.podatak.prvi.neispravan";
                return valid;
            }
               }
                 }
            return valid;
        }


    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_23 poz23 = new PozivNaModel_23();
        String test = "6122-111-1111111-1111";
        System.out.println("Test je : " + poz23.validatePoziv(test) + "      /     err code ; " + poz23.getMsgErrorCode());
    }
}
