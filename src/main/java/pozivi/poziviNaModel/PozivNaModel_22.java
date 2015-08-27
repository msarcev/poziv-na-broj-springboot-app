package pozivi.poziviNaModel;

import pozivi.IsNumeric;
import pozivi.IPozivNaBroj;
import pozivi.algs.PozivValidateMOD11;
import pozivi.algs.PozivValidateMOD11MBG;

/**
 * Created by msarcevic on 23.8.2015..
 */
public class PozivNaModel_22 extends PozivNaModel {
    @Override
    public boolean validatePoziv(String kod) {
        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (valid==true && nOfParts == 1) {
                    if (!validateMOD11(next) || next.length() != 4) {
                        valid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                //check za drugi podatak, ako ima treceg
                if (valid==true && nOfParts == 2) {
                    if (next.length() != 13 || !validateMOD11MBG(next)) {
                        valid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            //check za drugi podatak, ako nema treceg
            if (valid==true && nOfParts == 2) {
                if (kod.length() != 13 || !validateMOD11MBG(kod)) {
                    valid = false;
                    msgErrorCode = "poziv.modul11.fail";
                }
            }
            if (valid==true && nOfParts == 3) {
                if (kod.length() != 3) {
                    valid = false;
                    msgErrorCode = "poziv.podatak.treci.neispravan";
                }
            }
            //check za previse djelova
            if (valid==true && nOfParts > 3) {
                valid = false;
                msgErrorCode = "poziv.previse.dijelova";
            }
        } else {
                valid = false;
                msgErrorCode = "poziv.premalo.podataka";
        }
        return valid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }

    public static void main(String[] args) {
        PozivNaModel_22 poz22 = new PozivNaModel_22();
        String test = "1234-2004940339319";
        System.out.println("Test je : " + poz22.validatePoziv(test) + "      /     err code ; " + poz22.getMsgErrorCode());
    }
}
