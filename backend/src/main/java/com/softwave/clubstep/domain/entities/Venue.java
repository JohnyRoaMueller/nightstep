package com.softwave.clubstep.domain.entities;

import java.util.List;

import jakarta.persistence.*;

@Entity
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Venue {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String type;
    private int capacity;
    private String city;
    private String district;
    private String street;
    private String houseNumber;
    private String postalCode;
    private String description;

    @ElementCollection
    @CollectionTable(name = "venue_image_Pathes", joinColumns = @JoinColumn(name = "venue_id"))
    @Column(name = "image_address", columnDefinition = "TEXT")
    private List<String> imagePaths;

    /** Beziehungen */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "host_id", nullable = false)
    private Host host;

    @ManyToMany
    @JoinTable(
        name = "venue_follower",
        joinColumns = @JoinColumn(name = "venue_id"),
        inverseJoinColumns = @JoinColumn(name = "follower_id")
    )
    private List<Guest> followers;

    @OneToMany(mappedBy = "venue")
    List<Event> events;

    /** Konstruktoren */
    public Venue() {}

    public Venue
        (
        String name,
        String type,
        int capacity,
        String city,
        String district, 
        String street,
        String houseNumber,
        String postalCode, 
        String description,
        List<String> imagePaths,
        Host host,
        List<Guest> followers,
        List<Event> events
        )
        {
        this.name = name;
        this.type = type;
        this.capacity = capacity;
        this.city = city;
        this.district = district;
        this.street = street;
        this.houseNumber = houseNumber;
        this.postalCode = postalCode;
        this.description = description;
        this.imagePaths = imagePaths;
        this.host = host;
        this.followers = followers;
        this.events = events;
        }

    /** Getter & Setter */
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public int getCapacity() { return capacity; }
    public void setCapacity(int capacity) { this.capacity = capacity; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getDistrict() { return district; }
    public void setDistrict(String district) { this.district = district; }

    public String getStreet() { return street; }
    public void setStreet(String street) { this.street = street; }

    public String getHouseNumber() { return houseNumber; }
    public void setHouseNumber(String houseNumber) { this.houseNumber = houseNumber; }

    public String getPostalCode() { return postalCode; }
    public void setPostalCode(String postalCode) { this.postalCode = postalCode; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public List<String> getPicAddresses() { return imagePaths; }
    public void setPicAddresses(List<String> imagePaths) { this.imagePaths = imagePaths; }

    public Host getHost() { return host; }
    public void setHost(Host host) { this.host = host; }

    public List<Guest> getFollowers() { return followers; }
    public void setFollowers(List<Guest> followers) { this.followers = followers; }

    public List<Event> setEvents() { return events; }
    public void getEvents(List<Event> events) { this.events = events; }
    /** getter & Setter */
}