package id.its.api.spmi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.its.api.spmi.model.Dosen;

public class DosenRowMapper implements RowMapper<Dosen>{

	@Override
	public Dosen mapRow(ResultSet rs, int rowNum) throws SQLException {
		Dosen d = new Dosen();
		
		d.setJumlahDosen(rs.getInt("jumlahDosen"));
		
		return d;
	}

}
