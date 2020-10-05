package com.codeclan.example.pirateservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name= "raids")
public class Raid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column
    private String location;

    @Column
    private int loot;

    @JsonIgnoreProperties({"raids"})
    @ManyToMany
    @JoinTable(
            name="pirates_raids",
            joinColumns = {@JoinColumn(
                    name = "raid_id",
                    nullable = false,
                    updatable = false
            )}, inverseJoinColumns = {@JoinColumn(
                    name = "pirate_id",
                    nullable = false,
                    updatable = false
            )}
    )
    private List<Pirate> pirates;

    public Raid(String location, int loot) {
        this.location = location;
        this.loot = loot;
        this.pirates = new ArrayList<>();
    }

    public Raid() {
        this.pirates = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public List<Pirate> getPirates() {
        return pirates;
    }

    public void setPirates(List<Pirate> pirates) {
        this.pirates = pirates;
    }

    public void addPirate(Pirate pirate) {
        pirates.add(pirate);
    }
}
