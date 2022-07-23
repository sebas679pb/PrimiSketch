/**
 * Funcion que trae los horarios del usuario y los muestra en la pagina web
 */
function getSchedules() {
    var userSchedules = document.getElementById("schedules");
    fetch("/api/schedules/getGroupByUserId?id=" + sessionStorage.getItem("idUser"), { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                data.forEach(element => {
                    userSchedules.insertAdjacentHTML('beforeend', '<div class="card" onclick="getSchedule(' + element.idSchedule.idSchedule +')"><div class="card_image"> <img src="imgs/primiSiri.gif" /> </div><div class="card_title"><p>' + element.idSchedule.nombre + '</p></div></div>');
                });
            } else {
                console.log("Horarios no encontrados.");
            }
        });
}

/**
 * Almacena de manera temporal el identificador del usuario
 * @param {idSchedule} idSchedule
 */
function getSchedule(idSchedule) {
    sessionStorage.setItem("idSchedule", idSchedule);
    window.location.href = "/schedule.html";
}
