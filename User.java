package exam;

public class User {
	private int userId;
	private String userName;
	private String passwordHash;
	private String profile;
	
	public User(int userId, String userName, String passwordHash, String profile) {
		this.userId = userId;
		this.userName = userName;
		this.passwordHash = passwordHash;
		this.profile = profile;
	}
	
	public int getUserId() {
		return userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getPasswordHash() {
		return passwordHash;
	}
	
	public String getProfile() {
		return profile;
	}
	
	public void setProfile(String profile) {
		this.profile = profile;
	}
}
