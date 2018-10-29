package project.persistance.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.EndNode;

import java.util.Date;

@RelationshipEntity(type = "FRIEND_REQUEST")
public class FriendRequest {
	
	@Id @GeneratedValue private Long id;
	
    @StartNode
    private User requestor;

    @EndNode
    private User requestee;
    
    private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getRequestor() {
		return requestor;
	}

	public void setRequestor(User requestor) {
		this.requestor = requestor;
	}

	public User getRequestee() {
		return requestee;
	}

	public void setRequestee(User requestee) {
		this.requestee = requestee;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
