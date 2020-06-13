package et.com.synctech.mobileappexam.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import com.orm.SugarRecord;

public class Employee extends SugarRecord{
    
    @SerializedName("id")
    @Expose
    private String empId;

    @SerializedName("employee_name")
    @Expose
    private String name;

    @SerializedName("employee_salary")
    @Expose
    private String salary;

    @SerializedName("employee_age")
    @Expose
    private String age;

    @SerializedName("profile_image")
    @Expose
    private String profileImage;

    public Employee(){
    }

    public Employee(String empId,String employeeName,String employeeSalary,String employeeAge,String profileImage){
        this.empId=empId;
        this.name=employeeName;
        this.salary=employeeSalary;
        this.age=employeeAge;
        this.profileImage=profileImage;
    }

    public void setEmpId(String id) {
        this.empId=id;
    }
    public String getEmpId() {
        return empId;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }
    public String getSalary() {
        return salary;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String getAge() {
        return age;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }
    public String getProfileImage() {
        return profileImage;
    }
}
