package com.cts.jwtapi.models;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Role")
public class Role {
	@Id
	@Column(name="Role_Id")
	private long roleId;
	@Column(name="Role_Name")
	private String roleName;
	@ManyToMany(mappedBy = "roles")
	private List<User> users;
	

}
