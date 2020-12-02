
package com.mindtree.service.impl.test;

public class CustomerServiceImplTest {

}

// package com.mindtree.service.impl.test;
//
// import static org.junit.Assert.fail;
//
// import org.junit.BeforeClass;
// import org.junit.Test;
// import org.junit.runner.RunWith;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;
// import org.mockito.Spy;
// import org.mockito.runners.MockitoJUnitRunner;
//
// import com.mindtree.entity.Customer;
// import com.mindtree.repository.CustomerRepository;
// import com.mindtree.service.impl.CustomerServiceImpl;
//
// @RunWith(MockitoJUnitRunner.class)
// public class CustomerServiceImplTest {
//
// @Mock
// private CustomerRepository customerRepository;
//
// @InjectMocks
// private CustomerServiceImpl customerService;
//
// @Spy
// private Customer customerPersonalDetails = new Customer();
//
// @BeforeClass
// public void testSetup() throws Exception {
//
// MockitoAnnotations.initMocks(this);
//
// customerPersonalDetails = getCustomerPersonalDetailsDummyData();
//
// }
//
// @Test
// public void getDoctorPersonalDetailsTest1() {
// when(doctorDao.getDoctorPersonalDetails("nikhil@gmail.com")).thenReturn(doctorPersonalDetails);
// assertEquals("Nikhil", doctorPersonalDetails.getDoctorName());
// }
//
// public DoctorPersonalDetails getCustomerPersonalDetailsDummyData() {
// DoctorPersonalDetails doctorDetails = new DoctorPersonalDetails();
//
// DoctorLogin doctorLogin = new DoctorLogin();
// doctorLogin.setDoctorEmailId("nikhil@gmail.com");
// doctorLogin.setDoctorPassword("Nikhil@123");
// doctorLogin.setDoctorStatus("Approved");
//
// Location location = new Location();
// location.setCityName("Bhubaneshwar");
// location.setCountryName("India");
// location.setCityPincode("495001");
// location.setStateName("Odhisa");
//
// doctorDetails.setDoctorAddress("Mindtree kalinga");
// doctorDetails.setDoctorAge(24);
// doctorDetails.setDoctorConsultationCharges(300);
// doctorDetails.setDoctorEndTime("17:00 PM");
// doctorDetails.setDoctorExprience(2);
// doctorDetails.setDoctorGender("male");
// doctorDetails.setDoctorLicense("M10774");
// doctorDetails.setDoctorLogin(doctorLogin);
// doctorDetails.setDoctorName("Nikhil");
// doctorDetails.setDoctorPhoneNumber("9876799890");
// doctorDetails.setDoctorPhotoUrl("");
// doctorDetails.setDoctorSpeciality("Genral Physician");
// doctorDetails.setDoctorStartTime("09:00 AM");
// doctorDetails.setLocation(location);
//
// return doctorDetails;
//
// }
// }
