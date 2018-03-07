import java.awt.*;
import java.awt.event.*;

/**
  *
  * Beschreibung
  *
  * @ version 1.0 vom 04.03.2018
  * @ Lukas Rang
  */

public class FrmOMRAnw extends Frame {
  
  // Anfang Attribute
  
  private String Datenbus = "1";
  private String zZyklus;
  private String zOpcode;
  private String zAdressierung;
  private int zAdresse;
  private int Adressbus;
   
  private Button btRechnerStart = new Button();
  private Button btRechnerStopp = new Button();
  private Button btZyklus = new Button();
  
  private TextArea taDekodierung = new TextArea("", 1, 1, TextArea.SCROLLBARS_NONE);
  
  private Label lbDekodierung = new Label();        
  
  private TextField tferror = new TextField();
  // Ende Attribute
  
  public FrmOMRAnw(){ 
    // Frame-Initialisierung
    super();
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 960; 
    int frameHeight = 600;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Modellrechner OMR 1.0 (Java)");
    setResizable(false);
    //Panel cp = new Panel(null);
    //add(cp);
    
    // Anfang Komponenten
    
    btRechnerStart.setBounds(10, 456, 135, 30);
    btRechnerStart.setLabel("Rechner Start");
    btRechnerStart.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    btRechnerStart_ActionPerformed(evt);
    }
    });
    
    btRechnerStart.setFont(new Font("Dialog", Font.PLAIN, 16));
    this.add(btRechnerStart);
    btRechnerStart.setFocusable(false);
    
    btRechnerStopp.setBounds(10, 491, 135, 30);
    btRechnerStopp.setLabel("Rechner Stopp");
    btRechnerStopp.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    btRechnerStopp_ActionPerformed(evt);
    }
    });
    
    btRechnerStopp.setFont(new Font("Dialog", Font.PLAIN, 16));
    btRechnerStopp.setEnabled(false);
    this.add(btRechnerStopp);
    btRechnerStopp.setFocusable(false);
    
    btZyklus.setBounds(160, 456, 145, 65);
    btZyklus.setLabel("Befehl Holen");
    btZyklus.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    btZyklus_ActionPerformed(evt);
    }
    });
    
    btZyklus.setFont(new Font("Dialog", Font.PLAIN, 16));
    btZyklus.setEnabled(false);
    this.add(btZyklus);
    btZyklus.setFocusable(false);
    
    Rechenwerk.tfHR.setBounds(50, 70, 120, 30);
    Rechenwerk.tfHR.setFont(new Font("Courier", Font.PLAIN, 20));
    Rechenwerk.tfHR.setEditable(false);
    Rechenwerk.tfHR.setEnabled(true);
    this.add(Rechenwerk.tfHR);
    Rechenwerk.tfHR.setFocusable(false);
    
    Rechenwerk.tfAkku.setBounds(200, 70, 120, 30);
    Rechenwerk.tfAkku.setFont(new Font("Courier", Font.PLAIN, 20));
    Rechenwerk.tfAkku.setEnabled(true);
    Rechenwerk.tfAkku.setEditable(false);
    this.add(Rechenwerk.tfAkku);                                                                              
    Rechenwerk.tfAkku.setFocusable(false);
    
    Rechenwerk.tfALU.setBounds(145, 165, 80, 30);
    Rechenwerk.tfALU.setFont(new Font("Courier", Font.PLAIN, 20));
    Rechenwerk.tfALU.setEnabled(true);
    Rechenwerk.tfALU.setEditable(false);
    this.add(Rechenwerk.tfALU);
    Rechenwerk.tfALU.setFocusable(false);
    
    Rechenwerk.tfNegativeFlag.setBounds(65, 190, 30, 30);
    Rechenwerk.tfNegativeFlag.setFont(new Font("Courier", Font.PLAIN, 20));
    Rechenwerk.tfNegativeFlag.setEnabled(true);
    Rechenwerk.tfNegativeFlag.setEditable(false);
    this.add(Rechenwerk.tfNegativeFlag);
    Rechenwerk.tfNegativeFlag.setFocusable(false);
    
    Rechenwerk.tfZeroFlag.setBounds(30, 190, 30, 30);
    Rechenwerk.tfZeroFlag.setFont(new Font("Courier", Font.PLAIN, 20));
    Rechenwerk.tfZeroFlag.setEditable(false);
    Rechenwerk.tfZeroFlag.setEnabled(true);
    this.add(Rechenwerk.tfZeroFlag);
    Rechenwerk.tfZeroFlag.setFocusable(false);
    
    Rechenwerk.lbHR.setBounds(50, 35, 72, 30);
    Rechenwerk.lbHR.setText("HR");
    Rechenwerk.lbHR.setAlignment(Label.CENTER);
    Rechenwerk.lbHR.setFont(new Font("Courier", Font.PLAIN, 13));
    Rechenwerk.lbHR.setBackground(Color.yellow);
    this.add(Rechenwerk.lbHR);
    
    Rechenwerk.lbAkku.setBounds(200, 35, 60, 30);
    Rechenwerk.lbAkku.setText("Akku");
    Rechenwerk.lbAkku.setFont(new Font("Courier", Font.PLAIN, 13));
    Rechenwerk.lbAkku.setAlignment(Label.CENTER);
    Rechenwerk.lbAkku.setBackground(Color.yellow);
    this.add(Rechenwerk.lbAkku);
    
    Rechenwerk.lbALU.setBounds(165, 200, 60, 30);
    Rechenwerk.lbALU.setText("ALU");
    Rechenwerk.lbALU.setFont(new Font("Courier", Font.PLAIN, 13));
    Rechenwerk.lbALU.setAlignment(Label.CENTER);
    Rechenwerk.lbALU.setBackground(Color.yellow);
    this.add(Rechenwerk.lbALU);
    
    Rechenwerk.lbZeroFlag.setBounds(30, 155, 30, 30);
    Rechenwerk.lbZeroFlag.setText("Z");
    Rechenwerk.lbZeroFlag.setAlignment(Label.CENTER);
    Rechenwerk.lbZeroFlag.setFont(new Font("Courier", Font.BOLD, 14));
    Rechenwerk.lbZeroFlag.setBackground(Color.YELLOW);
    this.add(Rechenwerk.lbZeroFlag);
    
    Rechenwerk.lbNegativeFlag.setBounds(65, 155, 30, 30);
    Rechenwerk.lbNegativeFlag.setText("N");
    Rechenwerk.lbNegativeFlag.setAlignment(Label.CENTER);
    Rechenwerk.lbNegativeFlag.setFont(new Font("Courier", Font.BOLD, 14));
    Rechenwerk.lbNegativeFlag.setBackground(Color.yellow);
    this.add(Rechenwerk.lbNegativeFlag);
    
    Steuerwerk.tfBR.setBounds(384, 70, 185, 30);
    Steuerwerk.tfBR.setFont(new Font("Courier", Font.PLAIN, 20));
    Steuerwerk.tfBR.setEditable(false);
    Steuerwerk.tfBR.setEnabled(true);  
    this.add(Steuerwerk.tfBR);
    
    Steuerwerk.tfBZR.setBounds(450, 275, 120, 30);
    Steuerwerk.tfBZR.setFont(new Font("Courier", Font.PLAIN, 20));
    Steuerwerk.tfBZR.setEditable(false);
    Steuerwerk.tfBZR.setEnabled(true);
    this.add(Steuerwerk.tfBZR);
    Steuerwerk.tfBZR.setFocusable(false);
    
    Steuerwerk.lbBR.setBounds(385, 35, 30, 30);
    Steuerwerk.lbBR.setText("BR");
    Steuerwerk.lbBR.setFont(new Font("Courier", Font.BOLD, 14));
    Steuerwerk.lbBR.setAlignment(Label.CENTER);
    Steuerwerk.lbBR.setBackground(Color.green);
    this.add(Steuerwerk.lbBR);
    Steuerwerk.tfBR.setFocusable(false);
    
    Steuerwerk.lbBZR.setBounds(450, 240, 30, 30);
    Steuerwerk.lbBZR.setText("BZR");
    Steuerwerk.lbBZR.setAlignment(Label.CENTER);
    Steuerwerk.lbBZR.setFont(new Font("Courier", Font.BOLD, 14));
    Steuerwerk.lbBZR.setBackground(Color.green);
    this.add(Steuerwerk.lbBZR);
    
    Steuerwerk.lbPlus1.setBounds(575, 275, 30, 30);
    Steuerwerk.lbPlus1.setText("+1");
    Steuerwerk.lbPlus1.setFont(new Font("Courier", Font.BOLD, 14));
    Steuerwerk.lbPlus1.setAlignment(Label.CENTER);
    Steuerwerk.lbPlus1.setBackground(Color.green);
    this.add(Steuerwerk.lbPlus1);
    
    Steuerwerk.lbOpCode.setBounds(385, 105, 60, 30);
    Steuerwerk.lbOpCode.setText("OpCode");
    Steuerwerk.lbOpCode.setFont(new Font("Courier", Font.PLAIN, 13));
    Steuerwerk.lbOpCode.setAlignment(Label.CENTER);
    Steuerwerk.lbOpCode.setBackground(Color.green);
    this.add(Steuerwerk.lbOpCode);
    
    Steuerwerk.lbAdresse.setBounds(505, 105, 60, 30);
    Steuerwerk.lbAdresse.setText("Adresse");
    Steuerwerk.lbAdresse.setFont(new Font("Courier", Font.PLAIN, 13));
    Steuerwerk.lbAdresse.setAlignment(Label.CENTER);
    Steuerwerk.lbAdresse.setBackground(Color.green);
    this.add(Steuerwerk.lbAdresse);
    
    Speicherwerk.tfSR.setBounds(725, 70, 120, 30);
    Speicherwerk.tfSR.setFont(new Font("Courier", Font.PLAIN, 20));
    Speicherwerk.tfSR.setEditable(false);
    Speicherwerk.tfSR.setEnabled(true);
    this.add(Speicherwerk.tfSR);
    
    Speicherwerk.tfSAR.setBounds(650, 360, 120, 30);
    Speicherwerk.tfSAR.setFont(new Font("Courier", Font.PLAIN, 20));
    Speicherwerk.tfSAR.setEditable(false);
    Speicherwerk.tfSAR.setEnabled(true);
    this.add(Speicherwerk.tfSAR);
    
    Speicherwerk.taBefehlFenster.setFont(new Font("Courier", Font.PLAIN, 20));
    Speicherwerk.taBefehlFenster.setBounds(710, 110, 155, 207);
    Speicherwerk.taBefehlFenster.setEnabled(true);
    Speicherwerk.taBefehlFenster.setEditable(false);
    this.add(Speicherwerk.taBefehlFenster);
    
    Speicherwerk.lbSR.setBounds(725, 35, 30, 30);
    Speicherwerk.lbSR.setText("SR");
    Speicherwerk.lbSR.setAlignment(Label.CENTER);
    Speicherwerk.lbSR.setFont(new Font("Courier", Font.BOLD, 14));
    Speicherwerk.lbSR.setBackground(Color.cyan);
    this.add(Speicherwerk.lbSR);
    Speicherwerk.tfSR.setFocusable(false);
    
    Speicherwerk.lbSAR.setBounds(735, 325, 32, 30);
    Speicherwerk.lbSAR.setText("SAR");
    Speicherwerk.lbSAR.setAlignment(Label.CENTER);
    Speicherwerk.lbSAR.setFont(new Font("Courier", Font.BOLD, 14));
    Speicherwerk.lbSAR.setBackground(Color.cyan);
    this.add(Speicherwerk.lbSAR);
    Speicherwerk.tfSAR.setFocusable(false);
    
    IOWerk.tfeingabeRegister.setBounds(650, 456, 120, 30);
    IOWerk.tfeingabeRegister.setFont(new Font("Courier", Font.PLAIN, 20));
    this.add(IOWerk.tfeingabeRegister);
    
    IOWerk.tfausgabeRegister.setBounds(800, 456, 120, 30);
    IOWerk.tfausgabeRegister.setFont(new Font("Courier", Font.PLAIN, 20));
    IOWerk.tfausgabeRegister.setEditable(false);
    this.add(IOWerk.tfausgabeRegister);
    IOWerk.tfausgabeRegister.setFocusable(false);
    
    IOWerk.lbEingaberegister.setBounds(650, 494, 120, 30);
    IOWerk.lbEingaberegister.setText("Eingaberegister");
    IOWerk.lbEingaberegister.setFont(new Font("Courier", Font.PLAIN, 13));
    IOWerk.lbEingaberegister.setAlignment(Label.CENTER);
    IOWerk.lbEingaberegister.setBackground(Color.red);
    this.add(IOWerk.lbEingaberegister);
    
    IOWerk.lbAusgaberegister.setBounds(800, 494, 120, 30);
    IOWerk.lbAusgaberegister.setText("Ausgaberegister");
    IOWerk.lbAusgaberegister.setFont(new Font("Courier", Font.PLAIN, 13));
    IOWerk.lbAusgaberegister.setAlignment(Label.CENTER);
    IOWerk.lbAusgaberegister.setBackground(Color.red);
    this.add(IOWerk.lbAusgaberegister);
    
    IOWerk.lbER.setBounds(650, 421, 30, 30);
    IOWerk.lbER.setText("ER");
    IOWerk.lbER.setFont(new Font("Courier", Font.BOLD, 14));
    IOWerk.lbER.setAlignment(Label.CENTER);
    IOWerk.lbER.setBackground(Color.red);
    this.add(IOWerk.lbER);
    
    IOWerk.lbAR.setBounds(800, 421, 30, 30);
    IOWerk.lbAR.setText("AR");
    IOWerk.lbAR.setFont(new Font("Courier", Font.BOLD, 14));
    IOWerk.lbAR.setAlignment(Label.CENTER);
    IOWerk.lbAR.setBackground(Color.red);
    this.add(IOWerk.lbAR);
    
    lbDekodierung.setBounds(320, 419, 120, 30);
    lbDekodierung.setText("Dekodierung");
    lbDekodierung.setAlignment(Label.CENTER);
    lbDekodierung.setFont(new Font("Courier", Font.PLAIN, 13));
    lbDekodierung.setEnabled(true);
    this.add(lbDekodierung);
    
    taDekodierung.setBounds(320, 456, 275, 65);
    taDekodierung.setEditable(false);
    taDekodierung.setEnabled(false);
    this.add(taDekodierung);
    
    tferror.setBounds(321, 530, 275, 35);
    tferror.setEnabled(false);
    tferror.setEditable(false);
    tferror.setFont(new Font("Courier", Font.BOLD, 18));
    this.add(tferror);
    
    // Ende Komponenten
    
    this.setLayout(null);
    setVisible(true);
    
  } // end of public VonNeumannProjekt
    
  // Anfang Methoden
    
  /***************************** Anfang Hilfsmethoden *************************/
  
  public void reset(){
    Rechenwerk.reset();  
    Steuerwerk.reset();  
    Speicherwerk.reset();  
    IOWerk.reset(); 
  }
    
  /***************************** Ende Hilfsmethoden ***************************/
    
  /***************************** Anfang Ereignissteuerung *********************/
  
  public void rechnerStart(){
    btRechnerStart.setEnabled(false); // verhindert das man den "Rechner Start" Knopf mehrmals hintereinander drücken kann.
    btRechnerStopp.setEnabled(true);
    btZyklus.setEnabled(true);
    reset();
    Speicherwerk.speicherInitialisieren();
    Speicherwerk.taBefehlFenster.setCaretPosition(0); // scrollt im textarea nach oben
    tferror.setText("Keine Fehler gefunden");
  }
  
  public void rechnerStopp(){
    btRechnerStart.setEnabled(true);                                                          
    btRechnerStopp.setEnabled(false);
    btZyklus.setEnabled(false);
    btZyklus.setLabel("Befehl Holen");
  }   
  
  public void mainZyklus(){
    String Speicherinhalt = "";
    String str = "";
    if(btZyklus.getLabel().equals("Befehl Holen") == true){                     /*Befehl Holen*/
      // BZR -> SAR
      zAdresse = Steuerwerk.GetBZR();                                      
      Speicherwerk.SetSAR(zAdresse);;
      
      // Speicher SAR -> BR
      str = Speicherwerk.SetSR("lesen", "");  
      Speicherinhalt = Speicherwerk.GetSR();
      Steuerwerk.tfBR.setText(Speicherinhalt);
      ;
      Steuerwerk.IncrementBZR();
      taDekodierung.setText(""); // MemDekodierung.Clear 
      btZyklus.setLabel("Befehl Dekodieren");
    }
    else{
      if(btZyklus.getLabel().equals("Befehl Dekodieren") == true){              /*Befehl Dekodieren*/
        Speicherinhalt = Steuerwerk.GetBR();
        // Datenbus ?                                          
        // Befehl
        zOpcode = Speicherinhalt.substring(4,8);
        // tferror.setText(zOpcode);    //zum testen
        // Adressierungsart + Adresse
        if(zOpcode.charAt(3) == '_'){
          zAdressierung = "absolut";
          zAdresse = Integer.parseInt(Speicherinhalt.substring(5, Speicherinhalt.length()-4));
        }
        else {
          
          if(zOpcode.charAt(3) == '#'){
            zAdressierung = "unmittelbar";
            zAdresse = Integer.parseInt(Speicherinhalt.substring(5, Speicherinhalt.length()-4));
          }
          else if(zOpcode.charAt(3) == 'D' ||
          zOpcode.charAt(3) == 'T' ||
          zOpcode.charAt(3) == 'd' ||
          zOpcode.charAt(3) == 't' ){
            zAdressierung = "Register";
            zAdresse = -1;
          }
          else{
            if(zOpcode.charAt(3) == 'P' ||
            zOpcode.charAt(3) == 'p' ){
              zAdressierung = "Keine";
              zAdresse = -1;
            }
            // Anzeige
            taDekodierung.append("Befehl: " + zOpcode);
            taDekodierung.append("Adressierung: " + zAdressierung);
            if(zAdresse == -1){
              taDekodierung.append("Adresse/Wert: ---");
            }
            else{
              taDekodierung.append("Adresse/Wert: " + zAdresse);
            }
          }
        }  
        btZyklus.setLabel("Befehl Ausführen"); 
      }
      else{
        if(btZyklus.getLabel().equals("Befehl Ausführen") == true){             /*Befehl Ausführen*/
          //Befehl ausführen
          if(zOpcode.equals("")){
            tferror.setText("Keinen Befehl gefunden");
            // Ohne dieses If würde der Rechner zusätzliche Errors bekommen bei leeren Zeilen
          }
          else if(zOpcode.equals("STOP")){                                /*STOP*/
            // Takt deaktivieren
            rechnerStopp();
          }
          else if(zOpcode.equals("NOOP")){                                /*NOOP*/
            // NOOP = No Operation
          }
          else if(zOpcode.equals("READ")){                                /*READ*/
            Rechenwerk.SetAkku(IOWerk.GetER());
          }
          else if(zOpcode.equals("WRIT")){                                /*WRIT*/
            IOWerk.SetAR(Rechenwerk.GetAkku());
          }
          else if(zOpcode.equals("LDA_")){                                /*LDA_*/
            Speicherwerk.SetSAR(zAdresse);
            Speicherwerk.SetSR("lesen", "");
            Datenbus = Speicherwerk.GetSR();
            Rechenwerk.SetAkku(Integer.parseInt(Datenbus));
          }
          else if(zOpcode.equals("LDA#")){                                /*LDA#*/   
            Rechenwerk.SetAkku(zAdresse);
          }
          else if(zOpcode.equals("STO_")){                                /*STO_*/      
            Speicherwerk.SetSAR(zAdresse);
            //Speicherwerk.SetSR("schreiben", (Rechenwerk.GetAkku()));
          }
          else if(zOpcode.equals("ADD_")){                                /*ADD_*/        
            Speicherwerk.SetSAR(zAdresse);
            Speicherwerk.SetSR("lesen","");
            Datenbus = Speicherwerk.GetSR();
            Rechenwerk.SetHR(Integer.parseInt(Datenbus));
            Rechenwerk.SetALU("+");
            Rechenwerk.SetAkku(Rechenwerk.GetALU());
          }
          else if(zOpcode.equals("SUB_")){                                /*SUB_*/
            Speicherwerk.SetSAR(zAdresse);
            Speicherwerk.SetSR("lesen", "");
            Datenbus = Speicherwerk.GetSR();
            Rechenwerk.SetHR(Integer.parseInt(Datenbus));
            Rechenwerk.SetALU("-");
            Rechenwerk.SetAkku(Rechenwerk.GetALU());
          }
          else if(zOpcode.equals("MUL_")){                                /*MUL_*/       
            Speicherwerk.SetSAR(zAdresse);
            Speicherwerk.SetSR("lesen", "");
            Datenbus = Speicherwerk.GetSR();
            Rechenwerk.SetHR(Integer.parseInt(Datenbus));
            Rechenwerk.SetALU("*");
            Rechenwerk.SetAkku(Rechenwerk.GetALU());
          }
          else if(zOpcode.equals("DIV_")){                                /*DIV_*/
            Speicherwerk.SetSAR(zAdresse);
            Speicherwerk.SetSR("lesen", "");
            Datenbus = Speicherwerk.GetSR();
            Rechenwerk.SetHR(Integer.parseInt(Datenbus));
            Rechenwerk.SetALU("/");
            Rechenwerk.SetAkku(Rechenwerk.GetALU());
          }
          else if(zOpcode.equals("MOD_")){                                /*MOD_*/
            Speicherwerk.SetSAR(zAdresse);
            Speicherwerk.SetSR("lesen", "");
            Datenbus = Speicherwerk.GetSR();
            Rechenwerk.SetHR(Integer.parseInt(Datenbus));
            Rechenwerk.SetALU("mod");
            Rechenwerk.SetAkku(Rechenwerk.GetALU());
          }
          else if(zOpcode.equals("JMP_")){                                /*JMP_*/
            Steuerwerk.SetBZR(zAdresse);
          }
          else if(zOpcode.equals("CMP_")){                                /*CMP_*/
            Speicherwerk.SetSAR(zAdresse);
            Speicherwerk.SetSR("lesen", "");
            Datenbus = Speicherwerk.GetSR();
            Rechenwerk.SetHR(Integer.parseInt(Datenbus));
            Rechenwerk.SetALU("-");
            //Rechenwerk.SetAkku(Rechenwerk.GetALU());                                   
          }                                            
          else if(zOpcode.equals("BZE_")){                                /*BZE_*/
            if(Rechenwerk.GetZeroFlag() == 1){
              Steuerwerk.SetBZR(zAdresse);
            }
          }
          else if(zOpcode.equals("BPL_")){                                /*BPL_*/
            if(Rechenwerk.GetZeroFlag() == 1 && Rechenwerk.GetNegativeFlag() == 0 ){
              Steuerwerk.SetBZR(zAdresse);
            }
          }
          else if(zOpcode.equals("BNE_")){                                /*BNE_*/
            if(Rechenwerk.GetNegativeFlag() == 1){
              Steuerwerk.SetBZR(zAdresse);     
            }       
          }
          else{
            tferror.setText("Ungültiger Befehl gefunden");
          }
          btZyklus.setLabel("Befehl Holen");
        }
        else{
          tferror.setText("Ungültige Phase");
        }                                      
      }
    }
  }
    
    /***************************** Ende Ereignissteurung ************************/
    
  public void hintergrunderstellen(Graphics g){
    // Rechenwerk
    g.setColor(Color.black);
    g.drawRect(20, 30, 325, 380);
    g.setColor(Color.yellow);
    g.fillRect(21, 31, 324, 379);
    
    // Steuerwerk
    g.setColor(Color.black);
    g.drawRect(350, 30, 285, 380);
    g.setColor(Color.green);
    g.fillRect(351, 31, 284, 379);
    
    // Speicherwerk
    g.setColor(Color.black);
    g.drawRect(640, 30, 300, 380);
    g.setColor(Color.cyan);
    g.fillRect(641, 31, 299, 379);
    
    // IOWerk
    g.setColor(Color.black);
    g.drawRect(640, 415, 300, 165);
    g.setColor(Color.red);
    g.fillRect(641, 416, 299, 164);
  }
    
  public void btRechnerStart_ActionPerformed(ActionEvent evt) {
    rechnerStart();
  } // end of btRechnerStart_ActionPerformed
    
  public void btRechnerStopp_ActionPerformed(ActionEvent evt) {
    rechnerStopp();
  } // end of btRechnerStopp_ActionPerformed
    
  public void btZyklus_ActionPerformed(ActionEvent evt) {
    mainZyklus();
  } // end of btZyklus_ActionPerformed 
    
  public void paint(Graphics g){
    hintergrunderstellen(g);
  }
    
  public static void main(String[] args) {
    new FrmOMRAnw();
  } 
    
    // Ende Methoden
    
} // end of class VonNeumannProjekt  