$('#btnUploadNIC').click(function () {

    let formData = new FormData()

    $.ajax({
       url: 'http://localhost:8080/carRental/api/v1/car',
       type: 'POST',

    });
});

$('#sign-out').click(function () {
    if (confirm("Are you sure to Sign-out")){
        window.location.replace("index.html");
    }else{

    }
});
