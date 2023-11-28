package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
	private String driver = "org.postgresql.Driver";
	private String url = "jdbc:postgresql://localhost:5432/dbagenda";
	private String user = "postgres";
	private String passaword = "008830";

	private Connection conectar() {
		Connection con = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, passaword);
			return con;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void inserirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,fone,email)values (?,?,?)";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());

			pst.executeUpdate();
			
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}	
	}
	public ArrayList<JavaBeans> listarContatos(){
		ArrayList<JavaBeans> contatos = new ArrayList<>();
	String read = "select * from contatos order by nome";
	try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(read);
		ResultSet rs = pst.executeQuery();
		
		while(rs.next()) {
			String id = rs.getString(1);
			String nome = rs.getString(2);
			String fone = rs.getString(3);
			String email = rs.getString(4);
			
			contatos.add(new JavaBeans(id,nome,fone,email));
		}
		con.close();
		return contatos;
	} catch (Exception e) {
		System.out.println(e);
		return null;
	}
	}
public void selecionarContato(JavaBeans contato) {
	String read2 = "select * from contatos where Id = ?";
	try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(read2);
		 pst.setInt(1, Integer.parseInt(contato.getId()));
		ResultSet rs = pst.executeQuery();
		while (rs.next()) {
			contato.setId(rs.getString(1));
			contato.setNome(rs.getString(2));
			contato.setFone(rs.getString(3));
			contato.setEmail(rs.getString(4));
		}
		con.close();
	} catch (Exception e) {
		System.out.println(e);
	}
}
public void alterarContato(JavaBeans contato ) {
	String create = "update contatos set nome=?,fone=?,email=? where id=?";
	try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(create);
		pst.setString(1,contato.getNome());
		pst.setString(2,contato.getFone());
		pst.setString(3,contato.getEmail());
		pst.setInt(4, Integer.parseInt(contato.getId()));
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
}
public void deletarContato(JavaBeans contato) {
	String delete="delete from contatos where id=?";
	try {
		Connection con = conectar();
		PreparedStatement pst = con.prepareStatement(delete);
		pst.setInt(1, Integer.parseInt(contato.getId()));
		pst.executeUpdate();
		con.close();
		
	} catch (Exception e) {
		System.out.println(e);
	}
}
}