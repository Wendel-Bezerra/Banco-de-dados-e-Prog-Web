/**
 * validação de formulario
 * 
 */

 function validar() {
	let nome= frmContato.nome.value
	let fone= frmContato.fone.value
	if (nome===""){
		alert('preencha o campo Nome')
		FrContato.nome.focus()
		return false 
	} else if (fone ===''){
		 alert('preencha o campo fone')
		FrmContato.fone.focus()
		return false
	} else {
		document.forms['frmContato'].submit()
	}
	
 }