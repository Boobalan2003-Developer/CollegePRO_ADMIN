/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package eascpkg;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author booba
 */
public class LoginFrame extends javax.swing.JFrame {

    static String username;
    static String userID,pass;
    static int sw,sh,random_Number;
    public LoginFrame() {
        initComponents();
        try {
            File fontstl1=new File("D:\\Font Styles\\Poppins\\Poppins-Medium.ttf");
            Font f1=Font.createFont(Font.TRUETYPE_FONT,fontstl1 ).deriveFont(18f);
            Font f2=Font.createFont(Font.TRUETYPE_FONT,fontstl1 ).deriveFont(14f);
            Font f3=Font.createFont(Font.TRUETYPE_FONT,fontstl1 ).deriveFont(12f);
            wellbl.setFont(f1);
            lbl1.setFont(f2);
            lbl2.setFont(f2);
            lbl3.setFont(f2);
            forgotpwlbl.setFont(f3);
            forgotpanellbl.setFont(f2);
            enterOTPlbl.setFont(f3);
            confirmbtn.setFont(f3);
            sendbtn.setFont(f3);
            newPWlbl.setFont(f3);
            reEnterPWlbl.setFont(f3);
            INCOTPstslbl.setFont(f3);
            admintype.setFont(f3);
            userIdlbl.setFont(f3);
            adminTypelbl.setFont(f3);
            mailidlbl.setFont(f3);
//            clglbl1.setFont(f1);
            verifybtn.setFont(f3);
            resetbtn1.setFont(f3);
            clglbl2.setFont(f3);
            clglbl3.setFont(f3);
            clglbl4.setFont(f3);
//            otpsendingstslbl.setFont(f2);
        } 
        catch (FontFormatException | IOException ex) 
        {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }

        Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
        sw=(int)d.getWidth();
        sh=(int)d.getHeight();
        setExtendedState(MAXIMIZED_BOTH);
        setTitle("EASCPRO-ADMIN");
        getContentPane().setBackground(new Color(255,255,255));
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\netBeans\\EASCPRJ-ADMIN\\src\\Resources\\clglogo1.png"));
        
    }
    
    int OTPGenerate()
    {
        Random rand=new Random(); 
        random_Number=100000 + rand.nextInt(900000);
        return random_Number;
    }
    boolean OTPSending(String toAdd, String msg)
    {
        boolean res=false;
        String to=toAdd;
        String subject="EASCPRO-Password Authentication";
        String from="boobalanvellingiri@gmail.com";
        String passKey="ryvk nuuq kdwt peii";            
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); 
                            
