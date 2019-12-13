package coursework.vehicalrental.User;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "User")
public class User {

    private String name;
    private String contactNo;

    /*public User(String name, String contactNo){
        this.contactNo=contactNo;
        this.name=name;
    }*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


}

