package project.persistance.repositories;

import java.util.List;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;

import project.persistance.entities.Chatroom;

/**
 * Repository interface for neo4j and chatrooms
 * 
 * @author Vilhelml
 *
 */
public interface ChatroomRepository extends Neo4jRepository<Chatroom, Long> {
	// Return a Chatroom NodeEntity if chatroomName exists
	Chatroom findByChatroomName(String chatroomName);

	// get all listed chatrooms
	List<Chatroom> findByListed(Boolean listed);

	// get all chatrooms
	List<Chatroom> findAll();

	// create new chatroom in datbase
	Chatroom save(Chatroom chatroom);

	// delete a chatroom
	void delete(Chatroom chatroom);

	// find all the chatrooms with the given tag
	@Query("MATCH(a:Chatroom)-[r:HAS_TAG]->(b:Tag) WHERE b.name = {tagName} AND a.listed = true RETURN a.chatroomName;")
	List<String> findListedChatroomsWithTag(@Param("tagName") String tagName);
}
