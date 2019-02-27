package model;

public class Drugstore {

    private int id;
    private String name;
    private String address;

    public Drugstore(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String toString() {
        return "\"" + name + "\" - " + address;
    }

    public boolean equals(Drugstore drugstore) {
        if (getId() == drugstore.getId()) {
            return true;
        }

        return false;
    }
}
