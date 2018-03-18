/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
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
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.table.AbstractTableModel;
import static login.detaliiOVA.ListaPoze;
import static login.detaliiOVA.byteArrayToImage;
import static login.detaliiOVA.resize;


/**
 *
 * @author Serdin
 */
public class detaliiOIA extends javax.swing.JFrame {

     static int p=0;
   static int parametru;// reprezinta OVA-ul
    int nr=0;//pentru butonul detalii
     static  ArrayList<BufferedImage> ListaPoze=new ArrayList<BufferedImage>();
     int imagine=0;
     static boolean modificari=false;
      int pretVechi;
    public detaliiOIA(int OIA) {
        
        initComponents();
        ListaPoze.clear();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
        jScrollPane2.getVerticalScrollBar().setUnitIncrement(16);
        Comentarii.setVisible(false);
        WebCheckBox.setEnabled(false);
        this.parametru=OIA;
        functie(OIA);
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

    public void functie(int OIA){
        
        java.sql.Statement stmt = null;
        DescriereEmotionala.setEnabled(false);
                try {
        //DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        Class.forName("com.mysql.jdbc.Driver");

       Connection conn = DriverManager.getConnection(
        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
       // System.out.println("db connected");
        stmt = (java.sql.Statement) conn.createStatement();

        ResultSet rs1;
       
        
       rs1 = stmt.executeQuery("select Agent,Status,Strada,Pret,Poza,Harta,DescriereEmotionala,Camere,Confort,Compartimentare,Etaj,EtajeTotale,"
               + "SuprafataConstruita,NumarGrupuriSanitare,AnConstructie,ImbunatatiriReale,NumarBalcoane,"
               + "SuprafataUtila,FereastraGrupSanitar,NumarGaraje,LocuriParcare,Rezidential,Comercial,Birouri,Vacanta,"
               + "Reper,UsiIntrare,Celulare,Lemn,Panel,PVC,Sticla,AdresaCompleta,Status,"
              +" UsiIntrare,Imagine,"
                    + "Celulare,Lemn,Panel,PVC,Sticla,"
                    + "Curent,Gaz,Apa,Canalizare,Catv,TelefonO,International,CentralaProprie,"
                    + "CentralaImobil,Termoficare,Soba,Calorifere,IncalzirePardoseala,Cablu,"
                    + "FibraOptica,Wireless,Adsl,Parchet,Gresie,Linoleum,Mocheta,Dusumea,Marmura,"
                    + "Var,Vinarom,Lavabila,Faianta,Lambriu,Tapet,Homa,Aluminiu,Pvc2,Lemn2,Interior,"
                    + "Exterior,Terasa,WCServiciu,Debara,BoxaSubsol,Apometre,ContorGaz,ContoareCaldura,"
                    + "Jacuzzi,SenzorFum,Alarma,Aragaz,CuptorMicrounde,Plita,MasinaDeSpalat,Lift,Interfon,"
                    + "Sauna"
               + " from aptinchiriere where OIA Like "+OIA+"");
       while(rs1.next()){
           
           //pentru poze
            //pentru harta
            byte[] imgData2 = rs1.getBytes("Harta");//Here r1.getBytes() extract byte data from resultSet 
             
              File file2 = new File("image2.jpg");
           
             BufferedImage image2 = byteArrayToImage(imgData2);
             ImageIcon img2=new ImageIcon(resize(image2,500,400));
             jLabel1.setIcon(img2);
             //pentru Detalii
             String Agent="";
             Agent=rs1.getString("Agent");
             String Status="";
             Status=rs1.getString("Status");
             Detalii.setText("OIA "+OIA+" - Agent: "+Agent+" - Status: "+Status);
             String Strada="";
             Strada=rs1.getString("Strada");
             int Pret=0;
             Pret=rs1.getInt("Pret");
             pretVechi=Pret;
             StradaPret.setText("Str."+Strada+" - Pret: "+Pret);
           /*String d=rs1.getString("DescriereEmotionala");
           StringBuffer desc=new StringBuffer(d);
           int c=75;
           for (int i=0;i<desc.length();i++){
               if(i==c)
               {desc.insert(i, "\n");
               i=i+2;
               c=c+75;
               }
           }*/
          
            DescriereEmotionala.setLineWrap(true);
            DescriereEmotionala.setWrapStyleWord(true);
           
           DescriereEmotionala.setText(rs1.getString("DescriereEmotionala"));
           imagine=rs1.getInt("Imagine");
           
           NrCamere.setText(rs1.getString("Camere"));
           Confort.setText(rs1.getString("Confort"));
           Compartimentare.setText(rs1.getString("Compartimentare"));
           Etaj.setText(rs1.getString("Etaj"));
           EtajeTotale.setText(rs1.getString("EtajeTotale"));
           SuprafataConstruita.setText(rs1.getString("SuprafataConstruita"));
           NrGrupuriSanitare.setText(rs1.getString("NumarGrupuriSanitare"));
           An.setText(rs1.getString("AnConstructie"));
           ImbunatatiriReale.setText(rs1.getString("ImbunatatiriReale"));
           NrBalcoane.setText(rs1.getString("NumarBalcoane"));
           SuprafataUtila.setText(rs1.getString("SuprafataUtila"));
           FereastraGrupSanitar.setText(rs1.getString("FereastraGrupSanitar"));
           Garaje.setText(rs1.getString("NumarGaraje"));
           LocuriParcare.setText(rs1.getString("LocuriParcare"));
           String dest="";
           if (rs1.getInt("Rezidential")==1){
               dest=dest+"Rezidential,";
           }
           if (rs1.getInt("Comercial")==1){
               dest=dest+"Comercial,";
           }
           if (rs1.getInt("Birouri")==1){
               dest=dest+"Birouri,";
           }
           if (rs1.getInt("Vacanta")==1){
               dest=dest+"Vacanta";
           }
           Destinatie.setText(dest);
           Reper.setText(rs1.getString("Reper"));
           String finisaje="";
           finisaje=finisaje+"Usi intrare: "+rs1.getString("UsiIntrare");
           finisaje=finisaje+" Usi interior: ";
           if (rs1.getInt("Celulare")==1){
               finisaje=finisaje+"Celulare,";
           }
           if (rs1.getInt("Lemn")==1){
               finisaje=finisaje+"Lemn,";
           }
           if (rs1.getInt("Panel")==1){
               finisaje=finisaje+"Panel,";
           }
           if (rs1.getInt("PVC")==1){
               finisaje=finisaje+"PVC,";
           }
           if (rs1.getInt("Sticla")==1){
               finisaje=finisaje+"Sticla,";
           }
           finisaje=finisaje+" Parchet: ";
           if (rs1.getInt("Parchet")==1){
               finisaje=finisaje+"Parchet,";
           }
           if (rs1.getInt("Gresie")==1){
               finisaje=finisaje+"Gresie,";
           }
           if (rs1.getInt("Linoleum")==1){
               finisaje=finisaje+"Linoleum,";
           }
           if (rs1.getInt("Mocheta")==1){
               finisaje=finisaje+"Mocheta,";
           }
           if (rs1.getInt("Dusumea")==1){
               finisaje=finisaje+"Dusumea,";
           }
           if (rs1.getInt("Marmura")==1){
               finisaje=finisaje+"Marmura,";
           }
           finisaje=finisaje+" Pereti: ";
           if (rs1.getInt("Var")==1){
               finisaje=finisaje+"Var,";
           }
           if (rs1.getInt("Vinarom")==1){
               finisaje=finisaje+"Vinarom,";
           }
           if (rs1.getInt("Lavabila")==1){
               finisaje=finisaje+"Lavabila,";
           }
           if (rs1.getInt("Faianta")==1){
               finisaje=finisaje+"Faianta,";
           }
           if (rs1.getInt("Lambriu")==1){
               finisaje=finisaje+"Lambriu,";
           }
           if (rs1.getInt("Tapet")==1){
               finisaje=finisaje+"Tapet,";
           }
           if (rs1.getInt("Homa")==1){
               finisaje=finisaje+"Homa,";
           }
           finisaje=finisaje+" Ferestre Termopan: ";
           if (rs1.getInt("Aluminiu")==1){
               finisaje=finisaje+"Aluminiu,";
           }
           if (rs1.getInt("Pvc2")==1){
               finisaje=finisaje+"PVC,";
           }
           if (rs1.getInt("Lemn2")==1){
               finisaje=finisaje+"Lemn,";
           }
           finisaje=finisaje+" Izolatii Termice: ";
           if (rs1.getInt("Interior")==1){
               finisaje=finisaje+"Interior,";
           }
           if (rs1.getInt("Exterior")==1){
               finisaje=finisaje+"Exterior,";
           }
           Finisaje.setText(finisaje);
           //Utilitati
           String generale="";
           if (rs1.getInt("Curent")==1){
               generale=generale+"Curent,";
           }
           if (rs1.getInt("Gaz")==1){
               generale=generale+"Gaz,";
           }
           if (rs1.getInt("Apa")==1){
               generale=generale+"Apa,";
           }
           if (rs1.getInt("Canalizare")==1){
               generale=generale+"Canalizare,";
           }
           if (rs1.getInt("Catv")==1){
               generale=generale+"CATV,";
           }
           if (rs1.getInt("TelefonO")==1){
               generale=generale+"Telefon,";
           }
           if (rs1.getInt("International")==1){
               generale=generale+"International,";
           }
           generale=generale+" Sistem Incalzire: ";
           if (rs1.getInt("CentralaProprie")==1){
               generale=generale+"Centrala Proprie,";
           }
           if (rs1.getInt("CentralaImobil")==1){
               generale=generale+"CentralaImobil,";
           }
           if (rs1.getInt("Termoficare")==1){
               generale=generale+"Termoficare,";
           }
           if (rs1.getInt("Soba")==1){
               generale=generale+"Soba,";
           }
           if (rs1.getInt("Calorifere")==1){
               generale=generale+"Calorifere,";
           }
           if (rs1.getInt("IncalzirePardoseala")==1){
               generale=generale+"Incalzire Pardoseala,";
           }
           generale=generale+" Acces Internet: ";
           if (rs1.getInt("Cablu")==1){
               generale=generale+"Cablu,";
           }
           if (rs1.getInt("FibraOptica")==1){
               generale=generale+"Fibra Optica,";
           }
           if (rs1.getInt("Wireless")==1){
               generale=generale+"Wireless,";
           }
           if (rs1.getInt("Adsl")==1){
               generale=generale+"ADSL,";
           }
           Utilitati.setText(generale);
           String dotari="";
           dotari=dotari+" Spatii Utile: ";
           if (rs1.getInt("Terasa")==1){
               dotari=dotari+"Terasa,";
           }
           if (rs1.getInt("WCServiciu")==1){
               dotari=dotari+"WCServiciu,";
           }
           if (rs1.getInt("Debara")==1){
               dotari=dotari+"Debara,";
           }
           if (rs1.getInt("BoxaSubsol")==1){
               dotari=dotari+"Boxa Subsol,";
           }
           dotari=dotari+" Contorizare: ";
           if (rs1.getInt("Apometre")==1){
               dotari=dotari+"Apometre,";
           }
           if (rs1.getInt("ContorGaz")==1){
               dotari=dotari+"Contor Gaz,";
           }
           if (rs1.getInt("ContoareCaldura")==1){
               dotari=dotari+"Contoare Caldura,";
           }
           dotari=dotari+" Diverse: ";
           if (rs1.getInt("Jacuzzi")==1){
               dotari=dotari+"Jacuzzi,";
           }
           if (rs1.getInt("SenzorFum")==1){
               dotari=dotari+"SenzorFum,";
           }
           if (rs1.getInt("Alarma")==1){
               dotari=dotari+"Alarma,";
           }
           dotari=dotari+" Electrocasnice: ";
           if (rs1.getInt("Aragaz")==1){
               dotari=dotari+"Aragaz,";
           }
           if (rs1.getInt("CuptorMicrounde")==1){
               dotari=dotari+"Cuptor Microunde,";
           }
           if (rs1.getInt("Plita")==1){
               dotari=dotari+"Plita,";
           }
           if (rs1.getInt("MasinaDeSpalat")==1){
               dotari=dotari+"Masina de Spalat,";
           }
           dotari=dotari+" Servicii imobil: ";
           if (rs1.getInt("Lift")==1){
               dotari=dotari+"Lift,";
           }
           if (rs1.getInt("Interfon")==1){
               dotari=dotari+"Interfon,";
           }
           if (rs1.getInt("Sauna")==1){
               dotari=dotari+"Sauna,";
           }
           
           
           Dotari.setText(dotari);
          
           
           
       }
       if(imagine==1){
           ResultSet rs2;
       
        
       rs2 = stmt.executeQuery("select Poza from pozeia where OIA="+OIA+"");
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

                }
       catch(Exception e){
                    e.printStackTrace();
                }
                
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        PanelContainerPoze = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        NrCamere = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Confort = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Compartimentare = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Etaj = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        SuprafataConstruita = new javax.swing.JLabel();
        NrGrupuriSanitare = new javax.swing.JLabel();
        An = new javax.swing.JLabel();
        ImbunatatiriReale = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        NrBalcoane = new javax.swing.JLabel();
        SuprafataUtila = new javax.swing.JLabel();
        FereastraGrupSanitar = new javax.swing.JLabel();
        Garaje = new javax.swing.JLabel();
        LocuriParcare = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        Destinatie = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        Reper = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        Detalii = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        EtajeTotale = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        StradaPret = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DescriereEmotionala = new javax.swing.JTextArea();
        Comentarii = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        AdresaCompleta = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        Proprietar = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        ObservatiiClient = new javax.swing.JLabel();
        ComentariiTextField = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        ComentariiTable = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        StatusImport = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        Telefon = new javax.swing.JLabel();
        WebCheckBox = new javax.swing.JCheckBox();
        jLabel22 = new javax.swing.JLabel();
        PretNouTextField = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        Agent = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        Comision = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Suprafata = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        StareNouaComboBox = new javax.swing.JComboBox<>();
        jLabel34 = new javax.swing.JLabel();
        ModificaButton = new javax.swing.JButton();
        DetaliiButton = new javax.swing.JButton();
        Finisaje = new javax.swing.JLabel();
        Utilitati = new javax.swing.JLabel();
        Dotari = new javax.swing.JLabel();
        AdaugaPoza = new javax.swing.JButton();
        ModificaDetalii = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout PanelContainerPozeLayout = new javax.swing.GroupLayout(PanelContainerPoze);
        PanelContainerPoze.setLayout(PanelContainerPozeLayout);
        PanelContainerPozeLayout.setHorizontalGroup(
            PanelContainerPozeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        PanelContainerPozeLayout.setVerticalGroup(
            PanelContainerPozeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 126, Short.MAX_VALUE)
        );

        jLabel3.setBackground(new java.awt.Color(255, 255, 102));
        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Link extern proprietare: ");
        jLabel3.setOpaque(true);

        jLabel4.setBackground(new java.awt.Color(255, 255, 102));
        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Caracteristici proprietate");
        jLabel4.setOpaque(true);

        jLabel5.setText("Nr. camere: ");

        NrCamere.setText("jLabel6");
        NrCamere.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                NrCamereComponentAdded(evt);
            }
        });

        jLabel7.setText("Confort:");

        Confort.setText("jLabel8");

        jLabel9.setText("Compartimentare:");

        Compartimentare.setText("jLabel10");

        jLabel11.setText("Etaj:");

        Etaj.setText("jLabel12");

        jLabel16.setText("Suprafata construita:");

        jLabel17.setText("Nr. grupuri sanitare:");

        jLabel18.setText("An:");

        jLabel19.setText("Imbunatatiri reale?");

        SuprafataConstruita.setText("jLabel21");

        NrGrupuriSanitare.setText("jLabel22");

        An.setText("jLabel23");

        ImbunatatiriReale.setText("jLabel24");

        jLabel25.setText("Nr. balcoane:");

        jLabel26.setText("Suprafata utila:");

        jLabel27.setText("Fereastra GS:");

        jLabel28.setText("Garaje:");

        jLabel29.setText("Locuri parcare:");

        NrBalcoane.setText("jLabel30");

        SuprafataUtila.setText("jLabel31");

        FereastraGrupSanitar.setText("jLabel32");

        Garaje.setText("jLabel33");

        LocuriParcare.setText("jLabel34");

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel35.setText("    Destinatie");

        Destinatie.setText("jLabel36");

        jLabel37.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel37.setText("        Reper");

        Reper.setText("jLabel38");

        jLabel39.setBackground(new java.awt.Color(255, 255, 102));
        jLabel39.setText("Finisaje:");
        jLabel39.setOpaque(true);

        jLabel40.setBackground(new java.awt.Color(255, 255, 102));
        jLabel40.setText("Dotari");
        jLabel40.setOpaque(true);

        jLabel41.setBackground(new java.awt.Color(255, 255, 102));
        jLabel41.setText("Utilitati");
        jLabel41.setOpaque(true);

        Detalii.setBackground(new java.awt.Color(255, 255, 102));
        Detalii.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Detalii.setText("Detalii");
        Detalii.setOpaque(true);

        jLabel6.setText("din");

        EtajeTotale.setText("jLabel8");

        jLabel8.setBackground(new java.awt.Color(255, 255, 102));
        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel8.setText("Descriere Emotionala");
        jLabel8.setOpaque(true);

        StradaPret.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        StradaPret.setText("StradaPret");

        DescriereEmotionala.setColumns(20);
        DescriereEmotionala.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        DescriereEmotionala.setForeground(new java.awt.Color(255, 255, 255));
        DescriereEmotionala.setRows(5);
        DescriereEmotionala.setDisabledTextColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(DescriereEmotionala);

        jLabel12.setText("Adresa Completa:");

        AdresaCompleta.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        AdresaCompleta.setText("jLabel13");

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

        jLabel15.setText("Status import");

        StatusImport.setText("jLabel20");

        jLabel20.setText("Telefon:");

        Telefon.setForeground(new java.awt.Color(102, 0, 255));
        Telefon.setText("jLabel21");

        WebCheckBox.setText("Web");

        jLabel22.setText("Pret nou:");

        jLabel23.setText("Agent:");

        Agent.setText("jLabel24");

        jLabel24.setText("Comision(%):");

        Comision.setText("jLabel30");

        jLabel31.setText("Suprafata:");

        Suprafata.setText("jLabel32");

        jLabel33.setText("Stare noua:");

        StareNouaComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Actual", "Incorect", "Vandut" }));
        StareNouaComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StareNouaComboBoxActionPerformed(evt);
            }
        });

        jLabel34.setBackground(new java.awt.Color(255, 255, 0));
        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel34.setText("Comentarii");
        jLabel34.setOpaque(true);

        ModificaButton.setText("Modifica");
        ModificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ComentariiLayout = new javax.swing.GroupLayout(Comentarii);
        Comentarii.setLayout(ComentariiLayout);
        ComentariiLayout.setHorizontalGroup(
            ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComentariiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ComentariiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 511, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 998, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(ComentariiLayout.createSequentialGroup()
                        .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(ComentariiLayout.createSequentialGroup()
                                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(AdresaCompleta, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                                    .addComponent(Proprietar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ObservatiiClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(StatusImport, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(27, 27, 27)
                                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ComentariiLayout.createSequentialGroup()
                                        .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE)
                                            .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Telefon, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                            .addComponent(PretNouTextField)))
                                    .addComponent(WebCheckBox))
                                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(ComentariiLayout.createSequentialGroup()
                                        .addGap(367, 367, 367)
                                        .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ComentariiLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(ModificaButton)
                                .addGroup(ComentariiLayout.createSequentialGroup()
                                    .addComponent(jLabel33)
                                    .addGap(18, 18, 18)
                                    .addComponent(StareNouaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(125, 125, 125)
                                    .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(50, 50, 50)
                        .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Agent)
                            .addComponent(Comision)
                            .addComponent(Suprafata))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel34, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ComentariiLayout.setVerticalGroup(
            ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ComentariiLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(AdresaCompleta))
                .addGap(26, 26, 26)
                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Proprietar)
                    .addComponent(jLabel13)
                    .addComponent(jLabel20)
                    .addComponent(Telefon)
                    .addComponent(jLabel23)
                    .addComponent(Agent))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(ObservatiiClient)
                    .addComponent(WebCheckBox)
                    .addComponent(jLabel24)
                    .addComponent(Comision)
                    .addComponent(jLabel33)
                    .addComponent(StareNouaComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ComentariiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(StatusImport)
                    .addComponent(jLabel22)
                    .addComponent(PretNouTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31)
                    .addComponent(Suprafata)
                    .addComponent(ModificaButton))
                .addGap(26, 26, 26)
                .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ComentariiTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        DetaliiButton.setBackground(new java.awt.Color(255, 255, 0));
        DetaliiButton.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        DetaliiButton.setText("Detalii");
        DetaliiButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DetaliiButtonActionPerformed(evt);
            }
        });

        Finisaje.setBackground(new java.awt.Color(255, 255, 102));
        Finisaje.setText("jLabel30");
        Finisaje.setOpaque(true);

        Utilitati.setBackground(new java.awt.Color(255, 255, 102));
        Utilitati.setText("sdfsdf");
        Utilitati.setOpaque(true);

        Dotari.setBackground(new java.awt.Color(255, 255, 102));
        Dotari.setOpaque(true);

        AdaugaPoza.setText("Adauga Poza");
        AdaugaPoza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdaugaPozaActionPerformed(evt);
            }
        });

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
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Finisaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Utilitati, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Confort, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(Compartimentare, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(Etaj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(NrCamere, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EtajeTotale)
                                .addGap(45, 45, 45)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(SuprafataConstruita)
                                    .addComponent(NrGrupuriSanitare, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
                                    .addComponent(An, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(ImbunatatiriReale, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(125, 125, 125)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LocuriParcare)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(NrBalcoane)
                                            .addComponent(SuprafataUtila)
                                            .addComponent(FereastraGrupSanitar)
                                            .addComponent(Garaje))
                                        .addGap(125, 125, 125)
                                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(Destinatie, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel35, javax.swing.GroupLayout.DEFAULT_SIZE, 102, Short.MAX_VALUE)
                                            .addComponent(jLabel37, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(Reper, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(Dotari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(StradaPret, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(PanelContainerPoze, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jScrollPane1))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(AdaugaPoza, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(44, 44, 44)
                                        .addComponent(ModificaDetalii, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(Detalii, javax.swing.GroupLayout.PREFERRED_SIZE, 967, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DetaliiButton, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 20, Short.MAX_VALUE)))
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
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StradaPret, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AdaugaPoza)
                    .addComponent(ModificaDetalii))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(PanelContainerPoze, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1)))
                .addGap(13, 13, 13)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NrCamere, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NrBalcoane, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuprafataConstruita))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Confort, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SuprafataUtila, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Destinatie, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NrGrupuriSanitare, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Compartimentare, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FereastraGrupSanitar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(An, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Garaje, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Reper, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ImbunatatiriReale, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(EtajeTotale)
                        .addComponent(Etaj)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LocuriParcare, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Finisaje, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Utilitati, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Dotari, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
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
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1317, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NrCamereComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_NrCamereComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_NrCamereComponentAdded

    private void ComentariiTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ComentariiTextFieldKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            PreparedStatement myStmt = null;
            try{
                Class.forName("com.mysql.jdbc.Driver");

                Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
                //introdu alt agent cand te loghezi
                myStmt = conn.prepareStatement("insert into comentariiia"
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
                    + " from comentariiia "
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

    private void ModificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificaButtonActionPerformed

        PreparedStatement myStmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
            // prepare statement
            myStmt = conn.prepareStatement("update aptinchiriere"
                + " set Pret=?, Stare=? "
                + " where OIA=?");
            
            // set params
            if (!PretNouTextField.getText().equalsIgnoreCase("")){
            myStmt.setInt(1, Integer.parseInt(PretNouTextField.getText()));
            }else{
            myStmt.setInt(1, pretVechi);
            }
            myStmt.setString(2, StareNouaComboBox.getSelectedItem().toString());
            myStmt.setInt(3, this.parametru);

            // execute SQL
            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(detaliiOIA.this, "Stare noua si Pret nou au fost modificate cu succes", "", JOptionPane.INFORMATION_MESSAGE);
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(detaliiOIA.this, "Error: " + e, "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_ModificaButtonActionPerformed

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
                ResultSet rs0;
                int idclientoferta=0;

                rs0 = stmt.executeQuery("select AdresaCompleta,Status,Comision,SuprafataConstruita,SuprafataUtila,ClientID,Stare"
                    + " from aptinchiriere where OIA = "+this.parametru+"");
                while(rs0.next()){
                    AdresaCompleta.setText(rs0.getString("AdresaCompleta"));
                    StatusImport.setText(rs0.getString("Status"));
                    Comision.setText(rs0.getString("Comision"));
                    Suprafata.setText(rs0.getString("SuprafataConstruita")+rs0.getString("SuprafataUtila"));
                    idclientoferta=rs0.getInt("ClientID");
                    StareNouaComboBox.setSelectedItem(rs0.getString("Stare"));
                }
                ResultSet rs1 = stmt.executeQuery("select CL.Nume,CL.Prenume,CL.Telefon,CL.NumeAgent,CL.Observatii from clienti CL"
                    + " where CL.ID= "+idclientoferta);
                while(rs1.next()){
                    Proprietar.setText(rs1.getString("Nume")+" "+rs1.getString("Prenume"));
                    ObservatiiClient.setText(rs1.getString("Observatii"));
                    Telefon.setText("0"+rs1.getString("Telefon"));
                    Agent.setText(rs1.getString("NumeAgent"));
                }

                //pentru comentariu
                ResultSet rs2;
                rs2=stmt.executeQuery("select ID,Cod,Comentarii,Agent,DataOra "
                    + " from comentariiia "
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
        new OIA(parametru).setVisible(true);
        this.setVisible(false);
        
        
        
    }//GEN-LAST:event_ModificaDetaliiActionPerformed

    private void AdaugaPozaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdaugaPozaActionPerformed

        JFileChooser fileChooser = new JFileChooser();
        boolean succes=false;
        int result = fileChooser.showOpenDialog( null );
        File file1 = new File("image1.jpg");
        if ( result == JFileChooser.APPROVE_OPTION ) // user chose a file
        {
            URI mediaURL = null;

            // get the file as URL
            mediaURL = fileChooser.getSelectedFile().toURI();
            try{
                BufferedImage img=ImageIO.read(new File(mediaURL.getPath()));
                ImageIO.write(img, "jpg", file1);
                succes=true;

            }
            catch(Exception e){
                e.printStackTrace();
            }

            if(imagine==1&&succes){
                PreparedStatement myStmt = null;
                try{
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
                    // System.out.println("db connected");

                    myStmt = conn.prepareStatement("insert into pozeia (OIA,Poza,PrimaPoza) values (?,?,?)");

                    myStmt.setInt(1,parametru);
                    FileInputStream fis1 = new FileInputStream(file1);
                    myStmt.setBinaryStream(2, fis1, (int) file1.length());
                    myStmt.setInt(3, 0);
                    myStmt.executeUpdate();

                }
                catch(Exception e){
                    e.printStackTrace();

                }
            }
            else if(succes){
                PreparedStatement myStmt = null;
                try{
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
                    // System.out.println("db connected");

                    myStmt = conn.prepareStatement("insert into pozeia (OIA,Poza,PrimaPoza) values (?,?,?)");

                    myStmt.setInt(1,parametru);
                    FileInputStream fis1 = new FileInputStream(file1);
                    myStmt.setBinaryStream(2, fis1, (int) file1.length());
                    myStmt.setInt(3, 1);
                    myStmt.executeUpdate();

                }
                catch(Exception e){
                    e.printStackTrace();

                }
                try{
                    Class.forName("com.mysql.jdbc.Driver");

                    Connection conn = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/imobiliare", "razvan", "razvan");
                    // System.out.println("db connected");

                    myStmt = conn.prepareStatement("update aptinchiriere set Imagine=?, Poza=? where OIA="+parametru);

                    myStmt.setInt(1, 1);
                    FileInputStream fis1 = new FileInputStream(file1);
                    myStmt.setBinaryStream(2, fis1, (int) file1.length());
                    myStmt.executeUpdate();

                }
                catch(Exception e){
                    e.printStackTrace();

                }

            }
        }
        this.setVisible(false);
        new detaliiOIA(parametru).setVisible(true);

    }//GEN-LAST:event_AdaugaPozaActionPerformed

    private void StareNouaComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StareNouaComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_StareNouaComboBoxActionPerformed

    
    
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
            java.util.logging.Logger.getLogger(detaliiOIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(detaliiOIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(detaliiOIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(detaliiOIA.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
       /* java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new detaliiOIA().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdaugaPoza;
    private javax.swing.JLabel AdresaCompleta;
    private javax.swing.JLabel Agent;
    private javax.swing.JLabel An;
    private javax.swing.JPanel Comentarii;
    private javax.swing.JTable ComentariiTable;
    private javax.swing.JTextField ComentariiTextField;
    private javax.swing.JLabel Comision;
    private javax.swing.JLabel Compartimentare;
    private javax.swing.JLabel Confort;
    private javax.swing.JTextArea DescriereEmotionala;
    private javax.swing.JLabel Destinatie;
    private javax.swing.JLabel Detalii;
    private javax.swing.JButton DetaliiButton;
    private javax.swing.JLabel Dotari;
    private javax.swing.JLabel Etaj;
    private javax.swing.JLabel EtajeTotale;
    private javax.swing.JLabel FereastraGrupSanitar;
    private javax.swing.JLabel Finisaje;
    private javax.swing.JLabel Garaje;
    private javax.swing.JLabel ImbunatatiriReale;
    private javax.swing.JLabel LocuriParcare;
    private javax.swing.JButton ModificaButton;
    private javax.swing.JButton ModificaDetalii;
    private javax.swing.JLabel NrBalcoane;
    private javax.swing.JLabel NrCamere;
    private javax.swing.JLabel NrGrupuriSanitare;
    private javax.swing.JLabel ObservatiiClient;
    private javax.swing.JPanel PanelContainerPoze;
    private javax.swing.JTextField PretNouTextField;
    private javax.swing.JLabel Proprietar;
    private javax.swing.JLabel Reper;
    private javax.swing.JComboBox<String> StareNouaComboBox;
    private javax.swing.JLabel StatusImport;
    private javax.swing.JLabel StradaPret;
    private javax.swing.JLabel Suprafata;
    private javax.swing.JLabel SuprafataConstruita;
    private javax.swing.JLabel SuprafataUtila;
    private javax.swing.JLabel Telefon;
    private javax.swing.JLabel Utilitati;
    private javax.swing.JCheckBox WebCheckBox;
    private javax.swing.JLabel jLabel1;
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
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}
