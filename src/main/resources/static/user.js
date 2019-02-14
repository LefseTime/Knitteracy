let savedCharts;

function loadSavedCharts() {
    let grid = $('#word');
    grid.empty();
    let username = $('#username-value').val();
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/user/' + username,
        success: function (result) {
            console.log(result);
            $('#magnify-buttons').removeClass('hide');
            savedCharts = result.savedCharts;
            for (let r = 0; r < savedCharts.length; r++) {
                let chart = savedCharts[r];
                console.log(chart)
                constructChart(chart, grid, r, "user");
            }
        },
        error: function () {
            console.log(error)
            alert('FAILURE!');
        }
    });
};

document.onload = loadSavedCharts();

$('#word').on("click", ".delete-button", deleteChart);

function deleteChart(){
    let index = $(this).data("value");
    let chartId = savedCharts[index].chartId;
    console.log(chartId);
    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/api/deleteChart/' + chartId,
        success: function (result) {
            loadSavedCharts();
        },
        error: function () {
            
        }
    });

    
}