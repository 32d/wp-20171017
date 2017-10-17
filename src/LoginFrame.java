import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class LoginFrame extends JFrame {
    private Container cp;
    private JButton btn[] = new JButton[9];
    private JTextField tf = new JTextField();
    private JPanel pan = new JPanel(new GridLayout(3,3));
    private MainFrame log;

    public LoginFrame(MainFrame Login){
        log = Login;
        init();
    }
    private void init(){
        this.setBounds(100,100,600,600);
        cp= this.getContentPane();
        cp.setLayout(new BorderLayout(3,3));
        cp.add(tf,BorderLayout.NORTH);
        cp.add(pan,BorderLayout.CENTER);
        tf.setEditable(false);
        for(int i=0;i<9;i++){
            btn[i]=new JButton();
            pan.add(btn[i]);
            btn[i].setText(Integer.toString(i));
            btn[i].addActionListener(new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton tmp =(JButton) e.getSource();
                    tf.setText(tf.getText()+ tmp .getText());
                }
            });
        }
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                log.setVisible(true);
                dispose();
            }
        });



    }

}
