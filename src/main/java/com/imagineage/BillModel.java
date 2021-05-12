package com.imagineage;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class BillModel implements Serializable {
	private String id;
	private String iname;
	private Double iprice;
	private Double iqty;
	private Double total;
}
