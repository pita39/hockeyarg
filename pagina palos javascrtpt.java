// Variables para el carrito de compras
let cart = [];
let total = 0;

// Añadir producto al carrito
function addToCart(product, price) {
    cart.push({ product, price });
    total += price;
    document.getElementById("cart-count").innerText = cart.length;
    updateCart();
}

// Actualizar vista del carrito
function updateCart() {
    const cartItems = document.getElementById("cart-items");
    cartItems.innerHTML = "";
    cart.forEach(item => {
        const cartItem = document.createElement("div");
        cartItem.innerText = `${item.product} - $${item.price}`;
        cartItems.appendChild(cartItem);
    });
    document.getElementById("total").innerText = total;
}

// Finalizar compra
function checkout() {
    alert(`Compra finalizada. Total a pagar: $${total} ARS`);
    cart = [];
    total = 0;
    document.getElementById("cart-count").innerText = 0;
    updateCart();
}

// Lógica del carrusel de productos
let currentIndex = 0;
const items = document.querySelectorAll('.carousel-item');
document.querySelector('.next').addEventListener('click', () => {
    currentIndex = (currentIndex + 1) % items.length;
    items.forEach((item, index) => {
        item.style.transform = `translateX(${(index - currentIndex) * 100}%)`;
    });
});

document.querySelector('.prev').addEventListener('click', () => {
    currentIndex = (currentIndex - 1 + items.length) % items.length;
    items.forEach((item, index) => {
        item.style.transform = `translateX(${(index - currentIndex) * 100}%)`;
    });
});
