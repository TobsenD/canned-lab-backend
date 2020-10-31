package de.dols.cannedlabbackend.model;

import java.io.File;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Accessors(chain = true)
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NonNull
	private String name;
	private File image;
	@NonNull
	private String typ;
	@NonNull
	private Date canDate;
	private Date mhdDate;
	@NonNull
	private Integer menge;

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", image=" + image + ", typ=" + typ + ", canDate=" + canDate
				+ ", mhdDate=" + mhdDate + ", menge=" + menge + "]";
	}

}
