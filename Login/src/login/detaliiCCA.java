/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import static login.detaliiOIA.byteArrayToImage;
import static login.detaliiOIA.resize;

/**
 *
 * @author Serdin1
 */
public class detaliiCCA extends javax.swing.JFrame {

     static int p=0;
    int parametru;// reprezinta OVA-ul
    int nr=0;//pentru butonul detalii
    public detaliiCCA(int CCA) {
        
        initComponents();
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
        Comentarii.setVisible(false);
        this.parametru=CCA;
        functie(CCA);
    }
    /* public detaliiCCA() {
        
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        //jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        ComentariiTextField.setVisible(false);
       // ComentariiPanel.setVisible(false);
       // this.parametru=CCA;
       // functie(CCA);
    }*/
    public void functie(int CCA){
        
        java.sql.Statement stmt = null;
                try {
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");

       Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
       // System.out.println("db connected");
        stmt = (java.sql.Statement) conn.createStatement();

        ResultSet rs1;
       
        
       rs1 = stmt.executeQuery("select C.CCA,C.ClientID,C.Pret,C.Comision,C.Exclusivitate,C.Agent,"
                + "C.Negociabil,C.ObservatiiPret,C.TextAnuntIntern,C.AlteDetalii,C.Sector,C.Zona,C.Metrou,C.Garsoniera,"
                + "C.2camere,C.3camere,C.4camere,"
                + "C.4camerep,C.I,C.Ip,C.II,C.IIp,C.III,C.IIIp,C.Semidecomandat,C.Decomandat,C.Circular,"
                    + "C.Etaj1,C.Etaj2,C.Parter,C.Ultimul,C.Observatii,C.Stare,C.Data,C.Agent,CL.Nume,CL.Prenume  "
                + "from cerereca C,clienti CL"            
                + " where  C.CCA>=1 and CL.ID=C.ClientID and C.CCA Like "+CCA+"");
       while(rs1.next()){
           
           
             //pentru Detalii
             String Agent="";
             Agent=rs1.getString("C.Agent");
             
             Detalii.setText("CCA "+CCA+" - Agent: "+Agent+" - Introdus: "+rs1.getString("C.Data")+"("+Agent+")");
             int Pret=0;
             Pret=rs1.getInt("C.Pret");
             PretMaxim.setText(" "+Pret);
             String Stare1="";
             Stare1=rs1.getString("C.Stare");
             Stare.setText(Stare1);
             Zone.setText(rs1.getString("C.Zona"));
          String nrcamere="";
           if (rs1.getInt("C.Garsoniera")==1){
               nrcamere=nrcamere+"Garsoniera,";
           }
           if (rs1.getInt("C.2camere")==1){
               nrcamere=nrcamere+"2camere,";
           }
           if (rs1.getInt("C.3camere")==1){
               nrcamere=nrcamere+"3camere,";
           }
           if (rs1.getInt("C.4camere")==1){
               nrcamere=nrcamere+"4camere,";
           }
           if (rs1.getInt("C.4camerep")==1){
               nrcamere=nrcamere+"4camere+";
           }
          NrCamere.setText(nrcamere);
          String conf="";
           if (rs1.getInt("C.I")==1){
               conf=conf+"I,";
           }
           if (rs1.getInt("C.Ip")==1){
               conf=conf+"Ip,";
           }
           if (rs1.getInt("C.II")==1){
               conf=conf+"II,";
           }
           if (rs1.getInt("C.IIp")==1){
               conf=conf+"IIp,";
           }
           if (rs1.getInt("C.III")==1){
               conf=conf+"III,";
           }
           if (rs1.getInt("C.IIIp")==1){
               conf=conf+"IIIp";
           }
          Confort.setText(conf);
          String tip="";
           if (rs1.getInt("C.Semidecomandat")==1){
               tip=tip+"Semidecomandat,";
           }
           if (rs1.getInt("C.Decomandat")==1){
               tip=tip+"Decomandat,";
           }
           if (rs1.getInt("C.Circular")==1){
               tip=tip+"Circular,";
           }
           Compartimentare.setText(tip);
           Etaje.setText("Intre etajul"+rs1.getInt("C.Etaj1")+" si etajul"+rs1.getInt("C.Etaj2"));
           
            
           
       }

                }
       catch(Exception e){
                    e.printStackTrace();
                }
                
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        Detalii = new javax.swing.JLabel();
        StradaPret = new javax.swing.JLabel();
        Comentarii = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Proprietar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ObservatiiClient = new javax.swing.JLabel();
        ComentariiTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        ComentariiTable = new javax.swing.JTable();
        jLabel20 = new javax.swing.JLabel();
        Telefon = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        ObservatiiCerere = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Agent = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Comision = new javax.swing.JLabel();
        DetaliiButton = new javax.swing.JButton();
        PretMaxim = new javax.swing.JLabel();
        StradaPret1 = new javax.swing.JLabel();
        Stare = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Zone = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        NrCamere = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Confort = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Compartimentare = new javax.swing.JLabel();
        Etaje = new javax.swing.JLabel();
        ModificaDetalii = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setOpaque(false);

        Detalii.setBackground(new java.awt.Color(255, 255, 102));
        Detalii.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Detalii.setText("Detalii");
        Detalii.setOpaque(true);

        StradaPret.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        StradaPret.setText("Pret Maxim:");

        jLabel12.setText("Observatii cerere:");

        jLabel13.setText("Proprietar:");

        Proprietar.setText("jLabel14");

        jLabel14.setText("Observatii Client:");

        ObservatiiClient.setText("jLabel15");

        ComentariiTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                ComentariiTextFieldKeyPressed(evt);
            }
        });

        ComentariiTable.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(ComentariiTable);

        jLabel20.setText("Telefon:");

        Telefon.setForeground(new java.awt.Color(102, 0, 255));
        Telefon.setText("jLabel21");

        jLabel34.setBackground(new java.awt.Color(255, 255, 0));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Comentarii");
        jLabel34.setOpaque(true);

        ObservatiiCerere.setText("jLabel3");

        jLabel2.setText("Agent:");

        Agent.setText("jLabel3");

        jLabel3.setText("Comision:");

        Comision.setText("jLabel4");

        javax.swing.GroupLayout ComentariiLayout = new javax.swing.GroupLayout(Comentarii);
        Comentarii.setLayout(ComentariiLayout);
        ComentariiLayout.setHorizontalGroup(
            ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComentariiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ComentariiLayout.createSequentialGroup()
                        .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ComentariiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(95, Short.MAX_VALUE))
                    .addGroup(ComentariiLayout.createSequentialGroup()
                        .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ComentariiLayout.createSequentialGroup()
                                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Proprietar, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(ObservatiiClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Telefon, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(ObservatiiCerere, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(39, 39, 39)
                        .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Comision, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Agent, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(238, 238, 238))))
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ComentariiLayout.setVerticalGroup(
            ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComentariiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(ObservatiiCerere)
                    .addComponent(jLabel2)
                    .addComponent(Agent))
                .addGap(18, 18, 18)
                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Proprietar)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20)
                    .addComponent(Telefon)
                    .addComponent(jLabel3)
                    .addComponent(Comision))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ObservatiiClient))
                .addGap(56, 56, 56)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComentariiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(221, Short.MAX_VALUE))
        );

        DetaliiButton.setBackground(new java.awt.Color(255, 255, 0));
        DetaliiButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DetaliiButton.setText("Detalii");
        DetaliiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetaliiButtonActionPerformed(evt);
            }
        });

        PretMaxim.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        PretMaxim.setText("jLabel21");

        StradaPret1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        StradaPret1.setText("Stare:");

        Stare.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
        Stare.setText("jLabel21");

        jLabel21.setText("Zone:");

        Zone.setText("jLabel30");

        jLabel32.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel32.setText("Numar camere:");

        NrCamere.setText("jLabel1");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Confort:");

        Confort.setText("jLabel36");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Compartimentare:");

        Compartimentare.setText("jLabel36");

        Etaje.setText("jLabel36");

        ModificaDetalii.setText("Modifica Detalii");
        ModificaDetalii.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificaDetaliiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Comentarii, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(Zone, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 110, Short.MAX_VALUE)
                                    .addComponent(jLabel32, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(NrCamere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Compartimentare, javax.swing.GroupLayout.DEFAULT_SIZE, 216, Short.MAX_VALUE))
                                .addGap(39, 39, 39)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(26, 26, 26)
                                        .addComponent(Confort, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Etaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(StradaPret, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(PretMaxim, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(39, 39, 39)
                                    .addComponent(StradaPret1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(Stare, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ModificaDetalii, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                    .addComponent(Detalii, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(DetaliiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Detalii, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DetaliiButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(StradaPret, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(PretMaxim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(StradaPret1, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE)
                        .addComponent(Stare, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ModificaDetalii)))
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(Zone))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(NrCamere)
                    .addComponent(jLabel8)
                    .addComponent(Confort))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Compartimentare)
                    .addComponent(Etaje))
                .addGap(32, 32, 32)
                .addComponent(Comentarii, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane2.setViewportView(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1065, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 855, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ComentariiTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComentariiTextFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            PreparedStatement myStmt = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
                //introdu alt agent cand te loghezi
                myStmt = conn.prepareStatement("insert into comentariica"
                    + " (Cod,Comentarii,Agent,DataOra) "
                    + " values (?,?,?,?)");
                String com=ComentariiTextField.getText();// pentru a lua comentariul
                myStmt.setInt(1, this.parametru);
                myStmt.setString(2, com);
                myStmt.setString(3, Login.User);
                java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
                //System.out.println(date);
                myStmt.setTimestamp(4, date);

                myStmt.executeUpdate();
            }catch(Exception e){
                e.printStackTrace();
            }
            //pentru a extrage datele din tabel
            Connection conn=null;
            PreparedStatement stmt = null;

            try {

                Class.forName("com.mysql.jdbc.Driver");

                conn = DriverManager.getConnection( "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
                ResultSet rs1;
                stmt=conn.prepareStatement("select ID,Cod,Comentarii,Agent,DataOra "
                    + " from comentariica "
                    + " where  Cod=?");
                stmt.setInt(1, this.parametru);

                rs1 = stmt.executeQuery();

                ArrayList<ArrayList<Object>> ListaTabelLinii=new ArrayList<ArrayList<Object>>();
                int count=0;
                while (rs1.next()) {

                    ListaTabelLinii.add(new ArrayList<Object>());

                    ListaTabelLinii.get(count).add(count+1); //numarul de comentarii
                    ListaTabelLinii.get(count).add(rs1.getString("Comentarii"));
                    ListaTabelLinii.get(count).add(rs1.getString("Agent"));
                    ListaTabelLinii.get(count).add(rs1.getString("DataOra"));

                    count++;

                }

                for(int i=0;i<ListaTabelLinii.size();i++){
                    System.out.println(ListaTabelLinii.get(i));
                }
                System.out.println(ListaTabelLinii.size());

                //punerea in tabel
                String[] columnNames = {"Nr","Comentarii","Agent","Data/ora"};
                Object[][] data =new Object[ListaTabelLinii.size()][4];
                for(int i=0;i<ListaTabelLinii.size();i++){
                    for(int j=0;j<4;j++){
                        data[i][j]=ListaTabelLinii.get(i).get(j);
                    }
                }

                class ClasaTabel extends AbstractTableModel{

                    @Override
                    public int getRowCount() {
                        return ListaTabelLinii.size();
                    }

                    @Override
                    public int getColumnCount() {
                        return columnNames.length;
                    }
                    public String getColumnName(int col) {
                        return columnNames[col];
                    }
                    public Class getColumnClass(int c) {
                        return getValueAt(0, c).getClass();
                    }

                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        return data[rowIndex][columnIndex];
                    }

                }
                if (ListaTabelLinii.size()>0){

                    ComentariiTable.setModel(new ClasaTabel());
                    //jTable1.setRowHeight(100);
                    ComentariiTable.setVisible(true);
                    ComentariiTable.getColumnModel().getColumn(0).setMaxWidth(25);
                    ComentariiTable.getColumnModel().getColumn(1).setMinWidth(500);
                    ComentariiTextField.setText("");
                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }
    }//GEN-LAST:event_ComentariiTextFieldKeyPressed

    private void DetaliiButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DetaliiButtonActionPerformed
        nr++;
        if (nr%2==1){
            Comentarii.setVisible(true);
            //pentru tabel comentarii
            java.sql.Statement stmt = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
                // System.out.println("db connected");
                stmt = (java.sql.Statement) conn.createStatement();
                ResultSet rs1;
                //int idclientoferta=0;

                rs1 = stmt.executeQuery("select C.CCA,C.ClientID,C.Pret,C.Comision,C.Exclusivitate,C.Agent,"
                + "C.Negociabil,C.ObservatiiPret,C.TextAnuntIntern,C.AlteDetalii,C.Sector,C.Zona,C.Metrou,C.Garsoniera,"
                + "C.2camere,C.3camere,C.4camere,"
                + "C.4camerep,C.I,C.Ip,C.II,C.IIp,C.III,C.IIIp,C.Semidecomandat,C.Decomandat,C.Circular,"
                    + "C.Etaj1,C.Etaj2,C.Parter,C.Ultimul,C.Observatii,C.Stare,C.Data,C.Agent,CL.Nume,CL.Prenume,CL.Observatii,CL.Telefon,CL.NumeAgent  "
                + "from cerereca C,clienti CL"            
                + " where  C.CCA>=1 and CL.ID=C.ClientID and C.CCA Like "+this.parametru+"");
                while(rs1.next()){
                    ObservatiiCerere.setText(rs1.getString("C.Observatii"));
                    Proprietar.setText(rs1.getString("CL.Nume")+" "+rs1.getString("CL.Prenume"));
                    ObservatiiClient.setText(rs1.getString("CL.Observatii"));
                    Telefon.setText("0"+rs1.getString("CL.Telefon"));
                    Agent.setText(rs1.getString("CL.NumeAgent"));
                    Comision.setText(rs1.getString("C.Comision"));
                    
                }
                

                //pentru comentariu
                ResultSet rs2;
                rs2=stmt.executeQuery("select ID,Cod,Comentarii,Agent,DataOra "
                    + " from comentariica "
                    + " where  Cod="+this.parametru+"");

                ArrayList<ArrayList<Object>> ListaTabelLinii=new ArrayList<ArrayList<Object>>();
                int count=0;
                while (rs2.next()) {

                    ListaTabelLinii.add(new ArrayList<Object>());

                    ListaTabelLinii.get(count).add(count+1); //numarul de comentarii
                    ListaTabelLinii.get(count).add(rs2.getString("Comentarii"));
                    ListaTabelLinii.get(count).add(rs2.getString("Agent"));
                    ListaTabelLinii.get(count).add(rs2.getString("DataOra"));

                    count++;

                }

                for(int i=0;i<ListaTabelLinii.size();i++){
                    System.out.println(ListaTabelLinii.get(i));
                }
                System.out.println(ListaTabelLinii.size());

                //punerea in tabel
                String[] columnNames = {"Nr","Comentarii","Agent","Data/ora"};
                Object[][] data =new Object[ListaTabelLinii.size()][4];
                for(int i=0;i<ListaTabelLinii.size();i++){
                    for(int j=0;j<4;j++){
                        data[i][j]=ListaTabelLinii.get(i).get(j);
                    }
                }

                class ClasaTabel extends AbstractTableModel{

                    @Override
                    public int getRowCount() {
                        return ListaTabelLinii.size();
                    }

                    @Override
                    public int getColumnCount() {
                        return columnNames.length;
                    }
                    public String getColumnName(int col) {
                        return columnNames[col];
                    }
                    public Class getColumnClass(int c) {
                        return getValueAt(0, c).getClass();
                    }

                    @Override
                    public Object getValueAt(int rowIndex, int columnIndex) {
                        return data[rowIndex][columnIndex];
                    }

                }
                if (ListaTabelLinii.size()>0){

                    ComentariiTable.setModel(new ClasaTabel());
                    //jTable1.setRowHeight(100);
                    ComentariiTable.setVisible(true);
                    ComentariiTable.getColumnModel().getColumn(0).setMaxWidth(25);
                    ComentariiTable.getColumnModel().getColumn(1).setMinWidth(500);

                }
            }catch(Exception e){
                e.printStackTrace();
            }

        }else{
            Comentarii.setVisible(false);
        }
    }//GEN-LAST:event_DetaliiButtonActionPerformed

    private void ModificaDetaliiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificaDetaliiActionPerformed
        // TODO add your handling code here:
         new CCA(parametru).setVisible(true);
        this.setVisible(false);
        
        
    }//GEN-LAST:event_ModificaDetaliiActionPerformed

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
            java.util.logging.Logger.getLogger(detaliiCCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detaliiCCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detaliiCCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detaliiCCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
      /*  java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detaliiCCA().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Agent;
    private javax.swing.JPanel Comentarii;
    private javax.swing.JTable ComentariiTable;
    private javax.swing.JTextField ComentariiTextField;
    private javax.swing.JLabel Comision;
    private javax.swing.JLabel Compartimentare;
    private javax.swing.JLabel Confort;
    private javax.swing.JLabel Detalii;
    private javax.swing.JButton DetaliiButton;
    private javax.swing.JLabel Etaje;
    private javax.swing.JButton ModificaDetalii;
    private javax.swing.JLabel NrCamere;
    private javax.swing.JLabel ObservatiiCerere;
    private javax.swing.JLabel ObservatiiClient;
    private javax.swing.JLabel PretMaxim;
    private javax.swing.JLabel Proprietar;
    private javax.swing.JLabel Stare;
    private javax.swing.JLabel StradaPret;
    private javax.swing.JLabel StradaPret1;
    private javax.swing.JLabel Telefon;
    private javax.swing.JLabel Zone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
