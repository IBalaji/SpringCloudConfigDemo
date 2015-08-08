package demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraOperations;
import org.springframework.stereotype.Repository;

import demo.pojo.User;

@Repository
public class UserDAO {

	@Autowired
	CassandraOperations cassandraOperations;

	public void insertUser(User user) {
		cassandraOperations.insert(user);
	}
	
	
}
