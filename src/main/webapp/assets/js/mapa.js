
function agregarPunto(left, top, href, etiqueta) {
	let un_punto_a = document.createElement("a");
	un_punto_a.setAttribute('href', href);
	un_punto_a.setAttribute('class', 'punto-rojo');
	let estilo = 'left: ' + left + '%; top: ' + top + '%;';	
	un_punto_a.setAttribute('style', estilo);
	let un_punto_img = document.createElement("img");
	un_punto_img.setAttribute('src', etiqueta)	
	un_punto_img.setAttribute('class', 'etiqueta-atraccion');
	un_punto_a.appendChild(un_punto_img);
	return un_punto_a;
}

let puntos_rojos = [];
let dir = [
        'moria.html',
        'gondor.html',
        'isengard.html',
]
let coordsX = [
        40,
        52,
        36
]
let coordsY = [
        36,
        70,
        55
]
let etiquetas = [
	'../../res/etiquetas/moria.png',
	'../../res/etiquetas/gondor.png',
	'../../res/etiquetas/isengard.png'
]
for (let i = 0; i < 3; i++) {
	puntos_rojos[i] = agregarPunto(coordsX[i], coordsY[i], dir[i], etiquetas[i]);
	document.getElementById("container-mapa").appendChild(puntos_rojos[i])
};
