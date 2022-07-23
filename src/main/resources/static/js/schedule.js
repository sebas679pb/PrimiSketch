var startTime;
var endTime;
var duration;
var stompClient;

/**
 * Funcion que renderiza el horario para que se pueda observar de manera visual
 */
function visualSchedule() {
    fetch("/api/schedules/getSubjectsByScheduleId?id=" + sessionStorage.getItem("idSchedule"), { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                data.forEach(element => {
                    var idSub = element.idSubject.idSubject
                    var memoSub = element.idSubject.memoSub;
                    var groupSub = element.idSubject.groupSub;
                    getDatesSubject(idSub,memoSub,groupSub);
                });
            } else {
                console.log("Subjects no encontrados.");
            }
        });
}

/**
 * Funcion que renderiza el horario para que se pueda observar de manera visual
 * @param {idSub} id de la materia a renderizar
 * @param {memoSub} nombre de la materia a renderizar
 * @param {groupSub} grupo de la materia a renderizar
 */
function getDatesSubject(idSub,memoSub,groupSub){
    fetch("/api/subjects/getDatesSubject?id=" + idSub, { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                data.forEach(element => {
                    var day = element.dia;
                    setTimeParams(element.startTime,element.endTime);
                    if(duration == 1){
                        var boxId = day + startTime;
                        var container = document.getElementById(boxId);
                        container.innerHTML = memoSub + " - " + groupSub;
                    }else{
                        var boxId = day + startTime;
                        var container = document.getElementById(boxId);
                        container.innerHTML = memoSub + " - " + groupSub;
                        var boxIdBlock = day + (startTime + 1);
                        var container = document.getElementById(boxIdBlock);
                        container.innerHTML = memoSub + " - " + groupSub;
                    }
                    var json = {
                        action: 1,
                        day:day,
                        startTime:startTime,
                        endTime:endTime,
                        memoSub:memoSub,
                        groupSub:groupSub,
                        duration:duration,
                        container: container
                    };
                    sincro(json);
                });
            } else {
                console.log("Horarios no encontrados.");
            }
        });
}

/**
 * Funcion para eliminar una materia del horario visualmente
 * @param {idSubject} id de la materia a eliminar
 */
function getDatesSubjectDelete(idSub) {
    fetch("/api/subjects/getDatesSubject?id=" + idSub, { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                data.forEach(element => {
                    var day = element.dia;
                    setTimeParams(element.startTime, element.endTime);
                    if (duration == 1) {
                        var boxId = day + startTime;
                        var container = document.getElementById(boxId);
                        container.innerHTML = "";
                    } else {
                        var boxId = day + startTime;
                        var container = document.getElementById(boxId);
                        container.innerHTML = "";
                        var boxIdBlock = day + (startTime + 1);
                        var container = document.getElementById(boxIdBlock);
                        container.innerHTML = "";
                    }
                    var json = {
                        action: 2,
                        day: day,
                        startTime: startTime,
                        endTime: endTime,
                        duration: duration,
                        container: container
                    };
                    sincro(json);
                });
            } else {
                console.log("Horarios no encontrados.");
            }
        });
}

/**
 * Funcion para crear un nuevo horario
 */
function newSchedule(){
    var name = document.getElementById("newSchedule").value;
    fetch("/api/schedules/newSchedule?name=" + name, { method: "POST" })
        .then((data) => { 
            if(data.status == 400){
                return null
            }else
                return data.json() } )
        .then((data) => {
            if (data != null) {
                var idSketch = data.idSchedule;
                sessionStorage.setItem("idSchedule", idSketch);
                connectUserXSchedule(idSketch);
                window.location.href = "/editSchedule.html";
            } else {
                alert("Nombre no disponible.");
            } 
        });
}

/**
 * Funcion para conectar un usuario con el horario
 * @param {idSchedule} id del horario a conectar
 */
function connectUserXSchedule(idSchedule){
    fetch("/api/schedules/newUserXSchedule?userId=" + sessionStorage.getItem("idUser") + "&scheduleId=" + idSchedule, { method: "POST" })
}

/**
 * Funcion para agregar una materia al horario
 */
function addSubjectToSketch(){
    var memo = document.getElementById("memoSubject").value;
    var group = document.getElementById("groupSubject").value;
    fetch("/api/subjects/getSubjectsByMemoGroup?memo=" + memo + "&group=" + group, { method: "POST" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                var idSubject = data.idSubject;
                var memoSubject = data.memoSub;
                var groupSubject = data.groupSub;
                fetch("/api/schedules/newScheduleXSubject?scheduleId=" + sessionStorage.getItem("idSchedule") + "&subjectId=" + idSubject, { method: "POST" })
                setTimeout(() => { getDatesSubject(idSubject, memoSubject, groupSubject) } , 1000);
            } else {
                console.log("Materia no encontrada.");
            }
        });
}

/**
 * Funcion para eliminar una materia del horario
 */
function deleteSubjectFromSketch(){
    var memo = document.getElementById("memoSubject").value;
    var group = document.getElementById("groupSubject").value;
    fetch("/api/subjects/getSubjectsByMemoGroup?memo=" + memo + "&group=" + group, { method: "POST" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                var idSubject = data.idSubject
                fetch("/api/schedules/deleteScheduleXSubject?scheduleId=" + sessionStorage.getItem("idSchedule") + "&subjectId=" + idSubject, { method: "DELETE" })
                setTimeout(() => { getDatesSubjectDelete(idSubject) }, 1000);
            } else {
                console.log("Materia no encontrada.");
            }
        });
}

