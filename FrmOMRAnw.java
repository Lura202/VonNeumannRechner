import java.awt.*;
import java.awt.event.*;

/**
  *
  * Beschreibung
  *
  * @version 1.0 vom 02.01.2018
  * @author 
  */

public class FrmOMRAnw extends Frame {
  // Anfang Attribute
  private String Datenbus;
  private int Adressbus;
  private String zZyklus;
  private String zOpcode;
  private Image img;
   
  private Button bRechnerStart = new Button();
  private Button bRechnerStopp = new Button();
  private Button bBefehlholen = new Button();
  private TextField tfHR = new TextField();
  private TextField tfAkku = new TextField();
  private TextField tfALU = new TextField();
  private TextField tfN = new TextField();
  private TextField tfZ = new TextField();
  private TextField tfBR = new TextField();
  private TextField tfBZR = new TextField();
  private TextField tfeingabeRegister = new TextField();
  private TextField tfausgabeRegister = new TextField();
  private TextField tfSR = new TextField();
  private TextField tfSAR = new TextField();
  private TextArea taBefehlFenster = new TextArea("", 1, 1, TextArea.SCROLLBARS_VERTICAL_ONLY);
  // Ende Attribute
  
  public FrmOMRAnw() { 
    // Frame-Initialisierung
    super();
    addWindowListener(new WindowAdapter() {
    public void windowClosing(WindowEvent evt) { dispose(); }
    });
    int frameWidth = 1000; 
    int frameHeight = 600;
    setSize(frameWidth, frameHeight);
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int x = (d.width - getSize().width) / 2;
    int y = (d.height - getSize().height) / 2;
    setLocation(x, y);
    setTitle("FrmOMRAnw");
    setResizable(false);
    Panel cp = new Panel(null);
    add(cp);
    // Anfang Komponenten
    
    bRechnerStart.setBounds(25, 400, 120, 30);
    bRechnerStart.setLabel("Rechner Start");
    bRechnerStart.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    bRechnerStart_ActionPerformed(evt);
    }
    });
    bRechnerStart.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(bRechnerStart);
    tfHR.setBounds(50, 70, 120, 30);
    tfHR.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfHR);
    tfAkku.setBounds(200, 70, 120, 30);
    tfAkku.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfAkku);
    tfALU.setBounds(143, 150, 80, 40);
    tfALU.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfALU);
    tfN.setBounds(100, 150, 25, 40);
    tfN.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfN);
    tfZ.setBounds(70, 150, 25, 40);
    tfZ.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfZ);
    tfBR.setBounds(384, 70, 185, 30);
    tfBR.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfBR);
    tfBZR.setBounds(450, 275, 120, 30);
    tfBZR.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfBZR);
    tfeingabeRegister.setBounds(650, 400, 120, 30);
    tfeingabeRegister.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfeingabeRegister);
    tfausgabeRegister.setBounds(800, 400, 120, 30);
    tfausgabeRegister.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfausgabeRegister);
    tfSR.setBounds(730, 70, 120, 30);
    tfSR.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfSR);
    tfSAR.setBounds(650, 320, 120, 30);
    tfSAR.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(tfSAR);
    bRechnerStopp.setBounds(25, 435, 120, 30);
    bRechnerStopp.setLabel("Rechner Stopp");
    bRechnerStopp.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    bRechnerStopp_ActionPerformed(evt);
    }
    });
    bRechnerStopp.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(bRechnerStopp);
    bBefehlholen.setBounds(160, 400, 120, 65);
    bBefehlholen.setLabel("Befehl holen");
    bBefehlholen.addActionListener(new ActionListener() { 
    public void actionPerformed(ActionEvent evt) { 
    bBefehlholen_ActionPerformed(evt);
    }
    });
    bBefehlholen.setFont(new Font("Dialog", Font.PLAIN, 16));
    cp.add(bBefehlholen);
    
    taBefehlFenster.setBounds(710, 120, 155, 175);
    taBefehlFenster.setEnabled(true);
    taBefehlFenster.setFont(new Font("Dialog", Font.PLAIN, 20));
    cp.add(taBefehlFenster);
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
    re.reset();  // Da "reset()" keine statische Methode ist, wird die Methode wie dargestellt aufgerufen und nicht mit "Rechenwerk.reset();"
    Steuerwerk st = new Steuerwerk();
    st.reset();  // Da "reset()" keine statische Methode ist, wird die Methode wie dargestellt aufgerufen und nicht mit "Steuerwerk.reset();"
    Speicherwerk sp = new Speicherwerk();
    sp.reset();  // Da "reset()" keine statische Methode ist, wird die Methode wie dargestellt aufgerufen und nicht mit "Speicherwerk.reset();"
    IOWerk io = new IOWerk();
    io.reset();  // Da "reset()" keine statische Methode ist, wird die Methode wie dargestellt aufgerufen und nicht mit "IOWerk.reset();"
  }
  
  /***************************** Ende Hilfsmethoden ***************************/
  
  /***************************** Ereignissteuerung ****************************/
  
  /***************************** Ende Ereignissteurung ************************/
  
  public void bRechnerStart_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bRechnerStart_ActionPerformed
    
  public void bRechnerStopp_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bRechnerStopp_ActionPerformed
    
  public void bBefehlholen_ActionPerformed(ActionEvent evt) {
    // TODO hier Quelltext einfügen
    
  } // end of bBefehlholen_ActionPerformed
    
  // Ende Methoden

} // end of class VonNeumannProjekt
  