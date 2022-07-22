var startTime;
var endTime;
var duration;

function visualSchedule() {
    fetch("/api/schedules/getSubjectsByScheduleId?id=" + sessionStorage.getItem("idSchedule"), { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                data.forEach(element => {
                    var idSub = element.idSubject.idSubject
                    var memoSub = element.idSubject.memoSub;
                    getDatesSubject(idSub,memoSub);
                });
            } else {
                console.log("Subjects no encontrados.");
            }
        });
}

function getDatesSubject(idSub,memoSub){
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
                        container.innerHTML = memoSub;
                    }else{
                        var boxId = day + startTime;
                        var container = document.getElementById(boxId);
                        container.innerHTML = memoSub;
                        var boxIdBlock = day + (startTime + 1);
                        var container = document.getElementById(boxIdBlock);
                        container.innerHTML = memoSub;
                    }
                });
            } else {
                console.log("Horarios no encontrados.");
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