package com.danilo;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String name, String email, char gender) {
        this.name = name;
        this.email = email;
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public char getGender() {
        return gender;
    }
    public String toString(){
        return ("[Nome= " + name + ", Email= " + email +", Gender= " + gender + "]");
    }

    public static void main(String[] args) {
        Author a1 = new Author("Danilo", "danilogss@gmail.com", 'M' );
        System.out.println(a1.toString());
        a1.setEmail("danilogabrielss@gmail.com");
        System.out.println(a1.getEmail());
        System.out.println(a1.getName());
        System.out.println(a1.getGender());
        System.out.println(a1.toString());
    }
}
