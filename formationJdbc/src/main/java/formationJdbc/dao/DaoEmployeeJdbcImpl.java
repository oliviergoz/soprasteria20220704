package formationJdbc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import formationJdbc.model.Employee;
import formationJdbc.util.Context;

class DaoEmployeeJdbcImpl implements DaoEmployee {

	@Override
	public void insert(Employee obj) {
		try {
			PreparedStatement ps = Context.getInstance().getConnection().prepareStatement(
					"insert into employees(employee_id,last_name) values(nextval('seq_employee'),?)",
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
	public Employee update(Employee obj) {
		try {
			PreparedStatement ps = Context.getInstance().getConnection()
					.prepareStatement("update employees set last_name=? where employee_id=?");
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
	public void delete(Employee obj) {
		deleteByKey(obj.getId());

	}

	@Override
	public void deleteByKey(Long key) {
		try {
			PreparedStatement ps = Context.getInstance().getConnection()
					.prepareStatement("delete from employees where employee_id=?");
			ps.setLong(1, key);
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.close();

	}

	@Override
	public Employee findByKey(Long key) {
		Employee employee = null;
		try {
			PreparedStatement ps = Context.getInstance().getConnection()
					.prepareStatement("select * from employees where employee_id=?");
			ps.setLong(1, key);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee = new Employee(rs.getLong("employee_id"), rs.getString("last_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.close();
		return employee;
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			Statement st = Context.getInstance().getConnection().createStatement();
			ResultSet rs = st.executeQuery("select * from employees");
			while (rs.next()) {
				list.add(new Employee(rs.getLong("employee_id"), rs.getString("last_name")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.close();
		return list;
	}

}
