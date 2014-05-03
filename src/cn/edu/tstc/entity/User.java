/**
 * 
 */
package cn.edu.tstc.entity;

import java.util.Date;

import cn.edu.tstc.common.util.MD5Util;

/**
 * 项目名称：SignUpSystem 类名称：User 类描述: 创建人：姚洪肖 创建时间：2014-5-3 下午3:22:38 修改人：姚洪肖
 * 修改时间：2014-5-3 下午3:22:38 修改备注：
 * 
 * @version
 */

public class User {
	private String user_code;
	private String user_name;
	private String password;
	private String sex;
	private Date birthday;
	private String idcard;
	private String mobile;
	private String tel;
	private int age;
	private String email;

	/**
	 * @return the user_code
	 */
	public String getUser_code() {
		return user_code;
	}

	/**
	 * @param user_code
	 *            the user_code to set
	 */
	public void setUser_code(String user_code) {
		this.user_code = user_code;
	}

	/**
	 * @return the user_name
	 */
	public String getUser_name() {
		return user_name;
	}

	/**
	 * @param user_name
	 *            the user_name to set
	 */
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	
	public void setMd5Password(String md5Password){
		this.password = md5Password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = MD5Util.MD5(password);
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @param sex
	 *            the sex to set
	 */
	public void setSex(String sex) {
		if ("man".equals(sex)) {
			this.sex = "男";
		}else if("female".equals(sex)){
			
		}else{
			this.sex = sex;
		}
	}

	/**
	 * @return the birthday
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * @param birthday
	 *            the birthday to set
	 */
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	/**
	 * @return the idcard
	 */
	public String getIdcard() {
		return idcard;
	}

	/**
	 * @param idcard
	 *            the idcard to set
	 */
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}

	/**
	 * @param mobile
	 *            the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
}
