package models;

public class Resource {
    private int id;
    private String name;
    private int eventId;

    public Resource(int id, String name, int eventId) {
        this.id = id;
        this.name = name;
        this.eventId = eventId;
    }

    // Getters and Setters
    public int getId() { return id; }
    public String getName() { return name; }
    public int getEventId() { return eventId; }
}