        Session session = Session.getInstance(props, new Authenticator() {
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(from, passKey);
	            }
	});
        try{
	    Message mimeMessage = new MimeMessage(session);
	    mimeMessage.setFrom(new InternetAddress(from));
	    mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
	    mimeMessage.setSubject(subject);
	    mimeMessage.setText(msg);
	    Transport.send(mimeMessage);
            res=true;
	    } 
        catch (MessagingException e) {
	    JOptionPane.showMessageDialog(parentpanel,"Error in sending email: " + e.getMessage(),"EmailSender",2);
            
        }
        return res;
    }
    boolean passwordUpdate()
    {
        boolean result=false;
        String newPW=newPWTF.getText();
        String confirmPW=confirmPWTF.getText();
                if(newPW.equals(confirmPW))
                {
                    int res=JOptionPane.showConfirmDialog(parentpanel, "Are You sure want to change Your Password ?","EASCPRO",JOptionPane.YES_NO_CANCEL_OPTION);
                    
                    if(res==0)
                    {
                        try {
                            Class.forName("com.mysql.cj.jdbc.Driver");
                            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro","root","root");
                            String q="update adminLogin set adminPW = ? where adminid=?";
                            PreparedStatement ps1=con.prepareStatement(q);
                            ps1.setString(1,newPW);
                            ps1.setString(2,userIdTF.getText());
                            ps1.executeUpdate();
                            result=true;
                            parentpanel.removeAll();
                            parentpanel.add(Sign_inPanel);
                            parentpanel.repaint();
                            parentpanel.revalidate();
                            
                        }//try Block ends here...!
                  
                        catch (ClassNotFoundException | SQLException ex) {
                            Logger.getLogger(AdminDashBoard.class.getName()).log(Level.SEVERE, null, ex);
                        }//catch clause end here..!
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(parentpanel, "Password Fields Value Mismatch..!","EASCPRO",JOptionPane.ERROR_MESSAGE);
                }
        return result;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        clglbl4 = new javax.swing.JLabel();
        clglbl3 = new javax.swing.JLabel();
        clglbl2 = new javax.swing.JLabel();
        clglbl5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        mainPanel = new javax.swing.JPanel();
        parentpanel = new javax.swing.JPanel();
        Sign_inPanel = new javax.swing.JPanel();
        wellbl = new javax.swing.JLabel();
        lbl1 = new javax.swing.JLabel();
        lbl2 = new javax.swing.JLabel();
        uidTF = new javax.swing.JTextField();
        lbl3 = new javax.swing.JLabel();
        pwTF = new javax.swing.JPasswordField();
        verifybtn = new javax.swing.JButton();
        resetbtn1 = new javax.swing.JButton();
        forgotpwlbl = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        forgotPWPanel = new javax.swing.JPanel();
        forgotpanellbl = new javax.swing.JLabel();
        userIdlbl = new javax.swing.JLabel();
        userIdTF = new javax.swing.JTextField();
        adminTypelbl = new javax.swing.JLabel();
        admintype = new javax.swing.JComboBox<>();
        mailidlbl = new javax.swing.JLabel();
        mailIdTF = new javax.swing.JTextField();
        sendbtn = new javax.swing.JButton();
        resetbtnforForgotpwPanel = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        enterOTPlbl = new javax.swing.JLabel();
        otpTF = new javax.swing.JTextField();
        newPWlbl = new javax.swing.JLabel();
        newPWTF = new javax.swing.JTextField();
        reEnterPWlbl = new javax.swing.JLabel();
        confirmPWTF = new javax.swing.JTextField();
        confirmbtn = new javax.swing.JButton();
        verifyOTPbtn = new javax.swing.JButton();
        otpsendingstslbl = new javax.swing.JLabel();
        otpstspanel = new javax.swing.JPanel();
        panel1 = new javax.swing.JLabel();
        CRTOTPstslbl = new javax.swing.JLabel();
        INCOTPstslbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(102, 153, 255));
        jPanel2.setLayout(null);

        clglbl4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clglbl4.setForeground(new java.awt.Color(255, 255, 255));
        clglbl4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clglbl4.setText("Erode - 638009");
        jPanel2.add(clglbl4);
        clglbl4.setBounds(0, 180, 390, 20);

        clglbl3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clglbl3.setForeground(new java.awt.Color(255, 255, 255));
        clglbl3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clglbl3.setText("Autonomous (Co-Education)");
        jPanel2.add(clglbl3);
        clglbl3.setBounds(0, 160, 390, 20);

        clglbl2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clglbl2.setForeground(new java.awt.Color(255, 255, 255));
        clglbl2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clglbl2.setText("Affiliated to Bharathiar University");
        jPanel2.add(clglbl2);
        clglbl2.setBounds(0, 140, 390, 20);

        clglbl5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        clglbl5.setForeground(new java.awt.Color(255, 255, 255));
        clglbl5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clglbl5.setText("ERODE ARTS AND SCIENCE COLLEGE");
        jPanel2.add(clglbl5);
        clglbl5.setBounds(0, 110, 390, 30);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/clglogo1.png"))); // NOI18N
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel8);
        jLabel8.setBounds(80, 250, 220, 220);

        jPanel1.add(jPanel2);
        jPanel2.setBounds(20, 30, 390, 730);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));
        mainPanel.setLayout(null);

        parentpanel.setLayout(new java.awt.CardLayout());

        Sign_inPanel.setLayout(null);

        wellbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        wellbl.setText("Welcome to EASCPRO ");
        Sign_inPanel.add(wellbl);
        wellbl.setBounds(0, 20, 900, 40);

        lbl1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        lbl1.setText("Sign-in to Continue with us");
        Sign_inPanel.add(lbl1);
        lbl1.setBounds(150, 120, 260, 17);

        lbl2.setText("User-Id");
        Sign_inPanel.add(lbl2);
        lbl2.setBounds(150, 160, 100, 20);

        uidTF.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 255)));
        uidTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidTFActionPerformed(evt);
            }
        });
        Sign_inPanel.add(uidTF);
        uidTF.setBounds(150, 180, 250, 30);

        lbl3.setText("Password");
        Sign_inPanel.add(lbl3);
        lbl3.setBounds(150, 220, 100, 20);

        pwTF.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 255)));
        Sign_inPanel.add(pwTF);
        pwTF.setBounds(150, 240, 250, 30);

        verifybtn.setBackground(new java.awt.Color(102, 200, 215));
        verifybtn.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        verifybtn.setMnemonic('v');
        verifybtn.setText("Verify");
        verifybtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifybtnActionPerformed(evt);
            }
        });
        Sign_inPanel.add(verifybtn);
        verifybtn.setBounds(150, 290, 72, 23);

        resetbtn1.setBackground(new java.awt.Color(102, 200, 215));
        resetbtn1.setFont(new java.awt.Font("Segoe UI Semilight", 0, 12)); // NOI18N
        resetbtn1.setMnemonic('R');
        resetbtn1.setText("Reset");
        resetbtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtn1ActionPerformed(evt);
            }
        });
        Sign_inPanel.add(resetbtn1);
        resetbtn1.setBounds(330, 290, 72, 23);

        forgotpwlbl.setForeground(new java.awt.Color(102, 153, 255));
        forgotpwlbl.setText("Forgot Password");
        forgotpwlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        forgotpwlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                forgotpwlblMouseClicked(evt);
            }
        });
        Sign_inPanel.add(forgotpwlbl);
        forgotpwlbl.setBounds(150, 330, 120, 16);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/Authenticationlogo.png"))); // NOI18N
        jLabel6.setText("jLabel6");
        Sign_inPanel.add(jLabel6);
        jLabel6.setBounds(540, 40, 360, 320);

        parentpanel.add(Sign_inPanel, "card2");

        forgotPWPanel.setLayout(null);

        forgotpanellbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotpanellbl.setText("Forgot Password");
        forgotPWPanel.add(forgotpanellbl);
        forgotpanellbl.setBounds(350, 20, 210, 30);

        userIdlbl.setText("User ID");
        forgotPWPanel.add(userIdlbl);
        userIdlbl.setBounds(160, 90, 70, 30);

        userIdTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userIdTFActionPerformed(evt);
            }
        });
        forgotPWPanel.add(userIdTF);
        userIdTF.setBounds(160, 120, 250, 30);

        adminTypelbl.setText("Admin Type");
        forgotPWPanel.add(adminTypelbl);
        adminTypelbl.setBounds(160, 160, 80, 30);

        admintype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        admintype.setSelectedItem("-");
        forgotPWPanel.add(admintype);
        admintype.setBounds(160, 190, 250, 30);

        mailidlbl.setText("Mail ID");
        forgotPWPanel.add(mailidlbl);
        mailidlbl.setBounds(160, 230, 90, 30);
        forgotPWPanel.add(mailIdTF);
        mailIdTF.setBounds(160, 260, 250, 30);

        sendbtn.setBackground(new java.awt.Color(102, 200, 215));
        sendbtn.setText("Send OTP");
        forgotPWPanel.add(sendbtn);
        sendbtn.setBounds(160, 320, 110, 20);

        resetbtnforForgotpwPanel.setBackground(new java.awt.Color(102, 200, 215));
        resetbtnforForgotpwPanel.setText("Reset");
        resetbtnforForgotpwPanel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetbtnforForgotpwPanelActionPerformed(evt);
            }
        });
        forgotPWPanel.add(resetbtnforForgotpwPanel);
        resetbtnforForgotpwPanel.setBounds(310, 320, 100, 20);

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        forgotPWPanel.add(jSeparator1);
        jSeparator1.setBounds(440, 90, 10, 270);

        enterOTPlbl.setText("Enter OTP");
        forgotPWPanel.add(enterOTPlbl);
        enterOTPlbl.setBounds(470, 90, 130, 30);
        forgotPWPanel.add(otpTF);
        otpTF.setBounds(470, 120, 250, 30);

        newPWlbl.setText("New Password");
        forgotPWPanel.add(newPWlbl);
        newPWlbl.setBounds(470, 160, 120, 30);
        forgotPWPanel.add(newPWTF);
        newPWTF.setBounds(470, 190, 250, 30);

        reEnterPWlbl.setText("Re-Enter password");
        forgotPWPanel.add(reEnterPWlbl);
        reEnterPWlbl.setBounds(470, 230, 160, 30);
        forgotPWPanel.add(confirmPWTF);
        confirmPWTF.setBounds(470, 260, 250, 30);

        confirmbtn.setText("Confirm");
        confirmbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmbtnActionPerformed(evt);
            }
        });
        forgotPWPanel.add(confirmbtn);
        confirmbtn.setBounds(540, 320, 120, 20);

        verifyOTPbtn.setText("Verify");
        forgotPWPanel.add(verifyOTPbtn);
        verifyOTPbtn.setBounds(770, 120, 100, 20);

        otpsendingstslbl.setBackground(new java.awt.Color(102, 255, 102));
        otpsendingstslbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        forgotPWPanel.add(otpsendingstslbl);
        otpsendingstslbl.setBounds(340, 380, 200, 30);

        otpstspanel.setLayout(new java.awt.CardLayout());
        otpstspanel.add(panel1, "card4");
        otpstspanel.add(CRTOTPstslbl, "card3");
        otpstspanel.add(INCOTPstslbl, "card2");

        forgotPWPanel.add(otpstspanel);
        otpstspanel.setBounds(770, 140, 100, 40);

        parentpanel.add(forgotPWPanel, "card3");

        mainPanel.add(parentpanel);
        parentpanel.setBounds(120, 150, 900, 440);

        jPanel1.add(mainPanel);
        mainPanel.setBounds(410, 30, 1120, 730);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1550, 796);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MouseClicked

    private void uidTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uidTFActionPerformed

    private void verifybtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifybtnActionPerformed
        // TODO add your handling code here:

        userID=uidTF.getText();
        pass=pwTF.getText();
        System.out.println(userID+"  "+pass);
          try
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro","root","root");
            if(!(userID.equals(""))&& !(pass.equals("")))
            {
                String q="select * from adminlogin where adminId=? && adminPw=?";
                PreparedStatement ps1=con.prepareStatement(q);
                ps1.setString(1, uidTF.getText());
                ps1.setString(2,pwTF.getText());
                ResultSet rs1=ps1.executeQuery();

                if(rs1.next())
                {
                    username=rs1.getString("adminName");
                    JOptionPane.showMessageDialog(null, "Authentication Success..!","EASCPRO",JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                    new AdminDashBoard();
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Authentication Failed..!","EASCPRO",JOptionPane.ERROR_MESSAGE);
                    uidTF.setText("");
                    pwTF.setText("");
                }
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Username/password Field(s)are Missing","EASCPRO",JOptionPane.ERROR_MESSAGE);
            }
        }

        catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verifybtnActionPerformed

    private void resetbtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtn1ActionPerformed
        // TODO add your handling code here:
        uidTF.setText("");
        pwTF.setText("");
    }//GEN-LAST:event_resetbtn1ActionPerformed
    void OTPverification()
    {     
        INCOTPstslbl.setText("Incorrect OTP");
        INCOTPstslbl.setForeground(Color.red);
        CRTOTPstslbl.setText("OTP Verified");
        CRTOTPstslbl.setForeground(Color.green);
        
        CRTOTPstslbl.setVisible(false);
        INCOTPstslbl.setVisible(false);
        
        if(!(otpTF.getText().equals("")))
                {
                    if(Integer.parseInt(otpTF.getText())==random_Number)
                    {
                        otpstspanel.removeAll();
                        otpstspanel.add(CRTOTPstslbl);
                        otpstspanel.repaint();
                        otpstspanel.revalidate();
                        new Timer().schedule(new TimerTask(){
                            @Override
                            public void run() {
                                otpstspanel.removeAll();
                                otpstspanel.add(panel1);
                                otpstspanel.repaint();
                                otpstspanel.revalidate();
                                otpTF.setEnabled(false);
                                newPWTF.setEnabled(true);
                                confirmPWTF.setEnabled(true);
                                confirmbtn.setEnabled(true);
                                confirmbtn.setBackground(new Color(102,200,215));
                            }
                        }, 2000);
                    }
                    else
                    {
                        otpstspanel.removeAll();
                        otpstspanel.add(INCOTPstslbl);
                        otpstspanel.repaint();
                        otpstspanel.revalidate();
                        new Timer().schedule(new TimerTask(){
                            @Override
                            public void run() {
                                otpstspanel.removeAll();
                                otpstspanel.add(panel1);
                                otpstspanel.repaint();
                                otpstspanel.revalidate();
                            }
                        }, 2000);
                    }
                }
                else
                {
                    JOptionPane.showMessageDialog(parentpanel, "Input Field value missing","EASCPRO",JOptionPane.ERROR_MESSAGE);
                }
    } 
    private void forgotpwlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_forgotpwlblMouseClicked
        // TODO add your handling code here:
        parentpanel.removeAll();
        parentpanel.add(forgotPWPanel);
        parentpanel.repaint();
        parentpanel.revalidate();

        otpTF.setEnabled(false);
        confirmPWTF.setEnabled(false);
        newPWTF.setEnabled(false);
        confirmbtn.setEnabled(false);
        verifyOTPbtn.setEnabled(false);
        admintype.removeAllItems();
        admintype.addItem("-");
        admintype.addItem("Admission");
        admintype.addItem("Fee Collector");
