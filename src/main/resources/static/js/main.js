// popup

const login = document.querySelector('.account__login')
const content = document.querySelector('.popup__content')
const popup = document.querySelector('.popup__registration')
const popupBody = document.querySelector('.popup__body')

login.onclick = () => {
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

//login

const loginForm = document.querySelector('#formLogin')
const loginVal = document.querySelector('#login').value
const passVal = document.querySelector('#pass').value
const host = "http://178.250.246.214"

loginForm.addEventListener('submit', async (e)=> {
    e.preventDefault();
    
    const logData = {
        login: loginVal,
        pass: passVal
    };

    const responseOptions = {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(logData)
    }
    

   fetch(`${host}/api/v1/auth/authenticate`, responseOptions)
    .then(response => response.json())
    .then(console.log(response))
})