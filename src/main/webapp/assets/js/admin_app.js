const menu = document.querySelector(".menu");
const buscador = document.querySelector(".buscador");
const menu_links = document.querySelectorAll(".menu-links a");
const active_tab = document.querySelector(".active-tab");
const elementos_tooltip = document.querySelectorAll(".elemento-tooltip");

const menu_usuario = document.querySelector(".menu-usuario");
const profile = document.querySelector(".profile");

let indiceActivo;

menu.addEventListener("click", () => {
    document.body.classList.toggle("menu-comprimido");
});

buscador.addEventListener("click", () => {
    document.body.classList.remove("menu-comprimido");
    buscador.lastElementChild.focus();
});

function moveActiveTab() {
    let topPosition = indiceActivo * 58 + 2.5;
    active_tab.style.top = `${topPosition}px`;
}

function cambiarLink() {
    menu_links.forEach(link => link.classList.remove("active"));
    this.classList.add("active");

    indiceActivo = this.dataset.active;
    moveActiveTab();
}

menu_links.forEach(link => link.addEventListener("click", cambiarLink));

function showTooltip() {
    let tooltip = this.parentNode.lastElementChild;
    let spans = tooltip.children;
    let indiceTooltip = this.dataset.tooltip;

    Array.from(spans).forEach(sp => sp.classList.remove("mostrar"));
    spans[indiceTooltip].classList.add("mostrar");

    tooltip.style.top = `${(100 / (spans.length*2)) *(indiceTooltip*2 + 1)}%`;
}


elementos_tooltip.forEach(el => {
    el.addEventListener("mouseover", showTooltip);
});

profile.addEventListener("click", () => {
    menu_usuario.classList.toggle("mostrar-menu-usuario");
});