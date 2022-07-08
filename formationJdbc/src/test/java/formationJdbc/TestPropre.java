package formationJdbc;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import formationJdbc.dao.DaoDepartement;
import formationJdbc.dao.DaoDepartementFactory;
import formationJdbc.dao.DaoEmployee;
import formationJdbc.dao.DaoEmployeeFactory;
import formationJdbc.model.Departement;
import formationJdbc.model.Employee;

public class TestPropre {
	public static void main(String[] args) {

		DaoEmployee daoEmployee = DaoEmployeeFactory.getInstance();
		DaoDepartement daoDepartement = DaoDepartementFactory.getInstance();

		Employee employee = daoEmployee.findByKey(101L);
//		employee.setEmbauche(LocalDate.of(2022, 7, 8));
//		daoEmployee.update(employee);
		
		System.out.println(employee.getEmbauche());

	}
}
