package accesoDatos;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sun.jdi.connect.spi.Connection;

import entidades.Usuarios;

public class Dao {
	private static final String URL = "jdbc:sqlite:consultaveterinaria.sqlite3?date_string_format=yyyy-MM-dd";
	private static final String USUARIO_BDD = "";
	private static final String PASSWORD_BDD = "";

	// Buscar todos los registros de la tabla
	private static final String SQL_SELECT = "SELECT id, userName, email, password FROM usuarios";
	// Buscar UN registro por su id
	private static final String SQL_SELECT_ID = SQL_SELECT + " WHERE id=?";
	// Insertar un registro nuevo
	private static final String SQL_INSERT = "INSERT INTO usuarios (userName, email, password) VALUES (?,?)";
	// Modificar un registro cuyo id sea uno concreto
	private static final String SQL_UPDATE = "UPDATE usuarios SET userName=?, email=?, password=? WHERE id=?";
	// Borrar un registro cuyo id sea uno concreto
	private static final String SQL_DELETE = "DELETE FROM usuarios WHERE id=?";

	public static ArrayList<Usuarios> obtenerTodas() {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT);
				ResultSet rs = ps.executeQuery()) {
			ArrayList<Usuarios> usuarios = new ArrayList<>();

			while (rs.next()) {
				usuarios.add(new Usuarios(rs.getInt("id"), rs.getString("userName"),
						rs.getString("email"),rs.getString("password")));
			}

			return usuarios;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener todos los registros", e);
		}
	}
	
	public static Usuarios obtenerPorId(Integer id) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement(SQL_SELECT_ID);
				) {
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			Usuarios usuarios = null;

			if (rs.next()) {
				usuarios.add(new Usuarios(rs.getInt("id"), rs.getString("userName"),
						rs.getString("email"),rs.getString("password")));
			}

			return mascota;
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido obtener el registro con id " + id, e);
		}
	}
	
	public static void insertar(Usuarios usuario) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT);
				) {
			ps.setString(1, usuario.getUserName());
			ps.setObject(2, usuario.getEmail());
			ps.setObject(2, usuario.getPassword());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido insertar el registro " + usuario, e);
		}
	}
	
	public static void modificar(Usuarios usuario) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement(SQL_UPDATE);
				) {
			ps.setString(1, usuario.getUserName());
			ps.setString(2, usuario.getEmail());
			ps.setString(3, usuario.getPassword());

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido modificar el registro " + usuario, e);
		}
	}
	
	public static void borrar(Integer id) {
		try (Connection con = obtenerConexion();
				PreparedStatement ps = con.prepareStatement(SQL_DELETE);
				) {
			ps.setInt(1, id);

			ps.executeUpdate();
		} catch (SQLException e) {
			throw new AccesoDatosException("No se han podido borrar el registro id " + id, e);
		}
	}

	private static Connection obtenerConexion() throws AccesoDatosException {
		try {
			return (Connection) DriverManager.getConnection(URL, USUARIO_BDD, PASSWORD_BDD);
		} catch (SQLException e) {
			throw new AccesoDatosException("Ha habido un error al conectar a la base de datos", e);
		}
	}
}
