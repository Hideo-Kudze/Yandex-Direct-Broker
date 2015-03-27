window.onload = function () {

    $("form").submit(function (e) {


        var  positions = $(this).find("select").val();

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
            positions : positions,
            highestPosition : $(this).find("input[type='radio']:checked").val(),
            rmax : $(this).find('input[name=rmax]').val(),
            percent : $(this).find('input[name=percent]').val()

        };

        var idType = $(this).find('input[type=hidden]').attr('name');
        var id = $(this).find('input[type=hidden]').val();

        postData[idType] = id;

        postData = JSON.stringify(postData);

        $.ajax(
            {
                url: "/add_tactic",
                type: "POST",
                data: postData,
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                success: function (data, textStatus, jqXHR) {
                    //data: return data from server
                },
                error: function (jqXHR, textStatus, errorThrown) {
                    //if fails
                }
            });
        e.preventDefault(); //STOP default action
    });


}


function deleteTactics(type, id){
    var postData = {type:  type,
        id: id};

    $.ajax(
        {
            url: "/remove_tactics",
            type: "POST",
            data: postData,
            contentType: 'application/x-www-form-urlencoded',
            success: function (data, textStatus, jqXHR) {
                //data: return data from server
            },
            error: function (jqXHR, textStatus, errorThrown) {
                //if fails
            }
        });

}


function addUTM(id){

    var postData = {id: id};


    $.ajax(
        {
            url: "/add_utm",
            type: "POST",
            data: postData,
            contentType: 'application/x-www-form-urlencoded',
            success: function (data, textStatus, jqXHR) {
                //data: return data from server
            },
            error: function (jqXHR, textStatus, errorThrown) {
                //if fails
            }
        });

}