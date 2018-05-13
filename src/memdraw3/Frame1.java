package memdraw3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Random;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JSpinner;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.SystemColor;

public class Frame1 {
  private JFrame frame;

  //Setting private variables to be used for Raffle
  // private JSpinner minSpin;
  // private JSpinner maxSpin; 
  public int minVar = 1; // this can be accessed everywhere in MyClass
  private int maxVar = 10; // this can be accessed everywhere in MyClass
  // Setup Our Randomisation of raffle #
  int drawWinner;
  Random rand = new Random();
  public static String winner = "No memdraw.csv";
  public static String winnerNum = "No memdraw.csv";
  public static String filePath;
  public static JLabel lblMemNum = new JLabel("Get Ready!");


  //Set our Param variables
  public void func1(int s) {
    minVar = s;
  }

  public void func2(int s) {
    maxVar = s;
  }

  //Setting Static Variables to be used for CSV Member Winner
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
          window.frame.setVisible(true);
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

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frame = new JFrame();    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setLayout(new CardLayout(0, 0));
    frame.setBounds(0, 0, Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);

    // ******** PANELS ***********
    // HOME PANEL
    JPanel Home = new JPanel();
    Home.setBackground(SystemColor.inactiveCaptionBorder);
    frame.getContentPane().add(Home, "name_23302077142628");
    GridBagLayout gbl_Home = new GridBagLayout();
    gbl_Home.columnWidths = new int[]{194, 0, 395, 0, 227, 0};
    gbl_Home.rowHeights = new int[]{0, 301, 86, 0};
    gbl_Home.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
    gbl_Home.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
    Home.setLayout(gbl_Home);

