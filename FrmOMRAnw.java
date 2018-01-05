import java.awt.*;
import java.awt.event.*;
import je.util.Turtle;

/**
  *
  * Beschreibung
  *
  * @version 0.2 vom 05.01.2018
  * @Lukas Rang
  */

public class FrmOMRAnw extends Frame {
  
  // Anfang Attribute
  
  private String Datenbus;
  private int Adressbus;
  private String zZyklus;
  private String zOpcode;
  private Image img;
   
  private Button btRechnerStart = new Button();
  private Button btRechnerStopp = new Button();
  private Button btBefehlholen = new Button();
  
  public TextField tfHR = new TextField();
  private TextField tfAkku = new TextField();
  private TextField tfALU = new TextField();
  private TextField tfN = new TextField();
  private TextField tfZ = new TextField();
  protected TextField tfBR = new TextField();
  private TextField tfBZR = new TextField();
  private TextField tfeingabeRegister = new TextField();
  private TextField tfausgabeRegister = new TextField();
  private TextField tfSR = new TextField();
  private TextField tfSAR = new TextField();
  private TextField tfDekodierung = new TextField();
  
  private Label lbHilfsregister = new Label();
  private Label lbAkku = new Label();
  private Label lbEingaberegister = new Label();
  private Label lbAusgaberegister = new Label();
  private Label lbER = new Label();
  private Label lbAR = new Label();
  private Label lbSR = new Label();
  private Label lbBR = new Label();
  private Label lbBZR = new Label();
  private Label lbPlus1 = new Label();
  private Label lbALU = new Label();
  private Label lbZ = new Label();
  private Label lbN = new Label();
  private Label lbDekodierung = new Label();
  private Label lbOpCode = new Label();
  private Label lbAdresse = new Label();
  
  private TextArea taBefehlFenster = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  
  private Label lbSAR = new Label();
  // Ende Attribute
  
  public FrmOMRAnw() { 
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
    
    tfHR.setBounds(50, 70, 120, 30);
    tfHR.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfHR.setEditable(false);
    tfHR.setEnabled(true);
    cp.add(tfHR);
    
    tfAkku.setBounds(200, 70, 120, 30);
    tfAkku.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfAkku.setEnabled(true);
    tfAkku.setEditable(false);
    cp.add(tfAkku);
    
    tfALU.setBounds(145, 165, 80, 30);
    tfALU.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfALU.setEnabled(true);
    tfALU.setEditable(false);
    cp.add(tfALU);
    
    tfN.setBounds(65, 190, 30, 30);
    tfN.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfN.setEnabled(true);
    tfN.setEditable(false);
    cp.add(tfN);
    
    tfZ.setBounds(30, 190, 30, 30);
    tfZ.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfZ.setEditable(false);
    tfZ.setEnabled(true);
    cp.add(tfZ);
    
    tfBR.setBounds(384, 70, 185, 30);
    tfBR.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfBR.setEditable(false);
    tfBR.setEnabled(true);
    cp.add(tfBR);
    
    tfBZR.setBounds(450, 275, 120, 30);
    tfBZR.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfBZR.setEditable(false);
    tfBZR.setEnabled(true);
    cp.add(tfBZR);
    
    tfeingabeRegister.setBounds(650, 432, 120, 30);
    tfeingabeRegister.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfeingabeRegister);
    
    tfausgabeRegister.setBounds(800, 432, 120, 30);
    tfausgabeRegister.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfausgabeRegister.setEditable(false);
    tfausgabeRegister.setEnabled(true);
    cp.add(tfausgabeRegister);
    
    tfSR.setBounds(725, 70, 120, 30);
    tfSR.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfSR.setEditable(false);
    tfSR.setEnabled(true);
    cp.add(tfSR);
    
    tfSAR.setBounds(650, 360, 120, 30);
    tfSAR.setFont(new Font("Dialog", Font.PLAIN, 20));
    tfSAR.setEditable(false);
    tfSAR.setEnabled(true);
    cp.add(tfSAR);
    
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
    
