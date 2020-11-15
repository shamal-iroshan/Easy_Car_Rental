let arr = ['#btnHome','#btnRent','#btnHistory','#btnCustom','#btnFinal'];

$('#btnHome').click(function () {

    setClass();

    $('#btnHome').addClass('btn-custom-selected');
});

$('#btnRent').click(function () {

    setClass();

    $('#btnRent').addClass('btn-custom-selected');
});

$('#btnHistory').click(function () {

    setClass();

    $('#btnHistory').addClass('btn-custom-selected');
});

$('#btnCustom').click(function () {

    setClass();

    $('#btnCustom').addClass('btn-custom-selected');
});

$('#btnFinal').click(function () {

    setClass();

    $('#btnFinal').addClass('btn-custom-selected');
});


function setClass() {
    for (id in arr){
        $(arr[id]).removeClass('btn-custom-selected');
        $(arr[id]).addClass('btn-custom');
    }
}
