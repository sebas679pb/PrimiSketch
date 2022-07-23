/**
 * Funcion que renderiza la informacion de una materia de manera visual
 */
async function getSubjectInfo(){
    var memoCard = document.getElementById("memoCard");
    var infoCard = document.getElementById("infoCard");
    var horarioCard = document.getElementById("horarioCard");
    var memo = document.getElementById("memoSubject").value;
    var group = document.getElementById("groupSubject").value;
    await fetch("/api/subjects/getSubjectsByMemoGroup?memo=" + memo + "&group=" + group, { method: "POST" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                sessionStorage.setItem("idSubject", data.idSubject);
                memoCard.innerHTML = data.memoSub;
                infoCard.innerHTML = '<li>' + data.nameSub +'</li><li> Grupo # ' + data.groupSub + '</li><li>'+ data.professor +'</li>';
            } else {
                console.log("Materia no encontrada.");
            }
        });
    
    await fetch("/api/subjects/getDatesSubject?id=" + sessionStorage.getItem("idSubject") , { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                horarioCard.innerHTML = "";
                data.forEach(element => {
                    var dia;
                    if(element.dia === ("L"))
                        dia = "Lunes";
                    else if (element.dia === ("M"))
                        dia = "Martes";
                    else if (element.dia === ("X"))
                        dia = "Miercoles";
                    else if (element.dia === ("J"))
                        dia = "Jueves";
                    else if (element.dia === ("V"))
                        dia = "Viernes";
                    else
                        dia = "Sabado";
                    horarioCard.insertAdjacentHTML('beforeend', '<li>' + dia + ' - Hora de inicio: ' + element.startTime + ' - Hora de fin: ' + element.endTime + '</li>');
                });
            } else {
                console.log("Horarios no encontrados.");
            }
        });
    document.getElementById("subjectsInfo").style.display = "block";
}

/**
 * Funcion que realiza la busque da todas las asignaturas en base de datos
 */
function getSubjects(){
    fetch("/api/subjects/getAllSubjects", { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                var memoSubs = data.filter((v, i, a) => a.findIndex(v2 => (v2.memoSub === v.memoSub)) === i);
                var subjects = document.getElementById("memoSubject");
                memoSubs.forEach(element => {
                    var option = document.createElement("option");
                    option.text = element.memoSub;
                    option.value = element.memoSub;
                    subjects.add(option);
                });
            } else {
                console.log("Materias no encontradas.");
            }
        });
}

/**
 * Funcion que realiza la busqueda de todos los grupos asociados a una materia en base de datos
 */
function getGroups(){
    var memo = document.getElementById("memoSubject").value;
    fetch("/api/subjects/getSubjectsByMemo?memo=" + memo, { method: "GET" })
        .then((data) => data.json())
        .then((data) => {
            if (data != null) {
                var groups = document.getElementById("groupSubject");
                for (let i = groups.options.length - 1;i > 0;i--){
                    groups.options[i].remove();
                }
                data.forEach(element => {
                    var option = document.createElement("option");
                    option.text = element.groupSub;
                    option.value = element.groupSub;
                    groups.add(option);
                });
            } else {
                console.log("Grupos no encontrados.");
            }
        });
}
