const reg = document.querySelector('.registration__enter')
const content = document.querySelector('.popup__content')
const popup = document.querySelector('.popup__registration')
const popupBody = document.querySelector('.popup__body')
const login = document.querySelector('.account__login')

login.onclick = () => {
    popup.classList.toggle('popup__active')
    content.classList.toggle('popup__active')
}

reg.onclick = () => {
    popup.classList.toggle('popup__active')
    content.classList.toggle('popup__active')
}

window.onkeydown = function( event ) {
    if ( event.keyCode == 27 ) {
        popup.classList.remove('popup__active')
        content.classList.remove('popup__active')
    }
};

popup.onclick = () => {
    popup.classList.remove('popup__active')
    content.classList.remove('popup__active')
}