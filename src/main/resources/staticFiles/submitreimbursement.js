let submitRequest = document.getElementById("submitRequest");
let reimbursementTable = document.getElementById("reimbursementTbl");
let reimbamount = document.getElementById("reimbamount");

const timeSubmitted = Date.now();




const url = 'http://localhost:8080/reimbursements/add';

submitRequest.addEventListener("click", submitReimbursement);


async function submitReimbursement(){
  let reimbursement = {
    reimb_amount: reimbamount.value,
    reimb_description:document.getElementById("reimbDescription").value,
    reimb_submitted:timeSubmitted,
    reimb_status_id: 1,
    reimb_type:document.getElementById("reimbType").value,


  }

  let response = await fetch(url+"reimbursements", {
    method:"POST",
    body:JSON.stringify(reimbursement),
    credentials:"include"
  })


}



