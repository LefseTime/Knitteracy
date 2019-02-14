let savedCharts;

function loadSavedCharts() {
    let grid = $('#word');
    grid.empty();
    let username = $('#username-value').val();
    $.ajax({
        type: 'POST',
        url: '/api/user/' + username,
        success: function (result) {
            $('#magnify-buttons').removeClass('hide');
            savedCharts = result.savedCharts;
            for (let r = 0; r < savedCharts.length; r++) {
                let chart = savedCharts[r];
                constructChart(chart, grid, r, "user");
            }
        },
        error: function () {
            alert('FAILURE!');
        }
    });
};

document.onload = loadSavedCharts();

$('#word').on("click", ".delete-button", deleteChart);

function deleteChart(){
    let index = $(this).data("value");
    let chartId = savedCharts[index].chartId;
    $.ajax({
        type: 'POST',
        url: '/api/deleteChart/' + chartId,
        success: function (result) {
            loadSavedCharts();
        },
        error: function () {
            
        }
    });

    
}