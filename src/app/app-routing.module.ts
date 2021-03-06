import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { InicioComponent } from './components/inicio/inicio.component';
import { MainviewComponent } from './components/mainview/mainview.component';
import { AgregarRegionesComponent } from './components/region/agregar-regiones/agregar-regiones.component';
import { RegionComponent } from './components/region/region.component';
import { ListarRegionesComponent } from './components/region/listar-regiones/listar-regiones.component';
import { PaisComponent } from './components/pais/pais.component';
import { AgregarPaisesComponent } from './components/pais/agregar-paises/agregar-paises.component';
import { ListarPaisesComponent } from './components/pais/listar-paises/listar-paises.component';
import { DepartamentoComponent } from './components/departamento/departamento.component';
import { AgregarDepartamentosComponent } from './components/departamento/agregar-departamentos/agregar-departamentos.component';
import { ListarDepartamentosComponent } from './components/departamento/listar-departamentos/listar-departamentos.component';
import { PlatoComponent } from './components/plato/plato.component'
import { ListarplatosComponent } from './components/plato/listarplatos/listarplatos.component';
import { AgregarplatosComponent } from './components/plato/agregarplatos/agregarplatos.component';

const routes: Routes = [
  { path: '', component: InicioComponent },
  {
    path: 'mainView', component: MainviewComponent,
    children: [
      {
        path: 'manejoregiones', component: RegionComponent,
        children: [
          { path: 'nuevaregion', component: AgregarRegionesComponent },
          { path: 'buscarregion', component: ListarRegionesComponent },
          { path: '**', pathMatch: 'full', redirectTo: 'manejoregiones' }
        ]
      },
      {
        path: 'manejopaises', component: PaisComponent,
        children: [
          { path: 'nuevopais', component: AgregarPaisesComponent },

          {
            path: 'buscarpais', component: ListarPaisesComponent, children: [
              { path: 'nuevopais/:pais', component: AgregarPaisesComponent }
            ]
          },
          { path: '**', pathMatch: 'full', redirectTo: 'manejopaises' }

        ]
      },
      {
        path: 'manejodepartamentos', component: DepartamentoComponent,
        children: [
          { path: 'nuevodepartamento', component: AgregarDepartamentosComponent },
          { path: 'buscardepartamento', component: ListarDepartamentosComponent },
          { path: '**', pathMatch: 'full', redirectTo: 'manejodepartamentos' }

        ]
      },
      {
        path: 'manejoplatos', component: PlatoComponent,
        children: [
          {path: 'buscarplato', component: ListarplatosComponent},
          {path: 'nuevoplato', component: AgregarplatosComponent},
          { path: '**', pathMatch: 'full', redirectTo: 'manejoplatos' }
        ]
      },

      
    ]
  },
  { path: 'salir', component: InicioComponent },
  { path: '**', pathMatch: 'full', redirectTo: 'mainView' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule {
}
