/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Serdin
 */
public class CCA extends javax.swing.JFrame {

   // int cca;
    static String adresa=null;
     boolean modifica=false;
    Connection conn;
    ZonaCerere z;
    String zonaVeche;
    int nr=0;
    static int p=0;
    int exclusivitate;
    int negociabil;
    int metrou;
    int garsoniera;
    int camera2;
    int camera3;
    int camera4;
    int camera5;
    int confort1;
    int confort2;
    int confort3;
    int confort4;
    int confort5;
    int confort6;
    int semidecomandat;
    int decomandat;
    int circular;
    int etaj1;
    int etaj2;
    int parter;
    int ultimuletaj;
        int parametru;
    public CCA() {
        initComponents();
        metoda_init();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
         this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
         
       // NumeClientTextField.setText(MeniuInserare.NumeClient);
       //  PrenumeClientTextField.setText(MeniuInserare.PrenumeClient);
        Integer telefon= MeniuInserare.TelefonClient;
        
       //  TelefonClientTextField.setText(telefon.toString());
       // AgentComboBox.removeAllItems();
       // AgentComboBox.addItem(login.Login.User);
       // if(MeniuInserare.EmailClient!=null){
       //    EmailClientTextField.setText(MeniuInserare.EmailClient);
      //  }
      //  if(MeniuInserare.ObservatiiClient!=null){
      //      ObservatiiClientTextField.setText(MeniuInserare.ObservatiiClient);
      //  }
    }

     public void conexiune(){
         try{
           Class.forName("com.mysql.jdbc.Driver");

       conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
          }catch(Exception e){
              e.printStackTrace();
          }finally{
              System.out.println("da");
          }
    }
    
