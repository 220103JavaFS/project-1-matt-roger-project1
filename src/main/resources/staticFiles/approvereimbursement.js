let getAllbtn = document.getElementById("getAllbtn");
let reimbursementTable = document.getElementById("reimbursementTbl");

const url = "http://localhost:8080/"

getAllbtn.addEventListener("click", getAllReimbursements);


document.querySelectorAll('.status-btn').forEach(button => {
  button.addEventListener("click", e => {
    e.target.closest('tr').querySelector('td.status').innerText = e.target.dataset.status;
  });
});




async function getAllReimbursements(){
    let response = await fetch(url+"reimbursments", {
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
      let approveTd = document.createElement("td");
      let denyTd = document.createElement('td');
      let approveBtn = document.createElement("button");
      let denyBtn = document.createElement("button");
      approveBtn.addEventListener("click", updateValue.bind(reimbursement, true));
      denyBtn.addEventListener("click", updateValue.bind(reimbursement, false));

      approveBtn.innerText = "O";
      denyBtn.innerText = "X";

      approveTd.appendChild(approveBtn);
      denyTd.appendChild(denyBtn);
      row.appendChild(approveTd);
      row.appendChild(denyTd);
      reimbursementTable.appendChild(row);
    }
  }

  async function updateValue(reimbursement, isApproved)
  {
    if(isApproved)
    {
      reimbursement['statusId'] = 1;
    }
    else
    {
      reimbursement['statusId'] = 2;
    }
    
    let response = await fetch(
      url+"user/update",
      {
        method : "POST",
        body : JSON.stringify(reimbursement),
        credentials: "include"
      }
    );
  
    if(response.status===200){
      console.log("Update successfull. Returned status code of:"+response.status);
    }else{
      console.log("Update unsuccessful. Returned status code of:"+response.status);
    }
  }