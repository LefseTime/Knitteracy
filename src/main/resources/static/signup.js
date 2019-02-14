$('#submit-signup').click(function () {
    let username = $('#username').val();
    let password = $('#password').val();
    let data = {"username": username, "password": password};
    $.ajax({
        type: 'POST',
        url: '/signup',
        contentType:'application/json',
        data: JSON.stringify(data),
        success: function (result) {
            console.log(result);
        },
        error: function () {
            console.log(error)
            alert('FAILURE!');
        }
    });
});