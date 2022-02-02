let getAllbtn = document.getElementById("getAllbtn");

getAllbtn.addEventListener("click", getAllReimbursements);


async function getAllReimbursements(){
    let response = await fetch(url+"reimbursements", {
      credentials:"include"
    });
  
    if(response.status===200){
      let reimbursements = await response.json();
      populatereimbursment(reimbursement);
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