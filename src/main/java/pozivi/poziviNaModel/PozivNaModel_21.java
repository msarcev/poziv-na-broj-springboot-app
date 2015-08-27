package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateMOD11;

/**
 * Created by msarcevic on 17.8.2015..
 */
public class PozivNaModel_21 extends PozivNaModel{
    @Override
    public boolean validatePoziv(String kod) {

        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                if (valid==true && nOfParts == 1) {
                    if (!validateMOD11(next) || next.length() != 4) {
                        valid = false;
                        msgErrorCode="poziv.modul11.fail";
                        return valid;
                    }
                }
                if (valid==true && nOfParts == 2) {
                    String nulaCheck = next.substring(0,1);
                    if (!nulaCheck.equals("0")) {
                        valid = false;
                        msgErrorCode="poziv.podatak.drugi.nula";}
                    if (next.length() != 8 || !validateMOD11(next)) {
                        valid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                kod = kod.substring(kod.indexOf("-")+1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
             if (valid==true && kod.length() > 8) {
                    valid = false;
                    msgErrorCode="poziv.podatak.predug";
                }
            if (valid==true && nOfParts == 2) {
                String nulaCheck = kod.substring(0,1);
                if (!nulaCheck.equals("0")) {valid = false;msgErrorCode="poziv.podatak.drugi.nula";}
                if (kod.length() != 8 || !validateMOD11(kod)) {
                    valid = false;
                    msgErrorCode = "poziv.modul11.fail";
                }
            }
            if (valid==true && nOfParts > 3) {
                valid = false;
                msgErrorCode="poziv.previse.dijelova";
            }
        } else {
                valid = false;
                msgErrorCode = "poziv.premalo.podataka";
        }
        return valid;
    }
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args){
        PozivNaModel_21 poz5 = new PozivNaModel_21();
        String test = "1235-023a1237";
        System.out.println("Test je : "+ poz5.validatePoziv(test)+ "      /     err code ; " + poz5.getMsgErrorCode());
    }
}
