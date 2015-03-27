

function saveANYStrategy(button, campaignId) {

    $(button).attr("disabled", "disabled");

    var form = $(button).closest('form');


    var postData = {
        id: campaignId,
        goalsId: $(form).find("[name = 'goals']").val(),
        cmax: $(form).find("[name = 'cmax']").val()
    };


    postData = JSON.stringify(postData);


    $.ajax(
        {
            url: "/add_ANY_tactic",
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

function removeAnyStrategy(button, id){




    $(button).attr("disabled", "disabled");


    var postData = {id: id};

    $.ajax(
        {
            url: "/removeAnyStrategy",
            type: "POST",
            data: postData,
            contentType: 'application/x-www-form-urlencoded',

            success: function (data, textStatus, jqXHR) {
                $(button).removeAttr("disabled");
            },

            error: function (jqXHR, textStatus, errorThrown) {

                alert("Error");
                $(button).removeAttr("disabled");
            }
        });

}