<!-- Это надо переписать -->

let modal1 = document.getElementById("modal-1");
let modal2 = document.getElementById("modal-2");
let closeButton1 = document.getElementById("close-1");
let closeButton2 = document.getElementById("close-2");
let show1 = document.getElementById('button-1')
let show2 = document.getElementById('button-2')

function toggleModal(event) {
    if (event.target === show1) { modal1.classList.toggle("show-modal");
        document.body.style.display = 'fixed'; document.body.style.overflow = 'hidden'; }
    if (event.target === show2) { modal2.classList.toggle("show-modal");
        document.body.style.display = 'fixed'; document.body.style.overflow = 'hidden';}
}

function closeModal(event) {
    if (event.target !== modal1) { modal1.classList.remove("show-modal");
        document.body.style.position = ''; document.body.style.display = ''; document.body.style.overflow = ''; }
    if (event.target !== modal2) { modal2.classList.remove("show-modal");
        document.body.style.position = ''; document.body.style.display = ''; document.body.style.overflow = '';}
}

show1.addEventListener("click", toggleModal);
show2.addEventListener("click", toggleModal);
closeButton1.addEventListener("click", closeModal);
closeButton2.addEventListener("click", closeModal);