let chartArr = [];

$('#submit-text').click(function () {
    let request = $('#text-input').val();
    $.ajax({
        type: 'POST',
        url: '/api/words/' + request,
        success: function (result) {
            $('#magnify-buttons').removeClass('hide');
            let grid = $('#word');
            grid.empty();
            chartArr = result;
            for (let r = 0; r < result.length; r++){
                let chart = result[r];
                constructChart(chart, grid, r, "home");
            }   
        },
        error: function () {
            alert('FAILURE!');
        }
    });
});

$('#word').on("click", ".save-button", saveChart);

function saveChart(){
    let index = $(this).data("value");
    let chart = chartArr[index];

    let kerning = $('#kerning').val();
    let spacing = $('#spacing').val();
    let wordStr = chart.wordStr;
    let fontId = chart.font.fontId.toString();
    let username = $('#username-value').val();
    let data = {"kerningStr": kerning, "spacingStr": spacing, "text": wordStr, "fontIdStr": fontId, "username": username};
    $.ajax({
        type: 'POST',
        url: '/api/saveChart',
        contentType:'application/x-www-form-urlencoded',
        data: data,
        success: function (result) {
            $('#success-modal').modal('show');
            setTimeout(function(){ $('#success-modal').modal('hide'); }, 1500);
        },
        error: function () {
            location.href="/login";
        }
    });

    
}