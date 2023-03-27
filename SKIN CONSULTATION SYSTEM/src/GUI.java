import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Comparator;

                          /*---------------------GUI---------------------------*/
public class GUI {

    static void openGui(ArrayList<Doctor> doctors, ArrayList<Consultation> consultations) {
        JFrame mc = new JFrame();
        JPanel panel = new JPanel();
        panel.setBackground(Color.lightGray);
        mc.getContentPane();

        JLabel Menu = new JLabel("MENU");
        Menu.setFont(new Font("serif", Font.BOLD, 30));
        Menu.setSize(300, 30);
        Menu.setLocation(200, 30);
        panel.add(Menu);


        JButton vdButton = new JButton(" View All Doctors");
        vdButton.addActionListener(e ->
                {
                    viewDoctor(doctors);
                }
        );
        Dimension size1 = vdButton.getPreferredSize();
        vdButton.setBounds(175, 80, size1.width, size1.height);
        panel.setLayout(null);
        panel.add(vdButton);

        JButton cdButton = new JButton(" Chanel a Doctor ");
        cdButton.addActionListener(e ->
                {
                    bookDoctor(doctors,consultations);
                }
        );


        Dimension size2 = cdButton.getPreferredSize();
        cdButton.setBounds(175, 120, size2.width, size2.height);
        panel.setLayout(null);
        panel.add(cdButton);


        JButton vcButton = new JButton("    View Chanel    ");
        vcButton.addActionListener(e ->
                {
                    viewChannel(doctors,consultations);
                }
        );


        Dimension sizeViewChnl = vcButton.getPreferredSize();
        vcButton.setBounds(175, 160, sizeViewChnl.width, sizeViewChnl.height);
        panel.setLayout(null);
        panel.add(vcButton);

        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        mc.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mc.add(panel);
        mc.setLocation(400,70);
        mc.setSize(500, 300);
        mc.setVisible(true);
    }

    /*----------------------GUI view channel---------------------------*/
    private static void viewChannel(ArrayList<Doctor> doctors, ArrayList<Consultation> consultations) {

        JFrame vc = new JFrame();
        JPanel panel = new JPanel();
        vc.getContentPane();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.setBackground (Color.lightGray);
        vc.add(panel);
        vc.setSize(500, 300);
        vc.setVisible(true);

        JLabel  vcNameLabel = new JLabel("Enter Your Name:");
        vcNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension size1EntrName = vcNameLabel.getPreferredSize();
        vcNameLabel.setBounds(80, 70, size1EntrName.width, size1EntrName.height);
        panel.setLayout(null);
        panel.add(vcNameLabel);

        JTextField vcNameTxt = new JTextField();
        vcNameTxt.setSize(150,20);
        vcNameTxt.setLocation(270, 70);
        panel.add(vcNameTxt);

        JLabel vcSurNameLabel = new JLabel("Enter Your SurName:");
        vcSurNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension size1entrSurName = vcSurNameLabel.getPreferredSize();
        vcSurNameLabel.setBounds(80, 120, size1entrSurName.width, size1entrSurName.height);
        panel.setLayout(null);
        panel.add(vcSurNameLabel);

        JTextField vcSurNameTxt = new JTextField();
        vcSurNameTxt.setSize(150,20);
        vcSurNameTxt.setLocation(270, 120);
        panel.add(vcSurNameTxt);

        JButton res = new JButton(" Reset ");
        Dimension sizeReast = res.getPreferredSize();
        res.setBounds(180, 200, sizeReast.width, sizeReast.height);
        panel.add(res);
        res.addActionListener(e ->{
            vcNameTxt.setText("");
            vcSurNameTxt.setText("");

        });


        JButton btn = new JButton("Submit");
        Dimension sizeSubmit = btn.getPreferredSize();
        btn.setBounds(180, 170, sizeSubmit.width, sizeSubmit.height);
        btn.addActionListener(e ->
                {
                    JFrame onlyTable = new JFrame();
                    JPanel panelOnly = new JPanel();
                    onlyTable.getContentPane();
                    panelOnly.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                    onlyTable.add(panelOnly);
                    onlyTable.setSize(1300, 800);
                    onlyTable.setVisible(true);

                    String[] cols = { "Date", "Doctor Name", "Start Time(24-hour format)", "End Time(24-hour format)","Cost","Description" };
                    DefaultTableModel tableM = new DefaultTableModel(cols, 0);
                    JTable table = new JTable(tableM);
                    JScrollPane sp = new JScrollPane(table);
                    onlyTable.add(sp);

                    ArrayList<Consultation> c1=new ArrayList<>();
                    for (Consultation consultation:consultations) {

                        if (consultation.getPtntName().equals(vcNameTxt.getText())){

                            if (consultation.getPtnSurName().equals(vcSurNameTxt.getText())){

                                c1.add(consultation);
                            }

                        }


                    }
                    for (Consultation consultation:c1) {

                        String date = consultation.getDate();
                        String dctrName = consultation.getDctrName();
                        String Start_Time = consultation.getStartTime();
                        String End_Time = consultation.getEndTime();
                        int Cost = consultation.getCost();
                        String Notes = consultation.getNotes();

                        Object[] data = {date, dctrName, Start_Time, End_Time, Cost, Notes};

                        tableM.addRow(data);


                    }
                }
        );
        panel.add(btn);



    }

