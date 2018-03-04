/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import static login.CautaOVA.byteArrayToImage;
import static login.CautaOVA.resize;

/**
 *
 * @author Serdin
 */
public class CautaOIA extends javax.swing.JFrame implements DocumentListener{

    Zona z;
    int nr=0;
     public static BufferedImage  byteArrayToImage(byte[] bytes){  
        BufferedImage bufferedImage=null;
        if(bytes!=null){
        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);
            bufferedImage = ImageIO.read(inputStream);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        }
        return bufferedImage;
}
     public static void setCellsAlignment(JTable table, int alignment)
    {
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(alignment);

        TableModel tableModel = table.getModel();

        for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
        {
            table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
        }
    }
      public static BufferedImage resize(BufferedImage image, int width, int height) {
    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
    Graphics2D g2d = (Graphics2D) bi.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
    g2d.drawImage(image, 0, 0, width, height, null);
    g2d.dispose();
    return bi;
}
    private static String verifica(String str) {
    return str == null ? "" : str;
        }
    public CautaOIA() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        EchipaRadioButton.setEnabled(false);
        EchipaComboBox.setEnabled(false);
        Clientifavoriti.setEnabled(false);
        AgentRadioButton.setEnabled(false);
        AgentComboBox.setEnabled(false);
       WebComboBox.setEnabled(false);
        jTable1.setDefaultEditor(Object.class, null);
         this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
         
        
         //jScrollPane3.setVisible(true);
         
         
         //jScrollPane4.setVisible(false);
        
         
         
         jTable1.setVisible(false);
   
         jTable1.addMouseListener(new MouseAdapter() {
     @Override
     public void mousePressed(MouseEvent e) {
       if(e.getClickCount()==2){
           copy();
       }
     }
  });

    }

    
     public String[] returneazaCod(String text){
        ArrayList<String> Camere=new ArrayList<String>();
        ArrayList<String> Numere=new ArrayList<String>();
        ArrayList<String> Strazi=new ArrayList<String>();
        java.sql.Statement stmt = null;
                try {
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");

       Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
       // System.out.println("db connected");
        stmt = (java.sql.Statement) conn.createStatement();

        ResultSet rs1;
       // String a;
       // a=text.substring(0);
       rs1 = stmt.executeQuery("select OIA,Camere,Strada from aptinchiriere where OIA Like '"+text+"%'");
       while(rs1.next()){
         Camere.add(  rs1.getString("Camere"));
         Strazi.add(rs1.getString("Strada"));
         String aux;
        aux= rs1.getString("OIA");
        Numere.add(aux);
       }

                }
       catch(Exception e){
                    e.printStackTrace();
                }
                
                String Numere1[]=new String[Camere.size()];
                for(int i=0;i<Camere.size();i++){
                    Numere1[i]="OIA "+Numere.get(i)+"|"+Camere.get(i)+" camere| Str. "+Strazi.get(i);
                }
                if (Numere1.length>0)
                return Numere1; else 
                    return null;
    }
     public String[] returneazaStrada(String text){
        ArrayList<String> Camere=new ArrayList<String>();
        ArrayList<String> Numere=new ArrayList<String>();
        ArrayList<String> Strazi=new ArrayList<String>();
        java.sql.Statement stmt = null;
                try {
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");

       Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
       // System.out.println("db connected");
        stmt = (java.sql.Statement) conn.createStatement();

        ResultSet rs1;
       rs1 = stmt.executeQuery("select OIA,Camere,Strada from aptinchiriere where Strada Like '"+text+"%'");
       while(rs1.next()){
         Camere.add(rs1.getString("Camere"));
         Strazi.add(rs1.getString("Strada"));
         String aux;
        aux= rs1.getString("OIA");
        Numere.add(aux);
       }

                }
       catch(Exception e){
                    e.printStackTrace();
                }
                
                String Numere1[]=new String[Camere.size()];
                for(int i=0;i<Camere.size();i++){
                    Numere1[i]="OIA "+Numere.get(i)+"|"+Camere.get(i)+" camere| Str. "+Strazi.get(i);
                }
                if (Numere1.length>0)
                return Numere1; else 
                    return null;
    }
     
      public void copy() {
    int row = jTable1.getSelectedRow();
    //int col = jTable1.getSelectedColumn();
   String s= jTable1.getValueAt(row,0).toString();
        int i=Integer.parseInt(s);
        detaliiOIA a;
        a=new detaliiOIA(i);
        a.setVisible(true);
}
      
      
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        Mobila4 = new javax.swing.JCheckBox();
        jLabel29 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Status = new javax.swing.JComboBox<>();
        Bucatarie1 = new javax.swing.JCheckBox();
        Bucatarie2 = new javax.swing.JCheckBox();
        Bucatarie3 = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();
        CautaButton = new javax.swing.JButton();
        Reset = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        ImbunatatiriRealeComboBox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        PretTextField = new javax.swing.JTextField();
        PretDeLaTextField = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        PretPanaLaTextField = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        CautaDupaPretButton = new javax.swing.JButton();
        EtajInf = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        EtajSup = new javax.swing.JTextField();
        Pozitie1 = new javax.swing.JCheckBox();
        Pozitie2 = new javax.swing.JCheckBox();
        Pozitie3 = new javax.swing.JCheckBox();
        Pozitie4 = new javax.swing.JCheckBox();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CautaDupaCodTextField = new javax.swing.JTextField();
        CautaDupaCodButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CautaDupaStradaTextField = new javax.swing.JTextField();
        CautaDupaStradaButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Parter = new javax.swing.JCheckBox();
        Ultimul = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        Exclusivitate = new javax.swing.JCheckBox();
        jLabel8 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Dest1 = new javax.swing.JCheckBox();
        Tip1 = new javax.swing.JCheckBox();
        Dest2 = new javax.swing.JCheckBox();
        Tip2 = new javax.swing.JCheckBox();
        Dest3 = new javax.swing.JCheckBox();
        Tip3 = new javax.swing.JCheckBox();
        Dest4 = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        EchipaRadioButton = new javax.swing.JRadioButton();
        Camera1 = new javax.swing.JCheckBox();
        Camera2 = new javax.swing.JCheckBox();
        Camera3 = new javax.swing.JCheckBox();
        Camera4 = new javax.swing.JCheckBox();
        EchipaComboBox = new javax.swing.JComboBox<>();
        AgentRadioButton = new javax.swing.JRadioButton();
        AgentComboBox = new javax.swing.JComboBox<>();
        Clientifavoriti = new javax.swing.JCheckBox();
        Camera5 = new javax.swing.JCheckBox();
        jLabel23 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Metrou = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        Confort1 = new javax.swing.JCheckBox();
        CuPoze = new javax.swing.JCheckBox();
        Confort2 = new javax.swing.JCheckBox();
        FaraPoze = new javax.swing.JCheckBox();
        Confort3 = new javax.swing.JCheckBox();
        Confort4 = new javax.swing.JCheckBox();
        Confort5 = new javax.swing.JCheckBox();
        Confort6 = new javax.swing.JCheckBox();
        jLabel26 = new javax.swing.JLabel();
        Publicate = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        WebComboBox = new javax.swing.JComboBox<>();
        jLabel12 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        Mobila1 = new javax.swing.JCheckBox();
        Stare1 = new javax.swing.JCheckBox();
        Mobila2 = new javax.swing.JCheckBox();
        Stare2 = new javax.swing.JCheckBox();
        Mobila3 = new javax.swing.JCheckBox();
        Stare3 = new javax.swing.JCheckBox();
        An = new javax.swing.JTextField();
        ZonaButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBorder(null);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        Mobila4.setText("Mobilat lux");

        jLabel29.setBackground(new java.awt.Color(255, 255, 102));
        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel29.setText("            Status:");
        jLabel29.setOpaque(true);

        jLabel13.setBackground(new java.awt.Color(255, 255, 102));
        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("      Bucatarie:");
        jLabel13.setOpaque(true);

        Status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Neprecizat", "OK", "De revenit" }));

        Bucatarie1.setText("Nemobilata");
        Bucatarie1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bucatarie1ActionPerformed(evt);
            }
        });

        Bucatarie2.setText("Mobilata partial");

        Bucatarie3.setText("Mobilata complet");
        Bucatarie3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bucatarie3ActionPerformed(evt);
            }
        });

        jLabel14.setBackground(new java.awt.Color(255, 255, 102));
        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("        Imbunatatiri reale:");
        jLabel14.setOpaque(true);

        CautaButton.setText("Cauta");
        CautaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CautaButtonActionPerformed(evt);
            }
        });

        Reset.setText("Reset");
        Reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ResetActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable1);

        ImbunatatiriRealeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----", "NU", "DA" }));
        ImbunatatiriRealeComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImbunatatiriRealeComboBoxActionPerformed(evt);
            }
        });

        jLabel15.setBackground(new java.awt.Color(255, 255, 102));
        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("         Pret :");
        jLabel15.setOpaque(true);

        jLabel16.setText("mai mic de:");

        PretTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PretTextFieldActionPerformed(evt);
            }
        });

        PretDeLaTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("pana la:");

        jLabel17.setBackground(new java.awt.Color(255, 255, 102));
        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("         Etaj:");
        jLabel17.setOpaque(true);

        PretPanaLaTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PretPanaLaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PretPanaLaTextFieldActionPerformed(evt);
            }
        });

        jLabel18.setText("Intre:");

        CautaDupaPretButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CautaDupaPretButton.setText("Selecteaza");
        CautaDupaPretButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CautaDupaPretButtonActionPerformed(evt);
            }
        });

        EtajInf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtajInfActionPerformed(evt);
            }
        });

        jLabel19.setText("si");

        jLabel7.setBackground(new java.awt.Color(255, 255, 102));
        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("  Pozitie:");
        jLabel7.setOpaque(true);

        Pozitie1.setText("Ultracentral");
        Pozitie1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pozitie1ActionPerformed(evt);
            }
        });

        Pozitie2.setText("Central");

        Pozitie3.setText("Cartier");

        Pozitie4.setText("Periferie");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Cautare...");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Dupa COD: ");

        CautaDupaCodTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CautaDupaCodTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CautaDupaCodTextFieldActionPerformed(evt);
            }
        });
        CautaDupaCodTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                CautaDupaCodTextFieldKeyReleased(evt);
            }
        });

        CautaDupaCodButton.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        CautaDupaCodButton.setText("Selecteaza");
        CautaDupaCodButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CautaDupaCodButtonActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Dupa Strada:");

        CautaDupaStradaTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        CautaDupaStradaButton.setText("Selecteaza");
        CautaDupaStradaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CautaDupaStradaButtonActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Pret de la:");

        Parter.setText("Fara Parter");

        Ultimul.setText("Fara Ultimul Etaj");

        jLabel20.setBackground(new java.awt.Color(255, 255, 102));
        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("        Exclusivitate:");
        jLabel20.setOpaque(true);

        Exclusivitate.setText("Exclusivitate");
        Exclusivitate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExclusivitateActionPerformed(evt);
            }
        });

        jLabel8.setBackground(new java.awt.Color(255, 255, 102));
        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Destinatie:");
        jLabel8.setOpaque(true);

        jLabel21.setBackground(new java.awt.Color(255, 255, 102));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("         Compartimentare:");
        jLabel21.setOpaque(true);

        Dest1.setText("Rezidential");

        Tip1.setText("Semidecomandat");

        Dest2.setText("Comercial");

        Tip2.setText("Decomandat");

        Dest3.setText("Birouri");

        Tip3.setText("Circular");

        Dest4.setText("Vacanta");

        jLabel22.setBackground(new java.awt.Color(255, 255, 102));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("           Agent:");
        jLabel22.setOpaque(true);

        jLabel9.setBackground(new java.awt.Color(255, 255, 102));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Camere:");
        jLabel9.setOpaque(true);

        EchipaRadioButton.setText("Echipa");

        Camera1.setText("Garsoniera");

        Camera2.setText("2 camere");

        Camera3.setText("3 camere");

        Camera4.setText("4 camere");

        EchipaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------", "Item 1", "Item 2", "Item 3", "Item 4" }));

        AgentRadioButton.setText("Agent");
        AgentRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgentRadioButtonActionPerformed(evt);
            }
        });

        AgentComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------", "Item 1", "Item 2", "Item 3", "Item 4" }));

        Clientifavoriti.setText("Clienti favoriti");

        Camera5.setText("4+ camere");

        jLabel23.setBackground(new java.awt.Color(255, 255, 102));
        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel23.setText("         An Constructie:");
        jLabel23.setOpaque(true);

        jLabel10.setBackground(new java.awt.Color(255, 255, 102));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Metrou:");
        jLabel10.setOpaque(true);

        jLabel24.setText("An:");

        Metrou.setText("Metrou");

        jLabel11.setBackground(new java.awt.Color(255, 255, 102));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("  Confort:");
        jLabel11.setOpaque(true);

        jLabel25.setBackground(new java.awt.Color(255, 255, 102));
        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("         Imagini:");
        jLabel25.setOpaque(true);

        Confort1.setText("I+");
        Confort1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confort1ActionPerformed(evt);
            }
        });

        CuPoze.setText("Cu Imagini");
        CuPoze.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CuPozeActionPerformed(evt);
            }
        });

        Confort2.setText("I");

        FaraPoze.setText("Fara Imagini");

        Confort3.setText("II+");

        Confort4.setText("II");

        Confort5.setText("III+");

        Confort6.setText("III");

        jLabel26.setBackground(new java.awt.Color(255, 255, 102));
        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("         Publicate:");
        jLabel26.setOpaque(true);

        Publicate.setText("Publicate");

        jLabel27.setBackground(new java.awt.Color(255, 255, 102));
        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("         Web:");
        jLabel27.setOpaque(true);

        WebComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------", "Item 1", "Item 2", "Item 3", "Item 4" }));
        WebComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                WebComboBoxActionPerformed(evt);
            }
        });

        jLabel12.setBackground(new java.awt.Color(255, 255, 102));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("      Mobila:");
        jLabel12.setOpaque(true);

        jLabel28.setBackground(new java.awt.Color(255, 255, 102));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("             Stare:");
        jLabel28.setOpaque(true);

        Mobila1.setText("Nemobilat");

        Stare1.setText("Actual");

        Mobila2.setText("Mobilat partial");

        Stare2.setText("Incorect");

        Mobila3.setText("Mobilat complet");
        Mobila3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Mobila3ActionPerformed(evt);
            }
        });

        Stare3.setText("Vandut");

        An.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnActionPerformed(evt);
            }
        });

        ZonaButon.setBackground(new java.awt.Color(255, 255, 102));
        ZonaButon.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        ZonaButon.setText("Zona");
        ZonaButon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZonaButonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Dest2)
                            .addComponent(Dest3)
                            .addComponent(Dest4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ZonaButon, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Pozitie2)
                                    .addComponent(Pozitie1)
                                    .addComponent(Pozitie3)
                                    .addComponent(Pozitie4)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Dest1))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Camera3)
                                    .addComponent(Camera2)
                                    .addComponent(Camera1)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Camera4)
                                    .addComponent(Camera5)
                                    .addComponent(Metrou)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Bucatarie1)
                                    .addComponent(Bucatarie2)
                                    .addComponent(Bucatarie3)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ImbunatatiriRealeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE))
                                .addGap(128, 128, 128))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Confort3)
                                    .addComponent(Confort6)
                                    .addComponent(Confort5)
                                    .addComponent(Confort4)
                                    .addComponent(Confort1)
                                    .addComponent(Confort2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Mobila3)
                                    .addComponent(Mobila1)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Mobila2)
                                    .addComponent(Mobila4)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CautaDupaCodTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CautaDupaCodButton)))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(Ultimul)
                                .addComponent(Parter)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(11, 11, 11)))
                                .addComponent(Exclusivitate))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(PretTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(EtajInf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EtajSup, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)))
                .addComponent(CautaDupaStradaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(CautaDupaStradaButton)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(138, 138, 138)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(PretDeLaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PretPanaLaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CautaDupaPretButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Clientifavoriti)
                            .addComponent(Tip1)
                            .addComponent(jLabel21)
                            .addComponent(Tip2)
                            .addComponent(Tip3)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EchipaRadioButton)
                            .addComponent(EchipaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgentRadioButton)
                            .addComponent(AgentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                        .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(CuPoze)
                                        .addComponent(FaraPoze)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(34, 34, 34)
                                            .addComponent(Publicate)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel24)
                                        .addGap(36, 36, 36)
                                        .addComponent(An, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(WebComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Stare1)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Stare2)
                            .addComponent(Stare3)
                            .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(CautaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Reset, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(128, 128, 128))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(CautaDupaCodTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(CautaDupaCodButton)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(33, 33, 33)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ZonaButon)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Camera1)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Camera2)
                                    .addComponent(Pozitie2))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Pozitie1)
                                .addGap(9, 9, 9)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Camera4)
                                    .addComponent(Pozitie3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Camera5)
                                    .addComponent(Pozitie4)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(CautaDupaStradaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(CautaDupaStradaButton)
                                            .addComponent(jLabel4)
                                            .addComponent(PretDeLaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(PretPanaLaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CautaDupaPretButton))
                                        .addGap(115, 115, 115))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel23)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel11))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Confort2)
                                                    .addComponent(Mobila1)
                                                    .addComponent(PretTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel16))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Confort1)
                                                    .addComponent(Mobila2)
                                                    .addComponent(jLabel17)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(Tip1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Tip2))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(An, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel24))
                                                .addGap(12, 12, 12)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(jLabel25)
                                                    .addComponent(Stare2)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(Stare1)))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(Tip3)
                                                .addComponent(CuPoze))
                                            .addComponent(Stare3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(FaraPoze))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(Confort3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(Confort6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(209, 209, 209)
                                .addComponent(Mobila4)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Confort5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel20)
                                            .addComponent(jLabel22)
                                            .addComponent(jLabel26)
                                            .addComponent(jLabel29)
                                            .addComponent(jLabel13))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Bucatarie1)
                                            .addComponent(Exclusivitate)
                                            .addComponent(EchipaRadioButton)
                                            .addComponent(Publicate)
                                            .addComponent(Status, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Bucatarie2)
                                                    .addComponent(EchipaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Bucatarie3)
                                                    .addComponent(AgentRadioButton)
                                                    .addComponent(CautaButton)
                                                    .addComponent(Reset)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel27)))
                                        .addGap(3, 3, 3)
                                        .addComponent(jLabel14)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(AgentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(WebComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(ImbunatatiriRealeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel8))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Dest1)
                                            .addComponent(Metrou))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Dest2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Dest3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(Dest4))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EtajInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EtajSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(Confort4)
                            .addComponent(Mobila3)
                            .addComponent(Camera3))
                        .addGap(7, 7, 7)
                        .addComponent(Parter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ultimul)))
                .addGap(18, 18, 18)
                .addComponent(Clientifavoriti)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 417, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(998, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1080, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Bucatarie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bucatarie1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bucatarie1ActionPerformed

    private void Bucatarie3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bucatarie3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Bucatarie3ActionPerformed

    private void CautaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CautaButtonActionPerformed
        //POZITIE

        Boolean bolpoz=false;
        String String11="";
        String String12="";
        String String13="";
        String String14="";
        if(bolpoz==false){
            if(Pozitie1.isSelected()){
                bolpoz=true;
                String11=" AND Pozitie='Ultracentral'";
            }
        }
        else{
            if(Pozitie1.isSelected()){
                bolpoz=true;
                String11=" OR Pozitie='Ultracentral'";
            }
        }
        if(bolpoz==false){
            if(Pozitie2.isSelected()){
                bolpoz=true;
                String12=" AND Pozitie='Central'";
            }
        }
        else{
            if(Pozitie2.isSelected()){
                bolpoz=true;
                String12=" OR Pozitie='Central'";
            }
        }
        if(bolpoz==false){
            if(Pozitie3.isSelected()){
                bolpoz=true;
                String13=" AND Pozitie='Cartier'";
            }
        }
        else{
            if(Pozitie3.isSelected()){
                bolpoz=true;
                String13=" OR Pozitie='Cartier'";
            }
        }
        if(bolpoz==false){
            if(Pozitie4.isSelected()){
                bolpoz=true;
                String14=" AND Pozitie='Periferie'";
            }
        }
        else{
            if(Pozitie4.isSelected()){
                bolpoz=true;
                String14=" OR Pozitie='Periferie'";
            }
        }

        //DESTINATIE

        Boolean boldest=false;
        String String21="";
        String String22="";
        String String23="";
        String String24="";
        if(boldest==false){
            if(Dest1.isSelected()){
                boldest=true;
                String21=" AND Rezidential=1";
            }
        }
        else{
            if(Dest1.isSelected()){
                boldest=true;
                String21=" AND Rezidential=1";
            }
        }
        if(boldest==false){
            if(Dest2.isSelected()){
                boldest=true;
                String22=" AND Comercial=1";
            }
        }
        else{
            if(Dest2.isSelected()){
                boldest=true;
                String22=" AND Comercial=1";
            }
        }
        if(boldest==false){
            if(Dest3.isSelected()){
                boldest=true;
                String23=" AND Birouri=1";
            }
        }
        else{
            if(Dest3.isSelected()){
                boldest=true;
                String23=" AND Birouri=1";
            }
        }
        if(boldest==false){
            if(Dest4.isSelected()){
                boldest=true;
                String24=" AND Vacanta=1";
            }
        }
        else{
            if(Dest4.isSelected()){
                boldest=true;
                String24=" AND Vacanta=1";
            }
        }

        //CAMERE

        Boolean bolcam=false;
        String String31="";
        String String32="";
        String String33="";
        String String34="";
        String String35="";
        if(bolcam==false){
            if(Camera1.isSelected()){
                bolcam=true;
                String31=" AND Camere='1'";
            }
        }
        else{
            if(Camera1.isSelected()){
                bolcam=true;
                String31=" OR Camere='1'";
            }
        }
        if(bolcam==false){
            if(Camera2.isSelected()){
                bolcam=true;
                String32=" AND Camere='2'";
            }
        }
        else{
            if(Camera2.isSelected()){
                bolcam=true;
                String32=" OR Camere='2'";
            }
        }
        if(bolcam==false){
            if(Camera3.isSelected()){
                bolcam=true;
                String33=" AND Camere='3'";
            }
        }
        else{
            if(Camera3.isSelected()){
                bolcam=true;
                String33=" OR Camere='3'";
            }
        }
        if(bolcam==false){
            if(Camera4.isSelected()){
                bolcam=true;
                String34=" AND Camere='4'";
            }
        }
        else{
            if(Camera4.isSelected()){
                bolcam=true;
                String34=" OR Camere='4'";
            }
        }
        if(bolcam==false){
            if(Camera5.isSelected()){
                bolcam=true;
                String35=" AND Camere='4+'";
            }
        }
        else{
            if(Camera5.isSelected()){
                bolcam=true;
                String35=" OR Camere='4+'";
            }
        }

        //METROU
        boolean bolmetrou=false;
        if(bolmetrou==false){
            if(Metrou.isSelected()){
                bolcam=true;
                String35=" AND Metrou=1";
            }
        }
        else{
            if(Metrou.isSelected()){
                bolcam=true;
                String35=" AND Metrou=1";
            }
        }

        //CONFORT
        Boolean bolconfort=false;
        String String41="";
        String String42="";
        String String43="";
        String String44="";
        String String45="";
        String String46="";
        if(bolconfort==false){
            if(Confort1.isSelected()){
                bolconfort=true;
                String41=" AND Confort='I+'";
            }
        }
        else{
            if(Confort1.isSelected()){
                bolconfort=true;
                String41=" OR Confort='I+'";
            }
        }
        if(bolconfort==false){
            if(Confort2.isSelected()){
                bolconfort=true;
                String42=" AND Confort='I'";
            }
        }
        else{
            if(Confort2.isSelected()){
                bolconfort=true;
                String42=" OR Confort='I'";
            }
        }
        if(bolconfort==false){
            if(Confort3.isSelected()){
                bolconfort=true;
                String43=" AND Confort='II+'";
            }
        }
        else{
            if(Confort3.isSelected()){
                bolconfort=true;
                String43=" OR Confort='II+'";
            }
        }
        if(bolconfort==false){
            if(Confort4.isSelected()){
                bolconfort=true;
                String44=" AND Confort='II'";
            }
        }
        else{
            if(Confort4.isSelected()){
                bolconfort=true;
                String44=" OR Confort='II'";
            }
        }
        if(bolconfort==false){
            if(Confort5.isSelected()){
                bolconfort=true;
                String45=" AND Confort='III+'";
            }
        }
        else{
            if(Confort5.isSelected()){
                bolconfort=true;
                String45=" OR Confort='III+'";
            }
        }
        if(bolconfort==false){
            if(Confort6.isSelected()){
                bolconfort=true;
                String46=" AND Confort='III'";
            }
        }
        else{
            if(Confort6.isSelected()){
                bolconfort=true;
                String46=" OR Confort='III'";
            }
        }

        //MOBILA

        Boolean bolmob=false;
        String String51="";
        String String52="";
        String String53="";
        String String54="";
        if(bolmob==false){
            if(Mobila1.isSelected()){
                bolmob=true;
                String51=" AND Mobila='Nemobilat'";
            }
        }
        else{
            if(Mobila1.isSelected()){
                bolmob=true;
                String51=" OR Mobila='Nemobilat'";
            }
        }
        if(bolmob==false){
            if(Mobila2.isSelected()){
                bolmob=true;
                String52=" AND Mobila='Mobilat partial'";
            }
        }
        else{
            if(Mobila2.isSelected()){
                bolmob=true;
                String52=" OR Mobila='Mobilat partial'";
            }
        }
        if(bolmob==false){
            if(Mobila3.isSelected()){
                bolmob=true;
                String53=" AND Mobila='Mobilat complet'";
            }
        }
        else{
            if(Mobila3.isSelected()){
                bolmob=true;
                String53=" OR Mobila='Mobilat complet'";
            }
        }
        if(bolmob==false){
            if(Mobila4.isSelected()){
                bolmob=true;
                String54=" AND Mobila='Mobilat lux'";
            }
        }
        else{
            if(Mobila4.isSelected()){
                bolmob=true;
                String54=" OR Mobila='Mobilat lux'";
            }
        }

        //BUCATARIE

        Boolean bolbucat=false;
        String String61="";
        String String62="";
        String String63="";

        if(bolbucat==false){
            if(Bucatarie1.isSelected()){
                bolbucat=true;
                String61=" AND Bucatarie='Nemobilata'";
            }
        }
        else{
            if(Bucatarie1.isSelected()){
                bolbucat=true;
                String61=" OR Bucatarie='Nemobilata'";
            }
        }
        if(bolbucat==false){
            if(Bucatarie2.isSelected()){
                bolbucat=true;
                String62=" AND Bucatarie='Mobilata partial'";
            }
        }
        else{
            if(Bucatarie2.isSelected()){
                bolbucat=true;
                String62=" OR Bucatarie='Mobilata partial'";
            }
        }
        if(bolbucat==false){
            if(Bucatarie3.isSelected()){
                bolbucat=true;
                String63=" AND Bucatarie='Mobilata complet'";
            }
        }
        else{
            if(Bucatarie3.isSelected()){
                bolbucat=true;
                String63=" OR Bucatarie='Mobilata complet'";
            }
        }

        //Imbunatatiri reale
        String Stringp1="";
        if (ImbunatatiriRealeComboBox.getSelectedIndex()==1){
            Stringp1=" AND ImbunatatiriReale='NU'";
        }else
        if (ImbunatatiriRealeComboBox.getSelectedIndex()==2){
            Stringp1=" AND ImbunatatiriReale='DA'";
        }

        //TIP

        Boolean boltip=false;
        String String71="";
        String String72="";
        String String73="";
        if(boltip==false){
            if(Tip1.isSelected()){
                boltip=true;
                String71=" AND Compartimentare='Semidecomandat'";
            }
        }
        else{
            if(Tip1.isSelected()){
                boltip=true;
                String71=" OR Compartimentare='Semidecomandat'";
            }
        }
        if(boltip==false){
            if(Tip2.isSelected()){
                boltip=true;
                String72=" AND Compartimentare='Decomandat'";
            }
        }
        else{
            if(Tip2.isSelected()){
                boltip=true;
                String72=" OR Compartimentare='Decomandat'";
            }
        }
        if(boltip==false){
            if(Tip3.isSelected()){
                boltip=true;
                String73=" AND Compartimentare='Circular'";
            }
        }
        else{
            if(Tip3.isSelected()){
                boltip=true;
                String73=" OR Compartimentare='Circular'";
            }
        }

        //STARE

        Boolean bolstare=false;
        String String81="";
        String String82="";
        String String83="";
        if(bolstare==false){
            if(Stare1.isSelected()){
                bolstare=true;
                String81=" AND Stare='Actual'";
            }
        }
        else{
            if(Stare1.isSelected()){
                bolstare=true;
                String81=" OR Stare='Actual'";
            }
        }
        if(bolstare==false){
            if(Stare2.isSelected()){
                bolstare=true;
                String82=" AND Stare='Incorect'";
            }
        }
        else{
            if(Stare2.isSelected()){
                bolstare=true;
                String82=" OR Stare='Incorect'";
            }
        }
        if(bolstare==false){
            if(Stare3.isSelected()){
                bolstare=true;
                String83=" AND Stare='Vandut'";
            }
        }
        else{
            if(Stare3.isSelected()){
                bolstare=true;
                String83=" OR Stare='Vandut'";
            }
        }

        //METROU
        String StringMetrou="";
        if(Metrou.isSelected()){
            StringMetrou=" AND Metrou=1";
        }

        //EXCLUSIVITATE
        String StringExclusivitate="";
        if(Exclusivitate.isSelected()){
            StringExclusivitate=" AND Exclusivitate=1";
        }

        //PRET
        String Pret="";
        if(!PretTextField.getText().isEmpty()){
            Pret=" AND Pret<="+PretTextField.getText();
        }

        //ETAJ
        String Etaj="";
        if((!EtajInf.getText().isEmpty())&&(!EtajSup.getText().isEmpty())){
            Etaj=" AND Etaj BETWEEN "+EtajInf.getText()+" AND "+EtajSup.getText();
        }

        String StringParter= "";
        if(Parter.isSelected()){
            StringParter=" AND Parter=0";
        }
        String StringUltimul="";
        if(Ultimul.isSelected()){
            StringUltimul=" AND Ultimul=0";
        }

        //PUBLICATE
        String StringPublicate="";
        if(Publicate.isSelected()){
            StringPublicate=" AND Publicate=1";
        }

        //AN CONSTRCUTIE
        String anc="";
        if(!An.getText().isEmpty()){
            anc=" AND AnConstructie="+An.getText();
        }

        //STATUS
        String status="";
        if(Status.getSelectedIndex()==1){
            status=" AND Status='OK'";
        }
        if(Status.getSelectedIndex()==2){
            status=" AND Status='De revenit'";
        }

        //IMAGINI
        boolean boolpoze=false;
        String String91="";
        String String92="";
        if(boolpoze==false){
            if(CuPoze.isSelected()){
                String91=" AND Imagine=1";
                boolpoze=true;
            }
        }
        else{
            if(CuPoze.isSelected()){
                String91=" OR Imagine=1";
            }

        }
        if(boolpoze==false){
            if(FaraPoze.isSelected()){
                String92=" AND Imagine=0";
                boolpoze=true;
            }
        }
        else{
            if(FaraPoze.isSelected()){
                String92=" OR Imagine=0";
            }

        }

        ArrayList<ArrayList<Object>> ListaTabelLinii=new ArrayList<ArrayList<Object>>();
        ArrayList<Integer> ListaDeRevenit=new ArrayList<Integer>();

        java.sql.Statement stmt = null;
        Connection conn=null;

        try {

            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
            System.out.println("db connected");
            stmt = (java.sql.Statement) conn.createStatement();

            ResultSet rs1;
            System.out.println("select OIA,Zona,Reper,Strada,Camere,Compartimentare,SuprafataUtila,Etaj,Pret,Data "
                + "from aptinchiriere"
                + " where  OIA>1"+String11+String12+String13+String14+String21+String22+String23+String24
                + String31+String32+String33+String34+String35+String41+String42+String43+String44+String45+String46
                + String51+String52+String53+String54+String61+String62+String63+Stringp1+String71+String72+String73
                + String81+String82+String83+StringMetrou+String91+String92+StringExclusivitate+StringParter+StringUltimul
                +Pret+Etaj+status+StringPublicate+anc);
            String rez;

            if (nr==0){
                rez="";
            }else{
                rez=z.parametru;
            }

            rs1 = stmt.executeQuery("select OIA,Zona,Reper,Strada,Camere,Compartimentare,SuprafataUtila,Etaj,Pret,Data,Poza,Imagine,Status "
                + "from aptinchiriere"

                + " where  OIA>=1"+rez+String11+String12+String13+String14+String21+String22+String23+String24
                + String31+String32+String33+String34+String35+String41+String42+String43+String44+String45+String46
                + String51+String52+String53+String54+String61+String62+String63+Stringp1+String71+String72+String73
                + String81+String82+String83+StringMetrou+String91+String92+StringExclusivitate+StringParter+StringUltimul
                +Pret+Etaj+status+StringPublicate+anc);

            int count=0;

            while (rs1.next()) {

                ListaTabelLinii.add(new ArrayList<Object>());
                ListaTabelLinii.get(count).add(rs1.getInt("OIA"));

                byte[] imgData = rs1.getBytes("Poza");//Here r1.getBytes() extract byte data from resultSet

                File file = new File("image.jpg");

                BufferedImage image = byteArrayToImage(imgData);
                ImageIcon img=new ImageIcon(resize(image,100,100));

                ListaTabelLinii.get(count).add(img);

                ListaTabelLinii.get(count).add(rs1.getString("Zona"));
                ListaTabelLinii.get(count).add(rs1.getString("Reper"));
                ListaTabelLinii.get(count).add(rs1.getString("Strada"));
                ListaTabelLinii.get(count).add(rs1.getString("Camere"));
                ListaTabelLinii.get(count).add(rs1.getString("Compartimentare"));
                ListaTabelLinii.get(count).add(rs1.getInt("SuprafataUtila"));
                ListaTabelLinii.get(count).add(rs1.getInt("Etaj"));
                ListaTabelLinii.get(count).add(rs1.getInt("Pret"));
                ListaTabelLinii.get(count).add(rs1.getString("Data"));
                if(rs1.getString("Status").matches("OK")){
                    ListaDeRevenit.add(1);

                }
                else
                {
                    ListaDeRevenit.add(0);
                }
                count++;

            }

            for(int i=0;i<ListaTabelLinii.size();i++){
                System.out.println(ListaTabelLinii.get(i));
            }
            System.out.println(ListaTabelLinii.size());

            String[] columnNames = {"Cod","Poza","Zona","Reper","Strada","Cam","Compartimentare","ST","Etaj","Pret","Data"};

            Object[][] data =new Object[ListaTabelLinii.size()][11];
            for(int i=0;i<ListaTabelLinii.size();i++){
                for(int j=0;j<11;j++){
                    data[i][j]=ListaTabelLinii.get(i).get(j);
                }
            }
            //
            DefaultTableModel model = new DefaultTableModel(data, columnNames){
                public Class getColumnClass(int column)
                {
                    if (ListaTabelLinii.size()>0){
                        return getValueAt(0, column).getClass();
                    }else return null;
                }
                @Override
                public boolean isCellEditable(int row, int column) {
                    //all cells false
                    return false;
                }

            };
            DefaultTableCellRenderer a= new DefaultTableCellRenderer()
            {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isEditable, int row, int column)
                {
                    final Component c = super.getTableCellRendererComponent(table, value, isSelected, isEditable, row, column);

                    //System.out.println(ListaDeRevenit.get(row));
                    if(ListaDeRevenit.get(row)==1){
                        c.setForeground(Color.BLACK);
                    }
                    else{
                        c.setForeground(Color.RED);
                    }

                    return c;
                }

            };
            if (ListaTabelLinii.size()>0){
                jTable1.setSelectionForeground(Color.BLACK);
                jTable1.setSelectionBackground(Color.WHITE);
                jTable1.setSelectionMode(0);

                jTable1.setDefaultRenderer(model.getColumnClass(2), a);

                jTable1.setDefaultRenderer(model.getColumnClass(0), a);

                jTable1.setModel(model);
                jTable1.setRowHeight(100);
                jTable1.setVisible(true);
                //jTable1.
            }
            if (ListaTabelLinii.size()==0){
                JOptionPane.showMessageDialog(CautaOIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
                jTable1.setVisible(false);
            }
            //
        }  catch(Exception e){
            e.printStackTrace();
        }

    }//GEN-LAST:event_CautaButtonActionPerformed

    private void ImbunatatiriRealeComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImbunatatiriRealeComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ImbunatatiriRealeComboBoxActionPerformed

    private void PretTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PretTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PretTextFieldActionPerformed

    private void PretPanaLaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PretPanaLaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PretPanaLaTextFieldActionPerformed

     public void get_alldatecod(){
          java.sql.Statement stmt = null;
        Connection conn=null;
        

        
 try {
        
        Class.forName("com.mysql.jdbc.Driver");

       conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
        System.out.println("db connected");
        stmt = (java.sql.Statement) conn.createStatement();
        ArrayList<ArrayList<Object>> ListaTabelLinii=new ArrayList<ArrayList<Object>>();
        ArrayList<Integer> ListaDeRevenit=new ArrayList<Integer>(); 
        ResultSet rs1;
        rs1 = stmt.executeQuery("select OIA,Zona,Reper,Strada,Camere,Compartimentare,SuprafataUtila,Etaj,Pret,Data,Poza,Imagine,Status "
                + "from aptinchiriere"
                
                + " where  OIA>=1");
        
       int count=0;
        while (rs1.next()) {
          
        
            ListaTabelLinii.add(new ArrayList<Object>());
             ListaTabelLinii.get(count).add(rs1.getInt("OIA"));
              byte[] imgData = rs1.getBytes("Poza");//Here r1.getBytes() extract byte data from resultSet 
             
              File file = new File("image.jpg");
           
             BufferedImage image = byteArrayToImage(imgData);
             ImageIcon img=new ImageIcon(resize(image,100,100));

            
             ListaTabelLinii.get(count).add(img);
             ListaTabelLinii.get(count).add(rs1.getString("Zona"));
             ListaTabelLinii.get(count).add(rs1.getString("Reper"));
             ListaTabelLinii.get(count).add(rs1.getString("Strada"));
             ListaTabelLinii.get(count).add(rs1.getString("Camere"));
             ListaTabelLinii.get(count).add(rs1.getString("Compartimentare"));
             ListaTabelLinii.get(count).add(rs1.getInt("SuprafataUtila"));
             ListaTabelLinii.get(count).add(rs1.getInt("Etaj"));
             ListaTabelLinii.get(count).add(rs1.getInt("Pret"));
             ListaTabelLinii.get(count).add(rs1.getString("Data"));
             //JButton b=new JButton("Ion");
             //b.setLocation(20, 30);
             //ListaTabelLinii.get(count).add("Orice");
             //b.
             if(rs1.getString("Status").equals("OK")){
                 ListaDeRevenit.add(1);
                 
             }
             else
             {
               ListaDeRevenit.add(0);  
             }
             count++;
       
            
    }
        
        
//        for(int i=0;i<ListaTabelColoane.size();i++){
//            System.out.println(ListaTabelColoane.get(i));
//        }
        for(int i=0;i<ListaTabelLinii.size();i++){
            System.out.println(ListaTabelLinii.get(i));
        }
        System.out.println(ListaTabelLinii.size());
        
         String[] columnNames = {"Cod","Poza","Zona","Reper","Strada","Cam","Tip","ST","Etaj","Pret","Data"};
       
          Object[][] data =new Object[ListaTabelLinii.size()][11];
          for(int i=0;i<ListaTabelLinii.size();i++){
              for(int j=0;j<11;j++){
                  data[i][j]=ListaTabelLinii.get(i).get(j);
              }
          }
          
          DefaultTableModel model = new DefaultTableModel(data, columnNames){
            public Class getColumnClass(int column)
            {
                if (ListaTabelLinii.size()>0){
                return getValueAt(0, column).getClass();
                }else return null;
            }
             @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
    
            
        };
       
         DefaultTableCellRenderer a= new DefaultTableCellRenderer()
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isEditable, int row, int column)
    {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, isEditable, row, column);
        
            //System.out.println(ListaDeRevenit.get(row));
            if(ListaDeRevenit.get(row)==1){
                c.setBackground(Color.WHITE);
            }
            else{
        c.setBackground(Color.RED);
            }
        
        return c;
    }
    
   
};

          
        if (ListaTabelLinii.size()>0){
      jTable1.setSelectionForeground(Color.BLACK);
      jTable1.setSelectionBackground(Color.WHITE);
      jTable1.setSelectionMode(0);
      
      jTable1.setDefaultRenderer(model.getColumnClass(2), a);
      
       jTable1.setDefaultRenderer(model.getColumnClass(0), a);

       jTable1.setModel(model);
        jTable1.setRowHeight(100);
        jTable1.setVisible(true);
       }
        if (ListaTabelLinii.size()==0){
            JOptionPane.showMessageDialog(CautaOIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
            jTable1.setVisible(false);
        }
      //  
 }  catch(Exception e){
                e.printStackTrace();
                }
        
    }
    public void get_alldatecod(int c){
         Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet myRs = null;
        

        
 try {
        
        Class.forName("com.mysql.jdbc.Driver");

       conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
        System.out.println("db connected");
        //stmt = (java.sql.Statement) conn.createStatement();
        ArrayList<ArrayList<Object>> ListaTabelLinii=new ArrayList<ArrayList<Object>>();
         ArrayList<Integer> ListaDeRevenit=new ArrayList<Integer>();
        
        ResultSet rs1;
       stmt=conn.prepareStatement("select OIA,Zona,Reper,Strada,Camere,Compartimentare,SuprafataUtila,Etaj,Pret,Data,Poza,Imagine,Status "
                + "from aptinchiriere"
                + " where  OIA LIKE ? ");
       
        stmt.setInt(1, c);
        
        rs1 = stmt.executeQuery();
       //stmt.setInt(1, cod);
       int count=0;
        while (rs1.next()) {
          
        
            ListaTabelLinii.add(new ArrayList<Object>());
             ListaTabelLinii.get(count).add(rs1.getInt("OIA"));
              byte[] imgData = rs1.getBytes("Poza");//Here r1.getBytes() extract byte data from resultSet 
             
              File file = new File("image.jpg");
           
             BufferedImage image = byteArrayToImage(imgData);
             ImageIcon img=new ImageIcon(resize(image,100,100));
           
            
             ListaTabelLinii.get(count).add(img);
             ListaTabelLinii.get(count).add(rs1.getString("Zona"));
             ListaTabelLinii.get(count).add(rs1.getString("Reper"));
             ListaTabelLinii.get(count).add(rs1.getString("Strada"));
             ListaTabelLinii.get(count).add(rs1.getInt("Camere"));
             ListaTabelLinii.get(count).add(rs1.getString("Compartimentare"));
             ListaTabelLinii.get(count).add(rs1.getInt("SuprafataUtila"));
             ListaTabelLinii.get(count).add(rs1.getInt("Etaj"));
             ListaTabelLinii.get(count).add(rs1.getInt("Pret"));
             ListaTabelLinii.get(count).add(rs1.getString("Data"));
             if(rs1.getString("Status").equals("OK")){
                 ListaDeRevenit.add(1);
                 
             }
             else
             {
               ListaDeRevenit.add(0);  
             }
             count++;
       
            
    }
//        for(int i=0;i<ListaTabelColoane.size();i++){
//            System.out.println(ListaTabelColoane.get(i));
//        }
        for(int i=0;i<ListaTabelLinii.size();i++){
            System.out.println(ListaTabelLinii.get(i));
        }
        System.out.println(ListaTabelLinii.size());
        
         String[] columnNames = {"Cod","Poza","Zona","Reper","Strada","Cam","Tip","ST","Etaj","Pret","Data"};
       
          Object[][] data =new Object[ListaTabelLinii.size()][11];
          for(int i=0;i<ListaTabelLinii.size();i++){
              for(int j=0;j<11;j++){
                  data[i][j]=ListaTabelLinii.get(i).get(j);
              }
          }
        
          
         DefaultTableModel model = new DefaultTableModel(data, columnNames){
            public Class getColumnClass(int column)
            {
                if (ListaTabelLinii.size()>0){
                return getValueAt(0, column).getClass();
                }else return null;
            }
             @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
        };
        
       DefaultTableCellRenderer a= new DefaultTableCellRenderer()
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isEditable, int row, int column)
    {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, isEditable, row, column);
        
            //System.out.println(ListaDeRevenit.get(row));
            if(ListaDeRevenit.get(row)==1){
                c.setBackground(Color.WHITE);
            }
            else{
        c.setBackground(Color.RED);
            }
        
        return c;
    }
    
   
};

          
        if (ListaTabelLinii.size()>0){
      jTable1.setSelectionForeground(Color.BLACK);
      jTable1.setSelectionBackground(Color.WHITE);
      jTable1.setSelectionMode(0);
      
      jTable1.setDefaultRenderer(model.getColumnClass(2), a);
      
       jTable1.setDefaultRenderer(model.getColumnClass(0), a);

       jTable1.setModel(model);
        jTable1.setRowHeight(100);
        jTable1.setVisible(true);
       }
        if (ListaTabelLinii.size()==0){
            JOptionPane.showMessageDialog(CautaOIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
            jTable1.setVisible(false);
        }
      //  
 }  catch(Exception e){
                e.printStackTrace();
                }
            
    }
    
    public void get_alldatecodBetween(int c1,int c2){
        Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet myRs = null;
        

        
 try {
        
        Class.forName("com.mysql.jdbc.Driver");

       conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
        System.out.println("db connected");
        //stmt = (java.sql.Statement) conn.createStatement();
        ArrayList<ArrayList<Object>> ListaTabelLinii=new ArrayList<ArrayList<Object>>();
        ArrayList<Integer> ListaDeRevenit=new ArrayList<Integer>();
        ResultSet rs1;
       stmt=conn.prepareStatement("select OIA,Zona,Reper,Strada,Camere,Compartimentare,SuprafataUtila,Etaj,Pret,Data,Poza,Imagine,Status "
                + "from aptinchiriere"
                + " where  Pret BETWEEN ? and ?");
       
        stmt.setInt(1, c1);
        stmt.setInt(2, c2);
        
        rs1 = stmt.executeQuery();
       //stmt.setInt(1, cod);
      int count=0;
        while (rs1.next()) {
          
        
            ListaTabelLinii.add(new ArrayList<Object>());
             ListaTabelLinii.get(count).add(rs1.getInt("OIA"));
              byte[] imgData = rs1.getBytes("Poza");//Here r1.getBytes() extract byte data from resultSet 
             
              File file = new File("image.jpg");
           
             BufferedImage image = byteArrayToImage(imgData);
             ImageIcon img=new ImageIcon(resize(image,100,100));
           
            
             ListaTabelLinii.get(count).add(img);
             ListaTabelLinii.get(count).add(rs1.getString("Zona"));
             ListaTabelLinii.get(count).add(rs1.getString("Reper"));
             ListaTabelLinii.get(count).add(rs1.getString("Strada"));
             ListaTabelLinii.get(count).add(rs1.getInt("Camere"));
             ListaTabelLinii.get(count).add(rs1.getString("Compartimentare"));
             ListaTabelLinii.get(count).add(rs1.getInt("SuprafataUtila"));
             ListaTabelLinii.get(count).add(rs1.getInt("Etaj"));
             ListaTabelLinii.get(count).add(rs1.getInt("Pret"));
             ListaTabelLinii.get(count).add(rs1.getString("Data"));
             if(rs1.getString("Status").equals("OK")){
                 ListaDeRevenit.add(1);
                 
             }
             else
             {
               ListaDeRevenit.add(0);  
             }
             count++;
       
            
    }
//        for(int i=0;i<ListaTabelColoane.size();i++){
//            System.out.println(ListaTabelColoane.get(i));
//        }
        for(int i=0;i<ListaTabelLinii.size();i++){
            System.out.println(ListaTabelLinii.get(i));
        }
        System.out.println(ListaTabelLinii.size());
        
         String[] columnNames = {"Cod","Poza","Zona","Reper","Strada","Cam","Tip","ST","Etaj","Pret","Data"};
       
          Object[][] data =new Object[ListaTabelLinii.size()][11];
          for(int i=0;i<ListaTabelLinii.size();i++){
              for(int j=0;j<11;j++){
                  data[i][j]=ListaTabelLinii.get(i).get(j);
              }
          }
        
          
         DefaultTableModel model = new DefaultTableModel(data, columnNames){
            public Class getColumnClass(int column)
            {
                if (ListaTabelLinii.size()>0){
                return getValueAt(0, column).getClass();
                }else return null;
            }
             @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
        };
        
       DefaultTableCellRenderer a= new DefaultTableCellRenderer()
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isEditable, int row, int column)
    {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, isEditable, row, column);
        
            //System.out.println(ListaDeRevenit.get(row));
            if(ListaDeRevenit.get(row)==1){
                c.setBackground(Color.WHITE);
            }
            else{
        c.setBackground(Color.RED);
            }
        
        return c;
    }
    
   
};

          
        if (ListaTabelLinii.size()>0){
      jTable1.setSelectionForeground(Color.BLACK);
      jTable1.setSelectionBackground(Color.WHITE);
      jTable1.setSelectionMode(0);
      
      jTable1.setDefaultRenderer(model.getColumnClass(2), a);
      
       jTable1.setDefaultRenderer(model.getColumnClass(0), a);

       jTable1.setModel(model);
        jTable1.setRowHeight(100);
        jTable1.setVisible(true);
       }
        if (ListaTabelLinii.size()==0){
            JOptionPane.showMessageDialog(CautaOIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
            jTable1.setVisible(false);
        }
      //  
 }  catch(Exception e){
                e.printStackTrace();
                }
            
    }
    

    
    
    
    private void CautaDupaPretButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CautaDupaPretButtonActionPerformed
        // TODO add your handling code here:

        boolean ok=true;

        boolean flagInt=false;
        if(PretDeLaTextField.getText().isEmpty()){

            //this.PretLabel.setForeground(Color.red);
            ok=false;

        }else{
            //System.out.println("da");
            try{
                Integer.parseInt(PretDeLaTextField.getText());
            }
            catch(NumberFormatException e){
                flagInt=true;
            }
            if(flagInt==true){
                //this.PretLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(CautaOIA.this,"Va rugam sa introduceti un pret minim valid","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ok==false){
            JOptionPane.showMessageDialog(CautaOIA.this,"Va rugam sa introduceti un pret minim valid","Error Message",JOptionPane.ERROR_MESSAGE);
        }

        ok=true;

        flagInt=false;
        if(PretPanaLaTextField.getText().isEmpty()){

            //this.PretLabel.setForeground(Color.red);
            ok=false;

        }else{
            //System.out.println("da");
            try{
                Integer.parseInt(PretPanaLaTextField.getText());
            }
            catch(NumberFormatException e){
                flagInt=true;
            }
            if(flagInt==true){
                //this.PretLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(CautaOIA.this,"Va rugam sa introduceti un pret maxim valid","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ok==false){
            JOptionPane.showMessageDialog(CautaOIA.this,"Va rugam sa introduceti un pret maxim valid","Error Message",JOptionPane.ERROR_MESSAGE);
        }

        String p1 = PretDeLaTextField.getText();
        String p2=PretPanaLaTextField.getText();

        if (flagInt==false){
            if ((p1 != null && p1.trim().length() > 0)&&(p2 != null && p2.trim().length() > 0)){
                //get_alldate();
                int c1=Integer.parseInt(p1);
                int c2=Integer.parseInt(p2);
                get_alldatecodBetween(c1,c2);

            }
            //else {
                //	get_alldatecod();
                //}
        }

    }//GEN-LAST:event_CautaDupaPretButtonActionPerformed

    private void EtajInfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtajInfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EtajInfActionPerformed

    private void Pozitie1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pozitie1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Pozitie1ActionPerformed

    private void CautaDupaCodTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CautaDupaCodTextFieldActionPerformed

    }//GEN-LAST:event_CautaDupaCodTextFieldActionPerformed

    private void CautaDupaCodTextFieldKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_CautaDupaCodTextFieldKeyReleased

    }//GEN-LAST:event_CautaDupaCodTextFieldKeyReleased

    private void CautaDupaCodButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CautaDupaCodButtonActionPerformed

        boolean ok=true;

        boolean flagInt=false;
        if(CautaDupaCodTextField.getText().isEmpty()){

            //this.PretLabel.setForeground(Color.red);
            ok=false;

        }else{
            //System.out.println("da");
          //  if (CautaDupaCodTextField.getText().startsWith("OIA ")==false)
            try{
                Integer.parseInt(CautaDupaCodTextField.getText());
            }
            catch(NumberFormatException e){
                flagInt=true;
            }
            if(flagInt==true){
                //this.PretLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(CautaOIA.this,"Va rugam sa introduceti un cod valid","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }

        // ArrayList<ArrayList<Object>> ListaTabelLinii=new ArrayList<ArrayList<Object>>();

        String cod = CautaDupaCodTextField.getText();

         if (flagInt==false){
					if (cod != null && cod.trim().length() > 0) {
                                           // if (cod.startsWith("OVA ")==true){
                                                //String aux=cod.substring(4);
                                                int c=Integer.parseInt(cod);
                                                /*System.out.println(cod);
                                                System.out.println(cod.length());
                                                int c=Integer.parseInt(aux);
                                                get_alldatecod(c);
                                            }else{
                                                
                                                int c=Integer.parseInt(cod);*/
                                                get_alldatecod(c);
                                           // }
                                                
                                                
					} else {
						get_alldatecod();
					}
                                        }

    }//GEN-LAST:event_CautaDupaCodButtonActionPerformed

     public void get_alldatestrada(String nume){
       Connection conn=null;
		PreparedStatement stmt = null;
		ResultSet myRs = null;
        

        
 try {
        
        Class.forName("com.mysql.jdbc.Driver");

       conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
        System.out.println("db connected");
        //stmt = (java.sql.Statement) conn.createStatement();
        ArrayList<ArrayList<Object>> ListaTabelLinii=new ArrayList<ArrayList<Object>>();
         ArrayList<Integer> ListaDeRevenit=new ArrayList<Integer>();
        
        ResultSet rs1;
       stmt=conn.prepareStatement("select OIA,Zona,Reper,Strada,Camere,Compartimentare,SuprafataUtila,Etaj,Pret,Data,Poza,Imagine,Status "
                + " from aptinchiriere "
                + " where Strada Like '"+nume+"%'");
       
        //stmt.setString(1, nume);
        
        rs1 = stmt.executeQuery();
       //stmt.setInt(1, cod);
       int count=0;
        while (rs1.next()) {
          
        
            ListaTabelLinii.add(new ArrayList<Object>());
             ListaTabelLinii.get(count).add(rs1.getInt("OIA"));
              byte[] imgData = rs1.getBytes("Poza");//Here r1.getBytes() extract byte data from resultSet 
             
              File file = new File("image.jpg");
           
             BufferedImage image = byteArrayToImage(imgData);
             ImageIcon img=new ImageIcon(resize(image,100,100));
           
            
             ListaTabelLinii.get(count).add(img);
             ListaTabelLinii.get(count).add(rs1.getString("Zona"));
             ListaTabelLinii.get(count).add(rs1.getString("Reper"));
             ListaTabelLinii.get(count).add(rs1.getString("Strada"));
             ListaTabelLinii.get(count).add(rs1.getString("Camere"));
             ListaTabelLinii.get(count).add(rs1.getString("Compartimentare"));
             ListaTabelLinii.get(count).add(rs1.getInt("SuprafataUtila"));
             ListaTabelLinii.get(count).add(rs1.getInt("Etaj"));
             ListaTabelLinii.get(count).add(rs1.getInt("Pret"));
             ListaTabelLinii.get(count).add(rs1.getString("Data"));
             if(rs1.getString("Status").equals("OK")){
                 ListaDeRevenit.add(1);
                 
             }
             else
             {
               ListaDeRevenit.add(0);  
             }
             count++;
       
            
    }
//        for(int i=0;i<ListaTabelColoane.size();i++){
//            System.out.println(ListaTabelColoane.get(i));
//        }
        for(int i=0;i<ListaTabelLinii.size();i++){
            System.out.println(ListaTabelLinii.get(i));
        }
        System.out.println(ListaTabelLinii.size());
        
         String[] columnNames = {"Cod","Poza","Zona","Reper","Strada","Cam","Tip","ST","Etaj","Pret","Data"};
       
          Object[][] data =new Object[ListaTabelLinii.size()][11];
          for(int i=0;i<ListaTabelLinii.size();i++){
              for(int j=0;j<11;j++){
                  data[i][j]=ListaTabelLinii.get(i).get(j);
              }
          }
        
          
         DefaultTableModel model = new DefaultTableModel(data, columnNames){
            public Class getColumnClass(int column)
            {
                if (ListaTabelLinii.size()>0){
                return getValueAt(0, column).getClass();
                }else return null;
            }
             @Override
    public boolean isCellEditable(int row, int column) {
       //all cells false
       return false;
    }
        };
        
       DefaultTableCellRenderer a= new DefaultTableCellRenderer()
{
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean isEditable, int row, int column)
    {
        final Component c = super.getTableCellRendererComponent(table, value, isSelected, isEditable, row, column);
        
            //System.out.println(ListaDeRevenit.get(row));
            if(ListaDeRevenit.get(row)==1){
                c.setBackground(Color.WHITE);
            }
            else{
        c.setBackground(Color.RED);
            }
        
        return c;
    }
    
   
};

          
        if (ListaTabelLinii.size()>0){
      jTable1.setSelectionForeground(Color.BLACK);
      jTable1.setSelectionBackground(Color.WHITE);
      jTable1.setSelectionMode(0);
      
      jTable1.setDefaultRenderer(model.getColumnClass(2), a);
      
       jTable1.setDefaultRenderer(model.getColumnClass(0), a);

       jTable1.setModel(model);
        jTable1.setRowHeight(100);
        jTable1.setVisible(true);
       }
        if (ListaTabelLinii.size()==0){
            JOptionPane.showMessageDialog(CautaOIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
            jTable1.setVisible(false);
        }
      //  
 }  catch(Exception e){
                e.printStackTrace();
                }
            
            
  }
    
     
    
    
    private void CautaDupaStradaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CautaDupaStradaButtonActionPerformed

        boolean ok=true;

        String nume = CautaDupaStradaTextField.getText();

        if (nume!= null && nume.trim().length() > 0) {
            /*if (nume.startsWith("OIA ")==true){
                String aux=nume.substring(4);
                System.out.println(nume);
                System.out.println(nume.length());
                int c=Integer.parseInt(aux);
                get_alldatecod(c);
            }else{
                //int c=Integer.parseInt(cod);*/{
           // int c=Integer.parseInt(nume);
                get_alldatestrada(nume);
            }

        } else {
            get_alldatecod();
        }

    }//GEN-LAST:event_CautaDupaStradaButtonActionPerformed

    private void ExclusivitateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExclusivitateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExclusivitateActionPerformed

    private void AgentRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AgentRadioButtonActionPerformed
        // TODO add your handling code here:

        // AgentComboBox.

    }//GEN-LAST:event_AgentRadioButtonActionPerformed

    private void Confort1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confort1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Confort1ActionPerformed

    private void CuPozeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CuPozeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CuPozeActionPerformed

    private void WebComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WebComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WebComboBoxActionPerformed

    private void Mobila3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Mobila3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Mobila3ActionPerformed

    private void AnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AnActionPerformed

    private void ZonaButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZonaButonActionPerformed
        // TODO add your handling code here:
            z= new Zona();
            nr++;
        z.setVisible(true);
    }//GEN-LAST:event_ZonaButonActionPerformed

    private void ResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ResetActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
            CautaOIA cautaOIA=new CautaOIA();
            cautaOIA.setVisible(true);
    }//GEN-LAST:event_ResetActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CautaOIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CautaOIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CautaOIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CautaOIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CautaOIA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AgentComboBox;
    private javax.swing.JRadioButton AgentRadioButton;
    private javax.swing.JTextField An;
    private javax.swing.JCheckBox Bucatarie1;
    private javax.swing.JCheckBox Bucatarie2;
    private javax.swing.JCheckBox Bucatarie3;
    private javax.swing.JCheckBox Camera1;
    private javax.swing.JCheckBox Camera2;
    private javax.swing.JCheckBox Camera3;
    private javax.swing.JCheckBox Camera4;
    private javax.swing.JCheckBox Camera5;
    private javax.swing.JButton CautaButton;
    private javax.swing.JButton CautaDupaCodButton;
    private javax.swing.JTextField CautaDupaCodTextField;
    private javax.swing.JButton CautaDupaPretButton;
    private javax.swing.JButton CautaDupaStradaButton;
    private javax.swing.JTextField CautaDupaStradaTextField;
    private javax.swing.JCheckBox Clientifavoriti;
    private javax.swing.JCheckBox Confort1;
    private javax.swing.JCheckBox Confort2;
    private javax.swing.JCheckBox Confort3;
    private javax.swing.JCheckBox Confort4;
    private javax.swing.JCheckBox Confort5;
    private javax.swing.JCheckBox Confort6;
    private javax.swing.JCheckBox CuPoze;
    private javax.swing.JCheckBox Dest1;
    private javax.swing.JCheckBox Dest2;
    private javax.swing.JCheckBox Dest3;
    private javax.swing.JCheckBox Dest4;
    private javax.swing.JComboBox<String> EchipaComboBox;
    private javax.swing.JRadioButton EchipaRadioButton;
    private javax.swing.JTextField EtajInf;
    private javax.swing.JTextField EtajSup;
    private javax.swing.JCheckBox Exclusivitate;
    private javax.swing.JCheckBox FaraPoze;
    private javax.swing.JComboBox<String> ImbunatatiriRealeComboBox;
    private javax.swing.JCheckBox Metrou;
    private javax.swing.JCheckBox Mobila1;
    private javax.swing.JCheckBox Mobila2;
    private javax.swing.JCheckBox Mobila3;
    private javax.swing.JCheckBox Mobila4;
    private javax.swing.JCheckBox Parter;
    private javax.swing.JCheckBox Pozitie1;
    private javax.swing.JCheckBox Pozitie2;
    private javax.swing.JCheckBox Pozitie3;
    private javax.swing.JCheckBox Pozitie4;
    private javax.swing.JTextField PretDeLaTextField;
    private javax.swing.JTextField PretPanaLaTextField;
    private javax.swing.JTextField PretTextField;
    private javax.swing.JCheckBox Publicate;
    private javax.swing.JButton Reset;
    private javax.swing.JCheckBox Stare1;
    private javax.swing.JCheckBox Stare2;
    private javax.swing.JCheckBox Stare3;
    private javax.swing.JComboBox<String> Status;
    private javax.swing.JCheckBox Tip1;
    private javax.swing.JCheckBox Tip2;
    private javax.swing.JCheckBox Tip3;
    private javax.swing.JCheckBox Ultimul;
    private javax.swing.JComboBox<String> WebComboBox;
    private javax.swing.JButton ZonaButon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void insertUpdate(DocumentEvent e) {
        //search();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        //search();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        //search();
    }
}
