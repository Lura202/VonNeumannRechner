import java.awt.*;

public class IOWerk{
  
  //Anfang Attribute
  
  protected static TextField tfeingabeRegister = new TextField();
  protected static TextField tfausgabeRegister = new TextField();
  
  protected static Label lbEingaberegister = new Label();
  protected static Label lbAusgaberegister = new Label();
  protected static Label lbER = new Label();
  protected static Label lbAR = new Label();
  
  //Ende Attribute
  
  public static void reset(){
    tfeingabeRegister.setText("");
    tfausgabeRegister.setText("???");
  }
  
  public static void SetAR(int Wert){
    tfausgabeRegister.setText("" + Wert);
  }
  
  public static void SetER(int Wert){
    tfeingabeRegister.setText("" + Wert);
  }
  
  public static int GetER(){
    String Eingabe;
    Eingabe = tfeingabeRegister.getText();
    return Integer.parseInt(Eingabe);
  }
   
}