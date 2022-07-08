package formationJdbc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import formationJdbc.model.Departement;
import formationJdbc.model.Employee;
import formationJdbc.util.Context;

class DaoEmployeeJdbcImpl implements DaoEmployee {

	@Override
	public void insert(Employee obj) {
		try {
			PreparedStatement ps = Context.getInstance().getConnection().prepareStatement(
					"insert into employees(employee_id,last_name,department_id,hire_date) values(nextval('seq_employee'),?,?,?)",
					Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, obj.getNom());
			if (obj.getDepartement() != null) {
				ps.setLong(2, obj.getDepartement().getId());
			} else {
				ps.setNull(2, Types.BIGINT);
			}
			if (obj.getEmbauche() != null) {
				ps.setDate(3, Date.valueOf(obj.getEmbauche()));
			} else {
				ps.setNull(3, Types.DATE);
			}
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
			PreparedStatement ps = Context.getInstance().getConnection().prepareStatement(
					"update employees set last_name=?,department_id=?,hire_date=? where employee_id=?");
			ps.setString(1, obj.getNom());
			if (obj.getDepartement() != null) {
				ps.setLong(2, obj.getDepartement().getId());
			} else {
				ps.setNull(2, Types.BIGINT);
			}
			if (obj.getEmbauche() != null) {
				ps.setDate(3, Date.valueOf(obj.getEmbauche()));
			} else {
				ps.setNull(3, Types.DATE);
			}
			ps.setLong(4, obj.getId());
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
			// @formatter:off
			PreparedStatement ps = Context.getInstance().getConnection().prepareStatement(
					"select e.employee_id,e.last_name,e.department_id,e.hire_date,d.department_name "
					+ "from employees e "
					+ "left join departments d "
					+ "on e.department_id=d.department_id "
					+ "where e.employee_id=?");
			// @formatter:on
			ps.setLong(1, key);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				employee = new Employee(rs.getLong("employee_id"), rs.getString("last_name"));
				if (rs.getDate("hire_date") != null) {
					employee.setEmbauche(rs.getDate("hire_date").toLocalDate());
				}
				if (rs.getLong("department_id") != 0) {
					Departement d = new Departement(rs.getLong("department_id"), rs.getString("department_name"));
					employee.setDepartement(d);
				}
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
			// @formatter:off
			ResultSet rs = st.executeQuery(
					"select e.employee_id,e.last_name,e.department_id,d.department_name,e.hire_date "
					+ "from employees e "
					+ "left join departments d "
					+ "on e.department_id=d.department_id ");
			// @formatter:on
			Employee employee = null;
			while (rs.next()) {
				employee = new Employee(rs.getLong("employee_id"), rs.getString("last_name"));
				if (rs.getDate("hire_date") != null) {
					employee.setEmbauche(rs.getDate("hire_date").toLocalDate());
				}
				if (rs.getLong("department_id") != 0) {
					Departement d = new Departement(rs.getLong("department_id"), rs.getString("department_name"));
					employee.setDepartement(d);
				}
				list.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Context.close();
		return list;
	}

}
