/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.InputMap;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
//import static login.OVA.byteArrayToImage;
import static login.OVA.resize;
import static login.ParcurgereImagine.ListaPoze;
import static login.detaliiOIA.parametru;
//import static login.detaliiOVA.parametru;

/**
 *
 * @author Serdin
 */
public class OVA extends javax.swing.JFrame implements DocumentListener{

     static String adresa=null;
    Connection conn;
    int negociabil;
    int exclusivitate;
    int imagine;
    int etaj;
    int parter;
    int ultimul;
    int fereastragrupsanitar;
    int rezidential;
    int comercial;
    int birouri;
    int vacanta;
    // la usi intrare
    int celulare;
    int lemn;
    int panel;
    int pvc;
    int sticla;
    
    //Generale
    int curent;
    int gaz;
    int apa;
    int canalizare;
    int catv;
    int telefon;
    int international;
    
    //Sistem Incalzire
    int centralaproprie;
    int centralaimobil;
    int termoficare;
    int soba;
    int calorifere;
    int incalzirepardoseala;
    
    //Acces Internet
    int cablu;
    int fibraoptica;
    int wireless;
    int adsl;
    
    //finisaje
    //podele
    int parchet;
    int gresie;
    int linoleum;
    int mocheta;
    int dusumea;
    int marmura;
    //pereti
    int var;
    int vinarom;
    int lavabila;
    int faianta;
    int lambriu;
    int tapet;
    int homa;
    //ferestreTermopan
    int aluminiu;
    int pvc2;
    int lemn2;
    //izolatiiTermice
    int interior;
    int exterior;
    //dotari
    //alte spatii utile
    int terasa;
    int wcserviciu;
    int debara;
    int boxasubsol;
    //contorizare
    int apometre;
    int contorgaz;
    int contoarecaldura;
    //diverse
    int jacuzzi;
    int senzorfum;
    int alarma;
    //electrocasnice
    int aragaz;
    int cuptormicrounde;
    int plita;
    int masinadespalat;
    //dotari servicii/imobil
    int lift;
    int interfon;
    int sauna;

    int metrou;
    int publicate;
    int web;
     static int p=0;
	BufferedImage harta;
    BufferedImage poza;
	int parametru;
    //imagine daca listaPoze =0 inseamna ca are imagine altfel nu 
     boolean modifica=false;
    //imagine daca listaPoze =0 inseamna ca are imagine altfel nu 
      ArrayList<BufferedImage> ListaPoze=new ArrayList<BufferedImage>();
      ArrayList<BufferedImage> ListaPozeModifica=new ArrayList<BufferedImage>();
     
