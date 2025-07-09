// Call the dataTables jQuery plugin
$(document).ready(function() {
    cargarUsuarios();
  $('#usuarios').DataTable();
});

async function cargarUsuarios(){
  const request = await fetch('api/usuarios', {
  //const request = await fetch('api/v1/employee', {
    method: 'GET',
    headers: getHeaders()
  });

  //const employees = await request.json();
  const usuarios = await request.json();



   let listadoHtml = '';

    /*
   for (let employee of employees) {
         let botonEliminar = '<a href="#" onclick="eliminarUsuario('+ employee.dni +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

         let telefonoTexto = employee.telefono == null ? '-' : employee.telefono;
         let employeeHtml = '<tr><td>'+employee.dni+'</td><td>' + employee.firstName + ' ' + employee.lastName + '</td><td>'
                         + employee.email+'</td><td>'+telefonoTexto
                         + '</td><td>' + botonEliminar + '</td></tr>';
         listadoHtml += employeeHtml;
       }*/

    for (let usuario of usuarios) {
      let botonEliminar = '<a href="#" onclick="eliminarUsuario('+ usuario.id +')" class="btn btn-danger btn-circle btn-sm"><i class="fas fa-trash"></i></a>';

      let telefonoTexto = usuario.telefono == null ? '-' : usuario.telefono;
      let usuarioHtml = '<tr><td>'+usuario.id+'</td><td>' + usuario.nombre + ' ' + usuario.apellido + '</td><td>'
                      + usuario.email+'</td><td>'+telefonoTexto
                      + '</td><td>' + botonEliminar + '</td></tr>';
      listadoHtml += usuarioHtml;
    }

  document.querySelector('#usuarios tbody').outerHTML = listadoHtml;

}

function getHeaders(){
    return{
        'Accept': 'application/json',
        'Content-Type': 'application/json',
        'Authorization': localStorage.token
    };
}

async function eliminarUsuario(id){
if(!confirm('¡Desea Eliminar este usuario?')){
    return;
}
const request = await fetch('api/usuarios/' + id, {
//const request = await fetch('api/v1/employee/' + dni, {
    method: 'DELETE',
    headers: getHeaders()
  });
  location.reload()
}
