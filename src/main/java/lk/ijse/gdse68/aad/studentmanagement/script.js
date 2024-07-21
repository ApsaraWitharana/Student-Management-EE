function saveStudentData() {
    const id = document.getElementById('id').value;
    const name = document.getElementById('name').value;
    const email = document.getElementById('email').value;
    const city = document.getElementById('city').value;
    const level = document.getElementById('level').value;

    // Print the data to the console
    console.log(`ID: ${id}, Name: ${name}, Email: ${email}, City: ${city}, Level: ${level}`);

    const table = document.getElementById('studentTable').getElementsByTagName('tbody')[0];
    const newRow = table.insertRow();

    const cell1 = newRow.insertCell(0);
    const cell2 = newRow.insertCell(1);
    const cell3 = newRow.insertCell(2);
    const cell4 = newRow.insertCell(3);
    const cell5 = newRow.insertCell(4);

    cell1.textContent = id;
    cell2.textContent = name;
    cell3.textContent = email;
    cell4.textContent = city;
    cell5.textContent = level;

    // Reset the form
    document.getElementById('studentForm').reset();

    // create object
    const studentData ={
        name:name,
        email:email,
        city:city,
        level:level
    };
    console.log(studentData)

    //create json
    const studentJSON = JSON.stringify(studentData)
    console.log(studentJSON)

    //Introduce AJAX
    //get value,create object ,converting json object,send object
    // request ekk steps :
    //01.create ajax object - page ek refrash novi data tik geniynne //coll back function - feadeback ekk gnn
    //02.implement arrow function
    //03.open req -pass the method (yawann ona monawada postd,puts,getd)//("http method ek"," ywann ona location ek url",true-assintonized sinconized d true danne AJAX widiyt wada krnn)
    //04.create content tipe header //
    //05.send object

    const http = new XMLHttpRequest() //01
    http.onreadystatechange = ()=>{ // coll back funshion => ready state ek chak krnn use wenne req ekt dunn resp ek mokkd kiyl blagnn //parameter ekk widiyt data tranceper krnwa (promise method  ekk tiye)
        //AJAX - ready state ek athulen blnn puluwan eke swabawaya step 5k wenkm ynwa (0-4) //AJAX KIYNNE=> Acetonice and java xml
        // page ek refresh nokara client ta eyage user experience ek awlk nowi data transper krgnn AJAX use krnne
        // Holds the status of the XMLHttpRequest.
        // 0: request not initialized - open method not in working //un authorise
        // 1: server connection established - coll the open method and initialized
        // 2: request received - send the req to server // the req wen to sever and get the data //header ek read krl dataa gnn puluwan// paylord eke data tik send wela
        // 3: processing request - req processing but not given complete request property to responseText
        // 4: request finished and response is ready - ready server to get resp
        // we are checking statement 4 because we can get the result to statement 4
        //readystate => req ek t mokd une rsp ekkk awad kiyl dn gnn
        // status
        // 200: "OK"
        // 403: "Forbidden"
        // 404: "Page not found"
        // For a complete list go to the Http Messages Reference

        if (http.readyState == 4){
            if (http.status == 200){
               // property godak tiyenwa api dunn req ekt mokd une kiyl blnn resp ek kohomd blnna
              var responseTextJSON = JSON.stringify( http.responseText) //responce ek gnnwa stringifymethod ek use krgnnwa java EE wal krpu ek wage jason krn ek //stringifymethod => awa resp ek jason ekkt convert krla gnn ek
                console.log(responseTextJSON)
            }else {
                console.error("Failed to statement") // resp ekt mokkhri unot ek balagnn
                console.error("Status" + http.status)
                console.error("Ready State" + http.readyState)
            }

        }else {
            console.error("Ready State" + http.readyState)

        }
    } //02
    http.open("POST","http://localhost:8080/StudentManagement/student",true) //03 true unot withryi refresh nowi ynne assintonice (url ekyi assintonix d sintonix d kiyl)
    http.setRequestHeader("Content-Type","application/json") //04 Header- adishanal information ekk ywanne header walin === payload eke ewnne jason data ekk kiyl== denne
    http.send(studentJSON) // empty body to coll GET method //05 //jason object ek yawanawa


    // CORS policy - domain dekk athule data shar kragnn giyam enne domain dekk athara data shar krnn be
    // 01 firstly sent option - http method ekk
    //02 send post method -
    //alove krnn ona 4n 1 yi krl tiyenne ehinda tamayi erro enne
    // CORS policy  - implement krnn ona backend eken
    // this request - pre-flight req // add two part

    //Preflight request:
    // A CORS preflight request is a CORS request that checks to see if the CORS protocol is understood and a server is aware using specific methods and headers.
    // It is an OPTIONS request, using two or three HTTP request headers: Access-Control-Request-Method, Origin, and optionally Access-Control-Request-Headers.
    // A preflight request is automatically issued by a browser and in normal cases, front-end developers don't need to craft such requests themselves. It appears when request is qualified as "to be preflighted" and omitted for simple requests.
    // For example, a client might be asking a server if it would allow a DELETE request, before sending a DELETE request, by using a preflight request:
}
