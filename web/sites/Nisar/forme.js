selectBox = document.getElementById('shape');
selectBox2 = document.getElementById('shape2');
img = document.getElementById('img');
img2 = document.getElementById('img2');
const shapeArray = ['carre.gif','cercle.gif','parallelo.gif','rectangle.gif','trapeze.gif','triangle.gif'];

console.log(shapeArray[selectBox.value])

function shapeSelect(){
    img2.setAttribute('src',''+shapeArray[selectBox.value]+'')
}

function shapeSelectArray(){
    img.setAttribute('src',''+shapeArray[selectBox.value]+'')
}