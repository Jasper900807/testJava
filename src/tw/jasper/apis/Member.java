package tw.jasper.apis;

import java.util.Objects;

public class Member {
	private int id;
	private String account;
	private String passwd;
	private String name;
	
	
	public Member(int id, String account, String passwd, String name) {
		this.id = id;
		this.account = account;
		this.passwd = passwd;
		this.name = name;
	}
	
	
	public String getPasswd() {
		return passwd;
	}


	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getId() {
		return id;
	}


	public String getAccount() {
		return account;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
		Member other = (Member)obj;
		
		return this.id == other.id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
	
	@Override
	public String toString() {
		return String.format("%d:%s", id, name);
	}
}
