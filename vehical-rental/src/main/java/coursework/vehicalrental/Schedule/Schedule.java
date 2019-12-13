package coursework.vehicalrental.Schedule;

import com.sun.org.apache.xml.internal.dtm.ref.sax2dtm.SAX2DTM2;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Schedule")
public class Schedule {

    @Id
    private String id;
    private String nic;
    private String plateNO;
    private Date pickUpDate;
    private Date dropOffDate;
    private String custName;

    public Schedule(String custName, String id, String nic, String plateNO, Date pickUpDate, Date dropOffDate) {
        this.custName = custName;
        this.id = id;
        this.nic = nic;
        this.plateNO = plateNO;
        this.pickUpDate = pickUpDate;
        this.dropOffDate = dropOffDate;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getNic() {
        return nic;
    }

    public void setNic(String nic) {
        this.nic = nic;
    }

    public String getPlateNO() {
        return plateNO;
    }

    public void setPlateNO(String plateNO) {
        this.plateNO = plateNO;
    }


    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public Date getDropOffDate() {
        return dropOffDate;
    }

    public void setDropOffDate(Date dropOffDate) {
        this.dropOffDate = dropOffDate;
    }
}