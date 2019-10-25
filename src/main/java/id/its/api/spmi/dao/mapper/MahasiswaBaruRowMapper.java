package id.its.api.spmi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.its.api.spmi.model.MahasiswaBaru;

public class MahasiswaBaruRowMapper implements RowMapper<MahasiswaBaru> {

	@Override
	public MahasiswaBaru mapRow(ResultSet rs, int rowNum) throws SQLException {
		MahasiswaBaru m = new MahasiswaBaru();
		
		m.setJumlahMaba(rs.getInt("jumlahMaba"));
		
		return m;
	}

}
