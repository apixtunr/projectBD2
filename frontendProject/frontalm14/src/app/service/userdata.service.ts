import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { UserData } from '../entity/userdata';

@Injectable({
  providedIn: 'root'
})
export class UserDataService {

  constructor(private http:HttpClient) { }
  Url='http://localhost:9090';

  listUserData(){
    return this.http.get<UserData[]>(this.Url+"/api/list_userData");
  }

  addUserData(userData:UserData)
  {
    return this.http.post<UserData>(this.Url+"/api/create_userData",userData);
  }

  searchUserDataId(id:String)
  {
    return this.http.get<UserData>(this.Url+"/api/list_userData_id/"+id);
  }

  editUserData(id:String,userData:UserData)
  {
    return this.http.put<UserData>(this.Url+"/userData/"+id,userData);
  }
  deleteUserData(userData:UserData)
  {
    return this.http.delete(this.Url+"/userData/"+userData.idUser,{ responseType: 'text' });
  }

  login(userData: UserData){
    let httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };
    return this.http.post<UserData>(this.Url + "/api/userData/login", userData, httpOptions);
  }

}


