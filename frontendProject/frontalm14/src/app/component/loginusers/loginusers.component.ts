import { Router } from '@angular/router';
import { Component } from '@angular/core';
import { UserDataService } from '../../service/userdata.service';

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
      console.log(this.userData);
      this.userDataService.login(this.userData).subscribe(
        (u: any) => {
          console.log(u);
          this.darBienvenida(u);
        },
        (error:Error) => {
          console.error(error.message);
        }
      );
    }
  }

  darBienvenida(userData: any) {
    if (userData) {
      let t = JSON.stringify(userData);
      localStorage.setItem("userData", t);
      this.userData = {};

      if (userData.role === 'sys') {
        console.log("Usuario: "  + this.userData.userName);
        console.log("Esquema: "  + this.userData.userSchema);
        this.router.navigate(['/userdata']);
      }
    } else {
      alert("Invalid credentials");
    }
  }
}
