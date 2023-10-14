function initializeLogoutTimer() {

    if (sessionStorage.getItem('userLoggedIn') === 'true') {

        setTimeout(function() {
            logout();
        }, 30000);
    }
}

function logout() {

    sessionStorage.removeItem('userLoggedIn');

    window.location.href = 'login.html';
}
