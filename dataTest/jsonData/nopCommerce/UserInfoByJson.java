package jsonData.nopCommerce;

import commons.GlobalConstants;
import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import io.qameta.allure.internal.shadowed.jackson.databind.DeserializationFeature;
import io.qameta.allure.internal.shadowed.jackson.databind.ObjectMapper;

import java.io.File;

public class UserInfoByJson {

    public static UserInfoByJson getUserInfo() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(GlobalConstants.DATA_TEST_PATH + "userData.json"), UserInfoByJson.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("day")
    private String day;

    @JsonProperty("month")
    private String month;

    @JsonProperty("year")
    private String year;

    @JsonProperty("emailAddress")
    private String emailAddress;

    @JsonProperty("companyName")
    private String companyName;

    @JsonProperty("password")
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getYear() {
        return year;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPassword() {
        return password;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

}
