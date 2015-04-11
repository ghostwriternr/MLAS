/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mymlas;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author ghost_000
 */
public class Patient_home extends javax.swing.JFrame {

    /**
     * Creates new form Patient_home
     */
    
    int chn;
    
    public Patient_home() throws SQLException {
        this.Management_ = new Management();
        initComponents();
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            for(int i = 0;i < Management_.get_num_tests();i++)
            {    
                tm.addRow(new Object[] {i + 1,(Management_.list_Tests(i)).get_Testname(),(Management_.list_Tests(i)).get_Testcharges()});
                jComboBox1.addItem(Management_.list_Tests(i).get_Testname());
            }
        jLabel1.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
            }  
        });
        jLabel2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel2.setForeground(Color.white);
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jPanel3.setVisible(true);
            }  
        });
        jLabel3.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel3.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jPanel4.setVisible(true);
            }  
        });
        jLabel4.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel4.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jPanel5.setVisible(true);
            }  
        });
        jLabel5.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel5.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jPanel6.setVisible(true);
            }  
        });
        jLabel9.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel9.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                Home hm = new Home();
                hm.setVisible(true);
                setVisible(false);
            }  
        });
    }
    
    public Patient_home(int ch) throws SQLException {
        this.Management_ = new Management();
        initComponents();
        chn = ch;
        jPanel3.setVisible(false);
        jPanel4.setVisible(false);
        jPanel5.setVisible(false);
        jPanel6.setVisible(false);
        DefaultTableModel tm = (DefaultTableModel) jTable1.getModel();
            for(int i = 0;i < Management_.get_num_tests();i++)
                tm.addRow(new Object[] {i + 1,(Management_.list_Tests(i)).get_Testname(),(Management_.list_Tests(i)).get_Testcharges()});
        jLabel1.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(true);
                jLabel7.setVisible(true);
            }  
        });
        jLabel2.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel2.setForeground(Color.white);
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jPanel3.setVisible(true);
            }  
        });
        jLabel3.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel3.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jPanel4.setVisible(true);
            }  
        });
        jLabel4.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel4.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jPanel5.setVisible(true);
            }  
        });
        jLabel5.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel5.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jPanel6.setVisible(true);
            }  
        });
        jLabel9.addMouseListener(new MouseAdapter()  
        {  
            public void mouseClicked(MouseEvent e)  
            {
                jLabel9.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel4.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                Home hm = new Home();
                hm.setVisible(true);
                setVisible(false);
            }  
        });
        if (chn==3)
        {
            jPanel3.setVisible(false);
                jPanel4.setVisible(false);
                jPanel5.setVisible(false);
                jPanel6.setVisible(false);
                jLabel4.setForeground(Color.white);
                jLabel2.setForeground(new java.awt.Color(204,204,204));
                jLabel3.setForeground(new java.awt.Color(204,204,204));
                jLabel5.setForeground(new java.awt.Color(204,204,204));
                jLabel9.setForeground(new java.awt.Color(204,204,204));
                jLabel6.setVisible(false);
                jLabel7.setVisible(false);
                jPanel5.setVisible(true);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField7 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(59, 64, 68));
        jPanel1.setLayout(null);

        jLabel1.setBackground(new java.awt.Color(255, 153, 51));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("PATIENT HOME");
        jLabel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 50);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Take Test");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel2);
        jLabel2.setBounds(0, 50, 192, 60);

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Account Details");
        jLabel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 50, 192, 60);

        jLabel4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 204, 204));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Collect Test Report");
        jLabel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel4);
        jLabel4.setBounds(380, 50, 192, 60);

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Bills");
        jLabel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel5);
        jLabel5.setBounds(570, 50, 192, 60);

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Select Option Above");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(0, 426, 960, 70);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mymlas/moss.jpg"))); // NOI18N
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 110, 960, 430);

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 204, 204));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Logout");
        jLabel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jPanel1.add(jLabel9);
        jLabel9.setBounds(761, 50, 200, 60);

        jPanel3.setLayout(null);

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Tests Available in Lab");
        jPanel3.add(jLabel10);
        jLabel10.setBounds(0, 10, 500, 40);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Serial no.", "Test Name", "Test Charges", "Already Taken ?"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel3.add(jScrollPane1);
        jScrollPane1.setBounds(20, 52, 470, 370);

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Select Test to Take :");
        jPanel3.add(jLabel11);
        jLabel11.setBounds(520, 80, 410, 40);

        jPanel3.add(jComboBox1);
        jComboBox1.setBounds(520, 130, 420, 40);

        jButton1.setText("Proceed");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);
        jButton1.setBounds(749, 385, 200, 40);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mymlas/moss_blur.jpg"))); // NOI18N
        jPanel3.add(jLabel8);
        jLabel8.setBounds(0, 0, 960, 430);

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 110, 960, 430);

        jPanel4.setLayout(null);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Password");
        jPanel4.add(jLabel13);
        jLabel13.setBounds(480, 20, 480, 50);

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Name");
        jPanel4.add(jLabel14);
        jLabel14.setBounds(30, 80, 210, 40);

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Age");
        jPanel4.add(jLabel15);
        jLabel15.setBounds(30, 150, 210, 40);

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Gender");
        jPanel4.add(jLabel16);
        jLabel16.setBounds(30, 220, 210, 40);

        jTextField1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField1);
        jTextField1.setBounds(280, 80, 220, 40);

        jTextField2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField2);
        jTextField2.setBounds(280, 150, 220, 40);

        jTextField3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField3ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField3);
        jTextField3.setBounds(280, 220, 220, 40);

        jLabel17.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Account Details");
        jPanel4.add(jLabel17);
        jLabel17.setBounds(0, 20, 480, 50);

        jButton3.setText("Update");
        jPanel4.add(jButton3);
        jButton3.setBounds(749, 385, 200, 40);

        jLabel24.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Old Password");
        jPanel4.add(jLabel24);
        jLabel24.setBounds(530, 80, 210, 40);

        jLabel25.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("New Password");
        jPanel4.add(jLabel25);
        jLabel25.setBounds(530, 150, 210, 40);

        jLabel26.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("Confirm New Password");
        jPanel4.add(jLabel26);
        jLabel26.setBounds(530, 220, 210, 40);

        jTextField6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField6ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField6);
        jTextField6.setBounds(730, 80, 220, 40);

        jTextField7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField7ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField7);
        jTextField7.setBounds(730, 150, 220, 40);

        jTextField8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jTextField8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField8ActionPerformed(evt);
            }
        });
        jPanel4.add(jTextField8);
        jTextField8.setBounds(730, 220, 220, 40);

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mymlas/moss_blur.jpg"))); // NOI18N
        jPanel4.add(jLabel12);
        jLabel12.setBounds(0, 0, 960, 430);

        jPanel1.add(jPanel4);
        jPanel4.setBounds(0, 110, 960, 430);

        jPanel5.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Enter Details");
        jPanel5.add(jLabel20);
        jLabel20.setBounds(0, 20, 480, 50);

        jLabel21.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Name");
        jPanel5.add(jLabel21);
        jLabel21.setBounds(30, 80, 210, 40);

        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField4);
        jTextField4.setBounds(280, 80, 220, 40);

        jLabel22.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Bill ID");
        jPanel5.add(jLabel22);
        jLabel22.setBounds(30, 150, 210, 40);

        jTextField5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField5ActionPerformed(evt);
            }
        });
        jPanel5.add(jTextField5);
        jTextField5.setBounds(280, 150, 220, 40);

        jButton5.setText("Generate");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5);
        jButton5.setBounds(749, 385, 200, 40);

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mymlas/moss_blur.jpg"))); // NOI18N
        jPanel5.add(jLabel18);
        jLabel18.setBounds(0, 0, 960, 430);

        jPanel1.add(jPanel5);
        jPanel5.setBounds(0, 110, 960, 430);

        jPanel6.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Current Status of All Bills");
        jPanel6.add(jLabel23);
        jLabel23.setBounds(0, 10, 960, 40);

        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mymlas/moss_blur.jpg"))); // NOI18N
        jPanel6.add(jLabel19);
        jLabel19.setBounds(0, 0, 960, 430);

        jPanel1.add(jPanel6);
        jPanel6.setBounds(0, 110, 960, 430);

        jPanel2.setOpaque(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField3ActionPerformed

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jTextField5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5ActionPerformed

    private void jTextField6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField6ActionPerformed

    private void jTextField7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField7ActionPerformed

    private void jTextField8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField8ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        Report rpt = new Report();
        rpt.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*Bill_Page bl = new Bill_Page(1);
        bl.setVisible(true);
        this.setVisible(false);*/
        if(String.valueOf(jComboBox1.getSelectedItem()).equals("None")){
            JOptionPane.showMessageDialog(null,"Select a valid Test and then press Take Test.\n");
        }
        else {
            JOptionPane.showMessageDialog(null,"Thank You For taking the Test!!\nYou will receive the bill shortly.\n");
            try {
              Connect.create_Connection(); 
              Connect.sql = "SELECT * FROM notifications";
              ResultSet rs = Connect.stmt.executeQuery(Connect.sql);
              int nserial = 0;
              while(rs.next()){
                  nserial = rs.getInt("id");
              }
              nserial++;
              Connect.sql = "SELECT * FROM bills";
              int bserial = 0;
              while(rs.next()){
                  bserial = rs.getInt("id");
              }
              bserial++;
              //Calendar cal = Calendar.getInstance();
              Connect.sql = "INSERT INTO notifications VALUES (" + nserial + "," + bserial + ",0);";
              Connect.stmt.executeUpdate(Connect.sql);
              Connect.stmt.close();
              /*int indx = 0;
              DefaultTableModel tm = (DefaultTableModel) Table.getModel();
              for (int i = 0; i < tm.getRowCount(); i++){
                if (tm.getValueAt(i,1).equals(String.valueOf(Select_Test1.getSelectedItem()))){
                    indx = i;
                }
              }
              tm.setValueAt(true,indx,3);*/
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(Patient_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Patient_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Patient_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Patient_home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Patient_home().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Patient_home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    public Management Management_;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox jComboBox1;
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
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    // End of variables declaration//GEN-END:variables
}
