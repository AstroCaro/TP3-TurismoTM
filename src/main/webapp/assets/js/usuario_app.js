const items = document.querySelectorAll(".nav-items-derecha a");
const html = document.querySelector("html");
const menu_usuario = document.querySelector(".menu-usuario");
const profile = document.querySelector(".profile");

function activaritem() {

	this.classList.toggle("active");
}
items.forEach(item => item.addEventListener("click", activaritem));

profile.addEventListener("click", () => {
	menu_usuario.classList.toggle("mostrar-menu-usuario");
});

