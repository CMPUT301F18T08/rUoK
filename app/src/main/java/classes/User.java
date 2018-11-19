package classes;

import io.searchbox.annotations.JestId;

/**
 * User class
 * @author  Yuhan Ye
 * @version 1.1
 */
public abstract class User {

    private String userName;
    private String password;
    private String gender;
    private String email;
    private String phoneNumber;
    private String userType;

    @JestId
    private String id;

    public User(){}

    /**
     * user constructor
     * @param userName
     * @param password
     * @param gender
     * @param email
     * @param phoneNumber
     * @param userType
     */
    public User(String userName, String password, String gender, String email, String phoneNumber, String userType){
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userType = userType;

    }

    /**
     * method to get user password
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * method to get username
     * @return username
     */
    public String getUserName() {
        return userName;
    }

    /**
     * method to get user email
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * method to get user gender
     * @return gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * method to get user phone number
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * method to get user type( patient/care provider)
     * @return usertype
     */
    public String getUserType() {
        return userType;
    }

    /**
     * method to set user type ( patient/care provider)
     * @param userType
     */
    public void setUserType(String userType) {
        this.userType= userType;
    }

    /**
     * method to set password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * method to set userName
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * method to set email
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * method to set gender
     * @param gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * method to set phoneNumber
     * @param phoneNumber
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}