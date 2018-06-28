package app.enity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.util.Date;

@Entity
@Table(name = "respodent")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Respodent {

    @Id
    @SequenceGenerator(name="respodent_user_id_seq",sequenceName="respodent_user_id_seq")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="respodent_user_id_seq")
    @Column(name = "user_id",nullable = false)
    private int userId;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "date_of_birth")
    private Date dateOfB;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfB() {
        return dateOfB;
    }

    public void setDateOfB(Date dateOfB) {
        this.dateOfB = dateOfB;
    }
}
