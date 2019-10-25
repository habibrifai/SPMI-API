package id.its.api.spmi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import id.its.api.spmi.dao.AbstractDao;
import id.its.api.spmi.dao.DosenDao;
import id.its.api.spmi.dao.mapper.BebanKerjaDosenRowMapper;
import id.its.api.spmi.dao.mapper.DosenRowMapper;
import id.its.api.spmi.dao.mapper.IpDosenRowMapper;
import id.its.api.spmi.dao.mapper.JabatanDosenRowMapper;
import id.its.api.spmi.model.BebanKerjaDosen;
import id.its.api.spmi.model.Dosen;
import id.its.api.spmi.model.IpDosen;
import id.its.api.spmi.model.JabatanDosen;

public class JdbcDosenDao extends AbstractDao implements DosenDao{

	@Override
	public List<JabatanDosen> countFungsionalDosen1(Integer kodeProdi, String jabatan) {
		String sql = "SELECT jenis_kelamin as jenisKelamin, fungsional as fungsional, COUNT(*) as jumlahDosen "
				+ "FROM dosen "
				+ "WHERE "
				+ "kodeunitgate = :kodeProdi and fungsional = :jabatan and is_out = '0' "
				+ "GROUP BY jenis_kelamin, fungsional";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("jabatan", jabatan);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<JabatanDosen> jumlahFungsionalDosen = jdbcTemplate.query(sql, params, new JabatanDosenRowMapper());

		return jumlahFungsionalDosen;
	}

	@Override
	public List<JabatanDosen> countFungsionalDosen2(String fakultas, String jabatan) {
		String sql = "SELECT jenis_kelamin as jenisKelamin, fungsional as fungsional, COUNT(*) as jumlahDosen "
				+ "FROM dosen "
				+ "WHERE "
				+ "fak = :fakultas and fungsional = :jabatan and is_out = '0' "
				+ "GROUP BY jenis_kelamin, fungsional";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jabatan", jabatan);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<JabatanDosen> jumlahFungsionalDosen = jdbcTemplate.query(sql, params, new JabatanDosenRowMapper());

		return jumlahFungsionalDosen;
	}

	@Override
	public List<JabatanDosen> countFungsionalDosen3(Integer kodeProdi) {
		String sql = "SELECT jenis_kelamin as jenisKelamin, fungsional as fungsional, COUNT(*) as jumlahDosen "
				+ "FROM dosen "
				+ "WHERE "
				+ "kodeunitgate = :kodeProdi and is_out = '0' "
				+ "GROUP BY jenis_kelamin, fungsional";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<JabatanDosen> jumlahFungsionalDosen = jdbcTemplate.query(sql, params, new JabatanDosenRowMapper());

		return jumlahFungsionalDosen;
	}

	@Override
	public List<JabatanDosen> countFungsionalDosen4(String fakultas) {
		String sql = "SELECT jenis_kelamin as jenisKelamin, fungsional as fungsional, COUNT(*) as jumlahDosen "
				+ "FROM dosen "
				+ "WHERE "
				+ "fak = :fakultas and is_out = '0' "
				+ "GROUP BY jenis_kelamin, fungsional";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<JabatanDosen> jumlahFungsionalDosen = jdbcTemplate.query(sql, params, new JabatanDosenRowMapper());

		return jumlahFungsionalDosen;
	}

	@Override
	public List<JabatanDosen> countFungsionalDosen(String fakultas, Integer kodeProdi, String jabatan) {
		String sql = "SELECT jenis_kelamin as jenisKelamin, fungsional as fungsional, COUNT(*) as jumlahDosen "
				+ "FROM dosen "
				+ "WHERE "
				+ "kodeunitgate = :kodeProdi and fak = :fakultas and fungsional = :jabatan and is_out = 0 "
				+ "GROUP BY jenis_kelamin, fungsional";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("kodeProdi", kodeProdi);
		params.put("jabatan", jabatan);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<JabatanDosen> jumlahFungsionalDosen = jdbcTemplate.query(sql, params, new JabatanDosenRowMapper());

		return jumlahFungsionalDosen;
	}

