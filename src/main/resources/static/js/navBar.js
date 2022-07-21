function logout() {
    sessionStorage.removeItem("user");
    sessionStorage.removeItem("idUser");
    window.location.href = "/";
}

function goHome() {
    window.location.href = "/home.html";
}

function goBack(){
    window.location.href = "/mySchedules.html";
}
