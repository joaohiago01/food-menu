package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Restaurant", uniqueConstraints = @UniqueConstraint(columnNames = {"cnpj"}))
public class Restaurant implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String cnpj;
	
	private String name;
	
	private String description;
	
	private String time_open;
	
	private String time_close;
	
	private boolean sunday_open;
	
	private boolean monday_open;
	
	private boolean tuesday_open;
	
	private boolean wednesday_open;
	
	private boolean thursday_open;
	
	private boolean friday_open;
	
	private boolean saturday_open;
	
	private String phone;
	
	private String cep;
	
	private String state;
	
	private String city;
		
	private String address;
	
	private String district;
	
	private String number;
	
	private String addition;
	
	private boolean delivery;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;
	
	@ManyToOne(optional = true, fetch = FetchType.EAGER, targetEntity = Category.class, cascade = {CascadeType.MERGE})
	private Category category;

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTime_open() {
		return time_open;
	}

	public void setTime_open(String time_open) {
		this.time_open = time_open;
	}

	public String getTime_close() {
		return time_close;
	}

	public void setTime_close(String time_close) {
		this.time_close = time_close;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getAddition() {
		return addition;
	}

	public void setAddition(String addition) {
		this.addition = addition;
	}

	public boolean isDelivery() {
		return delivery;
	}

	public void setDelivery(boolean delivery) {
		this.delivery = delivery;
	}

	public boolean isSunday_open() {
		return sunday_open;
	}

	public void setSunday_open(boolean sunday_open) {
		this.sunday_open = sunday_open;
	}

	public boolean isMonday_open() {
		return monday_open;
	}

	public void setMonday_open(boolean monday_open) {
		this.monday_open = monday_open;
	}

	public boolean isTuesday_open() {
		return tuesday_open;
	}

	public void setTuesday_open(boolean tuesday_open) {
		this.tuesday_open = tuesday_open;
	}

	public boolean isWednesday_open() {
		return wednesday_open;
	}

	public void setWednesday_open(boolean wednesday_open) {
		this.wednesday_open = wednesday_open;
	}

	public boolean isThursday_open() {
		return thursday_open;
	}

	public void setThursday_open(boolean thursday_open) {
		this.thursday_open = thursday_open;
	}

	public boolean isFriday_open() {
		return friday_open;
	}

	public void setFriday_open(boolean friday_open) {
		this.friday_open = friday_open;
	}

	public boolean isSaturday_open() {
		return saturday_open;
	}

	public void setSaturday_open(boolean saturday_open) {
		this.saturday_open = saturday_open;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((addition == null) ? 0 : addition.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((cep == null) ? 0 : cep.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((cnpj == null) ? 0 : cnpj.hashCode());
		result = prime * result + (delivery ? 1231 : 1237);
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((district == null) ? 0 : district.hashCode());
		result = prime * result + (friday_open ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + (monday_open ? 1231 : 1237);
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
		result = prime * result + (saturday_open ? 1231 : 1237);
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + (sunday_open ? 1231 : 1237);
		result = prime * result + (thursday_open ? 1231 : 1237);
		result = prime * result + ((time_close == null) ? 0 : time_close.hashCode());
		result = prime * result + ((time_open == null) ? 0 : time_open.hashCode());
		result = prime * result + (tuesday_open ? 1231 : 1237);
		result = prime * result + (wednesday_open ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Restaurant other = (Restaurant) obj;
		if (addition == null) {
			if (other.addition != null)
				return false;
		} else if (!addition.equals(other.addition))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (cep == null) {
			if (other.cep != null)
				return false;
		} else if (!cep.equals(other.cep))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (cnpj == null) {
			if (other.cnpj != null)
				return false;
		} else if (!cnpj.equals(other.cnpj))
			return false;
		if (delivery != other.delivery)
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (district == null) {
			if (other.district != null)
				return false;
		} else if (!district.equals(other.district))
			return false;
		if (friday_open != other.friday_open)
			return false;
		if (id != other.id)
			return false;
		if (monday_open != other.monday_open)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		if (saturday_open != other.saturday_open)
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (sunday_open != other.sunday_open)
			return false;
		if (thursday_open != other.thursday_open)
			return false;
		if (time_close == null) {
			if (other.time_close != null)
				return false;
		} else if (!time_close.equals(other.time_close))
			return false;
		if (time_open == null) {
			if (other.time_open != null)
				return false;
		} else if (!time_open.equals(other.time_open))
			return false;
		if (tuesday_open != other.tuesday_open)
			return false;
		if (wednesday_open != other.wednesday_open)
			return false;
		return true;
	}
}
