import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { UserdataComponent } from './component/userdata/userdata.component';
import { LoginusersComponent } from './component/loginusers/loginusers.component'; // Asegúrate de importar LoginusersComponent

const routes: Routes = [
  {
    path: "loginusers", component: LoginusersComponent  // Ruta para el login
  },
  {
    path: "userdata", component: UserdataComponent  // Ruta para el componente de datos del usuario
  },
  {
    path: "", redirectTo: "loginusers", pathMatch: "full" // Redirige la raíz a loginusers
  },
  {
    path: "**", redirectTo: "loginusers", pathMatch: "full" // Ruta wildcard para cualquier URL no reconocida
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