    /*------------------ GUI book Doctor ---------------*/

    private static void bookDoctor(ArrayList<Doctor> doctors, ArrayList<Consultation> consultations) {
        JFrame bd = new JFrame();
        JPanel panel = new JPanel();
        bd.getContentPane();
        panel.setBackground ((Color.lightGray));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        bd.add(panel);
        bd.setSize(600, 800);
        bd.setVisible(true);


        JLabel bdPatientInfo = new JLabel("Patient Information");
        bdPatientInfo.setFont(new Font("serif", Font.BOLD, 30));
        bdPatientInfo.setSize(300, 30);
        bdPatientInfo.setLocation(60, 30);
        panel.add(bdPatientInfo);

        //Name
        JLabel bdNameLabel= new JLabel("Patient Name:");
        bdNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension size1 = bdNameLabel.getPreferredSize();
        bdNameLabel.setBounds(90, 85, size1.width, size1.height);
        panel.setLayout(null);
        panel.add(bdNameLabel);

        JTextField bdNameTxt = new JTextField();
        bdNameTxt.setSize(150,20);
        bdNameTxt.setLocation(260, 85);
        panel.add(bdNameTxt);

        //surName
        JLabel bdSurNameLabel = new JLabel("Patient SurName:");
        bdSurNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension size5 = bdSurNameLabel.getPreferredSize();
        bdSurNameLabel.setBounds(90, 125, size5.width, size5.height);
        panel.setLayout(null);
        panel.add(bdSurNameLabel);

        JTextField bdSurNameTxt = new JTextField();
        bdSurNameTxt.setSize(150,20);
        bdSurNameTxt.setLocation(260, 125);
        panel.add(bdSurNameTxt);

        //datePicker
        JLabel bdDobLabel = new JLabel("Date of Birth:");
        bdDobLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension sizedate = bdDobLabel.getPreferredSize();
        bdDobLabel.setBounds(90, 165, sizedate.width, sizedate.height);
        panel.setLayout(null);
        panel.add(bdDobLabel);

        JTextField bdDobTxt = new JTextField(20);
        bdDobTxt.setSize(150,20);
        bdDobTxt.setLocation(260, 165);
        panel.add(bdDobTxt);

        JButton bdDobPopup = new JButton("Popup");
        Dimension sizePopup = bdDobPopup.getPreferredSize();
        bdDobPopup.setBounds(420, 162, sizePopup.width, sizePopup.height);
        panel.add(bdDobPopup);
        bdDobPopup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                bdDobTxt.setText(new DatePicker(bd).setPickedDate());
            }
        });


        JLabel  bdTelLabel = new JLabel("Telephone No:");
        bdTelLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension size7 = bdTelLabel.getPreferredSize();
        bdTelLabel.setBounds(90, 205, size7.width, size7.height);
        panel.setLayout(null);
        panel.add(bdTelLabel);

        JTextField bdTelTxt = new JTextField();
        bdTelTxt.setSize(150,20);
        bdTelTxt.setLocation(260, 205);
        panel.add(bdTelTxt);

        JLabel bdConsultInfo = new JLabel("Consult Information");
        bdConsultInfo.setFont(new Font("Serif", Font.BOLD, 30));
        bdConsultInfo.setSize(300, 30);
        bdConsultInfo.setLocation(60, 260);
        panel.add(bdConsultInfo);


        JLabel bdDateLabel = new JLabel("Date:");
        bdDateLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension sizeDob = bdDateLabel.getPreferredSize();
        bdDateLabel.setBounds(90, 320, sizeDob.width, sizeDob.height);
        panel.setLayout(null);
        panel.add(bdDateLabel);

        JTextField bdDateTxt = new JTextField(20);
        bdDateTxt.setSize(150,20);
        bdDateTxt.setLocation(260, 320);
        panel.add(bdDateTxt);

        JButton bdDatePopup = new JButton("Popup");
        Dimension size = bdDatePopup.getPreferredSize();
        bdDatePopup.setBounds(420, 315, size.width, size.height);
        panel.add(bdDatePopup);
        bdDatePopup.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                bdDateTxt.setText(new DatePicker(bd).setPickedDate());
            }
        });

        JLabel bdStartLabel = new JLabel("Start Time(24-hour):");
        bdStartLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension size9 = bdStartLabel.getPreferredSize();
        bdStartLabel.setBounds(90, 360, size9.width, size9.height);
        panel.setLayout(null);
        panel.add(bdStartLabel);



        String []startTimeArray=new String[18];
        for (int i = 1; i < 18; i++) {
            startTimeArray[i]= String.valueOf(i);
        }

        JComboBox StartCombo = new JComboBox(startTimeArray);
        StartCombo.setSize(150,20);
        StartCombo.setLocation(260, 360);
        panel.add(StartCombo);


        String []h=new String[100];
        for (int i = 0; i <7; i++) {
            h[i]= String.valueOf(i+1);
        }

        JLabel bdHoursLabel = new JLabel("Hours");
        bdHoursLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension sizehrs = bdHoursLabel.getPreferredSize();
        bdHoursLabel.setBounds(90, 400, sizehrs.width, sizehrs.height);
        panel.setLayout(null);
        panel.add(bdHoursLabel);


        JComboBox HoursCombo=new JComboBox(h);
        HoursCombo.setSize(150,20);
        HoursCombo.setLocation(260, 400);
        panel.add(HoursCombo);

        JLabel bdEndLabel = new JLabel("End Time(24-hour):");
        bdEndLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension size10 = bdEndLabel.getPreferredSize();
        bdEndLabel.setBounds(90, 440, size10.width, size10.height);
        panel.setLayout(null);
        panel.add(bdEndLabel);

        JTextField bdEndTxt = new JTextField();
        bdEndTxt.setSize(150,20);
        bdEndTxt.setLocation(260, 440);
        panel.add(bdEndTxt);

        HoursCombo.addActionListener(e ->{
            int getStartTime= Integer.parseInt(StartCombo.getSelectedItem().toString());

            int howMnyHurs= Integer.parseInt(HoursCombo.getSelectedItem().toString());
            int endManualfinalTime=getStartTime+howMnyHurs;
            bdEndTxt.setText(String.valueOf(endManualfinalTime));
        } );



        String []dctrName=new String[10];
        for (int i = 0; i < doctors.size(); i++) {
            dctrName[i]=doctors.get(i).getName();
        }


        JLabel  bdDocNameLabel = new JLabel("Doctor Name:");
        bdDocNameLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension size11 = bdDocNameLabel.getPreferredSize();
        bdDocNameLabel.setBounds(90, 480, size11.width, size11.height);
        panel.setLayout(null);
        panel.add(bdDocNameLabel);

        JComboBox bdDocNameTxt=new JComboBox(dctrName);
        bdDocNameTxt.setSize(150,20);
        bdDocNameTxt.setLocation(260, 480);
        panel.add(bdDocNameTxt);

        JLabel  bdDesLabel = new JLabel("Description");
        bdDesLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension size12 = bdDesLabel.getPreferredSize();
        bdDesLabel.setBounds(90, 520, size12.width, size12.height);
        panel.setLayout(null);
        panel.add(bdDesLabel);

        JTextField bdDesTxt = new JTextField();
        bdDesTxt.setSize(150,20);
        bdDesTxt.setLocation(260, 520);
        panel.add(bdDesTxt);

        JLabel  bdFirstConsult = new JLabel("Is This your first consult this doctor:");
        bdFirstConsult.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension sizeCalCost = bdFirstConsult.getPreferredSize();
        bdFirstConsult.setBounds(90, 560, sizeCalCost.width, sizeCalCost.height);
        panel.setLayout(null);
        panel.add(bdFirstConsult);

        JButton yes = new JButton("Yes");
        Dimension sizeYes = yes.getPreferredSize();
        yes.setBounds(420, 560, sizeYes.width, sizeYes.height);
        panel.add(yes);


        JButton no = new JButton("No");
        Dimension sizeNo = no.getPreferredSize();
        no.setBounds(482, 560, sizeNo.width, sizeNo.height);
        panel.add(no);


        JLabel  bdCostLabel = new JLabel("Cost :");
        bdCostLabel.setFont(new Font("Serif", Font.PLAIN, 20));
        Dimension sizeCost = bdCostLabel.getPreferredSize();
        bdCostLabel.setBounds(90, 600, sizeCost.width, sizeCost.height);
        panel.setLayout(null);
        panel.add(bdCostLabel);

        JTextField bdCostTxt = new JTextField();
        bdCostTxt.setSize(150,20);
        bdCostTxt.setLocation(260, 600);
        panel.add(bdCostTxt);

        yes.addActionListener(e ->{
            int hourScale= Integer.parseInt(HoursCombo.getSelectedItem().toString());
            int finalCost=hourScale*15;
            bdCostTxt.setText(String.valueOf(finalCost));

        });
        no.addActionListener(e ->{
            int hourScaleNo= Integer.parseInt(HoursCombo.getSelectedItem().toString());
            int finalCost=hourScaleNo*25;
            bdCostTxt.setText(String.valueOf(finalCost));

        });

        //book doctor button
        JButton button = new JButton("Book Doctor");
        Dimension sizeBook = button.getPreferredSize();
        button.setBounds(250, 640, sizeBook.width, sizeBook.height);
        panel.add(button);
        button.addActionListener(e ->
        {
            System.out.println("book doctor start");

            Consultation consultation1 = new Consultation();
            consultation1.setDctrName(bdDocNameTxt.getSelectedItem().toString());
            consultation1.setDate(bdDateTxt.getText());
            consultation1.setStartTime(StartCombo.getSelectedItem().toString());
            consultation1.setNotes(bdDesTxt.getText());
            consultation1.setEndTime(bdEndTxt.getText());
            consultation1.setPtntName(bdNameTxt.getText());
            consultation1.setCost(Integer.parseInt(bdCostTxt.getText()));
            consultation1.setPtnDOB(bdDobTxt.getText());
            consultation1.setPtnTel(bdTelTxt.getText());
            consultation1.setPtnSurName(bdSurNameTxt.getText());

            if (consultations.isEmpty()){
                consultations.add(consultation1);
            }else {
                for (Consultation consultation:consultations) {
                    if (consultation.getDctrName().equals(consultation1.getDctrName())){
                        if (consultation.getDate().equals(consultation1.getDate())){
                            int c1= Integer.parseInt(consultation.getStartTime());
                            int c2= Integer.parseInt(consultation.getEndTime());
                            int d1= Integer.parseInt(consultation1.getEndTime());
                            int d2= Integer.parseInt(consultation1.getStartTime());
                            if (c1>d1 || c2<d2){
                                consultations.add(consultation1);
                            }else{
                                System.out.println("this doctor its booked..");
                                JOptionPane.showMessageDialog(null, "This doctor is currently booked.");
                            }
                        }else{
                            consultations.add(consultation1);

                        }

                    }else {
                        consultations.add(consultation1);

                    }
                }

            }
        });
        System.out.println("end");

    }

    /*-----------------------GUI view Doctor------------------------*/
    public static void viewDoctor(ArrayList<Doctor> doctors) {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        frame.getContentPane();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.add(panel);
        frame.setSize(500, 300);
        frame.setVisible(true);
        doctors.sort(new Comparator<Doctor>() {
            @Override
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurName().compareTo(d2.getSurName());
            }
        });
        String[] Col = { "Name", "Sure Name", "Dob", "Mobile No","license No","Specialisation" };
        DefaultTableModel tableM = new DefaultTableModel(Col, 0);
        JTable table = new JTable(tableM);
        JScrollPane sp = new JScrollPane(table);
        frame.add(sp);
        for (int i =0; i<doctors.size();i++) {
            String Name = doctors.get(i).getName();
            String surName = doctors.get(i).getSurName();
            String Dob = doctors.get(i).getDob();
            int mblNumber = doctors.get(i).getMblNumber();
            String licenseNumber = doctors.get(i).getMedId();
            String Specialisation = doctors.get(i).getSpecialisation();
            Object[] data = {Name, surName, Dob, mblNumber,licenseNumber,Specialisation};
            tableM.addRow(data);
        }
    }

}
