import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    JButton signin,clear,signup;
    JTextField card;
    JPasswordField pinTF;
    login(){
        setTitle("ATM");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2=i1.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(250,40,400,40);
        add(text);

        JLabel cardno=new JLabel("CARD NO:");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        card=new JTextField();
        card.setBounds(300,150,230,30);
        card.setFont(new Font("Arial",Font.BOLD,14));
        add(card);

        JLabel pin=new JLabel("PIN:");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinTF=new JPasswordField();
        pinTF.setBounds(300,220,230,30);
        pinTF.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTF);

        signin=new JButton("SIGN IN");
        signin.setBounds(300,300,100,30);
        signin.setBackground(Color.BLACK);
        signin.setForeground(Color.white);
        signin.addActionListener(this);
        add(signin);

        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("SIGN UP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

        getContentPane().setBackground(Color.YELLOW);

        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource()==clear){
            card.setText("");
            pinTF.setText("");
        }else if(e.getSource()==signin){
            connection c=new connection();
            String cardnumber=card.getText();
            String pinnumber=pinTF.getText();
            String query="select * from login where cardnumber = '"+cardnumber+"' and pin = '"+pinnumber+"'";
            try{
                ResultSet rs=c.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch(Exception e1){
                System.out.println(e1);
            }
        }else if(e.getSource()==signup){
                setVisible(false);
                new signup().setVisible(true);
        }
    }
    public static void main(String[] args) {
        new login();
    }
}
