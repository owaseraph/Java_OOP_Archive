import java.util.Scanner;

class Person {
    private String name;
    private String address;
    private String id;
    private static final String namereg = "^(?=[a-zA-Z\\s]*\\s)[a-zA-Z\\s]+$";

    public Person(String name, String address, String id) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Invalid name format!");
        }
        if (!isValidId(id)) {
            throw new IllegalArgumentException("Invalid ID format!");
        }
        this.address = address;
        this.name = name;
        this.id = id;
    }

    //setters
    public void setName(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Incorrect name format!");
        }
        this.name = name;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setId(String id) {
        if (!isValidId(id)) {
            throw new IllegalArgumentException("Invalid ID format!");
        }
        this.id = id;
    }

    //helpers
    boolean isValidName(String name) {
        String[] split = name.split(" ");
        for (String element : split) {
            if (element.length() < 3) {
                return false;
            }
        }
        return name.matches(namereg);
    }

    boolean isValidId(String id) {
        if (id.length() < 10)
            return false;
        //this only works because String is mutable, must declare a local variable so that you do not format your variable
        int specialCount = id.replaceAll("[A-Za-z0-9]", "").length();
        int uppercaseCount = id.replaceAll("[^A-Z]", "").length();
        return specialCount >= 2 && uppercaseCount >= 2;
    }
    static boolean staticIsValidName(String name) {
        String[] split = name.split(" ");
        for (String element : split) {
            if (element.length() < 3) {
                return false;
            }
        }
        return name.matches(namereg);
    }

    static boolean staticIsValidId(String id) {
        if (id.length() < 10)
            return false;
        int specialCount = id.replaceAll("[A-Za-z0-9]", "").length();
        int uppercaseCount = id.replaceAll("[^A-Z]", "").length();
        return specialCount >= 2 && uppercaseCount >= 2;
    }

    void enterInput(){

    }

    //print
    public void print() {
        System.out.println(this.name + " " + this.address + " " + this.id);
    }


}