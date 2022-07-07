package formationJdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import formationJdbc.model.Departement;
import formationJdbc.util.Context;

class DaoDepartementJdbcImpl implements DaoDepartement {

	@Override
	public void insert(Departement obj) {
		try {
			PreparedStatement ps = Context.getInstance().getConnection().prepareStatement(
					"insert into departments(department_id,department_name) values(nextval('seq_departments'),?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getNom());
			ps.executeUpdate();
			ResultSet rs = ps.getGeneratedKeys();
			if (rs.next()) {
				obj.setId(rs.getLong(1));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.close();
	}

	@Override
	public Departement update(Departement obj) {
		try {
			PreparedStatement ps = Context.getInstance().getConnection()
					.prepareStatement("update departments set department_name=? where department_id=?");
			ps.setString(1, obj.getNom());
			ps.setLong(2, obj.getId());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.close();
		return obj;
	}

	@Override
	public void delete(Departement obj) {
		deleteByKey(obj.getId());
	}

	@Override
	public void deleteByKey(Long key) {
		try {
			PreparedStatement ps = Context.getInstance().getConnection()
					.prepareStatement("delete from departments where department_id=?");
			ps.setLong(1, key);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.close();

	}

	@Override
	public Departement findByKey(Long key) {
		Departement departement = null;
		try {
			PreparedStatement ps = Context.getInstance().getConnection()
					.prepareStatement("select * from departments where department_id=?");
			ps.setLong(1, key);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				departement = new Departement(rs.getLong("department_id"), rs.getString("department_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.close();
		return departement;
	}

	@Override
	public List<Departement> findAll() {
		List<Departement> list = new ArrayList<Departement>();
		try {
			Statement st = Context.getInstance().getConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from departments");
			while (rs.next()) {
				list.add(new Departement(rs.getLong("department_id"), rs.getString("department_name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.close();
		return list;
	}

}
