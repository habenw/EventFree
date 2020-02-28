package com.codingdojo.EventFree.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	@Size(min = 2, max = 75, message = "Please enter a valid Event Name (min. 2 characters)")
	 private String name;
	@Size(min = 4, max = 75, message = "Please enter a valid Location (min. 4 characters)")
	 private String location;
	@Size(min = 4, max = 75, message = "Please enter a valid Description (min. 4 characters)")
	 private String description;
	 @Column(updatable=false)
	 private Date createdAt;
	 private Date updatedAt;
	
	 @ManyToOne(fetch = FetchType.LAZY)
	    @JoinColumn(name="creator_id")
		private User creator;
	 
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(
	    name = "events_attendees", 
	    joinColumns = @JoinColumn(name = "event_id"), 
	    inverseJoinColumns = @JoinColumn(name = "user_id")
	    )
	    private List<User> attendees;
	    
	 public Event() {
		    
		}
	public Event(@Size(min = 2, max = 75, message = "Please enter a valid Event Name (min. 2 characters)") String name,
			@Size(min = 4, max = 75, message = "Please enter a valid Location (min. 4 characters)") String location,
			@Size(min = 4, max = 75, message = "Please enter a valid Description (min. 4 characters)") String description,
			User creator) {
		super();
		this.name = name;
		this.location = location;
		this.description = description;
		this.creator = creator;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public List<User> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<User> attendees) {
		this.attendees = attendees;
	}
	// other getters and setters removed for brevity
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	 
}
