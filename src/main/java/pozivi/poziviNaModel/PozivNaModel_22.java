package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 23.8.2015..
 */
public class PozivNaModel_22 extends PozivNaModel {
    @Override
    public boolean validatePoziv(String kod) {
        isValid= true;
        nOfParts = 1;
        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid && nOfParts == 1) {
                    if (!validateMOD11(next) || next.length() != 4) {
                        isValid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                //check za drugi podatak, ako ima treceg
                if (isValid && nOfParts == 2) {
                    if (next.length() != 13 || !validateMOD11MBG(next)) {
                        isValid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            //check za drugi podatak, ako nema treceg
            if (isValid && nOfParts == 2) {
                if (kod.length() != 13 || !validateMOD11MBG(kod)) {
                    isValid = false;
                    msgErrorCode = "poziv.modul11.fail";
                }
            }
            if (isValid && nOfParts == 3) {
                if (kod.length() != 3) {
                    isValid = false;
                    msgErrorCode = "poziv.podatak.treci.neispravan";
                }
            }
            //check za previse djelova
            if (isValid && nOfParts > 3) {
                isValid = false;
                msgErrorCode = "poziv.previse.dijelova";
            }
        } else {
                isValid = false;
                msgErrorCode = "poziv.premalo.podataka";
        }
        return isValid;
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