     public void metoda_init(){
        EchipaComboBox.setEnabled(false);
        StareComboBox.setEnabled(false);
    }
    public boolean introducere_pret(){
        
         
         boolean ok=true; 
         
            boolean flagInt=false;
            if(PretTextField.getText().isEmpty()){
                
                this.PretLabel.setForeground(Color.red);
                ok=false;

            }else{
                //System.out.println("da");
                 try{
            Integer.parseInt(PretTextField.getText());
            }
            catch(NumberFormatException e){
            flagInt=true;
            ok=false;
            }
              if(flagInt==true){
            this.PretLabel.setForeground(Color.red);
            JOptionPane.showMessageDialog(CCA.this,"Va rugam sa introduceti un pret valid","Error Message",JOptionPane.ERROR_MESSAGE);
        }
}
            
            //comision
            flagInt=false;
            if(ComisionTextField.getText().isEmpty()){
                
                this.ComisionLabel.setForeground(Color.red);
                ok=false;

            }else{
              if (ComisionTextField.getText().compareTo("?")!=0){
                 try{
            Integer.parseInt(ComisionTextField.getText());
            }
            catch(NumberFormatException e){
            flagInt=true;
            ok=false;
            }
              if(flagInt==true)
              {
            this.ComisionLabel.setForeground(Color.red);
            JOptionPane.showMessageDialog(CCA.this,"Va rugam sa introduceti un comision valid","Error Message",JOptionPane.ERROR_MESSAGE);
        }
              }
}
            
         exclusivitate=0;
         if(ExclusivitateCheckBox.isSelected()){
             exclusivitate=1;
         }
         negociabil=0;
         if(NegociabilCheckBox.isSelected()){
             negociabil=1;
         }
         return ok;
    }
    public boolean introducere_ProprietateGeneral(){
        boolean ok=true;
        boolean flagInt=false;
          /*  if(TextanuntTextPane.getText().isEmpty()){
                
                this.TextAnuntLabel.setForeground(Color.red);
                ok=false;

            }*/
            return ok;
    }
    public boolean introducere_apartament(){
        boolean ok=true;
         metrou=0;
        if (MetrouCheckBox.isSelected()){
            metrou=1;
        }
        garsoniera=0;
        if (Camera1.isSelected()){
            garsoniera=1;
        }
        camera2=0;
        if (Camera2.isSelected()){
            camera2=1;
        }
        camera3=0;
        if (Camera3.isSelected()){
            camera3=1;
        }
        camera3=0;
        if (Camera3.isSelected()){
            camera3=1;
        }
        camera4=0;
        if (Camera4.isSelected()){
            camera4=1;
        }
        camera5=0;
        if (Camera5.isSelected()){
            camera5=1;
        }
        confort1=0;
        if (Confort1.isSelected()){
            confort1=1;
        }
        confort2=0;
        if (Confort2.isSelected()){
            confort2=1;
        }
        confort3=0;
        if (Confort3.isSelected()){
            confort3=1;
        }
        confort4=0;
        if (Confort4.isSelected()){
            confort4=1;
        }
        confort5=0;
        if (Confort5.isSelected()){
            confort5=1;
        }
        confort6=0;
        if (Confort6.isSelected()){
            confort6=1;
        }
        semidecomandat=0;
        if (Semidecomandat.isSelected()){
            semidecomandat=1;
        }
        decomandat=0;
        if (Decomandat.isSelected()){
            decomandat=1;
        }
        circular=0;
        if (Circular.isSelected()){
            circular=1;
        }
        boolean flagInt=false;
            if(Etaj1.getText().isEmpty()){
                
                etaj1=0;

            }else{
                 try{
            Integer.parseInt(Etaj1.getText());
            }
            catch(NumberFormatException e){
            flagInt=true;
            ok=false;
            }
              if(flagInt==true){
            JOptionPane.showMessageDialog(CCA.this,"Va rugam sa introduceti primul etaj valid","Error Message",JOptionPane.ERROR_MESSAGE);
        }
}
            flagInt=false;
            if(Etaj2.getText().isEmpty()){
                
                etaj2=0;

            }else{
                 try{
            Integer.parseInt(Etaj2.getText());
            }
            catch(NumberFormatException e){
            flagInt=true;
            ok=false;
            }
              if(flagInt==true){
            JOptionPane.showMessageDialog(CCA.this,"Va rugam sa introduceti al doilea valid","Error Message",JOptionPane.ERROR_MESSAGE);
        }
}
            parter=0;
        if (Parter.isSelected()){
            parter=1;
        }
        ultimuletaj=0;
        if (FaraUltimulEtaj.isSelected()){
            ultimuletaj=1;
        }
        
            
        
        
        
        return ok;
    }
    public void insert_CCA(){
        PreparedStatement myStmt = null; 
        if (introducere_pret()==true&&introducere_ProprietateGeneral()==true&&
                introducere_apartament()==true){
             try{
          Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");

            myStmt = conn.prepareStatement("insert into cerereca"
                + " (ClientID,Pret,Comision,Exclusivitate,Negociabil,ObservatiiPret,"
                    + "TextAnuntIntern,AlteDetalii,Sector,Zona,Metrou,Garsoniera,2camere,3camere,"
                    + "4camere,4camerep,Ip,I,IIp,II,IIIp,III,Semidecomandat,Decomandat,Circular,"
                    + "Etaj1,Etaj2,Parter,Ultimul,Observatii,Stare,Data,Agent)"
                + " values (?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,  ?,?,?)");
            /*myStmt = conn.prepareStatement("insert into aptinchiriere1"
                + " (Comision,"
                    + "ObservatiiPret,Negociabil,Pret,Exclusivitate,Valoric,Nume)"
                + " values (0, ?,?,?,?,?)");*/

            // set params
             myStmt.setInt(1, MeniuInserare.IdClient);
            myStmt.setInt(2, Integer.parseInt(PretTextField.getText()));
            myStmt.setString(3, ComisionTextField.getText());
            myStmt.setInt(4, exclusivitate);
            myStmt.setInt(5, negociabil);
            myStmt.setString(6, Observatii_PretTextPane.getText());
            myStmt.setString(7, "");
            myStmt.setString(8, AlteDetaliiConfidentialeTextPane.getText());
            if (SectorComboBox.getSelectedIndex()==0){
                 myStmt.setString(9, "");
            }else{
                myStmt.setString(9, SectorComboBox.getSelectedItem().toString());
            } 
            if (z==null){
                myStmt.setString(10, "");
            }else{
            myStmt.setString(10, z.parametru);
            }
            myStmt.setInt(11, metrou);
            myStmt.setInt(12, garsoniera);
            myStmt.setInt(13, camera2);
            myStmt.setInt(14, camera3);
            myStmt.setInt(15, camera4);
            myStmt.setInt(16, camera5);
            myStmt.setInt(17, confort1);
            myStmt.setInt(18, confort2);
            myStmt.setInt(19, confort3);
            myStmt.setInt(20, confort4);
            myStmt.setInt(21, confort5);
            myStmt.setInt(22, confort6);
            myStmt.setInt(23, semidecomandat);
            myStmt.setInt(24, decomandat);
            myStmt.setInt(25, circular);
            if (Etaj1.getText().isEmpty()){
                myStmt.setInt(26, etaj1);
            }else{
            myStmt.setInt(26, Integer.parseInt(Etaj1.getText()));
            }
            if (Etaj2.getText().isEmpty()){
                myStmt.setInt(27, etaj2);
            }else{
            myStmt.setInt(27, Integer.parseInt(Etaj2.getText()));
            }
            myStmt.setInt(28, parter);
            myStmt.setInt(29, ultimuletaj);
            myStmt.setString(30, ObservatiiTextField.getText());
            myStmt.setString(31, StareComboBox.getSelectedItem().toString());
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());
            myStmt.setTimestamp(32, date);
            myStmt.setString(33,Login.User);
   
                    
           myStmt.executeUpdate();

            
             conn.close();
        }

        catch(Exception e){
            e.printStackTrace();
        }
        }else{
            JOptionPane.showMessageDialog(CCA.this,"Va rugam sa completati campurile cu rosu","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        
                    
   
}
     public void updateCCA(){
        PreparedStatement myStmt = null; 
        try{
             Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
                // System.out.println("db connected");
             
               
                myStmt = conn.prepareStatement("update cerereca set Pret=?,Comision=?,Exclusivitate=?,Negociabil=?,ObservatiiPret=?,"
                    + "TextAnuntIntern=?,AlteDetalii=?,Sector=?,Zona=?,Metrou=?,Garsoniera=?,2camere=?,3camere=?,"
                    + "4camere=?,4camerep=?,Ip=?,I=?,IIp=?,II=?,IIIp=?,III=?,Semidecomandat=?,Decomandat=?,Circular=?,"
                    + "Etaj1=?,Etaj2=?,Parter=?,Ultimul=?,Observatii=?,Stare=? where CCA="+parametru);
                 
            myStmt.setInt(1, Integer.parseInt(PretTextField.getText()));
             
            myStmt.setString(2, ComisionTextField.getText());
             myStmt.setInt(3, exclusivitate);
            myStmt.setInt(4, negociabil);       
            myStmt.setString(5, Observatii_PretTextPane.getText());     
            myStmt.setString(6, "");
            myStmt.setString(7, AlteDetaliiConfidentialeTextPane.getText());
               
             if (SectorComboBox.getSelectedIndex()==0){
                 myStmt.setString(8, "");
            }else{
                myStmt.setString(8, SectorComboBox.getSelectedItem().toString());
            }  
             if (z!=null){
              myStmt.setString(9, z.parametru);
              System.out.println(z.parametru);
             }else{
                 myStmt.setString(9,zonaVeche);
             }
             myStmt.setInt(10,garsoniera);
            myStmt.setInt(11,metrou);
            myStmt.setInt(12,camera2);
            myStmt.setInt(13,camera3);
            myStmt.setInt(14,camera4);
            myStmt.setInt(15,camera5);
            myStmt.setInt(16,confort1);
            myStmt.setInt(17,confort2);
            myStmt.setInt(18,confort3);
            myStmt.setInt(19,confort4);
            myStmt.setInt(20,confort5);
            myStmt.setInt(21,confort6);
             myStmt.setInt(22,semidecomandat); 
             myStmt.setInt(23,decomandat);
             myStmt.setInt(24,circular);
              myStmt.setInt(25,etaj1);
               myStmt.setInt(26,etaj2);
             myStmt.setInt(27, parter);
             myStmt.setInt(28, ultimuletaj);
              myStmt.setString(29, ObservatiiTextField.getText());
              myStmt.setString(30, StareComboBox.getSelectedItem().toString());
              
             
         
            myStmt.executeUpdate();
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        

        
        
    }
     public CCA(int cca){
        initComponents();
         EchipaComboBox.setEnabled(false);
      
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        java.sql.Statement stmt = null;
        try{
             Class.forName("com.mysql.jdbc.Driver");

       Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
       // System.out.println("db connected");
        stmt = (java.sql.Statement) conn.createStatement();

        ResultSet rs1;
       
        
       rs1 = stmt.executeQuery("select Pret,Comision,Exclusivitate,Negociabil,ObservatiiPret,"
                    + "TextAnuntIntern,AlteDetalii,Sector,Zona,Metrou,Garsoniera,2camere,3camere,"
                    + "4camere,4camerep,Ip,I,IIp,II,IIIp,III,Semidecomandat,Decomandat,Circular,"
                    + "Etaj1,Etaj2,Parter,Ultimul,Observatii,Stare from cerereca where CCA="+cca+"");
       while(rs1.next()){
          
                     PretTextField.setText(rs1.getString("Pret"));
                      ComisionTextField.setText(rs1.getString("Comision"));
           if(rs1.getInt("Negociabil")==1){
               NegociabilCheckBox.setSelected(true);
           }
           if(rs1.getInt("Exclusivitate")==1){
               ExclusivitateCheckBox.setSelected(true);
           }
           Observatii_PretTextPane.setText(rs1.getString("ObservatiiPret"));
        //   TextanuntTextPane.setText(rs1.getString("TextAnuntIntern"));
           AlteDetaliiConfidentialeTextPane.setText(rs1.getString("AlteDetalii"));
           if(rs1.getString("Sector").equalsIgnoreCase("Sector 5")){
               SectorComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Sector").equalsIgnoreCase("Sector 6")){
               SectorComboBox.setSelectedIndex(2);
           } else{
               SectorComboBox.setSelectedIndex(0);
           }
           
           if(rs1.getInt("Metrou")==1){
               MetrouCheckBox.setSelected(true);
           }
          
             
           if(rs1.getInt("Garsoniera")==1){
               Camera1.setSelected(true);
           }
            if(rs1.getInt("2camere")==1){
               Camera2.setSelected(true);
           }
             if(rs1.getInt("3camere")==1){
               Camera3.setSelected(true);
           }
              if(rs1.getInt("4camere")==1){
               Camera4.setSelected(true);
           }
               if(rs1.getInt("4camerep")==1){
               Camera5.setSelected(true);
           }
                      if(rs1.getInt("Ip")==1){
               Confort1.setSelected(true);
           }
                    if(rs1.getInt("I")==1){
               Confort2.setSelected(true);
           }
                    if(rs1.getInt("IIp")==1){
               Confort3.setSelected(true);
           }
                    if(rs1.getInt("II")==1){
               Confort4.setSelected(true);
           }
                    if(rs1.getInt("IIIp")==1){
               Confort5.setSelected(true);
           }
                    if(rs1.getInt("III")==1){
               Confort6.setSelected(true);
           }
                    
                               if(rs1.getInt("Semidecomandat")==1){
               Semidecomandat.setSelected(true);
           }
                              if(rs1.getInt("Decomandat")==1){
               Decomandat.setSelected(true);
           }
                              if(rs1.getInt("Circular")==1){
               Circular.setSelected(true);
           }
         
          Etaj1.setText(rs1.getString("Etaj1"));
             Etaj2.setText(rs1.getString("Etaj2"));
              if(rs1.getInt("Parter")==1){
               Parter.setSelected(true);
           }
           if(rs1.getInt("Ultimul")==1){
               FaraUltimulEtaj.setSelected(true);
           }
         
          ObservatiiTextField.setText(rs1.getString("Observatii"));
      
           
           
           
           if(rs1.getString("Stare").equalsIgnoreCase("Actual")){
               StareComboBox.setSelectedIndex(0);
           }
           else if(rs1.getString("Stare").equalsIgnoreCase("Incorect")){
               StareComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Stare").equalsIgnoreCase("Vandut")){
               StareComboBox.setSelectedIndex(2);
           }
          
          zonaVeche=rs1.getString("Zona");
          System.out.println(zonaVeche);
         
        parametru=cca;
       modifica=true;
        
        
        
       
     
       }
        conn.close();
        }  catch(Exception e){
            e.printStackTrace();
        } 
        
        
    }
    
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        PretLabel = new javax.swing.JLabel();
        ComisionLabel = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        PretTextField = new javax.swing.JTextField();
        ComisionTextField = new javax.swing.JTextField();
        ExclusivitateCheckBox = new javax.swing.JCheckBox();
        NegociabilCheckBox = new javax.swing.JCheckBox();
        ObservatiiPretLabel = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Observatii_PretTextPane = new javax.swing.JTextPane();
        jLabel13 = new javax.swing.JLabel();
        AlteDetaliiConfidentialeLabel = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        AlteDetaliiConfidentialeTextPane = new javax.swing.JTextPane();
        jLabel16 = new javax.swing.JLabel();
        EchipaComboBox = new javax.swing.JComboBox<>();
        jLabel17 = new javax.swing.JLabel();
        SectorComboBox = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        PanelContainerPoze = new javax.swing.JPanel();
        PozitieLabel = new javax.swing.JLabel();
        MetrouCheckBox = new javax.swing.JCheckBox();
        jLabel11 = new javax.swing.JLabel();
        Camera5 = new javax.swing.JCheckBox();
        Camera4 = new javax.swing.JCheckBox();
        Camera3 = new javax.swing.JCheckBox();
        Camera2 = new javax.swing.JCheckBox();
        Camera1 = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        Confort1 = new javax.swing.JCheckBox();
        Confort2 = new javax.swing.JCheckBox();
        Confort3 = new javax.swing.JCheckBox();
        Confort4 = new javax.swing.JCheckBox();
        Confort5 = new javax.swing.JCheckBox();
        Confort6 = new javax.swing.JCheckBox();
        Semidecomandat = new javax.swing.JCheckBox();
        jLabel21 = new javax.swing.JLabel();
        Circular = new javax.swing.JCheckBox();
        Decomandat = new javax.swing.JCheckBox();
        Etaj1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        FaraUltimulEtaj = new javax.swing.JCheckBox();
        Parter = new javax.swing.JCheckBox();
        Etaj2 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        ObservatiiTextField = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        StareComboBox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        ZonaButton = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        SalveazaDateButton = new javax.swing.JButton();
        jLabel25 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        InserareMeniu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1920, 1080));

