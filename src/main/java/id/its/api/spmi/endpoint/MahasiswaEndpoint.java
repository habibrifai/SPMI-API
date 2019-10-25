package id.its.api.spmi.endpoint;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.DataFetcher;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import id.its.api.spmi.dao.MahasiswaDao;
import id.its.api.spmi.model.Mahasiswa;
import id.its.api.spmi.model.MahasiswaBaru;
import id.its.api.spmi.model.MahasiswaLulus;

@Path("/mahasiswa")
public class MahasiswaEndpoint{
	private MahasiswaDao mahasiswaDao;

	public MahasiswaDao getMahasiswaDao() {
		return mahasiswaDao;
	}

	public void setMahasiswaDao(MahasiswaDao mahasiswaDao) {
		this.mahasiswaDao = mahasiswaDao;
	}
	
	private GraphQL graphQL;
	
	public void loadSchema() {
		try {
			
			URL res = getClass().getClassLoader().getResource("data.graphqls");
			File file = Paths.get(res.toURI()).toFile();
			String absolutePath = file.getAbsolutePath();
			
			File schemaFile = new File(absolutePath);

			TypeDefinitionRegistry registry = new SchemaParser().parse(schemaFile);
			RuntimeWiring wiring = buildWiring();
			GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(registry, wiring);
			this.graphQL = GraphQL.newGraphQL(schema).build();
		} catch(Exception e) {
			System.out.print(e.toString());
		}
	}
	
