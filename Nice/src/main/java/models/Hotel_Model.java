package models;




import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Hotel_Model {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long hid;

private String name;

private boolean isAvailable=true;

public Hotel_Model(Long hid, String name, boolean isAvailable) {
	super();
	this.hid = hid;
	this.name = name;
	this.isAvailable = isAvailable;
}

public Long getHid() {
	return hid;
}

public void setHid(Long hid) {
	this.hid = hid;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public boolean isAvailable() {
	return isAvailable;
}

public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}


}
