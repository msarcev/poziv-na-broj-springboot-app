package pozivi;

/**
 * Created by msarcevic on 17.8.2015..
 */
public interface IPozivNaBroj {
    String msgErrorCode ="";
    Integer model = null;
    String pozivNB = null;
    boolean validatePoziv(String kod);
    String getMsgErrorCode();
}