/**
 * Funcion para obtener todos los usuarios del sistema
 */
function getUsers() {
    fetch("/api/users/getAllUsers", { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                var users = document.getElementById("users");
                data.forEach(element => {
                    if(element.idUser != sessionStorage.getItem("idUser")){
                        var option = document.createElement("option");
                        option.text = element.username;
                        option.value = element.username;
                        users.add(option);
                    }
                });
            } else {
                console.log("Materias no encontradas.");
            }
        });
}

/**
 * Funcion para adicionar un usuario a la edicion del horario
 */
function addMember() {
    var user = document.getElementById("users").value;
    fetch("/api/users/getUserByName?name=" + user, { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                fetch("/api/schedules/newUserXSchedule?userId=" + data.idUser + "&scheduleId=" + sessionStorage.getItem("idSchedule"), { method: "POST" })
            } else {
                console.log("Materias no encontradas.");
            }
        });
    document.getElementById("popup").style.display = "none";
}

/**
 * Funcion para eliminar un usuario de la edicion del horario
 */
function deleteMember() {
    var user = document.getElementById("users").value;
    fetch("/api/users/getUserByName?name=" + user, { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                fetch("/api/schedules/deleteUserXSchedule?userId=" + data.idUser + "&scheduleId=" + sessionStorage.getItem("idSchedule"), { method: "DELETE" })
            } else {
                console.log("Materias no encontradas.");
            }
        });
    document.getElementById("popup").style.display = "none";
}

/**
 * Funcion que settea los tiempos de una materia en el horario
 * @param {start} hora de inicio de la materia
 * @param {end} hora de fin de la materia
 */
function setTimeParams(start,end){
    // set start time
    if(start === ("7:00"))
        startTime = 1;
    else if(start === ("8:30"))
        startTime = 2;
    else if(start === ("10:00"))
        startTime = 3;
    else if (start === ("11:30"))
        startTime = 4;
    else if (start === ("13:00"))
        startTime = 5;
    else if (start === ("14:30"))
        startTime = 6;
    else if (start === ("16:00"))
        startTime = 7;
    else
        startTime = 8;
    // set end time
    if (end === ("8:30"))
        endTime = 2;
    else if (end === ("10:00"))
        endTime = 3;
    else if (end === ("11:30"))
        endTime = 4;
    else if (end === ("13:00"))
        endTime = 5;
    else if (end === ("14:30"))
        endTime = 6;
    else if (end === ("16:00"))
        endTime = 7;
    else if (end === ("17:30"))
        endTime = 8;
    else
        endTime = 9;
    // set duration
    duration = endTime - startTime;
}

// StompConfig

/**
 * Funcion que realiza el setup inicial de la conexion con el servidor
 */
function setup() {
    stomp();
    setTimeout(() => { visualSchedule() }, 1000);
    setTimeout(() => { getUsers() }, 1000);
    
}

/**
 * Funcion que realiza la sincronizacion con el servidor
 */
function sincro(json) {
    console.log(json);
    stompClient.send(
        "/topic/primiSketch" + sessionStorage.getItem("idSchedule"),
        {},
        JSON.stringify(json)
    );
}

/**
 * Funcion que ejecuta las modificaciones sobre la pagina web con respecto al servidor
 */
function stomp() {
    var socket = new SockJS("/stompEndpoint");
    stompClient = Stomp.over(socket);
    stompClient.connect({}, function (frame) {
        console.log(frame);
        stompClient.subscribe(
            "/topic/primiSketch" + sessionStorage.getItem("idSchedule"),
            function (event) {
                var json = JSON.parse(event.body);
                switch (json.action) {
                    case 1:
                        setTimeParams(json.startTime, json.endTime);
                        if (json.duration == 1) {
                            var boxId = json.day + json.startTime;
                            var container = document.getElementById(boxId);
                            container.innerHTML = json.memoSub + " - " + json.groupSub;
                        } else {
                            var boxId = json.day + json.startTime;
                            var container = document.getElementById(boxId);
                            container.innerHTML = json.memoSub + " - " + json.groupSub;
                            var boxIdBlock = json.day + (json.startTime + 1);
                            var container = document.getElementById(boxIdBlock);
                            container.innerHTML = json.memoSub + " - " + json.groupSub;
                        }
                        break;
                    case 2:
                        setTimeParams(json.startTime, json.endTime);
                        if (json.duration == 1) {
                            var boxId = json.day + json.startTime;
                            var container = document.getElementById(boxId);
                            container.innerHTML = "";
                        } else {
                            var boxId = json.day + json.startTime;
                            var container = document.getElementById(boxId);
                            container.innerHTML = "";
                            var boxIdBlock = json.day + (json.startTime + 1);
                            var container = document.getElementById(boxIdBlock);
                            container.innerHTML = "";
                        }
                        break
                    }
            }
        );
    });
}

/**
 * Funcion que intercambia mensajes con el servidor
 */
function message(json) {
    stompClient.send("/topic/primiSketch", {}, JSON.stringify(json));
}