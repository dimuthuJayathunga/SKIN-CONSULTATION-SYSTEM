import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class WestminsterSkinConsultationManagerTest {

    ArrayList<Doctor> doctorsTest = new ArrayList<>();
    Doctor doctor = new Doctor();
    WestminsterSkinConsultationManager westminister = new WestminsterSkinConsultationManager();

    @Test
    public void addDoctorTest() throws ParseException {
        String userInput = "Saman\nChandrapala\nDOB\n1919\n12345\nMedical_Dermatology";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(userInput.getBytes());
        System.setIn(inputStream);
        westminister.addDoctor(doctorsTest);
        assertEquals("Saman", doctorsTest.get(0).getName());
        assertEquals("Chandrapala", doctorsTest.get(0).getSurName());
        assertEquals("DOB", doctorsTest.get(0).getDob());
        assertEquals(1919, doctorsTest.get(0).getMblNumber());
        assertEquals("12345", doctorsTest.get(0).getMedId());
        assertEquals("Medical_Dermatology", doctorsTest.get(0).getSpecialisation());
    }
}