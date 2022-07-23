var startTime;
var endTime;
var duration;
var stompClient;

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

function connectUserXSchedule(idSchedule){
    fetch("/api/schedules/newUserXSchedule?userId=" + sessionStorage.getItem("idUser") + "&scheduleId=" + idSchedule, { method: "POST" })
}

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

// StopConfig

function setup() {
    stomp();
    setTimeout(() => { visualSchedule() }, 1000);
}

function sincro(json) {
    console.log(json);
    stompClient.send(
        "/topic/primiSketch" + sessionStorage.getItem("idSchedule"),
        {},
        JSON.stringify(json)
    );
}

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


function message(json) {
    stompClient.send("/topic/primiSketch", {}, JSON.stringify(json));
}