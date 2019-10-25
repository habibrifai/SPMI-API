package id.its.api.spmi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.its.api.spmi.model.MahasiswaLulus;

public class MahasiswaLulusRowMapper implements RowMapper<MahasiswaLulus>{

	@Override
	public MahasiswaLulus mapRow(ResultSet rs, int rowNum) throws SQLException {
		MahasiswaLulus m = new MahasiswaLulus();
		
		m.setJumlahLulusan(rs.getInt("jumlahLulusan"));
		m.setMaxIpk(rs.getDouble("maxIpk"));
		m.setMinIpk(rs.getDouble("minIpk"));
		m.setRataIpk(rs.getDouble("rataIpk"));
		m.setRataLamaStudi(rs.getDouble("rataLamaStudi"));
		
		return m;
	}

	
}
