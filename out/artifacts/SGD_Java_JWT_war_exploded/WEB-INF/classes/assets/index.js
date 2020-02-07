var senha = document.getElementById("senha")
    , confirmaSenha = document.getElementById("confirmarSenha");

function validatePassword(){
    if(senha.value != confirmaSenha.value) {
        confirmaSenha.setCustomValidity("As senhas não conferem.");
    } else {
        confirmaSenha.setCustomValidity('');
    }
}

senha.onchange = validatePassword;
confirmaSenha.onkeyup = validatePassword;