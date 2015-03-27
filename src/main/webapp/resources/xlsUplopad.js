function uploadXls() {

    $('#uploadButton').first().attr("disabled", "disabled");

    var data = new FormData();
    var files = $('#xlsUpload')[0].files;

    $.each(files, function (key, value) {
        data.append(key, value);
    });


    $.ajax(
        {
            url: "/uploadXls",
            type: "POST",
            data: data,
            cache: false,
            dataType: "json",
            processData: false,
            contentType: false,


            success: function (data, textStatus, jqXHR) {
                $('#uploadButton').first().removeAttr("disabled");
            },

            error: function (jqXHR, textStatus, errorThrown) {
                alert("Error");
                $('#uploadButton').first().removeAttr("disabled");
            }

        });

}