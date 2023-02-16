import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.util.*;
import com.toedter.calendar.JDateChooser;
public class signuptwo extends JFrame implements ActionListener{
    JTextField namet,fnamet,dobt,emailt,pan,aadhar,statet,pincodet;
    JButton next;
    JRadioButton male,female,other,married,single,syes,sno,eyes,eno;
    JDateChooser date;
    JComboBox income,religion,category,occupation,education;
    String formno;
    signuptwo(String formno){
        this.formno=formno;
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM  - PAGE 2");

        JLabel additionaldetails=new JLabel("Page 2: Additional Details");
        additionaldetails.setFont(new Font("Raleway",Font.BOLD,22));
        additionaldetails.setBounds(290,80,400,30);
        add(additionaldetails);

        JLabel name=new JLabel("Religion:");
        name.setFont(new Font("Raleway",Font.BOLD,20));
        name.setBounds(100,140,100,30);
        add(name);

        String valR[]={"Hindu","Muslim","Sikh","Christian","Others"};
        religion=new JComboBox(valR);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel fname=new JLabel("Category:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,200,30);
        add(fname);

        String valC[]={"General","OBC","SC","ST","Other"};
        category=new JComboBox(valC);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,200,30);
        add(dob);

        String Income[]={"Null","<1,50,000","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(Income);
        income.setBounds(300,240,400,30);
        income.setBackground(Color.WHITE);
        add(income);

        date=new JDateChooser();
        date.setForeground(new Color(105,105,105));
        date.setBounds(300,240,400,30);
        add(date);

        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,150,30);
        add(gender);

        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,315,200,30);
        add(email);

        String edu[]={"Non-Graduation","Graduation","Post-Graduation","Doctrate","Others"};
        education=new JComboBox(edu);
        education.setBounds(300,315,400,30);
        education.setBackground(Color.WHITE);
        add(education);

        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,300,30);
        add(marital);

        String occ[]={"Salaried","Self-Employed","Bussiness","Student","Retired","Others"};
        occupation=new JComboBox(occ);
        occupation.setBounds(300,390,400,30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address=new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,150,30);
        add(address);

        pan=new JTextField();
        pan.setBounds(300,440,400,30);
        pan.setFont(new Font("Arial",Font.BOLD,14));
        add(pan);

        JLabel city=new JLabel("Aadhar Number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,170,30);
        add(city);

        aadhar=new JTextField();
        aadhar.setBounds(300,490,400,30);
        aadhar.setFont(new Font("Arial",Font.BOLD,14));
        add(aadhar);

        JLabel state=new JLabel("Senior Citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,150,30);
        add(state);

        syes=new JRadioButton("Yes");
        syes.setBounds(300,540,100,30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno=new JRadioButton("No");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup smaritial=new ButtonGroup();
        smaritial.add(syes);
        smaritial.add(sno);

        JLabel pincode=new JLabel("Existing Account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,250,30);
        add(pincode);

        eyes=new JRadioButton("Yes");
        eyes.setBounds(300,590,100,30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno=new JRadioButton("No");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup emaritial=new ButtonGroup();
        emaritial.add(eyes);
        emaritial.add(eno);

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
        String sreligion=(String)religion.getSelectedItem();
        String scategory=(String)category.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syes.isSelected()){
            seniorcitizen="Yes";
        } else if (sno.isSelected()){
            seniorcitizen="No";
        }

        String existingaccount=null;

        if(eyes.isSelected()){
            existingaccount="Yes";
        }else if(eno.isSelected()){
            existingaccount="No";
        }

        String span=pan.getText();
        String saadhar=aadhar.getText();

        try{
            connection c1=new connection();
            String query="insert into signuptwo values('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadhar+"','"+existingaccount+"','"+seniorcitizen+"')";
            c1.s.executeUpdate(query);

            setVisible(false);
            new SignupThree(formno).setVisible(true);
        }catch(Exception e1){
            System.out.println(e1);
        }

    }
    public static void main(String[] args) {
        new signuptwo("");
    }
}

