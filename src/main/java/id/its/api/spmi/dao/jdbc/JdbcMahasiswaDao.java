package id.its.api.spmi.dao.jdbc;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import id.its.api.spmi.dao.AbstractDao;
import id.its.api.spmi.dao.MahasiswaDao;
import id.its.api.spmi.dao.mapper.MahasiswaBaruRowMapper;
import id.its.api.spmi.dao.mapper.MahasiswaLulusRowMapper;
import id.its.api.spmi.dao.mapper.MahasiswaRowMapper;
import id.its.api.spmi.model.Mahasiswa;
import id.its.api.spmi.model.MahasiswaBaru;
import id.its.api.spmi.model.MahasiswaLulus;

public class JdbcMahasiswaDao extends AbstractDao implements MahasiswaDao{

	@Override
	public List<MahasiswaBaru> countMaba1(String fakultas) {
		String sql = "SELECT COUNT(id) as jumlahMaba "
				+ "FROM mahasiswa u WHERE "
				+ "u.fakultas = :fakultas "
				+ "and u.tahun_angkatan = (SELECT MAX(u.tahun_angkatan) FROM mahasiswa u)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaBaru> jumlahMaba = jdbcTemplate.query(sql, params, new MahasiswaBaruRowMapper());

		return jumlahMaba;
	}

	@Override
	public List<MahasiswaBaru> countMaba2(String fakultas, String jenjang) {
		String sql = "SELECT COUNT(id) as jumlahMaba "
				+ "FROM mahasiswa u WHERE "
				+ "u.fakultas = :fakultas "
				+ "and u.tahun_angkatan = (SELECT MAX(u.tahun_angkatan) FROM mahasiswa u) and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaBaru> jumlahMaba = jdbcTemplate.query(sql, params, new MahasiswaBaruRowMapper());

		return jumlahMaba;
	}

	@Override
	public List<MahasiswaBaru> countMaba3(Integer kodeProdi, String jenjang) {
		String sql = "SELECT COUNT(id) as jumlahMaba "
				+ "FROM mahasiswa u WHERE "
				+ "u.kodeprodi LIKE :kodeProdi "
				+ "and u.tahun_angkatan = (SELECT MAX(u.tahun_angkatan) FROM mahasiswa u) and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaBaru> jumlahMaba = jdbcTemplate.query(sql, params, new MahasiswaBaruRowMapper());

		return jumlahMaba;
	}

	@Override
	public List<MahasiswaBaru> countMaba4(Integer kodeProdi) {
		String sql = "SELECT COUNT(id) as jumlahMaba "
				+ "FROM mahasiswa u WHERE "
				+ "u.kodeprodi LIKE :kodeProdi "
				+ "and u.tahun_angkatan = (SELECT MAX(u.tahun_angkatan) FROM mahasiswa u)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaBaru> jumlahMaba = jdbcTemplate.query(sql, params, new MahasiswaBaruRowMapper());

		return jumlahMaba;
	}

	@Override
	public List<MahasiswaBaru> countMaba5(String fakultas, Integer kodeProdi) {
		String sql = "SELECT COUNT(id) as jumlahMaba "
				+ "FROM mahasiswa u WHERE "
				+ "u.kodeprodi LIKE :kodeProdi and u.fakultas = :fakultas "
				+ "and u.tahun_angkatan = (SELECT MAX(u.tahun_angkatan) FROM mahasiswa u)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaBaru> jumlahMaba = jdbcTemplate.query(sql, params, new MahasiswaBaruRowMapper());

		return jumlahMaba;
	}

	@Override
	public List<MahasiswaBaru> countMaba(String fakultas, Integer kodeProdi, String jenjang) {
		String sql = "SELECT COUNT(id) as jumlahMaba "
				+ "FROM mahasiswa u WHERE "
				+ "u.kodeprodi LIKE :kodeProdi and u.fakultas = :fakultas and u.jenjang = :jenjang "
				+ "and u.tahun_angkatan = (SELECT MAX(u.tahun_angkatan) FROM mahasiswa u)";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaBaru> jumlahMaba = jdbcTemplate.query(sql, params, new MahasiswaBaruRowMapper());

		return jumlahMaba;
	}

