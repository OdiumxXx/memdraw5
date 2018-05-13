package memdraw3;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Panel;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Frame3 {

  private JFrame frmMembersDraw;
  private JTextField raffleFromField;
  private JTextField raffleToField;

  /**
   * Launch the application.
   */
  public static void main(String[] args) {
    EventQueue.invokeLater(new Runnable() {
      public void run() {
        try {
          Frame3 window = new Frame3();
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
  public Frame3() {
    initialize();
  }

  /**
   * Initialize the contents of the frame.
   */
  private void initialize() {
    frmMembersDraw = new JFrame();
    frmMembersDraw.setTitle("members draw");
    frmMembersDraw.setBounds(100, 100, 600, 300);
    frmMembersDraw.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frmMembersDraw.getContentPane().setLayout(null);
    
    
    Panel panel = new Panel();
    panel.setBounds(155, 0, 251, 255);
    // add panel
     frmMembersDraw.getContentPane().add(panel);
     panel.setLayout(null);
     panel.setVisible(false);
     
  // set raffle parameters button
     JButton btnRaffle = new JButton("Raffle");
     btnRaffle.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent arg0) {
        panel.setVisible(true);
        
       }
     });
     
     raffleFromField = new JTextField();
     raffleFromField.setBounds(115, 47, 86, 20);
     panel.add(raffleFromField);
     raffleFromField.setColumns(10);
     
     raffleToField = new JTextField();
     raffleToField.setBounds(115, 92, 86, 20);
     panel.add(raffleToField);
     raffleToField.setColumns(10);
     
     JLabel lblFrom = new JLabel("From");
     lblFrom.setBounds(38, 50, 46, 14);
     panel.add(lblFrom);
     
     JLabel lblTo = new JLabel("To");
     lblTo.setBounds(38, 95, 46, 14);
     panel.add(lblTo);
     
     JButton btnOk = new JButton("Ok");
     btnOk.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent arg0) {
         panel.setVisible(false);
         
         @SuppressWarnings("unused")
        int raffleFrom = 0;
         if (raffleFromField.getText() != null) {
           raffleFrom = Integer.parseInt(raffleFromField.getText());
         }
         @SuppressWarnings("unused")
        int raffleTo  = 0; 
         if (raffleToField.getText() != null) {
           raffleTo = Integer.parseInt(raffleToField.getText());
         }
         
       }
     });
     btnOk.setBounds(85, 157, 89, 23);
     panel.add(btnOk);
    btnRaffle.setBounds(216, 191, 126, 46);
    frmMembersDraw.getContentPane().add(btnRaffle);
   // set members draw button 
    JButton btnMembersDraw = new JButton("Member's Draw");
    btnMembersDraw.setBounds(216, 35, 126, 46);
    frmMembersDraw.getContentPane().add(btnMembersDraw);
    
  
  }
}
