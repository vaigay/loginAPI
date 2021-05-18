package com.vaigay.DTO;

public class ChangePassword {
	public ChangePassword() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String oldPassword;
	private String newPassword;
	public String getOldPassword() {
		return oldPassword;
	}
	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}
	public String getNewPassword() {
		return newPassword;
	}
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	@Override
	public String toString() {
		return "ChangePassword [oldPassword=" + oldPassword + ", newPassword=" + newPassword + "]";
	}
	
	
}
