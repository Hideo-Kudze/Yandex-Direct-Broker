
function refreshWire(){

    $('#refreshWireButton').first().attr("disabled", "disabled");
    $.ajax(
        {
            url: "/refresh_wire",
            type: "POST",
            contentType: 'application/x-www-form-urlencoded',
            success: function (data, textStatus, jqXHR) {
                $('#refreshWireButton').first().removeAttr("disabled");
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Error");
                $('#refreshWireButton').first().removeAttr("disabled");
            }
        });

}