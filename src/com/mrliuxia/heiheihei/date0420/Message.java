package com.mrliuxia.heiheihei.date0420;

import java.io.Serializable;

/**
 * @Description
 * @Author liuxiao
 * @Date 2017/4/21
 */
public class Message implements Serializable {

	private String username;
	private String command;
	private Object content;
	private int code;

	public Message(String username, String command, Object content, int code) {
		this.username = username;
		this.command = command;
		this.content = content;
		this.code = code;
	}

	public String getUsername() {
		return username;
	}

	public String getCommand() {
		return command;
	}

	public Object getContent() {
		return content;
	}

	public int getCode() {
		return code;
	}

	@Override
	public String toString() {
		return username + " " + command + " " + content.toString();
	}
}
