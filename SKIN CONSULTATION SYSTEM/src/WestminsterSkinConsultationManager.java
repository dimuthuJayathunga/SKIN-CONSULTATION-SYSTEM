import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class WestminsterSkinConsultationManager {


    public static void Console() throws IOException {
        Scanner input = new Scanner(System.in);
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Consultation> consultations = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            System.out.println("\n------------------------------------------------------------------------");
            System.out.println("                            *** * Console Menu * ***");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("1: Add a new doctor");
            System.out.println("2: Delete a doctor");
            System.out.println("3: Print the list of the doctors");
            System.out.println("4: Save in a file");
            System.out.println("5: Open gui");

            System.out.print("Option :");  // Output user input
            String option = input.nextLine();  // Read user input
            System.out.println(" ");

            switch (option) {
                case "1" -> addDoctor(doctors);
                case "2" -> delDoctor(doctors);
                case "3" -> printDoctor(doctors);
                case "4" -> saveData(doctors);
                case "5" -> GUI.openGui(doctors, consultations);
                default -> System.out.println("Please Enter Valid Number.");
            }

        }

    }

    //add doctor
    public static void addDoctor(ArrayList<Doctor> doctors) {
        try {
            Scanner input = new Scanner(System.in);
            for (int i = 0; i < 10; i++) {

                System.out.print("Name :");
                String name = input.nextLine();

                System.out.print("SurName:");
                String surName = input.nextLine();

                System.out.print("Date of Birth :");
                String dob = input.nextLine();

                System.out.print("Mobile Number :");
                String mblNumber = input.nextLine();

                System.out.print("Licence Number :");
                String medId = input.nextLine();

                System.out.print("Specialisation :");
                String specialisation = input.nextLine();

                Doctor doctor = new Doctor();
                doctor.setName(name);
                doctor.setSurName(surName);
                doctor.setDob(dob);
                doctor.setMblNumber(Integer.parseInt(mblNumber));
                doctor.setMedId(medId);
                doctor.setSpecialisation(specialisation);
                doctors.add(doctor);

                System.out.println(doctors);

                System.out.print("Press 'y' if you want to exit otherwise press any key :");
                String yA = input.nextLine();
                if (yA.equals("y")) {
                    break;
                }


            }
        } catch (Exception e) {
            System.out.println(" ");
            System.out.println("Invalid input !!" );
        }

    }

    //delete Doctor
    private static void delDoctor(ArrayList<Doctor> doctors) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the medical license number of the doctor to remove: ");
        String enterId = input.nextLine();

        Doctor doctor = null;
        for (Doctor d : doctors) {
            if (d.getMedId().equals(enterId)) {
                doctor = d;
                break;
            }
        }
        if (doctor == null) {
            System.out.println("No doctor was found with the specified license number.");
        } else {
            doctors.remove(doctor);
            System.out.println("The doctor with name " + doctor.getName() + " " + doctor.getSurName() + " and license number " + doctor.getMedId() + " has been removed.");
            System.out.println("The centre now has " + doctors.size() + " doctors.");

        }
    }

    //print Doctor
    private static void printDoctor(ArrayList<Doctor> doctors) {
        doctors.sort(new Comparator<Doctor>() {
            @Override
            public int compare(Doctor d1, Doctor d2) {
                return d1.getSurName().compareTo(d2.getSurName());
            }
        });
        for (Doctor doctor : doctors) {
            System.out.println("Doctor name: " + doctor.getName() + " " + doctor.getSurName());
            System.out.println("Medical license number: " + doctor.getMedId());
            System.out.println("Specialization: " + doctor.getSpecialisation());
            System.out.println();

        }
    }

    //Save in a file
    private static void saveData(ArrayList<Doctor> doctors) throws FileNotFoundException {
        File infoFile = new File("SaveTextFile.txt");
        PrintStream writer = new PrintStream(infoFile);

        for (Doctor doctor : doctors) {
            writer.println("Doctor name: " + doctor.getName());
            writer.println("Doctor Surname: " + doctor.getSurName());
            writer.println("Specialization: " + doctor.getSpecialisation());
            writer.println("LicenceNum: " + doctor.getMedId());
            writer.println("\n");
        }
        System.out.println("Successfully Saved...");
        writer.close();

    }
}
