// Call the dataTables jQuery plugin
$(document).ready(function() {
  //On Ready
});

async function registrarUsuarios(){

   let datos = {};
   datos.id = document.getElementById('txtId').value;
   datos.nombre = document.getElementById('txtNombre').value;
   datos.apellido = document.getElementById('txtApellido').value;
   datos.email = document.getElementById('txtEmail').value;
   datos.password = document.getElementById('txtPassword').value;
   //datos.cargo = document.getElementById('txtRepeatPassword').value;

   let repetirPassword = document.getElementById('txtRepeatPassword').value;

   if(repetirPassword != datos.password){
    alert('La Contraseña que escribiste es diferente');
    return;
   }

  const request = await fetch('api/usuarios', {
    method: 'POST',
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(datos)
  });
    alert("La Cuenta fue creada con Exito!");
    window.location.href = 'login.html'
}
