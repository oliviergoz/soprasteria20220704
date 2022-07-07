package formationJdbc;

import formationJdbc.dao.DaoEmployee;
import formationJdbc.dao.DaoEmployeeFactory;
import formationJdbc.model.Employee;

public class TestPropre {
	public static void main(String[] args) {

		DaoEmployee daoEmployee = DaoEmployeeFactory.getInstance();
		Employee emp = null;
//		 emp=new Employee();
//		emp.setNom("test dao2");
//		System.out.println(emp.getId());
//		daoEmployee.insert(emp);
//		
//		System.out.println(emp.getId());
//		
		emp = daoEmployee.findByKey(109L);
		System.out.println(emp.getId());
//		//new DaoEmployeeJdbcImpl(); plus visible
//		daoEmployee.findAll().forEach(e -> {
//			System.out.println(e.getId() + " " + e.getNom());
//		});

	}
}
