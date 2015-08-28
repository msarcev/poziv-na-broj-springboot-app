package pozivi.poziviNaModel;

/**
 * Created by msarcevic on 24.8.2015..
 */
public class PozivNaModel_template extends PozivNaModel {

    @Override
    public boolean validatePoziv(String kod) {
        sveukupnaDuzinaCheck(kod);

        if (kod.contains("-")) {
            do {
                String next = kod.substring(0, kod.indexOf("-"));
                emptyOrCharactersCheck(next);
                //check za prvi podatak
                if (isValid && nOfParts == 1) {

                }

                kod = kod.substring(kod.indexOf("-") + 1, kod.length());
                nOfParts++;
            } while (kod.contains("-"));
            emptyOrCharactersCheck(kod);
        }
        else {

        }
        return isValid;
    }

    @Override
    public String getMsgErrorCode() {
        return msgErrorCode;
    }
    public static void main(String[] args) {
        PozivNaModel_27 poz = new PozivNaModel_27();
        String test = "3117-12121218";
        System.out.println("Test je : " + poz.validatePoziv(test) + "      /     err code ; " + poz.getMsgErrorCode());
    }
}
