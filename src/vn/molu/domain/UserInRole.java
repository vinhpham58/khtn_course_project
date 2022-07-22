package vn.molu.domain;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "UserInRole")
@Table(name = "user_role")
public class UserInRole implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "RoleId")
	private Integer roleID;
	
	@Id
	@Column(name = "UserId")
	private Long userID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "RoleId")
	private Role role;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "UserId")
	private User user;
	
	public UserInRole(Integer roleID, Long userID) {
		this.roleID = roleID;
		this.userID = userID;
	}

	public UserInRole(Role role, User user) {
		this.role = role;
		this.user = user;
	}

	public UserInRole() {
	}
	
	public Integer getRoleID() {
		return roleID;
	}

	public void setRoleID(Integer roleID) {
		this.roleID = roleID;
	}

	public Long getUserID() {
		return userID;
	}

	public void setUserID(Long userID) {
		this.userID = userID;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
