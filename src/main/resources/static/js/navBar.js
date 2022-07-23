function logout() {
    sessionStorage.removeItem("user");
    sessionStorage.removeItem("idUser");
    window.location.href = "/";
}

function goHome() {
    window.location.href = "/home.html";
}

function goBack() {
    window.location.href = "/mySchedules.html";
}

function goToEditSchedule() {
    window.location.href = "/editSchedule.html";
}

function goToMySchedules() {
    window.location.href = "/mySchedules.html";
}

function addSubject() {
    document.getElementById("popup").style.display = "block";
    document.getElementById("addBtn").style.display = "block";
}

function deleteSubject() {
    document.getElementById("popup").style.display = "block";
    document.getElementById("deleteBtn").style.display = "block";
}

function cancel() {
    document.getElementById("popup").style.display = "none";
    document.getElementById("addBtn").style.display = "none";
    document.getElementById("deleteBtn").style.display = "none";
}