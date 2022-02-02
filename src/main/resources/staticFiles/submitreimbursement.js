let submitRequest = document.getElementById("submitRequest");
let reimbursementTable = document.getElementById("reimbursementTbl");
const timeSubmitted = Date.now();


const url = 'http://localhost:8080/reimbursements/add';

submitRequest.addEventListener("click", submitReimbursement);

button.addEventListener('click', requestFunc);

async function submitReimbursement(){
  let reimbursement = {
    reimb_amount: document.getElementById("reimbamount").value,
    reimb_description:document.getElementById("reimbDescription").value,
    reimb_submitted:timeSubmitted,
    reimb_status_id: 1,
    reimb_type:document.getElementById("reimbType").value,
    authorUserId: userId

  }

  let response = await fetch(url+"reimbursements", {
    method:"POST",
    body:JSON.stringify(reimbursements),
    credentials:"include"
  })


}



