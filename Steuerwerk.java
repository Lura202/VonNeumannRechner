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
   
  public static void reset(){
    tfBR.setText("???");
    tfBZR.setText("000");
  }
  
  public static void IncrementBZR(){
    int NaechsterBefehl = 0;
    String str = "";
    NaechsterBefehl =  Integer.parseInt(lbBZR.getText() + 1 );
    lbBZR.setText(str = str + NaechsterBefehl);
  }
  
  
  
}