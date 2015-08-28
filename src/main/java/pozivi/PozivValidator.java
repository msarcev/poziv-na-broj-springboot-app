package pozivi;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import pozivi.poziviNaModel.PozivNaModel;

/**
 * Created by msarcevic on 19.8.2015..
 */
public class PozivValidator implements Validator {

    private IsNumeric num = new IsNumeric();

    @Override
    public boolean supports(Class aClass) {
        return PozivNaModel.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        PozivFactory fact = new PozivFactory();

        PozivForm pozivForm = (PozivForm) o;
        String model = pozivForm.getModel();
        String pozNB = pozivForm.getPozivNB();

        if(model.equals("")) errors.rejectValue("model","model.null");
        else if(!num.isNumeric(model)) errors.rejectValue("model","model.not.number");
        else if (model.equals("05") || model.equals("5")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("11")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("12")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("21")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("22")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("23")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("24")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("25")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("26")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("27")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("28")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("28")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("30")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("31")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("33")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("34")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("62")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("63")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("64")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("65")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("66")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("67")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else if (model.equals("68")){
            PozivNaModel poz = fact.odaberiPoziv(model);
            if (!poz.validatePoziv(pozNB)) errors.rejectValue("pozivNB", poz.getMsgErrorCode());
        }
        else errors.rejectValue("model","model.nepoznat.error");
    }
}
