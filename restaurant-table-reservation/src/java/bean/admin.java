
package bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class admin {
    @Id
    @GeneratedValue
    private long admin_id;
    private String admin_name;
    private String admin_password;
    
    @Column(unique=true,nullable=false)
    private String admin_email;

    public admin()
    {
    }

    public admin(String admin_name, String admin_password, String admin_email) {
        this.admin_name = admin_name;
        this.admin_password = admin_password;
        this.admin_email = admin_email;
    }
    
    

    public long getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(long admin_id) {
        this.admin_id = admin_id;
    }

    public String getAdmin_name() {
        return admin_name;
    }

    public void setAdmin_name(String admin_name) {
        this.admin_name = admin_name;
    }

    public String getAdmin_password() {
        return admin_password;
    }

    public void setAdmin_password(String admin_password) {
        this.admin_password = admin_password;
    }

    public String getAdmin_email() {
        return admin_email;
    }

    public void setAdmin_email(String admin_email) {
        this.admin_email = admin_email;
    }

  
}
