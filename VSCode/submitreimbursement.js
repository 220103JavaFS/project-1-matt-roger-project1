let amount = document.getElementById('amount').value;
let description = document.getElementById('Description').value;
let type = document.getElementById('Type').value;
let status = document.getElementById('Status').value;
let button = document.getElementById('submit');

const url = 'http://localhost:8080';

button.addEventListener('click', requestFunc);

async function requestFunc() {
    let reimbursementRequest = {
      amount: amount,
      description: description,
      receipt: receipt,
      type: type,
      status: status,
    };
    if (
        reimbursementRequest.amount == '' ||
        reimbursementRequest.type == '' ||
        reimbursementRequest.status == ''
      ) {

        alert(
          'Please fill in the form'
        );
        return;
      }

    let response = await fetch(url + '/request', {
        method: 'POST',
        body: JSON.stringify(reimbursementRequest),
        credentials: 'include', //TODO: Is this needed for cookies?
    });

    
    if (response.status === 200) {   
        let data = await response.json(); 
        console.log(data);
        location.href = 'http://localhost:8080/MainPage.html';
  } else {
    alert('Try again');
  }

}