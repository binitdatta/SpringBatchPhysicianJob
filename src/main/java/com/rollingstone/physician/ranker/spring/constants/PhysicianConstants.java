package com.rollingstone.physician.ranker.spring.constants;

public class PhysicianConstants {

	public static final String INSERT_QUERY_P = "insert into PP_PHISICIAN(PHSICIAN_NAME,PHSICIAN_AGE,PHSICIAN_GENDER,PHSICIAN_DOB,EMAIL_ADDRESS,RESIDENCE_LAND_PHONE,OFFCE_LAND_PHONE, " +
			"CELL_PHONE) " +
			"values(?,?,?,?,?,?,?,?);";
	
	public static final String INSERT_QUERY_A = "insert into pp_phsician_address(HOUSE_NUMBER,CITY,STATE,ZIP,COUNTRY,ADDRESS_TYPE,physician_id " +
			") " +
			"values(?,?,?,?,?,?,?);";
	
	public static final String INSERT_QUERY_D = "insert into pp_physician_degrees(PHSICIAN_ID,DEGREE_ID,YEAR_PASSED, " +
			"PERCENTAGE) " +
			"values(?,?,?,?);";
	
	public static final String INSERT_QUERY_S = "insert into pp_physician_speciality(PHSICIAN_ID,SPECIALITY_ID,RANK) " +
			"values(?,?,?);";
}
