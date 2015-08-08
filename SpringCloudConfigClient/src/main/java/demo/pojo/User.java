package demo.pojo;

import org.springframework.data.cassandra.mapping.Column;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

@Table("user")
public class User {

	@PrimaryKey
	private String username;
	
	@Column("email_id")
	private String emailId;
	
	@Column("address")
	private String address;
	
	@Column("age")
	private int age;
	
	public User(String username,String emailId,String address,int age) {
		this.username = username; this.emailId = emailId; this.address = address; this.age = age;
	}
	
}
