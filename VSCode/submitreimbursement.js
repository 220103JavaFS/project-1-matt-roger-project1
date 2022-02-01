let submitRequest = document.getElementById("submitRequest");
let reimbursementTable = document.getElementById("reimbursementTbl");


const url = 'http://localhost:8080';

submitRequest.addEventListener("click", submitReimbursement);

button.addEventListener('click', requestFunc);

async function submitReimbursement(){
  let reimbursement = {
    reimbAmount: document.getElementById("reimbamount").value,
    reimbType:document.getElementById("reimbType").value,
    reimbDescription:document.getElementById("reimbDescription").value,
  }

  let response = await fetch(url+"reimbursements", {
    method:"POST",
    body:JSON.stringify(reimbursements),
    credentials:"include"
  })

  if(response.status===201){
    getAllReimbursements();
    console.log("reimbursement added successfully");
  }else{
    console.log("Problem encountered when adding reimbursement.");
  }

}

function populatereimbursment(reimbursements){
  reimbursementTable.innerHTML ="";
  for(let reimbursement of reimbursements){
    let row = document.createElement("tr");
    for(let data in reimbursement){
      let td = document.createElement("td");
      td.innerText = reimbursement[data];
      row.appendChild(td);
    }
    reimbursementTable.appendChild(row);
  }
}


