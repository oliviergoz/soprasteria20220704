
function CreateBtn(){
	let alphabet =['a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'];
for(let i=0;i<26;i++){
	let btn1 =document.createElement("button");
btn1.innerHTML = alphabet[i];
btn1.id=alphabet[i];
btn1.addEventListener('click', (event) => {
		console.log(event);
		})
		 document.body.append(btn1);
 }
 
 }
 function essai(btn1){	
	let MotsAtrouver=['amour','malediction','chance','foret','sang','bateau']
let MotSecret = MotsAtrouver[Math.floor(Math.random()*MotsAtrouver.length)];
console.log(MotSecret)

 for(let i=0;i<MotSecret.length;i++){
	  let btn2 =document.createElement("input");
	  btn2.setAttribute("type", "text",);
	  btn2.setAttribute("size", "1px",);
btn2.id=i;
btn2.addEventListener('click', (event) => {
		console.log(event);
		})
		 document.body.append(btn2);
	  
}
	
		
}
