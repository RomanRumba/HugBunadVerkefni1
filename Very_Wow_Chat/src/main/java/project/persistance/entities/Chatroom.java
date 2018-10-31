package project.persistance.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.awt.TextArea;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NodeEntity
public class Chatroom {

	@Id @GeneratedValue private Long id;
	// unique name serving as an identifier
	private String chatroomName;
	// non-unique name to be displayed
	private String displayName;
	// description of the chatroom
	private TextArea description;
	// denotes the visibility of the chatroom: true means listed, false means unlisted
	private Boolean listed;
	// denots the accessability of the chatroom: true means users can only join with an invite, false means anyone can join
	private Boolean invited_only;
	// the owner of the chatroom, has master privileges 
	private User owner;
	// when the chatroom was created
	private Long created;

	// the tags the chatroom is associated with
	@Relationship(type="HAS_TAG", direction=Relationship.OUTGOING)
	private List<Tag> tags;
	
	// users who are members of the chatroom
	@Relationship(type="MEMBER_OF", direction=Relationship.INCOMING)
	private List<User> members;
	
	// users who have administrative privileges of the chatroom
	@Relationship(type="ADMIN_OF", direction=Relationship.INCOMING)
	private List<User> administrators;

	// users who have been invited to join the chatroom
	@Relationship(type="INVITES", direction=Relationship.OUTGOING)
	private List<User> Memberinvitees;

	// users who have benen invited to become administrators of the chatroom
	@Relationship(type="ADMIN_INVITES", direction=Relationship.OUTGOING)
	private List<User> adminInvitees;

	// users who have been invited to become administrators of the chatroom
	@Relationship(type="REQUESTS_TO_JOIN", direction=Relationship.INCOMING)
	private List<User> requestors;
	

	// Empty constructor required as of Neo4j API 2.0.5
	public Chatroom () {}
	
	/**
	 * Create a new chatroom
	 * @param chatroomName
	 * @param displayName
	 * @param description
	 * @param listed
	 * @param invited_only
	 * @param owner
	 */
	public Chatroom(String chatroomName, String displayName, TextArea description, Boolean listed, Boolean invited_only, User owner) {
		this.chatroomName = chatroomName;
		this.displayName = displayName;
		this.description = description;
		this.listed = listed;
		this.invited_only = invited_only;
		this.owner = owner;

		this.created = (new Date()).getTime(); // current time

		// initalize the relations
		this.tags = new ArrayList<>();
		this.members = new ArrayList<>();
		this.administrators = new ArrayList<>();
		this.Memberinvitees = new ArrayList<>();
		this.adminInvitees = new ArrayList<>();
		this.requestors = new ArrayList<>();
	}

	// getters and setters

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getChatroomName() {
		return chatroomName;
	}

	public void setChatroomName(String chatroomName) {
		this.chatroomName = chatroomName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	public TextArea getDescription() {
		return description;
	}

	public void setDescription(TextArea description) {
		this.description = description;
	}

	public Boolean getListed() {
		return listed;
	}

	public void setListed(Boolean listed) {
		this.listed = listed;
	}

	public Boolean getInvited_only() {
		return invited_only;
	}

	public void setInvited_only(Boolean invited_only) {
		this.invited_only = invited_only;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public List<Tag> getTags() {
		return tags;
	}

	public void setTags(List<Tag> tags) {
		this.tags = tags;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public List<User> getAdministrators() {
		return administrators;
	}

	public void setAdministrators(List<User> administrators) {
		this.administrators = administrators;
	}

	public List<User> getMemberinvitees() {
		return Memberinvitees;
	}

	public void setMemberinvitees(List<User> memberinvitees) {
		Memberinvitees = memberinvitees;
	}

	public List<User> getAdminInvitees() {
		return adminInvitees;
	}

	public void setAdminInvitees(List<User> adminInvitees) {
		this.adminInvitees = adminInvitees;
	}

	public List<User> getRequestors() {
		return requestors;
	}

	public void setRequestors(List<User> requestors) {
		this.requestors = requestors;
	}
	
	
	
}
