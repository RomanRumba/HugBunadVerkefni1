package project.persistance.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

/**
 * Class which maps the user to a node in a neo4j database.
 */
@NodeEntity
public class User {

	@Id @GeneratedValue protected Long id;

	protected String username;
	protected String password;
	protected String displayName;
	
	// NOTE: at the moment the email is assumed to be encrypted.
	protected String email;
	protected Long created;
	protected Boolean isActive;

	// The User's friends
	@Relationship(type="FRIENDS", direction=Relationship.UNDIRECTED)
	protected List<User> friends;

	// Users who have received a friend request from the User
	@Relationship(type="FRIEND_REQUEST", direction=Relationship.OUTGOING)
	protected List<User> friendRequestees;
	
	// Users who have sent a friend request to the User
	@Relationship(type="FRIEND_REQUEST", direction=Relationship.INCOMING)
	protected List<User> friendRequestors;
	
	// chatrooms the user is a member of
	@Relationship(type="OWNS", direction=Relationship.OUTGOING)
	protected List<Chatroom> ownedChatrooms;
	
	// chatrooms the user is a member of
	@Relationship(type="ADMIN_OF", direction=Relationship.OUTGOING)
	protected List<Chatroom> adminOfChatrooms;
	
	// chatooms the user has requested to join
	@Relationship(type="REQUESTS_TO_JOIN", direction=Relationship.OUTGOING)
	protected List<Chatroom> chatroomRequests;

	// chatooms the user has received an invite to join from
	@Relationship(type="INVITES", direction=Relationship.INCOMING)
	protected List<Chatroom> chatroomInvites;

	// chatooms the user has received an invite to become an administrator
	@Relationship(type="ADMIN_INVITES", direction=Relationship.INCOMING)
	protected List<Chatroom> chatroomAdminInvites;

	// chatrooms the user is a member of
	@Relationship(type="HAS_MEMBER", direction=Relationship.INCOMING)
	protected List<Chatroom> memberOfChatrooms;
	
	// list of all the relations to chatrooms that the user is a member of
	//@JsonIgnoreProperties("user")
	@Relationship(type="MEMBER_OF", direction=Relationship.OUTGOING)
	protected List<Membership> memberships;
	
	// ATH when getting the chatrooms, their tag arrays will be empty, to get the tags, use findChatroomBychatroomName!!!
	
	// Empty constructor required as of Neo4j API 2.0.5
	protected User() {};

	/**
	 * Create a new user
	 * 
	 * NOTE: email is assumed to be encrypted here.
	 * 
	 * @param userName		a unique user name used to authenticate user
	 * @param password		user's password, used to authenticate user
	 * @param displayName	user's display name, seen by other users
	 * @param email	User's email.
	 */
	public User(String username, String password, String displayName, String email) {
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.email = email;
		
		this.created = (new Date()).getTime(); // current time
		this.isActive = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * NOTE: email is assumed to be encrypted here.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * NOTE: email is assumed to be encrypted here.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCreated() {
		return created;
	}

	public void setCreated(Long created) {
		this.created = created;
	}

	public List<User> getFriends() {
		if(friends == null) {
			friends = new ArrayList<>();
		}
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getFriendRequestees() {
		if(friendRequestees == null) {
			friendRequestees = new ArrayList<>();
		}
		return friendRequestees;
	}

	public void setFriendRequestees(List<User> friendRequestees) {
		this.friendRequestees = friendRequestees;
	}

	public List<User> getFriendRequestors() {
		if(friendRequestors == null) {
			friendRequestors = new ArrayList<>();
		}
		return friendRequestors;
	}

	public void setFriendRequestors(List<User> friendRequestors) {
		this.friendRequestors = friendRequestors;
	}

	public List<Chatroom> getMemberOfChatrooms() {
		if(memberOfChatrooms == null) {
			memberOfChatrooms = new ArrayList<>();
		}
		return memberOfChatrooms;
	}

	public void setMemberOfChatrooms(List<Chatroom> memberOfChatrooms) {
		this.memberOfChatrooms = memberOfChatrooms;
	}
	
	public List<Chatroom> getOwnedChatrooms() {
		if(ownedChatrooms == null) {
			ownedChatrooms = new ArrayList<>();
		}
		return ownedChatrooms;
	}

	public void setOwnedChatrooms(List<Chatroom> ownedChatrooms) {
		this.ownedChatrooms = ownedChatrooms;
	}

	public List<Chatroom> getAdminOfChatrooms() {
		if(adminOfChatrooms == null) {
			adminOfChatrooms = new ArrayList<>();
		}
		return adminOfChatrooms;
	}

	public void setAdminOfChatrooms(List<Chatroom> adminOfChatrooms) {
		this.adminOfChatrooms = adminOfChatrooms;
	}

	public List<Chatroom> getChatroomRequests() {
		if(chatroomRequests == null) {
			chatroomRequests = new ArrayList<>();
		}
		return chatroomRequests;
	}

	public void setChatroomRequests(List<Chatroom> chatroomRequests) {
		this.chatroomRequests = chatroomRequests;
	}

	public List<Chatroom> getChatroomInvites() {
		if(chatroomInvites == null) {
			chatroomInvites = new ArrayList<>();
		}
		return chatroomInvites;
	}

	public void setChatroomInvites(List<Chatroom> chatroomInvites) {
		this.chatroomInvites = chatroomInvites;
	}

	public List<Chatroom> getChatroomAdminInvites() {
		if(chatroomAdminInvites == null) {
			chatroomAdminInvites = new ArrayList<>();
		}
		return chatroomAdminInvites;
	}

	public void setChatroomAdminInvites(List<Chatroom> chatroomAdminInvites) {
		this.chatroomAdminInvites = chatroomAdminInvites;
	}

	public List<Membership> getMemberships() {
		if(memberships == null) {
			memberships = new ArrayList<>();
		}
		return memberships;
	}

	public void setMemberships(List<Membership> memberships) {
		this.memberships = memberships;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	
	
	
}
