/**
 * Funcion para cerrar la sesion del usurio
 */
function logout() {
    sessionStorage.removeItem("user");
    sessionStorage.removeItem("idUser");
    window.location.href = "/";
}

/**
 * Funcion de redirecion hacia home
 */
function goHome() {
    window.location.href = "/home.html";
}

/**
 * Funcion de redireccion hacia mySchedules
 */
function goBack() {
    window.location.href = "/mySchedules.html";
}

/**
 * Funcion de redireccion hacia la pagina de edicion de horarios
 */
function goToEditSchedule() {
    window.location.href = "/editSchedule.html";
}

/**
 * Funcion de redireccion hacia los horarios del usuario
 */
function goToMySchedules() {
    window.location.href = "/mySchedules.html";
}

/**
 * Funcion que modifica las propiedades de los elementos dados
 */
function addSubject() {
    document.getElementById("popup").style.display = "block";
    document.getElementById("addBtn").style.display = "block";
}

/**
 * Funcion que modifica las propiedades de los elementos dados
 */
function deleteSubject() {
    document.getElementById("popup").style.display = "block";
    document.getElementById("deleteBtn").style.display = "block";
}

/**
 * Funcion que modifica las propiedades de los elementos dados
 */
function cancel() {
    document.getElementById("popup").style.display = "none";
    document.getElementById("addBtn").style.display = "none";
    document.getElementById("deleteBtn").style.display = "none";
}

/**
 * Funcion que modifica las propiedades de los elementos dados
 */
function popupMembersCancel() {
    document.getElementById("popup").style.display = "none";
}

/**
 * Funcion que modifica las propiedades de los elementos dados
 */
function popupEditMembers() {
    document.getElementById("popup").style.display = "block";
}