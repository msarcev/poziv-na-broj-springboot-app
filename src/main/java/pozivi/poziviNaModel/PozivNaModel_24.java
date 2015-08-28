package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 23.8.2015..
 */
public class PozivNaModel_24 extends PozivNaModel {

    @Override
    public boolean validatePoziv(String kod) {
        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid ==true && nOfParts == 1) {
                    if (!validateMOD11(next) || next.length() != 4) {
                        isValid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                if (isValid ==true && nOfParts == 2) {
                    if (next.length() > 13) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.predug";
                    }
                }
                if (isValid ==true && nOfParts > 2) {
                    if (next.length() > 12) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.predug";
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid ==true && nOfParts == 2) {
                if (kod.length() > 13) {
                    isValid = false;
                    msgErrorCode = "poziv.podatak.predug";
                }
            }
            if (isValid ==true && nOfParts > 2) {
                if (kod.length() > 12) {
                    isValid = false;
                    msgErrorCode = "poziv.podatak.predug";
                }
            }
            //check za previse djelova
            if (isValid ==true && nOfParts > 4) {
                isValid = false;
                msgErrorCode = "poziv.previse.dijelova";
            }

        } else {
            emptyOrCharactersCheck(kod);
            if (isValid ==true && (!validateMOD11(kod) || kod.length() != 4)) {
                isValid = false;
                msgErrorCode = "poziv.modul11.fail";
            }
        }
        return isValid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }

    public static void main(String[] args) {
        PozivNaModel_24 poz24 = new PozivNaModel_24();
        String test = "3127-12121212";
        System.out.println("Test je : " + poz24.validatePoziv(test) + "      /     err code ; " + poz24.getMsgErrorCode());
    }
}
