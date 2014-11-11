package crm.to;

public class UserTO {
String username; 
String password;
int Key;
/**
 * The username in the class is same as the SubadminName of SubAdminTO
 * @return
 */
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
public int getKey() {
	return Key;
}
public void setKey(int key) {
	Key = key;
}
@Override
public String toString() {
	return "UserTO [username=" + username + ", password=" + password + ", Key="
			+ Key + "]";
}

}
