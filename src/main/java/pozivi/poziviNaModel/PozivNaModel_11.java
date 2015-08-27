package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 20.8.2015..
 */
public class PozivNaModel_11 extends PozivNaModel {
    @Override
    public boolean validatePoziv(String kod) {

        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                if (valid==true && nOfParts == 1) {
                    if (!validateMOD11(next) || next.length() > 12) {
                        valid = false;
                        msgErrorCode="poziv.modul11.fail";
                    }
                }
                if (valid==true && nOfParts == 2) {
                    if (!validateMOD11(next) || next.length() > 12) {
                        valid = false;
                        msgErrorCode="poziv.modul11.fail";
                    }
                }
                if (valid==true && nOfParts > 2) {
                    if (next.length() > 12) {
                        valid = false;
                        msgErrorCode="poziv.podatak.predug";
                    }
                }
                kod = kod.substring(kod.indexOf("-")+1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (valid==true && nOfParts == 2) {
                if (!validateMOD11(kod) || kod.length() > 12) {
                    valid = false;
                    msgErrorCode="poziv.modul11.fail";
                }
            }
            if (valid==true && nOfParts > 2) if (kod.length() > 12) {
                valid = false;
                msgErrorCode="poziv.podatak.predug";
            }
            if (valid==true && nOfParts > 3) {
                valid = false;
                msgErrorCode="poziv.previse.dijelova";
            }
        } else {
                valid = false;
                msgErrorCode = "poziv.required.parts";
            }
        return valid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args){
        PozivNaModel_11 poz11 = new PozivNaModel_11();
        String test = "1235-1235-1234";
        System.out.println("Test je : "+ poz11.validatePoziv(test));
    }
}
