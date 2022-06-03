<!-- Это надо переписать -->

let modal1 = document.getElementById("modal-1");
let modal2 = document.getElementById("modal-2");
let closeButton1 = document.getElementById("close-1");
let closeButton2 = document.getElementById("close-2");
let show1 = document.getElementById('button-1')
let show2 = document.getElementById('button-2')

function toggleModal(event) {
    if (event.target === show1) { modal1.classList.toggle("show-modal"); }
    if (event.target === show2) { modal2.classList.toggle("show-modal"); }
}

function closeModal(event) {
    if (event.target !== modal1) { modal1.classList.remove("show-modal");
        document.body.style.position = '';}
    if (event.target !== modal2) { modal2.classList.remove("show-modal"); }
}

show1.addEventListener("click", toggleModal);
show2.addEventListener("click", toggleModal);
closeButton1.addEventListener("click", closeModal);
closeButton2.addEventListener("click", closeModal);

// TODO: функция блока прокрутки при возникновении модального окна