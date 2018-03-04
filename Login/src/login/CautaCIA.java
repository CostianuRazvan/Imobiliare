/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Serdin
 */
public class CautaCIA extends javax.swing.JFrame implements DocumentListener{

    Zona z;
    int nr=0;
    public CautaCIA() {
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
        ArrayList<String> Clienti=new ArrayList<String>();
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
       rs1 = stmt.executeQuery("select C.CIA,C.Garsoniera,C.2camere,C.3camere,C.4camere,C.4camerep,CL.Nume "
               + "from cerereia C,clienti CL where CL.ID=C.ClientID and C.CIA Like '"+text+"%'");
       while(rs1.next()){
           String rez="";
           if (rs1.getInt("C.Garsoniera")==1){
               rez=rez+"Garsoniera ";
           }
           if (rs1.getInt("C.2camere")==1){
               rez=rez+"2 ";
           }
           if (rs1.getInt("C.3camere")==1){
               rez=rez+"3 ";
           }
           if (rs1.getInt("C.4camere")==1){
               rez=rez+"4 ";
           }
           if (rs1.getInt("C.4camerep")==1){
               rez=rez+"4+ ";
           }
         Camere.add(rez);
         Clienti.add(rs1.getString("CL.Nume"));
         String aux;
        aux= rs1.getString("C.CIA");
        Numere.add(aux);
       }
  
                }
       catch(Exception e){
                    e.printStackTrace();
                }
                
