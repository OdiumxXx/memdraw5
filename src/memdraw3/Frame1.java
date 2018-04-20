package memdraw3;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import java.awt.Dimension;

import javax.swing.JPanel;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.EtchedBorder;


import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.JSpinner;

public class Frame1 {
  private JFrame frmMembersDraw; 

  // Setting private variables to be used for Raffle
  private JSpinner minSpin;
  private JSpinner maxSpin;

  int drawWinner;
  public int minVar = 1; // this can be accessed everywhere in MyClass
  private int maxVar = 10; // this can be accessed everywhere in MyClass
  Random rand = new Random();
  public static String winner = "No memdraw.csv";
  public static String winnerNum = "No memdraw.csv";

  // Setting Static Variables to be used for CSV Member Winner
  public static void memDrawWinner(String s) {
    winner = "changed";
    winnerNum = "changed";   
  }

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Frame1 window = new Frame1();
          window.frmMembersDraw.setVisible(true);          
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    });

  }

  /**
   * Create the application.
   */
  public Frame1() {
    initialize();
  }
  // Set our Param variables
  public void func1(int s) {
    minVar = s;

  }
  public void func2(int s) {
    maxVar = s;
  }  

  /**
   * Initialize the contents of the frame.
   */  
  private void initialize() {  
    Dimension screenSize;
    frmMembersDraw = new JFrame();
    frmMembersDraw.setTitle("members draw");
    frmMembersDraw.setExtendedState(JFrame.MAXIMIZED_BOTH); 
    frmMembersDraw.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);    
    frmMembersDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmMembersDraw.getContentPane().setLayout(new CardLayout(0, 0));

    // SET PANELS    
    JPanel Home = new JPanel();    
    frmMembersDraw.getContentPane().add(Home, "name_18476658441745");
    Home.setBackground(new Color(240, 255, 240));
    Home.setLayout(null);


    JPanel raffleParam = new JPanel();
    raffleParam.setBackground(new Color(240, 248, 255));
    frmMembersDraw.getContentPane().add(raffleParam, "name_18529318097321");
    raffleParam.setLayout(null);     
    screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Home.setBounds(0,0,screenSize.width, screenSize.height);

    JPanel raffleDraw = new JPanel();
    raffleDraw.setBackground(new Color(240, 248, 255));
    frmMembersDraw.getContentPane().add(raffleDraw, "name_19373899126863");
    raffleDraw.setLayout(null);

    JPanel membersDraw = new JPanel();
    membersDraw.setBackground(new Color(255, 250, 205));
    frmMembersDraw.getContentPane().add(membersDraw, "name_40604808963260");
    membersDraw.setLayout(null);

    //HOME PANEL    
    JButton btnRaffle = new JButton("Set Raffle Paramaters");
    btnRaffle.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnRaffle.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        raffleParam.setVisible(true);
        Home.setVisible(false);
      }
    });
    btnRaffle.setBounds(147, 855, 263, 97);
    Home.add(btnRaffle);

    JButton btnDrawRaffle = new JButton("Draw Raffle!");
    btnDrawRaffle.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnDrawRaffle.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Home.setVisible(false);
        raffleDraw.setVisible(true);        
      }
    });
    btnDrawRaffle.setBounds(806, 855, 250, 97);
    Home.add(btnDrawRaffle);

    JButton btnNewButton = new JButton("Member's Draw");
    btnNewButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Home.setVisible(false);
        membersDraw.setVisible(true);

      }
    });
    btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
    btnNewButton.setBounds(386, 129, 466, 138);
    Home.add(btnNewButton);

    JLabel lblWTBC = new JLabel("");    
    lblWTBC.setForeground(Color.WHITE);
    lblWTBC.setBackground(new Color(240, 255, 240));
    lblWTBC.setHorizontalAlignment(SwingConstants.CENTER);
    lblWTBC.setIcon(new ImageIcon(Frame1.class.getResource("/memdraw3/image002.png")));
    lblWTBC.setBounds(413, 394, 411, 294);
    lblWTBC.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    Home.add(lblWTBC);

    //MEMBERS DRAW PANEL
    JLabel lblMemNum = new JLabel("Get Ready!");
    lblMemNum.setHorizontalAlignment(SwingConstants.CENTER);
    lblMemNum.setFont(lblMemNum.getFont().deriveFont(220f));
//    lblMemNum.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    lblMemNum.setBackground(new Color(245, 255, 250));
    lblMemNum.setBounds(10, 11, 1210, 292);
    membersDraw.add(lblMemNum);

    JLabel lblMemName = new JLabel("");
    lblMemName.setHorizontalAlignment(SwingConstants.CENTER);
    lblMemName.setFont(new Font("Verdana", Font.BOLD, 76));
