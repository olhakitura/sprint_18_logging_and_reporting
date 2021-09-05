package com.softserve.edu.opencart.data;

//
// TODO
// Use Builder
// Fluent Interface
//
public class User {

	private String firstname;
	private String lastname;
	private String email;
	private String telephone;
	private String fax;        // not required
	private String company;    // not required
	private String address1;
	private String address2;   // not required
	private String city;
	private String postcode;
	private String country;
	private String region;
	private String password;
	private boolean subscribe;

	public User(String firstname, String lastname,
			String email, String telephone, String fax,
			String company, String address1, String address2,
			String city, String postcode, String country,
			String region, String password, boolean subscribe) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.telephone = telephone;
		this.fax = fax;
		this.company = company;
		this.address1 = address1;
		this.address2 = address2;
		this.city = city;
		this.postcode = postcode;
		this.country = country;
		this.region = region;
		this.password = password;
		this.subscribe = subscribe;
	}

	public User() {}
	        
    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getFax() {
        return fax;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getPostcode() {
        return postcode;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getPassword() {
        return password;
    }

    public boolean isSubscribe() {
        return subscribe;
    }
    
    @Override
    public String toString() {
        return "Firstname: " + getFirstname()
            + " Lastname: " + getLastname()
            + " Email: " + getEmail()
            + " Telephone: " + getTelephone()
            + " Fax: " + getFax()
            + " Company: " + getCompany()
            + " Address1: " + getAddress1()
            + " Address2: " + getAddress2()
            + " City: " + getCity()
            + " Postcode: " + getPostcode()
            + " Country: " + getCountry()
            + " Region: " + getRegion()
            + " Password: " + getPassword();
    }
    
}
