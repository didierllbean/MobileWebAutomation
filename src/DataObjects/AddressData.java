package DataObjects;

public class AddressData {

	public static final String SHIPPING = "Shipping",
						BILLING = "Billing",
						FREE = "Free",
						EXPRESS = "Express";
	
	private String addressType,
					shipTo,
					title,
					firstName,
					middleName,
					lastName,
					gender,
					country,
					address1,
					address2,
					zipCode,
					city,
					state,
					daytimePhone,
					shippingMethod,
					email,
					eveningPhone;
	
	
	/** 
	 * @param addressType SHIPPING or BILLING address
	 * @param shipTo 	Name in the Shpping address. Null if Billing address
	 * @param title 	Mr, Mrs, MS, Dr or Sir
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param gender
	 * @param country
	 * @param address1
	 * @param address2
	 * @param zipCode
	 * @param city
	 * @param state
	 * @param daytimePhone
	 * @param shippingMethod FREE or EXPRESS. Null if Billing address
	 * @param email 	email address for the billing form. Null if Shipping address
	 * @param eveningPhone phone number for evening field in billing form. Null if Shipping Address
	 */
	public AddressData(String addressType, String shipTo, String title,
			String firstName, String middleName, String lastName,
			String gender, String country, String address1, String address2,
			String zipCode, String city, String state, String daytimePhone,
			String shippingMethod, String email, String eveningPhone) {
		
		setAddressType(addressType);
		setShipTo(shipTo);
		setTitle(title);
		setFirstName(firstName);
		setMiddleName(middleName);
		setLastName(lastName);
		setGender(gender);
		setCountry(country);
		setAddress1(address1);
		setAddress2(address2);
		setZipCode(zipCode);
		setCity(city);
		setState(state);
		setDaytimePhone(daytimePhone);
		setShippingMethod(shippingMethod);
		setEmail(email);
		setEveningPhone(eveningPhone);
	}
	

	public String getAddressType() { return addressType; }
	public void setAddressType(String addressType) {
		this.addressType = addressType;
	}

	public String getShipTo() {	return shipTo; }
	public void setShipTo(String shipTo) {
		this.shipTo = shipTo;
	}

	public String getTitle() { return title; }
	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() { return firstName; }
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() { return middleName; }
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() { return lastName; }
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() { return gender; }
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() { return country; }
	public void setCountry(String country) {
		this.country = country;
	}

	public String getAddress1() { return address1; }
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() { return address2; }
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getZipCode() { return zipCode; }
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getCity() { return city; }
	public void setCity(String city) {
		this.city = city;
	}

	public String getState() { return state; }
	public void setState(String state) {
		this.state = state;
	}

	public String getDaytimePhone() { return daytimePhone; }
	public void setDaytimePhone(String daytimePhone) {
		this.daytimePhone = daytimePhone;
	}

	public String getShippingMethod() { return shippingMethod; }
	public void setShippingMethod(String shippingMethod) {
		this.shippingMethod = shippingMethod;
	}

	public String getEmail() { return email; }
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEveningPhone() { return eveningPhone; }
	public void setEveningPhone(String eveningPhone) {
		this.eveningPhone = eveningPhone;
	}
}
