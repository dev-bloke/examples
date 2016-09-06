// Launch a modal.

$(document).ready(
	function() {
        $("#showModal").click(
        	function() {
                $("#myModal").modal('show');
            }
        );
    }
);

var count = 1;

$(document).ready(
	function() {
        $("#smallModal").on('show.bs.modal', 
        	function(event) {
                var button = $(event.relatedTarget);
                console.log(button);
                var titleData = 'You have pressed the ' + button.data('title') + ' button ';
                var times = (count > 1) ? count + ' times.' : 'once.';
                $(this).find('.modal-title').text(titleData + times);
                count++;
            }
        );
    }
);

// Enable tooltips.

$(function () {
	  $('[data-toggle="tooltip"]').tooltip()
})

// Enable popovers.

$(function () {
	  $('[data-toggle="popover"]').popover()
})
