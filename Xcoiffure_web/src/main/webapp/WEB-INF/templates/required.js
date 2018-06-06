$('form').bind('submit', validation);
function validation()
{
    var mail = document.getElementById('mail').value;
    var motdepasse = document.getElementById('motdepasse').value;
    
    alerte="";
   
    if(mail == ""){
        alert("Veuillez saisir votre mail ou votre nom d'utilisateur pour poursuivre votre inscription !");
        return false;}
   
    if (motdepasse == ""){
        alert("Veuillez entrer votre mot de passe");
        return false;}

	
    return true;
}


$('input').bind('keyup', verif);

function verif()
{
    if($(this).val() == '')
    {
    	$(this).css('border-color', 'red')
    }
    else
    {
    	$(this).css('border-color', '')
    }
}