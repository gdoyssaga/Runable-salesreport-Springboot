package com.gable.runma.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" })
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date raceDate;
    @Temporal(TemporalType.DATE)
    private Date openRegisDate;
    @Temporal(TemporalType.DATE)
    private Date closeRegisDate;
    private Boolean outOfTicketFlag;
    private String province;
    private String location;
    private Integer capacity;

    @OneToMany (
            mappedBy = "event" ,fetch = FetchType.LAZY,
            cascade = {CascadeType.REMOVE,CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}
            )
    private List<RaceType> raceTypeList;

    @ManyToMany(
            fetch = FetchType.LAZY,
            cascade = {CascadeType.MERGE, CascadeType.REFRESH}
            )
    @JoinTable(name = "EventOrganizer",  joinColumns =  @JoinColumn(name = "EventId", referencedColumnName = "id") ,
            inverseJoinColumns =  @JoinColumn(name = "OrganizerId", referencedColumnName = "id") )
    private List<Organizer> organizerList;

}