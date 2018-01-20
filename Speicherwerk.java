import java.awt.*;
  
public class Speicherwerk{
  
  //Anfang Attribute
  
  protected static TextField tfSR = new TextField();
  protected static TextField tfSAR = new TextField();
  
  protected static Label lbSR = new Label();
  protected static Label lbSAR = new Label();
  
  protected static TextArea taBefehlFenster = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  
  static int i = 0;
  
  //Ende Attribute
  
  public static void reset(){
    tfSR.setText("???");
    tfSAR.setText("???");
    
    if(i == 0){
      taBefehlFenster.append("000" + "\n" );
      taBefehlFenster.append("001" + "\n" );
      taBefehlFenster.append("002" + "\n" );
      taBefehlFenster.append("003" + "\n" );
      taBefehlFenster.append("004" + "\n" );
      taBefehlFenster.append("005" + "\n" );
      i = i +1;
    }
  }
  
  public static void SetSAR(int i){
    String str = "" + i + 0 + 0;
    tfSAR.setText(str);
  }

  public static void SetSR(String readwrite, String str){
    if(readwrite.equals("lesen")){
      
    }
  }
  
}