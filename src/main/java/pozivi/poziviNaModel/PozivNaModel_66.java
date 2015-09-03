package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 26.8.2015..
 */
public class PozivNaModel_66 extends PozivNaModel {
    @Override
    public boolean validatePoziv(String kod) {
        isValid= true;
        nOfParts = 1;
        String prvih8Nexta="";
        sveukupnaDuzinaCheck(kod);
        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid && nOfParts == 1 ){
                    if (next.length() != 4 || !validateMOD11(next)) {
                        isValid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                if (isValid && nOfParts == 2 ){
                    if (next.length() > 8) {
                       prvih8Nexta = next.substring(0,8);
                    } else {
                        isValid=false;
                        msgErrorCode="poziv.podatak.drugi.neispravan";
                    }
                    if (isValid && (next.length() != 12 || !validateMOD11(prvih8Nexta))) {
                        isValid = false;
                        msgErrorCode = "poziv.modul11.fail";
                    }
                }
                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
            if (isValid && nOfParts == 2 ){
                if (kod.length() > 8) {
                    prvih8Nexta = kod.substring(0,8);
                } else {
                    isValid=false;
                    msgErrorCode="poziv.podatak.drugi.neispravan";
                }
                if (isValid && (kod.length() != 12 || !validateMOD11(prvih8Nexta))) {
                    isValid = false;
                    msgErrorCode = "poziv.modul11.fail";
                }
            }
            if (isValid &&  nOfParts == 3 && kod.length()!=4){
                isValid = false;
                msgErrorCode = "poziv.podatak.treci.neispravan";
            }
            if (isValid &&  nOfParts > 4){
                isValid=false;
                msgErrorCode="poziv.previse.dijelova";
            }
            if (isValid &&  nOfParts < 2 ){
                isValid=false;
                msgErrorCode="poziv.premalo.podataka";
            }
        }
        else {
                isValid = false;
                msgErrorCode = "poziv.required.parts";
        }
        return isValid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_66 poz = new PozivNaModel_66();
        String test = "3116-121212162771";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
