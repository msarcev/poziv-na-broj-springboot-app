package pozivi;

import pozivi.poziviNaModel.*;

/**
 * Created by msarcevic on 17.8.2015..
 */
public class PozivFactory {
    public PozivNaModel odaberiPoziv(String model) {
        if (model == null) {
            return null;
        }
        if (model.equals("05") || model.equals("5")) {
            return new PozivNaModel_05();
        }
        if (model.equals("11")) {
            return new PozivNaModel_11();
        }
        if (model.equals("12")) {
            return new PozivNaModel_12();
        }

        if (model.equals("21")) {
            return new PozivNaModel_21();
        }
        if (model.equals("22")) {
            return new PozivNaModel_22();
        }
        /*
        if (model.equals("23")) {
            return new PozivNaModel_23();
        }
        if (model.equals("24")) {
            return new PozivNaModel_24();
        }
        if (model.equals("25")) {
            return new PozivNaModel_25();
        }
        if (model.equals("26")) {
            return new PozivNaModel_26();
        }
        if (model.equals("27")) {
            return new PozivNaModel_27();
        }
        if (model.equals("28")) {
            return new PozivNaModel_28();
        }
        if (model.equals("29")) {
            return new PozivNaModel_29();
        }
        if (model.equals("30")) {
            return new PozivNaModel_30();
        }
        if (model.equals("31")) {
            return new PozivNaModel_31();
        }
        if (model.equals("33")) {
            return new PozivNaModel_33();
        }
        if (model.equals("34")) {
            return new PozivNaModel_34();
        }
        if (model.equals("62")) {
            return new PozivNaModel_62();
        }
        if (model.equals("63")) {
            return new PozivNaModel_63();
        }
        if (model.equals("64")) {
            return new PozivNaModel_64();
        }
        if (model.equals("65")) {
            return new PozivNaModel_65();
        }
        if (model.equals("66")) {
            return new PozivNaModel_66();
        }
        if (model.equals("67")) {
            return new PozivNaModel_67();
        }
        if (model.equals("68")) {
            return new PozivNaModel_68();
        }
        */
        return null;

    }
}
