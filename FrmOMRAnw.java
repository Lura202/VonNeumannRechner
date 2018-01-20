import java.awt.*;
import java.awt.event.*;

/**
  *
  * Beschreibung
  *
  * @version 0.3 vom 06.01.2018
  * @Lukas Rang
  */

public class FrmOMRAnw extends Frame {
  
  // Anfang Attribute
  
  private String Datenbus;
  private int Adressbus;
  private String zZyklus;
  private String zOpcode;
  private int zAdresse;
   
  private Button btRechnerStart = new Button();
  private Button btRechnerStopp = new Button();
  private Button btZyklus = new Button();
  
  private TextField tfDekodierung = new TextField();
  
  private Label lbDekodierung = new Label();
  
  // Ende Attribute
  
  public FrmOMRAnw(){ 
    // Frame-Initialisierung
    super();
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 950; 
    int frameHeight = 600;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("Modellrechner OMR 1.0 (Java)");
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    
    btRechnerStart.setBounds(25, 432, 120, 30);
    btRechnerStart.setLabel("Rechner Start");
    btRechnerStart.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    btRechnerStart_ActionPerformed(evt);
    }
    });
    
    btRechnerStart.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(btRechnerStart);
    btRechnerStart.setFocusable(false);
    
    btRechnerStopp.setBounds(25, 467, 120, 30);
    btRechnerStopp.setLabel("Rechner Stopp");
    btRechnerStopp.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    btRechnerStopp_ActionPerformed(evt);
    }
    });
    
    btRechnerStopp.setFont(new Font("Dialog", Font.PLAIN, 16));
    btRechnerStopp.setEnabled(false);
    cp.add(btRechnerStopp);
    btRechnerStopp.setFocusable(false);
    
    btZyklus.setBounds(160, 432, 145, 65);
    btZyklus.setLabel("Befehl holen");
    btZyklus.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    btZyklus_ActionPerformed(evt);
    }
    });
    
    btZyklus.setFont(new Font("Dialog", Font.PLAIN, 16));
    btZyklus.setEnabled(false);
    cp.add(btZyklus);
    btZyklus.setFocusable(false);
   
    Rechenwerk.tfHR.setBounds(50, 70, 120, 30);
    Rechenwerk.tfHR.setFont(new Font("Dialog", Font.PLAIN, 20));
    Rechenwerk.tfHR.setEditable(false);
    Rechenwerk.tfHR.setEnabled(true);
    cp.add(Rechenwerk.tfHR);
    Rechenwerk.tfHR.setFocusable(false);
    
    Rechenwerk.tfAkku.setBounds(200, 70, 120, 30);
    Rechenwerk.tfAkku.setFont(new Font("Dialog", Font.PLAIN, 20));
    Rechenwerk.tfAkku.setEnabled(true);
    Rechenwerk.tfAkku.setEditable(false);
    cp.add(Rechenwerk.tfAkku);                                                                              
    Rechenwerk.tfAkku.setFocusable(false);
    
    Rechenwerk.tfALU.setBounds(145, 165, 80, 30);
    Rechenwerk.tfALU.setFont(new Font("Dialog", Font.PLAIN, 20));
    Rechenwerk.tfALU.setEnabled(true);
    Rechenwerk.tfALU.setEditable(false);
    cp.add(Rechenwerk.tfALU);
    Rechenwerk.tfALU.setFocusable(false);
    
    Rechenwerk.tfN.setBounds(65, 190, 30, 30);
    Rechenwerk.tfN.setFont(new Font("Dialog", Font.PLAIN, 20));
    Rechenwerk.tfN.setEnabled(true);
    Rechenwerk.tfN.setEditable(false);
    cp.add(Rechenwerk.tfN);
    Rechenwerk.tfN.setFocusable(false);
    
    Rechenwerk.tfZ.setBounds(30, 190, 30, 30);
    Rechenwerk.tfZ.setFont(new Font("Dialog", Font.PLAIN, 20));
    Rechenwerk.tfZ.setEditable(false);
    Rechenwerk.tfZ.setEnabled(true);
    cp.add(Rechenwerk.tfZ);
    Rechenwerk.tfZ.setFocusable(false);
    
    Rechenwerk.lbHR.setBounds(50, 35, 72, 30);
    Rechenwerk.lbHR.setText("HR");
    Rechenwerk.lbHR.setAlignment(Label.CENTER);
    Rechenwerk.lbHR.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(Rechenwerk.lbHR);
    
    Rechenwerk.lbAkku.setBounds(200, 35, 60, 30);
    Rechenwerk.lbAkku.setText("Akku");
    Rechenwerk.lbAkku.setFont(new Font("Dialog", Font.PLAIN, 13));
    Rechenwerk.lbAkku.setAlignment(Label.CENTER);
    cp.add(Rechenwerk.lbAkku);
    
    Rechenwerk.lbALU.setBounds(165, 200, 60, 30);
    Rechenwerk.lbALU.setText("ALU");
    Rechenwerk.lbALU.setFont(new Font("Dialog", Font.PLAIN, 13));
    Rechenwerk.lbALU.setAlignment(Label.CENTER);
    cp.add(Rechenwerk.lbALU);
    
    Rechenwerk.lbZ.setBounds(30, 155, 30, 30);
    Rechenwerk.lbZ.setText("Z");
    Rechenwerk.lbZ.setAlignment(Label.CENTER);
    Rechenwerk.lbZ.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(Rechenwerk.lbZ);
    
    Rechenwerk.lbN.setBounds(65, 155, 30, 30);
    Rechenwerk.lbN.setText("N");
    Rechenwerk.lbN.setAlignment(Label.CENTER);
    Rechenwerk.lbN.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(Rechenwerk.lbN);
    
    Steuerwerk.tfBR.setBounds(384, 70, 185, 30);
    Steuerwerk.tfBR.setFont(new Font("Dialog", Font.PLAIN, 20));
    Steuerwerk.tfBR.setEditable(false);
    Steuerwerk.tfBR.setEnabled(true);
    cp.add(Steuerwerk.tfBR);
    
    Steuerwerk.tfBZR.setBounds(450, 275, 120, 30);
    Steuerwerk.tfBZR.setFont(new Font("Dialog", Font.PLAIN, 20));
    Steuerwerk.tfBZR.setEditable(false);
    Steuerwerk.tfBZR.setEnabled(true);
    cp.add(Steuerwerk.tfBZR);
    Steuerwerk.tfBZR.setFocusable(false);
    
    Steuerwerk.lbBR.setBounds(385, 35, 30, 30);
    Steuerwerk.lbBR.setText("BR");
    Steuerwerk.lbBR.setFont(new Font("Dialog", Font.BOLD, 14));
    Steuerwerk.lbBR.setAlignment(Label.CENTER);
    cp.add(Steuerwerk.lbBR);
    Steuerwerk.tfBR.setFocusable(false);
    
    Steuerwerk.lbBZR.setBounds(450, 240, 30, 30);
    Steuerwerk.lbBZR.setText("BZR");
    Steuerwerk.lbBZR.setAlignment(Label.CENTER);
    Steuerwerk.lbBZR.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(Steuerwerk.lbBZR);
    
    Steuerwerk.lbPlus1.setBounds(575, 275, 30, 30);
    Steuerwerk.lbPlus1.setText("+1");
    Steuerwerk.lbPlus1.setFont(new Font("Dialog", Font.BOLD, 14));
    Steuerwerk.lbPlus1.setAlignment(Label.CENTER);
    cp.add(Steuerwerk.lbPlus1);
    
    Steuerwerk.lbOpCode.setBounds(385, 105, 60, 30);
    Steuerwerk.lbOpCode.setText("OpCode");
    Steuerwerk.lbOpCode.setFont(new Font("Dialog", Font.PLAIN, 13));
    Steuerwerk.lbOpCode.setAlignment(Label.CENTER);
    cp.add(Steuerwerk.lbOpCode);
    
    Steuerwerk.lbAdresse.setBounds(505, 105, 60, 30);
    Steuerwerk.lbAdresse.setText("Adresse");
    Steuerwerk.lbAdresse.setFont(new Font("Dialog", Font.PLAIN, 13));
    Steuerwerk.lbAdresse.setAlignment(Label.CENTER);
    cp.add(Steuerwerk.lbAdresse);
    
    Speicherwerk.tfSR.setBounds(725, 70, 120, 30);
    Speicherwerk.tfSR.setFont(new Font("Dialog", Font.PLAIN, 20));
    Speicherwerk.tfSR.setEditable(false);
    Speicherwerk.tfSR.setEnabled(true);
    cp.add(Speicherwerk.tfSR);
    
    Speicherwerk.tfSAR.setBounds(650, 360, 120, 30);
    Speicherwerk.tfSAR.setFont(new Font("Dialog", Font.PLAIN, 20));
    Speicherwerk.tfSAR.setEditable(false);
    Speicherwerk.tfSAR.setEnabled(true);
    cp.add(Speicherwerk.tfSAR);
    
    Speicherwerk.taBefehlFenster.setBounds(710, 110, 155, 207);
    Speicherwerk.taBefehlFenster.setEnabled(true);
    Speicherwerk.taBefehlFenster.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(Speicherwerk.taBefehlFenster);
    
    Speicherwerk.lbSR.setBounds(725, 35, 30, 30);
    Speicherwerk.lbSR.setText("SR");
    Speicherwerk.lbSR.setAlignment(Label.CENTER);
    Speicherwerk.lbSR.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(Speicherwerk.lbSR);
    Speicherwerk.tfSR.setFocusable(false);
    
    Speicherwerk.lbSAR.setBounds(735, 325, 32, 30);
    Speicherwerk.lbSAR.setText("SAR");
    Speicherwerk.lbSAR.setAlignment(Label.CENTER);
    Speicherwerk.lbSAR.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(Speicherwerk.lbSAR);
    Speicherwerk.tfSAR.setFocusable(false);
    
    IOWerk.tfeingabeRegister.setBounds(650, 432, 120, 30);
    IOWerk.tfeingabeRegister.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(IOWerk.tfeingabeRegister);
    
    IOWerk.tfausgabeRegister.setBounds(800, 432, 120, 30);
    IOWerk.tfausgabeRegister.setFont(new Font("Dialog", Font.PLAIN, 20));
    IOWerk.tfausgabeRegister.setEditable(false);
    cp.add(IOWerk.tfausgabeRegister);
    IOWerk.tfausgabeRegister.setFocusable(false);
    
    IOWerk.lbEingaberegister.setBounds(650, 472, 120, 30);
    IOWerk.lbEingaberegister.setText("Eingaberegister");
    IOWerk.lbEingaberegister.setFont(new Font("Dialog", Font.PLAIN, 13));
    IOWerk.lbEingaberegister.setAlignment(Label.CENTER);
    cp.add(IOWerk.lbEingaberegister);
    
    IOWerk.lbAusgaberegister.setBounds(800, 470, 120, 30);
    IOWerk.lbAusgaberegister.setText("text");
    IOWerk.lbAusgaberegister.setFont(new Font("Dialog", Font.PLAIN, 13));
    IOWerk.lbAusgaberegister.setAlignment(Label.CENTER);
    cp.add(IOWerk.lbAusgaberegister);
    
    IOWerk.lbER.setBounds(650, 397, 30, 30);
    IOWerk.lbER.setText("ER");
    IOWerk.lbER.setFont(new Font("Dialog", Font.BOLD, 14));
    IOWerk.lbER.setAlignment(Label.CENTER);
    cp.add(IOWerk.lbER);
    
    IOWerk.lbAR.setBounds(800, 397, 30, 30);
    IOWerk.lbAR.setText("AR");
    IOWerk.lbAR.setFont(new Font("Dialog", Font.BOLD, 14));
    IOWerk.lbAR.setAlignment(Label.CENTER);
    cp.add(IOWerk.lbAR);
    
    tfDekodierung.setBounds(320, 432, 275, 65);
    tfDekodierung.setVisible(true);
    tfDekodierung.setEditable(false);
    tfDekodierung.setEnabled(true);
    cp.add(tfDekodierung);
    tfDekodierung.setFocusable(false);
    
    lbDekodierung.setBounds(320, 395, 120, 30);
    lbDekodierung.setText("Dekodierung");
    lbDekodierung.setAlignment(Label.CENTER);
    lbDekodierung.setFont(new Font("Dialog", Font.PLAIN, 13));
    lbDekodierung.setEnabled(true);
    cp.add(lbDekodierung);
    
    cp.setBackground(Color.WHITE);
    
    // Ende Komponenten
    
    setVisible(true);
    
  } // end of public VonNeumannProjekt
    
  // Anfang Methoden
    
  public static void main(String[] args) {
    new FrmOMRAnw();
  } // end of main
    
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
  }
    
  public void rechnerStopp(){
    btRechnerStart.setEnabled(true);                                                          
    btRechnerStopp.setEnabled(false);
    btZyklus.setEnabled(false);
    btZyklus.setLabel("Befehl holen");
  }
    
    
    
  public void mainZyklus(){
    String Speicherinhalt;
    if(btZyklus.getLabel().equals("Befehl holen") == true){
      btZyklus.setLabel("Befehl Dekodieren");
      // BZR -> SAR
      zAdresse = Integer.parseInt(Steuerwerk.tfBZR.getText());
      Speicherwerk.SetSAR(zAdresse);
      // Speicher SAR -> BR
      Speicherwerk.SetSR("lesen", "");   // oder : "schreiben"
      //Speicherinhalt = Speicherwerk.GetSR();
      //Steuerwerk.SetBR(SpeicherInhalt);
      Steuerwerk.IncrementBZR();
      //Memdekodierung.clear ?
    }
    else{
      if(btZyklus.getLabel().equals("Befehl Dekodieren") == true){
        
      }
    } 
  } 
    
  /***************************** Ende Ereignissteurung ************************/
    
  public void btRechnerStart_ActionPerformed(ActionEvent evt) {
    rechnerStart();
  } // end of btRechnerStart_ActionPerformed
    
  public void btRechnerStopp_ActionPerformed(ActionEvent evt) {
    rechnerStopp();
  } // end of btRechnerStopp_ActionPerformed
    
  public void btZyklus_ActionPerformed(ActionEvent evt) {
    mainZyklus();
  } // end of btZyklus_ActionPerformed 
    
  // Ende Methoden
    
} // end of class VonNeumannProjekt
  