	@Override
	public List<BebanKerjaDosen> countRataBebanKerjaDosen1(Integer kodeProdi, String kategoriKegiatan, Integer tahun) {
		String sql = "SELECT ROUND(AVG(bk.sksbeban),2) as rataBebanKerjaDosen "
				+ "FROM dosen d JOIN bebankerja_dosen bk on d.nip_dosen = bk.nip_dosen "
				+ "WHERE "
				+ "("
				+ "(d.kodeunitgate = :kodeProdi and bk.kategorikegiatan = :kategoriKegiatan and bk.tahun = :tahun and d.is_out = '0')"
				+ ") "
				+ "and (((bk.kategorikegiatan = 'pendidikan') or (bk.kategorikegiatan = 'pengabdian masyarakat') or (bk.kategorikegiatan = 'penelitian')))";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("kategoriKegiatan", kategoriKegiatan);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<BebanKerjaDosen> rataBebanKerjaDosen = jdbcTemplate.query(sql, params, new BebanKerjaDosenRowMapper());

		return rataBebanKerjaDosen;
	}

	@Override
	public List<BebanKerjaDosen> countRataBebanKerjaDosen2(String fakultas, String kategoriKegiatan, Integer tahun) {
		String sql = "SELECT ROUND(AVG(bk.sksbeban),2) as rataBebanKerjaDosen "
				+ "FROM dosen d JOIN bebankerja_dosen bk on d.nip_dosen = bk.nip_dosen "
				+ "WHERE "
				+ "("
				+ "(d.fak = :fakultas and bk.kategorikegiatan = :kategoriKegiatan and bk.tahun = :tahun and d.is_out = '0')"
				+ ") "
				+ "and (((bk.kategorikegiatan = 'pendidikan') or (bk.kategorikegiatan = 'pengabdian masyarakat') or (bk.kategorikegiatan = 'penelitian')))";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("kategoriKegiatan", kategoriKegiatan);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<BebanKerjaDosen> rataBebanKerjaDosen = jdbcTemplate.query(sql, params, new BebanKerjaDosenRowMapper());

		return rataBebanKerjaDosen;
	}

	@Override
	public List<BebanKerjaDosen> countRataBebanKerjaDosen3(Integer kodeProdi, Integer tahun) {
		String sql = "SELECT ROUND(AVG(bk.sksbeban),2) as rataBebanKerjaDosen "
				+ "FROM dosen d JOIN bebankerja_dosen bk on d.nip_dosen = bk.nip_dosen "
				+ "WHERE "
				+ "("
				+ "(d.kodeunitgate = :kodeProdi and bk.tahun = :tahun and d.is_out = '0')"
				+ ") "
				+ "and (((bk.kategorikegiatan = 'pendidikan') or (bk.kategorikegiatan = 'pengabdian masyarakat') or (bk.kategorikegiatan = 'penelitian')))";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<BebanKerjaDosen> rataBebanKerjaDosen = jdbcTemplate.query(sql, params, new BebanKerjaDosenRowMapper());

		return rataBebanKerjaDosen;
	}

	@Override
	public List<BebanKerjaDosen> countRataBebanKerjaDosen4(String fakultas, Integer tahun) {
		String sql = "SELECT ROUND(AVG(bk.sksbeban),2) as rataBebanKerjaDosen "
				+ "FROM dosen d JOIN bebankerja_dosen bk on d.nip_dosen = bk.nip_dosen "
				+ "WHERE "
				+ "("
				+ "(d.fak = :fakultas and bk.tahun = :tahun and d.is_out = '0')"
				+ ") "
				+ "and (((bk.kategorikegiatan = 'pendidikan') or (bk.kategorikegiatan = 'pengabdian masyarakat') or (bk.kategorikegiatan = 'penelitian')))";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<BebanKerjaDosen> rataBebanKerjaDosen = jdbcTemplate.query(sql, params, new BebanKerjaDosenRowMapper());

		return rataBebanKerjaDosen;
	}

