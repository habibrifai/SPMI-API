package id.its.api.spmi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.its.api.spmi.model.BebanKerjaDosen;

public class BebanKerjaDosenRowMapper implements RowMapper<BebanKerjaDosen>{

	@Override
	public BebanKerjaDosen mapRow(ResultSet rs, int rowNum) throws SQLException {
		BebanKerjaDosen d = new BebanKerjaDosen();
		
		d.setRataBebanKerjaDosen(rs.getDouble("rataBebanKerjaDosen"));
		
		return d;
	}

}
