package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 23.8.2015..
 */
public class PozivNaModel_23 extends PozivNaModel {

    @Override
    public boolean validatePoziv(String kod) {

        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid && nOfParts == 1) {
                    String check6 = next.substring(0, 1);
                    if (!check6.equals("6")) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.prvi.neispravan";
                    }
                    if (!validateMOD11(next) || next.length() != 4) {
                        isValid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                if (isValid && nOfParts > 1) {
                    if (next.length() > 12) {
                        isValid = false;
                        msgErrorCode = "poziv.podatak.predug";
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid && nOfParts > 1) {
                if (kod.length() > 12) {
                    isValid = false;
                    msgErrorCode = "poziv.podatak.predug";
                }}
                //check za previse djelova
                if (isValid && nOfParts > 4) {
                    isValid = false;
                    msgErrorCode = "poziv.previse.dijelova";
                }

            } else {
            emptyOrCharactersCheck(kod);
            if (isValid) {
                    String check6 = kod.substring(0, 1);
                    if (!check6.equals("6") || !validateMOD11(kod) || kod.length() != 4) {
                    isValid = false;
                    msgErrorCode = "poziv.podatak.prvi.neispravan";
                 }
                 }
                 }
            return isValid;
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
