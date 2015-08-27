package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateMOD11;

/**
 * Created by msarcevic on 17.8.2015..
 */
public class PozivNaModel_05 extends PozivNaModel{

    @Override
    public boolean validatePoziv(String kod) {
        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                if (valid==true && (nOfParts == 1)) {
                    if (!validateMOD11(next) || next.length() > 12) {
                        valid = false;
                        msgErrorCode="poziv.modul11.fail";
                    }
                }
                if (valid==true && (nOfParts > 1)) {
                    if (next.length() > 12) {
                        valid = false;
                        msgErrorCode="poziv.podatak.predug";
                    }
                }
                kod = kod.substring(kod.indexOf("-")+1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));

            emptyOrCharactersCheck(kod);

            if (valid==true && nOfParts > 1) {
                if (kod.length() > 12) {
                    valid = false;
                    msgErrorCode="poziv.podatak.predug";
                }
            }
            if (valid==true && nOfParts > 3) {
                valid = false;
                msgErrorCode="poziv.previse.dijelova";
            }
        } else {
            emptyOrCharactersCheck(kod);
            if (valid == true && (!validateMOD11(kod) || kod.length() > 12)){
                valid = false;
                msgErrorCode = "poziv.modul11.fail";
            }
        }
        return valid;
    }
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args){
        PozivNaModel_05 poz5 = new PozivNaModel_05();
        String test = "01234560";
        System.out.println("Test je : "+ poz5.validatePoziv(test));
    }
}
