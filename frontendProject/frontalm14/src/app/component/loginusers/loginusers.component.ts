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
      console.log(this.userData); o
      this.userDataService.login(this.userData).subscribe(
        (u: any) => {
          console.log(u);
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
        alert("this is a beta angular change " + userData.userName);
        this.router.navigate(['/userdata']);
      }
    } else {
      alert("Invalid credentials");
    }
  }
}
