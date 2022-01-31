let usernameBox = document.getElementById("username");
let passwordBox = document.getElementById("password");
let loginBtn = document.getElementById("loginBtn");
let login_verify = document.getElementById("username_verify");
let pasword_verify = document.getElementById("password_verify");

const url = "http://localhost:8080/"

if (sessionStorage.getItem("userSession") != null){
    let user = JSON.parse(sessionStorage.getItem("userSession"));
    if(user.userRoleId != 2){
        window.location.replace(url + "employee.html");
    } else {
      window.location.replace(url + "manager.html");
    }
  }  
  
  loginBtn.addEventListener("click", loginFunc);

async function loginFunc(){
    let user = {
        username: usernameBox.value,
        password: passwordBox.value
    }

    

    if (user.username == ""){
      
      login_verify.style.fontSize = "12px";
      login_verify.innerHTML = "Wrong Username";
      let p = document.createElement("div");
      let break_line = document.createElement("br");
      document.createTextNode('\u00A0');
      p.appendChild(break_line);

    }
    if (user.password == ""){
        password_verify.style.fontSize = "12px";
        password_verify.innerHTML = "Wrong Password"; 
      }
      console.log("Username and Password:" + user.username + " | " + user.password);

      let response = await fetch(
        url+"login",
        {
          method : "POST",
          body : JSON.stringify(user),
          credentials: "include"
        }
        );
    
      if(response.status===200){
        let user_info = await response.json();
        console.log("User Role ID: " + user_info.userRoleId);
        sessionStorage.setItem("userSession", JSON.stringify(user_info));
        if (user_info.userRoleId == 2) {
            window.location.replace(url + "manager.html");
        } else {
            window.location.replace(url + "employee.html");
        }
      }else{
        console.log("Login unsuccessful"+response.status);
    }
}

