import java.awt.*;
  
public class Speicherwerk{
  
  //Anfang Attribute
  
  protected static TextField tfSR = new TextField();
  protected static TextField tfSAR = new TextField();
  
  protected static Label lbSR = new Label();
  protected static Label lbSAR = new Label();
  
  protected static TextArea taBefehlFenster = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  
  private static String[] speicher = new String[256];  
  
  private static String newline = "\n";
  
  //Ende Attribute
  
  public static void reset(){
    tfSR.setText("???");
    tfSAR.setText("???");
  }
  
  public static void speicherInitialisieren(){
    speicher[0] = "000 READ"; 
    speicher[1] = "001 STA_ 11"; 
    speicher[2] = "002 READ";
    speicher[3] = "003 STA_ 12"; 
    speicher[4] = "004 LDA_ 8"; 
    speicher[5] = "005 ADD_ 9"; 
    speicher[6] = "006 STA_ 13";
    speicher[7] = "007 LDA_ 13";
    speicher[8] = "008 WRIT";
    speicher[9] = "009 STOP";
    speicher[10] = "???";
    speicher[11] = "011 4";
    speicher[12] = "012 5";
    speicher[13] = "013 9";
    
    for (int i = 14; i < 256; i = i+1) {
      speicher[i] = "??? ???? ?";
    }
    
    for (int o = 0; o < 256; o = o+1) {       // musste o statt i benutzen, da i in dieser methode schon benutzt worden ist.
      taBefehlFenster.append(speicher[o] + newline);
    }
  }
  
  public static String getBefehl(int befehlsNummer){
    String str = "";
    str = speicher[befehlsNummer];
    tfSR.setText(str); 
    return str;
  }
  
  public static void SetSAR(int i){
    String str = "";
    str = getBefehl(i);
    tfSAR.setText(str.substring(0,3));
  }
  
  public static String SetSR(String readwrite, String wert){
    String Inhalt = "";
    int Speicherzelle = 0;
    if(readwrite.equals("lesen")){
      int i = Steuerwerk.GetBZR();
      Inhalt = getBefehl(i);
      
      //Inhalt = taBefehlFenster.getText().split("\\n");
      // Speicheradresse herausfiltern
      //Inhalt = Speicher;
      //taBefehlFenster.setText(Speicher); 
      //tfSR.setText();
    }
    else if(readwrite.equals("schreiben")){
      Speicherzelle = Integer.parseInt(lbSAR.getText());
      wert = lbSR.getText();
      //Inhalt = 
    }
    else{
      lbSR.setText("???");
    }
    return Inhalt;
  }
  
    
  public static String GetSR(){
    String str = tfSR.getText();
    return str;
  }
  
}