	@Override
	public List<BebanKerjaDosen> countRataBebanKerjaDosen5(Integer kodeProdi) {
		String sql = "SELECT ROUND(AVG(bk.sksbeban),2) as rataBebanKerjaDosen "
				+ "FROM dosen d JOIN bebankerja_dosen bk on d.nip_dosen = bk.nip_dosen "
				+ "WHERE "
				+ "("
				+ "(d.kodeunitgate = :kodeProdi and d.is_out = '0')"
				+ ") "
				+ "and (((bk.kategorikegiatan = 'pendidikan') or (bk.kategorikegiatan = 'pengabdian masyarakat') or (bk.kategorikegiatan = 'penelitian')))";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<BebanKerjaDosen> rataBebanKerjaDosen = jdbcTemplate.query(sql, params, new BebanKerjaDosenRowMapper());

		return rataBebanKerjaDosen;
	}

	@Override
	public List<BebanKerjaDosen> countRataBebanKerjaDosen6(String fakultas) {
		String sql = "SELECT ROUND(AVG(bk.sksbeban),2) as rataBebanKerjaDosen "
				+ "FROM dosen d JOIN bebankerja_dosen bk on d.nip_dosen = bk.nip_dosen "
				+ "WHERE "
				+ "("
				+ "(d.fak = :fakultas and d.is_out = '0')"
				+ ") "
				+ "and (((bk.kategorikegiatan = 'pendidikan') or (bk.kategorikegiatan = 'pengabdian masyarakat') or (bk.kategorikegiatan = 'penelitian')))";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<BebanKerjaDosen> rataBebanKerjaDosen = jdbcTemplate.query(sql, params, new BebanKerjaDosenRowMapper());

		return rataBebanKerjaDosen;
	}

	@Override
	public List<BebanKerjaDosen> countRataBebanKerjaDosen7(Integer kodeProdi, String kategoriKegiatan) {
		String sql = "SELECT ROUND(AVG(bk.sksbeban),2) as rataBebanKerjaDosen "
				+ "FROM dosen d JOIN bebankerja_dosen bk on d.nip_dosen = bk.nip_dosen "
				+ "WHERE "
				+ "("
				+ "(d.kodeunitgate = :kodeProdi and bk.kategorikegiatan = :kategoriKegiatan and d.is_out = '0')"
				+ ") "
				+ "and (((bk.kategorikegiatan = 'pendidikan') or (bk.kategorikegiatan = 'pengabdian masyarakat') or (bk.kategorikegiatan = 'penelitian')))";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("kategoriKegiatan", kategoriKegiatan);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<BebanKerjaDosen> rataBebanKerjaDosen = jdbcTemplate.query(sql, params, new BebanKerjaDosenRowMapper());

		return rataBebanKerjaDosen;
	}

	@Override
	public List<BebanKerjaDosen> countRataBebanKerjaDosen8(String fakultas, String kategoriKegiatan) {
		String sql = "SELECT ROUND(AVG(bk.sksbeban),2) as rataBebanKerjaDosen "
				+ "FROM dosen d JOIN bebankerja_dosen bk on d.nip_dosen = bk.nip_dosen "
				+ "WHERE "
				+ "("
				+ "(d.fak = :fakultas and bk.kategorikegiatan = :kategoriKegiatan and d.is_out = '0')"
				+ ") "
				+ "and (((bk.kategorikegiatan = 'pendidikan') or (bk.kategorikegiatan = 'pengabdian masyarakat') or (bk.kategorikegiatan = 'penelitian')))";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("kategoriKegiatan", kategoriKegiatan);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<BebanKerjaDosen> rataBebanKerjaDosen = jdbcTemplate.query(sql, params, new BebanKerjaDosenRowMapper());

		return rataBebanKerjaDosen;
	}

