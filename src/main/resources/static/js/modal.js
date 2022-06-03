<!-- Только одно модальное окно.. -->

let modal = document.querySelector(".modal");
let closeButton = document.querySelector(".close-button");
let show = document.querySelector('.show')

function toggleModal() {
    modal.classList.toggle("show-modal");
}

function windowOnClick(event) {
    if (event.target === modal) {
        toggleModal();
    }
}

show.addEventListener("click", toggleModal);
closeButton.addEventListener("click", toggleModal);
window.addEventListener("click", windowOnClick);

// TODO: функция блока прокрутки при возникновении модального окна