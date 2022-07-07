package formationJdbc;

import formationJdbc.dao.DaoDepartement;
import formationJdbc.dao.DaoDepartementFactory;
import formationJdbc.dao.DaoEmployee;
import formationJdbc.dao.DaoEmployeeFactory;
import formationJdbc.model.Departement;
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

		DaoDepartement daoDepartement = DaoDepartementFactory.getInstance();

		// daoDepartement.insert(new Departement("aaa"));
		// daoDepartement.deleteByKey(50L);
		daoDepartement.findAll().forEach(d -> {
			System.out.println(d.getId() + " " + d.getNom());
		});
		
		
		System.out.println(daoDepartement.findAll());

	}
}
