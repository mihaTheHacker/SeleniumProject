package ObjectData;

import java.util.HashMap;

public class PracticeFormObject {

    private String firstName;
    private String lastName;
    private String email;
    private String mobileNumber;
    private String currentAddress;

    public PracticeFormObject(HashMap<String, String> testData) {
        populateData(testData);

    }

    public void populateData(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "firstName":
                    setFirstName(testData.get(key));
                    break;
                case "lastName":
                    setLastName(testData.get(key));
                    break;
                case "email":
                    setEmail(testData.get(key));
                    break;
                case "mobileNumber":
                    setMobileNumber(testData.get(key));
                    break;
                case "currentAddress":
                    setAddress(testData.get(key));
                    break;
            }


        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getcurrentAddress() {
        return currentAddress;
    }

    public void setAddress(String address) {
        this.currentAddress = address;
    }
}
