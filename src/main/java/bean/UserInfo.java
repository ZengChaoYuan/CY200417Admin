package bean;

import java.util.Date;

public class UserInfo {//前台用户信息
	private Long userId;
	private String userName;
	private String userNiName;
	private String userPwd;
	private Date userCtime;
	private Long userState;
	private Long userSex;
	private String userEdu;
	private String userPro;
	private String userEmail;
	private String userTel;
	private Long userScore;

	public UserInfo(Long userId, String userName, String userNiName, String userPwd, Date userCtime, Long userState,
			Long userSex, String userEdu, String userPro, String userEmail, String userTel, Long userScore) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.userNiName = userNiName;
		this.userPwd = userPwd;
		this.userCtime = userCtime;
		this.userState = userState;
		this.userSex = userSex;
		this.userEdu = userEdu;
		this.userPro = userPro;
		this.userEmail = userEmail;
		this.userTel = userTel;
		this.userScore = userScore;
	}

	public UserInfo() {
		super();
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserNiName() {
		return userNiName;
	}

	public void setUserNiName(String userNiName) {
		this.userNiName = userNiName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public Date getUserCtime() {
		return userCtime;
	}

	public void setUserCtime(Date userCtime) {
		this.userCtime = userCtime;
	}

	public Long getUserState() {
		return userState;
	}

	public void setUserState(Long userState) {
		this.userState = userState;
	}

	public Long getUserSex() {
		return userSex;
	}

	public void setUserSex(Long userSex) {
		this.userSex = userSex;
	}

	public String getUserEdu() {
		return userEdu;
	}

	public void setUserEdu(String userEdu) {
		this.userEdu = userEdu;
	}

	public String getUserPro() {
		return userPro;
	}

	public void setUserPro(String userPro) {
		this.userPro = userPro;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public Long getUserScore() {
		return userScore;
	}

	public void setUserScore(Long userScore) {
		this.userScore = userScore;
	}

}