                String Numere1[]=new String[Camere.size()];
                for(int i=0;i<Camere.size();i++){
                    Numere1[i]="CIA "+Numere.get(i)+"|"+Camere.get(i)+" camere| Nume. "+Clienti.get(i);
                }
                if (Numere1.length>0)
                return Numere1; else 
                    return null;
    }
    public String[] returneazaClient(String text){
        ArrayList<String> Camere=new ArrayList<String>();
        ArrayList<String> Numere=new ArrayList<String>();
        ArrayList<String> Clienti=new ArrayList<String>();
        java.sql.Statement stmt = null;
                try {
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");

       Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
       // System.out.println("db connected");
        stmt = (java.sql.Statement) conn.createStatement();

        ResultSet rs1;
       rs1 = stmt.executeQuery("select C.CIA,C.Garsoniera,C.2camere,C.3camere,C.4camere,C.4camerep,CL.Nume "
               + "from cerereia C,clienti CL where CL.ID=C.ClientID and CL.Nume Like '"+text+"%'");
       while(rs1.next()){
         String rez="";
           if (rs1.getInt("C.Garsoniera")==1){
               rez=rez+"Garsoniera ";
           }
           if (rs1.getInt("C.2camere")==1){
               rez=rez+"2 ";
           }
           if (rs1.getInt("C.3camere")==1){
               rez=rez+"3 ";
           }
           if (rs1.getInt("C.4camere")==1){
               rez=rez+"4 ";
           }
           if (rs1.getInt("C.4camerep")==1){
               rez=rez+"4+ ";
           }
         Camere.add(rez);
         Clienti.add(rs1.getString("CL.Nume"));
         String aux;
        aux= rs1.getString("C.CIA");
        Numere.add(aux);
       }

                }
       catch(Exception e){
                    e.printStackTrace();
                }
                
                String Numere1[]=new String[Camere.size()];
                for(int i=0;i<Camere.size();i++){
                    Numere1[i]="CIA "+Numere.get(i)+"|"+Camere.get(i)+" camere| Nume "+Clienti.get(i);
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
        detaliiCIA a;
        a=new detaliiCIA(i);
        a.setVisible(true);
}
     @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
        EtajSup = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CautaDupaCodTextField = new javax.swing.JTextField();
        CautaDupaCodButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        CautaDupaClientTextField = new javax.swing.JTextField();
        CautaDupaClientButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Parter = new javax.swing.JCheckBox();
        Ultimul = new javax.swing.JCheckBox();
        jLabel20 = new javax.swing.JLabel();
        Exclusivitate = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        Tip1 = new javax.swing.JCheckBox();
        Tip2 = new javax.swing.JCheckBox();
        Tip3 = new javax.swing.JCheckBox();
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
        jLabel10 = new javax.swing.JLabel();
        Metrou = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        Confort1 = new javax.swing.JCheckBox();
        Confort2 = new javax.swing.JCheckBox();
        Confort3 = new javax.swing.JCheckBox();
        Confort4 = new javax.swing.JCheckBox();
        Confort5 = new javax.swing.JCheckBox();
        Confort6 = new javax.swing.JCheckBox();
        jLabel27 = new javax.swing.JLabel();
        WebComboBox = new javax.swing.JComboBox<>();
        jLabel28 = new javax.swing.JLabel();
        Stare1 = new javax.swing.JCheckBox();
        Stare2 = new javax.swing.JCheckBox();
        Stare3 = new javax.swing.JCheckBox();
        ZonaButon = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setBorder(null);
        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jButton4.setText("Cauta");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Reset");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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
        jLabel3.setText("Client:");

        CautaDupaClientTextField.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        CautaDupaClientButton.setText("Selecteaza");
        CautaDupaClientButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CautaDupaClientButtonActionPerformed(evt);
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

        jLabel21.setBackground(new java.awt.Color(255, 255, 102));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("         Compartimentare:");
        jLabel21.setOpaque(true);

        Tip1.setText("Semidecomandat");

        Tip2.setText("Decomandat");

        Tip3.setText("Circular");

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

        jLabel10.setBackground(new java.awt.Color(255, 255, 102));
        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel10.setText("Metrou:");
        jLabel10.setOpaque(true);

        Metrou.setText("Metrou");

        jLabel11.setBackground(new java.awt.Color(255, 255, 102));
        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel11.setText("  Confort:");
        jLabel11.setOpaque(true);

        Confort1.setText("I+");
        Confort1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confort1ActionPerformed(evt);
            }
        });

        Confort2.setText("I");

        Confort3.setText("II+");

        Confort4.setText("II");

        Confort5.setText("III+");

        Confort6.setText("III");

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

        jLabel28.setBackground(new java.awt.Color(255, 255, 102));
        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel28.setText("             Stare:");
        jLabel28.setOpaque(true);

        Stare1.setText("Actual");

        Stare2.setText("Incorect");

        Stare3.setText("Vandut");

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
                        .addComponent(ZonaButon, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Camera3)
                            .addComponent(Camera2)
                            .addComponent(Camera1)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Camera4)
                            .addComponent(Camera5)
                            .addComponent(Metrou)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Confort3)
                            .addComponent(Confort6)
                            .addComponent(Confort5)
                            .addComponent(Confort4)
                            .addComponent(Confort1)
                            .addComponent(Confort2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(CautaDupaCodTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CautaDupaCodButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 280, Short.MAX_VALUE)
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
                .addComponent(CautaDupaClientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(CautaDupaClientButton)
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
                        .addGap(44, 44, 44)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(WebComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Stare1)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Stare2)
                            .addComponent(Stare3)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))))
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
                                .addComponent(Camera1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(Camera2)
                                .addGap(32, 32, 32)
                                .addComponent(Camera4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Camera5))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(CautaDupaClientTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel3)
                                            .addComponent(CautaDupaClientButton)
                                            .addComponent(jLabel4)
                                            .addComponent(PretDeLaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel5)
                                            .addComponent(PretPanaLaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(CautaDupaPretButton))
                                        .addGap(115, 115, 115))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(102, 102, 102)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel21)
                                            .addComponent(jLabel28)
                                            .addComponent(jLabel11))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Confort2)
                                                    .addComponent(PretTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel16))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                    .addComponent(Confort1)
                                                    .addComponent(jLabel17)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addComponent(Tip1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Tip2))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(40, 40, 40)
                                                .addComponent(Stare2))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(Stare1)))))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Tip3)
                                    .addComponent(Stare3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(22, 22, 22)
                                        .addComponent(Confort3)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, Short.MAX_VALUE)
                                .addComponent(Confort6)))
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
                                            .addComponent(jLabel27))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(Exclusivitate)
                                            .addComponent(EchipaRadioButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(EchipaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(WebComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(AgentRadioButton)
                                        .addGap(28, 28, 28)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(AgentComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton4)
                                            .addComponent(jButton5)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Metrou)))))
                        .addGap(2, 2, 2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(186, 186, 186)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EtajInf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EtajSup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(Confort4)
                            .addComponent(Camera3))
                        .addGap(7, 7, 7)
                        .addComponent(Parter)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Ultimul)))
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

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //CAMERE

       
          Boolean bolcam=false;
        String String21="";
        String String22="";
        String String23="";
        String String24="";
        String String25="";
        if(bolcam==false){
            if(Camera1.isSelected()){
                bolcam=true;
                String21=" AND C.Garsoniera=1";
            }
        }
        else{
            if(Camera1.isSelected()){
                bolcam=true;
                String21=" AND C.Garsoniera=1";
            }
        }
        if(bolcam==false){
            if(Camera2.isSelected()){
                bolcam=true;
                String22=" AND C.2camere=1";
            }
        }
        else{
            if(Camera2.isSelected()){
                bolcam=true;
                String22=" AND C.2camere=1";
            }
        }
        if(bolcam==false){
            if(Camera3.isSelected()){
                bolcam=true;
                String23=" AND C.3camere=1";
            }
        }
        else{
            if(Camera3.isSelected()){
                bolcam=true;
                String23=" AND C.3camere=1";
            }
        }
        if(bolcam==false){
            if(Camera4.isSelected()){
                bolcam=true;
                String24=" AND C.4camere=1";
            }
        }
        else{
            if(Camera4.isSelected()){
                bolcam=true;
                String24=" AND C.4camere=1";
            }
        }
        if(bolcam==false){
            if(Camera5.isSelected()){
                bolcam=true;
                String25=" AND C.4camerep=1";
            }
        }
        else{
            if(Camera5.isSelected()){
                bolcam=true;
                String25=" AND C.4camerep=1";
            }
        }
        
        
        
        //METROU
        String String36="";
        boolean bolmetrou=false;
        if(bolmetrou==false){
            if(Metrou.isSelected()){
                bolcam=true;
                String36=" AND C.Metrou=1";
            }
        }
        else{
            if(Metrou.isSelected()){
                bolcam=true;
                String36=" AND C.Metrou=1";
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
            if(Confort2.isSelected()){
                bolconfort=true;
                String41=" AND C.I=1";
            }
        }
        else{
            if(Confort2.isSelected()){
                bolconfort=true;
                String41=" AND C.I=1";
            }
        }
        if(bolconfort==false){
            if(Confort1.isSelected()){
                bolconfort=true;
                String42=" AND C.Ip=1";
            }
        }
        else{
            if(Confort1.isSelected()){
                bolconfort=true;
                String42=" AND C.Ip=1";
            }
        }
        if(bolconfort==false){
            if(Confort4.isSelected()){
                bolconfort=true;
                String43=" AND C.II=1";
            }
        }
        else{
            if(Confort4.isSelected()){
                bolconfort=true;
                String43=" AND C.II=1";
            }
        }
        if(bolconfort==false){
            if(Confort3.isSelected()){
                bolconfort=true;
                String44=" AND C.IIp=1";
            }
        }
        else{
            if(Confort3.isSelected()){
                bolconfort=true;
                String44=" AND C.IIp=1";
            }
        }
        if(bolconfort==false){
            if(Confort6.isSelected()){
                bolconfort=true;
                String45=" AND C.III=1";
            }
        }
        else{
            if(Confort6.isSelected()){
                bolconfort=true;
                String45=" AND C.III=1";
            }
        }
        
        if(bolconfort==false){
            if(Confort5.isSelected()){
                bolconfort=true;
                String46=" AND C.IIIp=1";
            }
        }
        else{
            if(Confort5.isSelected()){
                bolconfort=true;
                String46=" AND C.IIIp=1";
            }
        }
        
        

        //TIP

         Boolean boltip=false;
        String String71="";
        String String72="";
        String String73="";
        if(boltip==false){
            if(Tip1.isSelected()){
                boltip=true;
                String71=" AND C.Semidecomandat=1";
            }
        }
        else{
            if(Tip1.isSelected()){
                boltip=true;
                String71=" AND C.Semidecomandat=1";
            }
        }
        if(boltip==false){
            if(Tip2.isSelected()){
                boltip=true;
                String72=" AND C.Decomandat=1";
            }
        }
        else{
            if(Tip2.isSelected()){
                boltip=true;
                String72=" AND C.Decomandat=1";
            }
        }
        if(boltip==false){
            if(Tip1.isSelected()){
                boltip=true;
                String71=" AND C.Circular=1";
            }
        }
        else{
            if(Tip1.isSelected()){
                boltip=true;
                String71=" AND C.Circular=1";
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
                String81=" AND C.Stare='Actual'";
            }
        }
        else{
            if(Stare1.isSelected()){
                bolstare=true;
                String81=" OR C.Stare='Actual'";
            }
        }
        if(bolstare==false){
            if(Stare2.isSelected()){
                bolstare=true;
                String82=" AND C.Stare='Incorect'";
            }
        }
        else{
            if(Stare2.isSelected()){
                bolstare=true;
                String82=" OR C.Stare='Incorect'";
            }
        }
        if(bolstare==false){
            if(Stare3.isSelected()){
                bolstare=true;
                String83=" AND C.Stare='Vandut'";
            }
        }
        else{
            if(Stare3.isSelected()){
                bolstare=true;
                String83=" OR C.Stare='Vandut'";
            }
        }

        //EXCLUSIVITATE
        String StringExclusivitate="";
        if(Exclusivitate.isSelected()){
            StringExclusivitate=" AND C.Exclusivitate=1";
        }

        //PRET
        String Pret="";
        if(!PretTextField.getText().isEmpty()){
            Pret=" AND Pret<="+PretTextField.getText();
        }

        //ETAJ
        String Etaj="";
        if((!EtajInf.getText().isEmpty())&&(!EtajSup.getText().isEmpty())){
            Etaj=" AND Etaj1 >= "+EtajInf.getText()+" AND Etaj2<= "+EtajSup.getText();
        }

        String StringParter= "";
        if(Parter.isSelected()){
            StringParter=" AND Parter=0";
        }
        String StringUltimul="";
        if(Ultimul.isSelected()){
            StringUltimul=" AND Ultimul=0";
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
           
            String rez;

            if (nr==0){
                rez="";
            }else{
                rez=z.parametru;
            }

            rs1 = stmt.executeQuery("select C.CIA,C.ClientID,C.Pret,C.Comision,C.Exclusivitate,"
                + "C.Negociabil,C.ObservatiiPret,C.TextAnuntIntern,C.AlteDetalii,C.Sector,C.Zona,C.Metrou,C.Garsoniera,"
                + "C.2camere,C.3camere,C.4camere,"
                + "C.4camerep,C.I,C.Ip,C.II,C.IIp,C.III,C.IIIp,C.Semidecomandat,C.Decomandat,C.Circular,"
                    + "C.Etaj1,C.Etaj2,C.Parter,C.Ultimul,C.Observatii,C.Stare,C.Data,CL.Nume,CL.Prenume  "
                + "from cerereia C, clienti CL"  +         
                " where  CL.ID=C.ClientID "+
                 " and C.CIA>=1 "
                + rez+ String21+String22+String23+String24+String25+String36+String41+String42+String43+String44+String45+String46
                +String71+String72+String73
                + String81+String82+String83+StringExclusivitate+StringParter+StringUltimul
                +Pret+Etaj+ " order by Data ");
            
            System.out.println("select C.CIA,C.ClientID,C.Pret,C.Comision,C.Exclusivitate,"
                + "C.Negociabil,C.ObservatiiPret,C.TextAnuntIntern,C.AlteDetalii,C.Sector,C.Zona,C.Metrou,C.Garsoniera,"
                + "C.2camere,C.3camere,C.4camere,"
                + "C.4camerep,C.I,C.Ip,C.II,C.IIp,C.III,C.IIIp,C.Semidecomandat,C.Decomandat,C.Circular,"
                    + "C.Etaj1,C.Etaj2,C.Parter,C.Ultimul,C.Observatii,C.Stare,C.Data,CL.Nume,CL.Prenume  "
                + "from cerereia C, clienti CL"  +         
                " where  CL.ID=C.ClientID "+
                 " and C.CIA>=1 "
                + rez+ String21+String22+String23+String24+String25+String36+String41+String42+String43+String44+String45+String46
                +String71+String72+String73
                + String81+String82+String83+StringExclusivitate+StringParter+StringUltimul
                +Pret+Etaj+ " order by Data ");

            int count=0;
            while (rs1.next()) {

                ListaTabelLinii.add(new ArrayList<Object>());
                ListaTabelLinii.get(count).add(rs1.getInt("C.CIA"));
                String rez1="";
                if (rs1.getInt("C.Garsoniera")==1){
                    rez1=rez1+"Garsoniera,";
                }
                if (rs1.getInt("C.2camere")==1){
                    rez1=rez1+"2,";
                }
                if (rs1.getInt("C.3camere")==1){
                    rez1=rez1+"3,";
                }
                if (rs1.getInt("C.4camere")==1){
                    rez1=rez1+"4,";
                }
                if (rs1.getInt("C.4camerep")==1){
                    rez1=rez1+"4+,";
                }
                if(rez1.compareTo("")!=0){
                    rez1=rez1.substring(0, rez1.length()-1);
                }
                ListaTabelLinii.get(count).add(rez1+"camere");
                ListaTabelLinii.get(count).add(rs1.getString("CL.Nume")+rs1.getString("CL.Prenume"));
                ListaTabelLinii.get(count).add(rs1.getString("C.Zona"));
                String rez2="confort ";
                if (rs1.getInt("C.I")==1){
                    rez2=rez2+"I";
                }
                if (rs1.getInt("C.Ip")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.II")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.IIp")==1){
                    rez2=rez2+"IIp,";
                }
                if (rs1.getInt("C.III")==1){
                    rez2=rez2+"III,";
                }
                if (rs1.getInt("C.IIIp")==1){
                    rez2=rez2+"IIIp,";
                }
                if (rs1.getInt("C.Semidecomandat")==1){
                    rez2=rez2+"Semidecomandat,";
                }
                if (rs1.getInt("C.Decomandat")==1){
                    rez2=rez2+"Decomandat,";
                }
                if (rs1.getInt("C.Circular")==1){
                    rez2=rez2+"Circular,";
                }
                ListaTabelLinii.get(count).add(rez2); //pentru detalii
                ListaTabelLinii.get(count).add(rs1.getInt("C.Pret"));
                ListaTabelLinii.get(count).add(rs1.getString("C.Data"));

                count++;

            }

            for(int i=0;i<ListaTabelLinii.size();i++){
                System.out.println(ListaTabelLinii.get(i));
            }
            System.out.println(ListaTabelLinii.size());

            String[] columnNames = {"Cod","Camere","Client","Zone","Detalii","Pret","Data"};

            Object[][] data =new Object[ListaTabelLinii.size()][7];
            for(int i=0;i<ListaTabelLinii.size();i++){
                for(int j=0;j<7;j++){
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

            if (ListaTabelLinii.size()>0){

                jTable1.setModel(model);
                jTable1.setRowHeight(100);
                jTable1.setVisible(true);
            }
            if (ListaTabelLinii.size()==0){
                JOptionPane.showMessageDialog(CautaCIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
                jTable1.setVisible(false);
            }
            //
        }  catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
        rs1 = stmt.executeQuery("select C.CIA,C.ClientID,C.Pret,C.Comision,C.Exclusivitate,"
                + "C.Negociabil,C.ObservatiiPret,C.TextAnuntIntern,C.AlteDetalii,C.Sector,C.Zona,C.Metrou,C.Garsoniera,"
                + "C.2camere,C.3camere,C.4camere,"
                + "C.4camerep,C.I,C.Ip,C.II,C.IIp,C.III,C.IIIp,C.Semidecomandat,C.Decomandat,C.Circular,"
                    + "C.Etaj1,C.Etaj2,C.Parter,C.Ultimul,C.Observatii,C.Stare,C.Data,CL.Nume,CL.Prenume  "
                + "from cerereia C,clienti CL"            
                + " where  CIA>=1 and CL.ID=C.ClientID ");
        
       int count=0;
        while (rs1.next()) {
          
        
            ListaTabelLinii.add(new ArrayList<Object>());
             ListaTabelLinii.get(count).add(rs1.getInt("C.CIA"));
              String rez1="";
                if (rs1.getInt("C.Garsoniera")==1){
                    rez1=rez1+"Garsoniera,";
                }
                if (rs1.getInt("C.2camere")==1){
                    rez1=rez1+"2,";
                }
                if (rs1.getInt("C.3camere")==1){
                    rez1=rez1+"3,";
                }
                if (rs1.getInt("C.4camere")==1){
                    rez1=rez1+"4,";
                }
                if (rs1.getInt("C.4camerep")==1){
                    rez1=rez1+"4+,";
                }
                if(rez1.compareTo("")!=0){
                rez1=rez1.substring(0, rez1.length()-1);
                }
                ListaTabelLinii.get(count).add(rez1+"camere");
                ListaTabelLinii.get(count).add(rs1.getString("CL.Nume")+rs1.getString("CL.Prenume"));
                ListaTabelLinii.get(count).add(rs1.getString("C.Zona"));
                String rez2="confort ";
                if (rs1.getInt("C.I")==1){
                    rez2=rez2+"I";
                }
                if (rs1.getInt("C.Ip")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.II")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.IIp")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.III")==1){
                    rez2=rez2+"III,";
                }
                 if (rs1.getInt("C.IIIp")==1){
                    rez2=rez2+"IIIp,";
                }
                 if (rs1.getInt("C.Semidecomandat")==1){
                     rez2=rez2+"Semidecomandat,";
                 }
                 if (rs1.getInt("C.Decomandat")==1){
                     rez2=rez2+"Decomandat,";
                 }
                 if (rs1.getInt("C.Circular")==1){
                     rez2=rez2+"Circular,";
                 }
                 ListaTabelLinii.get(count).add(rez2); //pentru detalii
                 ListaTabelLinii.get(count).add(rs1.getInt("C.Pret"));
                 ListaTabelLinii.get(count).add(rs1.getString("C.Data"));
                
             
             count++;
       
            
    }
        
        for(int i=0;i<ListaTabelLinii.size();i++){
            System.out.println(ListaTabelLinii.get(i));
        }
        System.out.println(ListaTabelLinii.size());
        
         String[] columnNames = {"Cod","Camere","Client","Zone","Detalii","Pret","Data"};
       
          Object[][] data =new Object[ListaTabelLinii.size()][7];
          for(int i=0;i<ListaTabelLinii.size();i++){
              for(int j=0;j<7;j++){
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
       
       
          
        if (ListaTabelLinii.size()>0){

      

       jTable1.setModel(model);
        jTable1.setRowHeight(100);
        jTable1.setVisible(true);
       }
        if (ListaTabelLinii.size()==0){
            JOptionPane.showMessageDialog(CautaCIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
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
       stmt=conn.prepareStatement("select C.CIA,C.ClientID,C.Pret,C.Comision,C.Exclusivitate,"
                + "C.Negociabil,C.ObservatiiPret,C.TextAnuntIntern,C.AlteDetalii,C.Sector,C.Zona,C.Metrou,C.Garsoniera,"
                + "C.2camere,C.3camere,C.4camere,"
                + "C.4camerep,C.I,C.Ip,C.II,C.IIp,C.III,C.IIIp,C.Semidecomandat,C.Decomandat,C.Circular,"
                    + "C.Etaj1,C.Etaj2,C.Parter,C.Ultimul,C.Observatii,C.Stare,CL.Nume,CL.Prenume,C.Data "
                + "from cerereia C,clienti CL"            
                + " where  CIA>=1 and CL.ID=C.ClientID and C.CIA LIKE ?");
       
        stmt.setInt(1, c);
        
        rs1 = stmt.executeQuery();
       //stmt.setInt(1, cod);
       int count=0;
        while (rs1.next()) {
          
        
            ListaTabelLinii.add(new ArrayList<Object>());
             ListaTabelLinii.get(count).add(rs1.getInt("C.CIA"));
              String rez1="";
                if (rs1.getInt("C.Garsoniera")==1){
                    rez1=rez1+"Garsoniera,";
                }
                if (rs1.getInt("C.2camere")==1){
                    rez1=rez1+"2,";
                }
                if (rs1.getInt("C.3camere")==1){
                    rez1=rez1+"3,";
                }
                if (rs1.getInt("C.4camere")==1){
                    rez1=rez1+"4,";
                }
                if (rs1.getInt("C.4camerep")==1){
                    rez1=rez1+"4+,";
                }
                if(rez1.compareTo("")!=0){
                rez1=rez1.substring(0, rez1.length()-1);
                }
                ListaTabelLinii.get(count).add(rez1+"camere");
                ListaTabelLinii.get(count).add(rs1.getString("CL.Nume")+rs1.getString("CL.Prenume"));
                ListaTabelLinii.get(count).add(rs1.getString("C.Zona"));
                String rez2="confort ";
                if (rs1.getInt("C.I")==1){
                    rez2=rez2+"I";
                }
                if (rs1.getInt("C.Ip")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.II")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.IIp")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.III")==1){
                    rez2=rez2+"III,";
                }
                 if (rs1.getInt("C.IIIp")==1){
                    rez2=rez2+"IIIp,";
                }
                 if (rs1.getInt("C.Semidecomandat")==1){
                     rez2=rez2+"Semidecomandat,";
                 }
                 if (rs1.getInt("C.Decomandat")==1){
                     rez2=rez2+"Decomandat,";
                 }
                 if (rs1.getInt("C.Circular")==1){
                     rez2=rez2+"Circular,";
                 }
                 ListaTabelLinii.get(count).add(rez2); //pentru detalii
                 ListaTabelLinii.get(count).add(rs1.getInt("C.Pret"));
                 ListaTabelLinii.get(count).add(rs1.getString("C.Data"));
                
             
             count++;
       
            
    }
        
        for(int i=0;i<ListaTabelLinii.size();i++){
            System.out.println(ListaTabelLinii.get(i));
        }
        System.out.println(ListaTabelLinii.size());
        
         String[] columnNames = {"Cod","Camere","Client","Zone","Detalii","Pret","Data"};
       
          Object[][] data =new Object[ListaTabelLinii.size()][7];
          for(int i=0;i<ListaTabelLinii.size();i++){
              for(int j=0;j<7;j++){
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
       
       
          
        if (ListaTabelLinii.size()>0){

      

       jTable1.setModel(model);
        jTable1.setRowHeight(100);
        jTable1.setVisible(true);
       }
        if (ListaTabelLinii.size()==0){
            JOptionPane.showMessageDialog(CautaCIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
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
       stmt=conn.prepareStatement("select C.CIA,C.ClientID,C.Pret,C.Comision,C.Exclusivitate,"
                + "C.Negociabil,C.ObservatiiPret,C.TextAnuntIntern,C.AlteDetalii,C.Sector,C.Zona,C.Metrou,C.Garsoniera,"
                + "C.2camere,C.3camere,C.4camere,"
                + "C.4camerep,C.I,C.Ip,C.II,C.IIp,C.III,C.IIIp,C.Semidecomandat,C.Decomandat,C.Circular,"
                    + "C.Etaj1,C.Etaj2,C.Parter,C.Ultimul,C.Observatii,C.Stare,CL.Nume,CL.Prenume  "
                + "from cerereia C,clienti CL"            
                + " where  C.CIA>=1 and CL.ID=C.ClientID and C.Pret BETWEEN ? and ?");
       
        stmt.setInt(1, c1);
        stmt.setInt(2, c2);
        
        rs1 = stmt.executeQuery();
       //stmt.setInt(1, cod);
       int count=0;
        while (rs1.next()) {
          
        
            ListaTabelLinii.add(new ArrayList<Object>());
             ListaTabelLinii.get(count).add(rs1.getInt("C.CIA"));
              String rez1="";
                if (rs1.getInt("C.Garsoniera")==1){
                    rez1=rez1+"Garsoniera,";
                }
                if (rs1.getInt("C.2camere")==1){
                    rez1=rez1+"2,";
                }
                if (rs1.getInt("C.3camere")==1){
                    rez1=rez1+"3,";
                }
                if (rs1.getInt("C.4camere")==1){
                    rez1=rez1+"4,";
                }
                if (rs1.getInt("C.4camerep")==1){
                    rez1=rez1+"4+,";
                }
                if(rez1.compareTo("")!=0){
                rez1=rez1.substring(0, rez1.length()-1);
                }
                ListaTabelLinii.get(count).add(rez1+"camere");
                ListaTabelLinii.get(count).add(rs1.getString("CL.Nume")+rs1.getString("CL.Prenume"));
                ListaTabelLinii.get(count).add(rs1.getString("C.Zona"));
                String rez2="confort ";
                if (rs1.getInt("C.I")==1){
                    rez2=rez2+"I";
                }
                if (rs1.getInt("C.Ip")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.II")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.IIp")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.III")==1){
                    rez2=rez2+"III,";
                }
                 if (rs1.getInt("C.IIIp")==1){
                    rez2=rez2+"IIIp,";
                }
                 if (rs1.getInt("C.Semidecomandat")==1){
                     rez2=rez2+"Semidecomandat,";
                 }
                 if (rs1.getInt("C.Decomandat")==1){
                     rez2=rez2+"Decomandat,";
                 }
                 if (rs1.getInt("C.Circular")==1){
                     rez2=rez2+"Circular,";
                 }
                 ListaTabelLinii.get(count).add(rez2); //pentru detalii
                 ListaTabelLinii.get(count).add(rs1.getInt("C.Pret"));
                 ListaTabelLinii.get(count).add(rs1.getString("C.Data"));
                
             
             count++;
       
            
    }
        
        for(int i=0;i<ListaTabelLinii.size();i++){
            System.out.println(ListaTabelLinii.get(i));
        }
        System.out.println(ListaTabelLinii.size());
        
         String[] columnNames = {"Cod","Camere","Client","Zone","Detalii","Pret","Data"};
       
          Object[][] data =new Object[ListaTabelLinii.size()][7];
          for(int i=0;i<ListaTabelLinii.size();i++){
              for(int j=0;j<7;j++){
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
       
       
          
        if (ListaTabelLinii.size()>0){

      

       jTable1.setModel(model);
        jTable1.setRowHeight(100);
        jTable1.setVisible(true);
       }
        if (ListaTabelLinii.size()==0){
            JOptionPane.showMessageDialog(CautaCIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
            jTable1.setVisible(false);
        }
      //  
 }  catch(Exception e){
                e.printStackTrace();
                }
            
    }
     
     
    private void PretTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PretTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PretTextFieldActionPerformed

    private void PretPanaLaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PretPanaLaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PretPanaLaTextFieldActionPerformed

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
                JOptionPane.showMessageDialog(CautaCIA.this,"Va rugam sa introduceti un pret minim valid","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ok==false){
            JOptionPane.showMessageDialog(CautaCIA.this,"Va rugam sa introduceti un pret minim valid","Error Message",JOptionPane.ERROR_MESSAGE);
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
                JOptionPane.showMessageDialog(CautaCIA.this,"Va rugam sa introduceti un pret maxim valid","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        if (ok==false){
            JOptionPane.showMessageDialog(CautaCIA.this,"Va rugam sa introduceti un pret maxim valid","Error Message",JOptionPane.ERROR_MESSAGE);
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
            if (CautaDupaCodTextField.getText().startsWith("CIA ")==false)
            try{
                Integer.parseInt(CautaDupaCodTextField.getText());
            }
            catch(NumberFormatException e){
                flagInt=true;
            }
            if(flagInt==true){
                //this.PretLabel.setForeground(Color.red);
                JOptionPane.showMessageDialog(CautaCIA.this,"Va rugam sa introduceti un cod valid","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }

        // ArrayList<ArrayList<Object>> ListaTabelLinii=new ArrayList<ArrayList<Object>>();

        String cod = CautaDupaCodTextField.getText();

        if (flagInt==false){
            if (cod != null && cod.trim().length() > 0) {
                //if (cod.startsWith("CIA ")==true){
                    //String aux=cod.substring(4);
                   // System.out.println(cod);
                    //System.out.println(cod.length());
                    int c=Integer.parseInt(cod);
                    get_alldatecod(c);
             //   }else{
               //     int c=Integer.parseInt(cod);
                //    get_alldatecod(c);
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
       stmt=conn.prepareStatement("select C.CIA,C.ClientID,C.Pret,C.Comision,C.Exclusivitate,"
                + "C.Negociabil,C.ObservatiiPret,C.TextAnuntIntern,C.AlteDetalii,C.Sector,C.Zona,C.Metrou,C.Garsoniera,"
                + "C.2camere,C.3camere,C.4camere,"
                + "C.4camerep,C.I,C.Ip,C.II,C.IIp,C.III,C.IIIp,C.Semidecomandat,C.Decomandat,C.Circular,"
                    + "C.Etaj1,C.Etaj2,C.Parter,C.Ultimul,C.Observatii,C.Data,C.Stare ,CL.Nume,CL.Prenume "
                + " from cerereia C,clienti CL "            
                + " where  C.CIA>=1 and CL.ID=C.ClientID and CL.Nume LIKE ?");
       
        stmt.setString(1, nume);
        
        rs1 = stmt.executeQuery();
       //stmt.setInt(1, cod);
       int count=0;
        while (rs1.next()) {
          
        
            ListaTabelLinii.add(new ArrayList<Object>());
             ListaTabelLinii.get(count).add(rs1.getInt("C.CIA"));
              String rez1="";
                if (rs1.getInt("C.Garsoniera")==1){
                    rez1=rez1+"Garsoniera,";
                }
                if (rs1.getInt("C.2camere")==1){
                    rez1=rez1+"2,";
                }
                if (rs1.getInt("C.3camere")==1){
                    rez1=rez1+"3,";
                }
                if (rs1.getInt("C.4camere")==1){
                    rez1=rez1+"4,";
                }
                if (rs1.getInt("C.4camerep")==1){
                    rez1=rez1+"4+,";
                }
                if(rez1.compareTo("")!=0){
                rez1=rez1.substring(0, rez1.length()-1);
                }
                ListaTabelLinii.get(count).add(rez1+"camere");
                ListaTabelLinii.get(count).add(rs1.getString("CL.Nume")+rs1.getString("CL.Prenume"));
                ListaTabelLinii.get(count).add(rs1.getString("C.Zona"));
                String rez2="confort ";
                if (rs1.getInt("C.I")==1){
                    rez2=rez2+"I";
                }
                if (rs1.getInt("C.Ip")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.II")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.IIp")==1){
                    rez2=rez2+"Ip,";
                }
                if (rs1.getInt("C.III")==1){
                    rez2=rez2+"III,";
                }
                 if (rs1.getInt("C.IIIp")==1){
                    rez2=rez2+"IIIp,";
                }
                 if (rs1.getInt("C.Semidecomandat")==1){
                     rez2=rez2+"Semidecomandat,";
                 }
                 if (rs1.getInt("C.Decomandat")==1){
                     rez2=rez2+"Decomandat,";
                 }
                 if (rs1.getInt("C.Circular")==1){
                     rez2=rez2+"Circular,";
                 }
                 ListaTabelLinii.get(count).add(rez2); //pentru detalii
                 ListaTabelLinii.get(count).add(rs1.getInt("C.Pret"));
                 ListaTabelLinii.get(count).add(rs1.getString("C.Data"));
                
             
             count++;
       
            
    }
        
        for(int i=0;i<ListaTabelLinii.size();i++){
            System.out.println(ListaTabelLinii.get(i));
        }
        System.out.println(ListaTabelLinii.size());
        
         String[] columnNames = {"Cod","Camere","Client","Zone","Detalii","Pret","Data"};
       
          Object[][] data =new Object[ListaTabelLinii.size()][7];
          for(int i=0;i<ListaTabelLinii.size();i++){
              for(int j=0;j<7;j++){
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
       
       
          
        if (ListaTabelLinii.size()>0){

      

       jTable1.setModel(model);
        jTable1.setRowHeight(100);
        jTable1.setVisible(true);
       }
        if (ListaTabelLinii.size()==0){
            JOptionPane.showMessageDialog(CautaCIA.this,"NU a fost gasit niciun rezultat pentru aceasta cautare","Error Message",JOptionPane.ERROR_MESSAGE);
            jTable1.setVisible(false);
        }
      //  
 }  catch(Exception e){
                e.printStackTrace();
                }
            
            
  }
    
    private void CautaDupaClientButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CautaDupaClientButtonActionPerformed

        boolean ok=true;

        String nume = CautaDupaClientTextField.getText();

        if (nume!= null && nume.trim().length() > 0) {
          //  if (nume.startsWith("CIA ")==true){
             /*   String aux=nume.substring(4);
                System.out.println(nume);
                System.out.println(nume.length());
                int c=Integer.parseInt(aux);
                get_alldatecod(c);*/
          //  }else{
                //int c=Integer.parseInt(cod);
                get_alldatestrada(nume);
           // }

        } else {
            get_alldatecod();
        }
    }//GEN-LAST:event_CautaDupaClientButtonActionPerformed

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

    private void WebComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_WebComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_WebComboBoxActionPerformed

    private void ZonaButonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZonaButonActionPerformed

        z= new Zona();
        nr++;

        z.setVisible(true);
    }//GEN-LAST:event_ZonaButonActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
            CautaCIA cautaCIA=new CautaCIA();
            cautaCIA.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

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
            java.util.logging.Logger.getLogger(CautaCIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CautaCIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CautaCIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CautaCIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CautaCIA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> AgentComboBox;
    private javax.swing.JRadioButton AgentRadioButton;
    private javax.swing.JCheckBox Camera1;
    private javax.swing.JCheckBox Camera2;
    private javax.swing.JCheckBox Camera3;
    private javax.swing.JCheckBox Camera4;
    private javax.swing.JCheckBox Camera5;
    private javax.swing.JButton CautaDupaClientButton;
    private javax.swing.JTextField CautaDupaClientTextField;
    private javax.swing.JButton CautaDupaCodButton;
    private javax.swing.JTextField CautaDupaCodTextField;
    private javax.swing.JButton CautaDupaPretButton;
    private javax.swing.JCheckBox Clientifavoriti;
    private javax.swing.JCheckBox Confort1;
    private javax.swing.JCheckBox Confort2;
    private javax.swing.JCheckBox Confort3;
    private javax.swing.JCheckBox Confort4;
    private javax.swing.JCheckBox Confort5;
    private javax.swing.JCheckBox Confort6;
    private javax.swing.JComboBox<String> EchipaComboBox;
    private javax.swing.JRadioButton EchipaRadioButton;
    private javax.swing.JTextField EtajInf;
    private javax.swing.JTextField EtajSup;
    private javax.swing.JCheckBox Exclusivitate;
    private javax.swing.JCheckBox Metrou;
    private javax.swing.JCheckBox Parter;
    private javax.swing.JTextField PretDeLaTextField;
    private javax.swing.JTextField PretPanaLaTextField;
    private javax.swing.JTextField PretTextField;
    private javax.swing.JCheckBox Stare1;
    private javax.swing.JCheckBox Stare2;
    private javax.swing.JCheckBox Stare3;
    private javax.swing.JCheckBox Tip1;
    private javax.swing.JCheckBox Tip2;
    private javax.swing.JCheckBox Tip3;
    private javax.swing.JCheckBox Ultimul;
    private javax.swing.JComboBox<String> WebComboBox;
    private javax.swing.JButton ZonaButon;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
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
      // search();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
       //search();
    }
}