    btBefehlholen.setBounds(160, 432, 120, 65);
    btBefehlholen.setLabel("Befehl holen");
    btBefehlholen.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    btBefehlholen_ActionPerformed(evt);
    }
    });
    
    btBefehlholen.setFont(new Font("Dialog", Font.PLAIN, 16));
    btBefehlholen.setEnabled(false);
    cp.add(btBefehlholen);
    
    taBefehlFenster.setBounds(710, 110, 155, 207);
    taBefehlFenster.setEnabled(true);
    taBefehlFenster.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(taBefehlFenster);
    
    lbHilfsregister.setBounds(50, 35, 72, 30);
    lbHilfsregister.setText("Hilfsregister");
    lbHilfsregister.setAlignment(Label.CENTER);
    lbHilfsregister.setFont(new Font("Dialog", Font.PLAIN, 13));
    cp.add(lbHilfsregister);
    
    lbAkku.setBounds(200, 35, 60, 30);
    lbAkku.setText("Akku");
    lbAkku.setFont(new Font("Dialog", Font.PLAIN, 13));
    lbAkku.setAlignment(Label.CENTER);
    cp.add(lbAkku);
    
    lbEingaberegister.setBounds(650, 472, 120, 30);
    lbEingaberegister.setText("Eingaberegister");
    lbEingaberegister.setFont(new Font("Dialog", Font.PLAIN, 13));
    lbEingaberegister.setAlignment(Label.CENTER);
    cp.add(lbEingaberegister);
    
    lbAusgaberegister.setBounds(800, 470, 120, 30);
    lbAusgaberegister.setText("text");
    lbAusgaberegister.setFont(new Font("Dialog", Font.PLAIN, 13));
    lbAusgaberegister.setAlignment(Label.CENTER);
    cp.add(lbAusgaberegister);
    
    lbER.setBounds(650, 397, 30, 30);
    lbER.setText("ER");
    lbER.setFont(new Font("Dialog", Font.BOLD, 14));
    lbER.setAlignment(Label.CENTER);
    cp.add(lbER);
    
    lbAR.setBounds(800, 397, 30, 30);
    lbAR.setText("AR");
    lbAR.setFont(new Font("Dialog", Font.BOLD, 14));
    lbAR.setAlignment(Label.CENTER);
    cp.add(lbAR);
    
    lbSR.setBounds(725, 35, 30, 30);
    lbSR.setText("SR");
    lbSR.setAlignment(Label.CENTER);
    lbSR.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(lbSR);
    
    lbBR.setBounds(385, 35, 30, 30);
    lbBR.setText("BR");
    lbBR.setFont(new Font("Dialog", Font.BOLD, 14));
    lbBR.setAlignment(Label.CENTER);
    cp.add(lbBR);
    
    lbBZR.setBounds(450, 240, 30, 30);
    lbBZR.setText("BZR");
    lbBZR.setAlignment(Label.CENTER);
    lbBZR.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(lbBZR);
    
    lbPlus1.setBounds(575, 275, 30, 30);
    lbPlus1.setText("+1");
    lbPlus1.setFont(new Font("Dialog", Font.BOLD, 14));
    lbPlus1.setAlignment(Label.CENTER);
    cp.add(lbPlus1);
    
    lbALU.setBounds(165, 200, 60, 30);
    lbALU.setText("ALU");
    lbALU.setFont(new Font("Dialog", Font.PLAIN, 13));
    lbALU.setAlignment(Label.CENTER);
    cp.add(lbALU);
    
    lbZ.setBounds(30, 155, 30, 30);
    lbZ.setText("Z");
    lbZ.setAlignment(Label.CENTER);
    lbZ.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(lbZ);
    
    lbN.setBounds(65, 155, 30, 30);
    lbN.setText("N");
    lbN.setAlignment(Label.CENTER);
    lbN.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(lbN);
    
    tfDekodierung.setBounds(320, 432, 275, 65);
    tfDekodierung.setCaretPosition(0);
    tfDekodierung.setVisible(true);
    tfDekodierung.setBackground(Color.WHITE);
    tfDekodierung.setEditable(false);
    tfDekodierung.setEnabled(true);
    cp.add(tfDekodierung);
    
    lbDekodierung.setBounds(320, 395, 120, 30);
    lbDekodierung.setText("Dekodierung");
    lbDekodierung.setAlignment(Label.CENTER);
    lbDekodierung.setFont(new Font("Dialog", Font.PLAIN, 13));
    lbDekodierung.setEnabled(true);
    cp.add(lbDekodierung);
    
    lbOpCode.setBounds(385, 105, 60, 30);
    lbOpCode.setText("OpCode");
    lbOpCode.setFont(new Font("Dialog", Font.PLAIN, 13));
    lbOpCode.setAlignment(Label.CENTER);
    cp.add(lbOpCode);
    
    lbAdresse.setBounds(505, 105, 60, 30);
    lbAdresse.setText("Adresse");
    lbAdresse.setFont(new Font("Dialog", Font.PLAIN, 13));
    lbAdresse.setAlignment(Label.CENTER);
    cp.add(lbAdresse);
    
    lbSAR.setBounds(735, 325, 32, 30);
    lbSAR.setText("SAR");
    lbSAR.setAlignment(Label.CENTER);
    lbSAR.setFont(new Font("Dialog", Font.BOLD, 14));
    cp.add(lbSAR);
    
    cp.setBackground(Color.WHITE);
    
    // Ende Komponenten
    
    setVisible(true);
    
  } // end of public VonNeumannProjekt
  
  // Anfang Methoden
  
  public static void main(String[] args) {
    new FrmOMRAnw();
  } // end of main
  
  /***************************** Hilfsmethoden ********************************/
  
  public void reset(){
    Rechenwerk re = new Rechenwerk();
    re.reset();  // Da "reset()" keine statische Methode ist, wird die Methode wie dargestellt aufgerufen anstatt mit "Rechenwerk.reset();"
    Steuerwerk st = new Steuerwerk();
    st.reset();  // Da "reset()" keine statische Methode ist, wird die Methode wie dargestellt aufgerufen anstatt mit "Steuerwerk.reset();"
    Speicherwerk sp = new Speicherwerk();
    sp.reset();  // Da "reset()" keine statische Methode ist, wird die Methode wie dargestellt aufgerufen anstatt mit "Speicherwerk.reset();"
    IOWerk io = new IOWerk();
    io.reset();  // Da "reset()" keine statische Methode ist, wird die Methode wie dargestellt aufgerufen anstatt mit "IOWerk.reset();"
  }
  
  /***************************** Ende Hilfsmethoden ***************************/
  
  /***************************** Ereignissteuerung ****************************/
  
  public void rechnerstart(){
    btRechnerStart.setEnabled(false);
    btRechnerStopp.setEnabled(true);
    btBefehlholen.setEnabled(true);
    reset();
  }
  
  public void rechnerstopp(){
    btRechnerStart.setEnabled(true);
    btRechnerStopp.setEnabled(false);
    btBefehlholen.setEnabled(false);
  }
  
  /***************************** Ende Ereignissteurung ************************/
  
  public void btRechnerStart_ActionPerformed(ActionEvent evt) {
    rechnerstart();
  } // end of btRechnerStart_ActionPerformed
    
  public void btRechnerStopp_ActionPerformed(ActionEvent evt) {
    rechnerstopp();
  } // end of btRechnerStopp_ActionPerformed
    
  public void btBefehlholen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of btBefehlholen_ActionPerformed
    
  // Ende Methoden

} // end of class VonNeumannProjekt
  