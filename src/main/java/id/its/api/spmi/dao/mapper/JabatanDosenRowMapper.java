package id.its.api.spmi.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import id.its.api.spmi.model.JabatanDosen;

public class JabatanDosenRowMapper implements RowMapper<JabatanDosen>{

	@Override
	public JabatanDosen mapRow(ResultSet rs, int rowNum) throws SQLException {
		JabatanDosen d = new JabatanDosen();
		
		d.setJabatanFungsional(rs.getString("fungsional"));
		d.setJenisKelamin(rs.getString("jenisKelamin"));
		d.setJumlahDosen(rs.getInt("jumlahDosen"));
//		d.setRataBebanKerjaDosen(rs.getDouble("rataBebanKerjaDosen"));
//		d.setRataIpd(rs.getDouble("rataIpd"));
	
		return d;
	}
}