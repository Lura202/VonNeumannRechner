import java.awt.*;

public class Rechenwerk{
  
  //Anfang Attribute
  
  protected static TextField tfHR = new TextField();
  protected static TextField tfAkku = new TextField();
  protected static TextField tfALU = new TextField();
  protected static TextField tfNegativeFlag = new TextField();   // NegativeFlag
  protected static TextField tfZeroFlag = new TextField();   // ZeroFlag
  
  protected static Label lbHR = new Label();
  protected static Label lbAkku = new Label();
  protected static Label lbALU = new Label();
  protected static Label lbZeroFlag = new Label();
  protected static Label lbNegativeFlag = new Label();
  
  private static int zInternerDatenbus;
  
  //Ende Attribute
  
  public static void reset(){
    tfHR.setText("???");
    tfAkku.setText("???");
    tfALU.setText("0");
    tfNegativeFlag.setText("0");
    tfZeroFlag.setText("0");
  }
  
  public static void SetAkku(int i){
    tfAkku.setText("" + i);
  }
  
  public static int GetAkku(){
    int wert = Integer.parseInt(tfAkku.getText());
    return wert;
  }
  
  public static void SetHR(int wert){
    tfHR.setText("" + wert);
  }
  
  public static int GetHR(){
    int wert = Integer.parseInt(tfHR.getText());
    return wert;
  }
  
  public static void SetALU(String Operation){
    if (Operation == "+") {
      tfALU.setText(" +");
      zInternerDatenbus = Integer.parseInt(tfAkku.getText()) + Integer.parseInt(tfHR.getText()) % 4069;
    }
    else {
      if (Operation == "-") {
        tfALU.setText(" -");
        zInternerDatenbus = Integer.parseInt(tfAkku.getText()) - Integer.parseInt(tfHR.getText());
        if (zInternerDatenbus < 0) {
          zInternerDatenbus = zInternerDatenbus + 4069;
        } 
      }
      else {
        if (Operation == "*") {
          tfALU.setText(" *");
          zInternerDatenbus = Integer.parseInt(tfAkku.getText()) * Integer.parseInt(tfHR.getText()) % 4069;
        } 
        else {
          if (Operation == "/") {
            tfALU.setText(" /");
            zInternerDatenbus = Integer.parseInt(tfAkku.getText()) / Integer.parseInt(tfHR.getText());
          } 
          else {
            if (Operation == "mod") {
              tfALU.setText(" mod");
              zInternerDatenbus = Integer.parseInt(tfAkku.getText()) % Integer.parseInt(tfHR.getText());
            } 
            else {
              tfALU.setText("???");
              zInternerDatenbus = 0; 
            }
            if (zInternerDatenbus == 0) {
              tfZeroFlag.setText("1");
              tfNegativeFlag.setText("0");
            }
            else {
              if (zInternerDatenbus < 0) {
                tfZeroFlag.setText("0");
                tfNegativeFlag.setText("1");
              } 
              else {
                if (zInternerDatenbus > 0) {
                  tfZeroFlag.setText("0");
                  tfNegativeFlag.setText("0");
                } 
              } 
            } 
          } 
        } 
      } 
    } 
  } 
  
    
  public static int GetALU(){
    int wert = zInternerDatenbus;
    return wert;
  }
    
  public static int GetZeroFlag(){
    if (tfZeroFlag.getText() == "1") {
      return 1;
    }
    else {
      return 0;
    }
  }
    
  public static int GetNegativeFlag(){
    if(tfNegativeFlag.getText() == "1") {
      return 1;
    }
    else{
      return 0;
    }
  }
    
}