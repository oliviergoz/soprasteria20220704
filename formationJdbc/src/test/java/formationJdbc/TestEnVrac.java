package formationJdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestEnVrac {
	public static void main(String[] args) {

		// Definition de l'implementation du JDBC a utiliser
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			// Connexion à la base=>Factory
			Connection connection = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/hr", "postgres",
					"postgres");

			// execution de requete
			Statement st = connection.createStatement();
			// ResultSet st.executeQuery(String requete) pour requete select
			// int st.executeUpdate(String requete) pour requete insert,update,delete
			// retour nombre de ligne modifiees

			String nom = "');delete from employees;('";
			PreparedStatement ps=connection.prepareStatement("insert into employees(employee_id,last_name) values(nextval('seq_employee'),? )");
			ps.setString(1, nom);
			ps.executeUpdate();
			//st.executeUpdate(
			//		"insert into employees(employee_id,last_name) values(nextval('seq_employee'),'" + nom + "')");
			// jamais sinon injection SQL
			
			
			ResultSet rs = st.executeQuery("select * from employees order by employee_id");
			while (rs.next()) {
				System.out.println(rs.getInt("employee_id") + " " + rs.getString("last_name"));
			}

			// fermeture de la connexion à faire des que possible
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}
