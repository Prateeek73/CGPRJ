package com.spring.dao;

import java.sql.PreparedStatement;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FlightDAO {
	private final JdbcTemplate jdbcTemplateObject;

	@Autowired
	public FlightDAO(DataSource dataSource) {
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	public int bookFlight(Integer flightId, Integer bookId, int noOfSeatsBooked) {
		String SQL = "INSERT INTO book_flight (bookingid, flightid, noofseatsbooked) VALUES (?, ?, ?)";
		jdbcTemplateObject.update(connection -> {
			PreparedStatement ps = connection.prepareStatement(SQL);
			ps.setInt(1, bookId);
			ps.setInt(2, flightId);
			ps.setInt(3, noOfSeatsBooked);
			return ps;
		});

		String SQL1 = "UPDATE flight SET noofseats = noofseats - ? WHERE flightid = ?";
		int result = jdbcTemplateObject.update(SQL1, noOfSeatsBooked, flightId);

		return result;
	}
}
