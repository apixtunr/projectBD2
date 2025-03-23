import { Component, OnInit } from '@angular/core';
import { UserDataService } from '../../service/userdata.service';
import { Router } from '@angular/router';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-userdata',
  templateUrl: './userdata.component.html',
  styleUrl: './userdata.component.css',
  providers: [DatePipe]
})

export class UserdataComponent implements OnInit {
  userData: any = {};

  constructor(private userDataService: UserDataService, private router: Router, private datePipe: DatePipe) {}

  ngOnInit() {
    this.getUserData();
  }

  getUserData() {
    this.userDataService.listUserData().subscribe(
      (data: any) => {
        console.log("Datos recibidos:", data); // log para imprimir datos en la consola

        if (data && data.length > 0) {
          this.userData = data[0]; // Si el servicio devuelve un array, tomamos el primer usuario
          localStorage.setItem("userData", JSON.stringify(this.userData));

          if (this.userData.userSchema) {
            console.log("Usuario: "  + this.userData.userName);
            console.log("Esquema: "  + this.userData.userSchema);
          } else {
            alert("No se encontró userSchema en la respuesta.");
          }
        } else {
          alert("No se encontraron usuarios en la base de datos.");
        }
      },
      (error) => {
        console.error("Error obteniendo datos del usuario", error);
      }
    );
  }
}
