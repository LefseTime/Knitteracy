let sizes = ['xs','s','m','l','xl'];
let currentSize = 2;

$('#magnify').click(function (){
    let table = $('table');
    if (sizes[currentSize + 1] != null){
        table.removeClass(sizes[currentSize]);
        currentSize++;
        table.addClass(sizes[currentSize]);
    }
});

$('#minify').click(function (){
    let table = $('table');
    if (sizes[currentSize - 1] != null){
        table.removeClass(sizes[currentSize]);
        currentSize--;
        table.addClass(sizes[currentSize]);
    }
});

function constructChart(result, grid, r, environment){
            let sourceName = result.font.sourceName;
            let sourceUrl = result.font.sourceUrl;
            let letterArr = result.letters;
            let height = letterArr[0].coordinates.length;
            let totalWidth = 0;
            let kerningWidth;
            let spacingWidth;

            if (environment === "user"){
                kerningWidth = parseInt(result.kerning);
            }
            else if (environment === "home"){
                kerningWidth = parseInt($(`#kerning`).val());
            } else {
                kerningWidth = parseInt(0);
            }

            if (environment === "user"){
                spacingWidth = parseInt(result.spacing);
            }
            else if (environment === "home"){
                spacingWidth = parseInt($(`#spacing`).val());
            } else {
                spacingWidth = parseInt(kerningWidth);
            }
            
            let wordHtml = '';
            let letterHtml = '';
            let rowHtml = '';
            let colHtml = '';
            for (let i = 0; i < letterArr.length; i++) {
                let letter = letterArr[i];
                letterHtml = '';

                //spacing
                if (letter === null){
                    totalWidth += parseInt(spacingWidth);

                    for (let l = height; l > 0; l--){
                        rowHtml = '';
                        for (let m = 0; m < spacingWidth; m++){
                            colHtml = '';
                            colHtml +=`<td></td>`;
                            rowHtml += colHtml;
                        }
                        letterHtml += `<tr>${rowHtml}</tr>`;
                    }
                    
                    
                } else {
                    totalWidth += parseInt(letter.width);
                    let coordinates = letter.coordinates;
                    for (let j = coordinates.length; j > 0; j--) {
                        let row = coordinates[j - 1];
                        rowHtml = '';
                        for (let k = 0; k < row.length; k++) {
                            colHtml = '';
                            if (row[k]) {
                                colHtml += `<td class='table-true'></td>`;
                            } else {
                                colHtml += `<td></td>`;
                            }
                            rowHtml += colHtml;
                        }
                        letterHtml += `<tr>${rowHtml}</tr>`;
                    }
                }

                wordHtml += `<table class='m'>${letterHtml}</table>`;

                //kerning
                if (i < letterArr.length - 1){
                    letterHtml = '';
                    totalWidth += parseInt(kerningWidth);
                    for (let j = height; j > 0; j--) {
                        rowHtml = '';
                        for (let k = 0; k < kerningWidth; k++) {
                            colHtml = '';
                            colHtml += `<td></td>`;
                            rowHtml += colHtml;
                        }
                        letterHtml += `<tr>${rowHtml}</tr>`;
                    }
                    wordHtml += `<table class='m'>${letterHtml}</table>`;
                }
                
            }

            wordHtml += `<div class='chart-info'>Height: ${parseInt(height)}<br>Width: ${parseInt(totalWidth)}<br>Kerning: ${parseInt(kerningWidth)}<br>Spacing: ${parseInt(spacingWidth)}<br><br>Source: <a href='${sourceUrl}' target='_blank'>${sourceName}</a>
            <br><br>`;

            if (environment === "home"){
                wordHtml += `<button type='button' name='save' class='save-button' id='save-button' data-value=${r}>Save</button>
                </div>`;
    
            } else {
                wordHtml += `<button type='button' name='delete' class='delete-button' id='delete-button' data-value=${r}>Delete</button>
                </div>`;
            }
            



            let chartHtml = `<div class='chart'>${wordHtml}</div>`;

            grid.append(chartHtml);
}