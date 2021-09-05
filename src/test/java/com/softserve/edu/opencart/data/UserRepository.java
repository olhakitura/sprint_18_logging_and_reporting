package com.softserve.edu.opencart.data;

//
// TODO
// Use Repository
// Use Singleton
//
public final class UserRepository {
	
    public User getExistUser() {
        return new User("firstname", "lastname",
                "email234@awdrt.com", "+380671234567", "fax",
                "company", "address1", "address2",
                "city", "postcode", "Ukraine",
                "Kyiv", "qwerty", true);
    }

    public User getNewUser() {
        //
        // TODO
        //
        return new User();
    }
    
    public User getInvalidUser() {
        //
        // TODO
        //
        return new User();
    }
    
}
