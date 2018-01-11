import java.awt.*;
  
public class Speicherwerk{
  
  //Anfang Attribute
  
  protected static TextField tfSR = new TextField();
  protected static TextField tfSAR = new TextField();
  
  protected static Label lbSR = new Label();
  protected static Label lbSAR = new Label();
  
  protected static TextArea taBefehlFenster = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  
  //Ende Attribute
  
  /***************************** Anfang Hilfsmethoden *************************/
  
  public static void reset(){
    tfSR.setText("???");
    tfSAR.setText("???");
  }
  
  /***************************** Ende Hilfsmethoden ***************************/
  
  /*
  public static void SetSAR(int i){
    String str = "" + i + 0 + 0;
    FrmOMRAnw.tfSAR.setText(str);
  }
  */
  
}