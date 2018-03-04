/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Serdin
 */
public class ZonaCerere extends javax.swing.JFrame {

    String parametru="";
    public ZonaCerere() {
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    
    public ZonaCerere(int codCerere,String tipCerere){
        initComponents();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        java.sql.Statement stmt = null;
        try{
             Class.forName("com.mysql.jdbc.Driver");

       Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
       // System.out.println("db connected");
        stmt = (java.sql.Statement) conn.createStatement();

        ResultSet rs1=null;
       
        if (tipCerere.equalsIgnoreCase("cumparare")){
            rs1 = stmt.executeQuery("select Zona from cerereca where CCA="+codCerere+"");
        }else if (tipCerere.equalsIgnoreCase("inchiriere")){
            rs1 = stmt.executeQuery("select Zona from cerereia where CIA="+codCerere+"");
        }
        String zona="";
        if (rs1.next()){
            zona=rs1.getString("Zona");
        }
       // String[] listZones=zona.split("[\\s,-]+");
       String[] listZones=zona.split("[,]+");
       for (int i=0;i<listZones.length;i++){
           listZones[i]=listZones[i].replace(" ", "");
           listZones[i]=listZones[i].replace("-", "");
       }
        
       for (int i=0;i<listZones.length;i++){
           System.out.println(listZones[i]);
           if(listZones[i].equalsIgnoreCase("Sector5")){
               Sector5CheckBox.setSelected(true);
           }
           if(listZones[i].equalsIgnoreCase("13Septembrie")){
               N_13SeptembrieCheckBox.setSelected(true);
           }
           if(listZones[i].equalsIgnoreCase("Panduri")){
               PanduriCheckBox.setSelected(true);
           }
           if(listZones[i].equalsIgnoreCase("Alexandriei")){
               AlexandrieiCheckBox.setSelected(true);
            }
           
            if(listZones[i].equalsIgnoreCase("Rahova")){
                RahovaCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("Cotroceni")){
                CotroceniCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("Sebastian")){
                SebastianCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("Izvor")){
                IzvorCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("Kogalniceanu")){
                KogalniceanuCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("Sector6")){
                Sector6CheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("AfiCotroceni")){
                AfiCotroceniCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("DrumulTabereiMoghoros")){
                DrumulTabereiMoghiorosCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("MilitariGorjului")){
                MilitariGorjuluiCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("PrelungireaGhencea")){
                PrelungireaGhenceaCheckBox.setSelected(true);
            }
            
            if(listZones[i].equalsIgnoreCase("DrumulTabereiPlazza")){
                DrumulTabereiPlazzaCheckBox.setSelected(true);
            }
            
            if(listZones[i].equalsIgnoreCase("Crangasi")){
                CrangasiCheckBox.setSelected(true);
            }
            
            if(listZones[i].equalsIgnoreCase("MilitariLujerului")){
                MilitariLujeruluiCheckBox.setSelected(true);
            }


            if(listZones[i].equalsIgnoreCase("CrangasiMetrou")){
                CrangasiMetrouCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("MilitariPacii")){
                MilitariPaciiCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("Ghencea")){
                GhenceaCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("DrumulTabereiRomancierilor")){
                DrumulTabereiRomancierilorCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("DrumulTabereiBucla")){
                DrumulTabereiBuclaCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("DrumulTabereiFavorit")){
                DrumulTabereiFavoritCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("Grozavesti")){
                GrozavestiCheckBox.setSelected(true);
            }

            if(listZones[i].equalsIgnoreCase("MilitariRosu")){
                MilitariRosuCheckBox.setSelected(true);
            }
           
           
           
       }
       
        
          
         
     //   parametru=cca;
     //  modifica=true;
        
        
        
       
     
       
        conn.close();
        }  catch(Exception e){
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        Sector5CheckBox = new javax.swing.JCheckBox();
        N_13SeptembrieCheckBox = new javax.swing.JCheckBox();
        PanduriCheckBox = new javax.swing.JCheckBox();
        AlexandrieiCheckBox = new javax.swing.JCheckBox();
        RahovaCheckBox = new javax.swing.JCheckBox();
        CotroceniCheckBox = new javax.swing.JCheckBox();
        SebastianCheckBox = new javax.swing.JCheckBox();
        IzvorCheckBox = new javax.swing.JCheckBox();
        KogalniceanuCheckBox = new javax.swing.JCheckBox();
        Sector6CheckBox = new javax.swing.JCheckBox();
        AfiCotroceniCheckBox = new javax.swing.JCheckBox();
        DrumulTabereiMoghiorosCheckBox = new javax.swing.JCheckBox();
        MilitariGorjuluiCheckBox = new javax.swing.JCheckBox();
        CrangasiCheckBox = new javax.swing.JCheckBox();
        MilitariLujeruluiCheckBox = new javax.swing.JCheckBox();
        CrangasiMetrouCheckBox = new javax.swing.JCheckBox();
        DrumulTabereiRomancierilorCheckBox = new javax.swing.JCheckBox();
        DrumulTabereiBuclaCheckBox = new javax.swing.JCheckBox();
        DrumulTabereiFavoritCheckBox = new javax.swing.JCheckBox();
        PrelungireaGhenceaCheckBox = new javax.swing.JCheckBox();
        DrumulTabereiPlazzaCheckBox = new javax.swing.JCheckBox();
        MilitariPaciiCheckBox = new javax.swing.JCheckBox();
        GhenceaCheckBox = new javax.swing.JCheckBox();
        GrozavestiCheckBox = new javax.swing.JCheckBox();
        MilitariRosuCheckBox = new javax.swing.JCheckBox();
        SelecteazaZonaButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));

        jScrollPane1.setPreferredSize(new java.awt.Dimension(772, 600));

        jLabel1.setBackground(new java.awt.Color(255, 255, 102));
        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("  Zona");
        jLabel1.setOpaque(true);

        Sector5CheckBox.setText("Sector 5");

        N_13SeptembrieCheckBox.setText("13 Septembrie");
        N_13SeptembrieCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                N_13SeptembrieCheckBoxActionPerformed(evt);
            }
        });

        PanduriCheckBox.setText("Panduri");

        AlexandrieiCheckBox.setText("Alexandriei");

        RahovaCheckBox.setText("Rahova");

        CotroceniCheckBox.setText("Cotroceni");

        SebastianCheckBox.setText("Sebastian");

        IzvorCheckBox.setText("Izvor");

        KogalniceanuCheckBox.setText("Kogalniceanu");

        Sector6CheckBox.setText("Sector 6");

        AfiCotroceniCheckBox.setText("Afi Cotroceni");

        DrumulTabereiMoghiorosCheckBox.setText("Drumul Taberei-Moghioros");

        MilitariGorjuluiCheckBox.setText("Militari-Gorjului");

        CrangasiCheckBox.setText("Crangasi");

        MilitariLujeruluiCheckBox.setText("Militari Lujerului");

        CrangasiMetrouCheckBox.setText("Crangasi Metrou");

        DrumulTabereiRomancierilorCheckBox.setText("Drumul Taberei-Romancierilor");

        DrumulTabereiBuclaCheckBox.setText("Drumul Taberei-Bucla");

        DrumulTabereiFavoritCheckBox.setText("Drumul Taberei-Favorit");

        PrelungireaGhenceaCheckBox.setText("Prelungirea Ghencea");

        DrumulTabereiPlazzaCheckBox.setText("Drumul Taberei-Plazza");

        MilitariPaciiCheckBox.setText("Militari Pacii");

        GhenceaCheckBox.setText("Ghencea");

        GrozavestiCheckBox.setText("Grozavesti");

        MilitariRosuCheckBox.setText("Militari Rosu");

        SelecteazaZonaButton.setText("Selecteaza Zona");
        SelecteazaZonaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SelecteazaZonaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(254, 254, 254)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Sector5CheckBox)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PanduriCheckBox)
                                    .addComponent(N_13SeptembrieCheckBox)
                                    .addComponent(AfiCotroceniCheckBox)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Sector6CheckBox)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(MilitariGorjuluiCheckBox)
                                    .addComponent(DrumulTabereiMoghiorosCheckBox)
                                    .addComponent(PrelungireaGhenceaCheckBox)
                                    .addComponent(DrumulTabereiPlazzaCheckBox))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(AlexandrieiCheckBox)
                                        .addGap(42, 42, 42))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(RahovaCheckBox)
                                        .addGap(66, 66, 66)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(SebastianCheckBox)
                                    .addComponent(CotroceniCheckBox))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(IzvorCheckBox)
                                    .addComponent(KogalniceanuCheckBox)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(CrangasiMetrouCheckBox)
                                            .addComponent(MilitariPaciiCheckBox)
                                            .addComponent(GhenceaCheckBox))
                                        .addGap(79, 79, 79)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(GrozavestiCheckBox)
                                            .addComponent(DrumulTabereiFavoritCheckBox)
                                            .addComponent(MilitariRosuCheckBox)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addComponent(CrangasiCheckBox)
                                                .addGap(41, 41, 41))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(MilitariLujeruluiCheckBox)
                                                .addGap(9, 9, 9)))
                                        .addGap(76, 76, 76)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(DrumulTabereiBuclaCheckBox)
                                            .addComponent(DrumulTabereiRomancierilorCheckBox))))))))
                .addContainerGap(145, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SelecteazaZonaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(214, 214, 214))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(Sector5CheckBox))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(N_13SeptembrieCheckBox)
                            .addComponent(AlexandrieiCheckBox)
                            .addComponent(CotroceniCheckBox)
                            .addComponent(IzvorCheckBox))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PanduriCheckBox)
                            .addComponent(RahovaCheckBox)
                            .addComponent(SebastianCheckBox)
                            .addComponent(KogalniceanuCheckBox))))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AfiCotroceniCheckBox)
                    .addComponent(CrangasiCheckBox)
                    .addComponent(DrumulTabereiRomancierilorCheckBox))
                .addGap(3, 3, 3)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Sector6CheckBox)
                    .addComponent(DrumulTabereiMoghiorosCheckBox)
                    .addComponent(MilitariLujeruluiCheckBox)
                    .addComponent(DrumulTabereiBuclaCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MilitariGorjuluiCheckBox)
                    .addComponent(CrangasiMetrouCheckBox)
                    .addComponent(DrumulTabereiFavoritCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PrelungireaGhenceaCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MilitariPaciiCheckBox)
                        .addComponent(GrozavestiCheckBox)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DrumulTabereiPlazzaCheckBox)
                    .addComponent(GhenceaCheckBox)
                    .addComponent(MilitariRosuCheckBox))
                .addGap(18, 18, 18)
                .addComponent(SelecteazaZonaButton)
                .addContainerGap(171, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 578, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void N_13SeptembrieCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_N_13SeptembrieCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_N_13SeptembrieCheckBoxActionPerformed

    private void SelecteazaZonaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SelecteazaZonaButtonActionPerformed
        // TODO add your handling code here:
        Boolean bolzona=false;
        //pentru Sector5
        String String11="";
        String String12="";
        String String13="";
        String String14="";
        String String15="";
        String String16="";
        String String17="";
        String String18="";
        String String19="";
        String String110="";
        String String111="";
        String String112="";
        String String113="";
        String String114="";
        String String115="";
        String String116="";
        String String117="";
        String String118="";
        String String119="";
        String String120="";
        String String121="";
        String String122="";
        String String123="";
        String String124="";
        String String125="";

            if(Sector5CheckBox.isSelected()){
                String11="Sector 5,";
            }

            if(N_13SeptembrieCheckBox.isSelected()){
                String12="13 Septembrie,";
            }
       

            if(PanduriCheckBox.isSelected()){
                String13="Panduri,";
            }

            if(AlexandrieiCheckBox.isSelected()){
                String14="Alexandriei,";
            }

            if(RahovaCheckBox.isSelected()){
                String15="Rahova,";
            }

            if(CotroceniCheckBox.isSelected()){
                String16="Cotroceni,";
            }

            if(SebastianCheckBox.isSelected()){
                String17="Sebastian,";
            }

            if(IzvorCheckBox.isSelected()){
                String18="Izvor,";
            }

            if(KogalniceanuCheckBox.isSelected()){
                String19="Kogalniceanu,";
            }

            if(Sector6CheckBox.isSelected()){
                String110="Sector 6,";
            }

            if(AfiCotroceniCheckBox.isSelected()){
                String111="Afi Cotroceni,";
            }

            if(DrumulTabereiMoghiorosCheckBox.isSelected()){
                bolzona=true;
                String112="Drumul Taberei-Moghoros,";
            }

            if(MilitariGorjuluiCheckBox.isSelected()){
                String113="Militari-Gorjului,";
            }

            if(PrelungireaGhenceaCheckBox.isSelected()){
                String114="Prelungirea Ghencea,";
            }

            if(DrumulTabereiPlazzaCheckBox.isSelected()){
                String115="Drumul Taberei-Plazza,";
            }

            if(CrangasiCheckBox.isSelected()){
                String116="Crangasi,";
            }

            if(MilitariLujeruluiCheckBox.isSelected()){
                String117="Militari Lujerului,";
            }

            if(CrangasiMetrouCheckBox.isSelected()){
                String118="Crangasi Metrou,";
            }

            if(MilitariPaciiCheckBox.isSelected()){
                String119="Militari Pacii,";
            }

            if(GhenceaCheckBox.isSelected()){
                String120="Ghencea,";
            }

            if(DrumulTabereiRomancierilorCheckBox.isSelected()){
                String121="Drumul Taberei-Romancierilor,";
            }

            if(DrumulTabereiBuclaCheckBox.isSelected()){
                String122="Drumul Taberei-Bucla,";
            }

            if(DrumulTabereiFavoritCheckBox.isSelected()){
                String123="Drumul Taberei-Favorit,";
            }

            if(GrozavestiCheckBox.isSelected()){
                String124="Grozavesti,";
            }

            if(MilitariRosuCheckBox.isSelected()){
                String125="Militari Rosu,";
            }
            String rez="";
        rez=rez+String11+String12+String13+String14+String15+String16+String17+String18+String19+String110+
        String111+String112+String113+String114+String115+String116+String117+String118+String119+
        String120+String121+String122+String123+String124+String125;
        if (rez.compareTo("")>0){
        String aux=rez.substring(0, rez.length()-1);
        parametru=aux;
        }

        this.setVisible(false);

    }//GEN-LAST:event_SelecteazaZonaButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ZonaCerere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ZonaCerere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ZonaCerere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ZonaCerere.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ZonaCerere().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox AfiCotroceniCheckBox;
    private javax.swing.JCheckBox AlexandrieiCheckBox;
    private javax.swing.JCheckBox CotroceniCheckBox;
    private javax.swing.JCheckBox CrangasiCheckBox;
    private javax.swing.JCheckBox CrangasiMetrouCheckBox;
    private javax.swing.JCheckBox DrumulTabereiBuclaCheckBox;
    private javax.swing.JCheckBox DrumulTabereiFavoritCheckBox;
    private javax.swing.JCheckBox DrumulTabereiMoghiorosCheckBox;
    private javax.swing.JCheckBox DrumulTabereiPlazzaCheckBox;
    private javax.swing.JCheckBox DrumulTabereiRomancierilorCheckBox;
    private javax.swing.JCheckBox GhenceaCheckBox;
    private javax.swing.JCheckBox GrozavestiCheckBox;
    private javax.swing.JCheckBox IzvorCheckBox;
    private javax.swing.JCheckBox KogalniceanuCheckBox;
    private javax.swing.JCheckBox MilitariGorjuluiCheckBox;
    private javax.swing.JCheckBox MilitariLujeruluiCheckBox;
    private javax.swing.JCheckBox MilitariPaciiCheckBox;
    private javax.swing.JCheckBox MilitariRosuCheckBox;
    private javax.swing.JCheckBox N_13SeptembrieCheckBox;
    private javax.swing.JCheckBox PanduriCheckBox;
    private javax.swing.JCheckBox PrelungireaGhenceaCheckBox;
    private javax.swing.JCheckBox RahovaCheckBox;
    private javax.swing.JCheckBox SebastianCheckBox;
    private javax.swing.JCheckBox Sector5CheckBox;
    private javax.swing.JCheckBox Sector6CheckBox;
    private javax.swing.JButton SelecteazaZonaButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
