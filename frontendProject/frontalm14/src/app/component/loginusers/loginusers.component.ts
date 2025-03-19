import { Router } from '@angular/router';
import { UserDataService } from '../../service/userdata.service';
import { Component } from '@angular/core';

@Component({
  selector: 'app-loginusers',
  templateUrl: './loginusers.component.html',
  styleUrls: ['./loginusers.component.css']
})
export class LoginusersComponent {

  userData: any = {};

  constructor(private userDataService: UserDataService, private router: Router) {}

  login() {
    let validarFormulario: any = document.getElementById("loginForm");
    if (validarFormulario.reportValidity()) {
      console.log(this.userData); // Verifica los datos que se están enviando
      this.userDataService.login(this.userData).subscribe(
        (u: any) => {
          console.log(u); // Verifica la respuesta del backend
          this.darBienvenida(u);
        },
        (error) => {
          console.error("Error en la solicitud", error);
        }
      );
    }
  }

  darBienvenida(userData: any) {
    if (userData) {
      let t = JSON.stringify(userData);
      localStorage.setItem("userData", t);
      this.userData = {};

      if (userData.role === 'user') {
        alert("Welcome " + userData.userName);  // Mostrar el mensaje de bienvenida antes de navegar
        this.router.navigate(['/userdata']);    // Redirigir después del mensaje
      }
    } else {
      alert("Invalid credentials");
    }
  }
}