	private RuntimeWiring buildWiring() {
		DataFetcher<List<MahasiswaBaru>> fetcherMahasiswaBaru = data -> {
			try {
				
				String fakultas = data.getArgument("fakultas");
				Integer kodeProdi = data.getArgument("kodeProdi");
				String jenjang = data.getArgument("jenjang");
				
//				filter berdasarkan fakultas
				if(fakultas != null && kodeProdi == null && jenjang == null) {
					return (List<MahasiswaBaru>) this.mahasiswaDao.countMaba1(fakultas);
//				filter berdasarkan fakultas dan jenjang
				} else if(fakultas != null && kodeProdi == null && jenjang != null) {
					return (List<MahasiswaBaru>) this.mahasiswaDao.countMaba2(fakultas, jenjang);
//				filter berdasarkan kodeProdi dan jenjang
				} else if(fakultas == null && kodeProdi != null && jenjang != null) {
					return (List<MahasiswaBaru>) this.mahasiswaDao.countMaba3(kodeProdi, jenjang);
//				filter berdasarkan kodeProdi
				} else if(fakultas == null && kodeProdi != null && jenjang == null) {
					return (List<MahasiswaBaru>) this.mahasiswaDao.countMaba4(kodeProdi);
//				filter berdasarkan kodeProdi dan fakultas
				} else if(fakultas != null && kodeProdi != null && jenjang == null) {
					return (List<MahasiswaBaru>) this.mahasiswaDao.countMaba5(fakultas, kodeProdi);
//				filter berdasarkan fakultas, kodeProdi, dan jenjang
				} else {
					return (List<MahasiswaBaru>) this.mahasiswaDao.countMaba(fakultas, kodeProdi, jenjang);
				}
			} catch(Exception e) {
				return null;
			}
		};
		
		DataFetcher<List<MahasiswaLulus>> fetcherMahasiswaLulus = data -> {
			try {
				
				String fakultas = data.getArgument("fakultas");
				Integer kodeProdi = data.getArgument("kodeProdi");
				String jenjang = data.getArgument("jenjang");
				Integer tahunLulus = data.getArgument("tahunLulus");
				Integer tahunMasuk = data.getArgument("tahunMasuk");
				
//				filter berdasarkan kodeprodi
				if(kodeProdi != null && fakultas == null && jenjang == null && tahunLulus == null && tahunMasuk == null) {
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan1(kodeProdi);
//				filter berdasarkan fakultas
				} else if(kodeProdi == null && fakultas != null && jenjang == null && tahunLulus == null && tahunMasuk == null) {
					System.out.println("lalala");
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan2(fakultas);
//				filter berdasarkan fakultas dan jenjang
				} else if(kodeProdi == null && fakultas != null && jenjang != null && tahunLulus == null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan3(fakultas, jenjang);
//				filter berdasarkan kodeProdi dan jenjang
				} else if(kodeProdi != null && fakultas == null && jenjang != null && tahunLulus == null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan4(kodeProdi, jenjang);
//				filter berdasarkan fakultas dan kodeProdi
				} else if(kodeProdi != null && fakultas != null && jenjang == null && tahunLulus == null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan5(fakultas, kodeProdi);
//				filter berdasarkan fakultas, jenjang, dan kodeProdi
				} else if(kodeProdi != null && fakultas != null && jenjang != null && tahunLulus == null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan6(fakultas, kodeProdi, jenjang);
//				filter berdasarkan kodeprodi dan tahunLulus
				}else if(kodeProdi != null && fakultas == null && jenjang == null && tahunLulus != null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan7(kodeProdi, tahunLulus);
//				filter berdasarkan fakultas dan tahunLulus
				} else if(kodeProdi == null && fakultas != null && jenjang == null && tahunLulus != null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan8(fakultas, tahunLulus);
//				filter berdasarkan fakultas dan jenjang dan tahunLulus
				} else if(kodeProdi == null && fakultas != null && jenjang != null && tahunLulus != null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan9(fakultas, jenjang, tahunLulus);
//				filter berdasarkan kodeProdi dan jenjang dan tahunLulus
				} else if(kodeProdi != null && fakultas == null && jenjang != null && tahunLulus != null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan10(kodeProdi, jenjang, tahunLulus);
//				filter berdasarkan fakultas dan kodeProdi dan tahunLulus
				} else if(kodeProdi != null && fakultas != null && jenjang == null && tahunLulus != null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan11(fakultas, kodeProdi, tahunLulus);
//				filter berdasarkan fakultas, jenjang, dan kodeProdi dan tahunLulus dan tahunMasuk
				} else if(kodeProdi != null && fakultas != null && jenjang != null && tahunLulus != null && tahunMasuk == null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan12(fakultas, kodeProdi, jenjang, tahunLulus);
//				filter berdasarkan kodeprodi dan tahunMasuk
				} else if(kodeProdi != null && fakultas == null && jenjang == null && tahunLulus == null && tahunMasuk != null) {
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan13(kodeProdi, tahunMasuk);
//				filter berdasarkan fakultas dan tahunMasuk
				} else if(kodeProdi == null && fakultas != null && jenjang == null && tahunLulus == null && tahunMasuk != null) {
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan14(fakultas, tahunMasuk);
//				filter berdasarkan fakultas dan jenjang dan tahunMasuk
				} else if(kodeProdi == null && fakultas != null && jenjang != null && tahunLulus == null && tahunMasuk != null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan15(fakultas, jenjang, tahunMasuk);
//				filter berdasarkan kodeProdi dan jenjang dan tahunMasuk
				} else if(kodeProdi != null && fakultas == null && jenjang != null && tahunLulus == null && tahunMasuk != null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan16(kodeProdi, jenjang, tahunMasuk);
//				filter berdasarkan fakultas dan kodeProdi dan tahunMasuk
				} else if(kodeProdi != null && fakultas != null && jenjang == null && tahunLulus == null && tahunMasuk != null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan17(fakultas, kodeProdi, tahunMasuk);
//				filter berdasarkan fakultas, jenjang, dan kodeProdi dan tahunMasuk
				} else if(kodeProdi != null && fakultas != null && jenjang != null && tahunLulus == null && tahunMasuk != null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan18(fakultas, kodeProdi, jenjang, tahunMasuk);
//				filter berdasarkan kodeprodi dan tahunLulus dan tahunMasuk
				} else if(kodeProdi != null && fakultas == null && jenjang == null && tahunLulus != null && tahunMasuk != null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan19(kodeProdi, tahunLulus, tahunMasuk);
//				filter berdasarkan fakultas dan tahunLulus dan tahunMasuk
				} else if(kodeProdi == null && fakultas != null && jenjang == null && tahunLulus != null && tahunMasuk != null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan20(fakultas, tahunLulus, tahunMasuk);
//				filter berdasarkan fakultas dan jenjang dan tahunLulus dan tahunMasuk
				} else if(kodeProdi == null && fakultas != null && jenjang != null && tahunLulus != null && tahunMasuk != null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan21(fakultas, jenjang, tahunLulus, tahunMasuk);
//				filter berdasarkan kodeProdi dan jenjang dan tahunLulus dan tahunMasuk
				} else if(kodeProdi != null && fakultas == null && jenjang != null && tahunLulus != null && tahunMasuk != null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan22(kodeProdi, jenjang, tahunLulus, tahunMasuk);
//				filter berdasarkan fakultas dan kodeProdi dan tahunLulus dan tahunMasuk
				} else if(kodeProdi != null && fakultas != null && jenjang == null && tahunLulus != null && tahunMasuk != null){
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan23(fakultas, kodeProdi, tahunLulus, tahunMasuk);
//				filter berdasarkan fakultas, jenjang, dan kodeProdi dan tahunLulus dan tahunMasuk
				} else {
					return (List<MahasiswaLulus>) this.mahasiswaDao.countLulusan(fakultas, kodeProdi, jenjang, tahunLulus, tahunMasuk);
				}
			} catch(Exception e) {
				return null;
			}
		};
		
		DataFetcher<List<Mahasiswa>> fetcherMahasiswa = data -> { 
			try {
				
				String fakultas = data.getArgument("fakultas");
				Integer kodeProdi = data.getArgument("kodeProdi");
				String jenjang = data.getArgument("jenjang");
				Integer ts = data.getArgument("ts");
				String status = data.getArgument("status");
				String statusSimplified = data.getArgument("statusSimplified");
				
//				filter berdasarkan fakultas
				if(fakultas != null && kodeProdi == null && jenjang == null && ts == null && status == null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa1(fakultas);
//				filter berdasarkan kodeProdi
				} else if(fakultas == null && kodeProdi != null && jenjang == null && ts == null && status == null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa2(kodeProdi);
//				filter berdasarkan fakultas dan status
				} else if(fakultas != null && kodeProdi == null && jenjang == null && ts == null && status != null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa3(fakultas, status);
//				filter berdasarkan kodeProdi dan status
				} else if(fakultas == null && kodeProdi != null && jenjang == null && ts == null && status != null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa4(kodeProdi, status);
//				filter berdasarkan fakultas dan statusSimplified
				} else if(fakultas != null && kodeProdi == null && jenjang == null && ts == null && status == null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa5(fakultas, statusSimplified);
//				filter berdasarkan kodeProdi dan statusSimplified
				} else if(fakultas == null && kodeProdi != null && jenjang == null && ts == null && status == null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa6(kodeProdi, statusSimplified);
//				filter berdasarkan fakultas, status, dan statusSimplified
				} else if(fakultas != null && kodeProdi == null && jenjang == null && ts == null && status != null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa7(fakultas, status, statusSimplified);
//				filter berdasarkan kodeProdi, status, dan statusSimplified
				} else if(fakultas == null && kodeProdi != null && jenjang == null && ts == null && status != null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa8(kodeProdi, status, statusSimplified);
//				filter berdasarkan fakultas, ts, status
				} else if(fakultas != null && kodeProdi == null && jenjang == null && ts != null && status != null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa9(fakultas, ts, status);
//				filter berdasarkan kodeProdi, ts, status
				} else if(fakultas == null && kodeProdi != null && jenjang == null && ts != null && status != null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa10(kodeProdi, ts, status);
//				filter berdasarkan fakultas, ts, status, statusSimplified
				} else if(fakultas != null && kodeProdi == null && jenjang == null && ts != null && status != null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa11(fakultas, ts, status, statusSimplified);
//				filter berdasarkan kodeProdi, ts, status, statusSimplified
				} else if(fakultas == null && kodeProdi != null && jenjang == null && ts != null && status != null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa12(kodeProdi, ts, status, statusSimplified);
//				filter berdasarkan fakultas, ts, statusSimplified
				} else if(fakultas != null && kodeProdi == null && jenjang == null && ts != null && status == null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa13(fakultas, ts, statusSimplified);
//				filter berdasarkan kodeProdi, ts, statusSimplified
				} else if(fakultas == null && kodeProdi != null && jenjang == null && ts != null && status == null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa14(kodeProdi, ts, statusSimplified);
//				filter berdasarkan fakultas, ts
				} else if(fakultas != null && kodeProdi == null && jenjang == null && ts != null && status == null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa15(fakultas, ts);
//				filter berdasarkan kodeProdi, ts
				} else if(fakultas == null && kodeProdi != null && jenjang == null && ts != null && status == null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa16(kodeProdi, ts);
//				filter berdasarkan fakultas, jenjang
				} else if(fakultas != null && kodeProdi == null && jenjang != null && ts == null && status == null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa17(fakultas, jenjang);
//				filter berdasarkan kodeProdi, jenjang
				} else if(fakultas == null && kodeProdi != null && jenjang != null && ts == null && status == null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa18(kodeProdi, jenjang);
//				filter berdasarkan fakultas, jenjang, statusSimplified
				} else if(fakultas != null && kodeProdi == null && jenjang != null && ts == null && status == null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa19(fakultas, jenjang, statusSimplified);
//				filter berdasarkan kodeProdi, jenjang, statusSimplified
				} else if(fakultas == null && kodeProdi != null && jenjang != null && ts == null && status == null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa20(kodeProdi, jenjang, statusSimplified);
//				filter berdasarkan fakultas, jenjang, ts
				} else if(fakultas != null && kodeProdi == null && jenjang != null && ts != null && status == null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa21(fakultas, jenjang, ts);
//				filter berdasarkan kodeProdi, jenjang, ts
				} else if(fakultas == null && kodeProdi != null && jenjang != null && ts != null && status == null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa22(kodeProdi, jenjang, ts);
//				filter berdasarkan fakultas, jenjang, ts, statusSimplified
				} else if(fakultas != null && kodeProdi == null && jenjang != null && ts != null && status == null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa23(fakultas, jenjang, ts, statusSimplified);
//				filter berdasarkan kodeProdi, jenjang, ts, statusSimplified
				} else if(fakultas == null && kodeProdi != null && jenjang != null && ts != null && status == null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa24(kodeProdi, jenjang, ts, statusSimplified);
//				filter berdasarkan fakultas, jenjang, status
				} else if(fakultas != null && kodeProdi == null && jenjang != null && ts == null && status != null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa25(fakultas, jenjang, status);
//				filter berdasarkan kodeProdi, jenjang, status
				} else if(fakultas == null && kodeProdi != null && jenjang != null && ts == null && status != null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa26(kodeProdi, jenjang, status);
//				filter berdasarkan fakultas, jenjang, status, statusSimplified
				} else if(fakultas != null && kodeProdi == null && jenjang != null && ts == null && status != null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa27(fakultas, jenjang, status, statusSimplified);
//				filter berdasarkan kodeProdi, jenjang, status, statusSimplified
				} else if(fakultas == null && kodeProdi != null && jenjang != null && ts == null && status != null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa28(kodeProdi, jenjang, status, statusSimplified);
//				filter berdasarkan fakultas, jenjang, ts, status
				} else if(fakultas != null && kodeProdi == null && jenjang != null && ts != null && status != null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa29(fakultas, jenjang, ts, status);
//				filter berdasarkan kodeProdi, jenjang, ts, status
				} else if(fakultas == null && kodeProdi != null && jenjang != null && ts != null && status != null && statusSimplified == null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa30(kodeProdi, jenjang, ts, status);
//				filter berdasarkan fakultas, jenjang, ts, status, statusSimplified
				} else if(fakultas != null && kodeProdi == null && jenjang != null && ts != null && status != null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa31(fakultas, jenjang, ts, status, statusSimplified);
//				filter berdasarkan kodeProdi, jenjang, ts, status, statusSimplified
				} else if(fakultas == null && kodeProdi != null && jenjang != null && ts != null && status != null && statusSimplified != null) {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa32(kodeProdi, jenjang, ts, status, statusSimplified);
				} else {
					return (List<Mahasiswa>) this.mahasiswaDao.countMahasiswa(fakultas, kodeProdi, jenjang, ts, status, statusSimplified);
				}
			} catch(Exception e) {
				return null;
			}		
		};
		
		return RuntimeWiring.newRuntimeWiring()
				.type("Query",typeWriting -> typeWriting
						.dataFetcher("mahasiswa", fetcherMahasiswa)
						.dataFetcher("mahasiswaBaru", fetcherMahasiswaBaru)
						.dataFetcher("mahasiswaLulusan", fetcherMahasiswaLulus)
						)
				.build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response getMahasiswa(String body) throws IOException {
		loadSchema();
		ExecutionResult result = this.graphQL.execute(body);
		return Response.ok(result).build();
	}
}
