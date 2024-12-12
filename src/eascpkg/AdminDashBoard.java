package eascpkg;

import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;
import java.util.Random;
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
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class AdminDashBoard extends javax.swing.JFrame {

    String adminname, adminmail, adminmob, adminpic = "", adminaddress, admindesignation, adminyoj, admintype;
    static String date;
    static Image profileimg;
    static int OTPforStaffAdmission;
    static int random_Number;
    public AdminDashBoard() {
        initComponents();

        // Connect to the database and fetch admin details
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q1 = "select * from admindetails where adminid=?";
            PreparedStatement ps1 = con.prepareStatement(q1);
            ps1.setString(1, LoginFrame.userID);
            ResultSet rs1 = ps1.executeQuery();

            // Load admin details if present in the database
            if (rs1.next()) {
                adminpic = rs1.getString("adminPic");
                adminname = rs1.getString("adminname");
                adminaddress = rs1.getString("adminaddress");
                adminmail = rs1.getString("adminMail");
                adminmob = rs1.getString("adminMob");
                admindesignation = rs1.getString("admindesignation");
                adminyoj = rs1.getString("YOJ");
                admintype = rs1.getString("admintype");

                // Set labels with fetched data
                usernamelbl.setText(adminname);
                deptlbl.setText(admindesignation);
                useridlbl.setText(LoginFrame.userID);

            } else {
                System.out.println("Data not Fetched..!");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(AdminDashBoard.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Load and set font styles for components
        try {
            File fontstl1 = new File("D:\\Font Styles\\Poppins\\Poppins-Medium.ttf");
            Font f1 = Font.createFont(Font.TRUETYPE_FONT, fontstl1).deriveFont(18f);
            Font f2 = Font.createFont(Font.TRUETYPE_FONT, fontstl1).deriveFont(14f);
            Font f3 = Font.createFont(Font.TRUETYPE_FONT, fontstl1).deriveFont(12f);

            // Set fonts for various UI components
            clglbl3.setFont(f3);
            clglbl4.setFont(f3);
            clglbl2.setFont(f3);
            clglbl.setFont(f2);
            usernamelbl.setFont(f3);
            useridlbl.setFont(f3);
            deptlbl.setFont(f3);
            profilelbl.setFont(f3);
            schedulelbl.setFont(f3);
            leavelbl.setFont(f3);
            logoutlbl.setFont(f1);
            loggedlbl.setFont(f1);
            admissionlblforMenupanel.setFont(f3);
            jLabel19.setFont(f1);
            academicInfromationlbl.setFont(f2);
            newfacultyNamelbl.setFont(f3);
            newfacultynameTF.setFont(f3);
            facultyTeachingTypeCB.setFont(f3);
            facultyDeptCB.setFont(f3);
            deptlblforAdmission.setFont(f3);
            facultyTeachingTypelbl.setFont(f3);
            facultydesignationlCB.setFont(f3);
            facultydesignationlblforAdmissionlbl.setFont(f3);
            facultymailIdlblforAdmission.setFont(f3);
            facultymailidforadmisssionTF.setFont(f3);
            facultymobilelblforAdmission.setFont(f3);
            facultymobileforAdmissionTF.setFont(f3);
            otpverificationlbl.setFont(f2);
            otplblforAdmissionStaff.setFont(f3);
            otpTFforAdmissionStaff.setFont(f3);
            verifybtnforAdmissionStaff.setFont(f3);
            createidbtnforStaff.setFont(f3);
            stslblforcreateStaffID.setFont(f2);
            collegelbl.setFont(f1);
            admindashboardlbl.setFont(f2);
            profileinolbl.setFont(f1);
            unamelblforprofile.setFont(f3);
            designationlabelforprofile.setFont(f3);
            UIDlblforprofile.setFont(f3);
            addlblforprofile.setFont(f2);
            emailidlblforprofile.setFont(f2);
            mobilelblforprofile.setFont(f2);
            addresslblforprofile.setFont(f3);
            mobTFforprofile.setFont(f3);
            mailidTFforprofile.setFont(f3);
            leavemanagementlbl.setFont(f2);
            avgintimelbl.setFont(f3);
            avgouttimelbl.setFont(f3);
            intime.setFont(f3);
            outtime.setFont(f3);
            jLabel9.setFont(f3);
            jLabel6.setFont(f3);
            totalLeavelbl.setFont(f3);
            jLabel8.setFont(f3);
            takenLeavelbl.setFont(f3);
            availableLeavelbl.setFont(f3);
            yojlblforprofile.setFont(f3);
            yojforprofile.setFont(f3);
            lbl1forprofile.setFont(f3);
            lbl2forprofile.setFont(f3);
            lbl3forprofile.setFont(f3);
            typelblforprofile.setFont(f3);
            typeforprofile.setFont(f3);
            academicInfolbl.setFont(f2);
            schoolingInfolbl.setFont(f3);
            collegeInfolbl.setFont(f3);
            schoolingInfolblforparentPanel.setFont(f2);
            sslclbl.setFont(f2);
            hsclbl.setFont(f2);
            schoollbl10.setFont(f3);
            boardlbl10.setFont(f3);
            scorelbl10.setFont(f3);
            school10.setFont(f3);
            board10.setFont(f3);
            score10.setFont(f3);
            schoollbl12.setFont(f3);
            boardlbl12.setFont(f3);
            scorelbl12.setFont(f3);
            school12.setFont(f3);
            board12.setFont(f3);
            score12.setFont(f3);
            collegeInfolblforParentPanel.setFont(f2);
            clgnamelbl1.setFont(f3);
            universitynamelbl.setFont(f3);
            aggregatelbl.setFont(f3);
            clgnameforug1.setFont(f3);
            universitynameforug1.setFont(f3);
            aggregateforug1.setFont(f3);
            uglbl.setFont(f3);
            degree.setFont(f3);
            deglbl.setFont(f3);
            yopforug1.setFont(f3);
            yoplbl.setFont(f3);
            majorforug1.setFont(f3);
            majorlbl1.setFont(f3);
            lblfordefaultpanelacademic.setFont(f2);
            sendOTPbtn.setFont(f3);
            stfadmissionmanagmentlbl.setFont(f2);
            adminnamelbl.setFont(f3);
            admissionlblforStaff.setFont(f3);
            admissionlblforStd.setFont(f3);
            admissionlblforpanel.setFont(f2);
            adminNameforAdmissionStaff.setFont(f3);
            adminlDlbl.setFont(f3);
            adminIDforadmissionStaff.setFont(f3);
            admissionDatelalb.setFont(f3);
            dateforStaffAdmission.setFont(f3);
            timelbl.setFont(f3);
            timeforStaffAdmission.setFont(f3);
            academicInfromationlbl.setFont(f3);

        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Load and set images for profile picture and logo
        ImageIcon bgimgaddress = new ImageIcon("D:\\netBeans\\EASCPRJ-ADMIN\\src\\Resources\\ClgImg.png");
        Image bgimage = bgimgaddress.getImage();
        Image backimg = bgimage.getScaledInstance(940, 420, bgimage.SCALE_SMOOTH);
        parentpanelbgimg.setIcon(new ImageIcon(backimg));

        ImageIcon logo1 = new ImageIcon("D:\\netBeans\\EASCPRJ-ADMIN\\src\\Resources\\clglogo1.png");
        Image img1 = logo1.getImage();
        Image scimg1 = img1.getScaledInstance(90, 90, img1.SCALE_SMOOTH);
        clglogo1.setIcon(new ImageIcon(scimg1));

        // Menu bar creation with profile, communication, and report options
        JMenuBar mb1 = new JMenuBar();

        JMenu profilemenu = new JMenu("Profile Management");
        mb1.add(profilemenu);
        JMenuItem personalinfo = new JMenuItem("Personal Info");
        profilemenu.add(personalinfo);
        JMenuItem academicinfo = new JMenuItem("Academic Information");
        profilemenu.add(academicinfo);
        JMenuItem leavemanagement = new JMenuItem("Leave Management");
        profilemenu.add(leavemanagement);
        JMenuItem stftimetable = new JMenuItem("Admin Time Table");
        profilemenu.add(stftimetable);

        JMenuItem quit = new JMenuItem("Quit");
        quit.setMnemonic('x');
        profilemenu.add(quit);

        // Quit action to confirm before exiting the application
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = JOptionPane.showConfirmDialog(parentPanel, "Are You Sure want to Quit ?", "EASCPRO", 2);
                if (res == 0) {
                    System.exit(0);
                }
            }
        });

        // Additional menu items for communication and reports
        JMenu communication = new JMenu("Communication");
        mb1.add(communication);
        JMenuItem notice = new JMenuItem("Notices");
        communication.add(notice);
        JMenuItem stdQueries = new JMenuItem("Student Queries");
        communication.add(stdQueries);

        JMenu report = new JMenu("Reports");
        mb1.add(report);
        JMenuItem genReport = new JMenuItem("Generate Reports");
        report.add(genReport);
        JMenuItem downloadReport = new JMenuItem("Download Report");
        report.add(downloadReport);

        // Frame setup and properties
        setTitle("EASCPRO-ADMIN");
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\netBeans\\EASCPRJ-ADMIN\\src\\Resources\\clglogo1.png"));
        setJMenuBar(mb1);
        setExtendedState(MAXIMIZED_BOTH);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    int seconds = 0;

    // Method to fetch and format current time
    public String timeManagement() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        DateTimeFormatter secFormatter = DateTimeFormatter.ofPattern("ss");
        String time = timeFormatter.format(localDate);
        String secStr = secFormatter.format(localDate);
        int sec = Integer.parseInt(secStr);
        seconds = sec * 1000;
        return time;
    }

    // Thread to update time every minute
    private void threadTimeManagement() {
        Thread incrementThread = new Thread(() -> {
            boolean running = true;
            while (running) {
                timeManagement();
                try {
                    Thread.sleep(60000 - seconds); // Sleep for 60 seconds
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        });
        incrementThread.start();
    }

    // Method to fetch and format current date
    public String DateManagement() {
        LocalDateTime localDate = LocalDateTime.now();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy");
        date = dateFormatter.format(localDate);
        return date;
    }

    // Method to generate scaled profile image
    private Image userProfileImagegenerate(int x, int y) {
        ImageIcon img_source = new ImageIcon(adminpic);
        Image img = img_source.getImage();
        profileimg = img.getScaledInstance(x, y, img.SCALE_SMOOTH);
        return profileimg;
    }

    // Method to display personal information on the profile panel
    private void personal_info() {
        parentPanel.removeAll();
        parentPanel.add(profilePanel);
        parentPanel.repaint();
        parentPanel.revalidate();

        // Update profile fields with admin data
        addresslblforprofile.setLineWrap(true);
        addresslblforprofile.setText(adminaddress);
        addresslblforprofile.setMargin(new Insets(10, 10, 10, 10));
        mobTFforprofile.setText("+91 " + adminmob);
        mailidTFforprofile.setText(adminmail);
        imglbl.setIcon(new ImageIcon(userProfileImagegenerate(150, 200)));
        unamelblforprofile.setText(adminname);
        designationlabelforprofile.setText(admindesignation);
        UIDlblforprofile.setText(LoginFrame.userID);
        yojforprofile.setText(adminyoj);
        typeforprofile.setText(admintype);
        ImageIcon editlogoimgadd = new ImageIcon("D:\\netBeans\\EASCPRJ-ADMIN\\src\\Resources\\editlogo.png");
        Image image = editlogoimgadd.getImage();
        Image res = image.getScaledInstance(30, 20, image.SCALE_SMOOTH);
        editlogoimg1.setIcon(new ImageIcon(res));
        editlogoimg2.setIcon(new ImageIcon(res));
        editlogoimg3.setIcon(new ImageIcon(res));
    }

    // Method to switch to academic info panel
    public void academicInfo() {
        parentPanel.removeAll();
        parentPanel.add(academicInfo);
        parentPanel.repaint();
        parentPanel.revalidate();
    }

    void leaveManagement() {
        parentPanel.removeAll();
        parentPanel.add(leavemanagement);
        parentPanel.repaint();
        parentPanel.revalidate();
        applyleavebtnforattendance.setEnabled(false);
        designationforleavemanagementlbl.setText(admindesignation);
        cancelleavebtnforattendance.setEnabled(false);
        unamelblforattendance.setText(adminname);
        typelblforattendace.setText(admintype);
        useridlblforattendancepanel.setText(LoginFrame.userID);
        profilepicforattendancepanel.setIcon(new ImageIcon(userProfileImagegenerate(140, 170)));
        try {
            int takenLeave, availableLeave = 0, totalLeave;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q = "select * from adminLeaveManagement where adminId=?";
            PreparedStatement ps1 = con.prepareStatement(q);
            ps1.setString(1, LoginFrame.userID);
            ResultSet rs1 = ps1.executeQuery();

            if (rs1.next()) {
                takenLeave = rs1.getInt("takenLeave");
                totalLeave = rs1.getInt("totalLeave");

                takenLeavelbl.setText(String.valueOf(takenLeave));
                totalLeavelbl.setText(String.valueOf(totalLeave));

                if (takenLeave < totalLeave) {
                    availableLeave = totalLeave - takenLeave;
                    applyleavebtnforattendance.setBackground(new Color(82, 155, 255));
                    cancelleavebtnforattendance.setBackground(new Color(82, 155, 255));
                    applyleavebtnforattendance.setForeground(Color.black);
                    cancelleavebtnforattendance.setForeground(Color.black);
                    applyleavebtnforattendance.setEnabled(true);
                    cancelleavebtnforattendance.setEnabled(true);
                    availableLeavelbl.setText(String.valueOf(availableLeave));
                } else {
                    availableLeavelbl.setText(String.valueOf(availableLeave));
                }
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void schoolingInfo() {
        parentpanel.removeAll();
        parentpanel.add(schoolingInfoPanel);
        parentpanel.repaint();
        parentpanel.revalidate();

        profilepicforsclinfo.setIcon(new ImageIcon(userProfileImagegenerate(160, 200)));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q = "select * from adminschooling where adminid=?";
            PreparedStatement ps1 = con.prepareStatement(q);
            ps1.setString(1, LoginFrame.userID);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                school10.setText(rs.getString("school"));
                board10.setText(rs.getString("boardSSLC"));
                score10.setText(rs.getString("sslc"));

                school12.setText(rs.getString("schoolHSC"));
                board12.setText(rs.getString("board"));
                score12.setText(rs.getString("hsc"));
            } else {
                JOptionPane.showMessageDialog(parentPanel, "Invalid User Data ..!", "EASCPRO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    private void collegeInfo() {
        parentpanel.removeAll();
        parentpanel.add(collegeInfoPanel);
        parentpanel.repaint();
        parentpanel.revalidate();

        profilepicforclginfo.setIcon(new ImageIcon(userProfileImagegenerate(160, 200)));
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q = "select * from staffcollege where staffid=?";
            PreparedStatement ps1 = con.prepareStatement(q);
            ps1.setString(1, LoginFrame.userID);
            ResultSet rs = ps1.executeQuery();
            if (rs.next()) {
                degree.setText(rs.getString("staffdegree"));
                majorforug1.setText(rs.getString("major"));
                clgnameforug1.setText(rs.getString("collegename"));
                universitynameforug1.setText(rs.getString("university"));
                aggregateforug1.setText(rs.getString("percentage") + " %");
                yopforug1.setText(rs.getString("yop"));
            } else {
                JOptionPane.showMessageDialog(parentPanel, "Invalid User Data ..!", "EASCPRO", JOptionPane.ERROR_MESSAGE);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    int OTPGenerate() {
        Random rand = new Random();
        random_Number = 100000 + rand.nextInt(900000);
        return random_Number;
    }

    boolean emailSending(String toAdd, String msg) {
        boolean res = false;
        String to = toAdd;
        String subject = "EASCPRO-Password Authentication";
        String from = "boobalanvellingiri@gmail.com";
        String passKey = "ryvk nuuq kdwt peii";
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
        try {
            Message mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(from));
            mimeMessage.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            mimeMessage.setSubject(subject);
            mimeMessage.setText(msg);
            Transport.send(mimeMessage);
            res = true;
        } catch (MessagingException e) {
            JOptionPane.showMessageDialog(parentpanel, "Email Sending Error: "+e.getMessage(), "EmailSender", 2);
        }
        return res;
    }

    private void admissionStaff() {

        timeforStaffAdmission.setText(timeManagement());
        dateforStaffAdmission.setText(DateManagement());
        adminNameforAdmissionStaff.setText(adminname);
        adminIDforadmissionStaff.setText(LoginFrame.userID);
        facultyDeptCB.removeAll();
        facultyTeachingTypeCB.removeAll();
        facultydesignationlCB.removeAll();
        facultyTeachingTypeCB.addItem("Teaching");
        facultyTeachingTypeCB.addItem("Non-Teaching");
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
            String q = "select * from designations";
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs1 = stmt.executeQuery(q);
            if (rs1.first()) {
                facultydesignationlCB.addItem(rs1.getString("designation"));
                while (rs1.next()) {
                    facultydesignationlCB.addItem(rs1.getString("designation"));
                }
            } else {
                System.out.println("Data nto Fetched..!");
            }

            String q1 = "select * from departments";
            Statement stmt1 = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet rs2 = stmt1.executeQuery(q1);
            if (rs2.first()) {
                facultyDeptCB.addItem(rs2.getString("deptname"));
                while (rs2.next()) {
                    facultyDeptCB.addItem(rs2.getString("deptname"));
                }
            } else {
                System.out.println("Data nto Fetched..!");
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        sendOTPbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if ((newfacultynameTF.getText().equals("") || facultyDeptCB.getSelectedItem().toString().equals("-") || facultymobileforAdmissionTF.getText().equals("")
                        || facultymailidforadmisssionTF.getText().equals("") || facultydesignationlCB.getSelectedItem().toString().equals("-") || facultyTeachingTypeCB.getSelectedItem().toString().equals("-"))) {
                    JOptionPane.showMessageDialog(parentPanelforadmission, "Check and fill the all Fields..!", "EASCPRO-ADMIN", JOptionPane.ERROR_MESSAGE);
                } else {

                    OTPforStaffAdmission = OTPGenerate();
                    String message = "You have request to Create your EASCPRO account \n"
                            + "\n" + "Your Confirmation code is \n" + OTPforStaffAdmission + "\n" + "\n\n\n\nTruly,\n" + "-EASCPRO-Management";

                    boolean res = emailSending(facultymailidforadmisssionTF.getText(), message);
                    if (res) {
                        JOptionPane.showMessageDialog(parentPanelforadmission, "OTP Sent Successful..!", "EASCPRO-STAFF", JOptionPane.INFORMATION_MESSAGE);
                        sendOTPbtn.setEnabled(false);
                        newfacultynameTF.setEnabled(false);
                        facultyDeptCB.setEnabled(false);
                        facultyTeachingTypeCB.setEnabled(false);
                        facultydesignationlCB.setEnabled(false);
                        facultymailidforadmisssionTF.setEnabled(false);
                        facultymobileforAdmissionTF.setEnabled(false);
                        verifybtnforAdmissionStaff.setEnabled(res);
                        otpTFforAdmissionStaff.setEnabled(res);
                    } else {
                        JOptionPane.showMessageDialog(parentPanelforadmission, "OTP Sent Failure..!", "EASCPRO-STAFF", JOptionPane.INFORMATION_MESSAGE);
                    }
                    verifybtnforAdmissionStaff.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (!otpTFforAdmissionStaff.equals("")) {
                                String otp = otpTFforAdmissionStaff.getText();
                                if (OTPforStaffAdmission == Integer.parseInt(otp)) {
                                    JOptionPane.showMessageDialog(parentPanelforadmission, "OTP Verification Complete..!", "EASCPRO-ADMIN", JOptionPane.ERROR_MESSAGE);
                                    verifybtnforAdmissionStaff.setEnabled(false);
                                    otpTFforAdmissionStaff.setEnabled(false);
                                    createidbtnforStaff.setEnabled(true);
                                } else {
                                    JOptionPane.showMessageDialog(parentPanelforadmission, "OTP is Incorrect", "EASCPRO-ADMIN", JOptionPane.ERROR_MESSAGE);
                                }
                            } else {
                                JOptionPane.showMessageDialog(parentPanelforadmission, "Fill the OTP Field..!", "EASCPRO-ADMIN", JOptionPane.ERROR_MESSAGE);
                            }

                        }
                    });

                    createidbtnforStaff.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            try {
                                Class.forName("com.mysql.cj.jdbc.Driver");
                                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                                String q = "select * from loginforstaff";
                                Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                                ResultSet rs1 = stmt.executeQuery(q);
                                if (rs1.next()) {
                                    rs1.last();
                                    String stfid = rs1.getString("staffID");
                                    int sno = rs1.getInt("idno") + 1;
                                    System.out.println("Here 1" + sno);
                                    String newID = staffID_generate(sno);
                                    int pw = 1000 + (sno);
                                    String newPW = String.valueOf(pw);
                                    String confirmationmessege = "Your EASCPRO-STAFF Account Created Successfully... \nYour User ID is: " + newID + "\nYour Password is:" + newPW
                                            + "\n\nEASCPRO-ADMIN\n\t-- " + adminname;
                                    if (!newID.equals("")) {
                                        try {
                                            Class.forName("com.mysql.cj.jdbc.Driver");
                                            Connection con1 = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                                            String q1 = "insert into loginforstaff values (?,?,?,?,?,?)";
                                            PreparedStatement ps = con.prepareStatement(q1);
                                            System.out.println(sno);
                                            ps.setInt(1, sno);
                                            ps.setString(2, newID);
                                            ps.setString(3, newfacultynameTF.getText());
                                            ps.setString(4, facultymailidforadmisssionTF.getText());
                                            ps.setString(5, newPW);
                                            ps.setString(6, facultyDeptCB.getSelectedItem().toString());
                                            boolean res = ps.execute();
                                            if (!res) {
                                                boolean res1 = emailSending(facultymailidforadmisssionTF.getText(), confirmationmessege);
                                                if (res1) {
                                                    JOptionPane.showMessageDialog(parentPanelforadmission, "StaffID Successfully Sent To Staff Mail Account..!", "EASCPRO-ADMIN", JOptionPane.INFORMATION_MESSAGE);
                                                    createidbtnforStaff.setEnabled(false);
                                                } else {
                                                    JOptionPane.showMessageDialog(parentPanelforadmission, "ID Creation is Failure..!", "EASCPRO-ADMIN", JOptionPane.INFORMATION_MESSAGE);
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(parentPanelforadmission, "StaffID Creation Process Failed..!Try Again", "EASCPRO-ADMIN", JOptionPane.INFORMATION_MESSAGE);
                                            }
                                        } catch (ClassNotFoundException | SQLException e1) {

                                        }
                                    } else {
                                        JOptionPane.showMessageDialog(parentPanelforadmission, "ID Creation is Failure..!", "EASCPRO-ADMIN", JOptionPane.INFORMATION_MESSAGE);
                                    }

                                } else {
                                    System.out.println("Data nto Fetched..!");
                                }
                            } catch (ClassNotFoundException | SQLException e1) {
                                e1.printStackTrace();
                            }
                        }
                    });

                }
            }
        });
    }

    String staffID_generate(int sno) {
        String newID = "";
        if (sno < 10) {
            newID = "easc100" + sno;
        } else {
            newID = "easc10" + sno;
        }
        return newID;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainpanel = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        clglbl = new javax.swing.JLabel();
        clglbl4 = new javax.swing.JLabel();
        clglbl2 = new javax.swing.JLabel();
        clglbl3 = new javax.swing.JLabel();
        clglogo1 = new javax.swing.JLabel();
        menupanel = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        loggedlbl = new javax.swing.JLabel();
        usernamelbl = new javax.swing.JLabel();
        useridlbl = new javax.swing.JLabel();
        deptlbl = new javax.swing.JLabel();
        logoutlbl = new javax.swing.JLabel();
        profilelbl = new javax.swing.JLabel();
        schedulelbl = new javax.swing.JLabel();
        leavelbl = new javax.swing.JLabel();
        admissionlblforMenupanel = new javax.swing.JLabel();
        parentPanel = new javax.swing.JPanel();
        welcomepanel = new javax.swing.JPanel();
        collegelbl = new javax.swing.JLabel();
        admindashboardlbl = new javax.swing.JLabel();
        bgpanel = new javax.swing.JPanel();
        parentpanelbgimg = new javax.swing.JLabel();
        profilePanel = new javax.swing.JPanel();
        imglbl = new javax.swing.JLabel();
        lbl1forprofile = new javax.swing.JLabel();
        lbl2forprofile = new javax.swing.JLabel();
        lbl3forprofile = new javax.swing.JLabel();
        UIDlblforprofile = new javax.swing.JLabel();
        designationlabelforprofile = new javax.swing.JLabel();
        unamelblforprofile = new javax.swing.JLabel();
        profileinolbl = new javax.swing.JLabel();
        addlblforprofile = new javax.swing.JLabel();
        addresslblforprofile = new javax.swing.JTextArea();
        emailidlblforprofile = new javax.swing.JLabel();
        mailidTFforprofile = new javax.swing.JTextField();
        mobilelblforprofile = new javax.swing.JLabel();
        mobTFforprofile = new javax.swing.JTextField();
        editlogoimg1 = new javax.swing.JLabel();
        editlogoimg2 = new javax.swing.JLabel();
        editlogoimg3 = new javax.swing.JLabel();
        yojlblforprofile = new javax.swing.JLabel();
        yojforprofile = new javax.swing.JLabel();
        typelblforprofile = new javax.swing.JLabel();
        typeforprofile = new javax.swing.JLabel();
        leavemanagement = new javax.swing.JPanel();
        leavemanagementlbl = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        profilepicforattendancepanel = new javax.swing.JLabel();
        unamelblforattendance = new javax.swing.JLabel();
        typelblforattendace = new javax.swing.JLabel();
        useridlblforattendancepanel = new javax.swing.JLabel();
        designationforleavemanagementlbl = new javax.swing.JLabel();
        jPanel17 = new javax.swing.JPanel();
        applyleavebtnforattendance = new javax.swing.JButton();
        cancelleavebtnforattendance = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        totalLeavelbl = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        takenLeavelbl = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        availableLeavelbl = new javax.swing.JLabel();
        avgintimelbl = new javax.swing.JLabel();
        intime = new javax.swing.JLabel();
        outtime = new javax.swing.JLabel();
        avgouttimelbl = new javax.swing.JLabel();
        academicInfo = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        academicInfolbl = new javax.swing.JLabel();
        schoolingInfolbl = new javax.swing.JLabel();
        collegeInfolbl = new javax.swing.JLabel();
        parentpanel = new javax.swing.JPanel();
        defaultPanel = new javax.swing.JPanel();
        lblfordefaultpanelacademic = new javax.swing.JLabel();
        schoolingInfoPanel = new javax.swing.JPanel();
        schoolingInfolblforparentPanel = new javax.swing.JLabel();
        sslclbl = new javax.swing.JLabel();
        schoollbl10 = new javax.swing.JLabel();
        boardlbl10 = new javax.swing.JLabel();
        scorelbl10 = new javax.swing.JLabel();
        hsclbl = new javax.swing.JLabel();
        schoollbl12 = new javax.swing.JLabel();
        boardlbl12 = new javax.swing.JLabel();
        scorelbl12 = new javax.swing.JLabel();
        school10 = new javax.swing.JLabel();
        board10 = new javax.swing.JLabel();
        score10 = new javax.swing.JLabel();
        school12 = new javax.swing.JLabel();
        board12 = new javax.swing.JLabel();
        score12 = new javax.swing.JLabel();
        profilepicforsclinfo = new javax.swing.JLabel();
        collegeInfoPanel = new javax.swing.JPanel();
        collegeInfolblforParentPanel = new javax.swing.JLabel();
        uglbl = new javax.swing.JLabel();
        clgnamelbl1 = new javax.swing.JLabel();
        universitynamelbl = new javax.swing.JLabel();
        aggregatelbl = new javax.swing.JLabel();
        clgnameforug1 = new javax.swing.JLabel();
        universitynameforug1 = new javax.swing.JLabel();
        aggregateforug1 = new javax.swing.JLabel();
        deglbl = new javax.swing.JLabel();
        degree = new javax.swing.JLabel();
        yoplbl = new javax.swing.JLabel();
        yopforug1 = new javax.swing.JLabel();
        majorforug1 = new javax.swing.JLabel();
        majorlbl1 = new javax.swing.JLabel();
        profilepicforclginfo = new javax.swing.JLabel();
        admissionPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        admissionlblforpanel = new javax.swing.JLabel();
        admissionlblforStaff = new javax.swing.JLabel();
        admissionlblforStd = new javax.swing.JLabel();
        parentPanelforadmission = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        defaultlblforAttenadancemanagement = new javax.swing.JLabel();
        StaffadmissionPanel = new javax.swing.JPanel();
        stfadmissionmanagmentlbl = new javax.swing.JLabel();
        adminnamelbl = new javax.swing.JLabel();
        adminNameforAdmissionStaff = new javax.swing.JLabel();
        adminlDlbl = new javax.swing.JLabel();
        adminIDforadmissionStaff = new javax.swing.JLabel();
        admissionDatelalb = new javax.swing.JLabel();
        timelbl = new javax.swing.JLabel();
        dateforStaffAdmission = new javax.swing.JLabel();
        timeforStaffAdmission = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        newfacultyNamelbl = new javax.swing.JLabel();
        newfacultynameTF = new javax.swing.JTextField();
        facultymailIdlblforAdmission = new javax.swing.JLabel();
        facultymailidforadmisssionTF = new javax.swing.JTextField();
        facultymobilelblforAdmission = new javax.swing.JLabel();
        facultymobileforAdmissionTF = new javax.swing.JTextField();
        facultyTeachingTypelbl = new javax.swing.JLabel();
        facultyTeachingTypeCB = new javax.swing.JComboBox<>();
        deptlblforAdmission = new javax.swing.JLabel();
        facultyDeptCB = new javax.swing.JComboBox<>();
        facultydesignationlblforAdmissionlbl = new javax.swing.JLabel();
        facultydesignationlCB = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        academicInfromationlbl = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        otpverificationlbl = new javax.swing.JLabel();
        otplblforAdmissionStaff = new javax.swing.JLabel();
        otpTFforAdmissionStaff = new javax.swing.JTextField();
        verifybtnforAdmissionStaff = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        createidbtnforStaff = new javax.swing.JButton();
        stslblforcreateStaffID = new javax.swing.JLabel();
        sendOTPbtn = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        II_ct_attendance1 = new javax.swing.JLabel();
        clsinchargenamelblICT = new javax.swing.JLabel();
        submitbtnforAttendance1 = new javax.swing.JButton();
        facultynamelblICT = new javax.swing.JLabel();
        facultynameIICT = new javax.swing.JLabel();
        facultyIDlblIICT = new javax.swing.JLabel();
        facultyIICT = new javax.swing.JLabel();
        paperhandlelblIICT = new javax.swing.JLabel();
        paperCBIICT = new javax.swing.JComboBox<>();
        hourlblIICT = new javax.swing.JLabel();
        hourCBIICT = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainpanel.setLayout(null);

        jPanel1.setBackground(new java.awt.Color(82, 155, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        clglbl.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        clglbl.setForeground(new java.awt.Color(255, 255, 255));
        clglbl.setText("ERODE ARTS AND SCIENCE COLLEGE");
        jPanel1.add(clglbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 280, 30));

        clglbl4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clglbl4.setForeground(new java.awt.Color(255, 255, 255));
        clglbl4.setText("Erode-638 009.");
        jPanel1.add(clglbl4, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 170, -1));

        clglbl2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clglbl2.setForeground(new java.awt.Color(255, 255, 255));
        clglbl2.setText("Affiliated to Bharathiar University");
        jPanel1.add(clglbl2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 260, -1));

        clglbl3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        clglbl3.setForeground(new java.awt.Color(255, 255, 255));
        clglbl3.setText("Autonomous (Co-Education)");
        jPanel1.add(clglbl3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 230, -1));
        jPanel1.add(clglogo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 100));

        mainpanel.add(jPanel1);
        jPanel1.setBounds(1, 2, 1533, 140);

        menupanel.setBackground(new java.awt.Color(82, 155, 255));
        menupanel.setLayout(null);

        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Shortcuts");
        menupanel.add(jLabel19);
        jLabel19.setBounds(0, 20, 200, 20);

        loggedlbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        loggedlbl.setForeground(new java.awt.Color(255, 255, 255));
        loggedlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        loggedlbl.setText("Logged In");
        menupanel.add(loggedlbl);
        loggedlbl.setBounds(0, 410, 200, 30);

        usernamelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usernamelbl.setText("UserName");
        usernamelbl.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        menupanel.add(usernamelbl);
        usernamelbl.setBounds(0, 450, 200, 30);

        useridlbl.setBackground(new java.awt.Color(82, 105, 255));
        useridlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        useridlbl.setText("User-Id");
        menupanel.add(useridlbl);
        useridlbl.setBounds(0, 480, 200, 30);

        deptlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deptlbl.setText("Department");
        menupanel.add(deptlbl);
        deptlbl.setBounds(0, 510, 200, 30);

        logoutlbl.setForeground(new java.awt.Color(255, 255, 255));
        logoutlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        logoutlbl.setText("Logout");
        logoutlbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        logoutlbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logoutlblMouseClicked(evt);
            }
        });
        menupanel.add(logoutlbl);
        logoutlbl.setBounds(0, 610, 200, 30);

        profilelbl.setText("Profile Info");
        profilelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        profilelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                profilelblMouseClicked(evt);
            }
        });
        menupanel.add(profilelbl);
        profilelbl.setBounds(10, 60, 190, 30);

        schedulelbl.setText("Schedule");
        schedulelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        schedulelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                schedulelblMouseClicked(evt);
            }
        });
        menupanel.add(schedulelbl);
        schedulelbl.setBounds(10, 90, 190, 30);

        leavelbl.setText("Leave Management");
        leavelbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        leavelbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leavelblMouseClicked(evt);
            }
        });
        menupanel.add(leavelbl);
        leavelbl.setBounds(10, 120, 190, 30);

        admissionlblforMenupanel.setText("Admission Entry");
        admissionlblforMenupanel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admissionlblforMenupanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admissionlblforMenupanelMouseClicked(evt);
            }
        });
        menupanel.add(admissionlblforMenupanel);
        admissionlblforMenupanel.setBounds(10, 150, 190, 30);

        mainpanel.add(menupanel);
        menupanel.setBounds(1, 144, 200, 670);

        parentPanel.setBackground(new java.awt.Color(255, 51, 255));
        parentPanel.setLayout(new java.awt.CardLayout());

        welcomepanel.setBackground(java.awt.Color.white);
        welcomepanel.setLayout(null);

        collegelbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collegelbl.setText("ERODE ARTS AND SCIENCE COLLEGE (AUOTNOMOUS)");
        welcomepanel.add(collegelbl);
        collegelbl.setBounds(430, 0, 510, 130);

        admindashboardlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admindashboardlbl.setText("Affiliated to Bharathiar University, Coimbatore.");
        welcomepanel.add(admindashboardlbl);
        admindashboardlbl.setBounds(460, 70, 470, 50);

        bgpanel.setLayout(new java.awt.BorderLayout());
        bgpanel.add(parentpanelbgimg, java.awt.BorderLayout.CENTER);

        welcomepanel.add(bgpanel);
        bgpanel.setBounds(180, 170, 940, 420);

        parentPanel.add(welcomepanel, "card11");

        profilePanel.setBackground(java.awt.Color.white);
        profilePanel.setLayout(null);

        imglbl.setBackground(new java.awt.Color(204, 204, 255));
        profilePanel.add(imglbl);
        imglbl.setBounds(360, 120, 150, 200);

        lbl1forprofile.setText("User Name");
        profilePanel.add(lbl1forprofile);
        lbl1forprofile.setBounds(570, 120, 100, 20);

        lbl2forprofile.setText("Desgination");
        profilePanel.add(lbl2forprofile);
        lbl2forprofile.setBounds(570, 200, 100, 20);

        lbl3forprofile.setText("User ID");
        profilePanel.add(lbl3forprofile);
        lbl3forprofile.setBounds(570, 160, 100, 20);

        UIDlblforprofile.setText("User ID");
        profilePanel.add(UIDlblforprofile);
        UIDlblforprofile.setBounds(690, 160, 200, 20);

        designationlabelforprofile.setText("Designation");
        profilePanel.add(designationlabelforprofile);
        designationlabelforprofile.setBounds(690, 200, 200, 20);

        unamelblforprofile.setText("uname");
        profilePanel.add(unamelblforprofile);
        unamelblforprofile.setBounds(690, 120, 200, 20);

        profileinolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        profileinolbl.setText("Profile Info");
        profilePanel.add(profileinolbl);
        profileinolbl.setBounds(560, 50, 180, 20);

        addlblforprofile.setText("Address");
        profilePanel.add(addlblforprofile);
        addlblforprofile.setBounds(570, 400, 90, 30);

        addresslblforprofile.setBackground(new java.awt.Color(242, 242, 242));
        addresslblforprofile.setColumns(20);
        addresslblforprofile.setRows(5);
        addresslblforprofile.setText("\n");
        addresslblforprofile.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 10));
        addresslblforprofile.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        addresslblforprofile.setEnabled(false);
        profilePanel.add(addresslblforprofile);
        addresslblforprofile.setBounds(690, 400, 220, 90);

        emailidlblforprofile.setText("Email-ID");
        profilePanel.add(emailidlblforprofile);
        emailidlblforprofile.setBounds(570, 320, 90, 30);

        mailidTFforprofile.setText("Mail-ID");
        mailidTFforprofile.setToolTipText("Mail-ID");
        mailidTFforprofile.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 10));
        mailidTFforprofile.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        mailidTFforprofile.setEnabled(false);
        profilePanel.add(mailidTFforprofile);
        mailidTFforprofile.setBounds(690, 320, 220, 30);

        mobilelblforprofile.setText("Mobile");
        profilePanel.add(mobilelblforprofile);
        mobilelblforprofile.setBounds(570, 360, 90, 30);

        mobTFforprofile.setText("+91 ");
        mobTFforprofile.setToolTipText("Mobile");
        mobTFforprofile.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 10));
        mobTFforprofile.setDisabledTextColor(new java.awt.Color(102, 102, 102));
        mobTFforprofile.setEnabled(false);
        profilePanel.add(mobTFforprofile);
        mobTFforprofile.setBounds(690, 360, 220, 30);

        editlogoimg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/editlogo.png"))); // NOI18N
        editlogoimg1.setToolTipText("Edit");
        editlogoimg1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editlogoimg1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editlogoimg1MouseClicked(evt);
            }
        });
        profilePanel.add(editlogoimg1);
        editlogoimg1.setBounds(920, 420, 30, 20);

        editlogoimg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/editlogo.png"))); // NOI18N
        editlogoimg2.setToolTipText("Edit");
        editlogoimg2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editlogoimg2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editlogoimg2MouseClicked(evt);
            }
        });
        profilePanel.add(editlogoimg2);
        editlogoimg2.setBounds(920, 320, 30, 20);

        editlogoimg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Resources/editlogo.png"))); // NOI18N
        editlogoimg3.setToolTipText("Edit");
        editlogoimg3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        editlogoimg3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editlogoimg3MouseClicked(evt);
            }
        });
        profilePanel.add(editlogoimg3);
        editlogoimg3.setBounds(920, 360, 30, 20);

        yojlblforprofile.setText("Year of Joining");
        profilePanel.add(yojlblforprofile);
        yojlblforprofile.setBounds(570, 280, 90, 20);

        yojforprofile.setText("yoj");
        profilePanel.add(yojforprofile);
        yojforprofile.setBounds(690, 280, 90, 20);

        typelblforprofile.setText("Type");
        profilePanel.add(typelblforprofile);
        typelblforprofile.setBounds(570, 240, 120, 20);

        typeforprofile.setText("Type of Admin");
        profilePanel.add(typeforprofile);
        typeforprofile.setBounds(690, 240, 220, 20);

        parentPanel.add(profilePanel, "card3");

        leavemanagement.setBackground(java.awt.Color.white);
        leavemanagement.setLayout(null);

        leavemanagementlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        leavemanagementlbl.setText("Leave Management");
        leavemanagement.add(leavemanagementlbl);
        leavemanagementlbl.setBounds(540, 80, 390, 40);

        jPanel12.setBackground(new java.awt.Color(222, 222, 222));
        jPanel12.setLayout(null);

        jPanel11.setBackground(new java.awt.Color(255, 204, 102));
        jPanel11.setLayout(new java.awt.BorderLayout());
        jPanel11.add(profilepicforattendancepanel, java.awt.BorderLayout.PAGE_END);

        jPanel12.add(jPanel11);
        jPanel11.setBounds(10, 20, 140, 170);

        unamelblforattendance.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unamelblforattendance.setText("User Name");
        jPanel12.add(unamelblforattendance);
        unamelblforattendance.setBounds(160, 30, 170, 30);

        typelblforattendace.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        typelblforattendace.setText("Admin Type");
        jPanel12.add(typelblforattendace);
        typelblforattendace.setBounds(160, 70, 170, 30);

        useridlblforattendancepanel.setBackground(new java.awt.Color(210, 210, 210));
        useridlblforattendancepanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        useridlblforattendancepanel.setText("User ID");
        jPanel12.add(useridlblforattendancepanel);
        useridlblforattendancepanel.setBounds(160, 150, 170, 30);

        designationforleavemanagementlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        designationforleavemanagementlbl.setText("Designation");
        jPanel12.add(designationforleavemanagementlbl);
        designationforleavemanagementlbl.setBounds(160, 110, 170, 30);

        leavemanagement.add(jPanel12);
        jPanel12.setBounds(210, 160, 330, 210);

        jPanel17.setBackground(new java.awt.Color(240, 240, 240));
        jPanel17.setLayout(null);
        leavemanagement.add(jPanel17);
        jPanel17.setBounds(10, 240, 130, 80);

        applyleavebtnforattendance.setBackground(new java.awt.Color(230, 230, 230));
        applyleavebtnforattendance.setText("Apply Leave");
        applyleavebtnforattendance.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        applyleavebtnforattendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                applyleavebtnforattendanceActionPerformed(evt);
            }
        });
        leavemanagement.add(applyleavebtnforattendance);
        applyleavebtnforattendance.setBounds(600, 370, 130, 26);

        cancelleavebtnforattendance.setBackground(new java.awt.Color(230, 230, 230));
        cancelleavebtnforattendance.setText("Cancel Leave");
        cancelleavebtnforattendance.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        cancelleavebtnforattendance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelleavebtnforattendanceActionPerformed(evt);
            }
        });
        leavemanagement.add(cancelleavebtnforattendance);
        cancelleavebtnforattendance.setBounds(780, 370, 130, 26);

        jLabel6.setBackground(new java.awt.Color(210, 210, 210));
        jLabel6.setText("Total Leave");
        leavemanagement.add(jLabel6);
        jLabel6.setBounds(650, 230, 130, 30);

        totalLeavelbl.setBackground(new java.awt.Color(210, 210, 210));
        totalLeavelbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        totalLeavelbl.setText("Leave Days");
        leavemanagement.add(totalLeavelbl);
        totalLeavelbl.setBounds(790, 230, 70, 30);

        jLabel8.setText("Taken Leaves");
        leavemanagement.add(jLabel8);
        jLabel8.setBounds(650, 270, 130, 30);

        takenLeavelbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        takenLeavelbl.setText("N/N");
        leavemanagement.add(takenLeavelbl);
        takenLeavelbl.setBounds(790, 270, 70, 30);

        jLabel9.setText("Available Leaves");
        leavemanagement.add(jLabel9);
        jLabel9.setBounds(650, 310, 130, 30);

        availableLeavelbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        availableLeavelbl.setText("N/N");
        leavemanagement.add(availableLeavelbl);
        availableLeavelbl.setBounds(790, 310, 70, 30);

        avgintimelbl.setText("Average In-Time");
        leavemanagement.add(avgintimelbl);
        avgintimelbl.setBounds(650, 150, 130, 30);

        intime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        intime.setText("9.45 AM");
        leavemanagement.add(intime);
        intime.setBounds(810, 150, 50, 30);

        outtime.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        outtime.setText("5.45 PM");
        leavemanagement.add(outtime);
        outtime.setBounds(810, 190, 50, 30);

        avgouttimelbl.setText("Average Out Time");
        leavemanagement.add(avgouttimelbl);
        avgouttimelbl.setBounds(650, 190, 130, 30);

        parentPanel.add(leavemanagement, "card4");

        academicInfo.setBackground(java.awt.Color.white);
        academicInfo.setLayout(null);

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));
        jPanel4.setLayout(null);

        academicInfolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        academicInfolbl.setText("Academic Information");
        jPanel4.add(academicInfolbl);
        academicInfolbl.setBounds(0, 30, 250, 60);

        schoolingInfolbl.setForeground(new java.awt.Color(102, 102, 255));
        schoolingInfolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolingInfolbl.setText("Schooling Information");
        schoolingInfolbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        schoolingInfolbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                schoolingInfolblMouseClicked(evt);
            }
        });
        jPanel4.add(schoolingInfolbl);
        schoolingInfolbl.setBounds(0, 90, 250, 40);

        collegeInfolbl.setForeground(new java.awt.Color(102, 102, 255));
        collegeInfolbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collegeInfolbl.setText("College Info");
        collegeInfolbl.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        collegeInfolbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                collegeInfolblMouseClicked(evt);
            }
        });
        jPanel4.add(collegeInfolbl);
        collegeInfolbl.setBounds(0, 130, 250, 40);

        academicInfo.add(jPanel4);
        jPanel4.setBounds(0, 0, 250, 650);

        parentpanel.setBackground(new java.awt.Color(212, 212, 212));
        parentpanel.setLayout(new java.awt.CardLayout());

        defaultPanel.setLayout(new java.awt.BorderLayout());

        lblfordefaultpanelacademic.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblfordefaultpanelacademic.setText("Please Select What you need ?");
        defaultPanel.add(lblfordefaultpanelacademic, java.awt.BorderLayout.CENTER);

        parentpanel.add(defaultPanel, "card4");

        schoolingInfoPanel.setLayout(null);

        schoolingInfolblforparentPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        schoolingInfolblforparentPanel.setText("Schooling Information");
        schoolingInfoPanel.add(schoolingInfolblforparentPanel);
        schoolingInfolblforparentPanel.setBounds(0, 20, 1080, 25);

        sslclbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        sslclbl.setText("SSLC");
        schoolingInfoPanel.add(sslclbl);
        sslclbl.setBounds(120, 110, 100, 25);

        schoollbl10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        schoollbl10.setText("School");
        schoolingInfoPanel.add(schoollbl10);
        schoollbl10.setBounds(190, 150, 100, 25);

        boardlbl10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boardlbl10.setText("Board of Study");
        schoolingInfoPanel.add(boardlbl10);
        boardlbl10.setBounds(190, 180, 100, 25);

        scorelbl10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scorelbl10.setText("Score");
        schoolingInfoPanel.add(scorelbl10);
        scorelbl10.setBounds(190, 210, 100, 25);

        hsclbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        hsclbl.setText("HSC");
        schoolingInfoPanel.add(hsclbl);
        hsclbl.setBounds(120, 270, 100, 25);

        schoollbl12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        schoollbl12.setText("School");
        schoolingInfoPanel.add(schoollbl12);
        schoollbl12.setBounds(190, 310, 100, 25);

        boardlbl12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        boardlbl12.setText("Board of Study");
        schoolingInfoPanel.add(boardlbl12);
        boardlbl12.setBounds(190, 350, 100, 25);

        scorelbl12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scorelbl12.setText("Score");
        schoolingInfoPanel.add(scorelbl12);
        scorelbl12.setBounds(190, 390, 100, 25);

        school10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        school10.setText("School Name");
        schoolingInfoPanel.add(school10);
        school10.setBounds(370, 150, 440, 25);

        board10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        board10.setText("Board of Study");
        schoolingInfoPanel.add(board10);
        board10.setBounds(370, 180, 440, 25);

        score10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        score10.setText("Score");
        schoolingInfoPanel.add(score10);
        score10.setBounds(370, 210, 100, 25);

        school12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        school12.setText("School Name");
        schoolingInfoPanel.add(school12);
        school12.setBounds(370, 310, 440, 25);

        board12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        board12.setText("Board of Study");
        schoolingInfoPanel.add(board12);
        board12.setBounds(370, 350, 440, 25);

        score12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        score12.setText("Score");
        schoolingInfoPanel.add(score12);
        score12.setBounds(370, 390, 100, 25);
        schoolingInfoPanel.add(profilepicforsclinfo);
        profilepicforsclinfo.setBounds(760, 110, 160, 200);

        parentpanel.add(schoolingInfoPanel, "card2");

        collegeInfoPanel.setLayout(null);

        collegeInfolblforParentPanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        collegeInfolblforParentPanel.setText("College Information");
        collegeInfoPanel.add(collegeInfolblforParentPanel);
        collegeInfolblforParentPanel.setBounds(0, 20, 1080, 25);

        uglbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        uglbl.setText("UG");
        collegeInfoPanel.add(uglbl);
        uglbl.setBounds(120, 110, 100, 25);

        clgnamelbl1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        clgnamelbl1.setText("College Name");
        collegeInfoPanel.add(clgnamelbl1);
        clgnamelbl1.setBounds(190, 240, 110, 25);

        universitynamelbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        universitynamelbl.setText("University Name");
        collegeInfoPanel.add(universitynamelbl);
        universitynamelbl.setBounds(190, 270, 110, 25);

        aggregatelbl.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aggregatelbl.setText("Aggregate");
        collegeInfoPanel.add(aggregatelbl);
        aggregatelbl.setBounds(190, 300, 110, 25);

        clgnameforug1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        clgnameforug1.setText("CollegeName");
        collegeInfoPanel.add(clgnameforug1);
        clgnameforug1.setBounds(330, 240, 510, 25);

        universitynameforug1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        universitynameforug1.setText("University Name");
        collegeInfoPanel.add(universitynameforug1);
        universitynameforug1.setBounds(330, 270, 510, 25);

        aggregateforug1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        aggregateforug1.setText("Aggregate");
        collegeInfoPanel.add(aggregateforug1);
        aggregateforug1.setBounds(330, 300, 510, 25);

        deglbl.setText("Degree");
        collegeInfoPanel.add(deglbl);
        deglbl.setBounds(190, 150, 110, 25);

        degree.setText("Degree");
        collegeInfoPanel.add(degree);
        degree.setBounds(330, 150, 360, 25);

        yoplbl.setText("Year of Passing");
        collegeInfoPanel.add(yoplbl);
        yoplbl.setBounds(190, 210, 130, 25);

        yopforug1.setText("Year");
        collegeInfoPanel.add(yopforug1);
        yopforug1.setBounds(330, 210, 300, 25);

        majorforug1.setText("Major");
        collegeInfoPanel.add(majorforug1);
        majorforug1.setBounds(330, 180, 390, 25);

        majorlbl1.setText("Major");
        collegeInfoPanel.add(majorlbl1);
        majorlbl1.setBounds(190, 180, 110, 25);
        collegeInfoPanel.add(profilepicforclginfo);
        profilepicforclginfo.setBounds(760, 110, 160, 200);

        parentpanel.add(collegeInfoPanel, "card3");

        academicInfo.add(parentpanel);
        parentpanel.setBounds(250, 0, 1080, 650);

        parentPanel.add(academicInfo, "card7");

        admissionPanel.setBackground(new java.awt.Color(255, 255, 255));
        admissionPanel.setLayout(null);

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setLayout(null);

        admissionlblforpanel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admissionlblforpanel.setText("Admission Management");
        jPanel3.add(admissionlblforpanel);
        admissionlblforpanel.setBounds(0, 30, 250, 30);

        admissionlblforStaff.setForeground(new java.awt.Color(82, 155, 255));
        admissionlblforStaff.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admissionlblforStaff.setText("Staff");
        admissionlblforStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admissionlblforStaff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admissionlblforStaffMouseClicked(evt);
            }
        });
        jPanel3.add(admissionlblforStaff);
        admissionlblforStaff.setBounds(0, 80, 250, 30);

        admissionlblforStd.setForeground(new java.awt.Color(82, 155, 255));
        admissionlblforStd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        admissionlblforStd.setText("Student");
        admissionlblforStd.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        admissionlblforStd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                admissionlblforStdMouseClicked(evt);
            }
        });
        jPanel3.add(admissionlblforStd);
        admissionlblforStd.setBounds(0, 110, 250, 30);

        admissionPanel.add(jPanel3);
        jPanel3.setBounds(0, 0, 250, 650);

        parentPanelforadmission.setLayout(new java.awt.CardLayout());

        jPanel7.setLayout(new java.awt.BorderLayout());

        defaultlblforAttenadancemanagement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        defaultlblforAttenadancemanagement.setText("Please Select What You Need?");
        jPanel7.add(defaultlblforAttenadancemanagement, java.awt.BorderLayout.CENTER);

        parentPanelforadmission.add(jPanel7, "card3");

        StaffadmissionPanel.setLayout(null);

        stfadmissionmanagmentlbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        stfadmissionmanagmentlbl.setText("Staff Admission Management");
        StaffadmissionPanel.add(stfadmissionmanagmentlbl);
        stfadmissionmanagmentlbl.setBounds(0, 30, 1100, 30);

        adminnamelbl.setText("Admin Name:");
        StaffadmissionPanel.add(adminnamelbl);
        adminnamelbl.setBounds(80, 100, 110, 25);

        adminNameforAdmissionStaff.setText("Staff Name");
        StaffadmissionPanel.add(adminNameforAdmissionStaff);
        adminNameforAdmissionStaff.setBounds(170, 100, 140, 25);

        adminlDlbl.setText("Admin ID: ");
        StaffadmissionPanel.add(adminlDlbl);
        adminlDlbl.setBounds(380, 100, 70, 25);

        adminIDforadmissionStaff.setText("Staff ID");
        StaffadmissionPanel.add(adminIDforadmissionStaff);
        adminIDforadmissionStaff.setBounds(450, 100, 120, 25);

        admissionDatelalb.setText("Admission Date");
        StaffadmissionPanel.add(admissionDatelalb);
        admissionDatelalb.setBounds(650, 100, 130, 25);

        timelbl.setText("Time");
        StaffadmissionPanel.add(timelbl);
        timelbl.setBounds(930, 100, 40, 25);

        dateforStaffAdmission.setText("Date");
        StaffadmissionPanel.add(dateforStaffAdmission);
        dateforStaffAdmission.setBounds(770, 100, 90, 25);

        timeforStaffAdmission.setText("Time");
        StaffadmissionPanel.add(timeforStaffAdmission);
        timeforStaffAdmission.setBounds(990, 100, 80, 25);

        jSeparator1.setForeground(new java.awt.Color(102, 102, 102));
        StaffadmissionPanel.add(jSeparator1);
        jSeparator1.setBounds(10, 80, 1080, 3);

        newfacultyNamelbl.setText("Faculty Name");
        StaffadmissionPanel.add(newfacultyNamelbl);
        newfacultyNamelbl.setBounds(90, 200, 130, 25);

        newfacultynameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newfacultynameTFActionPerformed(evt);
            }
        });
        StaffadmissionPanel.add(newfacultynameTF);
        newfacultynameTF.setBounds(230, 200, 180, 25);

        facultymailIdlblforAdmission.setText("Faculty Mail ID");
        StaffadmissionPanel.add(facultymailIdlblforAdmission);
        facultymailIdlblforAdmission.setBounds(90, 250, 150, 25);
        StaffadmissionPanel.add(facultymailidforadmisssionTF);
        facultymailidforadmisssionTF.setBounds(230, 250, 180, 25);

        facultymobilelblforAdmission.setText("Faculty Mobile ");
        StaffadmissionPanel.add(facultymobilelblforAdmission);
        facultymobilelblforAdmission.setBounds(90, 300, 150, 25);
        StaffadmissionPanel.add(facultymobileforAdmissionTF);
        facultymobileforAdmissionTF.setBounds(230, 300, 180, 25);

        facultyTeachingTypelbl.setText("Teaching Type");
        StaffadmissionPanel.add(facultyTeachingTypelbl);
        facultyTeachingTypelbl.setBounds(660, 200, 130, 25);

        facultyTeachingTypeCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-"}));
        StaffadmissionPanel.add(facultyTeachingTypeCB);
        facultyTeachingTypeCB.setBounds(770, 200, 180, 25);

        deptlblforAdmission.setText("Department");
        StaffadmissionPanel.add(deptlblforAdmission);
        deptlblforAdmission.setBounds(660, 250, 150, 25);

        facultyDeptCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {"-"}));
        StaffadmissionPanel.add(facultyDeptCB);
        facultyDeptCB.setBounds(770, 250, 180, 25);

        facultydesignationlblforAdmissionlbl.setText("Designation");
        StaffadmissionPanel.add(facultydesignationlblforAdmissionlbl);
        facultydesignationlblforAdmissionlbl.setBounds(660, 300, 150, 25);

        facultydesignationlCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-"}));
        StaffadmissionPanel.add(facultydesignationlCB);
        facultydesignationlCB.setBounds(770, 300, 180, 25);

        jSeparator2.setForeground(new java.awt.Color(102, 102, 102));
        StaffadmissionPanel.add(jSeparator2);
        jSeparator2.setBounds(10, 140, 1080, 10);

        academicInfromationlbl.setText("Academic Information");
        StaffadmissionPanel.add(academicInfromationlbl);
        academicInfromationlbl.setBounds(80, 150, 170, 25);

        jSeparator3.setForeground(new java.awt.Color(102, 102, 102));
        StaffadmissionPanel.add(jSeparator3);
        jSeparator3.setBounds(20, 520, 1080, 10);

        otpverificationlbl.setText("OTP Verification");
        StaffadmissionPanel.add(otpverificationlbl);
        otpverificationlbl.setBounds(90, 400, 150, 25);

        otplblforAdmissionStaff.setText("Enter OTP");
        StaffadmissionPanel.add(otplblforAdmissionStaff);
        otplblforAdmissionStaff.setBounds(110, 440, 110, 25);

        otpTFforAdmissionStaff.setEnabled(false);
        StaffadmissionPanel.add(otpTFforAdmissionStaff);
        otpTFforAdmissionStaff.setBounds(240, 440, 180, 25);

        verifybtnforAdmissionStaff.setMnemonic('v');
        verifybtnforAdmissionStaff.setText("Verify");
        verifybtnforAdmissionStaff.setEnabled(false);
        StaffadmissionPanel.add(verifybtnforAdmissionStaff);
        verifybtnforAdmissionStaff.setBounds(270, 480, 120, 25);

        jSeparator4.setForeground(new java.awt.Color(102, 102, 102));
        StaffadmissionPanel.add(jSeparator4);
        jSeparator4.setBounds(20, 390, 1080, 10);

        createidbtnforStaff.setText("Create ID");
        createidbtnforStaff.setEnabled(false);
        StaffadmissionPanel.add(createidbtnforStaff);
        createidbtnforStaff.setBounds(920, 440, 130, 23);

        stslblforcreateStaffID.setForeground(new java.awt.Color(51, 255, 51));
        stslblforcreateStaffID.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        StaffadmissionPanel.add(stslblforcreateStaffID);
        stslblforcreateStaffID.setBounds(430, 570, 310, 50);

        sendOTPbtn.setText("Send OTP");
        sendOTPbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendOTPbtnActionPerformed(evt);
            }
        });
        StaffadmissionPanel.add(sendOTPbtn);
        sendOTPbtn.setBounds(810, 350, 100, 23);

        parentPanelforadmission.add(StaffadmissionPanel, "card3");

        jPanel10.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(212, 212, 212));
        jPanel13.setLayout(new java.awt.BorderLayout());
        jPanel10.add(jPanel13);
        jPanel13.setBounds(100, 160, 910, 390);

        II_ct_attendance1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        II_ct_attendance1.setText("II-CT Attendance");
        jPanel10.add(II_ct_attendance1);
        II_ct_attendance1.setBounds(0, 30, 1100, 30);

        clsinchargenamelblICT.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        clsinchargenamelblICT.setText("Class Incharge ");
        jPanel10.add(clsinchargenamelblICT);
        clsinchargenamelblICT.setBounds(0, 60, 1100, 30);

        submitbtnforAttendance1.setBackground(new java.awt.Color(82, 155, 255));
        submitbtnforAttendance1.setText("Submit");
        jPanel10.add(submitbtnforAttendance1);
        submitbtnforAttendance1.setBounds(880, 580, 130, 30);

        facultynamelblICT.setText("Faculty Name:");
        jPanel10.add(facultynamelblICT);
        facultynamelblICT.setBounds(100, 120, 120, 25);

        facultynameIICT.setText("Staff Name");
        jPanel10.add(facultynameIICT);
        facultynameIICT.setBounds(190, 120, 140, 25);

        facultyIDlblIICT.setText("Faculty ID: ");
        jPanel10.add(facultyIDlblIICT);
        facultyIDlblIICT.setBounds(290, 120, 70, 25);

        facultyIICT.setText("Staff ID");
        jPanel10.add(facultyIICT);
        facultyIICT.setBounds(360, 120, 120, 25);

        paperhandlelblIICT.setText("Paper of Handling:");
        jPanel10.add(paperhandlelblIICT);
        paperhandlelblIICT.setBounds(460, 120, 140, 25);

        jPanel10.add(paperCBIICT);
        paperCBIICT.setBounds(600, 120, 160, 25);

        hourlblIICT.setText("Hour");
        jPanel10.add(hourlblIICT);
        hourlblIICT.setBounds(790, 120, 40, 25);

        jPanel10.add(hourCBIICT);
        hourCBIICT.setBounds(840, 120, 170, 25);

        parentPanelforadmission.add(jPanel10, "card4");

        admissionPanel.add(parentPanelforadmission);
        parentPanelforadmission.setBounds(250, 0, 1100, 650);

        parentPanel.add(admissionPanel, "card6");

        mainpanel.add(parentPanel);
        parentPanel.setBounds(203, 144, 1330, 670);

        getContentPane().add(mainpanel, java.awt.BorderLayout.CENTER);

        setBounds(0, 0, 1550, 871);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutlblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logoutlblMouseClicked
        // TODO add your handling code here:
        int res = JOptionPane.showConfirmDialog(parentPanel, "Are you sure want to Logout ?", "EASCPRO", 2);
        if (res == 0) {
            this.dispose();
            new LoginFrame().setVisible(true);
        }
    }//GEN-LAST:event_logoutlblMouseClicked

    private void profilelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_profilelblMouseClicked
        // TODO add your handling code here:
        personal_info();
    }//GEN-LAST:event_profilelblMouseClicked

    private void schedulelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schedulelblMouseClicked
        // TODO add your handling code here:
//        Schedule();
    }//GEN-LAST:event_schedulelblMouseClicked

    private void leavelblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leavelblMouseClicked
        // TODO add your handling code here:
        leaveManagement();
    }//GEN-LAST:event_leavelblMouseClicked

    private void admissionlblforMenupanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admissionlblforMenupanelMouseClicked
        // TODO add your handling code here:
        parentPanel.removeAll();
        parentPanel.add(admissionPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_admissionlblforMenupanelMouseClicked

    private void editlogoimg1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editlogoimg1MouseClicked
        // TODO add your handling code here:
        String newAdd = "";
        newAdd = JOptionPane.showInputDialog(parentPanel, "Enter a New Address here ", "Type here");
        if (!(newAdd).equals("")) {
            int res = JOptionPane.showConfirmDialog(parentPanel, "Are You sure want to make this Modification ?", "EASCPRO", 2);
            if (res == 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                    String q = "update admindetails set adminaddress= ? where adminid=?";
                    PreparedStatement ps1 = con.prepareStatement(q);
                    ps1.setString(1, newAdd);
                    ps1.setString(2, LoginFrame.userID);
                    ps1.executeUpdate();
                    JOptionPane.showMessageDialog(parentPanel, "Your Address Modification process is Completed..!", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    addresslblforprofile.setText(newAdd);
                }//try Block ends here...!
                catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AdminDashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }//catch clause end here..!
            }//Inner IF ends here..!
        }//Outer If ends here..!
    }//GEN-LAST:event_editlogoimg1MouseClicked

    private void editlogoimg2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editlogoimg2MouseClicked
        // TODO add your handling code here:
        String newMail = JOptionPane.showInputDialog(parentPanel, "Enter a New Mail Address here ", "Type here");
        if (!(newMail).equals("")) {
            int res = JOptionPane.showConfirmDialog(parentPanel, "Are You sure want to make this Modification ?", "EASCPRO", 2);
            if (res == 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                    String q = "update admindetails set adminMail= ? where adminid=?";
                    PreparedStatement ps1 = con.prepareStatement(q);
                    ps1.setString(1, newMail);
                    ps1.setString(2, LoginFrame.userID);
                    ps1.executeUpdate();
                    JOptionPane.showMessageDialog(parentPanel, "Your  Address Modification process is Completed..!", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    mailidTFforprofile.setText(newMail);
                }//try Block ends here...!
                catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AdminDashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }//catch clause end here..!
            }//Inner If ends here..!
        } //Outer If ends here..!
    }//GEN-LAST:event_editlogoimg2MouseClicked

    private void editlogoimg3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editlogoimg3MouseClicked
        // TODO add your handling code here:
        String newMob = JOptionPane.showInputDialog(parentPanel, "Enter a New Mobile Number here ", "Type here");
        if (!(newMob).equals("")) {
            int res = JOptionPane.showConfirmDialog(parentPanel, "Are You sure want to make this Modification ?", "EASCPRO", 2);
            if (res == 0) {
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/eascpro", "root", "root");
                    String q = "update admindetails set adminmob= ? where adminid=?";
                    PreparedStatement ps1 = con.prepareStatement(q);
                    ps1.setString(1, newMob);
                    ps1.setString(2, LoginFrame.userID);
                    ps1.executeUpdate();
                    JOptionPane.showMessageDialog(parentPanel, "Your  Mobile Modification process is Completed..!", "EASCPRO", JOptionPane.INFORMATION_MESSAGE);
                    mobTFforprofile.setText("+91 " + newMob);
                }//try Block ends here...!
                catch (ClassNotFoundException | SQLException ex) {
                    Logger.getLogger(AdminDashBoard.class.getName()).log(Level.SEVERE, null, ex);
                }//catch clause end here..!
            }//Inner If ends here..!
        } //Outer If ends here..!
    }//GEN-LAST:event_editlogoimg3MouseClicked

    private void applyleavebtnforattendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_applyleavebtnforattendanceActionPerformed
        // TODO add your handling code here:
        leaveManagement();
    }//GEN-LAST:event_applyleavebtnforattendanceActionPerformed

    private void cancelleavebtnforattendanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelleavebtnforattendanceActionPerformed
        // TODO add your handling code here:
        leaveManagement();
    }//GEN-LAST:event_cancelleavebtnforattendanceActionPerformed

    private void schoolingInfolblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_schoolingInfolblMouseClicked
        // TODO add your handling code here:
        schoolingInfo();
    }//GEN-LAST:event_schoolingInfolblMouseClicked

    private void collegeInfolblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_collegeInfolblMouseClicked
        // TODO add your handling code here:
        collegeInfo();
    }//GEN-LAST:event_collegeInfolblMouseClicked

    private void admissionlblforStaffMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admissionlblforStaffMouseClicked
        // TODO add your handling code here:
        parentPanelforadmission.removeAll();
        parentPanelforadmission.add(StaffadmissionPanel);
        parentPanelforadmission.repaint();
        parentPanelforadmission.revalidate();
        admissionStaff();
    }//GEN-LAST:event_admissionlblforStaffMouseClicked

    private void admissionlblforStdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_admissionlblforStdMouseClicked
        // TODO add your handling code here:
//        jPanel5.removeAll();
//        jPanel5.add(jPanel10);
//        jPanel5.repaint();
//        jPanel5.revalidate();
//        String yoj = "2022";
//        attendancemanagement(yoj, jPanel13);
    }//GEN-LAST:event_admissionlblforStdMouseClicked

    private void newfacultynameTFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newfacultynameTFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_newfacultynameTFActionPerformed

    private void sendOTPbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendOTPbtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sendOTPbtnActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashBoard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel II_ct_attendance1;
    private javax.swing.JPanel StaffadmissionPanel;
    private javax.swing.JLabel UIDlblforprofile;
    private javax.swing.JPanel academicInfo;
    private javax.swing.JLabel academicInfolbl;
    private javax.swing.JLabel academicInfromationlbl;
    private javax.swing.JLabel addlblforprofile;
    private javax.swing.JTextArea addresslblforprofile;
    private javax.swing.JLabel adminIDforadmissionStaff;
    private javax.swing.JLabel adminNameforAdmissionStaff;
    private javax.swing.JLabel admindashboardlbl;
    private javax.swing.JLabel adminlDlbl;
    private javax.swing.JLabel adminnamelbl;
    private javax.swing.JLabel admissionDatelalb;
    private javax.swing.JPanel admissionPanel;
    private javax.swing.JLabel admissionlblforMenupanel;
    private javax.swing.JLabel admissionlblforStaff;
    private javax.swing.JLabel admissionlblforStd;
    private javax.swing.JLabel admissionlblforpanel;
    private javax.swing.JLabel aggregateforug1;
    private javax.swing.JLabel aggregatelbl;
    private javax.swing.JButton applyleavebtnforattendance;
    private javax.swing.JLabel availableLeavelbl;
    private javax.swing.JLabel avgintimelbl;
    private javax.swing.JLabel avgouttimelbl;
    private javax.swing.JPanel bgpanel;
    private javax.swing.JLabel board10;
    private javax.swing.JLabel board12;
    private javax.swing.JLabel boardlbl10;
    private javax.swing.JLabel boardlbl12;
    private javax.swing.JButton cancelleavebtnforattendance;
    private javax.swing.JLabel clglbl;
    private javax.swing.JLabel clglbl2;
    private javax.swing.JLabel clglbl3;
    private javax.swing.JLabel clglbl4;
    public javax.swing.JLabel clglogo1;
    private javax.swing.JLabel clgnameforug1;
    private javax.swing.JLabel clgnamelbl1;
    private javax.swing.JLabel clsinchargenamelblICT;
    private javax.swing.JPanel collegeInfoPanel;
    private javax.swing.JLabel collegeInfolbl;
    private javax.swing.JLabel collegeInfolblforParentPanel;
    private javax.swing.JLabel collegelbl;
    private javax.swing.JButton createidbtnforStaff;
    private javax.swing.JLabel dateforStaffAdmission;
    private javax.swing.JPanel defaultPanel;
    private javax.swing.JLabel defaultlblforAttenadancemanagement;
    private javax.swing.JLabel deglbl;
    private javax.swing.JLabel degree;
    private javax.swing.JLabel deptlbl;
    private javax.swing.JLabel deptlblforAdmission;
    private javax.swing.JLabel designationforleavemanagementlbl;
    private javax.swing.JLabel designationlabelforprofile;
    private javax.swing.JLabel editlogoimg1;
    private javax.swing.JLabel editlogoimg2;
    private javax.swing.JLabel editlogoimg3;
    private javax.swing.JLabel emailidlblforprofile;
    private javax.swing.JComboBox<String> facultyDeptCB;
    private javax.swing.JLabel facultyIDlblIICT;
    private javax.swing.JLabel facultyIICT;
    private javax.swing.JComboBox<String> facultyTeachingTypeCB;
    private javax.swing.JLabel facultyTeachingTypelbl;
    private javax.swing.JComboBox<String> facultydesignationlCB;
    private javax.swing.JLabel facultydesignationlblforAdmissionlbl;
    private javax.swing.JLabel facultymailIdlblforAdmission;
    private javax.swing.JTextField facultymailidforadmisssionTF;
    private javax.swing.JTextField facultymobileforAdmissionTF;
    private javax.swing.JLabel facultymobilelblforAdmission;
    private javax.swing.JLabel facultynameIICT;
    private javax.swing.JLabel facultynamelblICT;
    private javax.swing.JComboBox<String> hourCBIICT;
    private javax.swing.JLabel hourlblIICT;
    private javax.swing.JLabel hsclbl;
    private javax.swing.JLabel imglbl;
    private javax.swing.JLabel intime;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JLabel lbl1forprofile;
    private javax.swing.JLabel lbl2forprofile;
    private javax.swing.JLabel lbl3forprofile;
    private javax.swing.JLabel lblfordefaultpanelacademic;
    private javax.swing.JLabel leavelbl;
    private javax.swing.JPanel leavemanagement;
    private javax.swing.JLabel leavemanagementlbl;
    private javax.swing.JLabel loggedlbl;
    private javax.swing.JLabel logoutlbl;
    private javax.swing.JTextField mailidTFforprofile;
    private javax.swing.JPanel mainpanel;
    private javax.swing.JLabel majorforug1;
    private javax.swing.JLabel majorlbl1;
    private javax.swing.JPanel menupanel;
    private javax.swing.JTextField mobTFforprofile;
    private javax.swing.JLabel mobilelblforprofile;
    private javax.swing.JLabel newfacultyNamelbl;
    private javax.swing.JTextField newfacultynameTF;
    private javax.swing.JTextField otpTFforAdmissionStaff;
    private javax.swing.JLabel otplblforAdmissionStaff;
    private javax.swing.JLabel otpverificationlbl;
    private javax.swing.JLabel outtime;
    private javax.swing.JComboBox<String> paperCBIICT;
    private javax.swing.JLabel paperhandlelblIICT;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel parentPanelforadmission;
    private javax.swing.JPanel parentpanel;
    private javax.swing.JLabel parentpanelbgimg;
    private javax.swing.JPanel profilePanel;
    private javax.swing.JLabel profileinolbl;
    private javax.swing.JLabel profilelbl;
    private javax.swing.JLabel profilepicforattendancepanel;
    private javax.swing.JLabel profilepicforclginfo;
    private javax.swing.JLabel profilepicforsclinfo;
    private javax.swing.JLabel schedulelbl;
    private javax.swing.JLabel school10;
    private javax.swing.JLabel school12;
    private javax.swing.JPanel schoolingInfoPanel;
    private javax.swing.JLabel schoolingInfolbl;
    private javax.swing.JLabel schoolingInfolblforparentPanel;
    private javax.swing.JLabel schoollbl10;
    private javax.swing.JLabel schoollbl12;
    private javax.swing.JLabel score10;
    private javax.swing.JLabel score12;
    private javax.swing.JLabel scorelbl10;
    private javax.swing.JLabel scorelbl12;
    private javax.swing.JButton sendOTPbtn;
    private javax.swing.JLabel sslclbl;
    private javax.swing.JLabel stfadmissionmanagmentlbl;
    private javax.swing.JLabel stslblforcreateStaffID;
    private javax.swing.JButton submitbtnforAttendance1;
    private javax.swing.JLabel takenLeavelbl;
    private javax.swing.JLabel timeforStaffAdmission;
    private javax.swing.JLabel timelbl;
    private javax.swing.JLabel totalLeavelbl;
    private javax.swing.JLabel typeforprofile;
    private javax.swing.JLabel typelblforattendace;
    private javax.swing.JLabel typelblforprofile;
    private javax.swing.JLabel uglbl;
    private javax.swing.JLabel unamelblforattendance;
    private javax.swing.JLabel unamelblforprofile;
    private javax.swing.JLabel universitynameforug1;
    private javax.swing.JLabel universitynamelbl;
    private javax.swing.JLabel useridlbl;
    private javax.swing.JLabel useridlblforattendancepanel;
    private javax.swing.JLabel usernamelbl;
    private javax.swing.JButton verifybtnforAdmissionStaff;
    private javax.swing.JPanel welcomepanel;
    private javax.swing.JLabel yojforprofile;
    private javax.swing.JLabel yojlblforprofile;
    private javax.swing.JLabel yopforug1;
    private javax.swing.JLabel yoplbl;
    // End of variables declaration//GEN-END:variables
}