	@Override
	public List<Mahasiswa> countMahasiswa1(String fakultas) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa2(Integer kodeProdi) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa3(String fakultas, String status) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.statusaktif = :status";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("status", status);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa4(Integer kodeProdi, String status) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.statusaktif = :status";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("status", status);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa5(String fakultas, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa6(Integer kodeProdi, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa7(String fakultas, String status, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.statusaktif_simplified = :statusSimplified and u.statusaktif = :status";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("statusSimplified", statusSimplified);
		params.put("status", status);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa8(Integer kodeProdi, String status, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.statusaktif_simplified = :statusSimplified and u.statusaktif = :status";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("statusSimplified", statusSimplified);
		params.put("status", status);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa9(String fakultas, Integer ts, String status) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.tahun_angkatan = :ts and u.statusaktif = :status";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("ts", ts);
		params.put("status", status);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa10(Integer kodeProdi, Integer ts, String status) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.tahun_angkatan = :ts and u.statusaktif = :status";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("ts", ts);
		params.put("status", status);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa11(String fakultas, Integer ts, String status, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.tahun_angkatan = :ts and u.statusaktif = :status and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("ts", ts);
		params.put("status", status);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa12(Integer kodeProdi, Integer ts, String status, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.tahun_angkatan = :ts and u.statusaktif = :status and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("ts", ts);
		params.put("status", status);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa13(String fakultas, Integer ts, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.tahun_angkatan = :ts and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("ts", ts);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa14(Integer kodeProdi, Integer ts, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.tahun_angkatan = :ts and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("ts", ts);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa15(String fakultas, Integer ts) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.tahun_angkatan = :ts";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("ts", ts);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa16(Integer kodeProdi, Integer ts) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.tahun_angkatan = :ts";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("ts", ts);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa17(String fakultas, String jenjang) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa18(Integer kodeProdi, String jenjang) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa19(String fakultas, String jenjang, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.jenjang = :jenjang and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa20(Integer kodeProdi, String jenjang, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa21(String fakultas, String jenjang, Integer ts) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.jenjang = :jenjang and u.tahun_angkatan = :ts";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("ts", ts);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa22(Integer kodeProdi, String jenjang, Integer ts) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang and u.tahun_angkatan = :ts";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("ts", ts);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa23(String fakultas, String jenjang, Integer ts, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.jenjang = :jenjang and u.tahun_angkatan = :ts and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("ts", ts);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa24(Integer kodeProdi, String jenjang, Integer ts, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang and u.tahun_angkatan = :ts and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("ts", ts);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa25(String fakultas, String jenjang, String status) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.jenjang = :jenjang and u.statusaktif = :status";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("status", status);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa26(Integer kodeProdi, String jenjang, String status) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang and u.statusaktif = :status";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("status", status);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa27(String fakultas, String jenjang, String status, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.jenjang = :jenjang and u.statusaktif = :status and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("status", status);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa28(Integer kodeProdi, String jenjang, String status, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang and u.statusaktif = :status and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("status", status);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa29(String fakultas, String jenjang, Integer ts, String status) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.jenjang = :jenjang and u.statusaktif = :status and u.tahun_angkatan = :ts";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("status", status);
		params.put("ts", ts);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa30(Integer kodeProdi, String jenjang, Integer ts, String status) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang and u.statusaktif = :status and u.tahun_angkatan = :ts";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("status", status);
		params.put("ts", ts);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa31(String fakultas, String jenjang, Integer ts, String status, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.jenjang = :jenjang "
				+ "and u.statusaktif = :status and u.tahun_angkatan = :ts and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("status", status);
		params.put("ts", ts);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa32(Integer kodeProdi, String jenjang, Integer ts, String status, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang "
				+ "and u.statusaktif = :status and u.tahun_angkatan = :ts and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("status", status);
		params.put("ts", ts);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<Mahasiswa> countMahasiswa(String fakultas, Integer kodeProdi, String jenjang, Integer ts, String status, String statusSimplified) {
		String sql = "SELECT COUNT(id) as jumlahMhs "
				+ "FROM mahasiswa u "
				+ "WHERE u.fakultas = :fakultas and u.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang "
				+ "and u.statusaktif = :status and u.tahun_angkatan = :ts and u.statusaktif_simplified = :statusSimplified";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("status", status);
		params.put("ts", ts);
		params.put("statusSimplified", statusSimplified);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<Mahasiswa> jumlahMhs = jdbcTemplate.query(sql, params, new MahasiswaRowMapper());

		return jumlahMhs;
	}

	@Override
	public List<MahasiswaLulus> countLulusan1(Integer kodeProdi) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}
	
	@Override
	public List<MahasiswaLulus> countLulusan2(String fakultas) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();
		
		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());
		
		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan3(String fakultas, String jenjang) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan4(Integer kodeProdi, String jenjang) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan5(String fakultas, Integer kodeProdi) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and m.fakultas = :fakultas";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("fakultas", fakultas);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan6(String fakultas, Integer kodeProdi, String jenjang) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and m.fakultas = :fakultas "
				+ "and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan7(Integer kodeProdi, Integer tahunLulus) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.PERIODESEM LIKE :tahunLulus";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan8(String fakultas, Integer tahunLulus) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas and u.PERIODESEM LIKE :tahunLulus";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan9(String fakultas, String jenjang, Integer tahunLulus) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas and u.PERIODESEM LIKE :tahunLulus and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan10(Integer kodeProdi, String jenjang, Integer tahunLulus) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.PERIODESEM LIKE :tahunLulus and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan11(String fakultas, Integer kodeProdi, Integer tahunLulus) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas and u.PERIODESEM LIKE :tahunLulus and m.kodeprodi LIKE :kodeProdi";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("kodeProdi", kodeProdi+"%");
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan12(String fakultas, Integer kodeProdi, String jenjang, Integer tahunLulus) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas and u.PERIODESEM LIKE :tahunLulus "
				+ "and m.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan13(Integer kodeProdi, Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.tahun_masuk = :tahunMasuk";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("tahunMasuk", tahunMasuk);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan14(String fakultas, Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas and u.tahun_masuk = :tahunMasuk";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("tahunMasuk", tahunMasuk);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan15(String fakultas, String jenjang, Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas and u.tahun_masuk = :tahunMasuk and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("tahunMasuk", tahunMasuk);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan16(Integer kodeProdi, String jenjang, Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.tahun_masuk = :tahunMasuk and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("tahunMasuk", tahunMasuk);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan17(String fakultas, Integer kodeProdi, Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.tahun_masuk = :tahunMasuk and m.fakultas = :fakultas";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("fakultas", fakultas);
		params.put("tahunMasuk", tahunMasuk);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan18(String fakultas, Integer kodeProdi, String jenjang, Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.tahun_masuk = :tahunMasuk "
				+ "and m.fakultas = :fakultas and u.jenjang = :jenjang";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("fakultas", fakultas);
		params.put("tahunMasuk", tahunMasuk);
		params.put("jenjang", jenjang);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan19(Integer kodeProdi, Integer tahunLulus, Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.tahun_masuk = :tahunMasuk "
				+ "and u.PERIODESEM LIKE :tahunLulus";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("tahunMasuk", tahunMasuk);
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan20(String fakultas, Integer tahunLulus, Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas and u.tahun_masuk = :tahunMasuk "
				+ "and u.PERIODESEM LIKE :tahunLulus";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("tahunMasuk", tahunMasuk);
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan21(String fakultas, String jenjang, Integer tahunLulus,
			Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.fakultas = :fakultas and u.jenjang = :jenjang "
				+ "and u.PERIODESEM LIKE :tahunLulus";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("fakultas", fakultas);
		params.put("jenjang", jenjang);
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan22(Integer kodeProdi, String jenjang, Integer tahunLulus,
			Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.jenjang = :jenjang "
				+ "and u.PERIODESEM LIKE :tahunLulus";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("jenjang", jenjang);
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan23(String fakultas, Integer kodeProdi, Integer tahunLulus,
			Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and u.fakultas = :fakultas "
				+ "and u.PERIODESEM LIKE :tahunLulus";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("fakultas", fakultas);
		params.put("tahunLulus", tahunLulus+"%");
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());

		return mahasiswaLulus;
	}

	@Override
	public List<MahasiswaLulus> countLulusan(String fakultas, Integer kodeProdi, String jenjang, Integer tahunLulus,
			Integer tahunMasuk) {
		String sql = "SELECT COUNT(*) as jumlahLulusan, "
				+ "ROUND(AVG(CAST(u.lama_studi as float)/2),2) as rataLamaStudi, "
				+ "ROUND(AVG(CAST(u.ipk as float)),2) as rataIpk, "
				+ "ROUND(MAX(u.ipk),2) as maxIpk, ROUND(MIN(u.ipk),2) as minIpk "
				+ "FROM mahasiswa_lulus u JOIN mahasiswa m on u.nrp = m.nrp "
				+ "WHERE m.kodeprodi LIKE :kodeProdi and m.fakultas = :fakultas "
				+ "and u.PERIODESEM LIKE :tahunLulus and u.jenjang = :jenjang and u.tahun_masuk = :tahunMasuk";
		
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("kodeProdi", kodeProdi+"%");
		params.put("fakultas", fakultas);
		params.put("tahunLulus", tahunLulus+"%");
		params.put("jenjang", jenjang);
		params.put("tahunMasuk", tahunMasuk);
		NamedParameterJdbcTemplate jdbcTemplate = getNamedParameterJdbcTemplate();

		List<MahasiswaLulus> mahasiswaLulus = jdbcTemplate.query(sql, params, new MahasiswaLulusRowMapper());
		
		System.out.println("lulusan");
		System.out.println(mahasiswaLulus.get(0).getJumlahLulusan());

		return mahasiswaLulus;
	}

}