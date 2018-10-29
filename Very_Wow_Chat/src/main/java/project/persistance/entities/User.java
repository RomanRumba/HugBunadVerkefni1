package project.persistance.entities;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NodeEntity
public class User {

	@Id @GeneratedValue private Long id;

	private String username;
	private String password;
	private String displayName;
	private String email;
	private Long created;

	// The User's friends
	@Relationship(type="FRIENDS", direction=Relationship.UNDIRECTED)
	private List<User> friends;

	// Users who have received a friend request from the User
	@Relationship(type="FRIEND_REQUEST", direction=Relationship.OUTGOING)
	private List<User> friendRequestees;
	
	// Users who have sent a friend request to the User
	@Relationship(type="FRIEND_REQUEST", direction=Relationship.INCOMING)
	private List<User> friendRequestors;
//
//	// chatrooms the user is a member of
//	@Relationship(type="MEMBER_OF", direction=Relationship.OUTGOING)
//	private List<Chatroom> memberOfChatrooms;
//	
//	// chatrooms the user is a member of
//	@Relationship(type="ADMIN_OF", direction=Relationship.OUTGOING)
//	private List<Chatroom> adminOfChatrooms;
//	
//	// chatooms the user has requested to join
//	@Relationship(type="REQUESTS_TO_JOIN", direction=Relationship.OUTGOING)
//	private List<Chatroom> chatroomRequests;
//
//	// chatooms the user has received an invite to join from
//	@Relationship(type="INVITES", direction=Relationship.INCOMING)
//	private List<Chatroom> chatroomInvites;
//
//	// chatooms the user has received an invite to become an administrator
//	@Relationship(type="ADMIN_INVITES", direction=Relationship.INCOMING)
//	private List<Chatroom> chatroomAdminInvites;
//	
//	
//
//	
	
//	// chatooms the user has received an invite to become an administrator
//	@Relationship(type="FRIENDS", direction=Relationship.UNDIRECTED)
//	private List<Friendship> friendships;
//	
//	public List<Friendship> getFriendships() {
//		return friendships;
//	}
//	public void setFriendships(List<Friendship> friendships) {
//		this.friendships = friendships;
//	}
//


	// Empty constructor required as of Neo4j API 2.0.5
	private User() {};

	/**
	 * Create a new user
	 * @param userName		a unique user name used to authenticate user
	 * @param password		user's password, used to authenticate user
	 * @param displayName	user's display name, seen by other users
	 */
	public User(String username, String password, String displayName, String email) {
		this.username = username;
		this.password = password;
		this.displayName = displayName;
		this.email = email;
		
		this.created = (new Date()).getTime(); // current time
	}

//	public void sendFriendRequest(User requestee) {
//		if(this.friendRequestees == null) {
//			this.friendRequestees = new ArrayList<>();
//		}
//		if(requestee.friendRequestors == null) {
//			requestee.friendRequestors = new ArrayList<>();
//		}
//		
//		System.out.println("before");
//		System.out.println(this.friendRequestees.size());
//		System.out.println(requestee.friendRequestors.size());
//		
//		this.friendRequestees.add(requestee);
//		requestee.friendRequestors.add(this);
//
//		System.out.println("after");
//		System.out.println(this.friendRequestees.size());
//		System.out.println(requestee.friendRequestors.size());
//	}
//	public void deleteFriendRequest(User user) {
//		this.friendRequestees.remove(user);
//		user.friendRequestors.remove(this);
//	}
//
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

	public String getEmail() {
		return email;
	}

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

//	public void setFriendRequestees(List<User> friendRequestees) {
//		this.friendRequestees = friendRequestees;
//	}
//
	public List<User> getFriendRequestors() {
		if(friendRequestors == null) {
			friendRequestors = new ArrayList<>();
		}
		return friendRequestors;
	}
//
//	public void setFriendRequestors(List<User> friendRequestors) {
//		this.friendRequestors = friendRequestors;
//	}
//
//	public List<Chatroom> getMemberOfChatrooms() {
//		if(memberOfChatrooms == null) {
//			memberOfChatrooms = new ArrayList<>();
//		}
//		return memberOfChatrooms;
//	}
//
//	public void setMemberOfChatrooms(List<Chatroom> memberOfChatrooms) {
//		this.memberOfChatrooms = memberOfChatrooms;
//	}
//
//	public List<Chatroom> getAdminOfChatrooms() {
//		if(adminOfChatrooms == null) {
//			adminOfChatrooms = new ArrayList<>();
//		}
//		return adminOfChatrooms;
//	}
//
//	public void setAdminOfChatrooms(List<Chatroom> adminOfChatrooms) {
//		this.adminOfChatrooms = adminOfChatrooms;
//	}
//
//	public List<Chatroom> getChatroomRequests() {
//		if(chatroomRequests == null) {
//			chatroomRequests = new ArrayList<>();
//		}
//		return chatroomRequests;
//	}
//
//	public void setChatroomRequests(List<Chatroom> chatroomRequests) {
//		this.chatroomRequests = chatroomRequests;
//	}
//
//	public List<Chatroom> getChatroomInvites() {
//		if(chatroomInvites == null) {
//			chatroomInvites = new ArrayList<>();
//		}
//		return chatroomInvites;
//	}
//
//	public void setChatroomInvites(List<Chatroom> chatroomInvites) {
//		this.chatroomInvites = chatroomInvites;
//	}
//
//	public List<Chatroom> getChatroomAdminInvites() {
//		if(chatroomAdminInvites == null) {
//			chatroomAdminInvites = new ArrayList<>();
//		}
//		return chatroomAdminInvites;
//	}
//
//	public void setChatroomAdminInvites(List<Chatroom> chatroomAdminInvites) {
//		this.chatroomAdminInvites = chatroomAdminInvites;
//	}

	
}
