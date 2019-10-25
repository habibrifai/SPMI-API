package id.its.api.spmi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.its.api.spmi.model.Mahasiswa;

public class MahasiswaRowMapper implements RowMapper<Mahasiswa>{

	@Override
	public Mahasiswa mapRow(ResultSet rs, int rowNum) throws SQLException {
		Mahasiswa m = new Mahasiswa();
		
		m.setJumlahMhs(rs.getInt("jumlahMhs"));
		
		return m;
	}

}
