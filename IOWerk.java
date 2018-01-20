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
    tfeingabeRegister.setText("0");
    tfausgabeRegister.setText("0");
  }
   
}