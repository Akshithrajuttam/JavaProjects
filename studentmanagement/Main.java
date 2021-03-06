
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.EventQueue;

final class Main {
    private JFrame window = new JFrame("college Management v0.1");
    private JPanel sidepane, userlogin, infobar, header;
    private JLabel logintxt, label2, label3, info, head, menulabel;
    private JTextField tf1, hallticket;
    private JPasswordField pf1;
    private JButton sidepanelbtn[];
    private JButton submitbtn;
    String value;
    // private JButton searchstudentbtn;
    private JButton resetpassword;
    private JButton button[], hallticketsearchbtn;
    private boolean accesstoken = false;
    private JPanel panels0, searchstudentpanel, managemenet;
    private int i = 0;
    private String serif = "Serif";

    void userlogin() {
        // window specification
        window.setVisible(true);
        window.setLayout(null);
        window.setSize(1080, 720);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);

        header = new JPanel();
        header.setBackground(new Color(123, 250, 200));

        // working here
        userlogin = new JPanel();
        userlogin.setLayout(null);// most important
        userlogin.setBackground(Color.orange);
        // userlogin.setBorder(new EmptyBorder(5, 5, 5, 5));
        userlogin.setBounds(180, 30, 890, 600);

        info = new JLabel("version 1.0 Swing Java");
        info.setForeground(Color.LIGHT_GRAY);
        info.setBackground(Color.MAGENTA);
        info.setFont(new Font("Script MT Bold", Font.BOLD, 20));
        info.setBounds(0, 0, 150, 150);

        menulabel = new JLabel("Menu");
        menulabel.setForeground(Color.LIGHT_GRAY);
        menulabel.setBackground(Color.magenta);
        menulabel.setFont(new Font("Sans-serif", Font.BOLD, 30));

        head = new JLabel("Vaagdevi college of Engineering");
        head.setBackground(Color.black);
        head.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
        head.setBounds(0, 0, 250, 250);

        // sidepanel which menu control
        sidepane = new JPanel();
        sidepane.setForeground(Color.white);
        sidepane.setBackground(Color.black);
        sidepane.setLayout(null);

        infobar = new JPanel();
        infobar.setBackground(new Color(123, 250, 200));
        infobar.setLayout(null);

        sidepane.setBounds(0, 50, 180, 570);
        infobar.setBounds(0, 620, 1080, 60);
        info.setBounds(720, 120, 720, 720);

        header.setBounds(0, 0, 1080, 50);
        header.add(head);

        infobar.add(info);
        // windows panels
        window.add(sidepane);
        window.add(infobar);
        window.add(header);
        window.add(userlogin);

        // sidepanel generation
        sidepanelbtn = new JButton[5];
        menulabel.setBounds(12, 150, 150, 40);// (x, y, width, height);
        sidepanelbtn[0] = new JButton("user-management");
        sidepanelbtn[0].setBounds(12, 200, 150, 28);
        sidepanelbtn[1] = new JButton("student Management");
        sidepanelbtn[1].setBounds(12, 240, 150, 28);
        sidepanelbtn[2] = new JButton("student Search");
        sidepanelbtn[2].setBounds(12, 280, 150, 28);
        sidepanelbtn[3] = new JButton("Reports");
        sidepanelbtn[3].setBounds(12, 320, 150, 28);
        sidepanelbtn[4] = new JButton("ID card");
        sidepanelbtn[4].setBounds(12, 360, 150, 28);

        for (; i < 5; i++) {
            sidepane.add(sidepanelbtn[i]);
            sidepanelbtn[i].setForeground(Color.orange);
            sidepanelbtn[i].setBackground(Color.black);
            sidepanelbtn[i].setFont(new Font(serif, Font.BOLD, 13));
        }
        sidepane.add(menulabel);
        // sidepane.setLayout(new BoxLayout(sidepane, BoxLayout.Y_AXIS));

