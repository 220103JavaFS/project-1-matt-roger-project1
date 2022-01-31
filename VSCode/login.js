

let username = document.getElementById("username");
let password = document.getElementById("password");

let submit = document.getElementById("submit");

const url = "http://localhost:8080/"


submit.addEventListener("click", loginFunc);


async function loginFunc(){
let user = {
    username: username.value,
    password: passWord.value
  }
}

let response = await fetch(
    url+"login",
    {
      method : "POST",
      body : JSON.stringify(user),
      credentials: "include"
    }
  );