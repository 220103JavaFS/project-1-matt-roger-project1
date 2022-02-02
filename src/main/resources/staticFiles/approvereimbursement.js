let getAllbtn = document.getElementById("getAllbtn");
let reimbursementTable = document.getElementById("reimbursementTbl");

const url = "http://localhost:8080/reimbursements"

getAllbtn.addEventListener("click", getAllReimbursements);


document.querySelectorAll('.status-btn').forEach(button => {
  button.addEventListener("click", e => {
    e.target.closest('tr').querySelector('td.status').innerText = e.target.dataset.status;
  });
});




async function getAllReimbursements(){
    let response = await fetch(url+"reimbursements", {
      credentials:"include"
    });
  
    if(response.status===200){
      let reimbursements = await response.json();
      populatereimbursment(reimbursements);
    } else{
      console.log("There was an error getting your reimbursements.")
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