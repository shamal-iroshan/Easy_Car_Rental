let arr = ['#btnDashBoard','#btnPlaceBooking','#btnBookings','#btnProfile'];
let containers = ['#dashboard','#place-booking','#bookings','#profile'];

$('#btnDashBoard').click(function () {

    setClass();
    $('#btnDashBoard').addClass('btn-custom-selected');

    setVisible();
    $('#dashboard').css('display','block');
});

$('#btnPlaceBooking').click(function () {

    setClass();
    $('#btnPlaceBooking').addClass('btn-custom-selected');

    setVisible();
    $('#place-booking').css('display','block');
});

$('#btnBookings').click(function () {

    setClass();
    $('#btnBookings').addClass('btn-custom-selected');

    setVisible();
    $('#bookings').css('display','block');
});

$('#btnProfile').click(function () {

    setClass();
    $('#btnProfile').addClass('btn-custom-selected');

    setVisible();
    $('#profile').css('display','block');
});



function setClass() {
    for (id in arr){
        $(arr[id]).removeClass('btn-custom-selected');
        $(arr[id]).addClass('btn-custom');
    }
}

function setVisible() {
    for (i in containers){
        $(containers[i]).css('display','none');
    }
}
