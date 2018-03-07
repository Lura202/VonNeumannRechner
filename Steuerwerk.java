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
    String str = "";
    for (int i = 0; i < 256; i = i+1) {
      str = Speicherwerk.getBefehl(i);
    }
    tfBZR.setText(str.substring(0,3)); 
  }
    
}