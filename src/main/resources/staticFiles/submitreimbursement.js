let submitRequest = document.getElementById("submitRequest");
let reimbursementTable = document.getElementById("reimbursementTbl");
let reimbamount = document.getElementById("reimbamount");
let reimbDescription = document.getElementById("reimbDescription");
let reimbType = document.getElementById("reimbType");
let authorUserId = 1;

const timeSubmitted = Date.now();

const url = 'http://localhost:8080/';

submitRequest.addEventListener("click", submitReimbursement);


async function submitReimbursement(){
  let reimbursement = {
    amount: reimbamount.value,
    description: reimbDescription.value,
    timeSubmitted:timeSubmitted,
    statusId: 1,
    typeId: reimbType.value,
    authorUserId
  

  }

  let response = await fetch(url+"reimbursments/add", {
    method:"POST",
    body:JSON.stringify(reimbursement),
    credentials:"include"
  })

  if(response.status===200){
    console.log("success");
    submit.innerText = ""; 
  }else{
    console.log("Add:"+response.status);
  }

}



