import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component'
import { FormsModule } from '@angular/forms';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { UserdataComponent } from './component/userdata/userdata.component';
import { LoginusersComponent } from './component/loginusers/loginusers.component';



@NgModule({
  declarations: [
    AppComponent,
    UserdataComponent,
    LoginusersComponent

   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
