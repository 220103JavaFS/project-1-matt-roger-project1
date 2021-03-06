let getAllbtn = document.getElementById("getAllbtn");
let statusbtn = document.getElementById("statusbtn");
let reimbursementTable = document.getElementById("reimbursementTbl");
let statusInput = document.getElementById("status");

const url = "http://localhost:8080/"

getAllbtn.addEventListener("click", getAllReimbursements);
statusbtn.addEventListener("click", getAllReimbursementsByStatus);



document.querySelectorAll('.status-btn').forEach(button => {
  button.addEventListener("click", e => {
    e.target.closest('tr').querySelector('td.status').innerText = e.target.dataset.status;
  });
});

async function getAllReimbursementsByStatus(){


  let response = await fetch(url+ "reimbursments/"+statusInput.value, { 
    credentials: 'include'
   });

  if (response.status === 200) {
    let data = await response.json();
    console.log(data);
    populatereimbursment(data);
  } else {
    console.log(url+ "reimbursments/"+statusInput.value);
    console.log('Something went wrong');
  }
}


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
      approveBtn.addEventListener("click", updateValue.bind(event, reimbursement, 2));
      denyBtn.addEventListener("click", updateValue.bind(event, reimbursement, 3));

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
    
    reimbursement['statusId'] = isApproved;
  
    console.log(reimbursement);
    let response = await fetch(
      url+"reimbursments/update",
      {
        method : "PUT",
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