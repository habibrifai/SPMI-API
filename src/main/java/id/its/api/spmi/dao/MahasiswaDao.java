package id.its.api.spmi.dao;

import java.util.List;

import id.its.api.spmi.model.Mahasiswa;
import id.its.api.spmi.model.MahasiswaBaru;
import id.its.api.spmi.model.MahasiswaLulus;

public interface MahasiswaDao {
	
	List<MahasiswaBaru> countMaba1(String fakultas);
	List<MahasiswaBaru> countMaba2(String fakultas, String jenjang);
	List<MahasiswaBaru> countMaba3(Integer kodeProdi, String jenjang);
	List<MahasiswaBaru> countMaba4(Integer kodeProdi);
	List<MahasiswaBaru> countMaba5(String fakultas, Integer kodeProdi);
	List<MahasiswaBaru> countMaba(String fakultas, Integer kodeProdi, String jenjang);
	List<Mahasiswa> countMahasiswa1(String fakultas);
	List<Mahasiswa> countMahasiswa2(Integer kodeProdi);
	List<Mahasiswa> countMahasiswa3(String fakultas, String status);
	List<Mahasiswa> countMahasiswa4(Integer kodeProdi, String status);
	List<Mahasiswa> countMahasiswa5(String fakultas, String statusSimplified);
	List<Mahasiswa> countMahasiswa6(Integer kodeProdi, String statusSimplified);
	List<Mahasiswa> countMahasiswa7(String fakultas, String status, String statusSimplified);
	List<Mahasiswa> countMahasiswa8(Integer kodeProdi, String status, String statusSimplified);
	List<Mahasiswa> countMahasiswa9(String fakultas, Integer ts, String status);
	List<Mahasiswa> countMahasiswa10(Integer kodeProdi, Integer ts, String status);
	List<Mahasiswa> countMahasiswa11(String fakultas, Integer ts, String status, String statusSimplified);
	List<Mahasiswa> countMahasiswa12(Integer kodeProdi, Integer ts, String status, String statusSimplified);
	List<Mahasiswa> countMahasiswa13(String fakultas, Integer ts, String statusSimplified);
	List<Mahasiswa> countMahasiswa14(Integer kodeProdi, Integer ts, String statusSimplified);
	List<Mahasiswa> countMahasiswa15(String fakultas, Integer ts);
	List<Mahasiswa> countMahasiswa16(Integer kodeProdi, Integer ts);
	List<Mahasiswa> countMahasiswa17(String fakultas, String jenjang);
	List<Mahasiswa> countMahasiswa18(Integer kodeProdi, String jenjang);
	List<Mahasiswa> countMahasiswa19(String fakultas, String jenjang, String statusSimplified);
	List<Mahasiswa> countMahasiswa20(Integer kodeProdi, String jenjang, String statusSimplified);
	List<Mahasiswa> countMahasiswa21(String fakultas, String jenjang, Integer ts);
	List<Mahasiswa> countMahasiswa22(Integer kodeProdi, String jenjang, Integer ts);
	List<Mahasiswa> countMahasiswa23(String fakultas, String jenjang, Integer ts, String statusSimplified);
	List<Mahasiswa> countMahasiswa24(Integer kodeProdi, String jenjang, Integer ts, String statusSimplified);
	List<Mahasiswa> countMahasiswa25(String fakultas, String jenjang, String status);
	List<Mahasiswa> countMahasiswa26(Integer kodeProdi, String jenjang, String status);
	List<Mahasiswa> countMahasiswa27(String fakultas, String jenjang, String status, String statusSimplified);
	List<Mahasiswa> countMahasiswa28(Integer kodeProdi, String jenjang, String status, String statusSimplified);
	List<Mahasiswa> countMahasiswa29(String fakultas, String jenjang, Integer ts, String status);
	List<Mahasiswa> countMahasiswa30(Integer kodeProdi, String jenjang, Integer ts, String status);
	List<Mahasiswa> countMahasiswa31(String fakultas, String jenjang, Integer ts, String status, String statusSimplified);
	List<Mahasiswa> countMahasiswa32(Integer kodeProdi, String jenjang, Integer ts, String status, String statusSimplified);
	List<Mahasiswa> countMahasiswa(String fakultas, Integer kodeProdi, String jenjang, Integer ts, String status, String statusSimplified);
	List<MahasiswaLulus> countLulusan1(Integer kodeProdi);
	List<MahasiswaLulus> countLulusan2(String fakultas);
	List<MahasiswaLulus> countLulusan3(String fakultas, String jenjang);
	List<MahasiswaLulus> countLulusan4(Integer kodeProdi, String jenjang);
	List<MahasiswaLulus> countLulusan5(String fakultas, Integer kodeProdi);
	List<MahasiswaLulus> countLulusan6(String fakultas, Integer kodeProdi, String jenjang);
	List<MahasiswaLulus> countLulusan7(Integer kodeProdi, Integer tahunLulus);
	List<MahasiswaLulus> countLulusan8(String fakultas, Integer tahunLulus);
	List<MahasiswaLulus> countLulusan9(String fakultas, String jenjang, Integer tahunLulus);
	List<MahasiswaLulus> countLulusan10(Integer kodeProdi, String jenjang, Integer tahunLulus);
	List<MahasiswaLulus> countLulusan11(String fakultas, Integer kodeProdi, Integer tahunLulus);
	List<MahasiswaLulus> countLulusan12(String fakultas, Integer kodeProdi, String jenjang, Integer tahunLulus);
	List<MahasiswaLulus> countLulusan13(Integer kodeProdi, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan14(String fakultas, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan15(String fakultas, String jenjang, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan16(Integer kodeProdi, String jenjang, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan17(String fakultas, Integer kodeProdi, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan18(String fakultas, Integer kodeProdi, String jenjang, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan19(Integer kodeProdi, Integer tahunLulus, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan20(String fakultas, Integer tahunLulus, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan21(String fakultas, String jenjang, Integer tahunLulus, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan22(Integer kodeProdi, String jenjang, Integer tahunLulus, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan23(String fakultas, Integer kodeProdi, Integer tahunLulus, Integer tahunMasuk);
	List<MahasiswaLulus> countLulusan(String fakultas, Integer kodeProdi, String jenjang, Integer tahunLulus, Integer tahunMasuk);



	
}
