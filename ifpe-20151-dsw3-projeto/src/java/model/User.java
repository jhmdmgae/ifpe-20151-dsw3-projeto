package model;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Named;

@ManagedBean(name="user")
@RequestScoped
public class User {

    private String name;
    private Date birthDate;
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean equals(User user) {
        return this.getName().equalsIgnoreCase(user.getName()) 
                    && this.getBirthDate().equals(user.getBirthDate());
    }
}
