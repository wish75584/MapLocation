package com.androidbatch.androiddevelopementtrainingfelix;

//example of encapsulation
//we can access this data from recycler and adapter
//createing getter and setter methods
//getting data in adapter class
//setting data on recycler activity
//create getter and setter methods(alt+insert)
// create constructor (alt+insert)

class Model {

    String username, password;

    public Model(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Model() {
        //created blank constructor for creating objectx
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}