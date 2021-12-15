const items = document.querySelectorAll(".nav-items-derecha .nav-item> a");
const html = document.querySelector("html");
const menu_usuario = document.querySelector(".menu-usuario");
const itinerario = document.querySelector(".itinerario");
const profile = document.querySelector(".profile");
const mapa = document.querySelector(".mapa");

function activaritem() {

	this.classList.toggle("active");
}
items.forEach(item => item.addEventListener("click", activaritem));

profile.addEventListener("click", () => {
	menu_usuario.classList.toggle("mostrar-menu-usuario");
});

mapa.addEventListener("click", () => {
	itinerario.classList.toggle("mostrar-itinerario");
});
