package pozivi.poziviNaModel;

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
                if (isValid && nOfParts == 1) {
                    if (!validateMOD11(next) || next.length() != 4) {
                        isValid = false;
                        msgErrorCode="poziv.modul11.fail";
                        return isValid;
                    }
                }
                if (isValid && nOfParts == 2) {
                    String nulaCheck = next.substring(0,1);
                    if (!nulaCheck.equals("0")) {
                        isValid = false;
                        msgErrorCode="poziv.podatak.drugi.nula";}
                    if (next.length() != 8 || !validateMOD11(next)) {
                        isValid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                kod = kod.substring(kod.indexOf("-")+1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
             if (isValid && kod.length() > 8) {
                    isValid = false;
                    msgErrorCode="poziv.podatak.predug";
                }
            if (isValid && nOfParts == 2) {
                String nulaCheck = kod.substring(0,1);
                if (!nulaCheck.equals("0")) {
                    isValid = false;msgErrorCode="poziv.podatak.drugi.nula";}
                if (kod.length() != 8 || !validateMOD11(kod)) {
                    isValid = false;
                    msgErrorCode = "poziv.modul11.fail";
                }
            }
            if (isValid && nOfParts > 3) {
                isValid = false;
                msgErrorCode="poziv.previse.dijelova";
            }
        } else {
                isValid = false;
                msgErrorCode = "poziv.premalo.podataka";
        }
        return isValid;
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