    //RAFFLEPARAM PANEL
    JPanel RaffleParam = new JPanel();
    RaffleParam.setBackground(SystemColor.inactiveCaptionBorder);
    frame.getContentPane().add(RaffleParam, "name_26537752723386");
    GridBagLayout gbl_RaffleParam = new GridBagLayout();
    gbl_RaffleParam.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
    gbl_RaffleParam.rowHeights = new int[]{84, 0, 69, 0, 0, 0};
    gbl_RaffleParam.columnWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
    gbl_RaffleParam.rowWeights = new double[]{0.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
    RaffleParam.setLayout(gbl_RaffleParam);

    // RAFFLEDRAW PANEL
    JPanel raffleDraw = new JPanel();
    raffleDraw.setBackground(new Color(240, 255, 240));
    frame.getContentPane().add(raffleDraw, "name_28297964832862");
    GridBagLayout gbl_raffleDraw = new GridBagLayout();
    gbl_raffleDraw.columnWidths = new int[]{204, 1363, -32, 0};
    gbl_raffleDraw.rowHeights = new int[]{98, 330, 0, 266, 0, 0};
    gbl_raffleDraw.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
    gbl_raffleDraw.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
    raffleDraw.setLayout(gbl_raffleDraw);

    JPanel membersDraw = new JPanel();
    membersDraw.setBackground(SystemColor.info);
    frame.getContentPane().add(membersDraw, "name_34030677593319");
    GridBagLayout gbl_membersDraw = new GridBagLayout();
    gbl_membersDraw.columnWidths = new int[]{0, 0, 0, 0};
    gbl_membersDraw.rowHeights = new int[]{318, 230, 0, 0, 0};
    gbl_membersDraw.columnWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
    gbl_membersDraw.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
    membersDraw.setLayout(gbl_membersDraw);

    JLabel lblNewLabel_1 = new JLabel("Minimum:");
    lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
    GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
    gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTHEAST;
    gbc_lblNewLabel_1.insets = new Insets(160, 0, 5, 5);
    gbc_lblNewLabel_1.gridx = 1;
    gbc_lblNewLabel_1.gridy = 1;
    RaffleParam.add(lblNewLabel_1, gbc_lblNewLabel_1);

    JPanel panel = new JPanel();
    panel.setBackground(SystemColor.inactiveCaptionBorder);
    panel.setLayout(null);
    GridBagConstraints gbc_panel = new GridBagConstraints();
    gbc_panel.insets = new Insets(0, 0, 5, 5);
    gbc_panel.fill = GridBagConstraints.BOTH;
    gbc_panel.gridx = 2;
    gbc_panel.gridy = 1;
    RaffleParam.add(panel, gbc_panel);

    JSpinner minSpin = new JSpinner();
    panel.add(minSpin);
    minSpin.setFont(new Font("Tahoma", Font.PLAIN, 42));
    minSpin.setBounds(50, 120, 180, 100);
    minSpin.setValue(Integer.valueOf(minVar));

    JLabel lblMaximum = new JLabel("Maximum:");
    lblMaximum.setFont(new Font("Tahoma", Font.PLAIN, 24));
    GridBagConstraints gbc_lblMaximum = new GridBagConstraints();
    gbc_lblMaximum.anchor = GridBagConstraints.NORTHEAST;
    gbc_lblMaximum.insets = new Insets(120, 0, 5, 0);
    gbc_lblMaximum.gridx = 1;
    gbc_lblMaximum.gridy = 2;
    RaffleParam.add(lblMaximum, gbc_lblMaximum);

    JPanel panel_1 = new JPanel();
    panel_1.setBackground(SystemColor.inactiveCaptionBorder);
    panel_1.setLayout(null);
    GridBagConstraints gbc_panel_1 = new GridBagConstraints();
    gbc_panel_1.insets = new Insets(0, 0, 5, 5);
    gbc_panel_1.fill = GridBagConstraints.BOTH;
    gbc_panel_1.gridx = 2;
    gbc_panel_1.gridy = 2;
    RaffleParam.add(panel_1, gbc_panel_1);

    JSpinner maxSpin = new JSpinner();
    maxSpin.setBounds(50, 80, 180, 100);
    panel_1.add(maxSpin);
    maxSpin.setFont(new Font("Tahoma", Font.PLAIN, 42));
    maxSpin.setValue(Integer.valueOf(maxVar));

    JButton btnBack = new JButton("Back");
    btnBack.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent arg0) {
        RaffleParam.setVisible(false);
        Home.setVisible(true);

      }
    });

    JButton btnOk = new JButton("Ok");
    btnOk.setFont(new Font("Tahoma", Font.PLAIN, 36));
    btnOk.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {        
        RaffleParam.setVisible(false);
        Home.setVisible(false);
        raffleDraw.setVisible(true);
        func1((Integer) minSpin.getValue());        
        func2((Integer) maxSpin.getValue());
        System.out.println("minVar is "+minVar);
        System.out.println("maxVar is "+maxVar); 
        drawWinner = rand.nextInt(maxVar + 1 - minVar) + minVar;
      }
    });


    GridBagConstraints gbc_btnOk = new GridBagConstraints();
    gbc_btnOk.anchor = GridBagConstraints.NORTHWEST;
    gbc_btnOk.insets = new Insets(25, 100, 5, 5);
    gbc_btnOk.gridx = 2;
    gbc_btnOk.gridy = 3;
    RaffleParam.add(btnOk, gbc_btnOk);
    btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
    GridBagConstraints gbc_btnBack = new GridBagConstraints();
    gbc_btnBack.insets = new Insets(0, 0, 0, 5);
    gbc_btnBack.gridx = 0;
    gbc_btnBack.gridy = 4;
    RaffleParam.add(btnBack, gbc_btnBack);
    
        //setup draw button
        JButton setupDraw = new JButton("Member's Draw");
        setupDraw.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {

            JFileChooser fileChooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("CSV files", new String[] {"csv"});
            fileChooser.setFileFilter(filter);
            File selectedFile = null;
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
            int result = fileChooser.showOpenDialog(setupDraw);
            if (result == JFileChooser.APPROVE_OPTION) {
              selectedFile = fileChooser.getSelectedFile();
              filePath = selectedFile.getAbsolutePath().toString();
              System.out.println("Selected file: " + selectedFile.getAbsolutePath());
              Home.setVisible(false);
              membersDraw.setVisible(true);
            } 
          }
        });        
        setupDraw.setFont(new Font("Tahoma", Font.PLAIN, 36));
        GridBagConstraints gbc_setupDraw = new GridBagConstraints();
        gbc_setupDraw.anchor = GridBagConstraints.SOUTH;
        gbc_setupDraw.insets = new Insets(100, 0, 5, 5);
        gbc_setupDraw.gridx = 2;
        gbc_setupDraw.gridy = 0;
        Home.add(setupDraw, gbc_setupDraw);

    JLabel lblLogo = new JLabel("");
    lblLogo.setIcon(new ImageIcon(Frame1.class.getResource("/memdraw3/icon002.png")));
    lblLogo.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    GridBagConstraints gbc_lblLogo = new GridBagConstraints();
    gbc_lblLogo.insets = new Insets(0, 0, 5, 5);
    gbc_lblLogo.gridx = 2;
    gbc_lblLogo.gridy = 1;
    Home.add(lblLogo, gbc_lblLogo);
    
        JButton btnRaffleParam = new JButton("Raffle");
        btnRaffleParam.setFont(new Font("Tahoma", Font.PLAIN, 36));    
        btnRaffleParam.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent arg0) {
            RaffleParam.setVisible(true);
            Home.setVisible(false);
          }
        });
        
            // setup raffle button
            GridBagConstraints gbc_btnRaffleParam = new GridBagConstraints();
            gbc_btnRaffleParam.anchor = GridBagConstraints.NORTH;
            gbc_btnRaffleParam.insets = new Insets(0, 0, 100, 5);
            gbc_btnRaffleParam.gridx = 2;
            gbc_btnRaffleParam.gridy = 2;
            Home.add(btnRaffleParam, gbc_btnRaffleParam);
            
            JButton btnClose = new JButton("Close");
            btnClose.addActionListener(new ActionListener() {
              public void actionPerformed(ActionEvent arg0) {
                System.exit(0);
              }
            });
            btnClose.setFont(new Font("Tahoma", Font.PLAIN, 24));
            GridBagConstraints gbc_btnClose = new GridBagConstraints();
            gbc_btnClose.gridx = 4;
            gbc_btnClose.gridy = 2;
            Home.add(btnClose, gbc_btnClose);



    JLabel lblRaffleNumber = new JLabel("Get Ready!");
    lblRaffleNumber.setHorizontalAlignment(SwingConstants.CENTER);
    lblRaffleNumber.setFont(lblRaffleNumber.getFont().deriveFont(190f));
    lblRaffleNumber.setBackground(Color.WHITE);
    GridBagConstraints gbc_lblRaffleNumber = new GridBagConstraints();
    gbc_lblRaffleNumber.anchor = GridBagConstraints.NORTH;
    gbc_lblRaffleNumber.insets = new Insets(0, 0, 5, 100);
    gbc_lblRaffleNumber.gridx = 1;
    gbc_lblRaffleNumber.gridy = 1;
    raffleDraw.add(lblRaffleNumber, gbc_lblRaffleNumber);

    JButton btnDraw = new JButton("Draw the Raffle!");
    btnDraw.setFont(new Font("Tahoma", Font.PLAIN, 36));
    btnDraw.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        drawWinner = rand.nextInt(maxVar + 1 - minVar) + minVar;
        lblRaffleNumber.setText(Integer.toString(drawWinner));

      }
    });
    
    JLabel label = new JLabel("");
    label.setIcon(new ImageIcon(Frame1.class.getResource("/memdraw3/icon002.png")));
    label.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
    GridBagConstraints gbc_label = new GridBagConstraints();
    gbc_label.insets = new Insets(0, 0, 5, 100);
    gbc_label.gridx = 1;
    gbc_label.gridy = 2;
    raffleDraw.add(label, gbc_label);
    GridBagConstraints gbc_btnDraw = new GridBagConstraints();
    gbc_btnDraw.insets = new Insets(0, 0, 5, 100);
    gbc_btnDraw.gridx = 1;
    gbc_btnDraw.gridy = 3;
    raffleDraw.add(btnDraw, gbc_btnDraw);

    JButton button = new JButton("Back");
    button.setFont(new Font("Tahoma", Font.PLAIN, 16));
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        raffleDraw.setVisible(false);
        Home.setVisible(true);
        lblRaffleNumber.setText("Get Ready!");
      }
    });

    GridBagConstraints gbc_button = new GridBagConstraints();
    gbc_button.insets = new Insets(0, 0, 50, 100);
    gbc_button.gridx = 1;
    gbc_button.gridy = 4;
    raffleDraw.add(button, gbc_button);



    
    lblMemNum.setHorizontalAlignment(SwingConstants.CENTER);
    lblMemNum.setFont(lblMemNum.getFont().deriveFont(190f));
    lblMemNum.setBackground(new Color(245, 255, 250));
    GridBagConstraints gbc_lblMemNum = new GridBagConstraints();
    gbc_lblMemNum.gridx = 1;
    gbc_lblMemNum.gridy = 0;
    membersDraw.add(lblMemNum, gbc_lblMemNum);

    JLabel lblMemName = new JLabel("");
    lblMemName.setHorizontalAlignment(SwingConstants.CENTER);
    lblMemName.setFont(new Font("Tahoma", Font.BOLD, 76));
    lblMemName.setBackground(new Color(245, 255, 250));
    GridBagConstraints gbc_lblMemName = new GridBagConstraints();
    gbc_lblMemName.insets = new Insets(0, 0, 100, 0);
    gbc_lblMemName.gridx = 1;
    gbc_lblMemName.gridy = 1;
    membersDraw.add(lblMemName, gbc_lblMemName);

    JButton btnMemDraw = new JButton("Draw the Member's Draw!");
    btnMemDraw.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        CSVReader.main(null);
        lblMemNum.setText(Frame1.winnerNum);
        lblMemName.setText(Frame1.winner);

        //        System.out.println("HERE!" + Frame1.winner);
        //  
      }
    });
    btnMemDraw.setFont(new Font("Tahoma", Font.PLAIN, 46));
    GridBagConstraints gbc_btnMemDraw = new GridBagConstraints();
    gbc_btnMemDraw.insets = new Insets(0, 0, 5, 5);
    gbc_btnMemDraw.gridx = 1;
    gbc_btnMemDraw.gridy = 2;
    membersDraw.add(btnMemDraw, gbc_btnMemDraw);

    JButton btnBack_1 = new JButton("Back");
    btnBack_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
    btnBack_1.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent arg0) {
        Home.setVisible(true);
        raffleDraw.setVisible(false);
        membersDraw.setVisible(false);
        lblMemNum.setText("Get Ready!");
        lblMemName.setText("");
      }
    });
    GridBagConstraints gbc_btnBack_1 = new GridBagConstraints();
    gbc_btnBack_1.insets = new Insets(0, 0, 0, 5);
    gbc_btnBack_1.gridx = 1;
    gbc_btnBack_1.gridy = 3;
    membersDraw.add(btnBack_1, gbc_btnBack_1);



  }

}
