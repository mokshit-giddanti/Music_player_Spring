function initializeLogoutTimer() {
    // Check if the user is logged in
    if (sessionStorage.getItem('userLoggedIn') === 'true') {
        // Set a timeout to automatically log out after 5 minutes (300,000 milliseconds)
        setTimeout(function() {
            logout();
        }, 60000);
    }
}

function logout() {
    // Clear the user's login status
    sessionStorage.removeItem('userLoggedIn');
    // Redirect to the login page
    window.location.href = 'login.html';
}
