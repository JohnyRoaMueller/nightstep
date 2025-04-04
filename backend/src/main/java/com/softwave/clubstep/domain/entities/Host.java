package com.softwave.clubstep.domain.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.softwave.clubstep.base.BaseUser;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Host extends BaseUser  {
    

    public Host() {};

    
    /** ↓↓↓ cardinalities  ↓↓↓*/
    /** ↓↓↓ cardinalities  ↓↓↓*/
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "host", cascade = CascadeType.ALL)
    @JsonManagedReference(value = "ownedVenuesReference")
    private List<Venue> ownedVenues;

    @OneToOne
    @JoinColumn(name = "userAuth_ID", nullable = false)
    @JsonBackReference(value = "hostReference")
    private UserAuth userAuth;
    
    /** ↑↑↑ cardinalities ↑↑↑ */
    /** ↑↑↑ cardinalities ↑↑↑ */


                {/*getter / setter */}
    {/* ↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓ */}   
    public List<Venue> getOwnedVenues() {
        return ownedVenues;
    }

    public void setOwnedVenues(List<Venue> ownedVenues) {
        this.ownedVenues = ownedVenues;
    }

    public UserAuth getUserAuth() {
        return userAuth;
    }

    public void setUserAuth(UserAuth userAuth) {
        this.userAuth = userAuth;
    }
    {/* ↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑ */}
                {/*getter / setter */}

}
