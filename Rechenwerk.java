import java.awt.*;

public class Rechenwerk{
  
  //Anfang Attribute
  
  protected static TextField tfHR = new TextField();
  protected static TextField tfAkku = new TextField();
  protected static TextField tfALU = new TextField();
  protected static TextField tfN = new TextField();
  protected static TextField tfZ = new TextField();
  
  protected static Label lbHR = new Label();
  protected static Label lbAkku = new Label();
  protected static Label lbALU = new Label();
  protected static Label lbZ = new Label();
  protected static Label lbN = new Label();
  
  //Ende Attribute
  
  /***************************** Anfang Hilfsmethoden *************************/
  
  public static void reset(){
    tfHR.setText("???");
    tfAkku.setText("???");
    tfALU.setText("0");
    tfN.setText("0");
    tfZ.setText("0");
  }
  
  /***************************** Ende Hilfsmethoden ***************************/

}