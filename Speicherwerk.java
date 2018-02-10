import java.awt.*;
  
public class Speicherwerk{
  
  //Anfang Attribute
  
  protected static TextField tfSR = new TextField();
  protected static TextField tfSAR = new TextField();
  
  protected static Label lbSR = new Label();
  protected static Label lbSAR = new Label();
  
  protected static TextArea taBefehlFenster = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  
  //Ende Attribute
  
  public static void reset(){
    tfSR.setText("???");
    tfSAR.setText("???");
  }
  
  public static void SetSAR(int i){
    String str = "" + i + 0 + 0;
    tfSAR.setText(str);
  }

  public static void SetSR(String readwrite, String wert){
    String Inhalt;
    int Speicherzelle = 0;
    if(readwrite.equals("lesen")){
      //Inhalt = taBefehlFenster.getText().split("\\n");
      // Speicheradresse herausfiltern
      //tfSR.setText();
    }
    else{
      if(readwrite.equals("schreiben")){
        Speicherzelle = Integer.parseInt(lbSAR.getText());
        wert = lbSR.getText();
        //Inhalt = 
        
      }
      else{
        lbSR.setText("???");
      }
    }
  }
  
  public static String GetSR(){
    String str = tfSR.getText();
    return str;
  }
  
}