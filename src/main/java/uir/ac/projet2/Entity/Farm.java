package uir.ac.projet2.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

/**
 * Created By Youssef on 10/05/2023
 *
 * @Author : Youssef
 * @Date : 10/05/2023
 * @Project : projet2
 */

@Entity
@Data
@Table(name = "farm")
public class Farm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFarm;

    @Column(name = "address")
    private String Address;

    @Column(name = "area")
    private String Area;

    @Column(name = "name")
    private String Name;

    @Column(name = "longitude")
    private double Longitude;

    @Column(name = "latitude")
    private double Latitude;

    @Column(name = "description")
    private String Description;

    @JsonIgnore
    @OneToMany
    @JoinTable(name = "farm_sensor"
            , joinColumns = @JoinColumn(name = "idFarm"), inverseJoinColumns = @JoinColumn(name = "idSensor"))
    private List<Sensor> sensorList;

    @JsonIgnore
    @OneToMany(mappedBy = "farm")
    private List<User_Farm_Link> userFarms;

    @Override
    public String toString() {
        return "Farm(idFarm=" + idFarm + ", Address=" + Address + ", Area=" + Area + ", Name=" + Name + ", Longitude=" + Longitude + ", Latitude=" + Latitude + ", Description=" + Description + ", sensorCount=" + (sensorList != null ? sensorList.size() : 0) + ", userFarms=" + userFarms + ")";
    }

}
