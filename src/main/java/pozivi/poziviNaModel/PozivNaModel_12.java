package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 17.8.2015..
 */
public class PozivNaModel_12 extends PozivNaModel {
    @Override
    public boolean validatePoziv(String kod) {
        isValid= true;
        nOfParts = 1;
        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                if (isValid && nOfParts == 1) {
                    if (!validateMOD11MBG(next) || next.length() != 13) {
                        isValid = false;
                        msgErrorCode="poziv.modul11.fail";
                    }
                }
                if (isValid && nOfParts > 1) {
                    if (next.length() > 12) {
                        isValid = false;
                        msgErrorCode="poziv.podatak.predug";
                    }
                }
                kod = kod.substring(kod.indexOf("-")+1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            //slucaj dva podatka
            if (isValid && nOfParts > 1){
                if (kod.length() > 12) {
                    isValid = false;
                    msgErrorCode="poziv.podatak.predug";
                }
            }
            if (isValid && nOfParts > 3) {
                isValid = false;
                msgErrorCode="poziv.previse.dijelova";
            }
        } else {
            emptyOrCharactersCheck(kod);
            if (isValid && (!validateMOD11MBG(kod) || kod.length() != 13)){
                isValid = false;
                msgErrorCode = "poziv.modul11.fail";
            }
        }
        return isValid;
    }
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args){
        PozivNaModel_12 poz5 = new PozivNaModel_12();
        String test = "2004940339312-111-111";
        System.out.println("Test je : "+ poz5.validatePoziv(test)+ "      /     err code ; " + poz5.getMsgErrorCode());
    }
}