        // userlogin content Development
        // submitbtn action listener
        logintxt = new JLabel("Login form");
        logintxt.setForeground(Color.black);
        logintxt.setFont(new Font("Serif", Font.BOLD, 48));
        label2 = new JLabel("Enter ID");
        label2.setForeground(Color.black);
        label2.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        label3 = new JLabel("Enter Password");
        label3.setForeground(Color.black);
        label3.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        tf1 = new JTextField();
        pf1 = new JPasswordField();
        resetpassword = new JButton("Reset password");
        resetpassword.setBounds(320, 380, 100, 30);
        resetpassword.addActionListener(actions);
        resetpassword.setFont(new Font("Sans-Serif", Font.BOLD, 18));
        submitbtn = new JButton("Submit");
        submitbtn.addActionListener(actions);
        logintxt.setBounds(390, 100, 273, 93);
        label2.setBounds(320, 210, 200, 30);
        label3.setBounds(320, 310, 200, 30);
        tf1.setBounds(540, 210, 200, 30);
        pf1.setBounds(540, 310, 200, 30);
        submitbtn.setBounds(220, 380, 100, 30);

        userlogin.add(logintxt);
        userlogin.add(label2);
        userlogin.add(label3);
        userlogin.add(tf1);
        userlogin.add(pf1);
        userlogin.add(submitbtn);
        userlogin.add(resetpassword);
        // boundaries
    }

    void userhome() {
        // after login panel array
        panels0 = new JPanel();
        panels0.setBackground(Color.orange);
        panels0.setVisible(true);
        panels0.setLayout(null);
        panels0.setBounds(180, 30, 890, 600);
        window.add(panels0);

        // buttons
        button = new JButton[10];
        button[0] = new JButton("search student");
        button[0].setBounds(120, 200, 250, 28);
        button[1] = new JButton("Update student name");
        button[1].setBounds(420, 200, 250, 28);
        button[2] = new JButton("Delete Student Data");
        button[2].setBounds(120, 250, 250, 28);
        button[3] = new JButton("Update Hallticket");
        button[3].setBounds(420, 250, 250, 28);
        button[4] = new JButton("Update Score &add score");
        button[4].setBounds(120, 300, 250, 28);
        button[5] = new JButton("Show all students");
        button[5].setBounds(420, 300, 250, 28);
        button[6] = new JButton("register student");
        button[6].setBounds(120, 350, 250, 28);
        button[7] = new JButton("New semister");
        button[7].setBounds(420, 350, 250, 28);
        button[8] = new JButton("Add a new subject");
        button[8].setBounds(120, 400, 250, 28);
        button[9] = new JButton("Help");
        button[9].setBounds(420, 400, 250, 28);
        for (int i = 0; i < 10; i++) {
            button[i].setBackground(Color.darkGray);
            button[i].setForeground(Color.white);
            panels0.add(button[i]);
            button[i].addActionListener(actions);

        }
    }

    // one method to get code resulability approch with complex
    void management(int tokenkey) {
        // adding Japanel finel
        managemenet = new JPanel();
        managemenet.setBackground(Color.orange);
        managemenet.setLayout(null);
        managemenet.setBounds(180, 30, 890, 600);
        managemenet.setVisible(true);
        window.add(managemenet);
        // working
        accesstoken = true;
        if (accesstoken = true) {
            switch (tokenkey) {
                case 0:
                    // search student
                    label3 = new JLabel("Enter Hallticket of an student");
                    label3.setBounds(120, 20, 250, 150);
                    managemenet.add(label3);

                    hallticket = new JTextField();
                    hallticket.setBounds(120, 170, 170, 25);
                    managemenet.add(hallticket);
                    hallticketsearchbtn = new JButton("Search");
                    hallticketsearchbtn.setBounds(120, 210, 170, 28);

                    managemenet.add(hallticketsearchbtn);
                    hallticketsearchbtn.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            label2 = new JLabel("----Details----");
                            label2.setBounds(310, 20, 250, 250);
                            managemenet.add(label2);
                            JTextPane tfd = new JTextPane();
                            tfd.setText(access(1));
                            tfd.setBackground(null);
                            tfd.setForeground(Color.BLACK);
                            // JTextField tfd = new JTextField(access(1));
                            tfd.setFont(new Font("Sans-Serif", Font.BOLD, 28));
                            tfd.setBounds(310, 210, 400, 150);
                            managemenet.add(tfd);
                        }
                    });
                    break;
                case 1:
                    // update student name
                    label3 = new JLabel("Enter Hallticket of an student");
                    label3.setBounds(120, 20, 250, 150);
                    managemenet.add(label3);

                    hallticket = new JTextField();
                    hallticket.setBounds(120, 170, 170, 25);
                    managemenet.add(hallticket);
                    hallticketsearchbtn = new JButton("Search");
                    hallticketsearchbtn.setBounds(120, 210, 170, 28);

                    managemenet.add(hallticketsearchbtn);
                    hallticketsearchbtn.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            label2 = new JLabel("----Details----");
                            label2.setBounds(310, 20, 250, 250);
                            managemenet.add(label2);
                            JTextPane tfd = new JTextPane();
                            tfd.setText(access(1));
                            tfd.setBackground(null);
                            tfd.setForeground(Color.BLACK);
                            // JTextField tfd = new JTextField(access(1));
                            tfd.setFont(new Font("Sans-Serif", Font.BOLD, 28));
                            tfd.setBounds(310, 210, 400, 150);
                            managemenet.add(tfd);
                        }
                    });
                    break;
                case 2:
                    // wipe student data and undo redo changes
                    label3 = new JLabel("Enter Hallticket of an student");
                    label3.setBounds(120, 20, 250, 150);
                    managemenet.add(label3);

                    hallticket = new JTextField();
                    hallticket.setBounds(120, 170, 170, 25);
                    managemenet.add(hallticket);
                    hallticketsearchbtn = new JButton("Search");
                    hallticketsearchbtn.setBounds(120, 210, 170, 28);

                    managemenet.add(hallticketsearchbtn);
                    hallticketsearchbtn.addActionListener(new ActionListener() {

                        public void actionPerformed(ActionEvent e) {
                            label2 = new JLabel("----Details----");
                            label2.setBounds(310, 20, 250, 250);
                            managemenet.add(label2);
                            JTextPane tfd = new JTextPane();
                            tfd.setText(access(1));
                            tfd.setBackground(null);
                            tfd.setForeground(Color.BLACK);
                            // JTextField tfd = new JTextField(access(1));
                            tfd.setFont(new Font("Sans-Serif", Font.BOLD, 28));
                            tfd.setBounds(310, 210, 400, 150);
                            managemenet.add(tfd);
                        }
                    });
                    break;
                case 3:
                    // update hallticket
                    break;
                case 4:
                    // update score and enter new score to student
                    break;
                case 5:
                    // show all student

                    break;
                case 6:
                    // register new student
                    break;
                case 7:
                    // add new semister
                    break;
                case 8:
                    // add new subject with semister
                    break;
                case 9:
                    // help
                    break;
                default:
                    break;

            }
        } else {
            // redirects to user login system
            userlogin();
        }
    }

    // search student method
    void searchstudentmethond() {
        searchstudentpanel = new JPanel();
        searchstudentpanel.setBackground(Color.orange);
        searchstudentpanel.setVisible(true);
        searchstudentpanel.setLayout(null);
        searchstudentpanel.setBounds(180, 30, 890, 600);
        window.add(searchstudentpanel);

        // buttons and test area
        label3 = new JLabel("Enter Hallticket of an student");
        label3.setBounds(120, 20, 250, 150);
        searchstudentpanel.add(label3);

        hallticket = new JTextField();
        hallticket.setBounds(120, 170, 170, 25);
        searchstudentpanel.add(hallticket);
        hallticketsearchbtn = new JButton("Search");
        hallticketsearchbtn.setBounds(120, 210, 170, 28);

        searchstudentpanel.add(hallticketsearchbtn);
        hallticketsearchbtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                label2 = new JLabel("----Details----");
                label2.setBounds(310, 20, 250, 250);
                searchstudentpanel.add(label2);
                JTextPane tfd = new JTextPane();
                tfd.setText(access(1));
                tfd.setBackground(null);
                tfd.setForeground(Color.BLACK);
                // JTextField tfd = new JTextField(access(1));
                tfd.setFont(new Font("Sans-Serif", Font.BOLD, 28));
                tfd.setBounds(310, 210, 400, 150);
                searchstudentpanel.add(tfd);
            }
        });
    }

    void deletestudentdata() {
        searchstudentpanel = new JPanel();
        searchstudentpanel.setBackground(Color.orange);
        searchstudentpanel.setVisible(true);
        searchstudentpanel.setLayout(null);
        searchstudentpanel.setBounds(180, 30, 890, 600);
        window.add(searchstudentpanel);

        // buttons and test area
        label3 = new JLabel("Enter Hallticket of an student");
        label3.setBounds(120, 20, 250, 150);
        searchstudentpanel.add(label3);

        hallticket = new JTextField();
        hallticket.setBounds(120, 170, 170, 25);
        searchstudentpanel.add(hallticket);
        hallticketsearchbtn = new JButton("Search");
        hallticketsearchbtn.setBounds(120, 210, 170, 28);

        searchstudentpanel.add(hallticketsearchbtn);
        hallticketsearchbtn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                label2 = new JLabel("----Details----");
                label2.setBounds(310, 20, 250, 250);
                searchstudentpanel.add(label2);
                JTextPane tfd = new JTextPane();
                tfd.setText(access(1));
                tfd.setBackground(null);
                tfd.setForeground(Color.BLACK);
                // JTextField tfd = new JTextField(access(1));
                tfd.setFont(new Font("Sans-Serif", Font.BOLD, 28));
                tfd.setBounds(310, 210, 400, 150);
                searchstudentpanel.add(tfd);
            }
        });
    }

    String access(int actionkey) {
        Connection connect = null;
        try {
            connect = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/collegemanagement", "root",
                    "0000");

            PreparedStatement st;
            switch (actionkey) {
                case 1:
                    try {
                        st = (PreparedStatement) connect.prepareStatement(
                                "select hallticket,studentname,studentcourse,studentcgpa,studentaddress from student where hallticket=?;");
                        st.setString(1, hallticket.getText());
                        ResultSet rs = st.executeQuery();
                        while (rs.next()) {
                            value = "Hallticket:" + rs.getString("hallticket") + "\nStudent Name:"
                                    + rs.getString("studentname") + "\nCourse:" + rs.getString("studentcourse")
                                    + "\nAddress:" + rs.getString("studentaddress");
                            // return values to
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Not found with ");
                    }
                    break;
                case 2:
                    try {
                        st = (PreparedStatement) connect
                                .prepareStatement("Select name, password from user where name=? and password=?");

                        st.setString(1, tf1.getText());
                        st.setString(2, pf1.getText());
                        ResultSet rs = st.executeQuery();
                        if (rs.next()) {
                            // dispose();
                            JOptionPane.showMessageDialog(submitbtn, "You have successfully logged in");
                            accesstoken = true;
                        }
                    } finally {
                        JOptionPane.showMessageDialog(submitbtn, "Wrong ID & Password");
                    }
                    break;
                case 3:
                    break;
                default:
                    //
                    break;

            }
            connect.close();
        } catch (SQLException e) {
            e.printStackTrace();
            // searchstudent();
        } finally {
            // JOptionPane.showInternalConfirmDialog(panels0, "Erros");
        }
        return value;
    }

    private ActionListener actions = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == submitbtn) {
                userlogin.setVisible(false);
                userhome();
                // access(2);
            } else if (e.getSource() == button[0]) {
                panels0.setVisible(false);
                // searchstudentmethond();
                management(0);
                // sidepane.setVisible(true);
            } else if (e.getSource() == button[1]) {
                panels0.setVisible(false);
                management(1);
            } else if (e.getSource() == button[2]) {
                panels0.setVisible(false);
                management(2);
            } else if (e.getSource() == button[3]) {
                panels0.setVisible(false);
                management(3);
            } else if (e.getSource() == button[4]) {
                panels0.setVisible(false);
                management(4);
            } else if (e.getSource() == button[5]) {
                panels0.setVisible(false);
                management(5);
            } else if (e.getSource() == button[6]) {
                panels0.setVisible(false);
                management(6);
            } else if (e.getSource() == button[7]) {
                panels0.setVisible(false);
                management(7);
            } else if (e.getSource() == button[8]) {
                panels0.setVisible(false);
                management(8);
            } else if (e.getSource() == button[9]) {
                panels0.setVisible(false);
                management(9);
            }
        }
    };

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Main().userlogin();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
