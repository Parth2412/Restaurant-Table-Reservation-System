/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class user {
    @Id
    @GeneratedValue
    private long user_id;
    private String user_name;
    private String user_password;
    private long user_contact_no;
    @Column(unique=true,nullable=false)
    private String user_email;

    public user()
    {
    }
    
    public user(String user_name, String user_password, long user_contact_no, String user_email) {
        this.user_name = user_name;
        this.user_password = user_password;
        this.user_contact_no = user_contact_no;
        this.user_email = user_email;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public long getUser_contact_no() {
        return user_contact_no;
    }

    public void setUser_contact_no(long user_contact_no) {
        this.user_contact_no = user_contact_no;
    }

    public String getUser_email() {
        return user_email;
    }

    public void setUser_email(String user_email) {
        this.user_email = user_email;
    }
    
    
}
