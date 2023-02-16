import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class signup extends JFrame implements ActionListener{
    long r;
    JTextField namet,fnamet,dobt,emailt,addresst,cityt,statet,pincodet;
    JButton next;
    JRadioButton male,female,other,married,single;
    JDateChooser date;
    signup(){
        setLayout(null);
        Random sc=new Random();
        r=Math.abs((sc.nextLong()%9000L)+1000L);

        JLabel formno=new JLabel("APPLICATION FORM NO. "+r);
        formno.setFont(new Font("Raleway",Font.BOLD,38));
        formno.setBounds(135,20,600,40);
        add(formno);

        JLabel personaldetails=new JLabel("Page 1: Personal Details");
        personaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        personaldetails.setBounds(290,80,400,30);
        add(personaldetails);

        JLabel name=new JLabel("Name:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        namet=new JTextField();
        namet.setBounds(300,140,400,30);
        namet.setFont(new Font("Arial",Font.BOLD,14));
        add(namet);

        JLabel fname=new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnamet=new JTextField();
        fnamet.setBounds(300,190,400,30);
        fnamet.setFont(new Font("Arial",Font.BOLD,14));
        add(fnamet);

        JLabel dob=new JLabel("Date of Birth:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,300,30);
        add(dob);

        date=new JDateChooser();
        date.setForeground(new Color(105,105,105));
        date.setBounds(300,240,400,30);
        add(date);

        JLabel gender=new JLabel("Gender:");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,150,30);
        add(gender);

        male=new JRadioButton("Male");
        male.setBounds(300,290,120,30);
        male.setBackground(Color.white);
        male.setFont(new Font("Raleway",Font.BOLD,20));
        male.setFont(new Font("Raleway",Font.ITALIC,15));

        female=new JRadioButton("Female");
        female.setBounds(450,290,120,30);
        female.setBackground(Color.white);
        female.setFont(new Font("Raleway",Font.ITALIC,15));
        add(male);
        add(female);

        ButtonGroup gendergroup=new ButtonGroup();
        gendergroup.add(male);
        gendergroup.add(female);

        JLabel email=new JLabel("Email Address:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,340,300,30);
        add(email);

        emailt=new JTextField();
        emailt.setBounds(300,340,400,30);
        emailt.setFont(new Font("Arial",Font.BOLD,14));
        add(emailt);

        JLabel marital=new JLabel("Marital Status:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,300,30);
        add(marital);

        married=new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.white);
        married.setFont(new Font("Raleway",Font.BOLD,20));
        married.setFont(new Font("Raleway",Font.ITALIC,15));

        single=new JRadioButton("Single");
        single.setBounds(450,390,100,30);
        single.setBackground(Color.white);
        single.setFont(new Font("Raleway",Font.ITALIC,15));

        other=new JRadioButton("Other");
        other.setBounds(600,390,100,30);
        other.setBackground(Color.white);
        other.setFont(new Font("Raleway",Font.ITALIC,15));
        add(married);
        add(single);
        add(other);

        ButtonGroup maritalgroup=new ButtonGroup();
        maritalgroup.add(married);
        maritalgroup.add(single);
        maritalgroup.add(other);

        JLabel address=new JLabel("Address:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,150,30);
        add(address);

        addresst=new JTextField();
        addresst.setBounds(300,440,400,30);
        addresst.setFont(new Font("Arial",Font.BOLD,14));
        add(addresst);

        JLabel city=new JLabel("City:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,100,30);
        add(city);

        cityt=new JTextField();
        cityt.setBounds(300,490,400,30);
        cityt.setFont(new Font("Arial",Font.BOLD,14));
        add(cityt);

        JLabel state=new JLabel("State:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,120,30);
        add(state);

        statet=new JTextField();
        statet.setBounds(300,540,400,30);
        statet.setFont(new Font("Arial",Font.BOLD,14));
        add(statet);

        JLabel pincode=new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,200,30);
        add(pincode);

        pincodet=new JTextField();
        pincodet.setBounds(300,590,400,30);
        pincodet.setFont(new Font("Arial",Font.BOLD,14));
        add(pincodet);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.white);
        setSize(850,800);
        setVisible(true);
        setLocation(350,10);

    }
    public void actionPerformed(ActionEvent e){
        String formno=""+r;
        String name=namet.getText();
        String fname=fnamet.getText();
        String dob=((JTextField) date.getDateEditor().getUiComponent()).getText();
        String gender=null;
        if(male.isSelected()){
            gender="Male";
        } else if (female.isSelected()){
            gender="Female";
        }
        String email=emailt.getText();
        String marital=null;
        if(married.isSelected()){
            marital="Married";
        }else if(single.isSelected()){
            marital="Single";
        } else if (other.isSelected()){
            marital="Others";
        }
        String address=addresst.getText();
        String city=cityt.getText();
        String state=statet.getText();
        String pin=pincodet.getText();

        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null,"Name is Required");
            }else{
                connection c=new connection();
                String query="insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+email+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+pin+"')";
                c.s.executeUpdate(query);

                setVisible(false);
                new signuptwo(formno).setVisible(true);
            }
        }catch(Exception e1){

        }

    }
    public static void main(String[] args) {
        new signup();
    }
}
