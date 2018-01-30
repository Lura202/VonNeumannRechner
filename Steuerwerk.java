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
  
  public static void SetBR(String Befehl){
    // Speicheradresse herausfiltern
    tfBR.setText(Befehl);
  }
  
  public static void SetBZR(int Adresse){
    tfBZR.setText("" + Adresse);
  }
  
  public static String GetBR(){
    return tfBR.getText();
  }
  
  public static int GetBZR(){
    return Integer.parseInt(tfBZR.getText());
  }
  
  public static void IncrementBZR(){
    int NaechsterBefehl;
    NaechsterBefehl = (Integer.parseInt(tfBZR.getText()) + 1) % 256;
    tfBZR.setText("0" + NaechsterBefehl);
  }
  
}