//        deptCBbox.addItem("Maths");
//        deptCBbox.addItem("Physics");
//        deptCBbox.addItem("Chemistry");
//        deptCBbox.addItem("Computer Technology");
//        deptCBbox.addItem("Computer Science");
//        deptCBbox.addItem("Information Technology");
//        deptCBbox.addItem("Computer Application");
//        deptCBbox.addItem("Bio-Chemistry");
//        deptCBbox.addItem("Micro-Biology");
//        deptCBbox.addItem("Visual Communication");
//        deptCBbox.addItem("Cyber Security");
//        deptCBbox.addItem("Costume Designing and Fashion");
//        deptCBbox.addItem("Business Administration");
//        deptCBbox.addItem("Social Work");
//        deptCBbox.addItem("Business Administration");
//        deptCBbox.addItem("Commerce-BF");
//        deptCBbox.addItem("Commerce-BI");
//        deptCBbox.addItem("Commerce-PA");
//        deptCBbox.addItem("Commerce-CA");
//        deptCBbox.addItem("Zoology");
//        deptCBbox.addItem("History");
//        deptCBbox.addItem("Defense andStrategy Studies");
//        deptCBbox.addItem("Food Science and Nutrition");
//        deptCBbox.addItem("Political Science");
//        deptCBbox.addItem("History");

        sendbtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(!(userIdTF.getText().equals("")) && !(admintype.getSelectedItem().toString().equals("-")) && !(mailIdTF.getText().equals("")))
                {
                    try
                    {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro","root","root");
                        String q="select * from adminLogin where adminid=? and adminMail=? and adminType=?";
                        PreparedStatement ps1=con.prepareStatement(q);
                        ps1.setString(1,userIdTF.getText());
                        ps1.setString(2,mailIdTF.getText());
                        ps1.setString(3,admintype.getSelectedItem().toString());
                        ResultSet rs1=ps1.executeQuery();
                        if(rs1.next())
                        {
                            username=rs1.getString("adminname");
                            int otp=OTPGenerate();
                            String message="You have request to update your password of your EASCPRO account \n" +
                            "\n" + "Your security code is \n"+otp+"\n" +"\n\n\n\nTruly,\n" +"-EASCPRO-Management";

                            boolean res=OTPSending(mailIdTF.getText(),message);
                            if(res)
                            {
                                otpsendingstslbl.setText("OTP Sent Succesful");
                                otpsendingstslbl.setForeground(Color.green);
                                new Timer().schedule(new TimerTask(){
                                    @Override
                                    public void run() {
                                        otpsendingstslbl.setText("");
                                        mailIdTF.setEnabled(false);
                                        userIdTF.setEnabled(false);
                                        admintype.setEnabled(false);
                                        otpTF.setEnabled(true);
                                        verifyOTPbtn.setEnabled(true);
                                        verifyOTPbtn.setBackground(new Color(102,200,215));
                                    }
                                }, 2000);
                            }
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(parentpanel, "Invalid User Data..!","EASCPRO",JOptionPane.ERROR_MESSAGE);
                        }
                    }//try Block ends here...!

                    catch (ClassNotFoundException | SQLException ex) {
                        ex.printStackTrace();
                    }//catch clause end here..!
                }
                else
                {
                    JOptionPane.showMessageDialog(parentpanel, "Input Field(s) value missing","EASCPRO",JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        verifyOTPbtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                OTPverification();
            }
        });

        confirmbtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e)
            {
                String message="Dear ["+username+"] This is to confirm that the password for your account has been successfully changed."
                + "\nYour account is now secured with the new password that you have set. "
                + "\nIf you did not change your password, please contact us immediately to report any unauthorized access to your account."
                +"\n\n Truly \n - EASC-Management";
                boolean res=passwordUpdate();
                if(res)
                {
                    boolean result=OTPSending(mailIdTF.getText(),message);
                    if(result)
                    {
                        JOptionPane.showMessageDialog(parentpanel,"Password Update Successful","EASCPRO",JOptionPane.INFORMATION_MESSAGE);
                    }

                }
                else
                {
                    JOptionPane.showMessageDialog(parentpanel,"Password Update failed","EASCPRO",JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }//GEN-LAST:event_forgotpwlblMouseClicked
    
    private void userIdTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userIdTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_userIdTFActionPerformed

    private void resetbtnforForgotpwPanelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetbtnforForgotpwPanelActionPerformed
        // TODO add your handling code here:
        userIdTF.setText("");
        mailIdTF.setText("");
        admintype.setSelectedIndex(0);
    }//GEN-LAST:event_resetbtnforForgotpwPanelActionPerformed

    private void confirmbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_confirmbtnActionPerformed
//
//    public static void main(String args[]) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new LoginFrame().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CRTOTPstslbl;
    private javax.swing.JLabel INCOTPstslbl;
    private javax.swing.JPanel Sign_inPanel;
    private javax.swing.JLabel adminTypelbl;
    private javax.swing.JComboBox<String> admintype;
    private javax.swing.JLabel clglbl2;
    private javax.swing.JLabel clglbl3;
    private javax.swing.JLabel clglbl4;
    private javax.swing.JLabel clglbl5;
    private javax.swing.JTextField confirmPWTF;
    private javax.swing.JButton confirmbtn;
    private javax.swing.JLabel enterOTPlbl;
    private javax.swing.JPanel forgotPWPanel;
    private javax.swing.JLabel forgotpanellbl;
    private javax.swing.JLabel forgotpwlbl;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lbl1;
    private javax.swing.JLabel lbl2;
    private javax.swing.JLabel lbl3;
    private javax.swing.JTextField mailIdTF;
    private javax.swing.JLabel mailidlbl;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JTextField newPWTF;
    private javax.swing.JLabel newPWlbl;
    private javax.swing.JTextField otpTF;
    private javax.swing.JLabel otpsendingstslbl;
    private javax.swing.JPanel otpstspanel;
    private javax.swing.JLabel panel1;
    private javax.swing.JPanel parentpanel;
    private javax.swing.JPasswordField pwTF;
    private javax.swing.JLabel reEnterPWlbl;
    private javax.swing.JButton resetbtn1;
    private javax.swing.JButton resetbtnforForgotpwPanel;
    private javax.swing.JButton sendbtn;
    private javax.swing.JTextField uidTF;
    private javax.swing.JTextField userIdTF;
    private javax.swing.JLabel userIdlbl;
    private javax.swing.JButton verifyOTPbtn;
    private javax.swing.JButton verifybtn;
    private javax.swing.JLabel wellbl;
    // End of variables declaration//GEN-END:variables
}
