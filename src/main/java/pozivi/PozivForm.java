package pozivi;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by msarcevic on 17.8.2015..
 */
public class PozivForm {
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPozivNB() {
        return pozivNB;
    }

    public void setPozivNB(String pozivNB) {
        this.pozivNB = pozivNB;
    }

    @NotNull
    @Size (max = 5)
    private String model ;
    @NotNull
    private String pozivNB;

}
