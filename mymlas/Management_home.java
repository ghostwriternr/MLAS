/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymlas;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ghost_000
 */
public class Management_home extends javax.swing.JFrame {

    /**
     * Creates new form Management_home
     */
    
    int pgn;
    
    public Management_home() throws SQLException {
        this.ef = new empfunc();
        initComponents();
        int nserial = 0;
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        try {
              Connect.create_Connection();
              int cnt=0;
              ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
              Connect.sql = "SELECT * FROM notifications";
              rs = Connect.stmt.executeQuery(Connect.sql);
              while(rs.next()){
                  cnt++;
                  //nserial = rs.getInt("id");
              }
              if (cnt==0)
                jLabel23.setText("0 Notifications");
              else
              {
                jLabel23.setText(""+cnt+" Notifications");
                Connect.sql = "SELECT * FROM notifications";
                rs = Connect.stmt.executeQuery(Connect.sql);
                while(rs.next()){
                    nserial = rs.getInt("id");
                    if (rs.getInt("Type")==0)
                    {
                        jLabel10.setText("Bill Requsted");
                        int bid = rs.getInt("Bill_id");
                        ResultSet rs1 = Connect.stmt.executeQuery(Connect.sql);
                        Connect.sql = "SELECT * FROM bills WHERE id="+bid+";";
                        rs1 = Connect.stmt.executeQuery(Connect.sql);
                        String pname = null;
                        String tname = null;
                        while(rs1.next()){
                            pname = rs1.getString("Patient_Name");
                            break;
                        }
                        jLabel27.setText("By "+pname+"");
                        jLabel28.setText(""+ pname +"has taken "+ tname +" test and has requested billing.");
                    }
                    break;
                }
                
              }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        jLabel1.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel1.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(92,100,121));
                jLabel6.setForeground(new java.awt.Color(92,100,121));
                jLabel23.setForeground(new java.awt.Color(92,100,121));
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jPanel3.setVisible(true);
            }  
        });
        jLabel2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel2.setForeground(Color.white);
                jLabel1.setForeground(new java.awt.Color(92,100,121));
                jLabel6.setForeground(new java.awt.Color(92,100,121));
                jLabel23.setForeground(new java.awt.Color(92,100,121));
                jPanel3.setVisible(false);
                jPanel5.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jPanel4.setVisible(true);
            }  
        });
        jLabel23.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel23.setForeground(Color.white);
                jLabel1.setForeground(new java.awt.Color(92,100,121));
                jLabel6.setForeground(new java.awt.Color(92,100,121));
                jLabel2.setForeground(new java.awt.Color(92,100,121));
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jPanel5.setVisible(true);
            }  
        });
        jLabel6.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel6.setForeground(Color.white);
                jLabel1.setForeground(new java.awt.Color(92,100,121));
                jLabel2.setForeground(new java.awt.Color(92,100,121));
                jLabel23.setForeground(new java.awt.Color(92,100,121));
                Home hm = new Home();
                hm.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel8.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                //empfunc ef;
                try {
                    ef = new empfunc(1);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                ef.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel9.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    ef = new empfunc(2);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                ef.setVisible(true);
                setVisible(false);
            }  
        });
        /*jLabel10.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                Bill_Page bp = new Bill_Page(2);
                bp.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel11.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                empfunc ef = new empfunc(4);
                ef.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel12.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                empfunc ef = new empfunc(5);
                ef.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel13.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                empfunc ef = new empfunc(6);
                ef.setVisible(true);
                setVisible(false);
            }  
        });*/
        jLabel15.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(1);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel16.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(2);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel17.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(3);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel18.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(4);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel19.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(5);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel20.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(6);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel21.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(7);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel22.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(8);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
    }
    
    public Management_home(int pg) {
        try {
            this.ef = new empfunc();
        } catch (SQLException ex) {
            Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
        }
        initComponents();
        pgn = pg;
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jLabel1.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel1.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(92,100,121));
                jLabel6.setForeground(new java.awt.Color(92,100,121));
                jLabel23.setForeground(new java.awt.Color(92,100,121));
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jPanel3.setVisible(true);
            }  
        });
        jLabel2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel2.setForeground(Color.white);
                jLabel1.setForeground(new java.awt.Color(92,100,121));
                jLabel6.setForeground(new java.awt.Color(92,100,121));
                jLabel23.setForeground(new java.awt.Color(92,100,121));
                jPanel3.setVisible(false);
                jPanel5.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jPanel4.setVisible(true);
            }  
        });
        jLabel23.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel23.setForeground(Color.white);
                jLabel1.setForeground(new java.awt.Color(92,100,121));
                jLabel6.setForeground(new java.awt.Color(92,100,121));
                jLabel2.setForeground(new java.awt.Color(92,100,121));
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jPanel5.setVisible(true);
            }  
        });
        jLabel5.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel1.setForeground(new java.awt.Color(92,100,121));
                jLabel2.setForeground(new java.awt.Color(92,100,121));
                jLabel6.setForeground(new java.awt.Color(92,100,121));
                jLabel23.setForeground(new java.awt.Color(92,100,121));
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jLabel3.setVisible(true);
                jLabel4.setVisible(true);
                jPanel3.setVisible(false);
            }  
        });
        jLabel6.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel6.setForeground(Color.white);
                jLabel1.setForeground(new java.awt.Color(92,100,121));
                jLabel2.setForeground(new java.awt.Color(92,100,121));
                jLabel23.setForeground(new java.awt.Color(92,100,121));
                Home hm = new Home();
                hm.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel8.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                //empfunc ef;
                try {
                    ef = new empfunc(1);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                ef.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel9.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                //empfunc ef;
                try {
                    ef = new empfunc(2);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                ef.setVisible(true);
                setVisible(false);
            }  
        });
        /*jLabel10.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                empfunc ef = new empfunc(3);
                ef.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel11.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                empfunc ef = new empfunc(4);
                ef.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel12.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                empfunc ef = new empfunc(5);
                ef.setVisible(true);
                setVisible(false);
            }  
        });
        jLabel13.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                empfunc ef = new empfunc(6);
                ef.setVisible(true);
                setVisible(false);
            }  
        });*/
        jLabel15.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(1);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel16.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(2);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel17.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(3);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel18.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(4);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel19.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(5);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel20.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(6);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel21.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(7);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        jLabel22.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                try {
                    mgfunc mgf = new mgfunc(8);
                    mgf.setVisible(true);
                    setVisible(false);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }  
        });
        if (pg == 1)
        {
            jLabel1.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(92,100,121));
                jLabel6.setForeground(new java.awt.Color(92,100,121));
                jLabel23.setForeground(new java.awt.Color(92,100,121));
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jPanel3.setVisible(true);
        }
        if (pg == 2)
        {
            jLabel2.setForeground(Color.white);
                jLabel1.setForeground(new java.awt.Color(92,100,121));
                jLabel6.setForeground(new java.awt.Color(92,100,121));
                jLabel23.setForeground(new java.awt.Color(92,100,121));
                jPanel3.setVisible(false);
                jPanel5.setVisible(false);
                jLabel3.setVisible(false);
                jLabel4.setVisible(false);
                jPanel4.setVisible(true);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(17, 29, 51));
        jPanel1.setLayout(null);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Choose function type below");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(140, 390, 700, 50);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(92, 100, 121));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Employee Functions");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(92, 100, 121), 2));
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1, 510, 240, 30);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(92, 100, 121));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Management Functions");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(92, 100, 121), 2));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(240, 510, 240, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mymlas/20150108_moon_city_600.jpg"))); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(0, 20, 960, 490);

        jLabel5.setBackground(new java.awt.Color(24, 24, 22));
        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 13)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ADMINISTRATION MAIN");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(0, 0, 960, 20);

        jPanel3.setBackground(new java.awt.Color(24, 24, 22));
        jPanel3.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Remove Test");
        jLabel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel3.add(jLabel17);
        jLabel17.setBounds(0, 326, 480, 164);

        jLabel18.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Edit Test");
        jLabel18.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel3.add(jLabel18);
        jLabel18.setBounds(480, 326, 480, 164);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("List Tests");
        jLabel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel3.add(jLabel15);
        jLabel15.setBounds(0, 163, 480, 163);

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Add Test");
        jLabel16.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel3.add(jLabel16);
        jLabel16.setBounds(480, 163, 480, 163);

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Add Patient");
        jLabel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel3.add(jLabel8);
        jLabel8.setBounds(1, 0, 480, 163);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("List Stocks");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel3.add(jLabel9);
        jLabel9.setBounds(480, 0, 480, 163);

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mymlas/mooncity_blur.jpg"))); // NOI18N
        jPanel3.add(jLabel7);
        jLabel7.setBounds(0, 0, 960, 490);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 20, 960, 490);

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(92, 100, 121));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Logout");
        jLabel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(92, 100, 121), 2));
        jPanel1.add(jLabel6);
        jLabel6.setBounds(720, 510, 240, 30);

        jPanel4.setBackground(new java.awt.Color(24, 24, 22));
        jPanel4.setLayout(null);

        jLabel19.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Place Order");
        jLabel19.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel4.add(jLabel19);
        jLabel19.setBounds(0, 0, 480, 245);

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Cancel Order");
        jLabel20.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel4.add(jLabel20);
        jLabel20.setBounds(480, 0, 480, 245);

        jLabel21.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("Modify Order");
        jLabel21.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel4.add(jLabel21);
        jLabel21.setBounds(0, 245, 480, 245);

        jLabel22.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("Replenish All Stocks");
        jLabel22.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel4.add(jLabel22);
        jLabel22.setBounds(480, 245, 480, 245);

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mymlas/mooncity_blur.jpg"))); // NOI18N
        jPanel4.add(jLabel14);
        jLabel14.setBounds(0, 0, 960, 490);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 20, 960, 490);

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(92, 100, 121));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Notifications");
        jLabel23.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(92, 100, 121), 2));
        jPanel1.add(jLabel23);
        jLabel23.setBounds(480, 510, 240, 30);

        jPanel5.setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Previous");
        jPanel5.add(jButton1);
        jButton1.setBounds(20, 80, 450, 25);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Next");
        jButton2.setToolTipText("");
        jPanel5.add(jButton2);
        jButton2.setBounds(490, 80, 450, 29);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jButton3.setForeground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Take Action");
        jPanel5.add(jButton3);
        jButton3.setBounds(20, 430, 920, 40);

        jLabel27.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(204, 204, 204));
        jLabel27.setText("From xyz");
        jPanel5.add(jLabel27);
        jLabel27.setBounds(40, 200, 880, 50);

        jLabel28.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(204, 204, 204));
        jLabel28.setText("Lorem ipsum dolor sit amet, dico eruditi adversarium et quo. Cu quo hinc porro aliquam, dictas possim omnesque ad vix.");
        jPanel5.add(jLabel28);
        jLabel28.setBounds(40, 260, 880, 50);
        jPanel5.add(jSeparator1);
        jSeparator1.setBounds(20, 412, 920, 10);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Test Notification");
        jPanel5.add(jLabel10);
        jLabel10.setBounds(40, 140, 880, 50);

        jLabel13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel5.add(jLabel13);
        jLabel13.setBounds(20, 120, 920, 280);

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.add(jLabel12);
        jLabel12.setBounds(20, 120, 920, 350);

        jLabel25.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Notifications");
        jLabel25.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel5.add(jLabel25);
        jLabel25.setBounds(1, 0, 960, 60);

        jLabel26.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel5.add(jLabel26);
        jLabel26.setBounds(1, 60, 960, 430);

        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mymlas/mooncity_blur.jpg"))); // NOI18N
        jPanel5.add(jLabel24);
        jLabel24.setBounds(0, 0, 960, 490);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 20, 960, 490);

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 539, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 539, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Management_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Management_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Management_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Management_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Management_home().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Management_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    private empfunc ef;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
