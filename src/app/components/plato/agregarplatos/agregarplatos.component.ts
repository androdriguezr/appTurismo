import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { DepartamentoModel } from 'src/app/models/departamento.model';
import { PlatoService } from 'src/app/services/plato/plato.service';
import { DepartamentoService } from 'src/app/services/departamento/departamento.service';


declare var $: any;
declare var jQuery: any;
@Component({
  selector: 'app-agregarplatos',
  templateUrl: './agregarplatos.component.html',
  styleUrls: ['./agregarplatos.component.scss']
})
export class AgregarplatosComponent implements OnInit {
  frmPlatoRegistro: FormGroup;
  departamentoId: number = 0;
  validacionCampos = {
    nombre: [{ 'type': 'required', message: 'Digite nombre del Departamento' }]
  }

  misDepartamentos: Array<DepartamentoModel> = [];

  constructor(private contructorFormulario: FormBuilder, private platoService: PlatoService, private departamentoService: DepartamentoService, private activatedRoute: ActivatedRoute) {
    this.frmPlatoRegistro = this.contructorFormulario.group({
      nombre: new FormControl('', Validators.compose([Validators.required])),
      descripcion: new FormControl()
    });

  }

  onSubmit() {
    let jQueryInstance = this
    //alert(this.region);
    if (this.departamentoId != 0) {
      if (this.frmPlatoRegistro.valid) {
        //this.frmRegionRegistro.value.pais=this.pais;
        this.platoService.InsertRecord(this.frmPlatoRegistro.value, this.departamentoId).subscribe(result => {
          //console.log(result);
          //console.log(result.id);

          if (result.id > 0) {
            alert("Guardado con exito");
            this.borrar();
          } else {
            alert("Error al guardar!!!");
            //this.estadoProceso = 0;
            //this.modal.callAlert("Error al registrar", "ERROR");
          }

        });
      } else {
        Object.keys(this.frmPlatoRegistro.controls).forEach(field => {
          const control: any = this.frmPlatoRegistro.get(field);
          if (!control['controls']) {
            control.markAsTouched({ onlySelf: true });
          }
        })
      }
    }else{
      alert("Debe seleccionar una Region");
    }

  }

  depSelectChange(event: any) {
    this.departamentoId = event.target.value;
  }

  borrar() {
    this.frmPlatoRegistro.reset();
    $("#enviar").attr("disabled", "disabled");
  }

  cargarDepartamentos() {
    const result = this.departamentoService.listarDepartamentos();
    console.log(result);
    result.then((data: Array<DepartamentoModel>) => {
      this.misDepartamentos = data;
    });

  }

  ngOnInit(): void {

    this.cargarDepartamentos();

    $(document).ready(function () {
      $("#nombrePlato").focus();
      $("#nombrePlato").keyup(function (evt) {
        if ($(this).val().length > 0) {
          $("#enviar").removeAttr("disabled",);
          $("#reset").removeAttr("disabled",);
        } else {
          $("#enviar").attr("disabled", "disabled");
          $("#reset").attr("disabled", "disabled");
        }

      });
    })
  }

}
