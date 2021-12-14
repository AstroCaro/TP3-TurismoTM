const Moria = {
    id: 1,
    nombre: "Moria",
    coordX: 39,
    coordY: 35
};
const Bosque_Negro = {
    id: 2,
    nombre: "Bosque Negro",
    coordX: 39,
    coordY: 28
};
const Mordor = {
    id: 3,
    nombre: "Mordor",
    coordX: 56,
    coordY: 69
};
const Gondor = {
    id: 4,
    nombre: "Gondor",
    coordX: 48,
    coordY: 69
};
const Prancing_Pony = {
    id: 5,
    nombre: "Prancing Pony",
    coordX: 12,
    coordY: 25
};
const La_Comarca = {
    id: 6,
    nombre: "La Comarca",
    coordX: 9,
    coordY: 28
};
const Lothlorien = {
    id: 7,
    nombre: "Lothlorien",
    coordX: 35,
    coordY: 37
};
const Isengard = {
    id: 8,
    nombre: "Isengard",
    coordX: 30,
    coordY: 53
};
const Abismo_de_Helm = {
    id: 9,
    nombre: "Abismo de Helm",
    coordX: 22,
    coordY: 56
};
const Erebor = {
    id: 10,
    nombre: "Erebor",
    coordX: 55,
    coordY: 15
};
const Minas_Tirith = {
    id: 11,
    nombre: "Minas Tirith",
    coordX: 41,
    coordY: 65
};
const Rivendel = {
    id: 12,
    nombre: "Rivendel",
    coordX: 34,
    coordY: 24
};

const atraccionesObj = [Moria, Bosque_Negro, Mordor, Gondor, Prancing_Pony, La_Comarca, Lothlorien, Isengard, Abismo_de_Helm, Erebor, Minas_Tirith, Rivendel];

function removerPunto(){
    punto = document.getElementsByClassName("punto-rojo")[0]
    punto.remove()
}

function crearPunto(left, top, href, etiqueta) {
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
function agregarPunto(pos){
    var left = atraccionesObj[pos].coordX;
    var top = atraccionesObj[pos].coordY;
    var href = '/TurismoTMTP3/atracciones/verAtraccion.do?id_atraccion=' + atraccionesObj[pos].id;
    var etiqueta = 'assets/img/etiquetas/' + atraccionesObj[pos].nombre +'.png';

    var punto_rojo = crearPunto(left, top, href, etiqueta);
	document.getElementById("container-mapa").appendChild(punto_rojo)
}


var carruselAtracciones = document.getElementById('carruselAtracciones');

carruselAtracciones.addEventListener('slid.bs.carousel', function (event) {
    removerPunto();
    var innerTexto = document.getElementsByClassName('carousel-item active')[0].getElementsByTagName("H5")[0].innerText;
    var posicion = atraccionesObj.findIndex(x => x.nombre == innerTexto);
    agregarPunto(posicion);
});
