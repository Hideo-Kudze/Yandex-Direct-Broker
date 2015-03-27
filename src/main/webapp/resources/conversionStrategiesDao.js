

function saveConversionStrategy(button, campaignId) {

    $(button).attr("disabled", "disabled");

    var form = $(button).closest('form');

    var  positions = $(form).find("[name = 'positions']").val();

    var positionsLength = positions.length;

    for (var i = 0; i < positionsLength; i++) {

        switch (positions[i]) {
            case "1СПЕЦ.":
                positions[i] = "FIRST_SPEC";
                break;
            case "СПЕЦ.":
                positions[i] = "SPEC";
                break;
            case "1ГАР.":
                positions[i] = "FIRST_GUAR";
                break;
            case "ГАР.":
                positions[i] = "GUAR";
                break;
            case "ДИН.":
                positions[i] = "DYN";
                break;
        }

    }

    var postData = {
        campaignId: campaignId,
        positions : positions,
        highestPosition : $(form).find("[name = 'group1']:checked").val(),
        goalsId: $(form).find("[name = 'goals']").val(),
        rmax: $(form).find("[name = 'rmax']").val(),
        cmax: $(form).find("[name = 'cmax']").val()
    };



    postData = JSON.stringify(postData);




    $.ajax(
        {
            url: "/add_conversion_tactic",
            type: "POST",
            data: postData,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            success: function (data, textStatus, jqXHR) {
                $(button).removeAttr("disabled");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                $(button).removeAttr("disabled");
            }
        });



}