package com.example.bg_tuvarna_sit_group21_library.database.Entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "bookstates")
public class Bookstates {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stateid", nullable = false)
    private Integer id;

    @OneToMany(mappedBy = "stateStateid")
    private Set<Exemplars> exemplarsSet;

    @Column(name = "state", nullable = false, length = 30)
    private String state;

    public Bookstates() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<Exemplars> getExemplarsSet() {
        return exemplarsSet;
    }

    public void setExemplarsSet(Set<Exemplars> exemplarsSet) {
        this.exemplarsSet = exemplarsSet;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Bookstates{" +
                "id=" + id +
                ", exemplarsSet=" + exemplarsSet +
                ", state='" + state + '\'' +
                '}';
    }
}