      public static BufferedImage resize(BufferedImage image, int width, int height) {
    BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
    Graphics2D g2d = (Graphics2D) bi.createGraphics();
    g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
    g2d.drawImage(image, 0, 0, width, height, null);
    g2d.dispose();
    return bi;
}
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
        LinkTextField.setEnabled(false);
        WebCheckBox.setEnabled(false);
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
            }
              if(flagInt==true){
            this.PretLabel.setForeground(Color.red);
            JOptionPane.showMessageDialog(OVA.this,"Va rugam sa introduceti un pret valid","Error Message",JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog(OVA.this,"Va rugam sa introduceti un comision valid","Error Message",JOptionPane.ERROR_MESSAGE);
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
       /*     if(TextanuntTextPane.getText().isEmpty()){
                
                this.TextAnuntLabel.setForeground(Color.red);
                ok=false;

            }*/
            return ok;
    }
    public boolean introducere_ApartamenteLocalizare(){
        boolean ok=true;
        
        metrou=0;
        if (MetrouCheckBox.isSelected()){
            metrou=1;
        }
            if(StradaTextField.getText().isEmpty()){
                
                this.StradaLabel.setForeground(Color.red);
                ok=false;

            }
            
         
            boolean flagInt=false;
            if(NrTextField.getText().isEmpty()){
                
                this.NrLabel.setForeground(Color.red);
                ok=false;

            }else{
                //System.out.println("da");
                 try{
            Integer.parseInt(NrTextField.getText());
            }
            catch(NumberFormatException e){
            flagInt=true;
            }
              if(flagInt==true){
            this.NrLabel.setForeground(Color.red);
            JOptionPane.showMessageDialog(OVA.this,"Va rugam sa introduceti un numar de strada valid","Error Message",JOptionPane.ERROR_MESSAGE);
        }
}
            

            
            return ok;
  
        
    }
    public boolean introducere_CaracteristiciProprietate(){
        boolean ok=true;
        //facem pentru etaj ceva cu Combobox
        //NrCamereComboBox.getSelectedItem().
        //partea cu etajul
       /* int max;
        max=Integer.parseInt(EtajeTotaleComboBox.getSelectedItem().toString());
        for (int i=0;i<max;i++){
            String au=Integer.toString(i);
            EtajComboBox.addItem(au);
        }*/
        
        
        
        boolean flagInt=false;
            if(SuprafataConstruitaTextField.getText().isEmpty()){
                
                this.SuprafataConstruitaLabel.setForeground(Color.red);
                ok=false;

            }else{
                //System.out.println("da");
                 try{
            Integer.parseInt(SuprafataConstruitaTextField.getText());
            }
            catch(NumberFormatException e){
            flagInt=true;
            }
              if(flagInt==true){
            this.SuprafataConstruitaLabel.setForeground(Color.red);
            JOptionPane.showMessageDialog(OVA.this,"Va rugam sa introduceti o suprafata valida","Error Message",JOptionPane.ERROR_MESSAGE);
        }
}
            
            flagInt=false;
            if(SuprafataUtilaTextField.getText().isEmpty()){
                
                this.SuprafataUtilaLabel.setForeground(Color.red);
                ok=false;

            }else{
                //System.out.println("da");
                 try{
            Integer.parseInt(SuprafataUtilaTextField.getText());
            }
            catch(NumberFormatException e){
            flagInt=true;
            }
              if(flagInt==true){
            this.SuprafataUtilaLabel.setForeground(Color.red);
            JOptionPane.showMessageDialog(OVA.this,"Va rugam sa introduceti o suprafata valida","Error Message",JOptionPane.ERROR_MESSAGE);
        }
}
            
            //AnTextField
            
             flagInt=false;
            if(AnTextField.getText().isEmpty()){
                
                this.AnLabel.setForeground(Color.red);
                ok=false;

            }else{
                //System.out.println("da");
                 try{
            Integer.parseInt(AnTextField.getText());
            }
            catch(NumberFormatException e){
            flagInt=true;
            }
              if(flagInt==true){
            this.AnLabel.setForeground(Color.red);
            JOptionPane.showMessageDialog(OVA.this,"Va rugam sa introduceti o suprafata valida","Error Message",JOptionPane.ERROR_MESSAGE);
        }
}

            
            parter=0;
            if (ParterCheckBox.isSelected()){
                parter=1;
            }
            ultimul=0;
            if (UltimulCheckBox.isSelected()){
                ultimul=1;
            }
            
        fereastragrupsanitar=0;
        if (FereastraGrupSanitarCheckBox.isSelected()){
            fereastragrupsanitar=1;
        }
        rezidential=0;
        if(RezidentialCheckBox.isSelected()){
            rezidential=1;
        }
        comercial=0;
        if(ComercialCheckBox.isSelected()){
            comercial=1;
        }
        birouri=0;
        if(BirouriCheckBox.isSelected()){
            birouri=1;
        }
        vacanta=0;
        if(VacantaCheckBox.isSelected()){
            vacanta=1;
        }
        
        
        return ok;
        
    }
    public boolean introducereGenerale(){
        boolean ok=true;
        curent=0;
        if (Curent.isSelected()){
            curent=1;
        }
        gaz=0;
        if (Gaz.isSelected()){
            gaz=1;
        }
        apa=0;
        if (Apa.isSelected()){
            apa=1;
        }
        canalizare=0;
        if (Canalizare.isSelected()){
            canalizare=1;
        }
        catv=0;
        if (CATV.isSelected()){
            catv=1;
        }
        telefon=0;
        if (TelefonO.isSelected()){
            telefon=1;
        }
        international=0;
        if (International.isSelected()){
            international=1;
        }
        centralaproprie=0;
        if (CentralaProprie.isSelected()){
            centralaproprie=1;
        }
        centralaimobil=0;
        if (CentralaImobil.isSelected()){
            centralaimobil=1;
        }
        termoficare=0;
        if (Termoficare.isSelected()){
            termoficare=1;
        }
        soba=0;
        if (Soba.isSelected()){
            soba=1;
        }
        calorifere=0;
        if (Calorifere.isSelected()){
            calorifere=1;
        }
        incalzirepardoseala=0;
        if (IncalzirePardoseala.isSelected()){
            incalzirepardoseala=1;
        }
        cablu=0;
        if (Cablu.isSelected()){
            cablu=1;
        }
        fibraoptica=0;
        if (FibraOptica.isSelected()){
            fibraoptica=1;
        }
        wireless=0;
        if (Wireless.isSelected()){
            wireless=1;
        }
        adsl=0;
        if (ADSL.isSelected()){
            adsl=1;
        }
        return ok;
        
        
        
        
        
    }
     public boolean introducere_Finisaje(){
        boolean ok=true;
        celulare=0;
        if (CelulareCheckBox.isSelected()){
            celulare=1;
        }
        lemn=0;
        if (LemnCheckBox.isSelected()){
            lemn=1;
        }
        panel=0;
        if (PanelCheckBox.isSelected()){
            panel=1;
        }
        pvc=0;
        if (PVCCheckBox.isSelected()){
            pvc=1;
        }
        sticla=0;
        if (SticlaCheckBox.isSelected()){
            sticla=1;
        }
        parchet=0;
        if (Parchet.isSelected()){
            parchet=1;
        }
        gresie=0;
        if (Gresie.isSelected()){
            gresie=1;
        }
        linoleum=0;
        if (Linoleum.isSelected()){
            linoleum=1;
        }
        mocheta=0;
        if (Mocheta.isSelected()){
            mocheta=1;
        }
        dusumea=0;
        if (Dusumea.isSelected()){
            dusumea=1;
        }
        marmura=0;
        if (Marmura.isSelected()){
            marmura=1;
        }
        var=0;
        if (Var.isSelected()){
            var=1;
        }
        vinarom=0;
        if (Vinarom.isSelected()){
            vinarom=1;
        }
        lavabila=0;
        if (Lavabila.isSelected()){
            lavabila=1;
        }
        faianta=0;
        if (Faianta.isSelected()){
            faianta=1;
        }
        lambriu=0;
        if (Lambriu.isSelected()){
            lambriu=1;
        }
        tapet=0;
        if (Tapet.isSelected()){
            tapet=1;
        }
        homa=0;
        if (Homa.isSelected()){
           homa=1;
        }
        aluminiu=0;
        if (Aluminiu.isSelected()){
            aluminiu=1;
        }
        pvc2=0;
        if (PVC2.isSelected()){
            pvc2=1;
        }
         lemn2=0;
        if (Lemn2.isSelected()){
            lemn2=1;
        }
         interior=0;
        if (Interior.isSelected()){
            interior=1;
        }
         exterior=0;
        if (Exterior.isSelected()){
            exterior=1;
        }
        
        return ok;
    }
     public boolean introducereDotari(){
        boolean ok=true;
        terasa=0;
        if (Terasa.isSelected()){
            terasa=1;
        }
        wcserviciu=0;
        if (WCServiciu.isSelected()){
            wcserviciu=1;
        }
        debara=0;
        if (Debara.isSelected()){
            debara=1;
        }
        boxasubsol=0;
        if (BoxaSubsol.isSelected()){
            boxasubsol=1;
        }
        apometre=0;
        if (Apometre.isSelected()){
            apometre=1;
        }
        contorgaz=0;
        if (ContorGaz.isSelected()){
            contorgaz=1;
        }
        contoarecaldura=0;
        if (ContoareCaldura.isSelected()){
            contoarecaldura=1;
        }
        jacuzzi=0;
        if (Jacuzzi.isSelected()){
            jacuzzi=1;
        }
        senzorfum=0;
        if (SenzorFum.isSelected()){
            senzorfum=1;
        }
        alarma=0;
        if (Alarma.isSelected()){
            alarma=1;
        }
        aragaz=0;
        if (Aragaz.isSelected()){
            aragaz=1;
        }
        cuptormicrounde=0;
        if (CuptorMicrounde.isSelected()){
            cuptormicrounde=1;
        }
        plita=0;
        if (Plita.isSelected()){
            plita=1;
        }
        masinadespalat=0;
        if (MasinaDeSpalat.isSelected()){
            masinadespalat=1;
        }
        lift=0;
        if (Lift.isSelected()){
            lift=1;
        }
        interfon=0;
        if (Interfon.isSelected()){
            interfon=1;
        }
        sauna=0;
        if (Sauna.isSelected()){
            sauna=1;
        }
        return ok;
        
    }
    public boolean introducere_Link() {
        boolean ok=true;
        publicate=0;
        if(PublicatCheckBox.isSelected()){
            publicate=1;
        }
       
        web=0;
        if(WebCheckBox.isSelected()){
            web=1;
        }
        
        
        
        return ok;

    }
    public void interogare_insert_apartament_vanzare(){
        
        PreparedStatement myStmt = null; 
        if (introducere_pret()==true&&introducere_ProprietateGeneral()==true&&
                introducere_ApartamenteLocalizare()==true&&introducere_CaracteristiciProprietate()==true
                &&introducereGenerale()==true&&introducere_Finisaje()==true&&introducereDotari()==true&&introducere_Link()==true){
             try{
          Class.forName("com.mysql.jdbc.Driver");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");

            myStmt = conn.prepareStatement("insert into aptvanzare"
                + " (Reper,Pozitie,Metrou,Mobila,Bucatarie,"
                    + "Agent,Imagine,Publicate,Web,Stare,Status,ClientID,Comision,"
                    + "Negociabil,Pret,Exclusivitate,ObservatiiPret,Textanunt,AlteDetaliiConfidentiale,"
                    + "Sector,Strada,Numar,Zona,AdresaCompleta,Camere,Confort,Compartimentare,"
                    + "EtajeTotale,Etaj,Parter,Ultimul,"
                    + ""
                    + "SuprafataConstruita,NumarGrupuriSanitare,AnConstructie,ImbunatatiriReale,NumarBalcoane,"
                    + "SuprafataUtila,FereastraGrupSanitar,"
                    + "NumarGaraje,LocuriParcare,Rezidential,Comercial,Birouri,Vacanta, UsiIntrare,"
                    + "Celulare,Lemn,Panel,PVC,Sticla,Link,DescriereEmotionala,Harta,Data,Poza,"
                + "Curent,Gaz,Apa,Canalizare,Catv,TelefonO,International,CentralaProprie,"
                    + "CentralaImobil,Termoficare,Soba,Calorifere,IncalzirePardoseala,Cablu,"
                    + "FibraOptica,Wireless,Adsl,Parchet,Gresie,Linoleum,Mocheta,Dusumea,Marmura,"
                    + "Var,Vinarom,Lavabila,Faianta,Lambriu,Tapet,Homa,Aluminiu,Pvc2,Lemn2,Interior,"
                    + "Exterior,Terasa,WCServiciu,Debara,BoxaSubsol,Apometre,ContorGaz,ContoareCaldura,"
                    + "Jacuzzi,SenzorFum,Alarma,Aragaz,CuptorMicrounde,Plita,MasinaDeSpalat,Lift,Interfon,"
                    + "Sauna)"
                + " values (0,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?, ?,?,?,?,?,"
                    + "?,?,?,?,?,  ?,?,?,?,?,   ?,?,?,?,?,   ?,?,?,?,?   ,?,?,?,?,?,   ?,?,?,?,?,    ?,?,?,?,?,"
                    + "?,?,?,?,?,      ?,?,?,?,?,     ?,?,?,?,?,    ?,?,?,?,?,   ?,?,?,?,?,    ?,?,?,?,?,   ?,?,?,?,?,"
                    + "?,?)");
            /*myStmt = conn.prepareStatement("insert into aptinchiriere1"
                + " (Comision,"
                    + "ObservatiiPret,Negociabil,Pret,Exclusivitate,Valoric,Nume)"
                + " values (0, ?,?,?,?,?)");*/

            // set params
            
            

            if (PozitieComboBox.getSelectedIndex()==0){
                 myStmt.setString(1, "");
            }else{
                myStmt.setString(1, PozitieComboBox.getSelectedItem().toString());
            }
            myStmt.setInt(2, metrou);
            if (MobilaComboBox.getSelectedIndex()==0){
                 myStmt.setString(3, "");
            }else{
                myStmt.setString(3, MobilaComboBox.getSelectedItem().toString());
            }
            //BucatarieComboBox
            if (BucatarieComboBox.getSelectedIndex()==0){
                 myStmt.setString(4, "");
            }else{
                myStmt.setString(4, BucatarieComboBox.getSelectedItem().toString());
            }
            myStmt.setString(5,Login.User);
            if (ListaPoze.size()!=0){
                imagine=1;
            }else{
                imagine=0;
            }
            myStmt.setInt(6, imagine);
             myStmt.setInt(7, publicate);
            myStmt.setInt(8, web);
            myStmt.setString(9, StareComboBox.getSelectedItem().toString());
            myStmt.setString(10, StatusComboBox.getSelectedItem().toString());
            //aici pui id-ul clientului de la 12
             myStmt.setInt(11, MeniuInserare.IdClient);
            
            
            myStmt.setString(12, ComisionTextField.getText());
           // myStmt.setInt(13, Integer.parseInt(ValoricTextField.getText()));
            myStmt.setInt(13, negociabil);
            myStmt.setInt(14, Integer.parseInt(PretTextField.getText()));
            myStmt.setInt(15, exclusivitate);
            myStmt.setString(16, Observatii_PretTextPane.getText());     
            myStmt.setString(17, "");
            myStmt.setString(18, AlteDetaliiConfidentialeTextPane.getText());
             
            
             if (SectorComboBox.getSelectedIndex()==0){
                 myStmt.setString(19, "");
            }else{
                myStmt.setString(19, SectorComboBox.getSelectedItem().toString());
            }  
            myStmt.setString(20, StradaTextField.getText());
             myStmt.setInt(21, Integer.parseInt(NrTextField.getText()));
            myStmt.setString(22, ReperComboBox.getSelectedItem().toString());
             myStmt.setString(23, AdesaCompletaTextPane.getText());
             
              if (NrCamereComboBox.getSelectedIndex()==0){
                 myStmt.setString(24, "");
            }else{
                myStmt.setString(24, NrCamereComboBox.getSelectedItem().toString());
            }
               if (ConfortComboBox.getSelectedIndex()==0){
                 myStmt.setString(25, "");
            }else{
                myStmt.setString(25, ConfortComboBox.getSelectedItem().toString());
            }
               if (CompartimentareComboBox.getSelectedIndex()==0){
                 myStmt.setString(26, "");
            }else{
                myStmt.setString(26, CompartimentareComboBox.getSelectedItem().toString());
            }
               
                myStmt.setInt(27, Integer.parseInt(EtajeTotaleComboBox.getSelectedItem().toString()));
             myStmt.setInt(28, Integer.parseInt(EtajComboBox.getSelectedItem().toString()));
             myStmt.setInt(29, parter);
             myStmt.setInt(30, ultimul);
             
             myStmt.setInt(31, Integer.parseInt(SuprafataConstruitaTextField.getText()));
             myStmt.setInt(32, Integer.parseInt(NrGrupuriSanitareComboBox.getSelectedItem().toString()));
             myStmt.setInt(33, Integer.parseInt(AnTextField.getText()));
              if (ImbunatatiriRealeComboBox.getSelectedIndex()==0){
                 myStmt.setString(34, "");
            }else{
                myStmt.setString(34, ImbunatatiriRealeComboBox.getSelectedItem().toString());
            }
             myStmt.setInt(35, Integer.parseInt(NrBalcoaneComboBox.getSelectedItem().toString()));
             myStmt.setInt(36, Integer.parseInt(SuprafataUtilaTextField.getText()));
             myStmt.setInt(37, fereastragrupsanitar);
             myStmt.setInt(38, Integer.parseInt(GarajeComboBox.getSelectedItem().toString()));
             myStmt.setInt(39, Integer.parseInt(ParcareComboBox.getSelectedItem().toString()));
             myStmt.setInt(40, rezidential);
             myStmt.setInt(41, comercial);
             myStmt.setInt(42, birouri);
             myStmt.setInt(43, vacanta);
             
             myStmt.setString(44, UsiIntrareComboBox.getSelectedItem().toString());
             myStmt.setInt(45, celulare);
             myStmt.setInt(46, lemn);
             myStmt.setInt(47, panel);
             myStmt.setInt(48, pvc);
             myStmt.setInt(49, sticla);
             myStmt.setString(50, LinkTextField.getText());
             myStmt.setString(51, DescriereEmotionalaTextPane.getText());
             
             //myStmt.setInt(53, publicate);
             //aici pui publicate
             
             if(Harta.img!=null){
             File file = new File("image.jpg");
             
        ImageIO.write(Harta.img, "jpg", file);
             
             
              FileInputStream fis = new FileInputStream(file); 

  
  myStmt.setBinaryStream(52, fis, (int) file.length());
  }
  else{
      myStmt.setNull(52, Types.BLOB);
  }
             java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());  
            //System.out.println(date);
            myStmt.setTimestamp(53, date);
/*DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
Date date = new Date();

System.out.println(dateFormat.format(date));
myStmt.setString(53, dateFormat.format(date));*/
//pentru Imagine
/*if (ListaPoze.size()>=1){
    myStmt.setInt(56, 1);
}else{
    myStmt.setInt(56, 0);
}*/


if(ListaPoze.size()>=1){
File file1 = new File("image1.jpg");
ImageIO.write(ListaPoze.get(0), "jpg", file1);
FileInputStream fis1 = new FileInputStream(file1);
myStmt.setBinaryStream(54, fis1, (int) file1.length());
}
else{
    myStmt.setNull(54, Types.BLOB);
}
             myStmt.setInt(55, curent);
           myStmt.setInt(56, gaz);
           myStmt.setInt(57, apa);
           myStmt.setInt(58, canalizare);
           myStmt.setInt(59, catv);
           myStmt.setInt(60, telefon);
           myStmt.setInt(61, international);
           myStmt.setInt(62, centralaproprie);
           myStmt.setInt(63, centralaimobil);
           myStmt.setInt(64, termoficare);
           myStmt.setInt(65, soba);
           myStmt.setInt(66, calorifere);
           myStmt.setInt(67, incalzirepardoseala);
           myStmt.setInt(68, cablu);
           myStmt.setInt(69, fibraoptica);
           myStmt.setInt(70, wireless);
           myStmt.setInt(71, adsl);
           myStmt.setInt(72, parchet);
           myStmt.setInt(73, gresie);
           myStmt.setInt(74, linoleum);
           myStmt.setInt(75, mocheta);
           myStmt.setInt(76, dusumea);
           myStmt.setInt(77, marmura);
           myStmt.setInt(78, var);
           myStmt.setInt(79, vinarom);
           myStmt.setInt(80, lavabila);
           myStmt.setInt(81, faianta);
           myStmt.setInt(82, lambriu);
           myStmt.setInt(83, tapet);
           myStmt.setInt(84, homa);
           myStmt.setInt(85, aluminiu);
           myStmt.setInt(86, pvc2);
           myStmt.setInt(87, lemn2);
           myStmt.setInt(88, interior);
           myStmt.setInt(89, exterior);
           myStmt.setInt(90, terasa);
           myStmt.setInt(91, wcserviciu);
           myStmt.setInt(92, debara);
           myStmt.setInt(93, boxasubsol);
           myStmt.setInt(94, apometre);
           myStmt.setInt(95, contorgaz);
           myStmt.setInt(96, contoarecaldura);
           myStmt.setInt(97, jacuzzi);
           myStmt.setInt(98, senzorfum);
           myStmt.setInt(99, alarma);
           myStmt.setInt(100, aragaz);
           myStmt.setInt(101, cuptormicrounde);
           myStmt.setInt(102, plita);
           myStmt.setInt(103, masinadespalat);
           myStmt.setInt(104, lift);
           myStmt.setInt(105, interfon);
           myStmt.setInt(106, sauna);
                    
           myStmt.executeUpdate();
           //fis.close();
   
             
            
             conn.close();
             Harta.img=null;
        }

        catch(Exception e){
            e.printStackTrace();
        }
        }
        else{
            JOptionPane.showMessageDialog(OVA.this,"Va rugam sa completati campurile cu rosu","Error Message",JOptionPane.ERROR_MESSAGE);
        }
        if(ListaPoze.size()!=0 &&introducere_pret()==true&&introducere_ProprietateGeneral()==true&&
                introducere_ApartamenteLocalizare()==true&&introducere_CaracteristiciProprietate()==true
                &&introducere_Finisaje()==true&&introducere_Link()==true){
            
        Statement stmt = null;
        int OVA=0;
        try{
             Class.forName("com.mysql.jdbc.Driver");

       Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
        stmt = (Statement) conn.createStatement();

        ResultSet rs1;
       rs1 = stmt.executeQuery("select MAX(OVA) from aptvanzare ");
            
       while(rs1.next()){
           OVA=rs1.getInt("MAX(OVA)");
            
       }
            System.out.println(OVA);
    }
        catch(Exception e){
            e.printStackTrace();
        }
         try{
    for(int i=0;i<ListaPoze.size();i++){
       
File file = new File("image.jpg");
ImageIO.write(ListaPoze.get(i), "jpg", file);
FileInputStream fis = new FileInputStream(file);

        
   Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");

  PreparedStatement ps = conn
       .prepareStatement("insert into pozeva"
					+ " (OVA,Poza,PrimaPoza)"
					+ " values (?,?,?)");

  ps.setInt(1, OVA);
  ps.setBinaryStream(2, fis, (int) file.length());
    if(i==0){
  ps.setBoolean(3, true);
  }
 else{
      ps.setBoolean(3, false);
  }
                    
   ps.executeUpdate();
    ps.close();
   fis.close();
   conn.close();

  
    }
                }
                  catch(Exception e){
                      e.printStackTrace();
    
}
}
    }
     
    public OVA() {
        initComponents();
         this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
         jScrollPane1.getVerticalScrollBar().setUnitIncrement(16);
         metoda_init();
         this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);

        Integer telefon= MeniuInserare.TelefonClient;
        
        
        LabelCaractere.setText("100");
        DescriereEmotionalaTextPane.getDocument().addDocumentListener(this);
         
        InputMap im = DescriereEmotionalaTextPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
    }

    public OVA(int ova){
        initComponents();
         EchipaComboBox.setEnabled(false);
        LinkTextField.setEnabled(false);
        WebCheckBox.setEnabled(false);
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
       
        
       rs1 = stmt.executeQuery("select OVA,Pozitie,Camere,Metrou,Confort,Mobila,Bucatarie,ImbunatatiriReale,EtajeTotale"
               +" ,Etaj,AnConstructie,Publicate,Web,Imagine,Stare,Status,Comision,Negociabil,Pret,Exclusivitate,ObservatiiPret"
               +" ,TextAnunt,AlteDetaliiConfidentiale,Sector,Strada,Numar,Reper,AdresaCompleta,SuprafataConstruita,NumarGrupuriSanitare"
               +" ,NumarBalcoane,SuprafataUtila,FereastraGrupSanitar,NumarGaraje,LocuriParcare,Rezidential,Comercial,Birouri,Vacanta,UsiIntrare,Celulare,Lemn,Panel"
               +",PVC,Sticla,DescriereEmotionala,Link,Parter,Ultimul,Compartimentare,Harta,Poza,Curent,Gaz,Apa,Canalizare,Catv,TelefonO"
               + ",International,CentralaProprie,CentralaImobil,Termoficare,Soba,Calorifere,IncalzirePardoseala,Cablu,FibraOptica,Wireless,Adsl,Parchet,Gresie,Linoleum"
               + ",Mocheta,Dusumea,Marmura,Var,Vinarom,Lavabila,Faianta,Lambriu,Tapet,Homa,Aluminiu,Pvc2,Lemn2,Interior,Exterior,Terasa,WCServiciu"
               + ",Debara,BoxaSubsol,Apometre,ContorGaz,ContoareCaldura,Jacuzzi,SenzorFum,Alarma,Aragaz,CuptorMicrounde,Plita,MasinaDeSpalat,Lift,Interfon,Sauna from aptvanzare where OVA = "+ova+"");
       while(rs1.next()){
           if(rs1.getString("Pozitie").equalsIgnoreCase("Ultracentral")){
               PozitieComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Pozitie").equalsIgnoreCase("Central")){
               PozitieComboBox.setSelectedIndex(2);
           }
           else if(rs1.getString("Pozitie").equalsIgnoreCase("Cartier")){
               PozitieComboBox.setSelectedIndex(3);
           }
           else if(rs1.getString("Pozitie").equalsIgnoreCase("Periferie")){
               PozitieComboBox.setSelectedIndex(1);
           }
           else{
               PozitieComboBox.setSelectedIndex(0);
           }
           if (rs1.getString("Camere").equalsIgnoreCase("1")){
               NrCamereComboBox.setSelectedIndex(1);
           }
           else if (rs1.getString("Camere").equalsIgnoreCase("2")){
               NrCamereComboBox.setSelectedIndex(2);
           }
           else if (rs1.getString("Camere").equalsIgnoreCase("3")){
               NrCamereComboBox.setSelectedIndex(3);
           }
           else if (rs1.getString("Camere").equalsIgnoreCase("4")){
               NrCamereComboBox.setSelectedIndex(4);
           }
           else if (rs1.getString("Camere").equalsIgnoreCase("4+")){
               NrCamereComboBox.setSelectedIndex(5);
           }
           else {
               NrCamereComboBox.setSelectedIndex(0);
           }
           if(rs1.getInt("Metrou")==1){
               MetrouCheckBox.setSelected(true);
           }
           if(rs1.getString("Confort").equalsIgnoreCase("I+")){
               ConfortComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Confort").equalsIgnoreCase("I")){
               ConfortComboBox.setSelectedIndex(2);
           }
           else if(rs1.getString("Confort").equalsIgnoreCase("II+")){
               ConfortComboBox.setSelectedIndex(3);
           }
           else if(rs1.getString("Confort").equalsIgnoreCase("II")){
               ConfortComboBox.setSelectedIndex(4);
           }
           else if(rs1.getString("Confort").equalsIgnoreCase("III+")){
               ConfortComboBox.setSelectedIndex(5);
           }
           else if(rs1.getString("Confort").equalsIgnoreCase("III")){
               ConfortComboBox.setSelectedIndex(6);
           }
           else{
               ConfortComboBox.setSelectedIndex(0);
           }
           if(rs1.getString("Mobila").equalsIgnoreCase("Nemobilat")){
               MobilaComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Mobila").equalsIgnoreCase("Mobilat Partial")){
               MobilaComboBox.setSelectedIndex(2);
           }
           else if(rs1.getString("Mobila").equalsIgnoreCase("Mobilat Complet")){
               MobilaComboBox.setSelectedIndex(3);
           }
           else if(rs1.getString("Mobila").equalsIgnoreCase("Mobilat lux")){
               MobilaComboBox.setSelectedIndex(4);
           }
           else{
               MobilaComboBox.setSelectedIndex(0);
           }
           if(rs1.getString("Bucatarie").equalsIgnoreCase("Nemobilata")){
               BucatarieComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Bucatarie").equalsIgnoreCase("Mobilata Partial")){
               BucatarieComboBox.setSelectedIndex(2);
           }
           else if(rs1.getString("Bucatarie").equalsIgnoreCase("Mobilata Complet")){
               BucatarieComboBox.setSelectedIndex(3);
           }
           else{
               BucatarieComboBox.setSelectedIndex(0);
           }
           if(rs1.getString("ImbunatatiriReale").equalsIgnoreCase("NU")){
               ImbunatatiriRealeComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("ImbunatatiriReale").equalsIgnoreCase("DA")){
               ImbunatatiriRealeComboBox.setSelectedIndex(2);
           }
           else{
               ImbunatatiriRealeComboBox.setSelectedIndex(0);
           }
           if(rs1.getInt("EtajeTotale")==0){
               EtajeTotaleComboBox.setSelectedIndex(0);
           }
           else if(rs1.getInt("EtajeTotale")==5){
               EtajeTotaleComboBox.setSelectedIndex(1);
           }
           else if(rs1.getInt("EtajeTotale")==10){
               EtajeTotaleComboBox.setSelectedIndex(2);
           }
           else if(rs1.getInt("EtajeTotale")==15){
               EtajeTotaleComboBox.setSelectedIndex(3);
           }
           else if(rs1.getInt("EtajeTotale")==20){
               EtajeTotaleComboBox.setSelectedIndex(4);
           }
           AnTextField.setText(rs1.getString("AnConstructie"));
           if(rs1.getInt("Publicate")==1){
               PublicatCheckBox.setSelected(true);
           }
           if(rs1.getInt("Web")==1){
               WebCheckBox.setSelected(true);
           }
           if(rs1.getString("Stare").equalsIgnoreCase("Actual")){
               StareComboBox.setSelectedIndex(0);
           }
           else if(rs1.getString("Stare").equalsIgnoreCase("Incorect")){
               StareComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Stare").equalsIgnoreCase("Vandut")){
               StareComboBox.setSelectedIndex(2);
           }
           if(rs1.getString("Status").equalsIgnoreCase("OK")){
               StatusComboBox.setSelectedIndex(0);
           }
           else if(rs1.getString("Status").equalsIgnoreCase("De revenit")){
               StatusComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Status").equalsIgnoreCase("Nu colaboreaza")){
               StatusComboBox.setSelectedIndex(2);
           }
           ComisionTextField.setText(rs1.getString("Comision"));
           if(rs1.getInt("Negociabil")==1){
               NegociabilCheckBox.setSelected(true);
           }
           PretTextField.setText(rs1.getString("Pret"));
           if(rs1.getInt("Exclusivitate")==1){
               ExclusivitateCheckBox.setSelected(true);
           }
           Observatii_PretTextPane.setText(rs1.getString("ObservatiiPret"));
          // TextanuntTextPane.setText("");
           AlteDetaliiConfidentialeTextPane.setText(rs1.getString("AlteDetaliiConfidentiale"));
           if(rs1.getString("Sector").equalsIgnoreCase("Sector 5")){
               SectorComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Sector").equalsIgnoreCase("Sector 6")){
               SectorComboBox.setSelectedIndex(2);
           } else{
               SectorComboBox.setSelectedIndex(0);
           }
           StradaTextField.setText(rs1.getString("Strada"));
           NrTextField.setText(rs1.getString("Numar"));
           AdesaCompletaTextPane.setText(rs1.getString("AdresaCompleta"));
           SuprafataConstruitaTextField.setText(rs1.getString("SuprafataConstruita"));
           NrGrupuriSanitareComboBox.setSelectedIndex(rs1.getInt("NumarGrupuriSanitare"));
           NrBalcoaneComboBox.setSelectedIndex(rs1.getInt("NumarBalcoane"));
           SuprafataUtilaTextField.setText(rs1.getString("SuprafataUtila"));
           if(rs1.getInt("FereastraGrupSanitar")==1){
               FereastraGrupSanitarCheckBox.setSelected(true);
           }
           GarajeComboBox.setSelectedIndex(rs1.getInt("NumarGaraje"));
           ParcareComboBox.setSelectedIndex(rs1.getInt("LocuriParcare"));
           if(rs1.getInt("Rezidential")==1){
               RezidentialCheckBox.setSelected(true);
           }
           if(rs1.getInt("Comercial")==1){
               ComercialCheckBox.setSelected(true);
           }
           if(rs1.getInt("Birouri")==1){
              BirouriCheckBox.setSelected(true);
           }
           if(rs1.getInt("Vacanta")==1){
               VacantaCheckBox.setSelected(true);
           }
           if(rs1.getString("UsiIntrare").equalsIgnoreCase("Metal")){
               UsiIntrareComboBox.setSelectedIndex(0);
           }
           else{
               UsiIntrareComboBox.setSelectedIndex(1);
           }
           if(rs1.getInt("Celulare")==1){
               CelulareCheckBox.setSelected(true);
           }
           if(rs1.getInt("Lemn")==1){
               LemnCheckBox.setSelected(true);
           }
           if(rs1.getInt("Panel")==1){
               PanelCheckBox.setSelected(true);
           }
           if(rs1.getInt("PVC")==1){
               PVCCheckBox.setSelected(true);
           }
           if(rs1.getInt("Sticla")==1){
               SticlaCheckBox.setSelected(true);
           }
           DescriereEmotionalaTextPane.setText(rs1.getString("DescriereEmotionala"));
           LinkTextField.setText(rs1.getString("Link"));
           if(rs1.getInt("Parter")==1){
               ParterCheckBox.setSelected(true);
           }
           if(rs1.getInt("Ultimul")==1){
               UltimulCheckBox.setSelected(true);
           }
           if(rs1.getString("Compartimentare").equalsIgnoreCase("Decomandat")){
               CompartimentareComboBox.setSelectedIndex(1);
           }
           else if(rs1.getString("Compartimentare").equalsIgnoreCase("Semidecomandat")){
               CompartimentareComboBox.setSelectedIndex(2);
           }
           else if(rs1.getString("Compartimentare").equalsIgnoreCase("Circular")){
               CompartimentareComboBox.setSelectedIndex(3);
           }
           else{
               CompartimentareComboBox.setSelectedIndex(0);
           }
           EtajComboBox.setSelectedIndex(rs1.getInt("Etaj"));
           imagine=rs1.getInt("Imagine");
           int lungime=rs1.getString("DescriereEmotionala").length();
           if(lungime>100){
               LabelCaractere.setText("0");
           }
           else{
               LabelCaractere.setText(String.valueOf(100-lungime));
           }
           DescriereEmotionalaTextPane.getDocument().addDocumentListener(this);
         
        InputMap im = DescriereEmotionalaTextPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        parametru=ova;
        byte[] imgData2 = rs1.getBytes("Harta");
        File file2 = new File("image2.jpg");
        harta = byteArrayToImage(imgData2);
        byte[] imgData1 = rs1.getBytes("Poza");
        File file1 = new File("image1.jpg");
        poza = byteArrayToImage(imgData1);
        if(rs1.getInt("Curent")==1){
            Curent.setSelected(true);
        }
        if(rs1.getInt("Gaz")==1){
            Gaz.setSelected(true);
        }
        if(rs1.getInt("Apa")==1){
            Apa.setSelected(true);
        }
        if(rs1.getInt("Canalizare")==1){
            Canalizare.setSelected(true);
        }
        if(rs1.getInt("Catv")==1){
            CATV.setSelected(true);
        }
        if(rs1.getInt("TelefonO")==1){
            TelefonO.setSelected(true);
        }
        if(rs1.getInt("CentralaProprie")==1){
            CentralaProprie.setSelected(true);
        }
        if(rs1.getInt("CentralaImobil")==1){
            CentralaImobil.setSelected(true);
        }
        if(rs1.getInt("Termoficare")==1){
            Termoficare.setSelected(true);
        }
        if(rs1.getInt("Soba")==1){
            Soba.setSelected(true);
        }
        if(rs1.getInt("Calorifere")==1){
            Calorifere.setSelected(true);
        }
        if(rs1.getInt("IncalzirePardoseala")==1){
            IncalzirePardoseala.setSelected(true);
        }
        if(rs1.getInt("Cablu")==1){
            Cablu.setSelected(true);
        }
        if(rs1.getInt("FibraOptica")==1){
            FibraOptica.setSelected(true);
        }
        if(rs1.getInt("Wireless")==1){
            Wireless.setSelected(true);
        }
        if(rs1.getInt("Adsl")==1){
            ADSL.setSelected(true);
        }
        if(rs1.getInt("Parchet")==1){
            Parchet.setSelected(true);
        }
        if(rs1.getInt("Gresie")==1){
            Gresie.setSelected(true);
        }
        if(rs1.getInt("Linoleum")==1){
            Linoleum.setSelected(true);
        }
        if(rs1.getInt("Mocheta")==1){
            Mocheta.setSelected(true);
        }
        if(rs1.getInt("Dusumea")==1){
            Dusumea.setSelected(true);
        }
        if(rs1.getInt("Marmura")==1){
            Marmura.setSelected(true);
        }
        if(rs1.getInt("Var")==1){
            Var.setSelected(true);
        }
        if(rs1.getInt("Vinarom")==1){
            Vinarom.setSelected(true);
        }
        if(rs1.getInt("Lavabila")==1){
            Lavabila.setSelected(true);
        }
        if(rs1.getInt("Faianta")==1){
            Faianta.setSelected(true);
        }
        if(rs1.getInt("Lambriu")==1){
            Lambriu.setSelected(true);
        }
        if(rs1.getInt("Tapet")==1){
            Tapet.setSelected(true);
        }
        if(rs1.getInt("Homa")==1){
            Homa.setSelected(true);
        }
        if(rs1.getInt("Aluminiu")==1){
            Aluminiu.setSelected(true);
        }
        if(rs1.getInt("Pvc2")==1){
            PVC2.setSelected(true);
        }
        if(rs1.getInt("Lemn2")==1){
            Lemn2.setSelected(true);
        }
        if(rs1.getInt("Interior")==1){
            Interior.setSelected(true);
        }
        if(rs1.getInt("Exterior")==1){
            Exterior.setSelected(true);
        }
        if(rs1.getInt("Terasa")==1){
            Terasa.setSelected(true);
        }
        if(rs1.getInt("WCServiciu")==1){
            WCServiciu.setSelected(true);
        }if(rs1.getInt("Debara")==1){
            Debara.setSelected(true);
        }
        if(rs1.getInt("BoxaSubsol")==1){
            BoxaSubsol.setSelected(true);
        }
        if(rs1.getInt("Apometre")==1){
            Apometre.setSelected(true);
        }
        if(rs1.getInt("ContorGaz")==1){
            ContorGaz.setSelected(true);
        }
        if(rs1.getInt("ContoareCaldura")==1){
            ContoareCaldura.setSelected(true);
        }
        if(rs1.getInt("Jacuzzi")==1){
            Jacuzzi.setSelected(true);
        }
        if(rs1.getInt("SenzorFum")==1){
            SenzorFum.setSelected(true);
        }
        if(rs1.getInt("Alarma")==1){
            Alarma.setSelected(true);
        }
        if(rs1.getInt("Aragaz")==1){
            Aragaz.setSelected(true);
        }
        if(rs1.getInt("CuptorMicrounde")==1){
            CuptorMicrounde.setSelected(true);
        }
        if(rs1.getInt("Plita")==1){
            Plita.setSelected(true);
        }
        if(rs1.getInt("MasinaDeSpalat")==1){
            MasinaDeSpalat.setSelected(true);
        }
        if(rs1.getInt("Lift")==1){
            Lift.setSelected(true);
        }
        if(rs1.getInt("Interfon")==1){
            Interfon.setSelected(true);
        }
        if(rs1.getInt("Sauna")==1){
            Sauna.setSelected(true);
        }
        
        
        
        
        
        modifica=true;
       }
       if(imagine==1){
           ResultSet rs2;
       
        
       rs2 = stmt.executeQuery("select Poza from pozeva where OVA="+ova+"");
       while(rs2.next()){
           byte[] imgData2 = rs2.getBytes("Poza"); //Here r1.getBytes() extract byte data from resultSet 
             
              File file2 = new File("image2.jpg");
           
             BufferedImage image2 = byteArrayToImage(imgData2);
             ListaPoze.add(image2);
           
       }
       JPanel panel = new JPanel();
            panel.invalidate();
            for (int i = 0; i <ListaPoze.size(); i++) {
                JButton btn = new JButton();
                // BufferedImage img=new BufferedImage(ListaPoze.get(i));
                ImageIcon img=new ImageIcon(resize(ListaPoze.get(i),100,100));
                btn.setIcon(img);
                btn.setPreferredSize(new Dimension(100,100));
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        ParcurgereImagine img=new ParcurgereImagine(ListaPoze);
                        img.setVisible(true);

                    }
                });

                panel.add(btn);

            }

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(0, 0, 300, 150);
            //JPanel contentPane = new JPanel(null);

            //contentPane.setPreferredSize(new Dimension(500, 400));
            PanelContainerPoze.add(scrollPane);
        
           
       }
       
       conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
    }
    
     public void updateOVA(){
        PreparedStatement myStmt = null; 
        try{
             Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
                // System.out.println("db connected");
             
               
                myStmt = conn.prepareStatement("update aptvanzare set Pozitie=?,Metrou=?,Mobila=?,Bucatarie=?,"
                    + "Agent=?,Imagine=?,Publicate=?,Web=?,Stare=?,Status=?,Comision=?,"
                    + "Negociabil=?,Pret=?,Exclusivitate=?,ObservatiiPret=?,Textanunt=?,AlteDetaliiConfidentiale=?,"
                    + "Sector=?,Strada=?,Numar=?,Reper=?,AdresaCompleta=?,Camere=?,Confort=?,Compartimentare=?,"
                    + "EtajeTotale=?,Etaj=?,Parter=?,Ultimul=?,"
                    + ""
                    + "SuprafataConstruita=?,NumarGrupuriSanitare=?,AnConstructie=?,ImbunatatiriReale=?,NumarBalcoane=?,"
                    + "SuprafataUtila=?,FereastraGrupSanitar=?,"
                    + "NumarGaraje=?,LocuriParcare=?,Rezidential=?,Comercial=?,Birouri=?,Vacanta=?, UsiIntrare=?,"
                    + "Celulare=?,Lemn=?,Panel=?,PVC=?,Sticla=?,Link=?,DescriereEmotionala=?,Harta=?,Poza=?,Curent=?,Gaz=?,Apa=?,Canalizare=?,Catv=?,TelefonO=?"
               + ",International=?,CentralaProprie=?,CentralaImobil=?,Termoficare=?,Soba=?,Calorifere=?,IncalzirePardoseala=?,Cablu=?,FibraOptica=?,Wireless=?,Adsl=?,Parchet=?,Gresie=?,Linoleum=?"
               + ",Mocheta=?,Dusumea=?,Marmura=?,Var=?,Vinarom=?,Lavabila=?,Faianta=?,Lambriu=?,Tapet=?,Homa=?,Aluminiu=?,Pvc2=?,Lemn2=?,Interior=?,Exterior=?,Terasa=?,WCServiciu=?"
               + ",Debara=?,BoxaSubsol=?,Apometre=?,ContorGaz=?,ContoareCaldura=?,Jacuzzi=?,SenzorFum=?,Alarma=?,Aragaz=?,CuptorMicrounde=?,Plita=?,MasinaDeSpalat=?,Lift=?,Interfon=?,Sauna=? where OVA="+parametru);
                 
                if (PozitieComboBox.getSelectedIndex()==0){
                 myStmt.setString(1, "");
            }else{
                myStmt.setString(1, PozitieComboBox.getSelectedItem().toString());
            }
            myStmt.setInt(2, metrou);
            if (MobilaComboBox.getSelectedIndex()==0){
                 myStmt.setString(3, "");
            }else{
                myStmt.setString(3, MobilaComboBox.getSelectedItem().toString());
            }
            //BucatarieComboBox
            if (BucatarieComboBox.getSelectedIndex()==0){
                 myStmt.setString(4, "");
            }else{
                myStmt.setString(4, BucatarieComboBox.getSelectedItem().toString());
            }
            myStmt.setString(5,Login.User);
            if (ListaPoze.size()!=0){
                imagine=1;
            }else{
                imagine=0;
            }
            myStmt.setInt(6, imagine);
             myStmt.setInt(7, publicate);
            myStmt.setInt(8, web);
            myStmt.setString(9, StareComboBox.getSelectedItem().toString());
            myStmt.setString(10, StatusComboBox.getSelectedItem().toString());
            //aici pui id-ul clientului de la 12
             //myStmt.setInt(11, MeniuInserare.IdClient);
            
            
            myStmt.setString(11, ComisionTextField.getText());
           // myStmt.setInt(13, Integer.parseInt(ValoricTextField.getText()));
            myStmt.setInt(12, negociabil);
            myStmt.setInt(13, Integer.parseInt(PretTextField.getText()));
            myStmt.setInt(14, exclusivitate);
            myStmt.setString(15, Observatii_PretTextPane.getText());     
            myStmt.setString(16, "");
            myStmt.setString(17, AlteDetaliiConfidentialeTextPane.getText());
             
            
             if (SectorComboBox.getSelectedIndex()==0){
                 myStmt.setString(18, "");
            }else{
                myStmt.setString(18, SectorComboBox.getSelectedItem().toString());
            }  
            myStmt.setString(19, StradaTextField.getText());
             myStmt.setInt(20, Integer.parseInt(NrTextField.getText()));
            myStmt.setString(21, ReperComboBox.getSelectedItem().toString());
             myStmt.setString(22, AdesaCompletaTextPane.getText());
             
              if (NrCamereComboBox.getSelectedIndex()==0){
                 myStmt.setString(23, "");
            }else{
                myStmt.setString(23, NrCamereComboBox.getSelectedItem().toString());
            }
               if (ConfortComboBox.getSelectedIndex()==0){
                 myStmt.setString(24, "");
            }else{
                myStmt.setString(24, ConfortComboBox.getSelectedItem().toString());
            }
               if (CompartimentareComboBox.getSelectedIndex()==0){
                 myStmt.setString(25, "");
            }else{
                myStmt.setString(25, CompartimentareComboBox.getSelectedItem().toString());
            }
               
                myStmt.setInt(26, Integer.parseInt(EtajeTotaleComboBox.getSelectedItem().toString()));
             myStmt.setInt(27, Integer.parseInt(EtajComboBox.getSelectedItem().toString()));
             myStmt.setInt(28, parter);
             myStmt.setInt(29, ultimul);
             
             myStmt.setInt(30, Integer.parseInt(SuprafataConstruitaTextField.getText()));
             myStmt.setInt(31, Integer.parseInt(NrGrupuriSanitareComboBox.getSelectedItem().toString()));
             myStmt.setInt(32, Integer.parseInt(AnTextField.getText()));
              if (ImbunatatiriRealeComboBox.getSelectedIndex()==0){
                 myStmt.setString(33, "");
            }else{
                myStmt.setString(33, ImbunatatiriRealeComboBox.getSelectedItem().toString());
            }
             myStmt.setInt(34, Integer.parseInt(NrBalcoaneComboBox.getSelectedItem().toString()));
             myStmt.setInt(35, Integer.parseInt(SuprafataUtilaTextField.getText()));
             myStmt.setInt(36, fereastragrupsanitar);
             myStmt.setInt(37, Integer.parseInt(GarajeComboBox.getSelectedItem().toString()));
             myStmt.setInt(38, Integer.parseInt(ParcareComboBox.getSelectedItem().toString()));
             myStmt.setInt(39, rezidential);
             myStmt.setInt(40, comercial);
             myStmt.setInt(41, birouri);
             myStmt.setInt(42, vacanta);
             
             myStmt.setString(43, UsiIntrareComboBox.getSelectedItem().toString());
             myStmt.setInt(44, celulare);
             myStmt.setInt(45, lemn);
             myStmt.setInt(46, panel);
             myStmt.setInt(47, pvc);
             myStmt.setInt(48, sticla);
             myStmt.setString(49, LinkTextField.getText());
             myStmt.setString(50, DescriereEmotionalaTextPane.getText());
             if(Harta.img!=null){
                 harta=Harta.img;
             }
             if(harta!=null){
             File file = new File("image1.jpg");
             
            ImageIO.write(harta, "jpg", file);
             
             
              FileInputStream fis = new FileInputStream(file); 

  
  myStmt.setBinaryStream(51, fis, (int) file.length());
  }
  else{
      myStmt.setNull(51, Types.BLOB);
  }
             if(poza==null &&ListaPozeModifica.size() >= 1){
                 File file = new File("image.jpg");
             
        ImageIO.write(ListaPozeModifica.get(0), "jpg", file);
             
             
              FileInputStream fis = new FileInputStream(file); 

  
  myStmt.setBinaryStream(52, fis, (int) file.length());
                 
                 
                 
                 
             }else if(poza!=null){
                 File file = new File("image.jpg");
             
        ImageIO.write(poza, "jpg", file);
             
             
              FileInputStream fis = new FileInputStream(file); 

  
  myStmt.setBinaryStream(52, fis, (int) file.length());
                 
             }
             else{
                 myStmt.setNull(52, Types.BLOB);
             }
             myStmt.setInt(53, curent);
           myStmt.setInt(54, gaz);
           myStmt.setInt(55, apa);
           myStmt.setInt(56, canalizare);
           myStmt.setInt(57, catv);
           myStmt.setInt(58, telefon);
           myStmt.setInt(59, international);
           myStmt.setInt(60, centralaproprie);
           myStmt.setInt(61, centralaimobil);
           myStmt.setInt(62, termoficare);
           myStmt.setInt(63, soba);
           myStmt.setInt(64, calorifere);
           myStmt.setInt(65, incalzirepardoseala);
           myStmt.setInt(66, cablu);
           myStmt.setInt(67, fibraoptica);
           myStmt.setInt(68, wireless);
           myStmt.setInt(69, adsl);
           myStmt.setInt(70, parchet);
           myStmt.setInt(71, gresie);
           myStmt.setInt(72, linoleum);
           myStmt.setInt(73, mocheta);
           myStmt.setInt(74, dusumea);
           myStmt.setInt(75, marmura);
           myStmt.setInt(76, var);
           myStmt.setInt(77, vinarom);
           myStmt.setInt(78, lavabila);
           myStmt.setInt(79, faianta);
           myStmt.setInt(80, lambriu);
           myStmt.setInt(81, tapet);
           myStmt.setInt(82, homa);
           myStmt.setInt(83, aluminiu);
           myStmt.setInt(84, pvc2);
           myStmt.setInt(85, lemn2);
           myStmt.setInt(86, interior);
           myStmt.setInt(87, exterior);
           myStmt.setInt(88, terasa);
           myStmt.setInt(89, wcserviciu);
           myStmt.setInt(90, debara);
           myStmt.setInt(91, boxasubsol);
           myStmt.setInt(92, apometre);
           myStmt.setInt(93, contorgaz);
           myStmt.setInt(94, contoarecaldura);
           myStmt.setInt(95, jacuzzi);
           myStmt.setInt(96, senzorfum);
           myStmt.setInt(97, alarma);
           myStmt.setInt(98, aragaz);
           myStmt.setInt(99, cuptormicrounde);
           myStmt.setInt(100, plita);
           myStmt.setInt(101, masinadespalat);
           myStmt.setInt(102, lift);
           myStmt.setInt(103, interfon);
           myStmt.setInt(104, sauna);
             
             myStmt.executeUpdate();
             Harta.img=null;
            conn.close();
        }
        catch(Exception e){
            e.printStackTrace();
            
        }
        try{
    for(int i=0;i<ListaPozeModifica.size();i++){
       
File file = new File("image.jpg");
ImageIO.write(ListaPozeModifica.get(i), "jpg", file);
FileInputStream fis = new FileInputStream(file);

        
   Class.forName("com.mysql.jdbc.Driver").newInstance();
    Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");

  PreparedStatement ps = conn
       .prepareStatement("insert into pozeia"
					+ " (OVA,Poza,PrimaPoza)"
					+ " values (?,?,?)");

  ps.setInt(1, parametru);
  ps.setBinaryStream(2, fis, (int) file.length());
    if(i==0 && poza==null){
  ps.setBoolean(3, true);
  }
 else{
      ps.setBoolean(3, false);
  }
                    
   ps.executeUpdate();
    ps.close();
   fis.close();
   conn.close();

  
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
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        StradaLabel = new javax.swing.JLabel();
        StradaTextField = new javax.swing.JTextField();
        NrLabel = new javax.swing.JLabel();
        NrTextField = new javax.swing.JTextField();
        ReperLabel = new javax.swing.JLabel();
        AdresaCompletaLabel = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        AdesaCompletaTextPane = new javax.swing.JTextPane();
        Label2 = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        NrCamereComboBox = new javax.swing.JComboBox<>();
        jLabel25 = new javax.swing.JLabel();
        ConfortComboBox = new javax.swing.JComboBox<>();
        jLabel26 = new javax.swing.JLabel();
        CompartimentareComboBox = new javax.swing.JComboBox<>();
        MobilaLabel = new javax.swing.JLabel();
        MobilaComboBox = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        BucatarieComboBox = new javax.swing.JComboBox<>();
        jPanel18 = new javax.swing.JPanel();
        SuprafataConstruitaLabel = new javax.swing.JLabel();
        SuprafataConstruitaTextField = new javax.swing.JTextField();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        NrGrupuriSanitareComboBox = new javax.swing.JComboBox<>();
        AnLabel = new javax.swing.JLabel();
        AnTextField = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        EtajComboBox = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        EtajeTotaleComboBox = new javax.swing.JComboBox<>();
        ParterCheckBox = new javax.swing.JCheckBox();
        UltimulCheckBox = new javax.swing.JCheckBox();
        jPanel19 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        NrBalcoaneComboBox = new javax.swing.JComboBox<>();
        SuprafataUtilaLabel = new javax.swing.JLabel();
        SuprafataUtilaTextField = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        FereastraGrupSanitarCheckBox = new javax.swing.JCheckBox();
        jLabel39 = new javax.swing.JLabel();
        GarajeComboBox = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        ParcareComboBox = new javax.swing.JComboBox<>();
        ImbunatatiriRealeComboBox = new javax.swing.JComboBox<>();
        jLabel33 = new javax.swing.JLabel();
        jPanel16 = new javax.swing.JPanel();
        RezidentialCheckBox = new javax.swing.JCheckBox();
        ComercialCheckBox = new javax.swing.JCheckBox();
        BirouriCheckBox = new javax.swing.JCheckBox();
        VacantaCheckBox = new javax.swing.JCheckBox();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        Curent = new javax.swing.JCheckBox();
        Gaz = new javax.swing.JCheckBox();
        Apa = new javax.swing.JCheckBox();
        Canalizare = new javax.swing.JCheckBox();
        CATV = new javax.swing.JCheckBox();
        TelefonO = new javax.swing.JCheckBox();
        International = new javax.swing.JCheckBox();
        jPanel6 = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        CentralaProprie = new javax.swing.JCheckBox();
        CentralaImobil = new javax.swing.JCheckBox();
        Termoficare = new javax.swing.JCheckBox();
        Soba = new javax.swing.JCheckBox();
        Calorifere = new javax.swing.JCheckBox();
        IncalzirePardoseala = new javax.swing.JCheckBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        Cablu = new javax.swing.JCheckBox();
        FibraOptica = new javax.swing.JCheckBox();
        Wireless = new javax.swing.JCheckBox();
        ADSL = new javax.swing.JCheckBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        jCheckBox24 = new javax.swing.JCheckBox();
        jCheckBox25 = new javax.swing.JCheckBox();
        jCheckBox26 = new javax.swing.JCheckBox();
        jLabel47 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        UsiIntrareComboBox = new javax.swing.JComboBox<>();
        jPanel22 = new javax.swing.JPanel();
        jLabel66 = new javax.swing.JLabel();
        CelulareCheckBox = new javax.swing.JCheckBox();
        LemnCheckBox = new javax.swing.JCheckBox();
        PanelCheckBox = new javax.swing.JCheckBox();
        PVCCheckBox = new javax.swing.JCheckBox();
        SticlaCheckBox = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel67 = new javax.swing.JLabel();
        Parchet = new javax.swing.JCheckBox();
        Gresie = new javax.swing.JCheckBox();
        Linoleum = new javax.swing.JCheckBox();
        Mocheta = new javax.swing.JCheckBox();
        Dusumea = new javax.swing.JCheckBox();
        Marmura = new javax.swing.JCheckBox();
        jPanel23 = new javax.swing.JPanel();
        jLabel68 = new javax.swing.JLabel();
        Var = new javax.swing.JCheckBox();
        Vinarom = new javax.swing.JCheckBox();
        Lavabila = new javax.swing.JCheckBox();
        Faianta = new javax.swing.JCheckBox();
        Lambriu = new javax.swing.JCheckBox();
        Tapet = new javax.swing.JCheckBox();
        Homa = new javax.swing.JCheckBox();
        jPanel9 = new javax.swing.JPanel();
        jLabel69 = new javax.swing.JLabel();
        Aluminiu = new javax.swing.JCheckBox();
        PVC2 = new javax.swing.JCheckBox();
        Lemn2 = new javax.swing.JCheckBox();
        jLabel70 = new javax.swing.JLabel();
        Interior = new javax.swing.JCheckBox();
        Exterior = new javax.swing.JCheckBox();
        jLabel48 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        Terasa = new javax.swing.JCheckBox();
        WCServiciu = new javax.swing.JCheckBox();
        Debara = new javax.swing.JCheckBox();
        BoxaSubsol = new javax.swing.JCheckBox();
        jPanel12 = new javax.swing.JPanel();
        jLabel51 = new javax.swing.JLabel();
        Apometre = new javax.swing.JCheckBox();
        ContorGaz = new javax.swing.JCheckBox();
        ContoareCaldura = new javax.swing.JCheckBox();
        jPanel15 = new javax.swing.JPanel();
        jLabel52 = new javax.swing.JLabel();
        Jacuzzi = new javax.swing.JCheckBox();
        SenzorFum = new javax.swing.JCheckBox();
        Alarma = new javax.swing.JCheckBox();
        jPanel13 = new javax.swing.JPanel();
        jLabel53 = new javax.swing.JLabel();
        Aragaz = new javax.swing.JCheckBox();
        CuptorMicrounde = new javax.swing.JCheckBox();
        Plita = new javax.swing.JCheckBox();
        MasinaDeSpalat = new javax.swing.JCheckBox();
        jPanel14 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        Lift = new javax.swing.JCheckBox();
        Interfon = new javax.swing.JCheckBox();
        Sauna = new javax.swing.JCheckBox();
        jLabel55 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        DescriereEmotionalaTextPane = new javax.swing.JTextPane();
        jLabel57 = new javax.swing.JLabel();
        LinkTextField = new javax.swing.JTextField();
        ExecButton = new javax.swing.JButton();
        AdaugaPozaButton = new javax.swing.JButton();
        PanelContainerPoze = new javax.swing.JPanel();
        AdaugaHartaButton = new javax.swing.JButton();
        PozitieLabel = new javax.swing.JLabel();
        PozitieComboBox = new javax.swing.JComboBox<>();
        MetrouCheckBox = new javax.swing.JCheckBox();
        PublicatCheckBox = new javax.swing.JCheckBox();
        StareLabel = new javax.swing.JLabel();
        StareComboBox = new javax.swing.JComboBox<>();
        StatusComboBox = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        WebCheckBox = new javax.swing.JCheckBox();
        LabelCaractere = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        SectorComboBox = new javax.swing.JComboBox<>();
        ReperComboBox = new javax.swing.JComboBox<>();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        InserareMeniu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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
        EchipaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EchipaComboBoxActionPerformed(evt);
            }
        });

        jLabel17.setText("Sector:");

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel18.setText("Pret");

        jLabel19.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel19.setText("Apartamente:");

        Label1.setBackground(new java.awt.Color(255, 255, 51));
        Label1.setForeground(new java.awt.Color(51, 51, 51));
        Label1.setText("Localizare");
        Label1.setOpaque(true);

        StradaLabel.setText("Strada:");

        NrLabel.setText("Nr:");

        ReperLabel.setText("Reper:");

        AdresaCompletaLabel.setText("Adresa completa:");

        jScrollPane5.setViewportView(AdesaCompletaTextPane);

        Label2.setBackground(new java.awt.Color(255, 255, 51));
        Label2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        Label2.setForeground(new java.awt.Color(51, 51, 51));
        Label2.setText("Caracteristici Proprietate");
        Label2.setOpaque(true);

        jLabel24.setText("Nr. Camere:");

        NrCamereComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------", "1", "2", "3", "4", "4+" }));

        jLabel25.setText("Confort:");

        ConfortComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------", "I+", "I", "II+", "II", "III+", "III" }));

        jLabel26.setText("Compartimentare:");

        CompartimentareComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------", "Decomandat", "Semidecomandat", "Circular" }));

        MobilaLabel.setText("Mobila:");

        MobilaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------", "Nemobilat", "Mobilat partial", "Mobilat complet", "Mobilat lux" }));

        jLabel8.setText("Bucatarie");

        BucatarieComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------", "Nemobilata", "Mobilata partial", "Mobilata complet" }));

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(MobilaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                        .addComponent(MobilaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NrCamereComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ConfortComboBox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CompartimentareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel17Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addComponent(BucatarieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(NrCamereComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(ConfortComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(CompartimentareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MobilaLabel)
                    .addComponent(MobilaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(BucatarieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        SuprafataConstruitaLabel.setText("Suprafata construita:");

        SuprafataConstruitaTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SuprafataConstruitaTextFieldActionPerformed(evt);
            }
        });

        jLabel30.setText("mp");

        jLabel31.setText("Nr. Grupuri Sanitare:");

        NrGrupuriSanitareComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));

        AnLabel.setText("An:");

        jLabel35.setText("Etaj:");

        EtajComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0" }));

        jLabel15.setText("Etaje Totale");

        EtajeTotaleComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15" }));
        EtajeTotaleComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EtajeTotaleComboBoxActionPerformed(evt);
            }
        });

        ParterCheckBox.setText("Parter");
        ParterCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ParterCheckBoxActionPerformed(evt);
            }
        });

        UltimulCheckBox.setText("Ultimul Etaj");

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AnLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(SuprafataConstruitaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(20, 20, 20))
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(EtajeTotaleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel35)
                                .addGap(4, 4, 4)))
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NrGrupuriSanitareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel18Layout.createSequentialGroup()
                                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(SuprafataConstruitaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(EtajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addComponent(ParterCheckBox)
                        .addGap(38, 38, 38)
                        .addComponent(UltimulCheckBox)))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel35)
                    .addComponent(EtajComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15)
                    .addComponent(EtajeTotaleComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ParterCheckBox)
                    .addComponent(UltimulCheckBox))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SuprafataConstruitaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuprafataConstruitaLabel)
                    .addComponent(jLabel30))
                .addGap(18, 18, 18)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(NrGrupuriSanitareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AnTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AnLabel))
                .addGap(45, 45, 45))
        );

        jLabel34.setText("Nr. balcoane:");

        NrBalcoaneComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2" }));

        SuprafataUtilaLabel.setText("Suprafata utila:");

        jLabel38.setText("mp");

        FereastraGrupSanitarCheckBox.setBackground(new java.awt.Color(204, 255, 204));
        FereastraGrupSanitarCheckBox.setText("Fereastra Grup Sanitar");
        FereastraGrupSanitarCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FereastraGrupSanitarCheckBoxActionPerformed(evt);
            }
        });

        jLabel39.setText("Garaje:");

        GarajeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));

        jLabel40.setText("Locuri parcare:");

        ParcareComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "0", "1", "2", "3" }));

        ImbunatatiriRealeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------", "NU", "DA" }));

        jLabel33.setText("Imbunatatiri reale:");

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FereastraGrupSanitarCheckBox, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SuprafataUtilaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(SuprafataUtilaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(NrBalcoaneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(GarajeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ParcareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addComponent(ImbunatatiriRealeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(NrBalcoaneComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel34))
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SuprafataUtilaLabel)
                    .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(SuprafataUtilaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel38)))
                .addGap(18, 18, 18)
                .addComponent(FereastraGrupSanitarCheckBox)
                .addGap(18, 18, 18)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(GarajeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(ParcareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ImbunatatiriRealeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        RezidentialCheckBox.setText("Rezidential");

        ComercialCheckBox.setText("Comercial");

        BirouriCheckBox.setText("Birouri");

        VacantaCheckBox.setText("Vacanta");

        jLabel41.setBackground(new java.awt.Color(153, 153, 153));
        jLabel41.setText("Destinatie:");
        jLabel41.setOpaque(true);

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(VacantaCheckBox)
                    .addComponent(BirouriCheckBox)
                    .addComponent(ComercialCheckBox)
                    .addComponent(RezidentialCheckBox))
                .addContainerGap(125, Short.MAX_VALUE))
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel41)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RezidentialCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ComercialCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BirouriCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(VacantaCheckBox)
                .addContainerGap(139, Short.MAX_VALUE))
        );

        jLabel42.setBackground(new java.awt.Color(255, 255, 0));
        jLabel42.setText("Utilitati");
        jLabel42.setOpaque(true);

        jLabel43.setBackground(new java.awt.Color(153, 153, 153));
        jLabel43.setText("Generale");
        jLabel43.setOpaque(true);

        Curent.setText("Curent");
        Curent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CurentActionPerformed(evt);
            }
        });

        Gaz.setText("Gaz");

        Apa.setText("Apa");

        Canalizare.setText("Canalizare");

        CATV.setText("CATV");

        TelefonO.setText("Telefon");

        International.setText("International");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(International)
                    .addComponent(TelefonO)
                    .addComponent(Curent)
                    .addComponent(Canalizare)
                    .addComponent(CATV)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(Gaz)
                        .addComponent(Apa)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Curent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Gaz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Apa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Canalizare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CATV)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TelefonO)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(International)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jLabel44.setBackground(new java.awt.Color(153, 153, 153));
        jLabel44.setText("Sistem Incalzire");
        jLabel44.setOpaque(true);

        CentralaProprie.setText("Centrala proprie");

        CentralaImobil.setText("Centrala imobil");

        Termoficare.setText("Termoficare");

        Soba.setText("Soba");

        Calorifere.setText("Calorifere");

        IncalzirePardoseala.setText("Incalzire Pardoseala");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(IncalzirePardoseala)
                    .addComponent(Calorifere)
                    .addComponent(Soba)
                    .addComponent(Termoficare)
                    .addComponent(CentralaImobil)
                    .addComponent(CentralaProprie))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CentralaProprie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CentralaImobil)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Termoficare)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Soba)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Calorifere)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IncalzirePardoseala)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel45.setBackground(new java.awt.Color(153, 153, 153));
        jLabel45.setText("Acces Internet");
        jLabel45.setOpaque(true);

        Cablu.setText("Cablu");

        FibraOptica.setText("Fibra Optica");

        Wireless.setText("Wireless");

        ADSL.setText("ADSL");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ADSL)
                    .addComponent(Wireless)
                    .addComponent(FibraOptica)
                    .addComponent(Cablu)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel45)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Cablu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(FibraOptica)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Wireless)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ADSL)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel46.setBackground(new java.awt.Color(153, 153, 153));
        jLabel46.setText("Climatizare");
        jLabel46.setOpaque(true);

        jCheckBox24.setText("Aer Conditionat");

        jCheckBox25.setText("Ventiloconvectoare");

        jCheckBox26.setText("Aeroterme");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBox26)
                            .addComponent(jCheckBox25)
                            .addComponent(jCheckBox24))
                        .addGap(0, 97, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jCheckBox24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox26)
                .addContainerGap(76, Short.MAX_VALUE))
        );

        jLabel47.setBackground(new java.awt.Color(255, 255, 0));
        jLabel47.setText("Finisaje");
        jLabel47.setOpaque(true);

        jLabel65.setText("Usi intrare:");

        UsiIntrareComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Metal", "Lemn" }));

        jLabel66.setBackground(new java.awt.Color(153, 153, 153));
        jLabel66.setText("Usi interior");
        jLabel66.setOpaque(true);

        CelulareCheckBox.setText("Celulare");

        LemnCheckBox.setText("Lemn");

        PanelCheckBox.setText("Panel");

        PVCCheckBox.setText("PVC");

        SticlaCheckBox.setText("Sticla");

        javax.swing.GroupLayout jPanel22Layout = new javax.swing.GroupLayout(jPanel22);
        jPanel22.setLayout(jPanel22Layout);
        jPanel22Layout.setHorizontalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel22Layout.createSequentialGroup()
                        .addGroup(jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SticlaCheckBox)
                            .addComponent(PVCCheckBox)
                            .addComponent(PanelCheckBox)
                            .addComponent(LemnCheckBox)
                            .addComponent(CelulareCheckBox))
                        .addGap(0, 75, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel22Layout.setVerticalGroup(
            jPanel22Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel22Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel66)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CelulareCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LemnCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PanelCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PVCCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SticlaCheckBox)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        jLabel67.setBackground(new java.awt.Color(153, 153, 153));
        jLabel67.setText("Podele");
        jLabel67.setOpaque(true);

        Parchet.setText("Parchet");

        Gresie.setText("Gresie");

        Linoleum.setText("Linoleum");

        Mocheta.setText("Mocheta");

        Dusumea.setText("Dusumea");

        Marmura.setText("Marmura");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel67, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Marmura)
                            .addComponent(Dusumea)
                            .addComponent(Mocheta)
                            .addComponent(Linoleum)
                            .addComponent(Gresie)
                            .addComponent(Parchet))
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel67)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Parchet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Gresie)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Linoleum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Mocheta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Dusumea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Marmura)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel68.setBackground(new java.awt.Color(153, 153, 153));
        jLabel68.setText("Pereti");
        jLabel68.setOpaque(true);

        Var.setText("Var");

        Vinarom.setText("Vinarom");

        Lavabila.setText("Lavabila");

        Faianta.setText("Faianta");

        Lambriu.setText("Lambriu");

        Tapet.setText("Tapet");

        Homa.setText("Homa");

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel68, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel23Layout.createSequentialGroup()
                        .addGroup(jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Homa)
                            .addComponent(Tapet)
                            .addComponent(Faianta)
                            .addComponent(Lavabila)
                            .addComponent(Vinarom)
                            .addComponent(Var)
                            .addComponent(Lambriu))
                        .addGap(0, 79, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Var)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Vinarom)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lavabila)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Faianta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lambriu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Tapet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Homa)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel69.setBackground(new java.awt.Color(153, 153, 153));
        jLabel69.setText("Ferestre Termopan");
        jLabel69.setOpaque(true);

        Aluminiu.setText("Aluminiu");

        PVC2.setText("PVC");

        Lemn2.setText("Lemn");

        jLabel70.setBackground(new java.awt.Color(153, 153, 153));
        jLabel70.setText("Izolatii termice");
        jLabel70.setOpaque(true);

        Interior.setText("Interior");

        Exterior.setText("Exterior");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel69, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Exterior)
                            .addComponent(Interior)
                            .addComponent(Lemn2)
                            .addComponent(PVC2)
                            .addComponent(Aluminiu))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel69)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Aluminiu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PVC2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Lemn2)
                .addGap(18, 18, 18)
                .addComponent(jLabel70)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Interior)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exterior)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jLabel48.setBackground(new java.awt.Color(255, 255, 0));
        jLabel48.setText("Dotari");
        jLabel48.setOpaque(true);

        jLabel49.setBackground(new java.awt.Color(153, 153, 153));
        jLabel49.setText("Alte spatii utile");
        jLabel49.setOpaque(true);

        Terasa.setText("Terasa");

        WCServiciu.setText("WC Serviciu");

        Debara.setText("Debara");

        BoxaSubsol.setText("Boxa subsol");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(BoxaSubsol)
                            .addComponent(Debara)
                            .addComponent(WCServiciu)
                            .addComponent(Terasa))
                        .addGap(0, 65, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Terasa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WCServiciu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Debara)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(BoxaSubsol)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel51.setBackground(new java.awt.Color(153, 153, 153));
        jLabel51.setText("Contorizare");
        jLabel51.setOpaque(true);

        Apometre.setText("Apometre");

        ContorGaz.setText("Contor gaz");

        ContoareCaldura.setText("Contoare caldura");

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel51, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ContoareCaldura)
                            .addComponent(ContorGaz)
                            .addComponent(Apometre))
                        .addGap(0, 68, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel51)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Apometre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ContorGaz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ContoareCaldura)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel52.setBackground(new java.awt.Color(153, 153, 153));
        jLabel52.setText("Diverse");
        jLabel52.setOpaque(true);

        Jacuzzi.setText("Jacuzzi");

        SenzorFum.setText("Senzor fum");

        Alarma.setText("Alarma");

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel52, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Alarma)
                            .addComponent(SenzorFum)
                            .addComponent(Jacuzzi))
                        .addGap(0, 98, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel52)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Jacuzzi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SenzorFum)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Alarma)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel53.setBackground(new java.awt.Color(153, 153, 153));
        jLabel53.setText("Electrocasnice");
        jLabel53.setOpaque(true);

        Aragaz.setText("Aragaz");

        CuptorMicrounde.setText("Cuptor microunde");

        Plita.setText("Plita");

        MasinaDeSpalat.setText("Masina de spalat");

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel53, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel13Layout.createSequentialGroup()
                        .addGroup(jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(MasinaDeSpalat)
                            .addComponent(Plita)
                            .addComponent(CuptorMicrounde)
                            .addComponent(Aragaz))
                        .addGap(0, 60, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel13Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel53)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Aragaz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CuptorMicrounde)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Plita)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MasinaDeSpalat)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel54.setBackground(new java.awt.Color(153, 153, 153));
        jLabel54.setText("Dotari/servicii imobil");
        jLabel54.setOpaque(true);

        Lift.setText("Lift");

        Interfon.setText("Interfon");

        Sauna.setText("Sauna");

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel54, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Sauna)
                            .addComponent(Interfon)
                            .addComponent(Lift))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel54)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Lift)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Interfon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Sauna)
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jLabel55.setBackground(new java.awt.Color(255, 255, 0));
        jLabel55.setText("Web");
        jLabel55.setOpaque(true);

        jLabel56.setText("Descriere emotionala:");

        jScrollPane6.setViewportView(DescriereEmotionalaTextPane);

        jLabel57.setText("Link:");

        ExecButton.setText("Salveaza Date");
        ExecButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExecButtonActionPerformed(evt);
            }
        });

        AdaugaPozaButton.setText("Adauga Poza");
        AdaugaPozaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdaugaPozaButtonActionPerformed(evt);
            }
        });

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

        AdaugaHartaButton.setText("Adauga Harta");
        AdaugaHartaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdaugaHartaButtonActionPerformed(evt);
            }
        });

        PozitieLabel.setText("Pozitie");

        PozitieComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-----------------", "Ultracentral", "Central", "Cartier", "Periferie" }));

        MetrouCheckBox.setText("Metrou");

        PublicatCheckBox.setText("Publicat");

        StareLabel.setText("Stare: ");

        StareComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actual", "Incorect", "Vandut" }));

        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "OK", "De revenit", "Nu colaboreaza" }));

        jLabel9.setText("Status");

        WebCheckBox.setText("Web");

        jLabel11.setText("Mai sunt de introdus:");

        jLabel12.setText("de caractere");

        jLabel14.setText("Se introduce \"?\" in cazul in care nu il stim");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Oferta Vanzare Apartament");

        SectorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------------------------------", "Sector 5", "Sector 6" }));
        SectorComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SectorComboBoxActionPerformed(evt);
            }
        });

        ReperComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "---------------", "13Septembrie", "Panduri", "Alexandriei", "Rahova", "Cotroceni", "Sebastian", "Izvor", "Kogalniceanu", "AFI Cotroceni", "Drumul Taberei-Moghioros", "Militari-Gorjului", "Prelungirea Ghencea", "Drumul Taberei-Plazza", "Crangasi", "Militari-Lujerului", "Crangasi-Metrou", "Militarii Pacii", "Ghencea", "Drumul Taberei-Romancierilor", "Drumul Taberei-Bucla", "Drumul Taberei-Favorit", "Grozavesti", "Militari Rosu" }));
        ReperComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReperComboBoxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(151, 151, 151)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Label2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(99, 99, 99)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(91, 91, 91)
                                                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(85, 85, 85)
                                                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel55, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(3, 3, 3)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel57, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(PublicatCheckBox)
                                            .addComponent(WebCheckBox)
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(LabelCaractere, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(18, 18, 18)))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(50, 50, 50)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(LinkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 771, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(280, 280, 280)
                                                .addComponent(jLabel9)
                                                .addGap(54, 54, 54)
                                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(UsiIntrareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jLabel65, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(87, 87, 87)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(101, 101, 101)
                                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(63, 63, 63)
                                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(77, 77, 77)
                                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel47, javax.swing.GroupLayout.PREFERRED_SIZE, 1568, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 694, Short.MAX_VALUE)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
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
                                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(EchipaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(174, 174, 174)
                                                .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(SectorComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(90, 90, 90)
                                        .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(62, 62, 62)
                                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(Label1, javax.swing.GroupLayout.PREFERRED_SIZE, 1207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(StradaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NrLabel)
                                            .addComponent(ReperLabel)
                                            .addComponent(PozitieLabel, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(179, 179, 179)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(StradaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(NrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(ReperComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(152, 152, 152)
                                                .addComponent(AdresaCompletaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(54, 54, 54)
                                                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(PozitieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(MetrouCheckBox)))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(316, 316, 316)
                                .addComponent(StareLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(StareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AdaugaPozaButton)
                                .addGap(36, 36, 36)
                                .addComponent(PanelContainerPoze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(AdaugaHartaButton)))
                        .addGap(365, 365, 365)
                        .addComponent(ExecButton, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
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
                    .addComponent(jLabel14))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExclusivitateCheckBox)
                    .addComponent(NegociabilCheckBox))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(ObservatiiPretLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jLabel13)
                .addGap(59, 59, 59)
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
                .addGap(41, 41, 41)
                .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label1)
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StradaLabel)
                    .addComponent(StradaTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(NrLabel)
                                    .addComponent(NrTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(ReperLabel)
                                    .addComponent(ReperComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(28, 28, 28))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(AdresaCompletaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(25, 25, 25)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PozitieLabel)
                            .addComponent(PozitieComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(MetrouCheckBox)
                        .addGap(38, 38, 38)
                        .addComponent(Label2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 103, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel47)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(31, 31, 31)
                                                .addComponent(jLabel65)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(UsiIntrareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jPanel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(jPanel23, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(47, 47, 47)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(26, 26, 26)
                        .addComponent(jLabel48)
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
                        .addComponent(jLabel55)
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel56, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                                    .addComponent(LabelCaractere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(3, 3, 3))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LinkTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PublicatCheckBox)
                            .addComponent(StareLabel)
                            .addComponent(StareComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(93, 93, 93)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(AdaugaPozaButton)
                                        .addGap(126, 126, 126))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(AdaugaHartaButton)
                                            .addComponent(ExecButton))
                                        .addGap(134, 134, 134))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addComponent(WebCheckBox)
                                .addGap(18, 18, 18)
                                .addComponent(PanelContainerPoze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1900, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 26, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 2953, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExclusivitateCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExclusivitateCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ExclusivitateCheckBoxActionPerformed

    private void NegociabilCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NegociabilCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NegociabilCheckBoxActionPerformed

    private void SuprafataConstruitaTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SuprafataConstruitaTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SuprafataConstruitaTextFieldActionPerformed

    private void EtajeTotaleComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EtajeTotaleComboBoxActionPerformed
        int max;
        EtajComboBox.removeAllItems();
        if (EtajeTotaleComboBox.getSelectedIndex()>=0){
            max=Integer.parseInt(EtajeTotaleComboBox.getSelectedItem().toString());
            for (int i=0;i<=max;i++){
                //String au=new String(Integer.toString(i));
                EtajComboBox.addItem(Integer.toString(i));
            }
        }
        // EtajComboBox.removeAllItems();
    }//GEN-LAST:event_EtajeTotaleComboBoxActionPerformed

    private void ParterCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ParterCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ParterCheckBoxActionPerformed

    private void FereastraGrupSanitarCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FereastraGrupSanitarCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_FereastraGrupSanitarCheckBoxActionPerformed

    private void CurentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CurentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CurentActionPerformed

    private void AdaugaPozaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdaugaPozaButtonActionPerformed
       PanelContainerPoze.removeAll();

        JFileChooser fileChooser = new JFileChooser();

        // show open file dialog
        int result = fileChooser.showOpenDialog( null );

        if ( result == JFileChooser.APPROVE_OPTION ) // user chose a file
        {
            URI mediaURL = null;

            // get the file as URL
            mediaURL = fileChooser.getSelectedFile().toURI();
            try{
                BufferedImage img=ImageIO.read(new File(mediaURL.getPath()));
                //ImageIcon icon=new ImageIcon(img);
                ListaPoze.add(img);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            JPanel panel = new JPanel();
            panel.invalidate();
            for (int i = 0; i <ListaPoze.size(); i++) {
                JButton btn = new JButton();
                // BufferedImage img=new BufferedImage(ListaPoze.get(i));
                ImageIcon img=new ImageIcon(resize(ListaPoze.get(i),100,100));
                btn.setIcon(img);
                btn.setPreferredSize(new Dimension(100,100));
                btn.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        ParcurgereImagine img=new ParcurgereImagine(ListaPoze);
                        img.setVisible(true);

                    }
                });

                panel.add(btn);

            }

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(0, 0, 300, 150);
            //JPanel contentPane = new JPanel(null);

            //contentPane.setPreferredSize(new Dimension(500, 400));
            PanelContainerPoze.add(scrollPane);

        }
    }//GEN-LAST:event_AdaugaPozaButtonActionPerformed

    private void AdaugaHartaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdaugaHartaButtonActionPerformed
        try{
            adresa="Strada."+StradaTextField.getText()+",Nr."+NrTextField.getText();
            System.out.println(AdesaCompletaTextPane.getText());
            Harta h=new Harta(adresa);
            h.setVisible(true);

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_AdaugaHartaButtonActionPerformed

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

    private void ExecButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExecButtonActionPerformed
        if(DescriereEmotionalaTextPane.getText().length()>=100){
            if (introducere_pret()==true&&introducere_ProprietateGeneral()==true&&
               introducere_ApartamenteLocalizare()==true&&introducere_CaracteristiciProprietate()==true
                    &&introducere_Finisaje()==true&&introducere_Link()==true&&introducereGenerale()==true&&introducereDotari()==true){
               if(!modifica){
                interogare_insert_apartament_vanzare();
                MeniuInserare m=new MeniuInserare();
                m.setVisible(true);
                this.setVisible(false);
                }
                else{
                    updateOVA();
                    this.setVisible(false);
                }
                JOptionPane.showMessageDialog(OVA.this,"Datele au fost salvate cu succes","Success Message",JOptionPane.INFORMATION_MESSAGE);
               
            }else{
                JOptionPane.showMessageDialog(OVA.this,"Va rugam sa completati toate detaliile in mod corect","Error Message",JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            JOptionPane.showMessageDialog(OVA.this,"Va rugam sa introduceti minim 100 de caractere in descrierea emotionala!","Error Message",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_ExecButtonActionPerformed

    private void SectorComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SectorComboBoxActionPerformed
        if (SectorComboBox.getSelectedIndex()==0){
            ReperComboBox.removeAllItems();
            ReperComboBox.addItem("---------------");
            ReperComboBox.addItem("13Septembrie");
            ReperComboBox.addItem("Panduri");
            ReperComboBox.addItem("Alexandriei");
            ReperComboBox.addItem("Rahova");
            ReperComboBox.addItem("Cotroceni");
            ReperComboBox.addItem("Sebastian");
            ReperComboBox.addItem("Izvor");
            ReperComboBox.addItem("Kogalniceanu");
            ReperComboBox.addItem("AFI Cotroceni");
            ReperComboBox.addItem("Drumul Taberei-Moghioros");
            ReperComboBox.addItem("Militari-Gorjului");
            ReperComboBox.addItem("Prelungirea Ghencea");
            ReperComboBox.addItem("Drumul Taberei-Plazza");
            ReperComboBox.addItem("Crangasi");
            ReperComboBox.addItem("Militari-Lujerului");
            ReperComboBox.addItem("Crangasi-Metrou");
            ReperComboBox.addItem("Militarii Pacii");
            ReperComboBox.addItem("Ghencea");
            ReperComboBox.addItem("Drumul Taberei-Romancierilor");
            ReperComboBox.addItem("Drumul Taberei-Bucla");
            ReperComboBox.addItem("Drumul Taberei-Favorit");
            ReperComboBox.addItem("Grozavesti");
            ReperComboBox.addItem("Militari Rosu");
        }

        if (SectorComboBox.getSelectedIndex()==1){
            ReperComboBox.removeAllItems();
            ReperComboBox.addItem("---------------");
            ReperComboBox.addItem("13Septembrie");
            ReperComboBox.addItem("Panduri");
            ReperComboBox.addItem("Alexandriei");
            ReperComboBox.addItem("Rahova");
            ReperComboBox.addItem("Cotroceni");
            ReperComboBox.addItem("Sebastian");
            ReperComboBox.addItem("Izvor");
            ReperComboBox.addItem("Kogalniceanu");

        }
        if (SectorComboBox.getSelectedIndex()==2){
            ReperComboBox.removeAllItems();
            ReperComboBox.addItem("---------------");
            ReperComboBox.addItem("AFI Cotroceni");
            ReperComboBox.addItem("Drumul Taberei-Moghioros");
            ReperComboBox.addItem("Militari-Gorjului");
            ReperComboBox.addItem("Prelungirea Ghencea");
            ReperComboBox.addItem("Drumul Taberei-Plazza");
            ReperComboBox.addItem("Crangasi");
            ReperComboBox.addItem("Militari-Lujerului");
            ReperComboBox.addItem("Crangasi-Metrou");
            ReperComboBox.addItem("Militarii Pacii");
            ReperComboBox.addItem("Ghencea");
            ReperComboBox.addItem("Drumul Taberei-Romancierilor");
            ReperComboBox.addItem("Drumul Taberei-Bucla");
            ReperComboBox.addItem("Drumul Taberei-Favorit");
            ReperComboBox.addItem("Grozavesti");
            ReperComboBox.addItem("Militari Rosu");
        }

    }//GEN-LAST:event_SectorComboBoxActionPerformed

    private void ReperComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReperComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReperComboBoxActionPerformed

    private void EchipaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EchipaComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_EchipaComboBoxActionPerformed

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
            java.util.logging.Logger.getLogger(OVA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OVA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OVA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OVA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OVA().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox ADSL;
    private javax.swing.JButton AdaugaHartaButton;
    private javax.swing.JButton AdaugaPozaButton;
    private javax.swing.JTextPane AdesaCompletaTextPane;
    private javax.swing.JLabel AdresaCompletaLabel;
    private javax.swing.JCheckBox Alarma;
    private javax.swing.JLabel AlteDetaliiConfidentialeLabel;
    private javax.swing.JTextPane AlteDetaliiConfidentialeTextPane;
    private javax.swing.JCheckBox Aluminiu;
    private javax.swing.JLabel AnLabel;
    private javax.swing.JTextField AnTextField;
    private javax.swing.JCheckBox Apa;
    private javax.swing.JCheckBox Apometre;
    private javax.swing.JCheckBox Aragaz;
    private javax.swing.JCheckBox BirouriCheckBox;
    private javax.swing.JCheckBox BoxaSubsol;
    private javax.swing.JComboBox<String> BucatarieComboBox;
    private javax.swing.JCheckBox CATV;
    private javax.swing.JCheckBox Cablu;
    private javax.swing.JCheckBox Calorifere;
    private javax.swing.JCheckBox Canalizare;
    private javax.swing.JCheckBox CelulareCheckBox;
    private javax.swing.JCheckBox CentralaImobil;
    private javax.swing.JCheckBox CentralaProprie;
    private javax.swing.JCheckBox ComercialCheckBox;
    private javax.swing.JLabel ComisionLabel;
    private javax.swing.JTextField ComisionTextField;
    private javax.swing.JComboBox<String> CompartimentareComboBox;
    private javax.swing.JComboBox<String> ConfortComboBox;
    private javax.swing.JCheckBox ContoareCaldura;
    private javax.swing.JCheckBox ContorGaz;
    private javax.swing.JCheckBox CuptorMicrounde;
    private javax.swing.JCheckBox Curent;
    private javax.swing.JCheckBox Debara;
    private javax.swing.JTextPane DescriereEmotionalaTextPane;
    private javax.swing.JCheckBox Dusumea;
    private javax.swing.JComboBox<String> EchipaComboBox;
    private javax.swing.JComboBox<String> EtajComboBox;
    private javax.swing.JComboBox<String> EtajeTotaleComboBox;
    private javax.swing.JCheckBox ExclusivitateCheckBox;
    private javax.swing.JButton ExecButton;
    private javax.swing.JCheckBox Exterior;
    private javax.swing.JCheckBox Faianta;
    private javax.swing.JCheckBox FereastraGrupSanitarCheckBox;
    private javax.swing.JCheckBox FibraOptica;
    private javax.swing.JComboBox<String> GarajeComboBox;
    private javax.swing.JCheckBox Gaz;
    private javax.swing.JCheckBox Gresie;
    private javax.swing.JCheckBox Homa;
    private javax.swing.JComboBox<String> ImbunatatiriRealeComboBox;
    private javax.swing.JCheckBox IncalzirePardoseala;
    private javax.swing.JMenu InserareMeniu;
    private javax.swing.JCheckBox Interfon;
    private javax.swing.JCheckBox Interior;
    private javax.swing.JCheckBox International;
    private javax.swing.JCheckBox Jacuzzi;
    private javax.swing.JLabel Label1;
    private javax.swing.JLabel Label2;
    private javax.swing.JLabel LabelCaractere;
    private javax.swing.JCheckBox Lambriu;
    private javax.swing.JCheckBox Lavabila;
    private javax.swing.JCheckBox Lemn2;
    private javax.swing.JCheckBox LemnCheckBox;
    private javax.swing.JCheckBox Lift;
    private javax.swing.JTextField LinkTextField;
    private javax.swing.JCheckBox Linoleum;
    private javax.swing.JCheckBox Marmura;
    private javax.swing.JCheckBox MasinaDeSpalat;
    private javax.swing.JCheckBox MetrouCheckBox;
    private javax.swing.JComboBox<String> MobilaComboBox;
    private javax.swing.JLabel MobilaLabel;
    private javax.swing.JCheckBox Mocheta;
    private javax.swing.JCheckBox NegociabilCheckBox;
    private javax.swing.JComboBox<String> NrBalcoaneComboBox;
    private javax.swing.JComboBox<String> NrCamereComboBox;
    private javax.swing.JComboBox<String> NrGrupuriSanitareComboBox;
    private javax.swing.JLabel NrLabel;
    private javax.swing.JTextField NrTextField;
    private javax.swing.JLabel ObservatiiPretLabel;
    private javax.swing.JTextPane Observatii_PretTextPane;
    private javax.swing.JCheckBox PVC2;
    private javax.swing.JCheckBox PVCCheckBox;
    private javax.swing.JCheckBox PanelCheckBox;
    private javax.swing.JPanel PanelContainerPoze;
    private javax.swing.JComboBox<String> ParcareComboBox;
    private javax.swing.JCheckBox Parchet;
    private javax.swing.JCheckBox ParterCheckBox;
    private javax.swing.JCheckBox Plita;
    private javax.swing.JComboBox<String> PozitieComboBox;
    private javax.swing.JLabel PozitieLabel;
    private javax.swing.JLabel PretLabel;
    private javax.swing.JTextField PretTextField;
    private javax.swing.JCheckBox PublicatCheckBox;
    private javax.swing.JComboBox<String> ReperComboBox;
    private javax.swing.JLabel ReperLabel;
    private javax.swing.JCheckBox RezidentialCheckBox;
    private javax.swing.JCheckBox Sauna;
    private javax.swing.JComboBox<String> SectorComboBox;
    private javax.swing.JCheckBox SenzorFum;
    private javax.swing.JCheckBox Soba;
    private javax.swing.JComboBox<String> StareComboBox;
    private javax.swing.JLabel StareLabel;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JCheckBox SticlaCheckBox;
    private javax.swing.JLabel StradaLabel;
    private javax.swing.JTextField StradaTextField;
    private javax.swing.JLabel SuprafataConstruitaLabel;
    private javax.swing.JTextField SuprafataConstruitaTextField;
    private javax.swing.JLabel SuprafataUtilaLabel;
    private javax.swing.JTextField SuprafataUtilaTextField;
    private javax.swing.JCheckBox Tapet;
    private javax.swing.JCheckBox TelefonO;
    private javax.swing.JCheckBox Terasa;
    private javax.swing.JCheckBox Termoficare;
    private javax.swing.JCheckBox UltimulCheckBox;
    private javax.swing.JComboBox<String> UsiIntrareComboBox;
    private javax.swing.JCheckBox VacantaCheckBox;
    private javax.swing.JCheckBox Var;
    private javax.swing.JCheckBox Vinarom;
    private javax.swing.JCheckBox WCServiciu;
    private javax.swing.JCheckBox WebCheckBox;
    private javax.swing.JCheckBox Wireless;
    private javax.swing.JCheckBox jCheckBox24;
    private javax.swing.JCheckBox jCheckBox25;
    private javax.swing.JCheckBox jCheckBox26;
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
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    // End of variables declaration//GEN-END:variables
 public void search() {
       // hilit.removeAllHighlights();
         
        String s = DescriereEmotionalaTextPane.getText();
        if(s.length()<=100){
        Integer i=100-s.length();
        String text;
        text=i.toString();
        LabelCaractere.setText(text);
        }
        else
        {
          LabelCaractere.setText("0");  
        }
        
    }
    @Override
    public void insertUpdate(DocumentEvent e) {
        search();
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        search();
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        search();
    }
}
