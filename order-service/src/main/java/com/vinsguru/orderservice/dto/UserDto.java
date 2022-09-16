package com.vinsguru.orderservice.dto;

import java.util.Objects;

public class UserDto {

	private Integer id;
	private String name;
	private Integer balance;

	public UserDto() {
	}

	public UserDto(String name, Integer balance) {
		this.name = name;
		this.balance = balance;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBalance() {
		return balance;
	}

	public void setBalance(Integer balance) {
		this.balance = balance;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof UserDto))
			return false;
		UserDto other = (UserDto) obj;
		return Objects.equals(balance, other.balance) && Objects.equals(id, other.id)
				&& Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "UserDto [id=" + id + ", name=" + name + ", balance=" + balance + "]";
	}

}
