$('#modalDeletionConfirmation').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	
	var codeInvoice = button.data('code');
	var customerInvoice = button.data('customer');
	
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	if (!action.endsWith('/')) {
		action += '/';
	}
	form.attr('action', action + codeInvoice);
	
	modal.find('.modal-body span').html('Are you sure you want to delete Invoice <strong> - ' + customerInvoice + '</strong>?');
});

$(function() {
	$('[rel="tooltip"]').tooltip();
	$('.js-currency').maskMoney({decimal: ',', thousands: '.', allowZero: true});
	
	$('.js-update-status').on('click', function(event) {
		event.preventDefault();
		
		var receiveButton = $(event.currentTarget);
		var receiveURL = receiveButton.attr('href');
		
		var response = $.ajax({
			url: receiveURL,
			type: 'PUT'
		});
		
		
		response.done(function(e) {
			var codeInvoice = receiveButton.data('code');
			$('[data-role=' + codeInvoice + ']').html('<span class="label label-success">' + e + '</span>');
			receiveButton.hide();
		});
		
		response.fail(function(e) {
			console.log(e);
			alert('Receiving invoice error');
		});
		
	});
});
