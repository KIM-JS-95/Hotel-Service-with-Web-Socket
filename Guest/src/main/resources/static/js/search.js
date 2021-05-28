var main = {
    init : function () {
        var _this = this;
        $('#btn-search').on('click', function () {
            _this.search();
        });
    },

    search : function () {
         var name= $('#name').val();
         var email= $('#email').val();

        $.ajax({
            type: 'GET',
            url: '/CheckInInquire',
            dataType: 'json',
            contentType:'application/json; charset=utf-8',

        }).done(function() {
            alert('조회!');
            window.location.href = 'inquiry-result';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

};

main.init();