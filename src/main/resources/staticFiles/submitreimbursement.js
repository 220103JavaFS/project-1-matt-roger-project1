let submitRequest = document.getElementById("submitRequest");
let reimbursementTable = document.getElementById("reimbursementTbl");
let reimbamount = document.getElementById("reimbamount");
let reimbDescription = document.getElementById("reimbDescription");
let reimbType = document.getElementById("reimbType");

const timeSubmitted = Date.now();

const url = 'http://localhost:8080/';

submitRequest.addEventListener("click", submitReimbursement);


async function submitReimbursement(){
  let reimbursement = {
    reimb_amount: reimbamount.value,
    reimb_description: reimbDescription.value,
    reimb_submitted:timeSubmitted,
    reimb_status_id: 1,
    reimb_type: reimbType.value


  }

  let response = await fetch(url+"reimbursements/add", {
    method:"POST",
    body:JSON.stringify(reimbursement),
    credentials:"include"
  })

  if(response.status===200){
    submit.innerText = ""; 
  }else{
    console.log("Add:"+response.status);
  }

}