        PretLabel.setText("Pret");

        ComisionLabel.setText("Comision");

        jLabel10.setText("%");

        ExclusivitateCheckBox.setText("Exclusivitate");
        ExclusivitateCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExclusivitateCheckBoxActionPerformed(evt);
            }
        });

        NegociabilCheckBox.setText("Negociabil");
        NegociabilCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NegociabilCheckBoxActionPerformed(evt);
            }
        });

        ObservatiiPretLabel.setText("Observatii pret:");

        jScrollPane2.setViewportView(Observatii_PretTextPane);

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel13.setText("Proprietate");

        AlteDetaliiConfidentialeLabel.setText("Alte detalii confidentiale:");

        jScrollPane4.setViewportView(AlteDetaliiConfidentialeTextPane);

        jLabel16.setText("Echipa:");

        EchipaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------------", "Item 1", "Item 2", "Item 3", "Item 4" }));
        EchipaComboBox.setEnabled(false);

        jLabel17.setText("Sector:");

        SectorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------------", "Sector 5", "Sector 6" }));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Pret");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Apartamente:");

        Label1.setBackground(new java.awt.Color(255, 255, 51));
        Label1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        Label1.setForeground(new java.awt.Color(51, 51, 51));
        Label1.setOpaque(true);

        PanelContainerPoze.setPreferredSize(new java.awt.Dimension(210, 115));

        javax.swing.GroupLayout PanelContainerPozeLayout = new javax.swing.GroupLayout(PanelContainerPoze);
        PanelContainerPoze.setLayout(PanelContainerPozeLayout);
        PanelContainerPozeLayout.setHorizontalGroup(
            PanelContainerPozeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 210, Short.MAX_VALUE)
        );
        PanelContainerPozeLayout.setVerticalGroup(
            PanelContainerPozeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );

        MetrouCheckBox.setText("Metrou");
        MetrouCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MetrouCheckBoxActionPerformed(evt);
            }
        });

        jLabel11.setBackground(new java.awt.Color(255, 255, 102));
        jLabel11.setText("                        Metrou:");
        jLabel11.setOpaque(true);

        Camera5.setText("4+ camere");

        Camera4.setText("4 camere");

        Camera3.setText("3 camere");

        Camera2.setText("2 camere");
        Camera2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Camera2ActionPerformed(evt);
            }
        });

        Camera1.setText("Garsoniera");

        jLabel12.setBackground(new java.awt.Color(255, 255, 102));
        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel12.setText("                           Camere:");
        jLabel12.setOpaque(true);

        jLabel14.setBackground(new java.awt.Color(255, 255, 102));
        jLabel14.setText("                                       Confort:");
        jLabel14.setOpaque(true);

        Confort1.setText("I+");
        Confort1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confort1ActionPerformed(evt);
            }
        });

        Confort2.setText("I");

        Confort3.setText("II+");

        Confort4.setText("II");
        Confort4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Confort4ActionPerformed(evt);
            }
        });

        Confort5.setText("III+");

        Confort6.setText("III");

        Semidecomandat.setText("Semidecomandat");

        jLabel21.setBackground(new java.awt.Color(255, 255, 102));
        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("                          Compartimentare:");
        jLabel21.setOpaque(true);

        Circular.setText("Circular");

        Decomandat.setText("Decomandat");

        Etaj1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Etaj1ActionPerformed(evt);
            }
        });

        jLabel20.setText("intre:");

        jLabel22.setBackground(new java.awt.Color(255, 255, 102));
        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("                           Etaj:");
        jLabel22.setOpaque(true);

        jLabel23.setText("si");

        FaraUltimulEtaj.setText("Ultimul Etaj");

        Parter.setText("Parter");

        jLabel8.setText("Observatii:");

        ObservatiiTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObservatiiTextFieldActionPerformed(evt);
            }
        });

        jLabel9.setText("Stare:");

        StareComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actual", "Incorect", "Vandut" }));
        StareComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StareComboBoxActionPerformed(evt);
            }
        });

        jLabel15.setText("Se introduce \"?\" in cazul in care nu il stim");

        ZonaButton.setBackground(new java.awt.Color(255, 255, 51));
        ZonaButton.setText("Zona:");
        ZonaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ZonaButtonActionPerformed(evt);
            }
        });

        jLabel24.setBackground(new java.awt.Color(255, 255, 51));
        jLabel24.setOpaque(true);

        SalveazaDateButton.setText("Salveaza Date");
        SalveazaDateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SalveazaDateButtonActionPerformed(evt);
            }
        });

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel25.setText("Cerere Cumparare Apartament");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AlteDetaliiConfidentialeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(56, 56, 56))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(10, 10, 10)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(EchipaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(174, 174, 174)
                                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(119, 119, 119)
                                        .addComponent(SectorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(ObservatiiPretLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(PretLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(ComisionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(ExclusivitateCheckBox))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NegociabilCheckBox)
                                    .addComponent(PretTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(ComisionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 540, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ZonaButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 484, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(33, 33, 33)
                                                .addComponent(PozitieLabel))
                                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Camera1)
                                            .addComponent(Camera2)
                                            .addComponent(Camera3)
                                            .addComponent(Camera4)
                                            .addComponent(Camera5))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Confort1)
                                            .addComponent(Confort2)
                                            .addComponent(Confort3)
                                            .addComponent(Confort4)
                                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(Confort6)
                                            .addComponent(Confort5)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(MetrouCheckBox, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addComponent(ObservatiiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(425, 425, 425)
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(StareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Semidecomandat)
                                    .addComponent(Decomandat)
                                    .addComponent(Circular)
                                    .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel20)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Etaj1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(Etaj2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Parter)
                                    .addComponent(FaraUltimulEtaj)
                                    .addComponent(jLabel22, javax.swing.GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
                                    .addComponent(SalveazaDateButton, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(165, 165, 165)
                        .addComponent(PanelContainerPoze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(1716, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(jLabel25)
                .addGap(45, 45, 45)
                .addComponent(jLabel18)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PretLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PretTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComisionLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(ComisionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15))
                .addGap(75, 75, 75)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExclusivitateCheckBox)
                    .addComponent(NegociabilCheckBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ObservatiiPretLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(jLabel13)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(AlteDetaliiConfidentialeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EchipaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SectorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(7, 7, 7)
                                .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ZonaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addComponent(PozitieLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(18, 18, 18)
                        .addComponent(MetrouCheckBox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel14))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Camera1)
                                    .addComponent(Confort1)
                                    .addComponent(Semidecomandat)))
                            .addComponent(jLabel21))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Camera2)
                            .addComponent(Confort2)
                            .addComponent(Decomandat))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Camera3)
                            .addComponent(Confort3)
                            .addComponent(Circular))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Camera4)
                                    .addComponent(Confort4))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Camera5)
                                    .addComponent(Confort5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Confort6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel20)
                                    .addComponent(Etaj1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel23)
                                    .addComponent(Etaj2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(Parter)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FaraUltimulEtaj)))))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(ObservatiiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(StareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(SalveazaDateButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1940, Short.MAX_VALUE)
                .addComponent(PanelContainerPoze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80))
        );

        jScrollPane1.setViewportView(jPanel1);

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jMenuBar1.setMinimumSize(new java.awt.Dimension(106, 26));
        jMenuBar1.setPreferredSize(new java.awt.Dimension(112, 56));

        jMenu1.setText("Cauta Oferta/Cerere");
        jMenu1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Oferta Vanzare Apartament");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuItem4.setText("Oferta Inchiriere Apartament");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("Cerere Inchiriere Apartament");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Cerere Cumparare Apartament");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuBar1.add(jMenu1);

        InserareMeniu.setBackground(new java.awt.Color(153, 153, 153));
        InserareMeniu.setText("Inserare");
        InserareMeniu.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        InserareMeniu.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                InserareMeniuMenuSelected(evt);
            }
        });
        InserareMeniu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                InserareMeniuMouseClicked(evt);
            }
        });
        InserareMeniu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InserareMeniuActionPerformed(evt);
            }
        });
        jMenuBar1.add(InserareMeniu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1623, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExclusivitateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExclusivitateCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExclusivitateCheckBoxActionPerformed

    private void NegociabilCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegociabilCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NegociabilCheckBoxActionPerformed

    private void MetrouCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MetrouCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MetrouCheckBoxActionPerformed

    private void Camera2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Camera2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Camera2ActionPerformed

    private void Confort1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confort1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Confort1ActionPerformed

    private void Confort4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Confort4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Confort4ActionPerformed

    private void Etaj1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Etaj1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Etaj1ActionPerformed

    private void ObservatiiTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObservatiiTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ObservatiiTextFieldActionPerformed

    private void StareComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StareComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StareComboBoxActionPerformed

    private void ZonaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ZonaButtonActionPerformed

        if (modifica){
            z=new ZonaCerere(parametru,"cumparare");
        }else{
        z= new ZonaCerere();
        }
        z.setVisible(true);
        System.out.println(z.parametru);

    }//GEN-LAST:event_ZonaButtonActionPerformed

    private void SalveazaDateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SalveazaDateButtonActionPerformed
        
        if (introducere_pret()==true&&introducere_ProprietateGeneral()==true&&introducere_apartament()){
        
                if(!modifica){
                insert_CCA();
                MeniuInserare m=new MeniuInserare();
                m.setVisible(true);
                this.setVisible(false);
                }
                else{
                    updateCCA();
                    this.setVisible(false);
                }
                JOptionPane.showMessageDialog(CCA.this,"Datele au fost salvate cu succes","Success Message",JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(CCA.this,"Va rugam sa completati toate detaliile","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        

    }//GEN-LAST:event_SalveazaDateButtonActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        CautaOVA s=new CautaOVA();
        s.setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        CautaOIA s=new CautaOIA();
        s.setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        CautaCIA s=new CautaCIA();
        s.setVisible(true);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        CautaCCA s=new CautaCCA();
        s.setVisible(true);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed

    private void InserareMeniuMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_InserareMeniuMenuSelected
        MeniuInserare dialog = new MeniuInserare();
        this.setVisible(false);
        dialog.setVisible(true);
    }//GEN-LAST:event_InserareMeniuMenuSelected

    private void InserareMeniuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_InserareMeniuMouseClicked

    }//GEN-LAST:event_InserareMeniuMouseClicked

    private void InserareMeniuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InserareMeniuActionPerformed
        MeniuInserare dialog = new MeniuInserare();

        // show dialog
        //m.setVisible(false);
        dialog.setVisible(true);
    }//GEN-LAST:event_InserareMeniuActionPerformed

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
            java.util.logging.Logger.getLogger(CCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CCA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CCA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AlteDetaliiConfidentialeLabel;
    private javax.swing.JTextPane AlteDetaliiConfidentialeTextPane;
    private javax.swing.JCheckBox Camera1;
    private javax.swing.JCheckBox Camera2;
    private javax.swing.JCheckBox Camera3;
    private javax.swing.JCheckBox Camera4;
    private javax.swing.JCheckBox Camera5;
    private javax.swing.JCheckBox Circular;
    private javax.swing.JLabel ComisionLabel;
    private javax.swing.JTextField ComisionTextField;
    private javax.swing.JCheckBox Confort1;
    private javax.swing.JCheckBox Confort2;
    private javax.swing.JCheckBox Confort3;
    private javax.swing.JCheckBox Confort4;
    private javax.swing.JCheckBox Confort5;
    private javax.swing.JCheckBox Confort6;
    private javax.swing.JCheckBox Decomandat;
    private javax.swing.JComboBox<String> EchipaComboBox;
    private javax.swing.JTextField Etaj1;
    private javax.swing.JTextField Etaj2;
    private javax.swing.JCheckBox ExclusivitateCheckBox;
    private javax.swing.JCheckBox FaraUltimulEtaj;
    private javax.swing.JMenu InserareMeniu;
    private javax.swing.JLabel Label1;
    private javax.swing.JCheckBox MetrouCheckBox;
    private javax.swing.JCheckBox NegociabilCheckBox;
    private javax.swing.JLabel ObservatiiPretLabel;
    private javax.swing.JTextField ObservatiiTextField;
    private javax.swing.JTextPane Observatii_PretTextPane;
    private javax.swing.JPanel PanelContainerPoze;
    private javax.swing.JCheckBox Parter;
    private javax.swing.JLabel PozitieLabel;
    private javax.swing.JLabel PretLabel;
    private javax.swing.JTextField PretTextField;
    private javax.swing.JButton SalveazaDateButton;
    private javax.swing.JComboBox<String> SectorComboBox;
    private javax.swing.JCheckBox Semidecomandat;
    private javax.swing.JComboBox<String> StareComboBox;
    private javax.swing.JButton ZonaButton;
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
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
