import java.awt.*;

public class Steuerwerk{
  
  //Anfang Attribute
  
  protected static TextField tfBR = new TextField();
  protected static TextField tfBZR = new TextField();
  
  protected static Label lbBR = new Label();
  protected static Label lbBZR = new Label();
  protected static Label lbPlus1 = new Label();
  protected static Label lbOpCode = new Label();
  protected static Label lbAdresse = new Label();
  
  //Ende Attribute
  
  /***************************** Anfang Hilfsmethoden *************************/
  
  public static void reset(){
    tfBR.setText("???");
    tfBZR.setText("000");
  }
  
  /***************************** Ende Hilfsmethoden ***************************/
  
}