	@Override
	public List<BebanKerjaDosen> countRataBebanKerjaDosen(String fakultas, Integer kodeProdi, String kategoriKegiatan, Integer tahun) {
		String sql = "SELECT ROUND(AVG(bk.sksbeban),2) as rataBebanKerjaDosen "
				+ "FROM dosen d JOIN bebankerja_dosen bk on d.nip_dosen = bk.nip_dosen "
				+ "WHERE "
				+ "("
				+ "(d.fak = :fakultas and d.kodeunitgate = :kodeProdi and bk.kategorikegiatan = :kategoriKegiatan and bk.tahun = :tahun and d.is_out = '0')"
				+ ") "
				+ "and (((bk.kategorikegiatan = 'pendidikan') or (bk.kategorikegiatan = 'pengabdian masyarakat') or (bk.kategorikegiatan = 'penelitian')))";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("kodeProdi", kodeProdi);
		params.put("kategoriKegiatan", kategoriKegiatan);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<BebanKerjaDosen> rataBebanKerjaDosen = jdbcTemplate.query(sql, params, new BebanKerjaDosenRowMapper());

		return rataBebanKerjaDosen;
	}

	@Override
	public List<Dosen> countPengabdianDosen1(Integer kodeProdi) {
				
		String sql = "SELECT COUNT(DISTINCT p.nip_dosen) as jumlahDosen "
				+ "FROM dosen d JOIN pengabdian_dosen p on d.nip_dosen = p.nip_dosen "
				+ "WHERE "
				+ "(d.kodeunitgate = :kodeProdi and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countPengabdianDosen2(String fakultas) {
		String sql = "SELECT COUNT(DISTINCT p.nip_dosen) as jumlahDosen "
				+ "FROM dosen d JOIN pengabdian_dosen p on d.nip_dosen = p.nip_dosen "
				+ "WHERE "
				+ "(d.fak = :fakultas and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countPengabdianDosen3(Integer kodeProdi, Integer tahun) {
		String sql = "SELECT COUNT(DISTINCT p.nip_dosen) as jumlahDosen "
				+ "FROM dosen d JOIN pengabdian_dosen p on d.nip_dosen = p.nip_dosen "
				+ "WHERE "
				+ "(d.kodeunitgate = :kodeProdi and p.tahun = :tahun and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countPengabdianDosen4(String fakultas, Integer tahun) {
		String sql = "SELECT COUNT(DISTINCT p.nip_dosen) as jumlahDosen "
				+ "FROM dosen d JOIN pengabdian_dosen p on d.nip_dosen = p.nip_dosen "
				+ "WHERE "
				+ "(d.fak = :fakultas and p.tahun = :tahun and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countPengabdianDosen(String fakultas, Integer kodeProdi, Integer tahun) {
		String sql = "SELECT COUNT(DISTINCT p.nip_dosen) as jumlahDosen "
				+ "FROM dosen d JOIN pengabdian_dosen p on d.nip_dosen = p.nip_dosen "
				+ "WHERE "
				+ "(d.fak = :fakultas and d.kodeunitgate = :kodeProdi and p.tahun = :tahun and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("fakultas", fakultas);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countPenelitianDosen1(Integer kodeProdi) {
		String sql = "SELECT COUNT(DISTINCT d.nip_dosen) as jumlahDosen FROM "
				+ "penelitian_dosen p "
				+ "JOIN dosen d on d.nip_dosen = p.nip_dosen "
				+ "FULL JOIN dosen_buku db on d.nip_dosen = db.nip_baru "
				+ "WHERE (d.kodeunitgate = :kodeProdi and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countPenelitianDosen2(String fakultas) {
		String sql = "SELECT COUNT(DISTINCT d.nip_dosen) as jumlahDosen FROM "
				+ "penelitian_dosen p "
				+ "JOIN dosen d on d.nip_dosen = p.nip_dosen "
				+ "FULL JOIN dosen_buku db on d.nip_dosen = db.nip_baru "
				+ "WHERE (d.fakultas = :fakultas and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countPenelitianDosen3(Integer kodeProdi, Integer tahun) {
		String sql = "SELECT COUNT(DISTINCT d.nip_dosen) as jumlahDosen FROM "
				+ "penelitian_dosen p "
				+ "JOIN dosen d on d.nip_dosen = p.nip_dosen "
				+ "FULL JOIN dosen_buku db on d.nip_dosen = db.nip_baru "
				+ "WHERE (d.kodeunitgate = :kodeProdi and p.tahun = :tahun and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countPenelitianDosen4(String fakultas, Integer tahun) {
		String sql = "SELECT COUNT(DISTINCT d.nip_dosen) as jumlahDosen FROM "
				+ "penelitian_dosen p "
				+ "JOIN dosen d on d.nip_dosen = p.nip_dosen "
				+ "FULL JOIN dosen_buku db on d.nip_dosen = db.nip_baru "
				+ "WHERE (d.fak = :fakultas and p.tahun = :tahun and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countPenelitianDosen(String fakultas, Integer kodeProdi, Integer tahun) {
		String sql = "SELECT COUNT(DISTINCT d.nip_dosen) as jumlahDosen FROM "
				+ "penelitian_dosen p "
				+ "JOIN dosen d on d.nip_dosen = p.nip_dosen "
				+ "FULL JOIN dosen_buku db on d.nip_dosen = db.nip_baru "
				+ "WHERE (d.fak = :fakultas and d.kodeunitgate = :kodeProdi and p.tahun = :tahun and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("fakultas", fakultas);
		params.put("tahun", tahun);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<IpDosen> countRataIpd1(Integer kodeProdi) {
		String sql = "SELECT ROUND(AVG(i.ipd),2) as rataIpd "
				+ "FROM dosen d JOIN history_ipd i on d.nip_dosen = i.nip_baru "
				+ "WHERE "
				+ "(d.kodeunitgate = :kodeProdi and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<IpDosen> rataIpd = jdbcTemplate.query(sql, params, new IpDosenRowMapper());
		
		return rataIpd;
	}

	@Override
	public List<IpDosen> countRataIpd2(String fakultas) {
		String sql = "SELECT ROUND(AVG(i.ipd),2) as rataIpd "
				+ "FROM dosen d JOIN history_ipd i on d.nip_dosen = i.nip_baru "
				+ "WHERE "
				+ "(d.fak = :fakultas and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<IpDosen> rataIpd = jdbcTemplate.query(sql, params, new IpDosenRowMapper());
		
		return rataIpd;
	}

	@Override
	public List<IpDosen> countRataIpd3(Integer kodeProdi, Integer tahunAjaran) {
		String sql = "SELECT ROUND(AVG(i.ipd),2) as rataIpd "
				+ "FROM dosen d JOIN history_ipd i on d.nip_dosen = i.nip_baru "
				+ "WHERE "
				+ "(d.kodeunitgate = :kodeProdi and i.tahun_ajaran = :tahunAjaran and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("tahunAjaran", tahunAjaran);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<IpDosen> rataIpd = jdbcTemplate.query(sql, params, new IpDosenRowMapper());
		
		return rataIpd;
	}

	@Override
	public List<IpDosen> countRataIpd4(String fakultas, Integer tahunAjaran) {
		String sql = "SELECT ROUND(AVG(i.ipd),2) as rataIpd "
				+ "FROM dosen d JOIN history_ipd i on d.nip_dosen = i.nip_baru "
				+ "WHERE "
				+ "(d.fak = :fakultas and i.tahun_ajaran = :tahunAjaran and d.is_out = '0')";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("tahunAjaran", tahunAjaran);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<IpDosen> rataIpd = jdbcTemplate.query(sql, params, new IpDosenRowMapper());
		
		return rataIpd;
	}

	@Override
	public List<IpDosen> countRataIpd(String fakultas, Integer kodeProdi, Integer tahunAjaran) {
		String sql = "SELECT ROUND(AVG(i.ipd),2) as rataIpd "
				+ "FROM dosen d JOIN history_ipd i on d.nip_dosen = i.nip_baru "
				+ "WHERE "
				+ "d.kodeunitgate = :kodeProdi and d.fak = :fakultas and i.tahun_ajaran = :tahunAjaran and d.is_out = '0'";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("fakultas", fakultas);
		params.put("tahunAjaran", tahunAjaran);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<IpDosen> rataIpd = jdbcTemplate.query(sql, params, new IpDosenRowMapper());
		
		return rataIpd;
	}

	@Override
	public List<Dosen> countDosen1(Integer kodeProdi, String pendidikanTerakhir, Integer isOut) {
		String sql = "SELECT COUNT(*) as jumlahDosen "
				+ "FROM dosen d "
				+ "WHERE "
				+ "(d.kodeunitgate = :kodeProdi and d.pendidikan_terakhir = :pendidikanTerakhir and d.is_out = :isOut)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("pendidikanTerakhir", pendidikanTerakhir);
		params.put("isOut", isOut);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countDosen2(Integer kodeProdi, String pendidikanTerakhir) {
		String sql = "SELECT COUNT(*) as jumlahDosen "
				+ "FROM dosen d "
				+ "WHERE "
				+ "(d.kodeunitgate = :kodeProdi and d.pendidikan_terakhir = :pendidikanTerakhir)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("pendidikanTerakhir", pendidikanTerakhir);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countDosen3(String fakultas, String pendidikanTerakhir, Integer isOut) {
		String sql = "SELECT COUNT(*) as jumlahDosen "
				+ "FROM dosen d "
				+ "WHERE "
				+ "(d.fak = :fakultas and d.pendidikan_terakhir = :pendidikanTerakhir and d.is_out = :isOut)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("pendidikanTerakhir", pendidikanTerakhir);
		params.put("isOut", isOut);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countDosen4(String fakultas, String pendidikanTerakhir) {
		String sql = "SELECT COUNT(*) as jumlahDosen "
				+ "FROM dosen d "
				+ "WHERE "
				+ "(d.fak = :fakultas and d.pendidikan_terakhir = :pendidikanTerakhir)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("pendidikanTerakhir", pendidikanTerakhir);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countDosen5(Integer kodeProdi, Integer isOut) {
		String sql = "SELECT COUNT(*) as jumlahDosen "
				+ "FROM dosen d "
				+ "WHERE "
				+ "(d.kodeunitgate = :kodeProdi and d.is_out = :isOut)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		params.put("isOut", isOut);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countDosen6(Integer kodeProdi) {
		String sql = "SELECT COUNT(*) as jumlahDosen "
				+ "FROM dosen d "
				+ "WHERE "
				+ "(d.kodeunitgate = :kodeProdi)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countDosen7(String fakultas, Integer isOut) {
		String sql = "SELECT COUNT(*) as jumlahDosen "
				+ "FROM dosen d "
				+ "WHERE "
				+ "(d.fak = :fakultas and d.is_out = :isOut)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("isOut", isOut);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countDosen8(String fakultas) {
		String sql = "SELECT COUNT(*) as jumlahDosen "
				+ "FROM dosen d "
				+ "WHERE "
				+ "(d.fak = :fakultas)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		
		return jumlahDosen;
	}

	@Override
	public List<Dosen> countDosen(String fakultas, Integer kodeProdi, String pendidikanTerakhir, Integer isOut) {
		String sql = "SELECT COUNT(*) as jumlahDosen "
				+ "FROM dosen "
				+ "WHERE fak = :fakultas and kodeunitgate = :kodeProdi "
				+ "and pendidikan_terakhir = :pendidikanTerakhir and is_out = :isOut";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("kodeProdi", kodeProdi);
		params.put("pendidikanTerakhir", pendidikanTerakhir);
		params.put("isOut", isOut);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<Dosen> jumlahDosen = jdbcTemplate.query(sql, params, new DosenRowMapper());
		return jumlahDosen;
	}
}