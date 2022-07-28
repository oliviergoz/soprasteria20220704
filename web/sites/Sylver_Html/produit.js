let table = document.createElement('table');
let thead = document.createElement('thead');
let tbody = document.createElement('tbody');

table.appendChild(thead);
table.appendChild(tbody);

// Adding the entire table to the body tag
document.getElementById('body').appendChild(table);
let row_1 = document.createElement('tr');
let heading_1 = document.createElement('th');
heading_1.innerHTML = "Nom";
let heading_2= document.createElement('th');
heading_2.innerHTML = "Prix(Euros)";

row_1.appendChild(heading_1);
row_1.appendChild(heading_2);
thead.appendChild(row_1);


// Creating and adding data to second row of the table
let row_2 = document.createElement('tr');
let row_2_data_1 = document.createElement('td');
row_2_data_1.innerHTML = "PC";
let row_2_data_2 = document.createElement('td');
row_2_data_2.innerHTML = "250";
row_2.appendChild(row_2_data_1);
row_2.appendChild(row_2_data_2);
tbody.appendChild(row_2);


// Creating and adding data to third row of the table
let row_3 = document.createElement('tr');
let row_3_data_1 = document.createElement('td');
row_3_data_1.innerHTML = "Smart TV";
let row_3_data_2 = document.createElement('td');
row_3_data_2.innerHTML = "800";

row_3.appendChild(row_3_data_1);
row_3.appendChild(row_3_data_2);
tbody.appendChild(row_3);

function Prix(){
NomP = document.getElementById("name").value;
PrixP = document.getElementById("price").value;
alert(NomP);
alert(PrixP);
}

	
	


