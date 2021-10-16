import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { PageEvent } from '@angular/material/paginator';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { PlatoModel } from 'src/app/models/plato.model';
import { PlatoService } from 'src/app/services/plato/plato.service';


declare var $: any;
declare var jQuery: any;
@Component({
  selector: 'app-listarplatos',
  templateUrl: './listarplatos.component.html',
  styleUrls: ['./listarplatos.component.scss']
})
export class ListarplatosComponent implements OnInit {

  @ViewChild("modalMensaje") modal: ElementRef;
  misPlatos: Array<PlatoModel> = [];
  pageSize = 5;
  desde = 0;
  hasta = this.pageSize;
  searchText;

  constructor(private platoService: PlatoService, private modalsv: NgbModal) { }

  listartodos() {
    const result = this.platoService.listarPlatos();
    result.then((data: Array<PlatoModel>) => {
      this.misPlatos = data;
    });
  }

  miPlato: PlatoModel;

  buscarPorNombre() {
    if (this.searchText != "") {
      const result = this.platoService.BuscarPlatoPorNombre(this.searchText);
      result.then((data: Array<PlatoModel>) => {
        this.misPlatos = data;
        //console.log(this.misPaises);
      });
    }else{
      this.misPlatos=[];
    }


    //esto es para 1 resultado
    /*this.miDepar = null;
    result.then((data: DepartamentoModel) => {
      //console.log(data);
      this.miDepar = data;
      this.misDepartamentos = new Array<DepartamentoModel>();
      this.misDepartamentos.push(this.miDepar);
      console.log(this.misDepartamentos);

    });*/

  }

  getPlato(valor):PlatoModel {
    return valor;
  }

  deletePlato(elpais: any) {
    this.platoService.DeleteItemRecord(elpais.id).subscribe(result => {
      console.log(result);
      //alert("eliminado");
      this.listartodos();
      alert("Registro borrado con exito");
    });
  }

  cambiarPagina(evt: PageEvent) {
    console.log(evt);
    console.log(evt.pageIndex)
    console.log(evt.pageSize)
    this.desde = evt.pageIndex * evt.pageSize;
    this.hasta = this.desde + evt.pageSize;
  }

  showUpdate(id: any) {
    this.modalsv.open(this.modal);
  }

  ngOnInit(): void {
  }

}
