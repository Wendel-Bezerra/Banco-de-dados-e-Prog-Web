/**
 * Confirmação de exclusão
 */

 function confirmar (id) {
	 let resposta = confirm("Confirma a exclusao deste contato?")
	 if(resposta===true){
		window.location.href = "delete?id=" + id
	 }
 }