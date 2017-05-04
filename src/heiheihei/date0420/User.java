package heiheihei.date0420;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/19
 */
public class User implements Serializable {

	private String username;
	private String password;
	private Set<String> blackList;
	private int errorCount;
	private long lastAliveTime;
	private long lastAttemptTime;

	public User() {
	}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
		blackList = new HashSet<>();
		errorCount = 0;
		lastAliveTime = 0l;
	}

	public int login(String pwd, int blockDuration) {
		if (errorCount >=3 && (System.currentTimeMillis() - lastAttemptTime) <= (blockDuration * 1000)) {
			return 3;
		}
		if (pwd.equals(this.password)) {
			errorCount = 0;
			lastAliveTime = System.currentTimeMillis();
			return 0;
		} else {
			errorCount++;
			lastAttemptTime = System.currentTimeMillis();
			if (errorCount == 3) {
				return 2;
			} else {
				return 1;
			}
		}
	}

	public boolean checkPassword(String input) {
		if (input == null) {
			return false;
		}
		return input.equals(password);
	}

	public boolean blockUser(String name) {
		if (blackList.contains(name)) {
			return false;
		}else {
			blackList.add(name);
			return true;
		}
	}

	public boolean unblockUser(String name) {
		if (blackList.contains(name)) {
			blackList.remove(name);
			return true;
		}else {
			return false;
		}
	}

	public String getUsername() {
		return username;
	}

	public long getLastAliveTime() {
		return lastAliveTime;
	}

	public void setLastAliveTime(long lastAliveTime) {
		this.lastAliveTime = lastAliveTime;
	}

	public Set<String> getBlackList() {
		return blackList;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof User)) {
			return false;
		}
		return ((User) obj).username.equals(this.username);
	}

	@Override
	public int hashCode() {
		return username.hashCode();
	}

}