//    lblMemName.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    lblMemName.setBackground(new Color(245, 255, 250));
    lblMemName.setBounds(10, 302, 1210, 310);
    membersDraw.add(lblMemName);

    JButton btnmembersDrawButton = new JButton("Draw the Member's Draw!");
    btnmembersDrawButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
    btnmembersDrawButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {        
        CSVReader.main(null);
        lblMemNum.setText(Frame1.winnerNum);
        lblMemName.setText(Frame1.winner);

        //        System.out.println("HERE!" + Frame1.winner);
        //        System.out.println("HERE!" + Frame1.winnerNum);
      }
    });
    btnmembersDrawButton.setBounds(495, 903, 259, 75);
    membersDraw.add(btnmembersDrawButton);

    JButton button = new JButton("Back");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Home.setVisible(true);        
        membersDraw.setVisible(false);
        lblMemNum.setText("Get Ready!");
        lblMemName.setText("");
      }
    });
    button.setBounds(10, 919, 140, 59);
    membersDraw.add(button);

    JLabel label_1 = new JLabel("");
    label_1.setIcon(new ImageIcon(Frame1.class.getResource("/memdraw3/image002.png")));
    label_1.setHorizontalAlignment(SwingConstants.CENTER);
    label_1.setForeground(Color.BLACK);
    label_1.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    label_1.setBackground(new Color(230, 230, 250));
    label_1.setBounds(415, 640, 404, 252);
    membersDraw.add(label_1);

    // PARAMATER PANEL   
    JLabel lblMin = new JLabel("Minimum:");
    lblMin.setFont(new Font("Tahoma", Font.PLAIN, 50));
    lblMin.setBounds(300, 216, 285, 97);
    raffleParam.add(lblMin);

    JLabel lblMax = new JLabel("Maximum:");
    lblMax.setFont(new Font("Tahoma", Font.PLAIN, 50));
    lblMax.setBounds(300, 429, 300, 66);
    raffleParam.add(lblMax);

    minSpin = new JSpinner();    
    minSpin.setFont(new Font("Tahoma", Font.PLAIN, 50));    
    minSpin.setBounds(632, 222, 160, 86);
    minSpin.setValue(Integer.valueOf(minVar)); // Set the default value.
    raffleParam.add(minSpin);

    maxSpin = new JSpinner();
    maxSpin.setFont(new Font("Tahoma", Font.PLAIN, 50));
    maxSpin.setBounds(632, 423, 160, 80);
    maxSpin.setValue(Integer.valueOf(maxVar)); // Set the default value.
    raffleParam.add(maxSpin);


    JButton btnOk = new JButton("Ok");    
    btnOk.setFont(new Font("Tahoma", Font.PLAIN, 36));
    btnOk.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {        
        raffleParam.setVisible(false);
        Home.setVisible(false);
        raffleDraw.setVisible(true);
        func1((Integer) minSpin.getValue());        
        func2((Integer) maxSpin.getValue());
        //        System.out.println("minVar is "+minVar);
        //        System.out.println("maxVar is "+maxVar); 
        drawWinner = rand.nextInt(maxVar + 1 - minVar) + minVar;
      }
    });
    btnOk.setBounds(558, 678, 176, 66);
    raffleParam.add(btnOk);


    // DRAW PANEL    
    JLabel lblRaffleNumber = new JLabel("Get Ready!");
    lblRaffleNumber.setBackground(UIManager.getColor("Button.disabledShadow"));
    lblRaffleNumber.setHorizontalAlignment(SwingConstants.CENTER);
    lblRaffleNumber.setFont(lblRaffleNumber.getFont().deriveFont(215f));
    lblRaffleNumber.setBounds(10, 11, 1205, 350); 
    lblRaffleNumber.setBorder(null);
    raffleDraw.add(lblRaffleNumber);

    JButton btnDraw = new JButton("Draw the Raffle!");
    btnDraw.setFont(new Font("Tahoma", Font.PLAIN, 21));
    btnDraw.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        drawWinner = rand.nextInt(maxVar + 1 - minVar) + minVar;
        lblRaffleNumber.setText(Integer.toString(drawWinner));
//        System.out.println("minVar is "+minVar);
//        System.out.println("maxVar is "+maxVar);
      }
    });
    btnDraw.setBounds(506, 829, 231, 102);
    raffleDraw.add(btnDraw);

    JButton Back = new JButton("Back");
    Back.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Home.setVisible(true);                
        raffleDraw.setVisible(false);
        lblRaffleNumber.setText("Get Ready!");
      }
    });
    Back.setBounds(10, 919, 140, 59);
    raffleDraw.add(Back);

    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon(Frame1.class.getResource("/memdraw3/image002.png")));
    label.setHorizontalAlignment(SwingConstants.CENTER);
    label.setForeground(Color.BLACK);
    label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    label.setBackground(new Color(230, 230, 250));
    label.setBounds(421, 480, 404, 288);
    raffleDraw.add(label);


  }
}


