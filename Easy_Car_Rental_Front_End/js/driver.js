function getCookie(name) {
    var nameEQ = name + "=";
    var ca = document.cookie.split(';');
    for(var i=0;i < ca.length;i++) {
        var c = ca[i];
        while (c.charAt(0)==' ') c = c.substring(1,c.length);
        if (c.indexOf(nameEQ) == 0) return c.substring(nameEQ.length,c.length);
    }
    return null;
}

$('#user-name').text(getCookie('user'));


$('#sign-out').click(function () {
    if (confirm("Are you sure to Sign-out")){
        window.location.replace("index.html");
    }else{

    }
});
