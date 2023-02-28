package com.tarun.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Table
@Builder
public class Customer {
	@Id
	private int customerId;
	private int accountNo;
	private String firstName;
	private String lastName;
	private String dob;
}
