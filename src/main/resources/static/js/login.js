function login() {
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    fetch("/api/users/login?name=" + username + "&password=" + password, { method: "POST" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                sessionStorage.setItem("user", data.username);
                sessionStorage.setItem("idUser", data.idUser);
                window.location.href = "/home.html";
            } else {
                alert("Credenciales no validas.");
                window.location.href = "/";
            }
        });
}
