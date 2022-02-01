let amount = document.getElementById('amount').value;
let description = document.getElementById('Description').value;
let type = document.getElementById('Type').value;
let status = document.getElementById('Status').value;
let button = document.getElementById('submit');

const url = 'http://localhost:8080';

submitRequest.addEventListener("click", submitreimbursement);

button.addEventListener('click', requestFunc);

async function submitreimbursement(){
  let reimbursement = {
    reimbAmount: document.getElementById("reimbamount").value,
    reimbType:document.getElementById("reimbType").value,
    reimbDescription:document.getElementById("reimbDescription").value,
  }

  let response = await fetch(url+"reimbursements", {
    method:"POST",
    body:JSON.stringify(home),
    credentials:"include"
  })

  if(response.status===201){
    getAllHomes();
    console.log("reimbursement added successfully");
  }else{
    console.log("Problem encountered when adding reimbursement.");
  }

}


