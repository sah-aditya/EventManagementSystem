package models;

public class Event {
    private int id;
    private String name;
    private String date;
    private String location;
    private int organizerId;

    public Event(int id, String name, String date, String location, int organizerId) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.location = location;
        this.organizerId = organizerId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getDate() { return date; }
    public String getLocation() { return location; }
    public int getOrganizerId() { return organizerId; }
}
