function eliminar(id){

swal({
  title: "¿Estas seguro de eliminar?",
  text: "Una vez eliminado, ¡no podrá recuperar este archivo!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
    $.ajax({
    url:"/eliminar/"+id,
    success: function(res){
        console.log(res);
    }
    })
    swal("¡Tu archivo ha sido eliminado!", {
      icon: "success",
    }).then((ok)=>{

        if(ok){
            location.href="/inventario";

        }

    });
  } else {
    swal("¡Tu archivo está a salvo!");
  }
});

}


function eliminarU(id){

swal({
  title: "¿Estas seguro de eliminar?",
  text: "Una vez eliminado, ¡no podrá recuperar este usuario!",
  icon: "warning",
  buttons: true,
  dangerMode: true,
})
.then((OK) => {
  if (OK) {
    $.ajax({
    url:"/eliminarU/"+id,
    success: function(res){
        console.log(res);
    }
    })
    swal("¡Tu usuario ha sido eliminado!", {
      icon: "success",
    }).then((ok)=>{

        if(ok){
            location.href="/usuarios";

        }

    });
  } else {
    swal("¡Tu usuario está a salvo!");
  }
});

}
