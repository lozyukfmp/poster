package com.lozyukartem.poster.entity;

public class User {
    private int id;
    private String username;
    private String password;
    private String firstname;
    private String secondname;
    private String thirdname;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    public String getThirdname() {
        return thirdname;
    }

    public void setThirdname(String thirdname) {
        this.thirdname = thirdname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (getUsername() != null ? !getUsername().equals(user.getUsername()) : user.getUsername() != null)
            return false;
        if (getPassword() != null ? !getPassword().equals(user.getPassword()) : user.getPassword() != null)
            return false;
        if (getFirstname() != null ? !getFirstname().equals(user.getFirstname()) : user.getFirstname() != null)
            return false;
        if (getSecondname() != null ? !getSecondname().equals(user.getSecondname()) : user.getSecondname() != null)
            return false;
        if (getThirdname() != null ? !getThirdname().equals(user.getThirdname()) : user.getThirdname() != null)
            return false;
        return getPhone() != null ? getPhone().equals(user.getPhone()) : user.getPhone() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode() : 0);
        result = 31 * result + (getFirstname() != null ? getFirstname().hashCode() : 0);
        result = 31 * result + (getSecondname() != null ? getSecondname().hashCode() : 0);
        result = 31 * result + (getThirdname() != null ? getThirdname().hashCode() : 0);
        result = 31 * result + (getPhone() != null ? getPhone().hashCode() : 0);
        return result;
    }
}
